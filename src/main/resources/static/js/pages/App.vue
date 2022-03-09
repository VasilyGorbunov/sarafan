<template>
    <div>
        <div v-if="!profile">Login <a href="/login">Google</a></div>
        <div v-else>
            <div style="margin-bottom: 2rem;">{{ profile.name }}&nbsp;<a href="/logout">Logout</a></div>
            <MessageList :messages="messages"/>
        </div>

    </div>
</template>

<script>
    import MessageList from "../components/messages/MessageList.vue";
    import {addHandler} from "../util/ws";
    import {getIndex} from "../util/collections";

    export default {
        name: "App.vue",
        components: {MessageList},
        data: () => (
            {
                messages: frontendData.messages,
                profile: frontendData.profile
            }
        ),
        created() {
            addHandler(data => {
                let index = getIndex(this.messages, data.id)
                if(index > -1) {
                   this.messages.splice(index, 1, data)
                } else {
                   this.messages.push(data)
                }
            })
        }
    }
</script>

<style scoped>

</style>
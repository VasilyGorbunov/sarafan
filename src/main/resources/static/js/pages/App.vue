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
    export default {
        name: "App.vue",
        components: {MessageList},
        data: () => (
            {
                messages: frontendData.messages,
                profile: frontendData.profile
            }
        )
    }
</script>

<style scoped>

</style>
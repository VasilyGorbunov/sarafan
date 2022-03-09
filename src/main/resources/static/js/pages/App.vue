<template>
    <v-app>
        <v-toolbar app>
            <v-toolbar-title>Sarafan</v-toolbar-title>
            <v-spacer/>
            <span v-if="profile">{{ profile.name }}</span>
            <v-btn v-if="profile"  icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-toolbar>
        <v-content>
            <v-container v-if="!profile">Авторизуйтесь через <a href="/login">Google</a></v-container>
            <v-container v-if="profile">
                <MessageList :messages="messages"/>
            </v-container>
        </v-content>
    </v-app>
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
                if (index > -1) {
                    this.messages.splice(index, 1, data)
                } else {
                    this.messages.push(data)
                }
            })
        }
    }
</script>

<style>

</style>
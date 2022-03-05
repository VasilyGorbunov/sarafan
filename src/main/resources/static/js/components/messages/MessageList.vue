<template>
    <div style="position: relative; width: 300px;">
        <MessageForm :messages="messages" :messageAttr="message"/>
        <hr/>

        <MessageRow
                v-for="message in messages"
                :message="message"
                :key="message.id"
                :messages="messages"
                :editMessage="editMessage"
                :deleteMessage="deleteMessage"
        />
    </div>
</template>

<script>
    import MessageRow from "./MessageRow.vue";
    import MessageForm from "./MessageForm.vue";
    export default {
        name: "MessageList",
        components: {MessageForm, MessageRow},
        props: ['messages'],
        data() {
            return {
                message: null
            }
        },
        methods: {
            editMessage(message) {
                this.message = message
            },
            deleteMessage(message) {
               this.$resource('/message/{id}').remove({id: message.id}).then(result => {
                   if(result.ok) {
                       this.messages.splice(this.messages.indexOf(message), 1)
                   }
               })
            }
        }
    }
</script>

<style scoped>

</style>
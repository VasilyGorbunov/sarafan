<template>
    <div>
        <i>({{message.id}})</i> {{ message.text }}
        &nbsp;<span style="position: absolute; right: 0;">
        <input type="button" value="Edit" @click="edit">
        <input type="button" value="X" @click="del">
    </span>
    </div>
</template>

<script>
    export default {
        name: "MessageRow",
        props: ['message', 'editMessage', 'deleteMessage', 'messages'],
        methods: {
            edit(message) {
                this.editMessage(this.message)
            },
            del() {
                this.deleteMessage(this.message)
            }
        }
    }
</script>

<style scoped>

</style>
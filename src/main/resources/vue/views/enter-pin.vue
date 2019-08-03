<template id="enter-pin">
    <app-frame>
        <form-field label="Pin code">
            An SMS has been sent to {{ $javalin.state.currentMsisdn }}
            <input v-model="pin" type="text" placeholder="Pin from SMS" autofocus @keydown.enter="verifyMsisdn">
            <field-error>
                <template v-if="error === 'PIN_INVALID'">Invalid pin code</template>
            </field-error>
        </form-field>
        <next-button @click.native="verifypin">Next</next-button>
    </app-frame>
</template>
<script>
    Vue.component("enter-pin", {
        template: "#enter-pin",
        data: () => ({
            pin: "",
            error: null
        }),
        methods: {
            verifypin() {
                axios.post("/verify-pin", this.pin)
                    .then(res => window.location = res.data)
                    .catch(e => this.error = e.response.data.title)
            }
        }
    });
</script>

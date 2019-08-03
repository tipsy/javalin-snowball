<template id="enter-msisdn">
    <app-frame>
        <form-field label="Phone number">
            <input v-model="msisdn" type="text" placeholder="Enter phone number" autofocus @keydown.enter="verifyMsisdn">
            <field-error>
                <template v-if="error === 'MSISDN_TOO_SHORT'">MSISDN too short</template>
                <template v-if="error === 'MSISDN_INVALID'">MSISDN invalid</template>
            </field-error>
        </form-field>
        <next-button @click.native="verifyMsisdn">Next</next-button>
    </app-frame>
</template>
<script>
    Vue.component("enter-msisdn", {
        template: "#enter-msisdn",
        data: () => ({
            msisdn: "",
            error: null
        }),
        methods: {
            verifyMsisdn() {
                axios.post("/verify-msisdn", this.msisdn)
                    .then(res => window.location = res.data)
                    .catch(e => this.error = e.response.data.title)
            }
        }
    });
</script>

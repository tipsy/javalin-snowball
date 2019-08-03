<template id="enter-email">
    <app-frame>
        <form-field label="Email address">
            <input v-model="email" type="text" placeholder="Enter email address" autofocus>
        </form-field>
        <next-button>Next</next-button>
    </app-frame>
</template>
<script>
    Vue.component("enter-email", {
        template: "#enter-email",
        data: () => ({
            email: "",
        }),
    });
</script>

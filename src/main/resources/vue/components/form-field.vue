<template id="form-field">
    <div>
        <label>{{label}}</label>
        <slot></slot>
    </div>
</template>
<script>
    Vue.component("form-field", {
        template: "#form-field",
        props: ["label"]
    });
</script>
<style>
    label + input {
        margin-top: 4px;
    }
    input[type=text] {
        height: 40px;
        width: 100%;
        padding: 0 8px;
        border-radius: 3px;
        border: 1px solid #ddd;
        font-size: 16px;
    }
    input[type="text"]:focus {
        box-shadow: 0 0 3px #0098c9;
    }
</style>

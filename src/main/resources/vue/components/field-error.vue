<template id="field-error">
    <div class="field-error">
        <slot></slot>
    </div>
</template>
<script>
    Vue.component("field-error", {template: "#field-error"});
</script>
<style>
    .field-error {
        height: 20px;
    }
</style>

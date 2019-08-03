<template id="next-button">
    <button class="next-button">
        <slot></slot>
    </button>
</template>
<script>
    Vue.component("next-button", {template: "#next-button"});
</script>
<style>
    .next-button {
        margin-top: 24px;
        background: #0098c9;
        color: white;
        font-size: 16px;
        border: none;
        height: 40px;
        line-height: 40px;
        padding: 0 40px;
        border-radius: 3px;
        width: 100%;
        cursor: pointer;
    }
</style>

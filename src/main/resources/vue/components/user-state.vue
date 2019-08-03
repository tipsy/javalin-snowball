<template id="user-state">
    <div class="user-state">
        currentMsisdn: {{ $javalin.state.currentMsisdn }}<br>
        verifiedMsisdn: {{ $javalin.state.verifiedMsisdn }}
    </div>
</template>
<script>
    Vue.component("user-state", {template: "#user-state"});
</script>
<style>
    .user-state {
        padding: 16px;
        background: #000;
        color: #00FF00;
        position: fixed;
        right: 20px;
        bottom: 20px;
        font-family: monospace;
        line-height: 1.5;
        font-size: 14px;
    }
</style>

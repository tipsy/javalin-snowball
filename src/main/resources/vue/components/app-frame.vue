<template id="app-frame">
    <div class="app-frame">
        <header>
            <span>Snowball</span>
            <span v-if="$javalin.state.currentUser">Current user: '{{$javalin.state.currentUser}}'</span>
        </header>
        <div class="content">
            <slot></slot>
        </div>
        <user-state></user-state>
    </div>
</template>
<script>
    Vue.component("app-frame", {template: "#app-frame"});
</script>
<style>
    * {
        box-sizing: border-box;
        outline: 0;
        font-family: sans-serif;
    }
    html {
        font-family: sans-serif;
    }
    body {
        margin: 0;
        align-items: center;
        background: linear-gradient(#fafafa, #f5f5f5);
    }
    .app-frame {
        background: #fff;
        max-width: 360px;
        margin: 100px auto 0;
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        border-radius: 3px;
    }
    .app-frame > header {
        padding: 20px;
        font-size: 20px;
        text-align: center;
        border-bottom: 1px solid #eee;
    }
    .app-frame > .content {
        padding: 32px 24px 24px;
    }
</style>

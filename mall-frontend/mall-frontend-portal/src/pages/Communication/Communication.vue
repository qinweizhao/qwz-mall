<template>
  <div>
    <div  style="margin-left: 60px">
      <h2>组件间通信高级</h2>
      <router-link to="/communication/event">Event事件深入    </router-link>
      <router-link to="/communication/model">v-model深入    </router-link>
      <router-link to="/communication/sync">属性修饰符Sync    </router-link>
      <router-link to="/communication/attrslistenerstest">$attrs与$listeners    </router-link>
    </div>
    <router-view style="margin: 60px"/>
  </div>

</template>

<script>
export default {
  name: "Communication"
}
</script>

<style scoped>

</style>
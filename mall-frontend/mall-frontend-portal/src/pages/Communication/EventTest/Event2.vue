<template>
  <div style="width: 100%;height: 60px;background-color: #7a6e6e">
    <h3>Event2组件</h3>
    <button @click="$emit('click','自定义click事件')">分发自定义click事件</button>
    <br>
    <button @click="$emit('xxx','自定义xxx事件')">分发自定义xxx事件</button>
    <p>其他内容</p>
  </div>
</template>

<script>
export default {
name: "Event2"
}
</script>

<style scoped>

</style>
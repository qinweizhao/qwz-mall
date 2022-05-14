<template>
  <div style="height: 60px;background-color: #7a6e6e">
    <p style="display: inline">小米每次花100元</p>
    <button @click="$emit('update:money',money-100)">花钱</button>
    爸爸还剩{{money}}元
  </div>
</template>

<script>
export default {
  name: "Child2",
  props:['money']
}
</script>

<style scoped>

</style>

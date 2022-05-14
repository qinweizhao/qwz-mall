<template>
  <div style="background-color: #5c5251">
    <h2>input包装组件</h2>
    <!--:value 动态属性-->
    <!--@input 原生事件-->
    <input type="text" :value="value" @input="$emit('input',$event.target.value)">
  </div>
</template>

<script>
export default {
  name: "CustomInput",
  props:['value'],
}
</script>

<style scoped>

</style>
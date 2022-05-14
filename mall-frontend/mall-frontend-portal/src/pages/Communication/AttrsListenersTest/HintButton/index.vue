<template>
  <div>
    <a :title="$attrs.title">
      <!--v-bind不能用:(冒号) v-on也不能用@代替-->
      <el-button v-bind="$attrs" v-on="$listeners">打你的喔</el-button>
    </a>
  </div>
</template>

<script>
export default {
  name: "index",
  mounted() {
    //$attrs是组件的一个属性 可以收到父组件传来的props
    //若子组件通过props接受了某个参数,则attrs就不会再接收
    console.log(this.$attrs)
    //this.$listeners也是组件实例一个属性 可以接收父组件传来的自定义事件
    console.log(this.$listeners)
  }
}
</script>

<style scoped>

</style>
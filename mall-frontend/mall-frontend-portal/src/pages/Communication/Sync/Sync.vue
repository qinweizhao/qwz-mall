<template>
<div>
  <p>小明的爸爸有{{ money }}元</p>
  <h2>不使用Sync修饰符</h2>
  <!--:money是父组件给子组件传递的props
      @update:money是自定义事件
      与v-model很像 实现了父子组件数据同步-->
  <Child1 :money="money" @update:money="money = $event"></Child1>
  <h2>使用Sync修饰符</h2>
  <!--:money.sync :父组件给子组件传递props:money
      给当前子组件绑定一个自定义事件: update:money-->
  <Child1 :money.sync="money"></Child1>

</div>
</template>

<script>
import Child1 from "@/pages/Communication/Sync/Child1"
import Child2 from "@/pages/Communication/Sync/Child2"
export default {
  name: "Sync",
  components:{Child1,Child2},
  data(){
    return{
      money:10000,
    }
  }
}
</script>

<style scoped>

</style>
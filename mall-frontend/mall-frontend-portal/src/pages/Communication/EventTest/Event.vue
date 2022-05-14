<template>
  <div>
    <h1>Event组件</h1>
  <!-- 原生DOM绑定系统事件 -->
    <button @click="handler">原生DOM绑定系统事件</button>
  <!-- Event1非原生DOM节点 而绑定的click事件非原生DOM事件，是自定义事件 -->
  <!-- @click.native可以把自定义事件变成原生DOM事件 -->
  <!-- 当前原生DOM的click事件其实是给子组件的根节点绑定了点击事件 利用了事件的委派 -->
    <Event1 @click.native="handler1"/>
  <!-- 原生DOM绑定自定义事件 但是无意义 因为没办法触发$emit -->
    <button @xxx="handler2">原生DOM绑定自定义事件</button>
    <!--组件标签 click是自定义事件-->
    <Event2 @click="handler3" @xxx="handler3"/>
  </div>
</template>

<script>
import Event1 from '@/pages/Communication/EventTest/Event1'
import Event2 from '@/pages/Communication/EventTest/Event2'
export default {
  name: "Event",
  components:{Event1,Event2},
  methods:{
    handler(event){
      console.log('原生DOM绑定系统事件',event)
    },
    handler1(event){
      console.log('click事件的回调',event)
    },
    handler2(event){
      console.log('原生DOM绑定自定义事件',event)
    },
    handler3(params){
      console.log('Event2的自定义事件:',params)
    }
  }
}
</script>

<style scoped>

</style>
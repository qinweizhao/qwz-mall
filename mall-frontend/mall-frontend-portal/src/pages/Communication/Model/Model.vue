<template>
  <div>
    <h3>深入v-model</h3>
    <input type="text" v-model="msg">
    <span>{{msg}}</span>
    <hr>
    <!-- 实现原理 -->
    <input type="text" :value="msg" @input="msg = $event.target.value">
    <span>{{msg}}</span>
    <hr>
    <!-- 深入学习:实现父子组件数据同步 -->
    <!--给子组件传递value  @input是自定义事件 $event是子组件传过来的参数-->
    <CustomInput :value="msg" @input="msg = $event"></CustomInput>
    <CustomInput v-model="msg"></CustomInput>
  </div>
</template>

<script>
import CustomInput from "@/pages/Communication/Model/CustomInput/CustomInput"
export default {
  name: "Model",
  components:{CustomInput},
  data() {
    return{
      msg:'菜鸡',
    }
  }
}
</script>

<style scoped>

</style>
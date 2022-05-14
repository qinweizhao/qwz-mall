<template>
  <div>
    <h2>自定义带hover提示的按钮</h2>
    <!--当用户使用封装的按钮的时候,需要向HintButton传递响应的参数 el-button二次封装-->
    <HintButton type="success" icon="el-icon-plus" size="mini" title="哈哈哈" @click="handler"/>
  </div>
</template>

<script>
import HintButton from './HintButton/index'
export default {
  name: "AttrsListenersTest",
  components:{HintButton},
  methods:{
    handler(){
      alert('666')
    }
  }
}
</script>

<style scoped>

</style>
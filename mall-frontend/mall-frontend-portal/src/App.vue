<template>
  <div id="app">
    <Header/>
    <router-view></router-view>
    <Footer v-show="$route.meta.show"/>
  </div>
</template>

<script>
import Header from './components/Header/index'
import Footer from './components/Footer/index'
export default {
  name: 'App',
  components: {Header, Footer,},
  mounted(){
    //通知vuex发请求,获取数据,存到仓库中 只发生一次请求
    this.$store.dispatch('home/categoryList')
  },

}
</script>

<style>

</style>

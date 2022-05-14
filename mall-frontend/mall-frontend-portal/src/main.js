import Vue from 'vue'
import App from './App.vue'
import router from '@/router'
import store from '@/store'
//引入MockServe模拟的数据
import '@/mock/mockServe'
//引入swiper样式
import 'swiper/css/swiper.css'
//引入elementUI 部分引入
import { Button, MessageBox } from 'element-ui'
Vue.component(Button.name, Button);
Vue.prototype.$msgbox = MessageBox
Vue.prototype.$alert = MessageBox.alert
//引入插件和图片
import VueLazyload from "vue-lazyload"
import lyy from '@/assets/lazyLoad.gif'
Vue.use(VueLazyload,{
  //懒加载默认图片
  loading:lyy,
})
//引入表单验证插件
import "@/plugins/validate"

Vue.config.productionTip = false
//**********************************************
//三级联动注册为全局组件
import TypeNav from '@/components/TypeNav'
Vue.component(TypeNav.name,TypeNav)
//轮播图注册为全局组件
import Carousel from '@/components/Carousel'
Vue.component(Carousel.name,Carousel)
//分页器注册为全局组件
import Pagination from '@/components/Pagination'
Vue.component(Pagination.name,Pagination)
//**********************************************
//统一引入接口api  不写vuex
import * as API from '@/api'

new Vue({
  render: h => h(App),
  router,
  store,
  //全局事件总线
  beforeCreate() {
    Vue.prototype.$bus = this
    Vue.prototype.$API = API
  }
}).$mount('#app')

import Vue from 'vue'
import VueRouter from 'vue-router'
import routes from '@/router/routes'
import store from '@/store'

Vue.use(VueRouter)

let originPush = VueRouter.prototype.push
let originReplace = VueRouter.prototype.replace

//重写push()
VueRouter.prototype.push = function (location) {
  return originPush.call(this, location).catch(err => err)
}
VueRouter.prototype.replace = function (location) {
  return originReplace.call(this, location).catch(err => err)
}

let router = new VueRouter({
  routes,
  //滚动行为
  scrollBehavior(to, from, savedPosition) {
    //返回的y代表滚动条的垂直位置 x是水平方向
    return {y: 0}
  }
})

//全局前置路由守卫
router.beforeEach(async (to,form,next)=>{
  //form:从哪里来 to:到哪里去
  //next是否放行   next(path):放行到指定路由
  let token = store.state.user.token
  let name = store.state.user.userInfo.name
  //判断是否登录
  if (token){//已经登录
    if (to.path === '/login'){
      //不能去到登录页面,回到首页
      next('/home')
    }else {
      //不是去到登录页,直接放行
      if (name){
        next()
      }else {
        //没有用户信息,获取用户信息
        try {
          await store.dispatch('user/getUserInfo')
          next()
        }catch (e) {
          //token过期 请求失败 清除过期的token 重新登录
          await store.dispatch('user/userLogout')
          next('/login')
        }
      }
    }
  }else {
    //未登录 不能去交易相关(pay,paysuccess,center)
    if (to.path.indexOf('/trade')!==-1 || to.path.indexOf('/pay')!==-1 || to.path.indexOf('/center')!==-1 || to.path.indexOf('/shopcart')!==-1){
      next('/login?redirect='+to.path)
    }else{
      next()
    }
  }

})

export default router

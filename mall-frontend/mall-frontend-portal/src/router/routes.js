import Home from "@/pages/Home"
import Search from "@/pages/Search"
import Login from "@/pages/Login"
import Register from "@/pages/Register"
import Detail from "@/pages/Detail"
import AddCartSuccess from "@/pages/AddCartSuccess"
import ShopCart from "@/pages/ShopCart"
import Trade from "@/pages/Trade"
import Pay from "@/pages/Pay"
import PaySuccess from "@/pages/PaySuccess"
import Center from "@/pages/Center"
import MyOrder from "@/pages/Center/myOrder"
import GroupOrder from "@/pages/Center/groupOrder"
/*
* 路由懒加载:当路由被访问的时候才加载对应的组件,效率更高了
* const foo = ()=>{
    return import('@/pages/Home')
  }
* */
export default [
  {
    path:'/communication',
    component:()=>import('@/pages/Communication/Communication'),
    children: [
      {
        path:'event',
        component: ()=>import('@/pages/Communication/EventTest/Event'),
        meta:{
          show:false
        },
      },
      {
        path:'model',
        component: ()=>import('@/pages/Communication/Model/Model'),
        meta:{
          show:false
        },
      },
      {
        path:'sync',
        component: ()=>import('@/pages/Communication/Sync/Sync'),
        meta:{
          show:false
        },
      },
      {
        path:'attrslistenerstest',
        component: ()=>import('@/pages/Communication/AttrsListenersTest/AttrsListenersTest'),
        meta:{
          show:false
        },
      },
    ]
  },
  {
    path:'/home',
    //路由懒加载
    component:()=>import('@/pages/Home'),
    meta:{show:true},
  },
  {
    name:'search',
    //params参数:keyword ?代表可传可不传
    path:'/search/:keyword?',
    component:Search,
    meta:{show:true},
  },
  {
    path:'/detail/:skuid',
    component:Detail,
    meta:{show:true},
  },
  {
    name:'addcartsuccess',
    path:'/addcartsuccess',
    component:AddCartSuccess,
    meta:{show:true},
  },
  {
    name:'shopcart',
    path:'/shopcart',
    component:ShopCart,
    meta:{show:true},
  },
  {
    name:'trade',
    path:'/trade',
    component:Trade,
    meta:{show:true},
    //路由独享守卫
    beforeEnter(to,form,next){
      if (form.path === '/shopcart' || to.path === '/trade'){
        next()
      }else{
        //停留在当前页
        next(false)
      }
    }
  },
  {
    name:'pay',
    path:'/pay',
    component:Pay,
    meta:{show:true},
    //路由独享守卫
    beforeEnter(to,form,next){
      if (form.path === '/trade' || to.path === '/pay'){
        next()
      }else{
        //停留在当前页
        next(false)
      }
    }
  },
  {
    name:'Center',
    path:'/center',
    component:Center,
    meta:{show:true},
    children:[
      {
        path:"myOrder",
        component:MyOrder
      },
      {
        path:'groupOrder',
        component:GroupOrder
      },
      {
        path:'/center',
        redirect:'/center/myOrder'
      }
    ]
  },
  {
    path:'/paysuccess',
    component:PaySuccess,
    meta:{show:true},
    //路由独享守卫 这里写在组件内守卫
    //beforeEnter(to,form,next){
    //  if (form.path === '/pay' || to.path === '/paysuccess'){
    //    next()
    //  }else{
    //    //停留在当前页
    //    next(false)
    //  }
    //}
  },
  {
    path:'/login',
    component:Login,
  },
  {
    path:'/register',
    component:Register,
  },
  //重定向
  {
    path:'/*',
    redirect:'/home',
  }
]
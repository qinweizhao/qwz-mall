// 对API统一管理
import request from './request'
import mockRequest from './mockAjax'

//三级联动接口
///api/product/getBaseCategoryList get null(无参数)
export const reqCategoryList = ()=>{
  //发请求
  return request({
    url:'/product/getBaseCategoryList',
    method:'get',
  })
}
//获取banner轮播图
export const reqGetBannerList = ()=> mockRequest.get('/banner')
//获取floor轮播图
export const reqGetFloorList = ()=> mockRequest.get('/floor')
//获取搜索模块  ///api/list post (带参数)
export const reqGetSearchInfo = (params)=>{
  return request({
    url:'/list',
    method:'post',
    data:params,
  })
}
//获取产品详情
export const reqGoodsInfo = (skuid)=>request({
  url:`/item/${skuid}`,
  method:'get'
})
//加入购物车
export const reqAddOrUpdateShopCart = ((skuId,skuNum)=>{
  return request({
    url:`/cart/addToCart/${skuId}/${skuNum}`,
    method:'post'
  })
})
//获取购物车列表
export const reqCartList = ()=>{
  return request({
    url:'/cart/cartList',
    method:'get'
  })
}
//删除购物车商品
export const reqDeleteCartById = (skuId)=>{
  return request({
    url:'/cart/deleteCart/'+skuId,
    method:'delete'
  })
}
//修改购物车商品选择状态
export const reqUpdateCheckedById = (skuId,isChecked)=>{
  return request({
    url:'cart/checkCart/'+skuId+'/'+isChecked,
    method:'get'
  })
}
//获取服务器验证码(注册)
export const reqGetCode = (phone)=>{
  return request({
    url:`/user/passport/sendCode/${phone}`,
    method:'get'
  })
}
//注册
export const reqUserRegister = (data)=>{
  return request({
    url:`/user/passport/register/`,
    data:data,
    method:'post'
  })
}
//登录
export const reqUserLogin = (data)=>{
  return request({
    url:'/user/passport/login',
    data:data,//参数参考接口文档 phone:xxx  password:xxx
    method:'post'
  })
}
//获取用户信息
export const reqGetUserInfo = ()=>{
  return request({
    url:'/user/passport/auth/getUserInfo',
    method:'get'
  })
}
//退出登录
export const reqLoginOut = ()=>{
  return request({
    url:'user/passport/logout',
    method:'get'
  })
}
//获取收获地址
export const reqAddressInfo = ()=>{
  return request({
    url:'user/userAddress/auth/findUserAddressList',
    method:'get'
  })
}
//获取商品清单
export const reqOrderInfo = ()=>{
  return request({
    url:'order/auth/trade',
    method:'get'
  })
}
//提交订单  这里开始 不写ＶＵＥＸ了
export const reqSubmitOrder = (tradeNo,data)=>{
  return request({
    url:'order/auth/submitOrder?tradeNo='+tradeNo,
    data,
    method:'post'
  })
}
//获取支付信息
export const reqPayInfo = (orderId)=>{
  return request({
    url:'payment/weixin/createNative/'+orderId,
    method:'get'
  })
}
//获取订单支付状态
export const reqPayStatus = (orderId)=>{
  return request({
    url:`payment/weixin/queryPayStatus/${orderId}`,
    method:'get'
  })
}
//获取订单列表
export const reqMyOrderList = (page,limit)=>{
  return request({
    url:`order/auth/${page}/${limit}`,
    method:'get'
  })
}

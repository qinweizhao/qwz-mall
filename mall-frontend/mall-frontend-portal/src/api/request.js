//对axios二次封装
import axios from 'axios'
//引入进度条及样式
import nprogress from 'nprogress'
import "nprogress/nprogress.css"
//引入仓库
import store from '@/store'

const request = axios.create({
  baseURL:'http://gmall-h5-api.atguigu.cn/api',
  timeout:5000,
})
//请求拦截器
request.interceptors.request.use((config)=>{
  //进度条开始
  nprogress.start();
  //***************************请求头**************************
  //带上用户临时ID
  if (store.state.detail.uuid_token){
    config.headers.userTempId = store.state.detail.uuid_token
  }
  //带上token传给服务器
  if (localStorage.getItem("token")){
    config.headers.token = localStorage.getItem("token")
  }
  //**************************请求头****************************
  return config
})
//响应拦截器
request.interceptors.response.use((res)=>{
  nprogress.done();
  return res.data
},(error) => {
  return Promise.reject(new Error(error))
})


export default request

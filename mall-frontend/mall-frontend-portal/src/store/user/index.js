import {reqGetCode, reqGetUserInfo, reqLoginOut, reqUserLogin, reqUserRegister} from "@/api"

export default {
  namespaced: true,
  //**************************--actions--**********************
  actions: {
    //获取验证码
    async getCode({commit}, phone) {
      let result = await reqGetCode(phone)
      console.log(result.code)
      if (result.code === 200) {
        commit("GETCODE", result.data)
        return 'ok'
      } else {
        return Promise.reject(new Error('fail'))
      }
    },
    //注册
    async userRegister({commit}, user) {
      let result = await reqUserRegister(user)
      console.log(result)
      if (result.code === 200) {
        return 'ok'
      } else {
        return Promise.reject(new Error(result.message))
      }
    },
    //登录
    async userLogin({commit}, data) {
      let result = await reqUserLogin(data)
      if (result.code === 200) {
        commit("USERLOGIN", result.data.token)
        localStorage.setItem("token",result.data.token)
        return 'ok'
      } else {
        return Promise.reject(new Error(result.message))
      }
    },
    //获取用户信息
    async getUserInfo(context) {
      let result = await reqGetUserInfo()
      if (result.code === 200) {
        context.commit("GETUSERINFO", result.data)
        return 'ok'
      }else {
        return Promise.reject(new Error(result.message))
      }
    },
    //退出登录
    async userLogout({commit}){
      let result = await reqLoginOut()
      if (result.code === 200){
        commit("CLEAR")
        return 'ok'
      }else {
        return Promise.reject(new Error(result.message))
      }
    }
  },
  //*************************--mutations--*********************
  mutations: {
    //验证码
    GETCODE(state, code) {
      state.code = code
    },
    //登录
    USERLOGIN(state, token) {
      state.token = token
    },
    //获取用户信息
    GETUSERINFO(state, userInfo) {
      state.userInfo = userInfo
    },
    //清除本地数据
    CLEAR(state){
      state.token = ''
      state.userInfo = ''
      localStorage.removeItem("token")
    }
  },
  //**************************--state--**************************
  state: {
    //验证码
    code: '',
    //令牌
    token:localStorage.getItem("token"),
    //用户信息
    userInfo: '',
  },
  //***************************--getters--***********************
  getters: {},
}
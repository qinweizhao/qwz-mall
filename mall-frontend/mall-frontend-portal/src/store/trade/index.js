import {reqAddressInfo, reqOrderInfo} from "@/api"

export default {
  namespaced: true,
  //**************************--actions--**********************
  actions: {
    //获取用户地址
    async getUserAddress({commit}){
      let result = await reqAddressInfo()
      if (result.code === 200){
        commit("GETUSERADDRESS",result.data)
      }else {
        return Promise.reject(new Error(result.message))
      }
    },
    //获取商品清单
    async getOrderInfo({commit}){
      let result = await reqOrderInfo()
      if (result.code === 200){
        commit('GETORDERINFO',result.data)
      }
    }
  },
  //*************************--mutations--*********************
  mutations: {
    GETUSERADDRESS(state,address){
      state.addressInfo = address
    },
    GETORDERINFO(state,orderInfo){
      state.orderInfo = orderInfo
    }
  },
  //**************************--state--**************************
  state: {
    addressInfo:[],
    orderInfo:[],
  },
  //***************************--getters--***********************
  getters: {},
}
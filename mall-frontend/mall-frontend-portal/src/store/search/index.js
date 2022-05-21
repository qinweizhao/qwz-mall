import { reqGetSearchInfo } from "@/api"
export default {
  namespaced:true,
  actions:{
    //搜索
    async getSearchList({commit},params={}){
      let result = await reqGetSearchInfo(params)
      if (result.code === "200"){
        commit('GETSEARCHLIST',result.data)
      }
    }
  },
  mutations:{
    //搜索
    GETSEARCHLIST(state,searchList){
      state.searchList = searchList
    }
  },
  state:{
    searchList: {
      products:[],
      attrs:[],
      brands:[]
    },
  },
  getters:{
    //搜索******************************
    //商品列表
    goodsList(state) {
      return state.searchList.products;
    },
    //商品属性
    attrsList(state) {
      return state.searchList.attrs;
    },
    //品牌
    trademarkList(state) {
      return state.searchList.brands;
    },
    //总数据条数
    total(state){
      // return state.searchList.total
      return 10
    }
    //**********************************
  },
}

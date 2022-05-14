import {reqAddOrUpdateShopCart, reqGoodsInfo} from "@/api"
import {getUUID} from "@/utils/uuid_token"
export default {
  namespaced:true,
  actions:{
    //获取产品信息
   async getGoodInfo({commit}, skuId) {
      let result = await reqGoodsInfo(skuId)
     if (result.code==200){
       commit('GETGOODINFO',result.data)
     }
    },
    //添加购物车 不返回数据
    async addOrUpdateShopCart({commit}, {skuId, skuNum}){
      let result = await reqAddOrUpdateShopCart(skuId,skuNum)
      if (result.code == 200){
        return 'ok'
      }else {
        return Promise.reject(new Error('fail'))
      }
    }
  },
  mutations:{
    //获取产品信息
    GETGOODINFO(state,goodInfo){
      state.goodInfo = goodInfo
    },
  },
  state:{
    goodInfo: {},
    //生成唯一随机字符串
    uuid_token: getUUID()
  },
  getters:{
    //路径导航
    categoryView(state) {
      //初始时会返回undefined 会报错 应该没数据时返回空对象
      return state.goodInfo.categoryView||{};
    },
    //产品数据
    skuInfo(state) {
      return state.goodInfo.skuInfo||{};
    },
    //售卖属性
    spuSaleAttrList(state) {
      return state.goodInfo.spuSaleAttrList||[];
    },
    price(state) {
      return state.goodInfo.price||0;
    },
    valuesSkuJson(state) {
      return state.goodInfo.valuesSkuJson||[];
    },
  },
}
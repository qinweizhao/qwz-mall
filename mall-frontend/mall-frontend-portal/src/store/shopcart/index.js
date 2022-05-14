import {reqCartList, reqDeleteCartById, reqUpdateCheckedById} from "@/api"

export default {
  namespaced: true,
  actions: {
    //获取购物车数据
    async getCartList({commit}) {
      let result = await reqCartList()
      if (result.code === 200) {
        commit('GETCARTLIST', result.data)
      }
    },
    //删除购物车商品
    async deleteCartById({commit}, skuId) {
      let result = await reqDeleteCartById(skuId)
      if (result.code === 200) {
        return 'ok'
      } else {
        return Promise.reject(new Error('fail'))
      }
    },
    //删除选中的商品
    deleteAllCheckedCart({dispatch, getters}) {
      //context :小仓库 有commit getters dispatch state
      let promiseAll = []
      getters.cartList.forEach(item => {
        let promise = ''
        if (item.isChecked)
          promise = dispatch('deleteCartById', item.skuId)
        else
          promise = ''
        promiseAll.push(promise)
      })
      //有个失败 返回失败 否则 返回成功
      return Promise.all(promiseAll)
    },
    //更新购物车商品选中状态
    async updateCheckedById({commit}, {skuId, isChecked}) {
      let result = await reqUpdateCheckedById(skuId, isChecked)
      if (result.code === 200) {
        return 'ok'
      } else {
        return Promise.reject(new Error('fail'))
      }
    },
    //全选功能
    async updateAllCartChecked({dispatch, state},isChecked){
      let promiseAll = []
      let promise = ''
      state.cartList[0].cartInfoList.forEach(item=>{
        promise = dispatch('updateCheckedById',{skuId:item.skuId,isChecked})
      })
      promiseAll.push(promise)
      return Promise.all(promiseAll)

    }
  },
  mutations: {
    GETCARTLIST(state, cartList) {
      state.cartList = cartList
    }
  },
  state: {
    cartList: [],
  },
  getters: {
    cartList(state) {
      if (state.cartList[0]) {
        return state.cartList[0].cartInfoList
      } else
        return []
    }
  },
}
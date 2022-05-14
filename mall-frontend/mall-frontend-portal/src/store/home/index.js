import {reqCategoryList,reqGetBannerList,reqGetFloorList} from '@/api'
export default {
  namespaced:true,
  actions :{
    //三级联动
    async categoryList({commit}){
      let result = await reqCategoryList();
      if (result.code === 200){
        commit('CATEGORYLIST',result.data)
      }
    },
    //banner
    getBannerList(content){
      reqGetBannerList().then(res=>{
        if (res.code === 200){
          content.commit('BANNERLIST',res.data)
        }
      }).catch(err=>{
        return Promise.reject(new Error(err))
      })
    },
    //floor
    async GetFloorList({commit}){
      let result = await reqGetFloorList();
      if (result.code === 200){
        commit('FLOORLIST',result.data)
      }
    },
  },
  mutations :{
    //三级联动
    CATEGORYLIST(state,categoryList){
      state.categoryList = categoryList
    },
    //banner
    BANNERLIST(state,bannerList){
      state.bannerList = bannerList
    },
    //floor
    FLOORLIST(state,floorList){
      state.floorList = floorList
    },
  },
  state :{
    categoryList:[],
    bannerList:[],
    floorList:[],
  },
  getters :{

  },
}

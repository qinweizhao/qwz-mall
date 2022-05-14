<template xmlns="">
  <div class="type-nav">
    <div class="container">
      <!--事件的委派   -->
      <div  @mouseleave="leaveIndex" @mouseenter="enterShow">
        <h2 class="all">全部商品分类</h2>
        <transition name="sort">
          <div class="sort" v-show="show">
            <!--   事件的委派 把子节点的事件委派给父节点   -->
            <div class="all-sort-list2" @click="goSearch">
              <div class="item"  v-for="(c1,index) in categoryList" :class="{cur:currentIndex===index}" :key="c1.categoryId">
                <h3 @mouseenter="changeIndex(index)">
                  <a :data-categoryName="c1.categoryName" :data-category1Id="c1.categoryId">{{c1.categoryName}}</a>
                </h3>
                <!--              二三级分类-->
                <div class="item-list clearfix" :style="{display:currentIndex===index?'block':'none'}">
                  <div class="subitem" v-for="(c2,index) in c1.categoryChild" :key="c2.categoryId">
                    <dl class="fore" >
                      <dt>
                        <a :data-categoryName="c2.categoryName" :data-category2Id="c2.categoryId">{{c2.categoryName}}</a>
                      </dt>
                      <dd>
                        <em v-for="(c3,index) in c2.categoryChild" :key="c3.categoryId">
                          <a :data-categoryName="c3.categoryName" :data-category3Id="c3.categoryId">{{c3.categoryName}}</a>
                        </em>
                      </dd>
                    </dl>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </transition>
      </div>
      <nav class="nav">
        <a href="###">服装城</a>
        <a href="###">美妆馆</a>
        <a href="###">尚品汇超市</a>
        <a href="###">全球购</a>
        <a href="###">闪购</a>
        <a href="###">团购</a>
        <a href="###">有趣</a>
        <a href="###">秒杀</a>
      </nav>
    </div>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import throttle from 'lodash/throttle'

  export default {
    name: "TypeNav",
    data(){
      return{
        currentIndex:-1,
        show:true,
      }
    },
    //组件加载完毕
    mounted() {
      if (this.$route.path !== '/home'){
        this.show = false
      }
    },
    computed:{
      // ...mapState({
      //   categoryList:(state)=>{
      //     return state.home.categoryList
      //   }
      // })
      ...mapState('home',['categoryList'])
    },
    methods:{
      //鼠标进入修改currentIndex
      // changeIndex(index){
      // //index分类的索引值
      //   this.currentIndex = index
      // },
      //节流写法
      changeIndex:throttle(function (index) {
        this.currentIndex = index
      },50),

      leaveIndex(){
        this.currentIndex = -1
        if (this.$route.path !== '/home'){
          this.show = false
        }
      },
      //编程式导航和事件委派---路由跳转home->search
      goSearch(){
        //在众多子节点中选择a标签 通过自定义属性
        let dataset = event.target.dataset
        let {categoryname,category1id,category2id,category3id} = dataset
        //如果是a标签
        if (categoryname) {
          let location = {name:'search'}
          let query = {categoryName:categoryname}

          if (category1id) {                //一级目录
            query.category1id = category1id
          }else if (category2id) {          //二级目录
            query.category2id = category2id
          }else {                           //三级目录
            query.category3id = category3id
          }

          if (this.$route.params){
            location.params = this.$route.params
          }
          location.query = query
          this.$router.push(location)
        }
      },
      enterShow(){
        this.show = true
      },
    },

  }
</script>

<style lang="less" scoped>
  .type-nav {
    border-bottom: 2px solid #e1251b;

    .container {
      width: 1200px;
      margin: 0 auto;
      display: flex;
      position: relative;

      .all {
        width: 210px;
        height: 45px;
        background-color: #e1251b;
        line-height: 45px;
        text-align: center;
        color: #fff;
        font-size: 14px;
        font-weight: bold;
      }

      .nav {
        a {
          height: 45px;
          margin: 0 22px;
          line-height: 45px;
          font-size: 16px;
          color: #333;
        }
      }

      .sort {
        position: absolute;
        left: 0;
        top: 45px;
        width: 210px;
        height: 461px;
        position: absolute;
        background: #fafafa;
        z-index: 999;
        .all-sort-list2 {
          .item {
            h3 {
              line-height: 30px;
              font-size: 14px;
              font-weight: 400;
              overflow: hidden;
              padding: 0 20px;
              margin: 0;

              a {
                color: #333;
                cursor: pointer;
              }
            }

            .item-list {
              display: none;
              position: absolute;
              width: 734px;
              min-height: 460px;
              background: #f7f7f7;
              left: 210px;
              border: 1px solid #ddd;
              top: 0;
              z-index: 9999 !important;

              .subitem {
                float: left;
                width: 650px;
                padding: 0 4px 0 8px;

                dl {
                  border-top: 1px solid #eee;
                  padding: 6px 0;
                  overflow: hidden;
                  zoom: 1;

                  &.fore {
                    border-top: 0;
                  }

                  dt {
                    float: left;
                    width: 54px;
                    line-height: 22px;
                    text-align: right;
                    padding: 3px 6px 0 0;
                    font-weight: 700;

                    a{
                      cursor: pointer;
                    }

                    a:hover{
                      color: #409eff;
                    }
                  }

                  dd {
                    float: left;
                    width: 415px;
                    padding: 3px 0 0;
                    overflow: hidden;

                    em {
                      float: left;
                      height: 14px;
                      line-height: 14px;
                      padding: 0 8px;
                      margin-top: 5px;
                      border-left: 1px solid #ccc;
                      cursor: pointer;
                    }

                    em:hover{
                      background-color: #a4e2ef;
                    }
                  }
                }
              }
            }

            /*&:hover {*/
            /*  .item-list {*/
            /*    display: block;*/
            /*  }*/
            /*}*/
          }
          .cur{
            background-color: orange;
          }
        }
      }
      .sort-enter{
        height: 0px;
        opacity: 0;
      }
      .sort-enter-to{
        height: 461px;
        opacity: 1;
      }
      .sort-enter-active{
        transition: all .5s linear;
      }
    }

  }
</style>

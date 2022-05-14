<template>
  <div>
    <TypeNav/>
    <div class="main">
      <div class="py-container">
        <!--bread-->
        <div class="bread">
          <ul class="fl sui-breadcrumb">
            <li>
              <a href="#">全部结果</a>
            </li>
          </ul>
          <ul class="fl sui-tag">
            <!--分类面包屑-->
            <li class="with-x" v-show="searchParams.categoryName">{{ searchParams.categoryName }}<i
                    @click="removeCategory">×</i></li>
            <!--关键字面包屑-->
            <li class="with-x" v-show="searchParams.keyword">{{ searchParams.keyword }}<i @click="removeKeyword">×</i>
            </li>
            <!--品牌面包屑-->
            <li class="with-x" v-show="searchParams.trademark">{{ trademarkName }}<i
                    @click="removeTrademark">×</i></li>
            <!--售卖属性面包屑-->
            <li class="with-x" v-for="(attr,index) in searchParams.props" :key="index">{{ attr.split(':')[1] }}<i
                    @click="removeAttr(index)">×</i></li>
          </ul>
        </div>

        <!--selector-->
        <SearchSelector @trademarkInfo="trademarkInfo" @attrInfo="attrInfo" />

        <!--details-->
        <div class="details clearfix">
          <div class="sui-navbar">
            <div class="navbar-inner filter">
              <ul class="sui-nav">
                <li :class="{active:isOne}" @click="changeOrder('1')">
                  <a>综合<i v-show="isOne" class="iconfont" :class="{'icon-up':isAsc,'icon-arrowdown':isDesc}"></i></a>
                </li>
                <li :class="{active:isTwo}" @click="changeOrder('2')">
                  <a>价格<i v-show="isTwo" class="iconfont" :class="{'icon-up':isAsc,'icon-arrowdown':isDesc}"></i></a>
                </li>
              </ul>
            </div>
          </div>
          <!--商品列表-->
          <div class="goods-list">
            <ul class="yui3-g">
              <li class="yui3-u-1-5" v-for="(good,index) in goodsList" :key="good.id">
                <div class="list-wrap">
                  <div class="p-img">
                    <!--路由跳转时带上参数-->
                    <router-link :to="`/detail/${good.id}`">
                      <img v-lazy="good.defaultImg" />
                    </router-link>
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥ </em>
                      <i>{{ good.price }}</i>
                    </strong>
                  </div>
                  <div class="attr">
                    <a target="_blank" href="item.html" v-html="good.title" title="促销信息"></a>
                  </div>
                  <div class="commit">
                    <i class="command">已有<span>{{ good.hotScore }}</span>人评价</i>
                  </div>
                  <div class="operate">
                    <a href="success-cart.html" target="_blank" class="sui-btn btn-bordered btn-danger">加入购物车</a>
                    <a href="javascript:void(0);" class="sui-btn btn-bordered">收藏</a>
                  </div>
                </div>
              </li>
            </ul>
          </div>
          <!--分页器-->
          <Pagination :pageNo="searchParams.pageNo" :pageSize="searchParams.pageSize" :total="total" continues="5" @getPageNo="getPageNo"/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {mapGetters,mapState} from 'vuex'
  import SearchSelector from './SearchSelector/SearchSelector'

  export default {
    name: 'Search',
    components: {SearchSelector},
    data() {
      return {
        searchParams: {
          "category1id": "",//一级分类id
          "category2id": "",//二级分类id
          "category3id": "",//三级分类id
          "categoryName": "",//分类名字
          "keyword": "",//搜索关键字
          "order": "1:desc",//排序 默认综合降序 1:综合2:价格asc升序desc降序
          "pageNo": 1,//当前页
          "pageSize": 10,//每页的商品数
          "props": [],//售卖属性
          "trademark": ""//商标
        },
      }
    },
    beforeMount() {
      Object.assign(this.searchParams, this.$route.query, this.$route.params)
    },
    mounted() {
      //挂载时发出一次请求
      this.getData()
    },
    computed: {
      // ...mapGetters('search',{goodsList:'goodsList'}),
      //获取search组件展示产品一共有多少条数据
      ...mapGetters('search', ['goodsList','total']),
      //显示品牌的面包屑
      trademarkName() {
        if (this.searchParams.trademark) {
          return this.searchParams.trademark.split(':')[1]
        }
      },
      //判断是哪个排序方式 1综合 2价格
      isOne() {
        return this.searchParams.order.indexOf('1') !== -1
      },
      isTwo() {
        return this.searchParams.order.indexOf('2') !== -1
      },
      //是否升序
      isAsc() {
        return this.searchParams.order.indexOf('asc') !== -1
      },
      //是否降序
      isDesc() {
        return this.searchParams.order.indexOf('desc') !== -1
      },
    },
    methods: {
      //获取搜索的数据
      getData() {
        this.$store.dispatch('search/getSearchList', this.searchParams)
      },
      removeCategory() {
        //不发送这些请求
        this.searchParams.categoryName = undefined
        this.searchParams.category1id = undefined
        this.searchParams.category2id = undefined
        this.searchParams.category3id = undefined
        this.getData()
        //修改地址栏 进行路由跳转
        this.$router.push({name: "search", params: this.$route.params || undefined})
      },
      removeKeyword() {
        this.searchParams.keyword = undefined
        this.getData()
        //通知header清除搜索框的关键字
        this.$bus.$emit('clear')
        this.$router.push({name: "search", params: undefined, query: this.$route.query})
      },
      removeTrademark() {
        this.searchParams.trademark = undefined
        this.getData()
      },
      removeAttr(index) {
        this.searchParams.props.splice(index, 1)
        //移除后重新发起请求
        this.getData()
      },
      //获取子组件的数据(品牌)
      trademarkInfo(trademark) {
        //整合数据
        this.searchParams.trademark = `${trademark.tmId}:${trademark.tmName}`
        this.getData()
      },
      //获取子组件的数据(售卖属性)
      attrInfo(attr, name) {
        //格式:  "106:安卓手机:手机一级"
        let props = `${attr.attrId}:${name}:${attr.attrName}`
        //数组去重
        if (this.searchParams.props.indexOf(props) === -1) {
          this.searchParams.props.push(props)
          this.getData()
        }
      },
      //排序操作
      changeOrder(flag) {
        //flag 1综合 2价格
        let originFlag = this.searchParams.order.split(":")[0]
        let originSort = this.searchParams.order.split(":")[1]

        this.searchParams.order = `${flag}:${originSort==="desc"?"asc":"desc"}`
        this.getData()
      },
      //获取子组件的当前页数
      getPageNo(pageNo){
        this.searchParams.pageNo = pageNo
        this.getData()
      }
    },
    watch: {
      //监听属性 当路由信息发生变化时发出搜索
      $route: {
        deep: true,
        handler(newValue, oldValue) {
          Object.assign(this.searchParams, this.$route.query, this.$route.params)
          this.getData()
          //请求后清除分类id的数据
          this.searchParams.category1id = undefined
          this.searchParams.category2id = undefined
          this.searchParams.category3id = undefined
        }
      }
    }
  }
</script>

<style lang="less" scoped>
  .main {
    margin: 10px 0;

    .py-container {
      width: 1200px;
      margin: 0 auto;

      .bread {
        margin-bottom: 5px;
        overflow: hidden;

        .sui-breadcrumb {
          padding: 3px 15px;
          margin: 0;
          font-weight: 400;
          border-radius: 3px;
          float: left;

          li {
            display: inline-block;
            line-height: 18px;

            a {
              color: #666;
              text-decoration: none;

              &:hover {
                color: #4cb9fc;
              }
            }
          }
        }

        .sui-tag {
          margin-top: -5px;
          list-style: none;
          font-size: 0;
          line-height: 0;
          padding: 5px 0 0;
          margin-bottom: 18px;
          float: left;

          .with-x {
            font-size: 12px;
            margin: 0 5px 5px 0;
            display: inline-block;
            overflow: hidden;
            color: #000;
            background: #f7f7f7;
            padding: 0 7px;
            height: 20px;
            line-height: 20px;
            border: 1px solid #dedede;
            white-space: nowrap;
            transition: color 400ms;
            cursor: pointer;

            i {
              margin-left: 10px;
              cursor: pointer;
              font: 400 14px tahoma;
              display: inline-block;
              height: 100%;
              vertical-align: middle;
            }

            &:hover {
              color: #28a3ef;
            }
          }
        }
      }

      .details {
        margin-bottom: 5px;

        .sui-navbar {
          overflow: visible;
          margin-bottom: 0;

          .filter {
            min-height: 40px;
            padding-right: 20px;
            background: #fbfbfb;
            border: 1px solid #e2e2e2;
            padding-left: 0;
            border-radius: 0;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.065);

            .sui-nav {
              position: relative;
              left: 0;
              display: block;
              float: left;
              margin: 0 10px 0 0;

              li {
                float: left;
                line-height: 18px;

                a {
                  display: block;
                  cursor: pointer;
                  padding: 11px 15px;
                  color: #777;
                  text-decoration: none;
                }

                &.active {
                  a {
                    background: #e1251b;
                    color: #fff;
                  }
                }
              }
            }
          }
        }

        .goods-list {
          margin: 20px 0;

          ul {
            display: flex;
            flex-wrap: wrap;

            li {
              height: 100%;
              width: 20%;
              margin-top: 10px;
              line-height: 28px;

              .list-wrap {
                .p-img {
                  padding-left: 15px;
                  width: 215px;
                  height: 255px;

                  a {
                    color: #666;

                    img {
                      max-width: 100%;
                      height: auto;
                      vertical-align: middle;
                    }
                  }
                }

                .price {
                  padding-left: 15px;
                  font-size: 18px;
                  color: #c81623;

                  strong {
                    font-weight: 700;

                    i {
                      margin-left: -5px;
                    }
                  }
                }

                .attr {
                  padding-left: 15px;
                  width: 85%;
                  overflow: hidden;
                  margin-bottom: 8px;
                  min-height: 38px;
                  cursor: pointer;
                  line-height: 1.8;
                  display: -webkit-box;
                  -webkit-box-orient: vertical;
                  -webkit-line-clamp: 2;

                  a {
                    color: #333;
                    text-decoration: none;
                  }
                }

                .commit {
                  padding-left: 15px;
                  height: 22px;
                  font-size: 13px;
                  color: #a7a7a7;

                  span {
                    font-weight: 700;
                    color: #646fb0;
                  }
                }

                .operate {
                  padding: 12px 15px;

                  .sui-btn {
                    display: inline-block;
                    padding: 2px 14px;
                    box-sizing: border-box;
                    margin-bottom: 0;
                    font-size: 12px;
                    line-height: 18px;
                    text-align: center;
                    vertical-align: middle;
                    cursor: pointer;
                    border-radius: 0;
                    background-color: transparent;
                    margin-right: 15px;
                  }

                  .btn-bordered {
                    min-width: 85px;
                    background-color: transparent;
                    border: 1px solid #8c8c8c;
                    color: #8c8c8c;

                    &:hover {
                      border: 1px solid #666;
                      color: #fff !important;
                      background-color: #666;
                      text-decoration: none;
                    }
                  }

                  .btn-danger {
                    border: 1px solid #e1251b;
                    color: #e1251b;

                    &:hover {
                      border: 1px solid #e1251b;
                      background-color: #e1251b;
                      color: white !important;
                      text-decoration: none;
                    }
                  }
                }
              }
            }
          }
        }

        .page {
          width: 733px;
          height: 66px;
          overflow: hidden;
          float: right;

          .sui-pagination {
            margin: 18px 0;

            ul {
              margin-left: 0;
              margin-bottom: 0;
              vertical-align: middle;
              width: 490px;
              float: left;

              li {
                line-height: 18px;
                display: inline-block;

                a {
                  position: relative;
                  float: left;
                  line-height: 18px;
                  text-decoration: none;
                  background-color: #fff;
                  border: 1px solid #e0e9ee;
                  margin-left: -1px;
                  font-size: 14px;
                  padding: 9px 18px;
                  color: #333;
                }

                &.active {
                  a {
                    background-color: #fff;
                    color: #e1251b;
                    border-color: #fff;
                    cursor: default;
                  }
                }

                &.prev {
                  a {
                    background-color: #fafafa;
                  }
                }

                &.disabled {
                  a {
                    color: #999;
                    cursor: default;
                  }
                }

                &.dotted {
                  span {
                    margin-left: -1px;
                    position: relative;
                    float: left;
                    line-height: 18px;
                    text-decoration: none;
                    background-color: #fff;
                    font-size: 14px;
                    border: 0;
                    padding: 9px 18px;
                    color: #333;
                  }
                }

                &.next {
                  a {
                    background-color: #fafafa;
                  }
                }
              }
            }

            div {
              color: #333;
              font-size: 14px;
              float: right;
              width: 241px;
            }
          }
        }
      }
    }
  }
</style>
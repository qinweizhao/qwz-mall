<template>
  <div class="cart">
    <h4>全部商品</h4>
    <div class="cart-main">
      <div class="cart-th">
        <div class="cart-th1">全部</div>
        <div class="cart-th2">商品</div>
        <div class="cart-th4">单价（元）</div>
        <div class="cart-th5">数量</div>
        <div class="cart-th6">小计（元）</div>
        <div class="cart-th7">操作</div>
      </div>

      <!--购物车列表-->
      <div class="cart-body">
        <ul class="cart-list" v-for="(cart) in cartList" :key="cart.id">
          <li class="cart-list-con1">
            <input type="checkbox" @change="updateChecked(cart,$event)" :checked="cart.isChecked" name="chk_list">
          </li>
          <li class="cart-list-con2">
            <img :src="cart.imgUrl">
            <div class="item-msg">{{ cart.skuName }}</div>
          </li>
          <li class="cart-list-con4">
            <span class="price">{{ cart.skuPrice }}</span>
          </li>
          <li class="cart-list-con5">
            <a class="mins" style="cursor: pointer" @click="handler('minus',-1,cart)">-</a>
            <input autocomplete="off" type="number" :value="cart.skuNum" minnum="1" class="itxt"
                   @focusout="handler('change',$event.target.value*1,cart)">
            <a class="plus" style="cursor: pointer" @click="handler('add',1,cart)">+</a>
          </li>
          <li class="cart-list-con6">
            <span class="sum">{{ cart.skuPrice * cart.skuNum }}</span>
          </li>
          <li class="cart-list-con7">
            <a @click="deleteCartById(cart)" style="cursor: pointer" class="sindelet">删除</a>
            <br>
            <a href="#none">移到收藏</a>
          </li>
        </ul>
      </div>

    </div>
    <div class="cart-tool">
      <div class="select-all">
        <input class="chooseAll" :checked="isChecked&&cartList.length>0" @change="updateAllCartChecked" type="checkbox">
        <span>全选</span>
      </div>
      <div class="option">
        <a style="cursor: pointer" @click="deleteAllCheckedCart">删除选中的商品</a>
        <a href="#none">移到我的关注</a>
        <a href="#none">清除下柜商品</a>
      </div>
      <div class="money-box">
        <div class="chosed">已选择
          <span>0</span>件商品
        </div>
        <div class="sumprice">
          <em>总价（不含运费） ：</em>
          <i class="summoney">{{ totalPrice }}</i>
        </div>
        <div class="sumbtn">
          <router-link class="sum-btn" to="/trade">结算</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import throttle from 'lodash/throttle'//节流

export default {
  name: 'ShopCart',
  mounted() {
    this.getData()
  },
  methods: {
    //获取个人购物车数据
    getData() {
      this.$store.dispatch('shopcart/getCartList')
    },
    //修改购物车商品的个数  throttle 节流操作
    handler: throttle(async function (type, disNum, cart) {
      //变化类型 变化数量 产品id
      switch (type) {
        case 'add':
          disNum = 1
          break
        case 'minus':
          disNum = cart.skuNum > 1 ? -1 : 0
          break
        case 'change':
          if (isNaN(disNum) || disNum < 1) {
            disNum = 0
          } else {
            disNum = parseInt(disNum) - cart.skuNum
          }
          //disNum = isNaN(disNum) || disNum<1 ? 0 : parseInt(disNum) - cart.skuNum
          break
      }
      try {
        await this.$store.dispatch('detail/addOrUpdateShopCart', {skuId: cart.skuId, skuNum: disNum})
        this.getData()
      } catch (error) {
        alert(error.message)
      }
    }, 300),
    //删除购物车商品
    async deleteCartById(cart) {
      try {
        await this.$store.dispatch('shopcart/deleteCartById', cart.skuId)
        this.getData()
      } catch (error) {
        alert(error.message)
      }
    },
    //删除选中的商品
    async deleteAllCheckedCart(){
      try {
        await this.$store.dispatch('shopcart/deleteAllCheckedCart')
        this.getData()
      }catch (e) {
        alert(e.message)
      }
    },
    //更新商品选中状态
    async updateChecked(cart,e){
      try {
        let checked = e.target.checked ? '1' : '0'
        await this.$store.dispatch('shopcart/updateCheckedById', {skuId:cart.skuId,isChecked:checked})
        this.getData()
      }catch (e) {
        alert(e.message)
      }
     },
    //全选功能
    async updateAllCartChecked(event){
      try {
        let isChecked = event.target.checked? "1":'0'
        await this.$store.dispatch('shopcart/updateAllCartChecked',isChecked)
        this.getData()
      }catch (e) {
        alert(e.message)
      }
     },
  },
  computed: {
    ...mapGetters('shopcart', ['cartList']),
    //总价
    totalPrice() {
      if (this.cartList) {
        let sum = 0
        this.cartList.forEach(item => {
          if (item.isChecked)
            sum = sum + item.skuNum * item.skuPrice
        })
        return sum
      }
    },
    //判断复选框是否全选
    isChecked() {
      //每个isChecked都是1 则返回1 否则0
      return this.cartList.every(item => item.isChecked === 1)
    }
  },

}
</script>

<style lang="less" scoped>
/*取消input type=number的上下箭头*/
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none !important;
  margin: 0;
}

.cart {
  width: 1200px;
  margin: 0 auto;

  h4 {
    margin: 9px 0;
    font-size: 14px;
    line-height: 21px;
  }

  .cart-main {
    .cart-th {
      background: #f5f5f5;
      border: 1px solid #ddd;
      padding: 10px;
      overflow: hidden;

      & > div {
        float: left;
      }

      .cart-th1 {
        width: 15%;

        input {
          vertical-align: middle;
        }

        span {
          vertical-align: middle;
        }
      }

      .cart-th2 {
        width: 28%;
      }

      .cart-th3 {
        width: 12%;
      }

      .cart-th4 {
        width: 12.5%;
      }

      .cart-th5 {
        width: 12.5%;
      }

      .cart-th6 {
        width: 22.5%;
      }

      .cart-th7 {
        width: 8.5%;
      }
    }

    .cart-body {
      margin: 15px 0;
      border: 1px solid #ddd;

      .cart-list {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        overflow: hidden;

        & > li {
          float: left;
        }

        .cart-list-con1 {
          width: 4.1667%;
        }

        .cart-list-con2 {
          width: 39%;

          img {
            width: 82px;
            height: 82px;
            float: left;
          }

          .item-msg {
            float: left;
            width: 300px;
            margin: 0 10px;
            line-height: 18px;
          }
        }

        .cart-list-con3 {
          width: 28.8333%;

          .item-txt {
            text-align: center;
          }
        }

        .cart-list-con4 {
          width: 9.5%;

        }

        .cart-list-con5 {
          width: 15.5%;

          .mins {
            border: 1px solid #ddd;
            border-right: 0;
            float: left;
            color: #666;
            width: 6px;
            text-align: center;
            padding: 8px;
          }

          input {
            border: 1px solid #ddd;
            width: 40px;
            height: 33px;
            float: left;
            text-align: center;
            font-size: 14px;
          }

          .plus {
            border: 1px solid #ddd;
            border-left: 0;
            float: left;
            color: #666;
            width: 6px;
            text-align: center;
            padding: 8px;
          }
        }

        .cart-list-con6 {
          width: 22.5%;

          .sum {
            font-size: 16px;
          }
        }

        .cart-list-con7 {
          width: 8.5%;

          a {
            color: #666;
          }
        }
      }
    }
  }

  .cart-tool {
    overflow: hidden;
    border: 1px solid #ddd;

    .select-all {
      padding: 10px;
      overflow: hidden;
      float: left;

      span {
        vertical-align: middle;
      }

      input {
        vertical-align: middle;
      }
    }

    .option {
      padding: 10px;
      overflow: hidden;
      float: left;

      a {
        float: left;
        padding: 0 10px;
        color: #666;
      }
    }

    .money-box {
      float: right;

      .chosed {
        line-height: 26px;
        float: left;
        padding: 0 10px;
      }

      .sumprice {
        width: 200px;
        line-height: 22px;
        float: left;
        padding: 0 10px;

        .summoney {
          color: #c81623;
          font-size: 16px;
        }
      }

      .sumbtn {
        float: right;

        a {
          display: block;
          position: relative;
          width: 96px;
          height: 52px;
          line-height: 52px;
          color: #fff;
          text-align: center;
          font-size: 18px;
          font-family: "Microsoft YaHei";
          background: #e1251b;
          overflow: hidden;
        }
      }
    }
  }
}
</style>
<template>
  <div class="spec-preview">
    <img :src="imgObj.imgUrl"/>
    <div class="event" @mousemove="handler"></div>
    <div class="big">
      <img :src="imgObj.imgUrl"  ref="big"/>
    </div>
    <div class="mask" ref="mask"></div>
  </div>
</template>

<script>
export default {
  name: "Zoom",
  props: ['skuImageList'],
  data() {
    return {
      //初始大图索引值
      index: 0
    }
  },
  computed: {
    //防止报错
    imgObj() {
      return this.skuImageList[this.index] || {}
    }
  },
  methods: {
    handler(event) {
      let mask = this.$refs.mask
      let big = this.$refs.big

      //offsetWidth表示元素在页面中所占用的总宽度
      //offsetHeight表示元素在页面中所占用的总高度
      let left = event.offsetX - mask.offsetWidth / 2
      let top = event.offsetY - mask.offsetHeight / 2
      //约束范围
      if (left < 0) left = 0
      if (left >= mask.offsetWidth) left = mask.offsetWidth
      if (top < 0) top = 0
      if (top >= mask.offsetHeight) top = mask.offsetHeight
      //修改mask的left和top
      mask.style.left = left + 'px'
      mask.style.top = top + 'px'
      //修改big的left和top
      big.style.left = -2 * left + 'px'
      big.style.top = -2 * top + 'px'
    }
  },
  mounted() {
    //当前大图显示是根据ImageList传过来的值决定
    this.$bus.$on('getIndex', (index) => {
      this.index = index
    })
  },
  beforeDestroy() {
    this.$bus.$off('big')
  }
}
</script>

<style lang="less">
.spec-preview {
  position: relative;
  width: 400px;
  height: 400px;
  border: 1px solid #ccc;

  img {
    width: 100%;
    height: 100%;
  }

  .event {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    z-index: 998;
  }

  .mask {
    width: 50%;
    height: 50%;
    background-color: rgba(0, 255, 0, 0.3);
    position: absolute;
    left: 0;
    top: 0;
    display: none;
  }

  .big {
    width: 100%;
    height: 100%;
    position: absolute;
    top: -1px;
    left: 100%;
    border: 1px solid #aaa;
    overflow: hidden;
    z-index: 998;
    display: none;
    background: white;

    img {
      width: 200%;
      max-width: 200%;
      height: 200%;
      position: absolute;
      left: 0;
      top: 0;
    }
  }

  .event:hover ~ .mask,
  .event:hover ~ .big {
    display: block;
  }
}
</style>

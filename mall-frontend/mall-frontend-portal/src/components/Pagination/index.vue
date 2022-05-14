<template>
  <div class="pagination">
    <button :disabled="pageNo===1" @click="$emit('getPageNo',pageNo-1)">上一页</button>
    <span  v-if="startNumAndEndNum.start>1">
      <button @click="$emit('getPageNo',1)" :class="{active:pageNo===1}">1</button>
      <button>···</button>
    </span>

    <button
        v-for="(page,index) in startNumAndEndNum.end"
        v-if="page>=startNumAndEndNum.start" :key="index"
        @click="$emit('getPageNo',page)"
        :class="{active:pageNo===page}"
    >{{ page }}</button>


    <button v-if="startNumAndEndNum.end<totalPage-1">···</button>
    <button v-if="startNumAndEndNum.end<totalPage"
            @click="$emit('getPageNo',totalPage)"
            :class="{active:pageNo===totalPage}"
    >{{ totalPage }}</button>

    <button :disabled="pageNo===totalPage" @click="$emit('getPageNo',pageNo+1)">下一页</button>

    <button style="margin-left: 30px">共 {{ total }} 条</button>
  </div>
</template>

<script>
export default {
  name: "Pagination",
  props:['pageNo','pageSize','total','continues'],
  computed:{
    //总页数
    totalPage(){
      //向上取整
      return Math.ceil(this.total/this.pageSize)
    },
    //连续页码的起始数和结束数
    startNumAndEndNum(){
      const {continues,pageNo,totalPage} = this    //5 3 20
      let start = 0
      let end = 0
      //连续页码数5 至少5页 有时候总页数小于5页
      if (continues > totalPage){
        start = 1
        end = totalPage
      }else{
        //比如说连续五页 则middle=5/2向下取整=2
        let middle = Math.floor(continues/2)     //5/2=2

        //连续页码数5 至少5页 有时候总页数大于5页
        if (pageNo >  middle){                      //3>2
          //结束数不超过总页数
          if ( (pageNo + middle) <= totalPage){     //3+2<=20
            start = pageNo - middle                 //3-2=1
            end = pageNo + middle                   //3+2=5
          }else {
            //当结束数在 总页数 和 总页数-middle之间 需要对起始数做处理 27 28 .29 30 31.
            end = totalPage
            start = totalPage - continues + 1
          }
        }else {
          //当前页小于中间数(Math.floor(continues/2))   1  .2.  3 4 5
          start = 1
          end = parseInt(continues)
        }
      }
      return {start,end}
    }
  }
}
</script>

<style lang="less" scoped>
.pagination {
  text-align: center;
  button {
    margin: 0 5px;
    background-color: #f4f4f5;
    color: #606266;
    outline: none;
    border-radius: 2px;
    padding: 0 4px;
    vertical-align: top;
    display: inline-block;
    font-size: 13px;
    min-width: 35.5px;
    height: 28px;
    line-height: 28px;
    cursor: pointer;
    box-sizing: border-box;
    text-align: center;
    border: 0;

    &[disabled] {
      color: #c0c4cc;
      cursor: not-allowed;
    }

    &.active {
      cursor: not-allowed;
      background-color: #409eff;
      color: #fff;
    }
  }
}
.active{
  background-color: #4cb9fc;
}
</style>

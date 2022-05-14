<template>
  <div>
    <TypeNav/>
    <ListContainer/>
    <Recommend/>
    <Rank/>
    <Like/>
    <Floor v-for="(floor,index) in floorList" :floorList="floor" :key="floor.id"/>
    <Brand/>
  </div>
</template>

<script>
  import ListContainer from '@/pages/Home/ListContainer'
  import Recommend from '@/pages/Home/Recommend'
  import Rank from '@/pages/Home/Rank'
  import Like from '@/pages/Home/Like'
  import Floor from '@/pages/Home/Floor'
  import Brand from '@/pages/Home/Brand'
  import {mapState} from 'vuex'
  export default {
    name: "Home",
    components:{ListContainer,Recommend,Rank,Like,Floor,Brand},
    mounted() {
      //获取floor组件的数据
      this.$store.dispatch('home/GetFloorList')
    },
    computed:{
      ...mapState('home',['floorList'])
    }
  }
</script>

<style scoped>

</style>
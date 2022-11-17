<template>
  <div class="head-container">
    <el-cascader
      filterable
      clearable
      placeholder="试试搜索：手机"
      v-model="paths"
      :options="categoryData"
      :props="setting"
    ></el-cascader>
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import《组件名称》from'《组件路径》';

import { pageCategory } from '@/api/product/category'

export default {
  //import引入的组件需要注入到对象中才能使用
  components: {},
  //接受父组件传来的值
  props: {
    categoryPath: {
      type: Array,
      default() {
        return []
      }
    }
  },
  data() {
    //这里存放数据
    return {
      setting: {
        value: 'categoryId',
        label: 'name',
        children: 'children'
      },
      categoryData: [],
      paths: this.categoryPath
    }
  },
  watch: {
    categoryPath(v) {
      console.log('category', v)
      this.paths = this.categoryPath
    },
    paths(v) {
      this.$emit('update:categoryPath', v)
      this.$emit('input',v[v.length - 1])
    }
  },
  //方法集合
  methods: {
    getCategory() {
      pageCategory(this.queryParams).then(response => {
        this.categoryData = this.handleTree(response.data.rows, 'categoryId')
      })
    }
  },
  //生命周期-创建完成（可以访问当前this实例）
  created() {
    this.getCategory()
  }
}
</script>
<style scoped>
</style>

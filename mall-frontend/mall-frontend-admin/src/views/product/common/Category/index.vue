<template>
  <div class="head-container">
    <el-input
      v-model="categoryName"
      placeholder="请输入分类名称"
      clearable
      size="small"
      prefix-icon="el-icon-search"
      style="margin-bottom: 20px"
    />
    <el-tree
      :data="categoryOptions"
      :props="defaultProps"
      :expand-on-click-node="false"
      :filter-node-method="filterNode"
      ref="tree"
      @node-click="handleNodeClick"
    />
  </div>

</template>

<script>
import {pageCategory} from '@/api/product/category'

export default {
  name: 'category',
  data() {
    return {
      categoryName: undefined,
      // 树选项
      categoryOptions: undefined,
      defaultProps: {
        children: 'children',
        label: 'name'
      },
      // 查询参数
      queryParams: {
        userName: undefined,
        status: undefined,
        categoryId: undefined
      }
    }
  },
  created() {
    this.getList();
  },
  watch: {
    // 根据名称筛选部门树
    categoryName(val) {
      this.$refs.tree.filter(val)
    }
  },
  methods: {
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data, node, component) {
      //向父组件发送事件；
      this.$emit("tree-node-click", data, node, component);
    },
    /** 查询分类列表 */
    getList() {
      this.loading = true
      pageCategory(this.queryParams).then(response => {
        this.categoryOptions = this.handleTree(response.data.rows, 'categoryId')
        this.loading = false
      })
    }
  }
}
</script>

<style scoped>

</style>

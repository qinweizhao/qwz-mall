<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
             label-width="68px"
    >
      <el-form-item label="属性名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入属性名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="类型" prop="status">
        <el-select
          v-model="queryParams.type"
          placeholder="属性类型"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.pms_attr_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="openSelectAttr"
          v-hasPermi="['system:role:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-circle-close"
          size="mini"
          :disabled="multiple"
          @click="cancelRelationAll"
          v-hasPermi="['system:role:remove']"
        >批量取消关联
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-close"
          size="mini"
          @click="handleClose"
        >关闭
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="attrList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="编号" align="center" prop="attrId"/>
      <el-table-column label="名称" align="center" prop="name"/>
      <el-table-column label="类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pms_attr_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="可选值" align="center" prop="valueSelect"/>
      <el-table-column label="值类型" align="center" prop="valueType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pms_attr_value_type" :value="scope.row.valueType"/>
        </template>
      </el-table-column>

      <el-table-column label="快速展示" align="center" prop="quickShow">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pms_attr_quick_show" :value="scope.row.quickShow"/>
        </template>
      </el-table-column>
      <el-table-column label="需要检索" align="center" prop="searchType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pms_attr_search_type" :value="scope.row.searchType"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-circle-close"
            @click="cancelRelation(scope.row)"
            v-hasPermi="['system:role:remove']"
          >取消关联
          </el-button>
        </template>
      </el-table-column>
    </el-table>


    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <select-attr ref="select" :attrGroupId="queryParams.attrGroupId" @ok="handleQuery"/>
  </div>
</template>

<script>
import {authUserCancelAll} from "@/api/system/role";
import {getRelation, relationCancel} from '@/api/product/attr/group'
import selectAttr from "./selectAttr";

export default {
  name: "Relation",
  dicts: ['pms_attr_value_type', 'pms_attr_search_type', 'pms_attr_type', 'pms_attr_quick_show'],
  components: {selectAttr},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 商品属性表格数据
      attrList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        icon: null,
        valueSelect: null,
        valueType: null,
        searchType: null,
        type: null,
        status: null,
        categoryId: null,
        attrGroupId: null,
        quickShow: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      categoryOptions: []
    }
  },
  created() {
    const attrGroupId = this.$route.params && this.$route.params.attrGroupId;
    if (attrGroupId) {
      this.queryParams.attrGroupId = attrGroupId;
      this.getList();
    }
  },
  methods: {
    /** 查询授权用户列表 */
    getList() {
      this.loading = true
      getRelation(this.queryParams).then(response => {
        this.attrList = response.data
        this.loading = false
      })
    },
    // 返回按钮
    handleClose() {
      const obj = {path: "/product/attr/group"};
      this.$tab.closeOpenPage(obj);
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.userIds = selection.map(item => item.userId)
      this.multiple = !selection.length
    },
    /** 打开授权用户表弹窗 */
    openSelectAttr() {
      this.$refs.select.show();
    },
    /** 取消关联操作 */
    cancelRelation(row) {
      const ids = row.attrId || this.ids
      this.$modal.confirm('确认要取消该用户"' + row.name + '"属性吗？').then(function () {
        return relationCancel(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("取消关联成功");
      }).catch(() => {
      });
    },
    /** 批量取消关联操作 */
    cancelRelationAll(row) {
      const roleId = this.queryParams.roleId;
      const userIds = this.userIds.join(",");
      this.$modal.confirm('是否取消选中用户授权数据项？').then(function () {
        return authUserCancelAll({roleId: roleId, userIds: userIds});
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("取消授权成功");
      }).catch(() => {
      });
    }
  }
};
</script>

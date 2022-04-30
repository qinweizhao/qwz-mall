<template>
  <!-- 关联属性 -->
  <el-dialog title="选择属性" :visible.sync="visible" width="800px" top="5vh" append-to-body>
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true"
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

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row>
      <el-table :data="attrList" @selection-change="handleSelectionChange">
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
      </el-table>
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />
    </el-row>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="handleSelectAttr">确 定</el-button>
      <el-button @click="visible = false">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
import {addRelation, unRelation} from '@/api/product/attr/group'

export default {
  name: 'selectAttr',
  dicts: ['pms_attr_value_type', 'pms_attr_search_type', 'pms_attr_type', 'pms_attr_quick_show'],
  props: {
    // 角色编号
    attrGroupId: {
      type: [Number, String]
    }
  },
  data() {
    return {
      // 遮罩层
      visible: false,
      // 总条数
      total: 0,
      // 商品属性表格数据
      attrList: [],
      attrIds: [],
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
    }
  },
  methods: {
    // 显示弹框
    show() {
      this.queryParams.attrGroupId = this.attrGroupId;
      this.getList();
      this.visible = true;
    },
    /** 查询授权用户列表 */
    getList() {
      this.visible = true
      unRelation(this.queryParams).then(response => {
        this.attrList = response.data.rows
        this.total = response.data.total
      })
    },
    /** 选择授权用户操作 */
    handleSelectAttr() {
      const attrGroupId = this.queryParams.attrGroupId;
      const attrIds = this.attrIds.join(",");
      if (attrIds === "") {
        this.$modal.msgError("请选择要关联的属性");
        return;
      }
      addRelation({attrGroupId: attrGroupId, attrIds: attrIds}).then(response => {
        this.$modal.msgSuccess(response.message);
        if (response.code === "200") {
          this.visible = false;
          this.$emit("ok");
        }
      });
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
      this.attrIds = selection.map(item => item.attrId);
    },
  }
}
</script>

<style scoped>

</style>

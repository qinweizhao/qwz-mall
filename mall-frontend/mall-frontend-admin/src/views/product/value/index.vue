<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品id" prop="spuId">
        <el-input
          v-model="queryParams.spuId"
          placeholder="请输入商品id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="属性id" prop="attrId">
        <el-input
          v-model="queryParams.attrId"
          placeholder="请输入属性id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="属性名" prop="attrName">
        <el-input
          v-model="queryParams.attrName"
          placeholder="请输入属性名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="属性值" prop="attrValue">
        <el-input
          v-model="queryParams.attrValue"
          placeholder="请输入属性值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顺序" prop="attrSort">
        <el-input
          v-model="queryParams.attrSort"
          placeholder="请输入顺序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="快速展示【是否展示在介绍上；0-否 1-是】" prop="quickShow">
        <el-input
          v-model="queryParams.quickShow"
          placeholder="请输入快速展示【是否展示在介绍上；0-否 1-是】"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          @click="handleAdd"
          v-hasPermi="['product:value:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['product:value:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['product:value:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['product:value:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="valueList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="商品id" align="center" prop="spuId" />
      <el-table-column label="属性id" align="center" prop="attrId" />
      <el-table-column label="属性名" align="center" prop="attrName" />
      <el-table-column label="属性值" align="center" prop="attrValue" />
      <el-table-column label="顺序" align="center" prop="attrSort" />
      <el-table-column label="快速展示【是否展示在介绍上；0-否 1-是】" align="center" prop="quickShow" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['product:value:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['product:value:remove']"
          >删除</el-button>
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

    <!-- 添加或修改spu属性值对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品id" prop="spuId">
          <el-input v-model="form.spuId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="属性id" prop="attrId">
          <el-input v-model="form.attrId" placeholder="请输入属性id" />
        </el-form-item>
        <el-form-item label="属性名" prop="attrName">
          <el-input v-model="form.attrName" placeholder="请输入属性名" />
        </el-form-item>
        <el-form-item label="属性值" prop="attrValue">
          <el-input v-model="form.attrValue" placeholder="请输入属性值" />
        </el-form-item>
        <el-form-item label="顺序" prop="attrSort">
          <el-input v-model="form.attrSort" placeholder="请输入顺序" />
        </el-form-item>
        <el-form-item label="快速展示【是否展示在介绍上；0-否 1-是】" prop="quickShow">
          <el-input v-model="form.quickShow" placeholder="请输入快速展示【是否展示在介绍上；0-否 1-是】" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listValue, getValue, delValue, addValue, updateValue } from "@/api/product/value";

export default {
  name: "Value",
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
      // spu属性值表格数据
      valueList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        spuId: null,
        attrId: null,
        attrName: null,
        attrValue: null,
        attrSort: null,
        quickShow: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询spu属性值列表 */
    getList() {
      this.loading = true;
      listValue(this.queryParams).then(response => {
        this.valueList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        spuId: null,
        attrId: null,
        attrName: null,
        attrValue: null,
        attrSort: null,
        quickShow: null
      };
      this.resetForm("form");
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加spu属性值";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getValue(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改spu属性值";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateValue(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addValue(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除spu属性值编号为"' + ids + '"的数据项？').then(function() {
        return delValue(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/value/export', {
        ...this.queryParams
      }, `value_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

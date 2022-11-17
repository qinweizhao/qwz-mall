<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="品牌名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入品牌名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="首字母" prop="firstLetter">
        <el-input
          v-model="queryParams.firstLetter"
          placeholder="请输入品牌首字母"
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
          v-hasPermi="['product:brand:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['product:brand:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['product:brand:remove']"
        >删除
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="brandList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="25" align="center"/>
      <el-table-column label="编号" align="center" prop="brandId" width="60px"/>
      <el-table-column label="品牌名" align="center" prop="name"/>
      <el-table-column label="logo" align="center" prop="logo">
        <template slot-scope="scope">
          <image-preview :src="scope.row.logo" :width="'30px'"/>
        </template>
      </el-table-column>
      <el-table-column label="介绍" align="center" prop="description"/>
      <el-table-column label="状态" align="center" prop="showStatus" width="60px"/>
      <el-table-column label="品牌首字母" align="center" prop="firstLetter"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            type="text"
            size="mini"
            icon="el-icon-edit"
            @click="handleUpdateRelation(scope.row)"
          >关联分类
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['product:brand:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['product:brand:remove']"
          >删除
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

    <!-- 添加或修改品牌对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="品牌名" prop="name">
          <el-input v-model="form.name" placeholder="请输入品牌名"/>
        </el-form-item>
        <el-form-item label="logo" prop="logo">
          <image-upload v-model="form.logo"></image-upload>
        </el-form-item>
        <el-form-item label="介绍" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="首字母" prop="firstLetter">
          <el-input v-model="form.firstLetter" placeholder="请输入检索首字母"/>
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 关联分类对话框 -->
    <el-dialog title="关联分类" :visible.sync="cateRelationDialogVisible" width="30%">
      <el-popover placement="right-end" v-model="popCategorySelectVisible">
        <category-cascade :category-path.sync="categoryPath"/>
        <div style="text-align: right; margin: 0">
          <el-button size="mini" type="text" @click="popCategorySelectVisible = false">取消</el-button>
          <el-button type="primary" size="mini" @click="handleRelationAdd">确定</el-button>
        </div>
        <el-button slot="reference">新增关联</el-button>
      </el-popover>
      <el-table :data="relationTableData">
        <el-table-column prop="id" label="编号"></el-table-column>
        <el-table-column prop="brandName" label="品牌名"></el-table-column>
        <el-table-column prop="categoryName" label="分类名"></el-table-column>
        <el-table-column fixed="right" header-align="center" align="center" label="操作">
          <template slot-scope="scope">
            <el-button
              type="text"
              size="small"
              @click="HandleRelationDelete(scope.row)"
            >移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="cateRelationDialogVisible = false">关 闭</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {addBrand, delBrand, getBrand, pageBrand, updateBrand} from '@/api/product/brand'
import {addRelation, delRelation, getRelation,} from "@/api/product/categoryBrand"
import ImageUpload from '@/components/ImageUpload'
import CategoryCascade from '@/views/product/common/CategoryCascade'
import ImagePreview from '@/components/ImagePreview'

export default {
  name: 'Brand',
  components: {ImageUpload, ImagePreview, CategoryCascade},
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
      // 品牌表格数据
      brandList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        logo: null,
        description: null,
        showStatus: null,
        firstLetter: null,
        sort: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      categoryPath:[],
      // 关联表单
      relationForm: {},
      cateRelationDialogVisible: false,
      relationTableData: [],
      addRelationForm: {},
      popCategorySelectVisible: false
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询品牌列表 */
    getList() {
      this.loading = true
      pageBrand(this.queryParams).then(response => {
        this.brandList = response.data.rows
        this.total = response.data.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.cateRelationDialogVisible = false
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        brandId: null,
        name: null,
        logo: null,
        description: null,
        showStatus: 0,
        firstLetter: null,
        sort: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.brandId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.cateRelationDialogVisible = false
      this.title = '添加品牌'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const brandId = row.brandId || this.ids
      getBrand(brandId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改品牌'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.brandId != null) {
            updateBrand(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addBrand(this.form).then(response => {
              this.$modal.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const brandIds = row.brandId || this.ids
      this.$modal.confirm('是否确认删除品牌编号为"' + brandIds + '"的数据项？').then(function () {
        return delBrand(brandIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/brand/export', {
        ...this.queryParams
      }, `brand_${new Date().getTime()}.xlsx`)
    },
    // wz-code
    handleUpdateRelation(row) {
      this.cateRelationDialogVisible = true;
      this.relationForm.brandId = row.brandId;
      this.getCateRelation();
    },
    getCateRelation() {
      console.log(this.relationForm)
      getRelation(this.relationForm).then(response => {
        this.relationTableData = response.data
        this.loading = false
      })
    },
    handleRelationAdd() {
      if (this.categoryPath!= null) {
        this.relationForm.categoryId=this.categoryPath[this.categoryPath.length-1]
        addRelation(this.relationForm).then(response => {
          this.$modal.msgSuccess('新增成功')
          this.popCategorySelectVisible = false
          this.getCateRelation()
        })
      } else {
        this.$modal.msgError('请选择分类')
      }

    },
    HandleRelationDelete(row) {
      const categoryId = row.id;
      this.$modal.confirm('是否确认删除品牌编号为"' + categoryId + '"的数据项？').then(function () {
        return delRelation(categoryId)
      }).then(() => {
        this.getCateRelation()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    treeNodeClick(data, node, component) {
      if (node.level === 3) {
        this.relationForm.categoryId = data.categoryId
      }
    },
  }
}
</script>
<style>
.el-popover {
  overflow: auto;
}
</style>


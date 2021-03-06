<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--分类数据-->
      <el-col :span="4" :xs="24">
        <category @tree-node-click="treeNodeClick"/>
      </el-col>
      <!--属性分组数据-->
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
                 label-width="68px"
        >
          <el-form-item label="组名" prop="name">
            <el-input
              v-model="queryParams.name"
              placeholder="请输入组名"
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
              v-hasPermi="['product:attrgroup:add']"
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
              v-hasPermi="['product:attrgroup:edit']"
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
              v-hasPermi="['product:attrgroup:remove']"
            >删除
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="search"
              plain
              icon="el-icon-refresh"
              size="mini"
              @click="handleQueryAll"
              v-hasPermi="['product:attrgroup:export']"
            >查询全部
            </el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="groupList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55" align="center"/>
          <el-table-column label="编号" width="55" align="center" prop="attrGroupId"/>
          <el-table-column label="组名" align="center" prop="name"/>
          <el-table-column label="排序" align="center" prop="sort"/>
          <el-table-column label="描述" align="center" prop="description"/>
          <el-table-column label="创建时间" align="center" prop="createTime"/>
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleRelation(scope.row)"
                v-hasPermi="['product:attrgroup:edit']"
              >关联属性
              </el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['product:attrgroup:edit']"
              >修改
              </el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['product:attrgroup:remove']"
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
      </el-col>
    </el-row>

    <!-- 添加或修改属性分组对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="组名" prop="name">
              <el-input v-model="form.name" placeholder="请输入组名"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="排序" prop="sort">
              <el-input v-model="form.sort" placeholder="请输入排序"/>
            </el-form-item>
          </el-col>

        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="分类" prop="categoryId">
              <category-cascade :categoryPath.sync="form.categoryPath"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" placeholder="请输入描述"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入描述"/>
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

import { addGroup, delGroup, getGroup, listAttrGroup, updateGroup } from '@/api/product/attrGroup'
import Category from '@/views/product/common/Category'
import CategoryCascade from '@/views/product/common/CategoryCascade'

export default {
  name: 'Group',
  components: { Category, CategoryCascade },
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
      // 属性分组表格数据
      groupList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        sort: null,
        description: null,
        icon: null,
        categoryId: null
      },
      // 表单参数
      form: {
        categoryPath: []
      },
      // 表单校验
      rules: {
        categoryId: [
          { required: true, message: '请选择具分类', trigger: 'blur' }
        ],
        name: [
          { required: true, message: '分组名不能为空', trigger: 'blur' }
        ],
        sort: [
          { required: true, message: '排序不能为空', trigger: 'blur' }
        ]
      }

    }
  },
  created() {
    this.getList()
  },
  methods: {

    /** 查询属性分组列表 */
    getList() {
      this.loading = true
      listAttrGroup(this.queryParams).then(response => {
        this.groupList = response.data.rows
        this.total = response.data.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        attrGroupId: null,
        name: null,
        sort: null,
        description: null,
        icon: null,
        categoryId: null
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
      this.ids = selection.map(item => item.attrGroupId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加属性分组'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const attrGroupId = row.attrGroupId || this.ids
      getGroup(attrGroupId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改属性分组'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.form.categoryId = this.form.categoryPath[this.form.categoryPath.length - 1]
      this.form.categoryPath = this.form.categoryPath.join(',');
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.attrGroupId != null) {
            updateGroup(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addGroup(this.form).then(response => {
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
      const attrGroupIds = row.attrGroupId || this.ids
      this.$modal.confirm('是否确认删除属性分组编号为"' + attrGroupIds + '"的数据项？').then(function() {
        return delGroup(attrGroupIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    // wz-code
    handleQueryAll() {
      this.queryParams.pageNum = 1
      this.queryParams.categoryId = null
      this.getList()
    },
    treeNodeClick(data, node, component) {
      if (node.level === 3) {
      this.queryParams.categoryId = data.categoryId
      this.getList() //重新查询
      }
    },
    /** 关联属性操作 */
    handleRelation: function(row) {
      const attrGroupId = row.attrGroupId
      console.log(row)
      this.$router.push('/product/relation/attr-attrgroup/' + attrGroupId)
    }

  }
}
</script>

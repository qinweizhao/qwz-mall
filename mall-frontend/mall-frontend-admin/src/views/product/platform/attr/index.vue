<template>
  <div class="app-container">

    <el-row :gutter="20">
      <!--分类数据-->
      <el-col :span="4" :xs="24">
        <category @tree-node-click="treeNodeClick"/>
      </el-col>
      <!--属性数据-->
      <el-col :span="20" :xs="24">
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
              @click="handleAdd"
              v-hasPermi="['product:attr:add']"
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
              v-hasPermi="['product:attr:edit']"
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
              v-hasPermi="['product:attr:remove']"
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
              v-hasPermi="['product:group:export']"
            >查询全部
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
          <el-table-column label="状态" align="center" key="status">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.status"
                :active-value="1"
                :inactive-value="0"
                @change="handleStatusChange(scope.row)"
              ></el-switch>
            </template>
          </el-table-column>
          <el-table-column label="所属分类" align="center" prop="categoryId"/>
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
          <el-table-column label="操作" width="180px" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['product:attr:edit']"
              >修改
              </el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['product:attr:remove']"
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

    <!-- 添加或修改商品属性对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入属性名"/>
        </el-form-item>
        <el-form-item label="类型" prop="icon">
          <el-select
            v-model="form.type"
            placeholder="属性类型"
            clearable
            size="small"
            style="width: 240px"
          >
            <el-option
              v-for="dict in dict.type.pms_attr_type"
              :key="parseInt(dict.value)"
              :label="dict.label"
              :value="parseInt(dict.value)"
            />
          </el-select>
        </el-form-item>


        <el-form-item label="分类" prop="categoryId">
          <treeselect v-model="form.categoryId" :options="categoryOptions" :show-count="true" placeholder="请选择所属分类"/>
        </el-form-item>

        <el-form-item label="值类型" prop="valueSelect">
          <el-radio-group v-model="form.valueType">
            <el-radio
              v-for="dict in dict.type.pms_attr_value_type"
              :key="parseInt(dict.value)"
              :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="可选值" prop="valueSelect" v-if="form.valueType==1">
          <el-input v-model="form.valueSelect" placeholder="请输入可选值[用逗号分隔]"/>
        </el-form-item>


        <el-form-item label="快速展示" prop="quickShow">
          <el-radio-group v-model="form.quickShow">
            <el-radio
              v-for="dict in dict.type.pms_attr_quick_show"
              :key="parseInt(dict.value)"
              :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>


        <el-form-item label="可检索" prop="searchType">
          <el-radio-group v-model="form.searchType">
            <el-radio
              v-for="dict in dict.type.pms_attr_search_type"
              :key="parseInt(dict.value)"
              :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>


        <el-form-item label="状态" prop="status">
          <el-switch
            v-model="form.status"
            :active-value="1"
            :inactive-value="0"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </el-form-item>

        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注"/>
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
import {addAttr, delAttr, getAttr, listAttr, updateAttr} from '@/api/product/attr'
import {changeUserStatus} from '@/api/system/user'
import Category from '@/views/components/product/Category'
import Treeselect from '@riophae/vue-treeselect'
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {treeselect} from '@/api/product/category'

export default {
  name: 'Attr',
  components: {Category, Treeselect},
  dicts: ['pms_attr_value_type', 'pms_attr_search_type', 'pms_attr_type', 'pms_attr_quick_show'],
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
    this.getList()
  },
  methods: {
    /** 查询商品属性列表 */
    getList() {
      this.loading = true
      listAttr(this.queryParams).then(response => {
        this.attrList = response.data.rows
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
        attrId: null,
        name: null,
        icon: null,
        valueSelect: null,
        valueType: null,
        searchType: null,
        type: null,
        status: 0,
        categoryId: null,
        quickShow: null,
        createBy: null,
        updateBy: null,
        createTime: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.attrId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.getTreeselect()
      this.reset()
      this.open = true
      this.title = '添加商品属性'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.getTreeselect()
      this.reset()
      const attrId = row.attrId || this.ids
      getAttr(attrId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改商品属性'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.attrId != null) {
            updateAttr(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addAttr(this.form).then(response => {
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
      const attrIds = row.attrId || this.ids
      this.$modal.confirm('是否确认删除商品属性编号为"' + attrIds + '"的数据项？').then(function () {
        return delAttr(attrIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/attr/export', {
        ...this.queryParams
      }, `attr_${new Date().getTime()}.xlsx`)
    },
    // wz-code
    // 用户状态修改
    handleStatusChange(row) {
      let text = row.status === '0' ? '启用' : '停用'
      this.$modal.confirm('确认要"' + text + '""' + row.userName + '"用户吗？').then(function () {
        return changeUserStatus(row.userId, row.status)
      }).then(() => {
        this.$modal.msgSuccess(text + '成功')
      }).catch(function () {
        row.status = row.status === '0' ? '1' : '0'
      })
    },
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
    /** 查询分类下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.categoryOptions = response.data
      })
    }

  }
}
</script>

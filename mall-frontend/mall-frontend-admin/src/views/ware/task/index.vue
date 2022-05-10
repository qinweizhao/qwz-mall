<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="order_id" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入order_id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="order_sn" prop="orderSn">
        <el-input
          v-model="queryParams.orderSn"
          placeholder="请输入order_sn"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货人" prop="consignee">
        <el-input
          v-model="queryParams.consignee"
          placeholder="请输入收货人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货人电话" prop="consigneeTel">
        <el-input
          v-model="queryParams.consigneeTel"
          placeholder="请输入收货人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单备注" prop="orderComment">
        <el-input
          v-model="queryParams.orderComment"
          placeholder="请输入订单备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款方式【 1:在线付款 2:货到付款】" prop="paymentWay">
        <el-input
          v-model="queryParams.paymentWay"
          placeholder="请输入付款方式【 1:在线付款 2:货到付款】"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单描述" prop="orderBody">
        <el-input
          v-model="queryParams.orderBody"
          placeholder="请输入订单描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流单号" prop="trackingNo">
        <el-input
          v-model="queryParams.trackingNo"
          placeholder="请输入物流单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库id" prop="wareId">
        <el-input
          v-model="queryParams.wareId"
          placeholder="请输入仓库id"
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
          v-hasPermi="['product:task:add']"
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
          v-hasPermi="['product:task:edit']"
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
          v-hasPermi="['product:task:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['product:task:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="taskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="order_id" align="center" prop="orderId" />
      <el-table-column label="order_sn" align="center" prop="orderSn" />
      <el-table-column label="收货人" align="center" prop="consignee" />
      <el-table-column label="收货人电话" align="center" prop="consigneeTel" />
      <el-table-column label="配送地址" align="center" prop="deliveryAddress" />
      <el-table-column label="订单备注" align="center" prop="orderComment" />
      <el-table-column label="付款方式【 1:在线付款 2:货到付款】" align="center" prop="paymentWay" />
      <el-table-column label="任务状态" align="center" prop="taskStatus" />
      <el-table-column label="订单描述" align="center" prop="orderBody" />
      <el-table-column label="物流单号" align="center" prop="trackingNo" />
      <el-table-column label="仓库id" align="center" prop="wareId" />
      <el-table-column label="工作单备注" align="center" prop="taskComment" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['product:task:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['product:task:remove']"
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

    <!-- 添加或修改库存工作单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="order_id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入order_id" />
        </el-form-item>
        <el-form-item label="order_sn" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入order_sn" />
        </el-form-item>
        <el-form-item label="收货人" prop="consignee">
          <el-input v-model="form.consignee" placeholder="请输入收货人" />
        </el-form-item>
        <el-form-item label="收货人电话" prop="consigneeTel">
          <el-input v-model="form.consigneeTel" placeholder="请输入收货人电话" />
        </el-form-item>
        <el-form-item label="配送地址" prop="deliveryAddress">
          <el-input v-model="form.deliveryAddress" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="订单备注" prop="orderComment">
          <el-input v-model="form.orderComment" placeholder="请输入订单备注" />
        </el-form-item>
        <el-form-item label="付款方式【 1:在线付款 2:货到付款】" prop="paymentWay">
          <el-input v-model="form.paymentWay" placeholder="请输入付款方式【 1:在线付款 2:货到付款】" />
        </el-form-item>
        <el-form-item label="订单描述" prop="orderBody">
          <el-input v-model="form.orderBody" placeholder="请输入订单描述" />
        </el-form-item>
        <el-form-item label="物流单号" prop="trackingNo">
          <el-input v-model="form.trackingNo" placeholder="请输入物流单号" />
        </el-form-item>
        <el-form-item label="仓库id" prop="wareId">
          <el-input v-model="form.wareId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="工作单备注" prop="taskComment">
          <el-input v-model="form.taskComment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
  import {addTask, delTask, getTask, listTask, updateTask} from "@/api/ware/task";

  export default {
  name: "Task",
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
      // 库存工作单表格数据
      taskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderId: null,
        orderSn: null,
        consignee: null,
        consigneeTel: null,
        deliveryAddress: null,
        orderComment: null,
        paymentWay: null,
        taskStatus: null,
        orderBody: null,
        trackingNo: null,
        wareId: null,
        taskComment: null,
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
    /** 查询库存工作单列表 */
    getList() {
      this.loading = true;
      listTask(this.queryParams).then(response => {
        this.taskList = response.rows;
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
        orderId: null,
        orderSn: null,
        consignee: null,
        consigneeTel: null,
        deliveryAddress: null,
        orderComment: null,
        paymentWay: null,
        taskStatus: 0,
        orderBody: null,
        trackingNo: null,
        wareId: null,
        taskComment: null,
        createBy: null,
        updateBy: null,
        createTime: null,
        updateTime: null,
        remark: null
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
      this.title = "添加库存工作单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTask(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改库存工作单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTask(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除库存工作单编号为"' + ids + '"的数据项？').then(function() {
        return delTask(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/task/export', {
        ...this.queryParams
      }, `task_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

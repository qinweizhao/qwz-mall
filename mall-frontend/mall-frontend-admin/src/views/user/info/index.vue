<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="会员id" prop="memberId">
        <el-input
          v-model="queryParams.memberId"
          placeholder="请输入会员id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="累计消费金额" prop="consumeAmount">
        <el-input
          v-model="queryParams.consumeAmount"
          placeholder="请输入累计消费金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="累计优惠金额" prop="couponAmount">
        <el-input
          v-model="queryParams.couponAmount"
          placeholder="请输入累计优惠金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单数量" prop="orderCount">
        <el-input
          v-model="queryParams.orderCount"
          placeholder="请输入订单数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="优惠券数量" prop="couponCount">
        <el-input
          v-model="queryParams.couponCount"
          placeholder="请输入优惠券数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评价数" prop="commentCount">
        <el-input
          v-model="queryParams.commentCount"
          placeholder="请输入评价数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货数量" prop="returnOrderCount">
        <el-input
          v-model="queryParams.returnOrderCount"
          placeholder="请输入退货数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="登录次数" prop="loginCount">
        <el-input
          v-model="queryParams.loginCount"
          placeholder="请输入登录次数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关注数量" prop="attendCount">
        <el-input
          v-model="queryParams.attendCount"
          placeholder="请输入关注数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="粉丝数量" prop="fansCount">
        <el-input
          v-model="queryParams.fansCount"
          placeholder="请输入粉丝数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收藏的商品数量" prop="collectProductCount">
        <el-input
          v-model="queryParams.collectProductCount"
          placeholder="请输入收藏的商品数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收藏的专题活动数量" prop="collectSubjectCount">
        <el-input
          v-model="queryParams.collectSubjectCount"
          placeholder="请输入收藏的专题活动数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收藏的评论数量" prop="collectCommentCount">
        <el-input
          v-model="queryParams.collectCommentCount"
          placeholder="请输入收藏的评论数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邀请的朋友数量" prop="inviteFriendCount">
        <el-input
          v-model="queryParams.inviteFriendCount"
          placeholder="请输入邀请的朋友数量"
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
          v-hasPermi="['product:info:add']"
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
          v-hasPermi="['product:info:edit']"
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
          v-hasPermi="['product:info:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['product:info:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="id" align="center" prop="id"/>
      <el-table-column label="会员id" align="center" prop="memberId"/>
      <el-table-column label="累计消费金额" align="center" prop="consumeAmount"/>
      <el-table-column label="累计优惠金额" align="center" prop="couponAmount"/>
      <el-table-column label="订单数量" align="center" prop="orderCount"/>
      <el-table-column label="优惠券数量" align="center" prop="couponCount"/>
      <el-table-column label="评价数" align="center" prop="commentCount"/>
      <el-table-column label="退货数量" align="center" prop="returnOrderCount"/>
      <el-table-column label="登录次数" align="center" prop="loginCount"/>
      <el-table-column label="关注数量" align="center" prop="attendCount"/>
      <el-table-column label="粉丝数量" align="center" prop="fansCount"/>
      <el-table-column label="收藏的商品数量" align="center" prop="collectProductCount"/>
      <el-table-column label="收藏的专题活动数量" align="center" prop="collectSubjectCount"/>
      <el-table-column label="收藏的评论数量" align="center" prop="collectCommentCount"/>
      <el-table-column label="邀请的朋友数量" align="center" prop="inviteFriendCount"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['product:info:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['product:info:remove']"
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

    <!-- 添加或修改会员统计信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="会员id" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员id"/>
        </el-form-item>
        <el-form-item label="累计消费金额" prop="consumeAmount">
          <el-input v-model="form.consumeAmount" placeholder="请输入累计消费金额"/>
        </el-form-item>
        <el-form-item label="累计优惠金额" prop="couponAmount">
          <el-input v-model="form.couponAmount" placeholder="请输入累计优惠金额"/>
        </el-form-item>
        <el-form-item label="订单数量" prop="orderCount">
          <el-input v-model="form.orderCount" placeholder="请输入订单数量"/>
        </el-form-item>
        <el-form-item label="优惠券数量" prop="couponCount">
          <el-input v-model="form.couponCount" placeholder="请输入优惠券数量"/>
        </el-form-item>
        <el-form-item label="评价数" prop="commentCount">
          <el-input v-model="form.commentCount" placeholder="请输入评价数"/>
        </el-form-item>
        <el-form-item label="退货数量" prop="returnOrderCount">
          <el-input v-model="form.returnOrderCount" placeholder="请输入退货数量"/>
        </el-form-item>
        <el-form-item label="登录次数" prop="loginCount">
          <el-input v-model="form.loginCount" placeholder="请输入登录次数"/>
        </el-form-item>
        <el-form-item label="关注数量" prop="attendCount">
          <el-input v-model="form.attendCount" placeholder="请输入关注数量"/>
        </el-form-item>
        <el-form-item label="粉丝数量" prop="fansCount">
          <el-input v-model="form.fansCount" placeholder="请输入粉丝数量"/>
        </el-form-item>
        <el-form-item label="收藏的商品数量" prop="collectProductCount">
          <el-input v-model="form.collectProductCount" placeholder="请输入收藏的商品数量"/>
        </el-form-item>
        <el-form-item label="收藏的专题活动数量" prop="collectSubjectCount">
          <el-input v-model="form.collectSubjectCount" placeholder="请输入收藏的专题活动数量"/>
        </el-form-item>
        <el-form-item label="收藏的评论数量" prop="collectCommentCount">
          <el-input v-model="form.collectCommentCount" placeholder="请输入收藏的评论数量"/>
        </el-form-item>
        <el-form-item label="邀请的朋友数量" prop="inviteFriendCount">
          <el-input v-model="form.inviteFriendCount" placeholder="请输入邀请的朋友数量"/>
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
import {addInfo, delInfo, getInfo, listInfo, updateInfo} from "@/api/user/info";

export default {
  name: "Info",
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
      // 会员统计信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
        consumeAmount: null,
        couponAmount: null,
        orderCount: null,
        couponCount: null,
        commentCount: null,
        returnOrderCount: null,
        loginCount: null,
        attendCount: null,
        fansCount: null,
        collectProductCount: null,
        collectSubjectCount: null,
        collectCommentCount: null,
        inviteFriendCount: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询会员统计信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
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
        memberId: null,
        consumeAmount: null,
        couponAmount: null,
        orderCount: null,
        couponCount: null,
        commentCount: null,
        returnOrderCount: null,
        loginCount: null,
        attendCount: null,
        fansCount: null,
        collectProductCount: null,
        collectSubjectCount: null,
        collectCommentCount: null,
        inviteFriendCount: null
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
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加会员统计信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员统计信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除会员统计信息编号为"' + ids + '"的数据项？').then(function () {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

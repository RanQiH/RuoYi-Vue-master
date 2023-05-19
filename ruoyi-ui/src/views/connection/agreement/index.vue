<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="合同类别" prop="type">
        <el-input
          v-model="queryParams.type"
          placeholder="请输入合同类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同金额" prop="sum">
        <el-input
          v-model="queryParams.sum"
          placeholder="请输入合同金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签订日期" prop="singDate">
        <el-input
          v-model="queryParams.singDate"
          placeholder="请输入签订日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供货期开始" prop="startTime">
        <el-input
          v-model="queryParams.startTime"
          placeholder="请输入供货期开始"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供货期结束" prop="endTime">
        <el-input
          v-model="queryParams.endTime"
          placeholder="请输入供货期结束"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户名称" prop="connectName">
        <el-input
          v-model="queryParams.connectName"
          placeholder="请输入客户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="委托人员" prop="entrustPerson">
        <el-input
          v-model="queryParams.entrustPerson"
          placeholder="请输入委托人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式" prop="entrustContactInformation">
        <el-input
          v-model="queryParams.entrustContactInformation"
          placeholder="请输入联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程名称" prop="engineerName">
        <el-input
          v-model="queryParams.engineerName"
          placeholder="请输入工程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="建设单位" prop="constructionUnit">
        <el-input
          v-model="queryParams.constructionUnit"
          placeholder="请输入建设单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="施工地址" prop="constructionAddress">
        <el-input
          v-model="queryParams.constructionAddress"
          placeholder="请输入施工地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运输距离" prop="transportationDistance">
        <el-input
          v-model="queryParams.transportationDistance"
          placeholder="请输入运输距离"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="浇筑方量" prop="pouringVolume">
        <el-input
          v-model="queryParams.pouringVolume"
          placeholder="请输入浇筑方量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品定价依据" prop="productPriceBasis">
        <el-input
          v-model="queryParams.productPriceBasis"
          placeholder="请输入产品定价依据"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品定价" prop="productPrice">
        <el-input
          v-model="queryParams.productPrice"
          placeholder="请输入产品定价"
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
          v-hasPermi="['connection:agreement:add']"
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
          v-hasPermi="['connection:agreement:edit']"
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
          v-hasPermi="['connection:agreement:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['connection:agreement:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="agreementList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="合同编号" align="center" prop="id" />
      <el-table-column label="合同类别" align="center" prop="type" />
      <el-table-column label="签订日期" align="center" prop="singDate" />
      <el-table-column label="客户名称" align="center" prop="connectName" />
      <el-table-column label="工程名称" align="center" prop="engineerName" />
      <el-table-column label="交货地址" align="center" prop="constructionAddress" />
      <el-table-column label="运输距离" align="center" prop="transportationDistance" />
      <el-table-column label="供货期开始" align="center" prop="startTime" />
      <el-table-column label="结算单位" align="center" prop="settlementUnit" />
      <el-table-column label="业务员" align="center" prop="saleman" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['connection:agreement:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['connection:agreement:remove']"
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

    <!-- 添加或修改agreement对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合同类别" prop="type">
          <el-input v-model="form.type" placeholder="请输入合同类别" />
        </el-form-item>
        <el-form-item label="合同金额" prop="sum">
          <el-input v-model="form.sum" placeholder="请输入合同金额" />
        </el-form-item>
        <el-form-item label="签订日期" prop="singDate">
          <el-input v-model="form.singDate" placeholder="请输入签订日期" />
        </el-form-item>
        <el-form-item label="供货期开始" prop="startTime">
          <el-input v-model="form.startTime" placeholder="请输入供货期开始" />
        </el-form-item>
        <el-form-item label="供货期结束" prop="endTime">
          <el-input v-model="form.endTime" placeholder="请输入供货期结束" />
        </el-form-item>
        <el-form-item label="客户名称" prop="connectName">
          <el-input v-model="form.connectName" placeholder="请输入客户名称" />
        </el-form-item>
        <el-form-item label="委托人员" prop="entrustPerson">
          <el-input v-model="form.entrustPerson" placeholder="请输入委托人员" />
        </el-form-item>
        <el-form-item label="联系方式" prop="entrustContactInformation">
          <el-input v-model="form.entrustContactInformation" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="工程名称" prop="engineerName">
          <el-input v-model="form.engineerName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="建设单位" prop="constructionUnit">
          <el-input v-model="form.constructionUnit" placeholder="请输入建设单位" />
        </el-form-item>
        <el-form-item label="施工地址" prop="constructionAddress">
          <el-input v-model="form.constructionAddress" placeholder="请输入施工地址" />
        </el-form-item>
        <el-form-item label="运输距离" prop="transportationDistance">
          <el-input v-model="form.transportationDistance" placeholder="请输入运输距离" />
        </el-form-item>
        <el-form-item label="浇筑方量" prop="pouringVolume">
          <el-input v-model="form.pouringVolume" placeholder="请输入浇筑方量" />
        </el-form-item>
        <el-form-item label="产品定价依据" prop="productPriceBasis">
          <el-input v-model="form.productPriceBasis" placeholder="请输入产品定价依据" />
        </el-form-item>
        <el-form-item label="产品定价" prop="productPrice">
          <el-input v-model="form.productPrice" placeholder="请输入产品定价" />
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
import { listAgreement, getAgreement, delAgreement, addAgreement, updateAgreement } from "@/api/connection/agreement";

export default {
  name: "Agreement",
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
      // agreement表格数据
      agreementList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        sum: null,
        singDate: null,
        startTime: null,
        endTime: null,
        connectName: null,
        entrustPerson: null,
        entrustContactInformation: null,
        engineerName: null,
        constructionUnit: null,
        constructionAddress: null,
        transportationDistance: null,
        pouringVolume: null,
        productPriceBasis: null,
        productPrice: null,
        freightAgreement: null,
        settlementUnit: null,
        contacts: null,
        saleContactInformation: null,
        saleman: null,
        freightUnitPrice: null,
        remarks: null,
        creator: null,
        tenantId: null
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
    /** 查询agreement列表 */
    getList() {
      this.loading = true;
      listAgreement(this.queryParams).then(response => {
        this.agreementList = response.rows;
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
        type: null,
        sum: null,
        singDate: null,
        startTime: null,
        endTime: null,
        connectName: null,
        entrustPerson: null,
        entrustContactInformation: null,
        engineerName: null,
        constructionUnit: null,
        constructionAddress: null,
        transportationDistance: null,
        pouringVolume: null,
        productPriceBasis: null,
        productPrice: null,
        freightAgreement: "0",
        settlementUnit: "0",
        contacts: "0",
        saleContactInformation: "0",
        saleman: "0",
        freightUnitPrice: "0",
        remarks: "0",
        creator: "0",
        tenantId: 0
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
      this.title = "添加agreement";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAgreement(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改agreement";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAgreement(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAgreement(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除agreement编号为"' + ids + '"的数据项？').then(function() {
        return delAgreement(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('connection/agreement/export', {
        ...this.queryParams
      }, `agreement_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

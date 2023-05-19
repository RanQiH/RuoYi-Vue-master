<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="工程名称" prop="engineerName">
        <el-select v-model="queryParams.engineerName" placeholder="选择工程名称">
          <el-option
            v-for="item in engineerNames"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="工程地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入工程地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户名称" prop="connectName">
        <el-select v-model="queryParams.connectName" placeholder="选择客户名称">
          <el-option
            v-for="item in connectNames"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
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
          v-hasPermi="['connection:engineer:add']"
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
          v-hasPermi="['connection:engineer:edit']"
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
          v-hasPermi="['connection:engineer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['connection:engineer:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="engineerList" @selection-change="handleSelectionChange" @row-dblclick="handleUpdate">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工程名称" align="center" prop="engineerName" />
      <el-table-column label="客户名称" align="center" prop="connectName" />
      <el-table-column label="工程地址" align="center" prop="address" />
      <el-table-column label="运输距离" align="center" prop="distance" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['connection:engineer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['connection:engineer:remove']"
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

    <!-- 添加或修改engineer对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" size="medium" label-width="79px">
          <el-col :span="16">
            <el-form-item label="工程名称" prop="engineerName">
              <el-input v-model="form.engineerName" placeholder="输入工程名称" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="工程进度" prop="progress">
              <el-input v-model="form.progress" placeholder="输入工程进度" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="工程类别" prop="type">
              <el-input v-model="form.type" placeholder="输入工程类别" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="工程级别" prop="rank">
              <el-select v-model="form.rank" placeholder="选择工程名称">
                <el-option
                  v-for="item in ranks"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="浇筑方量" prop="pouringVolume">
              <el-input-number v-model="form.pouringVolume" placeholder="m3" controls-position=right>
              </el-input-number>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="工程地址" prop="address">
              <el-input v-model="form.address" placeholder="输入工程地址" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="运输距离" prop="distance">
              <el-input-number v-model="form.distance" placeholder="km" controls-position=right>
              </el-input-number>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="建设单位" prop="constructionUnit">
              <el-input v-model="form.constructionUnit" placeholder="输入建设单位" clearable
                        :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预计开工时间" prop="startTime">
              <el-date-picker v-model="form.startTime" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                              :style="{width: '100%'}" placeholder="选择预计开工时间" clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户名称" prop="connectName">
              <el-select v-model="form.connectName" placeholder="选择客户名称" clearable :style="{width: '100%'}">
                  <el-option
                    v-for="item in connectNames"
                    :key="item"
                    :label="item"
                    :value="item">
                  </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预计竣工时间" prop="endTime">
              <el-date-picker v-model="form.endTime" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                              :style="{width: '100%'}" placeholder="选择预计竣工时间" clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系人" prop="contactName">
              <el-input v-model="form.contactName" placeholder="输入联系人" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系电话" prop="contactPhone">
              <el-input v-model="form.contactPhone" placeholder="输入联系电话" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remarks">
              <el-input v-model="form.remarks" placeholder="输入备注" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listEngineer,
  getEngineer,
  delEngineer,
  addEngineer,
  updateEngineer,
  listConnectionNames,
  listEngineerNames
} from "@/api/connection/engineer";

export default {
  name: "Engineer",
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
      // engineer表格数据
      engineerList: [],
      //所有工程名
      engineerNames:[],
      //所有客户名
      connectNames:[],
      //工程级别
      ranks:['低','中','高'],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        engineerName: null,
        type: null,
        rank: null,
        address: null,
        progress: null,
        pouringVolume: null,
        distance: null,
        constructionUnit: null,
        startTime: null,
        endTime: null,
        connectName: null,
        contactName: null,
        contactPhone: null,
        remarks: null,
        tenantId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        engineerName: [
          { required: true, message: "工程名称不能为空", trigger: "blur" }
        ],
        constructionUnit: [
          { required: true, message: "建设单位不能为空", trigger: "blur" },
        ],
        contactName: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        contactPhone: [
          { required: true, message: "联系电话不能为空", trigger: "blur" },
          { min: 8, max: 11, message: '长度在 8 到 11个字符' }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.findConnectionNames();
  },
  methods: {
    /** 查询engineer列表 */
    getList() {
      this.loading = true;
      listEngineer(this.queryParams).then(response => {
        this.engineerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      this.queryParams.engineerName=null;
      this.queryParams.address=null;
      this.queryParams.connectName=null;
      this.findEngineerNames();
    },
    findConnectionNames(){
      listConnectionNames().then(
        response=>{
          this.connectNames=response;
        }
      )
    },
    findEngineerNames(){
      listEngineerNames().then(
        response=>{
          this.engineerNames=response;
        }
      )
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
        engineerName: null,
        type: null,
        rank: null,
        address: null,
        progress: null,
        pouringVolume: null,
        distance: null,
        constructionUnit: null,
        startTime: null,
        endTime: null,
        connectName: null,
        contactName: null,
        contactPhone: null,
        remarks: null,
        tenantId: null
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
      this.title = "添加工程";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEngineer(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工程";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEngineer(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEngineer(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除engineer编号为"' + ids + '"的数据项？').then(function() {
        return delEngineer(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('connection/engineer/export', {
        ...this.queryParams
      }, `engineer_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

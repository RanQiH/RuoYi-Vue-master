package com.ruoyi.web.controller.sale;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;

import com.ruoyi.sale.domain.SaleConnection;
import com.ruoyi.sale.service.ISaleConnectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * connectionController
 * 
 * @author LyingY
 * @date 2023-05-15
 */
@RestController
@RequestMapping("/connection/connection")
public class SaleConnectionController extends BaseController
{
    @Autowired
    private ISaleConnectionService saleConnectionService;

    /**
     * 查询connection列表
     */
    @PreAuthorize("@ss.hasPermi('connection:connection:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleConnection saleConnection)
    {
        startPage();
        List<SaleConnection> list = saleConnectionService.selectSaleConnectionList(saleConnection);
        return getDataTable(list);
    }

    /**
     * 导出connection列表
     */
    @PreAuthorize("@ss.hasPermi('connection:connection:export')")
    @Log(title = "connection", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SaleConnection saleConnection)
    {
        List<SaleConnection> list = saleConnectionService.selectSaleConnectionList(saleConnection);
        ExcelUtil<SaleConnection> util = new ExcelUtil<SaleConnection>(SaleConnection.class);
        util.exportExcel(response, list, "connection数据");
    }

    /**
     * 获取connection详细信息
     */
    @PreAuthorize("@ss.hasPermi('connection:connection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(saleConnectionService.selectSaleConnectionById(id));
    }

    /**
     * 新增connection
     */
    @PreAuthorize("@ss.hasPermi('connection:connection:add')")
    @Log(title = "connection", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SaleConnection saleConnection)
    {
        return toAjax(saleConnectionService.insertSaleConnection(saleConnection));
    }

    /**
     * 修改connection
     */
    @PreAuthorize("@ss.hasPermi('connection:connection:edit')")
    @Log(title = "connection", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SaleConnection saleConnection)
    {
        return toAjax(saleConnectionService.updateSaleConnection(saleConnection));
    }

    /**
     * 删除connection
     */
    @PreAuthorize("@ss.hasPermi('connection:connection:remove')")
    @Log(title = "connection", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(saleConnectionService.deleteSaleConnectionByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('connection:connection:list')")
    @ApiOperation("查询所有业务员")
    @GetMapping("/findSalemans")
    public List findSalesMans(){
        return saleConnectionService.findSalesMans();
    }
}

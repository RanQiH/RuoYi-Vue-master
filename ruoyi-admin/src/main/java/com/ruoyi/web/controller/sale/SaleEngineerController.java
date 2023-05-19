package com.ruoyi.web.controller.sale;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.sale.domain.SaleEngineer;
import com.ruoyi.sale.service.ISaleEngineerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * engineerController
 * 
 * @author ruoyi
 * @date 2023-05-16
 */
@RestController
@RequestMapping("/connection/engineer")
public class SaleEngineerController extends BaseController
{
    @Autowired
    private ISaleEngineerService saleEngineerService;

    /**
     * 查询engineer列表
     */
    @PreAuthorize("@ss.hasPermi('connection:engineer:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleEngineer saleEngineer)
    {
        startPage();
        List<SaleEngineer> list = saleEngineerService.selectSaleEngineerList(saleEngineer);
        return getDataTable(list);
    }

    /**
     * 导出engineer列表
     */
    @PreAuthorize("@ss.hasPermi('connection:engineer:export')")
    @Log(title = "engineer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SaleEngineer saleEngineer)
    {
        List<SaleEngineer> list = saleEngineerService.selectSaleEngineerList(saleEngineer);
        ExcelUtil<SaleEngineer> util = new ExcelUtil<SaleEngineer>(SaleEngineer.class);
        util.exportExcel(response, list, "engineer数据");
    }

    /**
     * 获取engineer详细信息
     */
    @PreAuthorize("@ss.hasPermi('connection:engineer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(saleEngineerService.selectSaleEngineerById(id));
    }

    /**
     * 新增engineer
     */
    @PreAuthorize("@ss.hasPermi('connection:engineer:add')")
    @Log(title = "engineer", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SaleEngineer saleEngineer)
    {
        return toAjax(saleEngineerService.insertSaleEngineer(saleEngineer));
    }

    /**
     * 修改engineer
     */
    @PreAuthorize("@ss.hasPermi('connection:engineer:edit')")
    @Log(title = "engineer", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SaleEngineer saleEngineer)
    {
        return toAjax(saleEngineerService.updateSaleEngineer(saleEngineer));
    }

    /**
     * 删除engineer
     */
    @PreAuthorize("@ss.hasPermi('connection:engineer:remove')")
    @Log(title = "engineer", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(saleEngineerService.deleteSaleEngineerByIds(ids));
    }
    //查询所有客户名
    @PreAuthorize("@ss.hasPermi('connection:engineer:list')")
    @ApiOperation("查询所有客户名称")
    @GetMapping("/findConnectionNames")
    public List findConnectionNames(){
        return saleEngineerService.findConnectionNames();
    }

    @PreAuthorize("@ss.hasPermi('connection:engineer:list')")
    @ApiOperation("查询所有工程名称")
    @GetMapping("/findEngineerNames")
    public List findEngineerNames(){
        return saleEngineerService.findEngineerNames();
    }
}

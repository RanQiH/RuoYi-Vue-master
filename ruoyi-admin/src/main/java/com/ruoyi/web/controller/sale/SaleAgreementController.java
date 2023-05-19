package com.ruoyi.web.controller.sale;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sale.domain.SaleAgreement;
import com.ruoyi.sale.service.ISaleAgreementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * agreementController
 * 
 * @author LyingY
 * @date 2023-05-17
 */
@RestController
@RequestMapping("/connection/agreement")
public class SaleAgreementController extends BaseController
{
    @Autowired
    private ISaleAgreementService saleAgreementService;

    /**
     * 查询agreement列表
     */
    @PreAuthorize("@ss.hasPermi('connection:agreement:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleAgreement saleAgreement)
    {
        startPage();
        List<SaleAgreement> list = saleAgreementService.selectSaleAgreementList(saleAgreement);
        return getDataTable(list);
    }

    /**
     * 导出agreement列表
     */
    @PreAuthorize("@ss.hasPermi('connection:agreement:export')")
    @Log(title = "agreement", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SaleAgreement saleAgreement)
    {
        List<SaleAgreement> list = saleAgreementService.selectSaleAgreementList(saleAgreement);
        ExcelUtil<SaleAgreement> util = new ExcelUtil<SaleAgreement>(SaleAgreement.class);
        util.exportExcel(response, list, "agreement数据");
    }

    /**
     * 获取agreement详细信息
     */
    @PreAuthorize("@ss.hasPermi('connection:agreement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(saleAgreementService.selectSaleAgreementById(id));
    }

    /**
     * 新增agreement
     */
    @PreAuthorize("@ss.hasPermi('connection:agreement:add')")
    @Log(title = "agreement", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SaleAgreement saleAgreement)
    {
        return toAjax(saleAgreementService.insertSaleAgreement(saleAgreement));
    }

    /**
     * 修改agreement
     */
    @PreAuthorize("@ss.hasPermi('connection:agreement:edit')")
    @Log(title = "agreement", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SaleAgreement saleAgreement)
    {
        return toAjax(saleAgreementService.updateSaleAgreement(saleAgreement));
    }

    /**
     * 删除agreement
     */
    @PreAuthorize("@ss.hasPermi('connection:agreement:remove')")
    @Log(title = "agreement", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(saleAgreementService.deleteSaleAgreementByIds(ids));
    }
}

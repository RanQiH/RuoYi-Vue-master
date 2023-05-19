package com.ruoyi.sale.mapper;

import java.util.List;
import com.ruoyi.sale.domain.SaleAgreement;

/**
 * agreementMapper接口
 * 
 * @author LyingY
 * @date 2023-05-17
 */
public interface SaleAgreementMapper 
{
    /**
     * 查询agreement
     * 
     * @param id agreement主键
     * @return agreement
     */
    public SaleAgreement selectSaleAgreementById(Long id);

    /**
     * 查询agreement列表
     * 
     * @param saleAgreement agreement
     * @return agreement集合
     */
    public List<SaleAgreement> selectSaleAgreementList(SaleAgreement saleAgreement);

    /**
     * 新增agreement
     * 
     * @param saleAgreement agreement
     * @return 结果
     */
    public int insertSaleAgreement(SaleAgreement saleAgreement);

    /**
     * 修改agreement
     * 
     * @param saleAgreement agreement
     * @return 结果
     */
    public int updateSaleAgreement(SaleAgreement saleAgreement);

    /**
     * 删除agreement
     * 
     * @param id agreement主键
     * @return 结果
     */
    public int deleteSaleAgreementById(Long id);

    /**
     * 批量删除agreement
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSaleAgreementByIds(Long[] ids);
}

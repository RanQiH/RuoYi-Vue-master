package com.ruoyi.sale.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sale.mapper.SaleAgreementMapper;
import com.ruoyi.sale.domain.SaleAgreement;
import com.ruoyi.sale.service.ISaleAgreementService;

/**
 * agreementService业务层处理
 * 
 * @author LyingY
 * @date 2023-05-17
 */
@Service
public class SaleAgreementServiceImpl implements ISaleAgreementService 
{
    @Autowired
    private SaleAgreementMapper saleAgreementMapper;

    /**
     * 查询agreement
     * 
     * @param id agreement主键
     * @return agreement
     */
    @Override
    public SaleAgreement selectSaleAgreementById(Long id)
    {
        return saleAgreementMapper.selectSaleAgreementById(id);
    }

    /**
     * 查询agreement列表
     * 
     * @param saleAgreement agreement
     * @return agreement
     */
    @Override
    public List<SaleAgreement> selectSaleAgreementList(SaleAgreement saleAgreement)
    {
        return saleAgreementMapper.selectSaleAgreementList(saleAgreement);
    }

    /**
     * 新增agreement
     * 
     * @param saleAgreement agreement
     * @return 结果
     */
    @Override
    public int insertSaleAgreement(SaleAgreement saleAgreement)
    {
        return saleAgreementMapper.insertSaleAgreement(saleAgreement);
    }

    /**
     * 修改agreement
     * 
     * @param saleAgreement agreement
     * @return 结果
     */
    @Override
    public int updateSaleAgreement(SaleAgreement saleAgreement)
    {
        return saleAgreementMapper.updateSaleAgreement(saleAgreement);
    }

    /**
     * 批量删除agreement
     * 
     * @param ids 需要删除的agreement主键
     * @return 结果
     */
    @Override
    public int deleteSaleAgreementByIds(Long[] ids)
    {
        return saleAgreementMapper.deleteSaleAgreementByIds(ids);
    }

    /**
     * 删除agreement信息
     * 
     * @param id agreement主键
     * @return 结果
     */
    @Override
    public int deleteSaleAgreementById(Long id)
    {
        return saleAgreementMapper.deleteSaleAgreementById(id);
    }
}

package com.ruoyi.sale.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sale.mapper.SaleEngineerMapper;
import com.ruoyi.sale.domain.SaleEngineer;
import com.ruoyi.sale.service.ISaleEngineerService;

/**
 * engineerService业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-16
 */
@Service
public class SaleEngineerServiceImpl implements ISaleEngineerService 
{
    @Autowired
    private SaleEngineerMapper saleEngineerMapper;

    /**
     * 查询engineer
     * 
     * @param id engineer主键
     * @return engineer
     */
    @Override
    public SaleEngineer selectSaleEngineerById(Long id)
    {
        return saleEngineerMapper.selectSaleEngineerById(id);
    }

    /**
     * 查询engineer列表
     * 
     * @param saleEngineer engineer
     * @return engineer
     */
    @Override
    public List<SaleEngineer> selectSaleEngineerList(SaleEngineer saleEngineer)
    {
        return saleEngineerMapper.selectSaleEngineerList(saleEngineer);
    }

    /**
     * 新增engineer
     * 
     * @param saleEngineer engineer
     * @return 结果
     */
    @Override
    public int insertSaleEngineer(SaleEngineer saleEngineer)
    {
        return saleEngineerMapper.insertSaleEngineer(saleEngineer);
    }

    /**
     * 修改engineer
     * 
     * @param saleEngineer engineer
     * @return 结果
     */
    @Override
    public int updateSaleEngineer(SaleEngineer saleEngineer)
    {
        return saleEngineerMapper.updateSaleEngineer(saleEngineer);
    }

    /**
     * 批量删除engineer
     * 
     * @param ids 需要删除的engineer主键
     * @return 结果
     */
    @Override
    public int deleteSaleEngineerByIds(Long[] ids)
    {
        return saleEngineerMapper.deleteSaleEngineerByIds(ids);
    }

    /**
     * 删除engineer信息
     * 
     * @param id engineer主键
     * @return 结果
     */
    @Override
    public int deleteSaleEngineerById(Long id)
    {
        return saleEngineerMapper.deleteSaleEngineerById(id);
    }

    @Override
    public List<String> findConnectionNames() {
        return saleEngineerMapper.findConnectionNames();
    }

    @Override
    public List<String> findEngineerNames() {
        return saleEngineerMapper.findEngineerNames();
    }
}

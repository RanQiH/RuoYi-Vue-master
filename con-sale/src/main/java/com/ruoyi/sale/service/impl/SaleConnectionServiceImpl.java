package com.ruoyi.sale.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sale.mapper.SaleConnectionMapper;
import com.ruoyi.sale.domain.SaleConnection;
import com.ruoyi.sale.service.ISaleConnectionService;

/**
 * connectionService业务层处理
 * 
 * @author LyingY
 * @date 2023-05-15
 */
@Service
public class SaleConnectionServiceImpl implements ISaleConnectionService 
{
    @Autowired
    private SaleConnectionMapper saleConnectionMapper;

    /**
     * 查询connection
     * 
     * @param id connection主键
     * @return connection
     */
    @Override
    public SaleConnection selectSaleConnectionById(Long id)
    {
        return saleConnectionMapper.selectSaleConnectionById(id);
    }

    /**
     * 查询connection列表
     * 
     * @param saleConnection connection
     * @return connection
     */
    @Override
    public List<SaleConnection> selectSaleConnectionList(SaleConnection saleConnection)
    {
        return saleConnectionMapper.selectSaleConnectionList(saleConnection);
    }

    /**
     * 新增connection
     * 
     * @param saleConnection connection
     * @return 结果
     */
    @Override
    public int insertSaleConnection(SaleConnection saleConnection)
    {
        return saleConnectionMapper.insertSaleConnection(saleConnection);
    }

    /**
     * 修改connection
     * 
     * @param saleConnection connection
     * @return 结果
     */
    @Override
    public int updateSaleConnection(SaleConnection saleConnection)
    {
        return saleConnectionMapper.updateSaleConnection(saleConnection);
    }

    /**
     * 批量删除connection
     * 
     * @param ids 需要删除的connection主键
     * @return 结果
     */
    @Override
    public int deleteSaleConnectionByIds(Long[] ids)
    {
        return saleConnectionMapper.deleteSaleConnectionByIds(ids);
    }

    /**
     * 删除connection信息
     * 
     * @param id connection主键
     * @return 结果
     */
    @Override
    public int deleteSaleConnectionById(Long id)
    {
        return saleConnectionMapper.deleteSaleConnectionById(id);
    }

    @Override
    public List <String>findSalesMans() {
        return saleConnectionMapper.findSalesMans();
    }
}

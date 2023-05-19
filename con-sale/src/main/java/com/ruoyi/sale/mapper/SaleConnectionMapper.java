package com.ruoyi.sale.mapper;

import java.util.List;
import com.ruoyi.sale.domain.SaleConnection;

/**
 * connectionMapper接口
 * 
 * @author LyingY
 * @date 2023-05-15
 */
public interface SaleConnectionMapper 
{
    /**
     * 查询connection
     * 
     * @param id connection主键
     * @return connection
     */
    public SaleConnection selectSaleConnectionById(Long id);

    /**
     * 查询connection列表
     * 
     * @param saleConnection connection
     * @return connection集合
     */
    public List<SaleConnection> selectSaleConnectionList(SaleConnection saleConnection);

    /**
     * 新增connection
     * 
     * @param saleConnection connection
     * @return 结果
     */
    public int insertSaleConnection(SaleConnection saleConnection);

    /**
     * 修改connection
     * 
     * @param saleConnection connection
     * @return 结果
     */
    public int updateSaleConnection(SaleConnection saleConnection);

    /**
     * 删除connection
     * 
     * @param id connection主键
     * @return 结果
     */
    public int deleteSaleConnectionById(Long id);

    /**
     * 批量删除connection
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSaleConnectionByIds(Long[] ids);

    List <String>findSalesMans();
}

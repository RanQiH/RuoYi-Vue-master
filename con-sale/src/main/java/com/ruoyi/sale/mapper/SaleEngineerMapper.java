package com.ruoyi.sale.mapper;

import java.util.List;
import com.ruoyi.sale.domain.SaleEngineer;

/**
 * engineerMapper接口
 * 
 * @author ruoyi
 * @date 2023-05-16
 */
public interface SaleEngineerMapper 
{
    /**
     * 查询engineer
     * 
     * @param id engineer主键
     * @return engineer
     */
    public SaleEngineer selectSaleEngineerById(Long id);

    /**
     * 查询engineer列表
     * 
     * @param saleEngineer engineer
     * @return engineer集合
     */
    public List<SaleEngineer> selectSaleEngineerList(SaleEngineer saleEngineer);

    /**
     * 新增engineer
     * 
     * @param saleEngineer engineer
     * @return 结果
     */
    public int insertSaleEngineer(SaleEngineer saleEngineer);

    /**
     * 修改engineer
     * 
     * @param saleEngineer engineer
     * @return 结果
     */
    public int updateSaleEngineer(SaleEngineer saleEngineer);

    /**
     * 删除engineer
     * 
     * @param id engineer主键
     * @return 结果
     */
    public int deleteSaleEngineerById(Long id);

    /**
     * 批量删除engineer
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSaleEngineerByIds(Long[] ids);
    List<String> findConnectionNames();
    List<String> findEngineerNames();
}

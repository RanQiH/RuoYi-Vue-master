package com.ruoyi.sale.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * agreement对象 sale_agreement
 * 
 * @author LyingY
 * @date 2023-05-17
 */
public class SaleAgreement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同编号 */
    private Long id;

    /** 合同类别 */
    @Excel(name = "合同类别")
    private String type;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private String sum;

    /** 签订日期 */
    @Excel(name = "签订日期")
    private String singDate;

    /** 供货期开始 */
    @Excel(name = "供货期开始")
    private String startTime;

    /** 供货期结束 */
    @Excel(name = "供货期结束")
    private String endTime;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String connectName;

    /** 委托人员 */
    @Excel(name = "委托人员")
    private String entrustPerson;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String entrustContactInformation;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String engineerName;

    /** 建设单位 */
    @Excel(name = "建设单位")
    private String constructionUnit;

    /** 施工地址 */
    @Excel(name = "施工地址")
    private String constructionAddress;

    /** 运输距离 */
    @Excel(name = "运输距离")
    private Long transportationDistance;

    /** 浇筑方量 */
    @Excel(name = "浇筑方量")
    private String pouringVolume;

    /** 产品定价依据 */
    @Excel(name = "产品定价依据")
    private String productPriceBasis;

    /** 产品定价 */
    @Excel(name = "产品定价")
    private String productPrice;

    /** 运费约定 */
    @Excel(name = "运费约定")
    private String freightAgreement;

    /** 结算单位 */
    @Excel(name = "结算单位")
    private String settlementUnit;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String saleContactInformation;

    /** 业务员 */
    @Excel(name = "业务员")
    private String saleman;

    /** 运费单价 */
    @Excel(name = "运费单价")
    private String freightUnitPrice;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 制单人 */
    @Excel(name = "制单人")
    private String creator;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long tenantId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSum(String sum) 
    {
        this.sum = sum;
    }

    public String getSum() 
    {
        return sum;
    }
    public void setSingDate(String singDate) 
    {
        this.singDate = singDate;
    }

    public String getSingDate() 
    {
        return singDate;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setConnectName(String connectName) 
    {
        this.connectName = connectName;
    }

    public String getConnectName() 
    {
        return connectName;
    }
    public void setEntrustPerson(String entrustPerson) 
    {
        this.entrustPerson = entrustPerson;
    }

    public String getEntrustPerson() 
    {
        return entrustPerson;
    }
    public void setEntrustContactInformation(String entrustContactInformation) 
    {
        this.entrustContactInformation = entrustContactInformation;
    }

    public String getEntrustContactInformation() 
    {
        return entrustContactInformation;
    }
    public void setEngineerName(String engineerName) 
    {
        this.engineerName = engineerName;
    }

    public String getEngineerName() 
    {
        return engineerName;
    }
    public void setConstructionUnit(String constructionUnit) 
    {
        this.constructionUnit = constructionUnit;
    }

    public String getConstructionUnit() 
    {
        return constructionUnit;
    }
    public void setConstructionAddress(String constructionAddress) 
    {
        this.constructionAddress = constructionAddress;
    }

    public String getConstructionAddress() 
    {
        return constructionAddress;
    }
    public void setTransportationDistance(Long transportationDistance) 
    {
        this.transportationDistance = transportationDistance;
    }

    public Long getTransportationDistance() 
    {
        return transportationDistance;
    }
    public void setPouringVolume(String pouringVolume) 
    {
        this.pouringVolume = pouringVolume;
    }

    public String getPouringVolume() 
    {
        return pouringVolume;
    }
    public void setProductPriceBasis(String productPriceBasis) 
    {
        this.productPriceBasis = productPriceBasis;
    }

    public String getProductPriceBasis() 
    {
        return productPriceBasis;
    }
    public void setProductPrice(String productPrice) 
    {
        this.productPrice = productPrice;
    }

    public String getProductPrice() 
    {
        return productPrice;
    }
    public void setFreightAgreement(String freightAgreement) 
    {
        this.freightAgreement = freightAgreement;
    }

    public String getFreightAgreement() 
    {
        return freightAgreement;
    }
    public void setSettlementUnit(String settlementUnit) 
    {
        this.settlementUnit = settlementUnit;
    }

    public String getSettlementUnit() 
    {
        return settlementUnit;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setSaleContactInformation(String saleContactInformation) 
    {
        this.saleContactInformation = saleContactInformation;
    }

    public String getSaleContactInformation() 
    {
        return saleContactInformation;
    }
    public void setSaleman(String saleman) 
    {
        this.saleman = saleman;
    }

    public String getSaleman() 
    {
        return saleman;
    }
    public void setFreightUnitPrice(String freightUnitPrice) 
    {
        this.freightUnitPrice = freightUnitPrice;
    }

    public String getFreightUnitPrice() 
    {
        return freightUnitPrice;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("sum", getSum())
            .append("singDate", getSingDate())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("connectName", getConnectName())
            .append("entrustPerson", getEntrustPerson())
            .append("entrustContactInformation", getEntrustContactInformation())
            .append("engineerName", getEngineerName())
            .append("constructionUnit", getConstructionUnit())
            .append("constructionAddress", getConstructionAddress())
            .append("transportationDistance", getTransportationDistance())
            .append("pouringVolume", getPouringVolume())
            .append("productPriceBasis", getProductPriceBasis())
            .append("productPrice", getProductPrice())
            .append("freightAgreement", getFreightAgreement())
            .append("settlementUnit", getSettlementUnit())
            .append("contacts", getContacts())
            .append("saleContactInformation", getSaleContactInformation())
            .append("saleman", getSaleman())
            .append("freightUnitPrice", getFreightUnitPrice())
            .append("remarks", getRemarks())
            .append("creator", getCreator())
            .append("tenantId", getTenantId())
            .toString();
    }
}

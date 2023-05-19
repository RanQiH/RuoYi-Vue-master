package com.ruoyi.sale.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * engineer对象 sale_engineer
 * 
 * @author ruoyi
 * @date 2023-05-16
 */
public class SaleEngineer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 工程名 */
    @Excel(name = "工程名")
    private String engineerName;

    /** 工程类别 */
    @Excel(name = "工程类别")
    private String type;

    /** 工程级别 */
    @Excel(name = "工程级别")
    private String rank;

    /** 工程地址 */
    @Excel(name = "工程地址")
    private String address;

    /** 工程进度 */
    @Excel(name = "工程进度")
    private String progress;

    /** 浇筑方量 */
    @Excel(name = "浇筑方量")
    private String pouringVolume;

    /** 运输距离 */
    @Excel(name = "运输距离")
    private String distance;

    /** 建设单位 */
    @Excel(name = "建设单位")
    private String constructionUnit;

    /** 预计开工时间 */
    @Excel(name = "预计开工时间")
    private String startTime;

    /** 预计竣工时间 */
    @Excel(name = "预计竣工时间")
    private String endTime;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String connectName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 无意义 */
    @Excel(name = "无意义")
    private Long tenantId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEngineerName(String engineerName) 
    {
        this.engineerName = engineerName;
    }

    public String getEngineerName() 
    {
        return engineerName;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setRank(String rank) 
    {
        this.rank = rank;
    }

    public String getRank() 
    {
        return rank;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setProgress(String progress) 
    {
        this.progress = progress;
    }

    public String getProgress() 
    {
        return progress;
    }
    public void setPouringVolume(String pouringVolume) 
    {
        this.pouringVolume = pouringVolume;
    }

    public String getPouringVolume() 
    {
        return pouringVolume;
    }
    public void setDistance(String distance) 
    {
        this.distance = distance;
    }

    public String getDistance() 
    {
        return distance;
    }
    public void setConstructionUnit(String constructionUnit) 
    {
        this.constructionUnit = constructionUnit;
    }

    public String getConstructionUnit() 
    {
        return constructionUnit;
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
    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public String getContactName() 
    {
        return contactName;
    }
    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
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
            .append("engineerName", getEngineerName())
            .append("type", getType())
            .append("rank", getRank())
            .append("address", getAddress())
            .append("progress", getProgress())
            .append("pouringVolume", getPouringVolume())
            .append("distance", getDistance())
            .append("constructionUnit", getConstructionUnit())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("connectName", getConnectName())
            .append("contactName", getContactName())
            .append("contactPhone", getContactPhone())
            .append("remarks", getRemarks())
            .append("tenantId", getTenantId())
            .toString();
    }
}

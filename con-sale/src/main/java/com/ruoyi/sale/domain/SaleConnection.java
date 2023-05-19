package com.ruoyi.sale.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * connection对象 sale_connection
 * 
 * @author LyingY
 * @date 2023-05-15
 */
public class SaleConnection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String unitname;

    /** 单位类别 */
    @Excel(name = "单位类别")
    private String unitcategory;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalrepresentative;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telephone;

    /** 传真号 */
    @Excel(name = "传真号")
    private String faxnumber;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String adress;

    /** 邮编 */
    @Excel(name = "邮编")
    private String postalcode;

    /** 业务员 */
    @Excel(name = "业务员")
    private String salesman;

    /** 纳税号 */
    @Excel(name = "纳税号")
    private String taxid;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String accountname;

    /** 开户银行 */
    @Excel(name = "开户银行")
    private String openingbank;

    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private String bankaccount;

    /** 联系人信息 */
    @Excel(name = "联系人信息")
    private String contactname;

    /** 职务 */
    @Excel(name = "职务")
    private String post;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactinformation;

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
    public void setUnitname(String unitname) 
    {
        this.unitname = unitname;
    }

    public String getUnitname() 
    {
        return unitname;
    }
    public void setUnitcategory(String unitcategory) 
    {
        this.unitcategory = unitcategory;
    }

    public String getUnitcategory() 
    {
        return unitcategory;
    }
    public void setLegalrepresentative(String legalrepresentative) 
    {
        this.legalrepresentative = legalrepresentative;
    }

    public String getLegalrepresentative() 
    {
        return legalrepresentative;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setFaxnumber(String faxnumber) 
    {
        this.faxnumber = faxnumber;
    }

    public String getFaxnumber() 
    {
        return faxnumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAdress(String adress) 
    {
        this.adress = adress;
    }

    public String getAdress() 
    {
        return adress;
    }
    public void setPostalcode(String postalcode) 
    {
        this.postalcode = postalcode;
    }

    public String getPostalcode() 
    {
        return postalcode;
    }
    public void setSalesman(String salesman) 
    {
        this.salesman = salesman;
    }

    public String getSalesman() 
    {
        return salesman;
    }
    public void setTaxid(String taxid) 
    {
        this.taxid = taxid;
    }

    public String getTaxid() 
    {
        return taxid;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setAccountname(String accountname) 
    {
        this.accountname = accountname;
    }

    public String getAccountname() 
    {
        return accountname;
    }
    public void setOpeningbank(String openingbank) 
    {
        this.openingbank = openingbank;
    }

    public String getOpeningbank() 
    {
        return openingbank;
    }
    public void setBankaccount(String bankaccount) 
    {
        this.bankaccount = bankaccount;
    }

    public String getBankaccount() 
    {
        return bankaccount;
    }
    public void setContactname(String contactname) 
    {
        this.contactname = contactname;
    }

    public String getContactname() 
    {
        return contactname;
    }
    public void setPost(String post) 
    {
        this.post = post;
    }

    public String getPost() 
    {
        return post;
    }
    public void setContactinformation(String contactinformation) 
    {
        this.contactinformation = contactinformation;
    }

    public String getContactinformation() 
    {
        return contactinformation;
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
            .append("unitname", getUnitname())
            .append("unitcategory", getUnitcategory())
            .append("legalrepresentative", getLegalrepresentative())
            .append("telephone", getTelephone())
            .append("faxnumber", getFaxnumber())
            .append("email", getEmail())
            .append("adress", getAdress())
            .append("postalcode", getPostalcode())
            .append("salesman", getSalesman())
            .append("taxid", getTaxid())
            .append("remarks", getRemarks())
            .append("accountname", getAccountname())
            .append("openingbank", getOpeningbank())
            .append("bankaccount", getBankaccount())
            .append("contactname", getContactname())
            .append("post", getPost())
            .append("contactinformation", getContactinformation())
            .append("tenantId", getTenantId())
            .toString();
    }
}

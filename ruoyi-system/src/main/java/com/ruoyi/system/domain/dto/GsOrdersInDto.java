package com.ruoyi.system.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class GsOrdersInDto implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private Integer supplierId;

    private String supplierName;

    private Integer salerId;

    private Integer customerId;

    private String customerName;

    private Date orderDate;

    private Byte status;

    private Integer whId;

    private Integer userId;

    private Integer statuss;

    private String ponumber;

    private String factory;

    private Integer cas;

    private Integer gsid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSalerId() {
        return salerId;
    }

    public void setSalerId(Integer salerId) {
        this.salerId = salerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }

    public String getPonumber() {
        return ponumber;
    }

    public void setPonumber(String ponumber) {
        this.ponumber = ponumber == null ? null : ponumber.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public Integer getCas() {
        return cas;
    }

    public void setCas(Integer cas) {
        this.cas = cas;
    }

    public Integer getGsid() {
        return gsid;
    }

    public void setGsid(Integer gsid) {
        this.gsid = gsid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GsOrdersInDto other = (GsOrdersInDto) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()))
            && (this.getSalerId() == null ? other.getSalerId() == null : this.getSalerId().equals(other.getSalerId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getWhId() == null ? other.getWhId() == null : this.getWhId().equals(other.getWhId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatuss() == null ? other.getStatuss() == null : this.getStatuss().equals(other.getStatuss()))
            && (this.getPonumber() == null ? other.getPonumber() == null : this.getPonumber().equals(other.getPonumber()))
            && (this.getFactory() == null ? other.getFactory() == null : this.getFactory().equals(other.getFactory()))
            && (this.getCas() == null ? other.getCas() == null : this.getCas().equals(other.getCas()))
            && (this.getGsid() == null ? other.getGsid() == null : this.getGsid().equals(other.getGsid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        result = prime * result + ((getSalerId() == null) ? 0 : getSalerId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getWhId() == null) ? 0 : getWhId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatuss() == null) ? 0 : getStatuss().hashCode());
        result = prime * result + ((getPonumber() == null) ? 0 : getPonumber().hashCode());
        result = prime * result + ((getFactory() == null) ? 0 : getFactory().hashCode());
        result = prime * result + ((getCas() == null) ? 0 : getCas().hashCode());
        result = prime * result + ((getGsid() == null) ? 0 : getGsid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", salerId=").append(salerId);
        sb.append(", customerId=").append(customerId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", status=").append(status);
        sb.append(", whId=").append(whId);
        sb.append(", userId=").append(userId);
        sb.append(", statuss=").append(statuss);
        sb.append(", ponumber=").append(ponumber);
        sb.append(", factory=").append(factory);
        sb.append(", cas=").append(cas);
        sb.append(", gsid=").append(gsid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
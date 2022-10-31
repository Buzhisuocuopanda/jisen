package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbiw implements Serializable {
    private String goodssku;

    private String sn;

    private String storesku;

    private String upc;

    private Date createtime;

    private Integer user;

    private static final long serialVersionUID = 1L;

    public String getGoodssku() {
        return goodssku;
    }

    public void setGoodssku(String goodssku) {
        this.goodssku = goodssku == null ? null : goodssku.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getStoresku() {
        return storesku;
    }

    public void setStoresku(String storesku) {
        this.storesku = storesku == null ? null : storesku.trim();
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc == null ? null : upc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
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
        Cbiw other = (Cbiw) that;
        return (this.getGoodssku() == null ? other.getGoodssku() == null : this.getGoodssku().equals(other.getGoodssku()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getStoresku() == null ? other.getStoresku() == null : this.getStoresku().equals(other.getStoresku()))
            && (this.getUpc() == null ? other.getUpc() == null : this.getUpc().equals(other.getUpc()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUser() == null ? other.getUser() == null : this.getUser().equals(other.getUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodssku() == null) ? 0 : getGoodssku().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getStoresku() == null) ? 0 : getStoresku().hashCode());
        result = prime * result + ((getUpc() == null) ? 0 : getUpc().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodssku=").append(goodssku);
        sb.append(", sn=").append(sn);
        sb.append(", storesku=").append(storesku);
        sb.append(", upc=").append(upc);
        sb.append(", createtime=").append(createtime);
        sb.append(", user=").append(user);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
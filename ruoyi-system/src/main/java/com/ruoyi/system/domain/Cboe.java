package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cboe implements Serializable {
    private Integer cboe01;

    private Date cboe02;

    private Integer cboe03;

    private Date cboe04;

    private Integer cboe05;

    private Integer cboe06;

    private String cboe07;

    private Date cboe08;

    private Integer cboe10;

    private String cboe21;

    private Integer cboe09;

    private Integer userId;

    private Double standardprice;

    private Double thisprice;

    private Double money;

    private Integer cboe22;

    private static final long serialVersionUID = 1L;

    public Integer getCboe01() {
        return cboe01;
    }

    public void setCboe01(Integer cboe01) {
        this.cboe01 = cboe01;
    }

    public Date getCboe02() {
        return cboe02;
    }

    public void setCboe02(Date cboe02) {
        this.cboe02 = cboe02;
    }

    public Integer getCboe03() {
        return cboe03;
    }

    public void setCboe03(Integer cboe03) {
        this.cboe03 = cboe03;
    }

    public Date getCboe04() {
        return cboe04;
    }

    public void setCboe04(Date cboe04) {
        this.cboe04 = cboe04;
    }

    public Integer getCboe05() {
        return cboe05;
    }

    public void setCboe05(Integer cboe05) {
        this.cboe05 = cboe05;
    }

    public Integer getCboe06() {
        return cboe06;
    }

    public void setCboe06(Integer cboe06) {
        this.cboe06 = cboe06;
    }

    public String getCboe07() {
        return cboe07;
    }

    public void setCboe07(String cboe07) {
        this.cboe07 = cboe07 == null ? null : cboe07.trim();
    }

    public Date getCboe08() {
        return cboe08;
    }

    public void setCboe08(Date cboe08) {
        this.cboe08 = cboe08;
    }

    public Integer getCboe10() {
        return cboe10;
    }

    public void setCboe10(Integer cboe10) {
        this.cboe10 = cboe10;
    }

    public String getCboe21() {
        return cboe21;
    }

    public void setCboe21(String cboe21) {
        this.cboe21 = cboe21 == null ? null : cboe21.trim();
    }

    public Integer getCboe09() {
        return cboe09;
    }

    public void setCboe09(Integer cboe09) {
        this.cboe09 = cboe09;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getStandardprice() {
        return standardprice;
    }

    public void setStandardprice(Double standardprice) {
        this.standardprice = standardprice;
    }

    public Double getThisprice() {
        return thisprice;
    }

    public void setThisprice(Double thisprice) {
        this.thisprice = thisprice;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getCboe22() {
        return cboe22;
    }

    public void setCboe22(Integer cboe22) {
        this.cboe22 = cboe22;
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
        Cboe other = (Cboe) that;
        return (this.getCboe01() == null ? other.getCboe01() == null : this.getCboe01().equals(other.getCboe01()))
            && (this.getCboe02() == null ? other.getCboe02() == null : this.getCboe02().equals(other.getCboe02()))
            && (this.getCboe03() == null ? other.getCboe03() == null : this.getCboe03().equals(other.getCboe03()))
            && (this.getCboe04() == null ? other.getCboe04() == null : this.getCboe04().equals(other.getCboe04()))
            && (this.getCboe05() == null ? other.getCboe05() == null : this.getCboe05().equals(other.getCboe05()))
            && (this.getCboe06() == null ? other.getCboe06() == null : this.getCboe06().equals(other.getCboe06()))
            && (this.getCboe07() == null ? other.getCboe07() == null : this.getCboe07().equals(other.getCboe07()))
            && (this.getCboe08() == null ? other.getCboe08() == null : this.getCboe08().equals(other.getCboe08()))
            && (this.getCboe10() == null ? other.getCboe10() == null : this.getCboe10().equals(other.getCboe10()))
            && (this.getCboe21() == null ? other.getCboe21() == null : this.getCboe21().equals(other.getCboe21()))
            && (this.getCboe09() == null ? other.getCboe09() == null : this.getCboe09().equals(other.getCboe09()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStandardprice() == null ? other.getStandardprice() == null : this.getStandardprice().equals(other.getStandardprice()))
            && (this.getThisprice() == null ? other.getThisprice() == null : this.getThisprice().equals(other.getThisprice()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCboe01() == null) ? 0 : getCboe01().hashCode());
        result = prime * result + ((getCboe02() == null) ? 0 : getCboe02().hashCode());
        result = prime * result + ((getCboe03() == null) ? 0 : getCboe03().hashCode());
        result = prime * result + ((getCboe04() == null) ? 0 : getCboe04().hashCode());
        result = prime * result + ((getCboe05() == null) ? 0 : getCboe05().hashCode());
        result = prime * result + ((getCboe06() == null) ? 0 : getCboe06().hashCode());
        result = prime * result + ((getCboe07() == null) ? 0 : getCboe07().hashCode());
        result = prime * result + ((getCboe08() == null) ? 0 : getCboe08().hashCode());
        result = prime * result + ((getCboe10() == null) ? 0 : getCboe10().hashCode());
        result = prime * result + ((getCboe21() == null) ? 0 : getCboe21().hashCode());
        result = prime * result + ((getCboe09() == null) ? 0 : getCboe09().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStandardprice() == null) ? 0 : getStandardprice().hashCode());
        result = prime * result + ((getThisprice() == null) ? 0 : getThisprice().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cboe01=").append(cboe01);
        sb.append(", cboe02=").append(cboe02);
        sb.append(", cboe03=").append(cboe03);
        sb.append(", cboe04=").append(cboe04);
        sb.append(", cboe05=").append(cboe05);
        sb.append(", cboe06=").append(cboe06);
        sb.append(", cboe07=").append(cboe07);
        sb.append(", cboe08=").append(cboe08);
        sb.append(", cboe10=").append(cboe10);
        sb.append(", cboe21=").append(cboe21);
        sb.append(", cboe09=").append(cboe09);
        sb.append(", userId=").append(userId);
        sb.append(", standardprice=").append(standardprice);
        sb.append(", thisprice=").append(thisprice);
        sb.append(", money=").append(money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
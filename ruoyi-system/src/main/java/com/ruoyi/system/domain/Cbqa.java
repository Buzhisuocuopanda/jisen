package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbqa implements Serializable {
    private Integer cbqa01;

    private Date cbqa02;

    private Integer cbqa03;

    private Date cbqa04;

    private Integer cbqa05;

    private Integer cbqa06;

    private String cbqa07;

    private Date cbqa08;

    private Integer cbqa09;

    private Integer cbqa10;

    private Date cbqa11;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbqa01() {
        return cbqa01;
    }

    public void setCbqa01(Integer cbqa01) {
        this.cbqa01 = cbqa01;
    }

    public Date getCbqa02() {
        return cbqa02;
    }

    public void setCbqa02(Date cbqa02) {
        this.cbqa02 = cbqa02;
    }

    public Integer getCbqa03() {
        return cbqa03;
    }

    public void setCbqa03(Integer cbqa03) {
        this.cbqa03 = cbqa03;
    }

    public Date getCbqa04() {
        return cbqa04;
    }

    public void setCbqa04(Date cbqa04) {
        this.cbqa04 = cbqa04;
    }

    public Integer getCbqa05() {
        return cbqa05;
    }

    public void setCbqa05(Integer cbqa05) {
        this.cbqa05 = cbqa05;
    }

    public Integer getCbqa06() {
        return cbqa06;
    }

    public void setCbqa06(Integer cbqa06) {
        this.cbqa06 = cbqa06;
    }

    public String getCbqa07() {
        return cbqa07;
    }

    public void setCbqa07(String cbqa07) {
        this.cbqa07 = cbqa07 == null ? null : cbqa07.trim();
    }

    public Date getCbqa08() {
        return cbqa08;
    }

    public void setCbqa08(Date cbqa08) {
        this.cbqa08 = cbqa08;
    }

    public Integer getCbqa09() {
        return cbqa09;
    }

    public void setCbqa09(Integer cbqa09) {
        this.cbqa09 = cbqa09;
    }

    public Integer getCbqa10() {
        return cbqa10;
    }

    public void setCbqa10(Integer cbqa10) {
        this.cbqa10 = cbqa10;
    }

    public Date getCbqa11() {
        return cbqa11;
    }

    public void setCbqa11(Date cbqa11) {
        this.cbqa11 = cbqa11;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        Cbqa other = (Cbqa) that;
        return (this.getCbqa01() == null ? other.getCbqa01() == null : this.getCbqa01().equals(other.getCbqa01()))
            && (this.getCbqa02() == null ? other.getCbqa02() == null : this.getCbqa02().equals(other.getCbqa02()))
            && (this.getCbqa03() == null ? other.getCbqa03() == null : this.getCbqa03().equals(other.getCbqa03()))
            && (this.getCbqa04() == null ? other.getCbqa04() == null : this.getCbqa04().equals(other.getCbqa04()))
            && (this.getCbqa05() == null ? other.getCbqa05() == null : this.getCbqa05().equals(other.getCbqa05()))
            && (this.getCbqa06() == null ? other.getCbqa06() == null : this.getCbqa06().equals(other.getCbqa06()))
            && (this.getCbqa07() == null ? other.getCbqa07() == null : this.getCbqa07().equals(other.getCbqa07()))
            && (this.getCbqa08() == null ? other.getCbqa08() == null : this.getCbqa08().equals(other.getCbqa08()))
            && (this.getCbqa09() == null ? other.getCbqa09() == null : this.getCbqa09().equals(other.getCbqa09()))
            && (this.getCbqa10() == null ? other.getCbqa10() == null : this.getCbqa10().equals(other.getCbqa10()))
            && (this.getCbqa11() == null ? other.getCbqa11() == null : this.getCbqa11().equals(other.getCbqa11()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbqa01() == null) ? 0 : getCbqa01().hashCode());
        result = prime * result + ((getCbqa02() == null) ? 0 : getCbqa02().hashCode());
        result = prime * result + ((getCbqa03() == null) ? 0 : getCbqa03().hashCode());
        result = prime * result + ((getCbqa04() == null) ? 0 : getCbqa04().hashCode());
        result = prime * result + ((getCbqa05() == null) ? 0 : getCbqa05().hashCode());
        result = prime * result + ((getCbqa06() == null) ? 0 : getCbqa06().hashCode());
        result = prime * result + ((getCbqa07() == null) ? 0 : getCbqa07().hashCode());
        result = prime * result + ((getCbqa08() == null) ? 0 : getCbqa08().hashCode());
        result = prime * result + ((getCbqa09() == null) ? 0 : getCbqa09().hashCode());
        result = prime * result + ((getCbqa10() == null) ? 0 : getCbqa10().hashCode());
        result = prime * result + ((getCbqa11() == null) ? 0 : getCbqa11().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbqa01=").append(cbqa01);
        sb.append(", cbqa02=").append(cbqa02);
        sb.append(", cbqa03=").append(cbqa03);
        sb.append(", cbqa04=").append(cbqa04);
        sb.append(", cbqa05=").append(cbqa05);
        sb.append(", cbqa06=").append(cbqa06);
        sb.append(", cbqa07=").append(cbqa07);
        sb.append(", cbqa08=").append(cbqa08);
        sb.append(", cbqa09=").append(cbqa09);
        sb.append(", cbqa10=").append(cbqa10);
        sb.append(", cbqa11=").append(cbqa11);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
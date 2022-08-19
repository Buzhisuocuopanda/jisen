package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsg implements Serializable {
    private Integer cbsg01;

    private Integer cbsg02;

    private Date cbsg03;

    private Integer cbsg04;

    private Date cbsg05;

    private Integer cbsg06;

    private Integer cbsg07;

    private Integer cbsg08;

    private String cbsg09;

    private Integer cbsg10;

    private Integer cbsg11;

    private String cbsg12;

    private Integer cbse01;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbsg01() {
        return cbsg01;
    }

    public void setCbsg01(Integer cbsg01) {
        this.cbsg01 = cbsg01;
    }

    public Integer getCbsg02() {
        return cbsg02;
    }

    public void setCbsg02(Integer cbsg02) {
        this.cbsg02 = cbsg02;
    }

    public Date getCbsg03() {
        return cbsg03;
    }

    public void setCbsg03(Date cbsg03) {
        this.cbsg03 = cbsg03;
    }

    public Integer getCbsg04() {
        return cbsg04;
    }

    public void setCbsg04(Integer cbsg04) {
        this.cbsg04 = cbsg04;
    }

    public Date getCbsg05() {
        return cbsg05;
    }

    public void setCbsg05(Date cbsg05) {
        this.cbsg05 = cbsg05;
    }

    public Integer getCbsg06() {
        return cbsg06;
    }

    public void setCbsg06(Integer cbsg06) {
        this.cbsg06 = cbsg06;
    }

    public Integer getCbsg07() {
        return cbsg07;
    }

    public void setCbsg07(Integer cbsg07) {
        this.cbsg07 = cbsg07;
    }

    public Integer getCbsg08() {
        return cbsg08;
    }

    public void setCbsg08(Integer cbsg08) {
        this.cbsg08 = cbsg08;
    }

    public String getCbsg09() {
        return cbsg09;
    }

    public void setCbsg09(String cbsg09) {
        this.cbsg09 = cbsg09 == null ? null : cbsg09.trim();
    }

    public Integer getCbsg10() {
        return cbsg10;
    }

    public void setCbsg10(Integer cbsg10) {
        this.cbsg10 = cbsg10;
    }

    public Integer getCbsg11() {
        return cbsg11;
    }

    public void setCbsg11(Integer cbsg11) {
        this.cbsg11 = cbsg11;
    }

    public String getCbsg12() {
        return cbsg12;
    }

    public void setCbsg12(String cbsg12) {
        this.cbsg12 = cbsg12 == null ? null : cbsg12.trim();
    }

    public Integer getCbse01() {
        return cbse01;
    }

    public void setCbse01(Integer cbse01) {
        this.cbse01 = cbse01;
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
        Cbsg other = (Cbsg) that;
        return (this.getCbsg01() == null ? other.getCbsg01() == null : this.getCbsg01().equals(other.getCbsg01()))
            && (this.getCbsg02() == null ? other.getCbsg02() == null : this.getCbsg02().equals(other.getCbsg02()))
            && (this.getCbsg03() == null ? other.getCbsg03() == null : this.getCbsg03().equals(other.getCbsg03()))
            && (this.getCbsg04() == null ? other.getCbsg04() == null : this.getCbsg04().equals(other.getCbsg04()))
            && (this.getCbsg05() == null ? other.getCbsg05() == null : this.getCbsg05().equals(other.getCbsg05()))
            && (this.getCbsg06() == null ? other.getCbsg06() == null : this.getCbsg06().equals(other.getCbsg06()))
            && (this.getCbsg07() == null ? other.getCbsg07() == null : this.getCbsg07().equals(other.getCbsg07()))
            && (this.getCbsg08() == null ? other.getCbsg08() == null : this.getCbsg08().equals(other.getCbsg08()))
            && (this.getCbsg09() == null ? other.getCbsg09() == null : this.getCbsg09().equals(other.getCbsg09()))
            && (this.getCbsg10() == null ? other.getCbsg10() == null : this.getCbsg10().equals(other.getCbsg10()))
            && (this.getCbsg11() == null ? other.getCbsg11() == null : this.getCbsg11().equals(other.getCbsg11()))
            && (this.getCbsg12() == null ? other.getCbsg12() == null : this.getCbsg12().equals(other.getCbsg12()))
            && (this.getCbse01() == null ? other.getCbse01() == null : this.getCbse01().equals(other.getCbse01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsg01() == null) ? 0 : getCbsg01().hashCode());
        result = prime * result + ((getCbsg02() == null) ? 0 : getCbsg02().hashCode());
        result = prime * result + ((getCbsg03() == null) ? 0 : getCbsg03().hashCode());
        result = prime * result + ((getCbsg04() == null) ? 0 : getCbsg04().hashCode());
        result = prime * result + ((getCbsg05() == null) ? 0 : getCbsg05().hashCode());
        result = prime * result + ((getCbsg06() == null) ? 0 : getCbsg06().hashCode());
        result = prime * result + ((getCbsg07() == null) ? 0 : getCbsg07().hashCode());
        result = prime * result + ((getCbsg08() == null) ? 0 : getCbsg08().hashCode());
        result = prime * result + ((getCbsg09() == null) ? 0 : getCbsg09().hashCode());
        result = prime * result + ((getCbsg10() == null) ? 0 : getCbsg10().hashCode());
        result = prime * result + ((getCbsg11() == null) ? 0 : getCbsg11().hashCode());
        result = prime * result + ((getCbsg12() == null) ? 0 : getCbsg12().hashCode());
        result = prime * result + ((getCbse01() == null) ? 0 : getCbse01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsg01=").append(cbsg01);
        sb.append(", cbsg02=").append(cbsg02);
        sb.append(", cbsg03=").append(cbsg03);
        sb.append(", cbsg04=").append(cbsg04);
        sb.append(", cbsg05=").append(cbsg05);
        sb.append(", cbsg06=").append(cbsg06);
        sb.append(", cbsg07=").append(cbsg07);
        sb.append(", cbsg08=").append(cbsg08);
        sb.append(", cbsg09=").append(cbsg09);
        sb.append(", cbsg10=").append(cbsg10);
        sb.append(", cbsg11=").append(cbsg11);
        sb.append(", cbsg12=").append(cbsg12);
        sb.append(", cbse01=").append(cbse01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
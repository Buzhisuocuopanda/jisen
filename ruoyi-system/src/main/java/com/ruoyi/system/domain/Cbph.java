package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbph implements Serializable {
    private Integer cbph01;

    private Integer cbph02;

    private Date cbph03;

    private Integer cbph04;

    private Date cbph05;

    private Integer cbph06;

    private Integer cbph07;

    private Integer cbph08;

    private Double cbph09;

    private Double cbph10;

    private Double cbph11;

    private Double cbph12;

    private String cbph13;

    private Integer cbpg01;

    private Integer userId;



    private static final long serialVersionUID = 1L;

    public Integer getCbph01() {
        return cbph01;
    }

    public void setCbph01(Integer cbph01) {
        this.cbph01 = cbph01;
    }

    public Integer getCbph02() {
        return cbph02;
    }

    public void setCbph02(Integer cbph02) {
        this.cbph02 = cbph02;
    }

    public Date getCbph03() {
        return cbph03;
    }

    public void setCbph03(Date cbph03) {
        this.cbph03 = cbph03;
    }

    public Integer getCbph04() {
        return cbph04;
    }

    public void setCbph04(Integer cbph04) {
        this.cbph04 = cbph04;
    }

    public Date getCbph05() {
        return cbph05;
    }

    public void setCbph05(Date cbph05) {
        this.cbph05 = cbph05;
    }

    public Integer getCbph06() {
        return cbph06;
    }

    public void setCbph06(Integer cbph06) {
        this.cbph06 = cbph06;
    }

    public Integer getCbph07() {
        return cbph07;
    }

    public void setCbph07(Integer cbph07) {
        this.cbph07 = cbph07;
    }

    public Integer getCbph08() {
        return cbph08;
    }

    public void setCbph08(Integer cbph08) {
        this.cbph08 = cbph08;
    }

    public Double getCbph09() {
        return cbph09;
    }

    public void setCbph09(Double cbph09) {
        this.cbph09 = cbph09;
    }

    public Double getCbph10() {
        return cbph10;
    }

    public void setCbph10(Double cbph10) {
        this.cbph10 = cbph10;
    }

    public Double getCbph11() {
        return cbph11;
    }

    public void setCbph11(Double cbph11) {
        this.cbph11 = cbph11;
    }

    public Double getCbph12() {
        return cbph12;
    }

    public void setCbph12(Double cbph12) {
        this.cbph12 = cbph12;
    }

    public String getCbph13() {
        return cbph13;
    }

    public void setCbph13(String cbph13) {
        this.cbph13 = cbph13 == null ? null : cbph13.trim();
    }

    public Integer getCbpg01() {
        return cbpg01;
    }

    public void setCbpg01(Integer cbpg01) {
        this.cbpg01 = cbpg01;
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
        Cbph other = (Cbph) that;
        return (this.getCbph01() == null ? other.getCbph01() == null : this.getCbph01().equals(other.getCbph01()))
            && (this.getCbph02() == null ? other.getCbph02() == null : this.getCbph02().equals(other.getCbph02()))
            && (this.getCbph03() == null ? other.getCbph03() == null : this.getCbph03().equals(other.getCbph03()))
            && (this.getCbph04() == null ? other.getCbph04() == null : this.getCbph04().equals(other.getCbph04()))
            && (this.getCbph05() == null ? other.getCbph05() == null : this.getCbph05().equals(other.getCbph05()))
            && (this.getCbph06() == null ? other.getCbph06() == null : this.getCbph06().equals(other.getCbph06()))
            && (this.getCbph07() == null ? other.getCbph07() == null : this.getCbph07().equals(other.getCbph07()))
            && (this.getCbph08() == null ? other.getCbph08() == null : this.getCbph08().equals(other.getCbph08()))
            && (this.getCbph09() == null ? other.getCbph09() == null : this.getCbph09().equals(other.getCbph09()))
            && (this.getCbph10() == null ? other.getCbph10() == null : this.getCbph10().equals(other.getCbph10()))
            && (this.getCbph11() == null ? other.getCbph11() == null : this.getCbph11().equals(other.getCbph11()))
            && (this.getCbph12() == null ? other.getCbph12() == null : this.getCbph12().equals(other.getCbph12()))
            && (this.getCbph13() == null ? other.getCbph13() == null : this.getCbph13().equals(other.getCbph13()))
            && (this.getCbpg01() == null ? other.getCbpg01() == null : this.getCbpg01().equals(other.getCbpg01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbph01() == null) ? 0 : getCbph01().hashCode());
        result = prime * result + ((getCbph02() == null) ? 0 : getCbph02().hashCode());
        result = prime * result + ((getCbph03() == null) ? 0 : getCbph03().hashCode());
        result = prime * result + ((getCbph04() == null) ? 0 : getCbph04().hashCode());
        result = prime * result + ((getCbph05() == null) ? 0 : getCbph05().hashCode());
        result = prime * result + ((getCbph06() == null) ? 0 : getCbph06().hashCode());
        result = prime * result + ((getCbph07() == null) ? 0 : getCbph07().hashCode());
        result = prime * result + ((getCbph08() == null) ? 0 : getCbph08().hashCode());
        result = prime * result + ((getCbph09() == null) ? 0 : getCbph09().hashCode());
        result = prime * result + ((getCbph10() == null) ? 0 : getCbph10().hashCode());
        result = prime * result + ((getCbph11() == null) ? 0 : getCbph11().hashCode());
        result = prime * result + ((getCbph12() == null) ? 0 : getCbph12().hashCode());
        result = prime * result + ((getCbph13() == null) ? 0 : getCbph13().hashCode());
        result = prime * result + ((getCbpg01() == null) ? 0 : getCbpg01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbph01=").append(cbph01);
        sb.append(", cbph02=").append(cbph02);
        sb.append(", cbph03=").append(cbph03);
        sb.append(", cbph04=").append(cbph04);
        sb.append(", cbph05=").append(cbph05);
        sb.append(", cbph06=").append(cbph06);
        sb.append(", cbph07=").append(cbph07);
        sb.append(", cbph08=").append(cbph08);
        sb.append(", cbph09=").append(cbph09);
        sb.append(", cbph10=").append(cbph10);
        sb.append(", cbph11=").append(cbph11);
        sb.append(", cbph12=").append(cbph12);
        sb.append(", cbph13=").append(cbph13);
        sb.append(", cbpg01=").append(cbpg01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

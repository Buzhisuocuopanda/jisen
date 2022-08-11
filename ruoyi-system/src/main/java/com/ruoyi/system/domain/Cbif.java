package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbif implements Serializable {
    private Integer cbif01;

    private Integer cbif02;

    private Date cbif03;

    private Integer cbif04;

    private Date cbif05;

    private Integer cbif06;

    private Integer cbif07;

    private Integer cbif08;

    private Double cbif09;

    private Double cbif10;

    private Double cbif11;

    private Double cbif12;

    private String cbif13;

    private Integer cbie01;

    private Integer cbif14;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbif01() {
        return cbif01;
    }

    public void setCbif01(Integer cbif01) {
        this.cbif01 = cbif01;
    }

    public Integer getCbif02() {
        return cbif02;
    }

    public void setCbif02(Integer cbif02) {
        this.cbif02 = cbif02;
    }

    public Date getCbif03() {
        return cbif03;
    }

    public void setCbif03(Date cbif03) {
        this.cbif03 = cbif03;
    }

    public Integer getCbif04() {
        return cbif04;
    }

    public void setCbif04(Integer cbif04) {
        this.cbif04 = cbif04;
    }

    public Date getCbif05() {
        return cbif05;
    }

    public void setCbif05(Date cbif05) {
        this.cbif05 = cbif05;
    }

    public Integer getCbif06() {
        return cbif06;
    }

    public void setCbif06(Integer cbif06) {
        this.cbif06 = cbif06;
    }

    public Integer getCbif07() {
        return cbif07;
    }

    public void setCbif07(Integer cbif07) {
        this.cbif07 = cbif07;
    }

    public Integer getCbif08() {
        return cbif08;
    }

    public void setCbif08(Integer cbif08) {
        this.cbif08 = cbif08;
    }

    public Double getCbif09() {
        return cbif09;
    }

    public void setCbif09(Double cbif09) {
        this.cbif09 = cbif09;
    }

    public Double getCbif10() {
        return cbif10;
    }

    public void setCbif10(Double cbif10) {
        this.cbif10 = cbif10;
    }

    public Double getCbif11() {
        return cbif11;
    }

    public void setCbif11(Double cbif11) {
        this.cbif11 = cbif11;
    }

    public Double getCbif12() {
        return cbif12;
    }

    public void setCbif12(Double cbif12) {
        this.cbif12 = cbif12;
    }

    public String getCbif13() {
        return cbif13;
    }

    public void setCbif13(String cbif13) {
        this.cbif13 = cbif13 == null ? null : cbif13.trim();
    }

    public Integer getCbie01() {
        return cbie01;
    }

    public void setCbie01(Integer cbie01) {
        this.cbie01 = cbie01;
    }

    public Integer getCbif14() {
        return cbif14;
    }

    public void setCbif14(Integer cbif14) {
        this.cbif14 = cbif14;
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
        Cbif other = (Cbif) that;
        return (this.getCbif01() == null ? other.getCbif01() == null : this.getCbif01().equals(other.getCbif01()))
            && (this.getCbif02() == null ? other.getCbif02() == null : this.getCbif02().equals(other.getCbif02()))
            && (this.getCbif03() == null ? other.getCbif03() == null : this.getCbif03().equals(other.getCbif03()))
            && (this.getCbif04() == null ? other.getCbif04() == null : this.getCbif04().equals(other.getCbif04()))
            && (this.getCbif05() == null ? other.getCbif05() == null : this.getCbif05().equals(other.getCbif05()))
            && (this.getCbif06() == null ? other.getCbif06() == null : this.getCbif06().equals(other.getCbif06()))
            && (this.getCbif07() == null ? other.getCbif07() == null : this.getCbif07().equals(other.getCbif07()))
            && (this.getCbif08() == null ? other.getCbif08() == null : this.getCbif08().equals(other.getCbif08()))
            && (this.getCbif09() == null ? other.getCbif09() == null : this.getCbif09().equals(other.getCbif09()))
            && (this.getCbif10() == null ? other.getCbif10() == null : this.getCbif10().equals(other.getCbif10()))
            && (this.getCbif11() == null ? other.getCbif11() == null : this.getCbif11().equals(other.getCbif11()))
            && (this.getCbif12() == null ? other.getCbif12() == null : this.getCbif12().equals(other.getCbif12()))
            && (this.getCbif13() == null ? other.getCbif13() == null : this.getCbif13().equals(other.getCbif13()))
            && (this.getCbie01() == null ? other.getCbie01() == null : this.getCbie01().equals(other.getCbie01()))
            && (this.getCbif14() == null ? other.getCbif14() == null : this.getCbif14().equals(other.getCbif14()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbif01() == null) ? 0 : getCbif01().hashCode());
        result = prime * result + ((getCbif02() == null) ? 0 : getCbif02().hashCode());
        result = prime * result + ((getCbif03() == null) ? 0 : getCbif03().hashCode());
        result = prime * result + ((getCbif04() == null) ? 0 : getCbif04().hashCode());
        result = prime * result + ((getCbif05() == null) ? 0 : getCbif05().hashCode());
        result = prime * result + ((getCbif06() == null) ? 0 : getCbif06().hashCode());
        result = prime * result + ((getCbif07() == null) ? 0 : getCbif07().hashCode());
        result = prime * result + ((getCbif08() == null) ? 0 : getCbif08().hashCode());
        result = prime * result + ((getCbif09() == null) ? 0 : getCbif09().hashCode());
        result = prime * result + ((getCbif10() == null) ? 0 : getCbif10().hashCode());
        result = prime * result + ((getCbif11() == null) ? 0 : getCbif11().hashCode());
        result = prime * result + ((getCbif12() == null) ? 0 : getCbif12().hashCode());
        result = prime * result + ((getCbif13() == null) ? 0 : getCbif13().hashCode());
        result = prime * result + ((getCbie01() == null) ? 0 : getCbie01().hashCode());
        result = prime * result + ((getCbif14() == null) ? 0 : getCbif14().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbif01=").append(cbif01);
        sb.append(", cbif02=").append(cbif02);
        sb.append(", cbif03=").append(cbif03);
        sb.append(", cbif04=").append(cbif04);
        sb.append(", cbif05=").append(cbif05);
        sb.append(", cbif06=").append(cbif06);
        sb.append(", cbif07=").append(cbif07);
        sb.append(", cbif08=").append(cbif08);
        sb.append(", cbif09=").append(cbif09);
        sb.append(", cbif10=").append(cbif10);
        sb.append(", cbif11=").append(cbif11);
        sb.append(", cbif12=").append(cbif12);
        sb.append(", cbif13=").append(cbif13);
        sb.append(", cbie01=").append(cbie01);
        sb.append(", cbif14=").append(cbif14);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
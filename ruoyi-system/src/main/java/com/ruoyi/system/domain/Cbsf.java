package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsf implements Serializable {
    private Integer cbsf01;

    private Integer cbsf02;

    private Date cbsf03;

    private Integer cbsf04;

    private Date cbsf05;

    private Integer cbsf06;

    private Integer cbsf07;

    private Integer cbsf08;

    private Double cbsf09;

    private Double cbsf10;

    private Double cbsf11;

    private Double cbsf12;

    private String cbsf13;

    private Integer cbse01;

    private Integer cbsf14;

    private Integer cbsf15;

    private Integer cbsf16;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbsf01() {
        return cbsf01;
    }

    public void setCbsf01(Integer cbsf01) {
        this.cbsf01 = cbsf01;
    }

    public Integer getCbsf02() {
        return cbsf02;
    }

    public void setCbsf02(Integer cbsf02) {
        this.cbsf02 = cbsf02;
    }

    public Date getCbsf03() {
        return cbsf03;
    }

    public void setCbsf03(Date cbsf03) {
        this.cbsf03 = cbsf03;
    }

    public Integer getCbsf04() {
        return cbsf04;
    }

    public void setCbsf04(Integer cbsf04) {
        this.cbsf04 = cbsf04;
    }

    public Date getCbsf05() {
        return cbsf05;
    }

    public void setCbsf05(Date cbsf05) {
        this.cbsf05 = cbsf05;
    }

    public Integer getCbsf06() {
        return cbsf06;
    }

    public void setCbsf06(Integer cbsf06) {
        this.cbsf06 = cbsf06;
    }

    public Integer getCbsf07() {
        return cbsf07;
    }

    public void setCbsf07(Integer cbsf07) {
        this.cbsf07 = cbsf07;
    }

    public Integer getCbsf08() {
        return cbsf08;
    }

    public void setCbsf08(Integer cbsf08) {
        this.cbsf08 = cbsf08;
    }

    public Double getCbsf09() {
        return cbsf09;
    }

    public void setCbsf09(Double cbsf09) {
        this.cbsf09 = cbsf09;
    }

    public Double getCbsf10() {
        return cbsf10;
    }

    public void setCbsf10(Double cbsf10) {
        this.cbsf10 = cbsf10;
    }

    public Double getCbsf11() {
        return cbsf11;
    }

    public void setCbsf11(Double cbsf11) {
        this.cbsf11 = cbsf11;
    }

    public Double getCbsf12() {
        return cbsf12;
    }

    public void setCbsf12(Double cbsf12) {
        this.cbsf12 = cbsf12;
    }

    public String getCbsf13() {
        return cbsf13;
    }

    public void setCbsf13(String cbsf13) {
        this.cbsf13 = cbsf13 == null ? null : cbsf13.trim();
    }

    public Integer getCbse01() {
        return cbse01;
    }

    public void setCbse01(Integer cbse01) {
        this.cbse01 = cbse01;
    }

    public Integer getCbsf14() {
        return cbsf14;
    }

    public void setCbsf14(Integer cbsf14) {
        this.cbsf14 = cbsf14;
    }

    public Integer getCbsf15() {
        return cbsf15;
    }

    public void setCbsf15(Integer cbsf15) {
        this.cbsf15 = cbsf15;
    }

    public Integer getCbsf16() {
        return cbsf16;
    }

    public void setCbsf16(Integer cbsf16) {
        this.cbsf16 = cbsf16;
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
        Cbsf other = (Cbsf) that;
        return (this.getCbsf01() == null ? other.getCbsf01() == null : this.getCbsf01().equals(other.getCbsf01()))
            && (this.getCbsf02() == null ? other.getCbsf02() == null : this.getCbsf02().equals(other.getCbsf02()))
            && (this.getCbsf03() == null ? other.getCbsf03() == null : this.getCbsf03().equals(other.getCbsf03()))
            && (this.getCbsf04() == null ? other.getCbsf04() == null : this.getCbsf04().equals(other.getCbsf04()))
            && (this.getCbsf05() == null ? other.getCbsf05() == null : this.getCbsf05().equals(other.getCbsf05()))
            && (this.getCbsf06() == null ? other.getCbsf06() == null : this.getCbsf06().equals(other.getCbsf06()))
            && (this.getCbsf07() == null ? other.getCbsf07() == null : this.getCbsf07().equals(other.getCbsf07()))
            && (this.getCbsf08() == null ? other.getCbsf08() == null : this.getCbsf08().equals(other.getCbsf08()))
            && (this.getCbsf09() == null ? other.getCbsf09() == null : this.getCbsf09().equals(other.getCbsf09()))
            && (this.getCbsf10() == null ? other.getCbsf10() == null : this.getCbsf10().equals(other.getCbsf10()))
            && (this.getCbsf11() == null ? other.getCbsf11() == null : this.getCbsf11().equals(other.getCbsf11()))
            && (this.getCbsf12() == null ? other.getCbsf12() == null : this.getCbsf12().equals(other.getCbsf12()))
            && (this.getCbsf13() == null ? other.getCbsf13() == null : this.getCbsf13().equals(other.getCbsf13()))
            && (this.getCbse01() == null ? other.getCbse01() == null : this.getCbse01().equals(other.getCbse01()))
            && (this.getCbsf14() == null ? other.getCbsf14() == null : this.getCbsf14().equals(other.getCbsf14()))
            && (this.getCbsf15() == null ? other.getCbsf15() == null : this.getCbsf15().equals(other.getCbsf15()))
            && (this.getCbsf16() == null ? other.getCbsf16() == null : this.getCbsf16().equals(other.getCbsf16()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsf01() == null) ? 0 : getCbsf01().hashCode());
        result = prime * result + ((getCbsf02() == null) ? 0 : getCbsf02().hashCode());
        result = prime * result + ((getCbsf03() == null) ? 0 : getCbsf03().hashCode());
        result = prime * result + ((getCbsf04() == null) ? 0 : getCbsf04().hashCode());
        result = prime * result + ((getCbsf05() == null) ? 0 : getCbsf05().hashCode());
        result = prime * result + ((getCbsf06() == null) ? 0 : getCbsf06().hashCode());
        result = prime * result + ((getCbsf07() == null) ? 0 : getCbsf07().hashCode());
        result = prime * result + ((getCbsf08() == null) ? 0 : getCbsf08().hashCode());
        result = prime * result + ((getCbsf09() == null) ? 0 : getCbsf09().hashCode());
        result = prime * result + ((getCbsf10() == null) ? 0 : getCbsf10().hashCode());
        result = prime * result + ((getCbsf11() == null) ? 0 : getCbsf11().hashCode());
        result = prime * result + ((getCbsf12() == null) ? 0 : getCbsf12().hashCode());
        result = prime * result + ((getCbsf13() == null) ? 0 : getCbsf13().hashCode());
        result = prime * result + ((getCbse01() == null) ? 0 : getCbse01().hashCode());
        result = prime * result + ((getCbsf14() == null) ? 0 : getCbsf14().hashCode());
        result = prime * result + ((getCbsf15() == null) ? 0 : getCbsf15().hashCode());
        result = prime * result + ((getCbsf16() == null) ? 0 : getCbsf16().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsf01=").append(cbsf01);
        sb.append(", cbsf02=").append(cbsf02);
        sb.append(", cbsf03=").append(cbsf03);
        sb.append(", cbsf04=").append(cbsf04);
        sb.append(", cbsf05=").append(cbsf05);
        sb.append(", cbsf06=").append(cbsf06);
        sb.append(", cbsf07=").append(cbsf07);
        sb.append(", cbsf08=").append(cbsf08);
        sb.append(", cbsf09=").append(cbsf09);
        sb.append(", cbsf10=").append(cbsf10);
        sb.append(", cbsf11=").append(cbsf11);
        sb.append(", cbsf12=").append(cbsf12);
        sb.append(", cbsf13=").append(cbsf13);
        sb.append(", cbse01=").append(cbse01);
        sb.append(", cbsf14=").append(cbsf14);
        sb.append(", cbsf15=").append(cbsf15);
        sb.append(", cbsf16=").append(cbsf16);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
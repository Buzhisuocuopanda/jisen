package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbic implements Serializable {
    private Integer cbic01;

    private Date cbic02;

    private Date cbic03;

    private Integer cbic04;

    private Integer cbic05;

    private Integer cbic06;

    private Integer cbic07;

    private Integer cbic08;

    private Integer cbic09;

    private String cbic10;

    private Integer cbic11;

    private Date cbic12;

    private Integer cbic13;

    private Integer cbic14;

    private Integer cbic15;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbic01() {
        return cbic01;
    }

    public void setCbic01(Integer cbic01) {
        this.cbic01 = cbic01;
    }

    public Date getCbic02() {
        return cbic02;
    }

    public void setCbic02(Date cbic02) {
        this.cbic02 = cbic02;
    }

    public Date getCbic03() {
        return cbic03;
    }

    public void setCbic03(Date cbic03) {
        this.cbic03 = cbic03;
    }

    public Integer getCbic04() {
        return cbic04;
    }

    public void setCbic04(Integer cbic04) {
        this.cbic04 = cbic04;
    }

    public Integer getCbic05() {
        return cbic05;
    }

    public void setCbic05(Integer cbic05) {
        this.cbic05 = cbic05;
    }

    public Integer getCbic06() {
        return cbic06;
    }

    public void setCbic06(Integer cbic06) {
        this.cbic06 = cbic06;
    }

    public Integer getCbic07() {
        return cbic07;
    }

    public void setCbic07(Integer cbic07) {
        this.cbic07 = cbic07;
    }

    public Integer getCbic08() {
        return cbic08;
    }

    public void setCbic08(Integer cbic08) {
        this.cbic08 = cbic08;
    }

    public Integer getCbic09() {
        return cbic09;
    }

    public void setCbic09(Integer cbic09) {
        this.cbic09 = cbic09;
    }

    public String getCbic10() {
        return cbic10;
    }

    public void setCbic10(String cbic10) {
        this.cbic10 = cbic10 == null ? null : cbic10.trim();
    }

    public Integer getCbic11() {
        return cbic11;
    }

    public void setCbic11(Integer cbic11) {
        this.cbic11 = cbic11;
    }

    public Date getCbic12() {
        return cbic12;
    }

    public void setCbic12(Date cbic12) {
        this.cbic12 = cbic12;
    }

    public Integer getCbic13() {
        return cbic13;
    }

    public void setCbic13(Integer cbic13) {
        this.cbic13 = cbic13;
    }

    public Integer getCbic14() {
        return cbic14;
    }

    public void setCbic14(Integer cbic14) {
        this.cbic14 = cbic14;
    }

    public Integer getCbic15() {
        return cbic15;
    }

    public void setCbic15(Integer cbic15) {
        this.cbic15 = cbic15;
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
        Cbic other = (Cbic) that;
        return (this.getCbic01() == null ? other.getCbic01() == null : this.getCbic01().equals(other.getCbic01()))
            && (this.getCbic02() == null ? other.getCbic02() == null : this.getCbic02().equals(other.getCbic02()))
            && (this.getCbic03() == null ? other.getCbic03() == null : this.getCbic03().equals(other.getCbic03()))
            && (this.getCbic04() == null ? other.getCbic04() == null : this.getCbic04().equals(other.getCbic04()))
            && (this.getCbic05() == null ? other.getCbic05() == null : this.getCbic05().equals(other.getCbic05()))
            && (this.getCbic06() == null ? other.getCbic06() == null : this.getCbic06().equals(other.getCbic06()))
            && (this.getCbic07() == null ? other.getCbic07() == null : this.getCbic07().equals(other.getCbic07()))
            && (this.getCbic08() == null ? other.getCbic08() == null : this.getCbic08().equals(other.getCbic08()))
            && (this.getCbic09() == null ? other.getCbic09() == null : this.getCbic09().equals(other.getCbic09()))
            && (this.getCbic10() == null ? other.getCbic10() == null : this.getCbic10().equals(other.getCbic10()))
            && (this.getCbic11() == null ? other.getCbic11() == null : this.getCbic11().equals(other.getCbic11()))
            && (this.getCbic12() == null ? other.getCbic12() == null : this.getCbic12().equals(other.getCbic12()))
            && (this.getCbic13() == null ? other.getCbic13() == null : this.getCbic13().equals(other.getCbic13()))
            && (this.getCbic14() == null ? other.getCbic14() == null : this.getCbic14().equals(other.getCbic14()))
            && (this.getCbic15() == null ? other.getCbic15() == null : this.getCbic15().equals(other.getCbic15()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbic01() == null) ? 0 : getCbic01().hashCode());
        result = prime * result + ((getCbic02() == null) ? 0 : getCbic02().hashCode());
        result = prime * result + ((getCbic03() == null) ? 0 : getCbic03().hashCode());
        result = prime * result + ((getCbic04() == null) ? 0 : getCbic04().hashCode());
        result = prime * result + ((getCbic05() == null) ? 0 : getCbic05().hashCode());
        result = prime * result + ((getCbic06() == null) ? 0 : getCbic06().hashCode());
        result = prime * result + ((getCbic07() == null) ? 0 : getCbic07().hashCode());
        result = prime * result + ((getCbic08() == null) ? 0 : getCbic08().hashCode());
        result = prime * result + ((getCbic09() == null) ? 0 : getCbic09().hashCode());
        result = prime * result + ((getCbic10() == null) ? 0 : getCbic10().hashCode());
        result = prime * result + ((getCbic11() == null) ? 0 : getCbic11().hashCode());
        result = prime * result + ((getCbic12() == null) ? 0 : getCbic12().hashCode());
        result = prime * result + ((getCbic13() == null) ? 0 : getCbic13().hashCode());
        result = prime * result + ((getCbic14() == null) ? 0 : getCbic14().hashCode());
        result = prime * result + ((getCbic15() == null) ? 0 : getCbic15().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbic01=").append(cbic01);
        sb.append(", cbic02=").append(cbic02);
        sb.append(", cbic03=").append(cbic03);
        sb.append(", cbic04=").append(cbic04);
        sb.append(", cbic05=").append(cbic05);
        sb.append(", cbic06=").append(cbic06);
        sb.append(", cbic07=").append(cbic07);
        sb.append(", cbic08=").append(cbic08);
        sb.append(", cbic09=").append(cbic09);
        sb.append(", cbic10=").append(cbic10);
        sb.append(", cbic11=").append(cbic11);
        sb.append(", cbic12=").append(cbic12);
        sb.append(", cbic13=").append(cbic13);
        sb.append(", cbic14=").append(cbic14);
        sb.append(", cbic15=").append(cbic15);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
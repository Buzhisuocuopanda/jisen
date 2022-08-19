package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbac implements Serializable {
    private Integer cbac01;

    private Integer cbac02;

    private Date cbac03;

    private Integer cbac04;

    private Date cbac05;

    private Integer cbac06;

    private Integer cbac07;

    private Integer cbac08;

    private String cbac09;

    private Integer cbac10;

    private Integer cbac11;

    private String cbac12;

    private Integer cbaa01;

    private Integer cbac13;

    private Integer cbac14;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbac01() {
        return cbac01;
    }

    public void setCbac01(Integer cbac01) {
        this.cbac01 = cbac01;
    }

    public Integer getCbac02() {
        return cbac02;
    }

    public void setCbac02(Integer cbac02) {
        this.cbac02 = cbac02;
    }

    public Date getCbac03() {
        return cbac03;
    }

    public void setCbac03(Date cbac03) {
        this.cbac03 = cbac03;
    }

    public Integer getCbac04() {
        return cbac04;
    }

    public void setCbac04(Integer cbac04) {
        this.cbac04 = cbac04;
    }

    public Date getCbac05() {
        return cbac05;
    }

    public void setCbac05(Date cbac05) {
        this.cbac05 = cbac05;
    }

    public Integer getCbac06() {
        return cbac06;
    }

    public void setCbac06(Integer cbac06) {
        this.cbac06 = cbac06;
    }

    public Integer getCbac07() {
        return cbac07;
    }

    public void setCbac07(Integer cbac07) {
        this.cbac07 = cbac07;
    }

    public Integer getCbac08() {
        return cbac08;
    }

    public void setCbac08(Integer cbac08) {
        this.cbac08 = cbac08;
    }

    public String getCbac09() {
        return cbac09;
    }

    public void setCbac09(String cbac09) {
        this.cbac09 = cbac09 == null ? null : cbac09.trim();
    }

    public Integer getCbac10() {
        return cbac10;
    }

    public void setCbac10(Integer cbac10) {
        this.cbac10 = cbac10;
    }

    public Integer getCbac11() {
        return cbac11;
    }

    public void setCbac11(Integer cbac11) {
        this.cbac11 = cbac11;
    }

    public String getCbac12() {
        return cbac12;
    }

    public void setCbac12(String cbac12) {
        this.cbac12 = cbac12 == null ? null : cbac12.trim();
    }

    public Integer getCbaa01() {
        return cbaa01;
    }

    public void setCbaa01(Integer cbaa01) {
        this.cbaa01 = cbaa01;
    }

    public Integer getCbac13() {
        return cbac13;
    }

    public void setCbac13(Integer cbac13) {
        this.cbac13 = cbac13;
    }

    public Integer getCbac14() {
        return cbac14;
    }

    public void setCbac14(Integer cbac14) {
        this.cbac14 = cbac14;
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
        Cbac other = (Cbac) that;
        return (this.getCbac01() == null ? other.getCbac01() == null : this.getCbac01().equals(other.getCbac01()))
            && (this.getCbac02() == null ? other.getCbac02() == null : this.getCbac02().equals(other.getCbac02()))
            && (this.getCbac03() == null ? other.getCbac03() == null : this.getCbac03().equals(other.getCbac03()))
            && (this.getCbac04() == null ? other.getCbac04() == null : this.getCbac04().equals(other.getCbac04()))
            && (this.getCbac05() == null ? other.getCbac05() == null : this.getCbac05().equals(other.getCbac05()))
            && (this.getCbac06() == null ? other.getCbac06() == null : this.getCbac06().equals(other.getCbac06()))
            && (this.getCbac07() == null ? other.getCbac07() == null : this.getCbac07().equals(other.getCbac07()))
            && (this.getCbac08() == null ? other.getCbac08() == null : this.getCbac08().equals(other.getCbac08()))
            && (this.getCbac09() == null ? other.getCbac09() == null : this.getCbac09().equals(other.getCbac09()))
            && (this.getCbac10() == null ? other.getCbac10() == null : this.getCbac10().equals(other.getCbac10()))
            && (this.getCbac11() == null ? other.getCbac11() == null : this.getCbac11().equals(other.getCbac11()))
            && (this.getCbac12() == null ? other.getCbac12() == null : this.getCbac12().equals(other.getCbac12()))
            && (this.getCbaa01() == null ? other.getCbaa01() == null : this.getCbaa01().equals(other.getCbaa01()))
            && (this.getCbac13() == null ? other.getCbac13() == null : this.getCbac13().equals(other.getCbac13()))
            && (this.getCbac14() == null ? other.getCbac14() == null : this.getCbac14().equals(other.getCbac14()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbac01() == null) ? 0 : getCbac01().hashCode());
        result = prime * result + ((getCbac02() == null) ? 0 : getCbac02().hashCode());
        result = prime * result + ((getCbac03() == null) ? 0 : getCbac03().hashCode());
        result = prime * result + ((getCbac04() == null) ? 0 : getCbac04().hashCode());
        result = prime * result + ((getCbac05() == null) ? 0 : getCbac05().hashCode());
        result = prime * result + ((getCbac06() == null) ? 0 : getCbac06().hashCode());
        result = prime * result + ((getCbac07() == null) ? 0 : getCbac07().hashCode());
        result = prime * result + ((getCbac08() == null) ? 0 : getCbac08().hashCode());
        result = prime * result + ((getCbac09() == null) ? 0 : getCbac09().hashCode());
        result = prime * result + ((getCbac10() == null) ? 0 : getCbac10().hashCode());
        result = prime * result + ((getCbac11() == null) ? 0 : getCbac11().hashCode());
        result = prime * result + ((getCbac12() == null) ? 0 : getCbac12().hashCode());
        result = prime * result + ((getCbaa01() == null) ? 0 : getCbaa01().hashCode());
        result = prime * result + ((getCbac13() == null) ? 0 : getCbac13().hashCode());
        result = prime * result + ((getCbac14() == null) ? 0 : getCbac14().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbac01=").append(cbac01);
        sb.append(", cbac02=").append(cbac02);
        sb.append(", cbac03=").append(cbac03);
        sb.append(", cbac04=").append(cbac04);
        sb.append(", cbac05=").append(cbac05);
        sb.append(", cbac06=").append(cbac06);
        sb.append(", cbac07=").append(cbac07);
        sb.append(", cbac08=").append(cbac08);
        sb.append(", cbac09=").append(cbac09);
        sb.append(", cbac10=").append(cbac10);
        sb.append(", cbac11=").append(cbac11);
        sb.append(", cbac12=").append(cbac12);
        sb.append(", cbaa01=").append(cbaa01);
        sb.append(", cbac13=").append(cbac13);
        sb.append(", cbac14=").append(cbac14);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
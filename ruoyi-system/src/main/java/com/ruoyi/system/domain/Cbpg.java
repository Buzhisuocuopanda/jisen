package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpg implements Serializable {
    private Integer cbpg01;

    private Date cbpg02;

    private Integer cbpg03;

    private Date cbpg04;

    private Integer cbpg05;

    private Integer cbpg06;

    private String cbpg07;

    private Date cbpg08;

    private Integer cbpg09;

    private Integer cbpg10;

    private Integer cbpg11;

    private Integer cbpg12;

    private Date cbpg13;

    private Integer cbpg14;

    private Date cbpg15;

    private Integer cbpg16;

    private String cbpg17;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbpg01() {
        return cbpg01;
    }

    public void setCbpg01(Integer cbpg01) {
        this.cbpg01 = cbpg01;
    }

    public Date getCbpg02() {
        return cbpg02;
    }

    public void setCbpg02(Date cbpg02) {
        this.cbpg02 = cbpg02;
    }

    public Integer getCbpg03() {
        return cbpg03;
    }

    public void setCbpg03(Integer cbpg03) {
        this.cbpg03 = cbpg03;
    }

    public Date getCbpg04() {
        return cbpg04;
    }

    public void setCbpg04(Date cbpg04) {
        this.cbpg04 = cbpg04;
    }

    public Integer getCbpg05() {
        return cbpg05;
    }

    public void setCbpg05(Integer cbpg05) {
        this.cbpg05 = cbpg05;
    }

    public Integer getCbpg06() {
        return cbpg06;
    }

    public void setCbpg06(Integer cbpg06) {
        this.cbpg06 = cbpg06;
    }

    public String getCbpg07() {
        return cbpg07;
    }

    public void setCbpg07(String cbpg07) {
        this.cbpg07 = cbpg07 == null ? null : cbpg07.trim();
    }

    public Date getCbpg08() {
        return cbpg08;
    }

    public void setCbpg08(Date cbpg08) {
        this.cbpg08 = cbpg08;
    }

    public Integer getCbpg09() {
        return cbpg09;
    }

    public void setCbpg09(Integer cbpg09) {
        this.cbpg09 = cbpg09;
    }

    public Integer getCbpg10() {
        return cbpg10;
    }

    public void setCbpg10(Integer cbpg10) {
        this.cbpg10 = cbpg10;
    }

    public Integer getCbpg11() {
        return cbpg11;
    }

    public void setCbpg11(Integer cbpg11) {
        this.cbpg11 = cbpg11;
    }

    public Integer getCbpg12() {
        return cbpg12;
    }

    public void setCbpg12(Integer cbpg12) {
        this.cbpg12 = cbpg12;
    }

    public Date getCbpg13() {
        return cbpg13;
    }

    public void setCbpg13(Date cbpg13) {
        this.cbpg13 = cbpg13;
    }

    public Integer getCbpg14() {
        return cbpg14;
    }

    public void setCbpg14(Integer cbpg14) {
        this.cbpg14 = cbpg14;
    }

    public Date getCbpg15() {
        return cbpg15;
    }

    public void setCbpg15(Date cbpg15) {
        this.cbpg15 = cbpg15;
    }

    public Integer getCbpg16() {
        return cbpg16;
    }

    public void setCbpg16(Integer cbpg16) {
        this.cbpg16 = cbpg16;
    }

    public String getCbpg17() {
        return cbpg17;
    }

    public void setCbpg17(String cbpg17) {
        this.cbpg17 = cbpg17 == null ? null : cbpg17.trim();
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
        Cbpg other = (Cbpg) that;
        return (this.getCbpg01() == null ? other.getCbpg01() == null : this.getCbpg01().equals(other.getCbpg01()))
            && (this.getCbpg02() == null ? other.getCbpg02() == null : this.getCbpg02().equals(other.getCbpg02()))
            && (this.getCbpg03() == null ? other.getCbpg03() == null : this.getCbpg03().equals(other.getCbpg03()))
            && (this.getCbpg04() == null ? other.getCbpg04() == null : this.getCbpg04().equals(other.getCbpg04()))
            && (this.getCbpg05() == null ? other.getCbpg05() == null : this.getCbpg05().equals(other.getCbpg05()))
            && (this.getCbpg06() == null ? other.getCbpg06() == null : this.getCbpg06().equals(other.getCbpg06()))
            && (this.getCbpg07() == null ? other.getCbpg07() == null : this.getCbpg07().equals(other.getCbpg07()))
            && (this.getCbpg08() == null ? other.getCbpg08() == null : this.getCbpg08().equals(other.getCbpg08()))
            && (this.getCbpg09() == null ? other.getCbpg09() == null : this.getCbpg09().equals(other.getCbpg09()))
            && (this.getCbpg10() == null ? other.getCbpg10() == null : this.getCbpg10().equals(other.getCbpg10()))
            && (this.getCbpg11() == null ? other.getCbpg11() == null : this.getCbpg11().equals(other.getCbpg11()))
            && (this.getCbpg12() == null ? other.getCbpg12() == null : this.getCbpg12().equals(other.getCbpg12()))
            && (this.getCbpg13() == null ? other.getCbpg13() == null : this.getCbpg13().equals(other.getCbpg13()))
            && (this.getCbpg14() == null ? other.getCbpg14() == null : this.getCbpg14().equals(other.getCbpg14()))
            && (this.getCbpg15() == null ? other.getCbpg15() == null : this.getCbpg15().equals(other.getCbpg15()))
            && (this.getCbpg16() == null ? other.getCbpg16() == null : this.getCbpg16().equals(other.getCbpg16()))
            && (this.getCbpg17() == null ? other.getCbpg17() == null : this.getCbpg17().equals(other.getCbpg17()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpg01() == null) ? 0 : getCbpg01().hashCode());
        result = prime * result + ((getCbpg02() == null) ? 0 : getCbpg02().hashCode());
        result = prime * result + ((getCbpg03() == null) ? 0 : getCbpg03().hashCode());
        result = prime * result + ((getCbpg04() == null) ? 0 : getCbpg04().hashCode());
        result = prime * result + ((getCbpg05() == null) ? 0 : getCbpg05().hashCode());
        result = prime * result + ((getCbpg06() == null) ? 0 : getCbpg06().hashCode());
        result = prime * result + ((getCbpg07() == null) ? 0 : getCbpg07().hashCode());
        result = prime * result + ((getCbpg08() == null) ? 0 : getCbpg08().hashCode());
        result = prime * result + ((getCbpg09() == null) ? 0 : getCbpg09().hashCode());
        result = prime * result + ((getCbpg10() == null) ? 0 : getCbpg10().hashCode());
        result = prime * result + ((getCbpg11() == null) ? 0 : getCbpg11().hashCode());
        result = prime * result + ((getCbpg12() == null) ? 0 : getCbpg12().hashCode());
        result = prime * result + ((getCbpg13() == null) ? 0 : getCbpg13().hashCode());
        result = prime * result + ((getCbpg14() == null) ? 0 : getCbpg14().hashCode());
        result = prime * result + ((getCbpg15() == null) ? 0 : getCbpg15().hashCode());
        result = prime * result + ((getCbpg16() == null) ? 0 : getCbpg16().hashCode());
        result = prime * result + ((getCbpg17() == null) ? 0 : getCbpg17().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpg01=").append(cbpg01);
        sb.append(", cbpg02=").append(cbpg02);
        sb.append(", cbpg03=").append(cbpg03);
        sb.append(", cbpg04=").append(cbpg04);
        sb.append(", cbpg05=").append(cbpg05);
        sb.append(", cbpg06=").append(cbpg06);
        sb.append(", cbpg07=").append(cbpg07);
        sb.append(", cbpg08=").append(cbpg08);
        sb.append(", cbpg09=").append(cbpg09);
        sb.append(", cbpg10=").append(cbpg10);
        sb.append(", cbpg11=").append(cbpg11);
        sb.append(", cbpg12=").append(cbpg12);
        sb.append(", cbpg13=").append(cbpg13);
        sb.append(", cbpg14=").append(cbpg14);
        sb.append(", cbpg15=").append(cbpg15);
        sb.append(", cbpg16=").append(cbpg16);
        sb.append(", cbpg17=").append(cbpg17);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
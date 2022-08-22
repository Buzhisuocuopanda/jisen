package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsh implements Serializable {
    private Integer cbsh01;

    private Date cbsh02;

    private Date cbsh03;

    private Integer cbsh04;

    private Integer cbsh05;

    private Integer cbsh06;

    private String cbsh07;

    private Date cbsh08;

    private Integer cbsh09;

    private Integer cbsh10;

    private Integer cbsh11;

    private Date cbsh12;

    private Integer cbsh13;

    private Date cbsh14;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbsh01() {
        return cbsh01;
    }

    public void setCbsh01(Integer cbsh01) {
        this.cbsh01 = cbsh01;
    }

    public Date getCbsh02() {
        return cbsh02;
    }

    public void setCbsh02(Date cbsh02) {
        this.cbsh02 = cbsh02;
    }

    public Date getCbsh03() {
        return cbsh03;
    }

    public void setCbsh03(Date cbsh03) {
        this.cbsh03 = cbsh03;
    }

    public Integer getCbsh04() {
        return cbsh04;
    }

    public void setCbsh04(Integer cbsh04) {
        this.cbsh04 = cbsh04;
    }

    public Integer getCbsh05() {
        return cbsh05;
    }

    public void setCbsh05(Integer cbsh05) {
        this.cbsh05 = cbsh05;
    }

    public Integer getCbsh06() {
        return cbsh06;
    }

    public void setCbsh06(Integer cbsh06) {
        this.cbsh06 = cbsh06;
    }

    public String getCbsh07() {
        return cbsh07;
    }

    public void setCbsh07(String cbsh07) {
        this.cbsh07 = cbsh07 == null ? null : cbsh07.trim();
    }

    public Date getCbsh08() {
        return cbsh08;
    }

    public void setCbsh08(Date cbsh08) {
        this.cbsh08 = cbsh08;
    }

    public Integer getCbsh09() {
        return cbsh09;
    }

    public void setCbsh09(Integer cbsh09) {
        this.cbsh09 = cbsh09;
    }

    public Integer getCbsh10() {
        return cbsh10;
    }

    public void setCbsh10(Integer cbsh10) {
        this.cbsh10 = cbsh10;
    }

    public Integer getCbsh11() {
        return cbsh11;
    }

    public void setCbsh11(Integer cbsh11) {
        this.cbsh11 = cbsh11;
    }

    public Date getCbsh12() {
        return cbsh12;
    }

    public void setCbsh12(Date cbsh12) {
        this.cbsh12 = cbsh12;
    }

    public Integer getCbsh13() {
        return cbsh13;
    }

    public void setCbsh13(Integer cbsh13) {
        this.cbsh13 = cbsh13;
    }

    public Date getCbsh14() {
        return cbsh14;
    }

    public void setCbsh14(Date cbsh14) {
        this.cbsh14 = cbsh14;
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
        Cbsh other = (Cbsh) that;
        return (this.getCbsh01() == null ? other.getCbsh01() == null : this.getCbsh01().equals(other.getCbsh01()))
            && (this.getCbsh02() == null ? other.getCbsh02() == null : this.getCbsh02().equals(other.getCbsh02()))
            && (this.getCbsh03() == null ? other.getCbsh03() == null : this.getCbsh03().equals(other.getCbsh03()))
            && (this.getCbsh04() == null ? other.getCbsh04() == null : this.getCbsh04().equals(other.getCbsh04()))
            && (this.getCbsh05() == null ? other.getCbsh05() == null : this.getCbsh05().equals(other.getCbsh05()))
            && (this.getCbsh06() == null ? other.getCbsh06() == null : this.getCbsh06().equals(other.getCbsh06()))
            && (this.getCbsh07() == null ? other.getCbsh07() == null : this.getCbsh07().equals(other.getCbsh07()))
            && (this.getCbsh08() == null ? other.getCbsh08() == null : this.getCbsh08().equals(other.getCbsh08()))
            && (this.getCbsh09() == null ? other.getCbsh09() == null : this.getCbsh09().equals(other.getCbsh09()))
            && (this.getCbsh10() == null ? other.getCbsh10() == null : this.getCbsh10().equals(other.getCbsh10()))
            && (this.getCbsh11() == null ? other.getCbsh11() == null : this.getCbsh11().equals(other.getCbsh11()))
            && (this.getCbsh12() == null ? other.getCbsh12() == null : this.getCbsh12().equals(other.getCbsh12()))
            && (this.getCbsh13() == null ? other.getCbsh13() == null : this.getCbsh13().equals(other.getCbsh13()))
            && (this.getCbsh14() == null ? other.getCbsh14() == null : this.getCbsh14().equals(other.getCbsh14()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsh01() == null) ? 0 : getCbsh01().hashCode());
        result = prime * result + ((getCbsh02() == null) ? 0 : getCbsh02().hashCode());
        result = prime * result + ((getCbsh03() == null) ? 0 : getCbsh03().hashCode());
        result = prime * result + ((getCbsh04() == null) ? 0 : getCbsh04().hashCode());
        result = prime * result + ((getCbsh05() == null) ? 0 : getCbsh05().hashCode());
        result = prime * result + ((getCbsh06() == null) ? 0 : getCbsh06().hashCode());
        result = prime * result + ((getCbsh07() == null) ? 0 : getCbsh07().hashCode());
        result = prime * result + ((getCbsh08() == null) ? 0 : getCbsh08().hashCode());
        result = prime * result + ((getCbsh09() == null) ? 0 : getCbsh09().hashCode());
        result = prime * result + ((getCbsh10() == null) ? 0 : getCbsh10().hashCode());
        result = prime * result + ((getCbsh11() == null) ? 0 : getCbsh11().hashCode());
        result = prime * result + ((getCbsh12() == null) ? 0 : getCbsh12().hashCode());
        result = prime * result + ((getCbsh13() == null) ? 0 : getCbsh13().hashCode());
        result = prime * result + ((getCbsh14() == null) ? 0 : getCbsh14().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsh01=").append(cbsh01);
        sb.append(", cbsh02=").append(cbsh02);
        sb.append(", cbsh03=").append(cbsh03);
        sb.append(", cbsh04=").append(cbsh04);
        sb.append(", cbsh05=").append(cbsh05);
        sb.append(", cbsh06=").append(cbsh06);
        sb.append(", cbsh07=").append(cbsh07);
        sb.append(", cbsh08=").append(cbsh08);
        sb.append(", cbsh09=").append(cbsh09);
        sb.append(", cbsh10=").append(cbsh10);
        sb.append(", cbsh11=").append(cbsh11);
        sb.append(", cbsh12=").append(cbsh12);
        sb.append(", cbsh13=").append(cbsh13);
        sb.append(", cbsh14=").append(cbsh14);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
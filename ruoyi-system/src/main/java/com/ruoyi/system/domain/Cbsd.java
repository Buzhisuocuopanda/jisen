package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsd implements Serializable {
    private Integer cbsd01;

    private Integer cbsd02;

    private Date cbsd03;

    private Integer cbsd04;

    private Date cbsd05;

    private Integer cbsd06;

    private Integer cbsd07;

    private Integer cbsd08;

    private String cbsd09;

    private Integer cbsd10;

    private Integer cbsd11;

    private String cbsd12;

    private Integer cbsb01;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbsd01() {
        return cbsd01;
    }

    public void setCbsd01(Integer cbsd01) {
        this.cbsd01 = cbsd01;
    }

    public Integer getCbsd02() {
        return cbsd02;
    }

    public void setCbsd02(Integer cbsd02) {
        this.cbsd02 = cbsd02;
    }

    public Date getCbsd03() {
        return cbsd03;
    }

    public void setCbsd03(Date cbsd03) {
        this.cbsd03 = cbsd03;
    }

    public Integer getCbsd04() {
        return cbsd04;
    }

    public void setCbsd04(Integer cbsd04) {
        this.cbsd04 = cbsd04;
    }

    public Date getCbsd05() {
        return cbsd05;
    }

    public void setCbsd05(Date cbsd05) {
        this.cbsd05 = cbsd05;
    }

    public Integer getCbsd06() {
        return cbsd06;
    }

    public void setCbsd06(Integer cbsd06) {
        this.cbsd06 = cbsd06;
    }

    public Integer getCbsd07() {
        return cbsd07;
    }

    public void setCbsd07(Integer cbsd07) {
        this.cbsd07 = cbsd07;
    }

    public Integer getCbsd08() {
        return cbsd08;
    }

    public void setCbsd08(Integer cbsd08) {
        this.cbsd08 = cbsd08;
    }

    public String getCbsd09() {
        return cbsd09;
    }

    public void setCbsd09(String cbsd09) {
        this.cbsd09 = cbsd09 == null ? null : cbsd09.trim();
    }

    public Integer getCbsd10() {
        return cbsd10;
    }

    public void setCbsd10(Integer cbsd10) {
        this.cbsd10 = cbsd10;
    }

    public Integer getCbsd11() {
        return cbsd11;
    }

    public void setCbsd11(Integer cbsd11) {
        this.cbsd11 = cbsd11;
    }

    public String getCbsd12() {
        return cbsd12;
    }

    public void setCbsd12(String cbsd12) {
        this.cbsd12 = cbsd12 == null ? null : cbsd12.trim();
    }

    public Integer getCbsb01() {
        return cbsb01;
    }

    public void setCbsb01(Integer cbsb01) {
        this.cbsb01 = cbsb01;
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
        Cbsd other = (Cbsd) that;
        return (this.getCbsd01() == null ? other.getCbsd01() == null : this.getCbsd01().equals(other.getCbsd01()))
            && (this.getCbsd02() == null ? other.getCbsd02() == null : this.getCbsd02().equals(other.getCbsd02()))
            && (this.getCbsd03() == null ? other.getCbsd03() == null : this.getCbsd03().equals(other.getCbsd03()))
            && (this.getCbsd04() == null ? other.getCbsd04() == null : this.getCbsd04().equals(other.getCbsd04()))
            && (this.getCbsd05() == null ? other.getCbsd05() == null : this.getCbsd05().equals(other.getCbsd05()))
            && (this.getCbsd06() == null ? other.getCbsd06() == null : this.getCbsd06().equals(other.getCbsd06()))
            && (this.getCbsd07() == null ? other.getCbsd07() == null : this.getCbsd07().equals(other.getCbsd07()))
            && (this.getCbsd08() == null ? other.getCbsd08() == null : this.getCbsd08().equals(other.getCbsd08()))
            && (this.getCbsd09() == null ? other.getCbsd09() == null : this.getCbsd09().equals(other.getCbsd09()))
            && (this.getCbsd10() == null ? other.getCbsd10() == null : this.getCbsd10().equals(other.getCbsd10()))
            && (this.getCbsd11() == null ? other.getCbsd11() == null : this.getCbsd11().equals(other.getCbsd11()))
            && (this.getCbsd12() == null ? other.getCbsd12() == null : this.getCbsd12().equals(other.getCbsd12()))
            && (this.getCbsb01() == null ? other.getCbsb01() == null : this.getCbsb01().equals(other.getCbsb01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsd01() == null) ? 0 : getCbsd01().hashCode());
        result = prime * result + ((getCbsd02() == null) ? 0 : getCbsd02().hashCode());
        result = prime * result + ((getCbsd03() == null) ? 0 : getCbsd03().hashCode());
        result = prime * result + ((getCbsd04() == null) ? 0 : getCbsd04().hashCode());
        result = prime * result + ((getCbsd05() == null) ? 0 : getCbsd05().hashCode());
        result = prime * result + ((getCbsd06() == null) ? 0 : getCbsd06().hashCode());
        result = prime * result + ((getCbsd07() == null) ? 0 : getCbsd07().hashCode());
        result = prime * result + ((getCbsd08() == null) ? 0 : getCbsd08().hashCode());
        result = prime * result + ((getCbsd09() == null) ? 0 : getCbsd09().hashCode());
        result = prime * result + ((getCbsd10() == null) ? 0 : getCbsd10().hashCode());
        result = prime * result + ((getCbsd11() == null) ? 0 : getCbsd11().hashCode());
        result = prime * result + ((getCbsd12() == null) ? 0 : getCbsd12().hashCode());
        result = prime * result + ((getCbsb01() == null) ? 0 : getCbsb01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsd01=").append(cbsd01);
        sb.append(", cbsd02=").append(cbsd02);
        sb.append(", cbsd03=").append(cbsd03);
        sb.append(", cbsd04=").append(cbsd04);
        sb.append(", cbsd05=").append(cbsd05);
        sb.append(", cbsd06=").append(cbsd06);
        sb.append(", cbsd07=").append(cbsd07);
        sb.append(", cbsd08=").append(cbsd08);
        sb.append(", cbsd09=").append(cbsd09);
        sb.append(", cbsd10=").append(cbsd10);
        sb.append(", cbsd11=").append(cbsd11);
        sb.append(", cbsd12=").append(cbsd12);
        sb.append(", cbsb01=").append(cbsb01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
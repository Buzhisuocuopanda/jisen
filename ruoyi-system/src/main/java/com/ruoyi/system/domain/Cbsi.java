package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsi implements Serializable {
    private Integer cbsi01;

    private Integer cbsi02;

    private Date cbsi03;

    private Date cbsi04;

    private Integer cbsi05;

    private Integer cbsi06;

    private Integer cbsi07;

    private Integer cbsi08;

    private Double cbsi09;

    private Double cbsi10;

    private String cbsi11;

    private Double cbsi12;

    private Double cbsi13;

    private Integer cbsh01;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbsi01() {
        return cbsi01;
    }

    public void setCbsi01(Integer cbsi01) {
        this.cbsi01 = cbsi01;
    }

    public Integer getCbsi02() {
        return cbsi02;
    }

    public void setCbsi02(Integer cbsi02) {
        this.cbsi02 = cbsi02;
    }

    public Date getCbsi03() {
        return cbsi03;
    }

    public void setCbsi03(Date cbsi03) {
        this.cbsi03 = cbsi03;
    }

    public Date getCbsi04() {
        return cbsi04;
    }

    public void setCbsi04(Date cbsi04) {
        this.cbsi04 = cbsi04;
    }

    public Integer getCbsi05() {
        return cbsi05;
    }

    public void setCbsi05(Integer cbsi05) {
        this.cbsi05 = cbsi05;
    }

    public Integer getCbsi06() {
        return cbsi06;
    }

    public void setCbsi06(Integer cbsi06) {
        this.cbsi06 = cbsi06;
    }

    public Integer getCbsi07() {
        return cbsi07;
    }

    public void setCbsi07(Integer cbsi07) {
        this.cbsi07 = cbsi07;
    }

    public Integer getCbsi08() {
        return cbsi08;
    }

    public void setCbsi08(Integer cbsi08) {
        this.cbsi08 = cbsi08;
    }

    public Double getCbsi09() {
        return cbsi09;
    }

    public void setCbsi09(Double cbsi09) {
        this.cbsi09 = cbsi09;
    }

    public Double getCbsi10() {
        return cbsi10;
    }

    public void setCbsi10(Double cbsi10) {
        this.cbsi10 = cbsi10;
    }

    public String getCbsi11() {
        return cbsi11;
    }

    public void setCbsi11(String cbsi11) {
        this.cbsi11 = cbsi11 == null ? null : cbsi11.trim();
    }

    public Double getCbsi12() {
        return cbsi12;
    }

    public void setCbsi12(Double cbsi12) {
        this.cbsi12 = cbsi12;
    }

    public Double getCbsi13() {
        return cbsi13;
    }

    public void setCbsi13(Double cbsi13) {
        this.cbsi13 = cbsi13;
    }

    public Integer getCbsh01() {
        return cbsh01;
    }

    public void setCbsh01(Integer cbsh01) {
        this.cbsh01 = cbsh01;
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
        Cbsi other = (Cbsi) that;
        return (this.getCbsi01() == null ? other.getCbsi01() == null : this.getCbsi01().equals(other.getCbsi01()))
            && (this.getCbsi02() == null ? other.getCbsi02() == null : this.getCbsi02().equals(other.getCbsi02()))
            && (this.getCbsi03() == null ? other.getCbsi03() == null : this.getCbsi03().equals(other.getCbsi03()))
            && (this.getCbsi04() == null ? other.getCbsi04() == null : this.getCbsi04().equals(other.getCbsi04()))
            && (this.getCbsi05() == null ? other.getCbsi05() == null : this.getCbsi05().equals(other.getCbsi05()))
            && (this.getCbsi06() == null ? other.getCbsi06() == null : this.getCbsi06().equals(other.getCbsi06()))
            && (this.getCbsi07() == null ? other.getCbsi07() == null : this.getCbsi07().equals(other.getCbsi07()))
            && (this.getCbsi08() == null ? other.getCbsi08() == null : this.getCbsi08().equals(other.getCbsi08()))
            && (this.getCbsi09() == null ? other.getCbsi09() == null : this.getCbsi09().equals(other.getCbsi09()))
            && (this.getCbsi10() == null ? other.getCbsi10() == null : this.getCbsi10().equals(other.getCbsi10()))
            && (this.getCbsi11() == null ? other.getCbsi11() == null : this.getCbsi11().equals(other.getCbsi11()))
            && (this.getCbsi12() == null ? other.getCbsi12() == null : this.getCbsi12().equals(other.getCbsi12()))
            && (this.getCbsi13() == null ? other.getCbsi13() == null : this.getCbsi13().equals(other.getCbsi13()))
            && (this.getCbsh01() == null ? other.getCbsh01() == null : this.getCbsh01().equals(other.getCbsh01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsi01() == null) ? 0 : getCbsi01().hashCode());
        result = prime * result + ((getCbsi02() == null) ? 0 : getCbsi02().hashCode());
        result = prime * result + ((getCbsi03() == null) ? 0 : getCbsi03().hashCode());
        result = prime * result + ((getCbsi04() == null) ? 0 : getCbsi04().hashCode());
        result = prime * result + ((getCbsi05() == null) ? 0 : getCbsi05().hashCode());
        result = prime * result + ((getCbsi06() == null) ? 0 : getCbsi06().hashCode());
        result = prime * result + ((getCbsi07() == null) ? 0 : getCbsi07().hashCode());
        result = prime * result + ((getCbsi08() == null) ? 0 : getCbsi08().hashCode());
        result = prime * result + ((getCbsi09() == null) ? 0 : getCbsi09().hashCode());
        result = prime * result + ((getCbsi10() == null) ? 0 : getCbsi10().hashCode());
        result = prime * result + ((getCbsi11() == null) ? 0 : getCbsi11().hashCode());
        result = prime * result + ((getCbsi12() == null) ? 0 : getCbsi12().hashCode());
        result = prime * result + ((getCbsi13() == null) ? 0 : getCbsi13().hashCode());
        result = prime * result + ((getCbsh01() == null) ? 0 : getCbsh01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsi01=").append(cbsi01);
        sb.append(", cbsi02=").append(cbsi02);
        sb.append(", cbsi03=").append(cbsi03);
        sb.append(", cbsi04=").append(cbsi04);
        sb.append(", cbsi05=").append(cbsi05);
        sb.append(", cbsi06=").append(cbsi06);
        sb.append(", cbsi07=").append(cbsi07);
        sb.append(", cbsi08=").append(cbsi08);
        sb.append(", cbsi09=").append(cbsi09);
        sb.append(", cbsi10=").append(cbsi10);
        sb.append(", cbsi11=").append(cbsi11);
        sb.append(", cbsi12=").append(cbsi12);
        sb.append(", cbsi13=").append(cbsi13);
        sb.append(", cbsh01=").append(cbsh01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
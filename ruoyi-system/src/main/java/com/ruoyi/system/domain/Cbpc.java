package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpc implements Serializable {
    private Integer cbpc01;

    private Date cbpc02;

    private Integer cbpc03;

    private Date cbpc04;

    private Integer cbpc05;

    private Integer cbpc06;

    private String cbpc07;

    private Date cbpc08;

    private Integer cbpc09;

    private Integer cbpc10;

    private Integer cbpc11;

    private Integer cbpc12;

    private Date cbpc13;

    private Integer cbpc14;

    private Date cbpc15;

    private Integer cbpc16;

    private String cbpc17;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbpc01() {
        return cbpc01;
    }

    public void setCbpc01(Integer cbpc01) {
        this.cbpc01 = cbpc01;
    }

    public Date getCbpc02() {
        return cbpc02;
    }

    public void setCbpc02(Date cbpc02) {
        this.cbpc02 = cbpc02;
    }

    public Integer getCbpc03() {
        return cbpc03;
    }

    public void setCbpc03(Integer cbpc03) {
        this.cbpc03 = cbpc03;
    }

    public Date getCbpc04() {
        return cbpc04;
    }

    public void setCbpc04(Date cbpc04) {
        this.cbpc04 = cbpc04;
    }

    public Integer getCbpc05() {
        return cbpc05;
    }

    public void setCbpc05(Integer cbpc05) {
        this.cbpc05 = cbpc05;
    }

    public Integer getCbpc06() {
        return cbpc06;
    }

    public void setCbpc06(Integer cbpc06) {
        this.cbpc06 = cbpc06;
    }

    public String getCbpc07() {
        return cbpc07;
    }

    public void setCbpc07(String cbpc07) {
        this.cbpc07 = cbpc07 == null ? null : cbpc07.trim();
    }

    public Date getCbpc08() {
        return cbpc08;
    }

    public void setCbpc08(Date cbpc08) {
        this.cbpc08 = cbpc08;
    }

    public Integer getCbpc09() {
        return cbpc09;
    }

    public void setCbpc09(Integer cbpc09) {
        this.cbpc09 = cbpc09;
    }

    public Integer getCbpc10() {
        return cbpc10;
    }

    public void setCbpc10(Integer cbpc10) {
        this.cbpc10 = cbpc10;
    }

    public Integer getCbpc11() {
        return cbpc11;
    }

    public void setCbpc11(Integer cbpc11) {
        this.cbpc11 = cbpc11;
    }

    public Integer getCbpc12() {
        return cbpc12;
    }

    public void setCbpc12(Integer cbpc12) {
        this.cbpc12 = cbpc12;
    }

    public Date getCbpc13() {
        return cbpc13;
    }

    public void setCbpc13(Date cbpc13) {
        this.cbpc13 = cbpc13;
    }

    public Integer getCbpc14() {
        return cbpc14;
    }

    public void setCbpc14(Integer cbpc14) {
        this.cbpc14 = cbpc14;
    }

    public Date getCbpc15() {
        return cbpc15;
    }

    public void setCbpc15(Date cbpc15) {
        this.cbpc15 = cbpc15;
    }

    public Integer getCbpc16() {
        return cbpc16;
    }

    public void setCbpc16(Integer cbpc16) {
        this.cbpc16 = cbpc16;
    }

    public String getCbpc17() {
        return cbpc17;
    }

    public void setCbpc17(String cbpc17) {
        this.cbpc17 = cbpc17 == null ? null : cbpc17.trim();
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
        Cbpc other = (Cbpc) that;
        return (this.getCbpc01() == null ? other.getCbpc01() == null : this.getCbpc01().equals(other.getCbpc01()))
            && (this.getCbpc02() == null ? other.getCbpc02() == null : this.getCbpc02().equals(other.getCbpc02()))
            && (this.getCbpc03() == null ? other.getCbpc03() == null : this.getCbpc03().equals(other.getCbpc03()))
            && (this.getCbpc04() == null ? other.getCbpc04() == null : this.getCbpc04().equals(other.getCbpc04()))
            && (this.getCbpc05() == null ? other.getCbpc05() == null : this.getCbpc05().equals(other.getCbpc05()))
            && (this.getCbpc06() == null ? other.getCbpc06() == null : this.getCbpc06().equals(other.getCbpc06()))
            && (this.getCbpc07() == null ? other.getCbpc07() == null : this.getCbpc07().equals(other.getCbpc07()))
            && (this.getCbpc08() == null ? other.getCbpc08() == null : this.getCbpc08().equals(other.getCbpc08()))
            && (this.getCbpc09() == null ? other.getCbpc09() == null : this.getCbpc09().equals(other.getCbpc09()))
            && (this.getCbpc10() == null ? other.getCbpc10() == null : this.getCbpc10().equals(other.getCbpc10()))
            && (this.getCbpc11() == null ? other.getCbpc11() == null : this.getCbpc11().equals(other.getCbpc11()))
            && (this.getCbpc12() == null ? other.getCbpc12() == null : this.getCbpc12().equals(other.getCbpc12()))
            && (this.getCbpc13() == null ? other.getCbpc13() == null : this.getCbpc13().equals(other.getCbpc13()))
            && (this.getCbpc14() == null ? other.getCbpc14() == null : this.getCbpc14().equals(other.getCbpc14()))
            && (this.getCbpc15() == null ? other.getCbpc15() == null : this.getCbpc15().equals(other.getCbpc15()))
            && (this.getCbpc16() == null ? other.getCbpc16() == null : this.getCbpc16().equals(other.getCbpc16()))
            && (this.getCbpc17() == null ? other.getCbpc17() == null : this.getCbpc17().equals(other.getCbpc17()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpc01() == null) ? 0 : getCbpc01().hashCode());
        result = prime * result + ((getCbpc02() == null) ? 0 : getCbpc02().hashCode());
        result = prime * result + ((getCbpc03() == null) ? 0 : getCbpc03().hashCode());
        result = prime * result + ((getCbpc04() == null) ? 0 : getCbpc04().hashCode());
        result = prime * result + ((getCbpc05() == null) ? 0 : getCbpc05().hashCode());
        result = prime * result + ((getCbpc06() == null) ? 0 : getCbpc06().hashCode());
        result = prime * result + ((getCbpc07() == null) ? 0 : getCbpc07().hashCode());
        result = prime * result + ((getCbpc08() == null) ? 0 : getCbpc08().hashCode());
        result = prime * result + ((getCbpc09() == null) ? 0 : getCbpc09().hashCode());
        result = prime * result + ((getCbpc10() == null) ? 0 : getCbpc10().hashCode());
        result = prime * result + ((getCbpc11() == null) ? 0 : getCbpc11().hashCode());
        result = prime * result + ((getCbpc12() == null) ? 0 : getCbpc12().hashCode());
        result = prime * result + ((getCbpc13() == null) ? 0 : getCbpc13().hashCode());
        result = prime * result + ((getCbpc14() == null) ? 0 : getCbpc14().hashCode());
        result = prime * result + ((getCbpc15() == null) ? 0 : getCbpc15().hashCode());
        result = prime * result + ((getCbpc16() == null) ? 0 : getCbpc16().hashCode());
        result = prime * result + ((getCbpc17() == null) ? 0 : getCbpc17().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpc01=").append(cbpc01);
        sb.append(", cbpc02=").append(cbpc02);
        sb.append(", cbpc03=").append(cbpc03);
        sb.append(", cbpc04=").append(cbpc04);
        sb.append(", cbpc05=").append(cbpc05);
        sb.append(", cbpc06=").append(cbpc06);
        sb.append(", cbpc07=").append(cbpc07);
        sb.append(", cbpc08=").append(cbpc08);
        sb.append(", cbpc09=").append(cbpc09);
        sb.append(", cbpc10=").append(cbpc10);
        sb.append(", cbpc11=").append(cbpc11);
        sb.append(", cbpc12=").append(cbpc12);
        sb.append(", cbpc13=").append(cbpc13);
        sb.append(", cbpc14=").append(cbpc14);
        sb.append(", cbpc15=").append(cbpc15);
        sb.append(", cbpc16=").append(cbpc16);
        sb.append(", cbpc17=").append(cbpc17);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
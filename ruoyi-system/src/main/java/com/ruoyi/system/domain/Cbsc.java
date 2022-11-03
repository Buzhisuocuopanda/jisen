package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsc implements Serializable {
    private Integer cbsc01;

    private Integer cbsc02;

    private Date cbsc03;

    private Integer cbsc04;

    private Date cbsc05;

    private Integer cbsc06;

    private Integer cbsc07;

    private Integer cbsc08;

    private Double cbsc09;

    private Double cbsc10;

    private Double cbsc11;

    private Double cbsc12;

    private String cbsc13;

    private Integer cbsb01;

    private Integer cbsc14;

    private Integer cbsc15;

    private Integer cbsc16;

    private Integer cbsc17;

    private Integer userId;

    private Integer takegoodsid;

    private Integer scannum;

    private static final long serialVersionUID = 1L;

    public Integer getCbsc01() {
        return cbsc01;
    }

    public void setCbsc01(Integer cbsc01) {
        this.cbsc01 = cbsc01;
    }

    public Integer getCbsc02() {
        return cbsc02;
    }

    public void setCbsc02(Integer cbsc02) {
        this.cbsc02 = cbsc02;
    }

    public Date getCbsc03() {
        return cbsc03;
    }

    public void setCbsc03(Date cbsc03) {
        this.cbsc03 = cbsc03;
    }

    public Integer getCbsc04() {
        return cbsc04;
    }

    public void setCbsc04(Integer cbsc04) {
        this.cbsc04 = cbsc04;
    }

    public Date getCbsc05() {
        return cbsc05;
    }

    public void setCbsc05(Date cbsc05) {
        this.cbsc05 = cbsc05;
    }

    public Integer getCbsc06() {
        return cbsc06;
    }

    public void setCbsc06(Integer cbsc06) {
        this.cbsc06 = cbsc06;
    }

    public Integer getCbsc07() {
        return cbsc07;
    }

    public void setCbsc07(Integer cbsc07) {
        this.cbsc07 = cbsc07;
    }

    public Integer getCbsc08() {
        return cbsc08;
    }

    public void setCbsc08(Integer cbsc08) {
        this.cbsc08 = cbsc08;
    }

    public Double getCbsc09() {
        return cbsc09;
    }

    public void setCbsc09(Double cbsc09) {
        this.cbsc09 = cbsc09;
    }

    public Double getCbsc10() {
        return cbsc10;
    }

    public void setCbsc10(Double cbsc10) {
        this.cbsc10 = cbsc10;
    }

    public Double getCbsc11() {
        return cbsc11;
    }

    public void setCbsc11(Double cbsc11) {
        this.cbsc11 = cbsc11;
    }

    public Double getCbsc12() {
        return cbsc12;
    }

    public void setCbsc12(Double cbsc12) {
        this.cbsc12 = cbsc12;
    }

    public String getCbsc13() {
        return cbsc13;
    }

    public void setCbsc13(String cbsc13) {
        this.cbsc13 = cbsc13 == null ? null : cbsc13.trim();
    }

    public Integer getCbsb01() {
        return cbsb01;
    }

    public void setCbsb01(Integer cbsb01) {
        this.cbsb01 = cbsb01;
    }

    public Integer getCbsc14() {
        return cbsc14;
    }

    public void setCbsc14(Integer cbsc14) {
        this.cbsc14 = cbsc14;
    }

    public Integer getCbsc15() {
        return cbsc15;
    }

    public void setCbsc15(Integer cbsc15) {
        this.cbsc15 = cbsc15;
    }

    public Integer getCbsc16() {
        return cbsc16;
    }

    public void setCbsc16(Integer cbsc16) {
        this.cbsc16 = cbsc16;
    }

    public Integer getCbsc17() {
        return cbsc17;
    }

    public void setCbsc17(Integer cbsc17) {
        this.cbsc17 = cbsc17;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTakegoodsid() {
        return takegoodsid;
    }

    public void setTakegoodsid(Integer takegoodsid) {
        this.takegoodsid = takegoodsid;
    }

    public Integer getScannum() {
        return scannum;
    }

    public void setScannum(Integer scannum) {
        this.scannum = scannum;
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
        Cbsc other = (Cbsc) that;
        return (this.getCbsc01() == null ? other.getCbsc01() == null : this.getCbsc01().equals(other.getCbsc01()))
            && (this.getCbsc02() == null ? other.getCbsc02() == null : this.getCbsc02().equals(other.getCbsc02()))
            && (this.getCbsc03() == null ? other.getCbsc03() == null : this.getCbsc03().equals(other.getCbsc03()))
            && (this.getCbsc04() == null ? other.getCbsc04() == null : this.getCbsc04().equals(other.getCbsc04()))
            && (this.getCbsc05() == null ? other.getCbsc05() == null : this.getCbsc05().equals(other.getCbsc05()))
            && (this.getCbsc06() == null ? other.getCbsc06() == null : this.getCbsc06().equals(other.getCbsc06()))
            && (this.getCbsc07() == null ? other.getCbsc07() == null : this.getCbsc07().equals(other.getCbsc07()))
            && (this.getCbsc08() == null ? other.getCbsc08() == null : this.getCbsc08().equals(other.getCbsc08()))
            && (this.getCbsc09() == null ? other.getCbsc09() == null : this.getCbsc09().equals(other.getCbsc09()))
            && (this.getCbsc10() == null ? other.getCbsc10() == null : this.getCbsc10().equals(other.getCbsc10()))
            && (this.getCbsc11() == null ? other.getCbsc11() == null : this.getCbsc11().equals(other.getCbsc11()))
            && (this.getCbsc12() == null ? other.getCbsc12() == null : this.getCbsc12().equals(other.getCbsc12()))
            && (this.getCbsc13() == null ? other.getCbsc13() == null : this.getCbsc13().equals(other.getCbsc13()))
            && (this.getCbsb01() == null ? other.getCbsb01() == null : this.getCbsb01().equals(other.getCbsb01()))
            && (this.getCbsc14() == null ? other.getCbsc14() == null : this.getCbsc14().equals(other.getCbsc14()))
            && (this.getCbsc15() == null ? other.getCbsc15() == null : this.getCbsc15().equals(other.getCbsc15()))
            && (this.getCbsc16() == null ? other.getCbsc16() == null : this.getCbsc16().equals(other.getCbsc16()))
            && (this.getCbsc17() == null ? other.getCbsc17() == null : this.getCbsc17().equals(other.getCbsc17()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTakegoodsid() == null ? other.getTakegoodsid() == null : this.getTakegoodsid().equals(other.getTakegoodsid()))
            && (this.getScannum() == null ? other.getScannum() == null : this.getScannum().equals(other.getScannum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsc01() == null) ? 0 : getCbsc01().hashCode());
        result = prime * result + ((getCbsc02() == null) ? 0 : getCbsc02().hashCode());
        result = prime * result + ((getCbsc03() == null) ? 0 : getCbsc03().hashCode());
        result = prime * result + ((getCbsc04() == null) ? 0 : getCbsc04().hashCode());
        result = prime * result + ((getCbsc05() == null) ? 0 : getCbsc05().hashCode());
        result = prime * result + ((getCbsc06() == null) ? 0 : getCbsc06().hashCode());
        result = prime * result + ((getCbsc07() == null) ? 0 : getCbsc07().hashCode());
        result = prime * result + ((getCbsc08() == null) ? 0 : getCbsc08().hashCode());
        result = prime * result + ((getCbsc09() == null) ? 0 : getCbsc09().hashCode());
        result = prime * result + ((getCbsc10() == null) ? 0 : getCbsc10().hashCode());
        result = prime * result + ((getCbsc11() == null) ? 0 : getCbsc11().hashCode());
        result = prime * result + ((getCbsc12() == null) ? 0 : getCbsc12().hashCode());
        result = prime * result + ((getCbsc13() == null) ? 0 : getCbsc13().hashCode());
        result = prime * result + ((getCbsb01() == null) ? 0 : getCbsb01().hashCode());
        result = prime * result + ((getCbsc14() == null) ? 0 : getCbsc14().hashCode());
        result = prime * result + ((getCbsc15() == null) ? 0 : getCbsc15().hashCode());
        result = prime * result + ((getCbsc16() == null) ? 0 : getCbsc16().hashCode());
        result = prime * result + ((getCbsc17() == null) ? 0 : getCbsc17().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTakegoodsid() == null) ? 0 : getTakegoodsid().hashCode());
        result = prime * result + ((getScannum() == null) ? 0 : getScannum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsc01=").append(cbsc01);
        sb.append(", cbsc02=").append(cbsc02);
        sb.append(", cbsc03=").append(cbsc03);
        sb.append(", cbsc04=").append(cbsc04);
        sb.append(", cbsc05=").append(cbsc05);
        sb.append(", cbsc06=").append(cbsc06);
        sb.append(", cbsc07=").append(cbsc07);
        sb.append(", cbsc08=").append(cbsc08);
        sb.append(", cbsc09=").append(cbsc09);
        sb.append(", cbsc10=").append(cbsc10);
        sb.append(", cbsc11=").append(cbsc11);
        sb.append(", cbsc12=").append(cbsc12);
        sb.append(", cbsc13=").append(cbsc13);
        sb.append(", cbsb01=").append(cbsb01);
        sb.append(", cbsc14=").append(cbsc14);
        sb.append(", cbsc15=").append(cbsc15);
        sb.append(", cbsc16=").append(cbsc16);
        sb.append(", cbsc17=").append(cbsc17);
        sb.append(", userId=").append(userId);
        sb.append(", takegoodsid=").append(takegoodsid);
        sb.append(", scannum=").append(scannum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

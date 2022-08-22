package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbie implements Serializable {
    private Integer cbie01;

    private Date cbie02;

    private Integer cbie03;

    private Date cbie04;

    private Integer cbie05;

    private Integer cbie06;

    private String cbie07;

    private Date cbie08;

    private Integer cbie09;

    private Integer cbie10;

    private Integer cbie11;

    private Date cbie12;

    private Integer cbie13;

    private Date cbie14;

    private String cbie15;

    private Integer cbie16;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbie01() {
        return cbie01;
    }

    public void setCbie01(Integer cbie01) {
        this.cbie01 = cbie01;
    }

    public Date getCbie02() {
        return cbie02;
    }

    public void setCbie02(Date cbie02) {
        this.cbie02 = cbie02;
    }

    public Integer getCbie03() {
        return cbie03;
    }

    public void setCbie03(Integer cbie03) {
        this.cbie03 = cbie03;
    }

    public Date getCbie04() {
        return cbie04;
    }

    public void setCbie04(Date cbie04) {
        this.cbie04 = cbie04;
    }

    public Integer getCbie05() {
        return cbie05;
    }

    public void setCbie05(Integer cbie05) {
        this.cbie05 = cbie05;
    }

    public Integer getCbie06() {
        return cbie06;
    }

    public void setCbie06(Integer cbie06) {
        this.cbie06 = cbie06;
    }

    public String getCbie07() {
        return cbie07;
    }

    public void setCbie07(String cbie07) {
        this.cbie07 = cbie07 == null ? null : cbie07.trim();
    }

    public Date getCbie08() {
        return cbie08;
    }

    public void setCbie08(Date cbie08) {
        this.cbie08 = cbie08;
    }

    public Integer getCbie09() {
        return cbie09;
    }

    public void setCbie09(Integer cbie09) {
        this.cbie09 = cbie09;
    }

    public Integer getCbie10() {
        return cbie10;
    }

    public void setCbie10(Integer cbie10) {
        this.cbie10 = cbie10;
    }

    public Integer getCbie11() {
        return cbie11;
    }

    public void setCbie11(Integer cbie11) {
        this.cbie11 = cbie11;
    }

    public Date getCbie12() {
        return cbie12;
    }

    public void setCbie12(Date cbie12) {
        this.cbie12 = cbie12;
    }

    public Integer getCbie13() {
        return cbie13;
    }

    public void setCbie13(Integer cbie13) {
        this.cbie13 = cbie13;
    }

    public Date getCbie14() {
        return cbie14;
    }

    public void setCbie14(Date cbie14) {
        this.cbie14 = cbie14;
    }

    public String getCbie15() {
        return cbie15;
    }

    public void setCbie15(String cbie15) {
        this.cbie15 = cbie15 == null ? null : cbie15.trim();
    }

    public Integer getCbie16() {
        return cbie16;
    }

    public void setCbie16(Integer cbie16) {
        this.cbie16 = cbie16;
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
        Cbie other = (Cbie) that;
        return (this.getCbie01() == null ? other.getCbie01() == null : this.getCbie01().equals(other.getCbie01()))
            && (this.getCbie02() == null ? other.getCbie02() == null : this.getCbie02().equals(other.getCbie02()))
            && (this.getCbie03() == null ? other.getCbie03() == null : this.getCbie03().equals(other.getCbie03()))
            && (this.getCbie04() == null ? other.getCbie04() == null : this.getCbie04().equals(other.getCbie04()))
            && (this.getCbie05() == null ? other.getCbie05() == null : this.getCbie05().equals(other.getCbie05()))
            && (this.getCbie06() == null ? other.getCbie06() == null : this.getCbie06().equals(other.getCbie06()))
            && (this.getCbie07() == null ? other.getCbie07() == null : this.getCbie07().equals(other.getCbie07()))
            && (this.getCbie08() == null ? other.getCbie08() == null : this.getCbie08().equals(other.getCbie08()))
            && (this.getCbie09() == null ? other.getCbie09() == null : this.getCbie09().equals(other.getCbie09()))
            && (this.getCbie10() == null ? other.getCbie10() == null : this.getCbie10().equals(other.getCbie10()))
            && (this.getCbie11() == null ? other.getCbie11() == null : this.getCbie11().equals(other.getCbie11()))
            && (this.getCbie12() == null ? other.getCbie12() == null : this.getCbie12().equals(other.getCbie12()))
            && (this.getCbie13() == null ? other.getCbie13() == null : this.getCbie13().equals(other.getCbie13()))
            && (this.getCbie14() == null ? other.getCbie14() == null : this.getCbie14().equals(other.getCbie14()))
            && (this.getCbie15() == null ? other.getCbie15() == null : this.getCbie15().equals(other.getCbie15()))
            && (this.getCbie16() == null ? other.getCbie16() == null : this.getCbie16().equals(other.getCbie16()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbie01() == null) ? 0 : getCbie01().hashCode());
        result = prime * result + ((getCbie02() == null) ? 0 : getCbie02().hashCode());
        result = prime * result + ((getCbie03() == null) ? 0 : getCbie03().hashCode());
        result = prime * result + ((getCbie04() == null) ? 0 : getCbie04().hashCode());
        result = prime * result + ((getCbie05() == null) ? 0 : getCbie05().hashCode());
        result = prime * result + ((getCbie06() == null) ? 0 : getCbie06().hashCode());
        result = prime * result + ((getCbie07() == null) ? 0 : getCbie07().hashCode());
        result = prime * result + ((getCbie08() == null) ? 0 : getCbie08().hashCode());
        result = prime * result + ((getCbie09() == null) ? 0 : getCbie09().hashCode());
        result = prime * result + ((getCbie10() == null) ? 0 : getCbie10().hashCode());
        result = prime * result + ((getCbie11() == null) ? 0 : getCbie11().hashCode());
        result = prime * result + ((getCbie12() == null) ? 0 : getCbie12().hashCode());
        result = prime * result + ((getCbie13() == null) ? 0 : getCbie13().hashCode());
        result = prime * result + ((getCbie14() == null) ? 0 : getCbie14().hashCode());
        result = prime * result + ((getCbie15() == null) ? 0 : getCbie15().hashCode());
        result = prime * result + ((getCbie16() == null) ? 0 : getCbie16().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbie01=").append(cbie01);
        sb.append(", cbie02=").append(cbie02);
        sb.append(", cbie03=").append(cbie03);
        sb.append(", cbie04=").append(cbie04);
        sb.append(", cbie05=").append(cbie05);
        sb.append(", cbie06=").append(cbie06);
        sb.append(", cbie07=").append(cbie07);
        sb.append(", cbie08=").append(cbie08);
        sb.append(", cbie09=").append(cbie09);
        sb.append(", cbie10=").append(cbie10);
        sb.append(", cbie11=").append(cbie11);
        sb.append(", cbie12=").append(cbie12);
        sb.append(", cbie13=").append(cbie13);
        sb.append(", cbie14=").append(cbie14);
        sb.append(", cbie15=").append(cbie15);
        sb.append(", cbie16=").append(cbie16);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
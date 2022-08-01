package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cala implements Serializable {
    private Integer cala01;

    private String cala02;

    private Date cala03;

    private Date cala04;

    private Integer cala05;

    private Integer cala06;

    private Integer cala07;

    private String cala08;

    private String cala09;

    private String cala10;

    private String cala11;

    private String cala12;

    private static final long serialVersionUID = 1L;

    public Integer getCala01() {
        return cala01;
    }

    public void setCala01(Integer cala01) {
        this.cala01 = cala01;
    }

    public String getCala02() {
        return cala02;
    }

    public void setCala02(String cala02) {
        this.cala02 = cala02 == null ? null : cala02.trim();
    }

    public Date getCala03() {
        return cala03;
    }

    public void setCala03(Date cala03) {
        this.cala03 = cala03;
    }

    public Date getCala04() {
        return cala04;
    }

    public void setCala04(Date cala04) {
        this.cala04 = cala04;
    }

    public Integer getCala05() {
        return cala05;
    }

    public void setCala05(Integer cala05) {
        this.cala05 = cala05;
    }

    public Integer getCala06() {
        return cala06;
    }

    public void setCala06(Integer cala06) {
        this.cala06 = cala06;
    }

    public Integer getCala07() {
        return cala07;
    }

    public void setCala07(Integer cala07) {
        this.cala07 = cala07;
    }

    public String getCala08() {
        return cala08;
    }

    public void setCala08(String cala08) {
        this.cala08 = cala08 == null ? null : cala08.trim();
    }

    public String getCala09() {
        return cala09;
    }

    public void setCala09(String cala09) {
        this.cala09 = cala09 == null ? null : cala09.trim();
    }

    public String getCala10() {
        return cala10;
    }

    public void setCala10(String cala10) {
        this.cala10 = cala10 == null ? null : cala10.trim();
    }

    public String getCala11() {
        return cala11;
    }

    public void setCala11(String cala11) {
        this.cala11 = cala11 == null ? null : cala11.trim();
    }

    public String getCala12() {
        return cala12;
    }

    public void setCala12(String cala12) {
        this.cala12 = cala12 == null ? null : cala12.trim();
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
        Cala other = (Cala) that;
        return (this.getCala01() == null ? other.getCala01() == null : this.getCala01().equals(other.getCala01()))
            && (this.getCala02() == null ? other.getCala02() == null : this.getCala02().equals(other.getCala02()))
            && (this.getCala03() == null ? other.getCala03() == null : this.getCala03().equals(other.getCala03()))
            && (this.getCala04() == null ? other.getCala04() == null : this.getCala04().equals(other.getCala04()))
            && (this.getCala05() == null ? other.getCala05() == null : this.getCala05().equals(other.getCala05()))
            && (this.getCala06() == null ? other.getCala06() == null : this.getCala06().equals(other.getCala06()))
            && (this.getCala07() == null ? other.getCala07() == null : this.getCala07().equals(other.getCala07()))
            && (this.getCala08() == null ? other.getCala08() == null : this.getCala08().equals(other.getCala08()))
            && (this.getCala09() == null ? other.getCala09() == null : this.getCala09().equals(other.getCala09()))
            && (this.getCala10() == null ? other.getCala10() == null : this.getCala10().equals(other.getCala10()))
            && (this.getCala11() == null ? other.getCala11() == null : this.getCala11().equals(other.getCala11()))
            && (this.getCala12() == null ? other.getCala12() == null : this.getCala12().equals(other.getCala12()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCala01() == null) ? 0 : getCala01().hashCode());
        result = prime * result + ((getCala02() == null) ? 0 : getCala02().hashCode());
        result = prime * result + ((getCala03() == null) ? 0 : getCala03().hashCode());
        result = prime * result + ((getCala04() == null) ? 0 : getCala04().hashCode());
        result = prime * result + ((getCala05() == null) ? 0 : getCala05().hashCode());
        result = prime * result + ((getCala06() == null) ? 0 : getCala06().hashCode());
        result = prime * result + ((getCala07() == null) ? 0 : getCala07().hashCode());
        result = prime * result + ((getCala08() == null) ? 0 : getCala08().hashCode());
        result = prime * result + ((getCala09() == null) ? 0 : getCala09().hashCode());
        result = prime * result + ((getCala10() == null) ? 0 : getCala10().hashCode());
        result = prime * result + ((getCala11() == null) ? 0 : getCala11().hashCode());
        result = prime * result + ((getCala12() == null) ? 0 : getCala12().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cala01=").append(cala01);
        sb.append(", cala02=").append(cala02);
        sb.append(", cala03=").append(cala03);
        sb.append(", cala04=").append(cala04);
        sb.append(", cala05=").append(cala05);
        sb.append(", cala06=").append(cala06);
        sb.append(", cala07=").append(cala07);
        sb.append(", cala08=").append(cala08);
        sb.append(", cala09=").append(cala09);
        sb.append(", cala10=").append(cala10);
        sb.append(", cala11=").append(cala11);
        sb.append(", cala12=").append(cala12);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbof implements Serializable {
    private Integer cbof01;

    private Integer cbof02;

    private Date cbof03;

    private Integer cbof04;

    private Date cbof05;

    private Integer cbof06;

    private Integer cbof07;

    private Integer cbof08;

    private Double cbof09;

    private String cbof13;

    private Integer cboe01;

    private Double standardprice;

    private Double thisprice;

    private Double money;

    private static final long serialVersionUID = 1L;

    public Integer getCbof01() {
        return cbof01;
    }

    public void setCbof01(Integer cbof01) {
        this.cbof01 = cbof01;
    }

    public Integer getCbof02() {
        return cbof02;
    }

    public void setCbof02(Integer cbof02) {
        this.cbof02 = cbof02;
    }

    public Date getCbof03() {
        return cbof03;
    }

    public void setCbof03(Date cbof03) {
        this.cbof03 = cbof03;
    }

    public Integer getCbof04() {
        return cbof04;
    }

    public void setCbof04(Integer cbof04) {
        this.cbof04 = cbof04;
    }

    public Date getCbof05() {
        return cbof05;
    }

    public void setCbof05(Date cbof05) {
        this.cbof05 = cbof05;
    }

    public Integer getCbof06() {
        return cbof06;
    }

    public void setCbof06(Integer cbof06) {
        this.cbof06 = cbof06;
    }

    public Integer getCbof07() {
        return cbof07;
    }

    public void setCbof07(Integer cbof07) {
        this.cbof07 = cbof07;
    }

    public Integer getCbof08() {
        return cbof08;
    }

    public void setCbof08(Integer cbof08) {
        this.cbof08 = cbof08;
    }

    public Double getCbof09() {
        return cbof09;
    }

    public void setCbof09(Double cbof09) {
        this.cbof09 = cbof09;
    }

    public String getCbof13() {
        return cbof13;
    }

    public void setCbof13(String cbof13) {
        this.cbof13 = cbof13 == null ? null : cbof13.trim();
    }

    public Integer getCboe01() {
        return cboe01;
    }

    public void setCboe01(Integer cboe01) {
        this.cboe01 = cboe01;
    }

    public Double getStandardprice() {
        return standardprice;
    }

    public void setStandardprice(Double standardprice) {
        this.standardprice = standardprice;
    }

    public Double getThisprice() {
        return thisprice;
    }

    public void setThisprice(Double thisprice) {
        this.thisprice = thisprice;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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
        Cbof other = (Cbof) that;
        return (this.getCbof01() == null ? other.getCbof01() == null : this.getCbof01().equals(other.getCbof01()))
            && (this.getCbof02() == null ? other.getCbof02() == null : this.getCbof02().equals(other.getCbof02()))
            && (this.getCbof03() == null ? other.getCbof03() == null : this.getCbof03().equals(other.getCbof03()))
            && (this.getCbof04() == null ? other.getCbof04() == null : this.getCbof04().equals(other.getCbof04()))
            && (this.getCbof05() == null ? other.getCbof05() == null : this.getCbof05().equals(other.getCbof05()))
            && (this.getCbof06() == null ? other.getCbof06() == null : this.getCbof06().equals(other.getCbof06()))
            && (this.getCbof07() == null ? other.getCbof07() == null : this.getCbof07().equals(other.getCbof07()))
            && (this.getCbof08() == null ? other.getCbof08() == null : this.getCbof08().equals(other.getCbof08()))
            && (this.getCbof09() == null ? other.getCbof09() == null : this.getCbof09().equals(other.getCbof09()))
            && (this.getCbof13() == null ? other.getCbof13() == null : this.getCbof13().equals(other.getCbof13()))
            && (this.getCboe01() == null ? other.getCboe01() == null : this.getCboe01().equals(other.getCboe01()))
            && (this.getStandardprice() == null ? other.getStandardprice() == null : this.getStandardprice().equals(other.getStandardprice()))
            && (this.getThisprice() == null ? other.getThisprice() == null : this.getThisprice().equals(other.getThisprice()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbof01() == null) ? 0 : getCbof01().hashCode());
        result = prime * result + ((getCbof02() == null) ? 0 : getCbof02().hashCode());
        result = prime * result + ((getCbof03() == null) ? 0 : getCbof03().hashCode());
        result = prime * result + ((getCbof04() == null) ? 0 : getCbof04().hashCode());
        result = prime * result + ((getCbof05() == null) ? 0 : getCbof05().hashCode());
        result = prime * result + ((getCbof06() == null) ? 0 : getCbof06().hashCode());
        result = prime * result + ((getCbof07() == null) ? 0 : getCbof07().hashCode());
        result = prime * result + ((getCbof08() == null) ? 0 : getCbof08().hashCode());
        result = prime * result + ((getCbof09() == null) ? 0 : getCbof09().hashCode());
        result = prime * result + ((getCbof13() == null) ? 0 : getCbof13().hashCode());
        result = prime * result + ((getCboe01() == null) ? 0 : getCboe01().hashCode());
        result = prime * result + ((getStandardprice() == null) ? 0 : getStandardprice().hashCode());
        result = prime * result + ((getThisprice() == null) ? 0 : getThisprice().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbof01=").append(cbof01);
        sb.append(", cbof02=").append(cbof02);
        sb.append(", cbof03=").append(cbof03);
        sb.append(", cbof04=").append(cbof04);
        sb.append(", cbof05=").append(cbof05);
        sb.append(", cbof06=").append(cbof06);
        sb.append(", cbof07=").append(cbof07);
        sb.append(", cbof08=").append(cbof08);
        sb.append(", cbof09=").append(cbof09);
        sb.append(", cbof13=").append(cbof13);
        sb.append(", cboe01=").append(cboe01);
        sb.append(", standardprice=").append(standardprice);
        sb.append(", thisprice=").append(thisprice);
        sb.append(", money=").append(money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
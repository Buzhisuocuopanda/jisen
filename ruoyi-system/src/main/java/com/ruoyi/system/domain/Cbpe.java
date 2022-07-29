package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpe implements Serializable {
    private Integer cbpe01;

    private Integer cbpe02;

    private Date cbpe03;

    private Integer cbpe04;

    private Date cbpe05;

    private Integer cbpe06;

    private Integer cbpe07;

    private Integer cbpe08;

    private String cbpe09;

    private Integer cbpe10;

    private Integer cbpe11;

    private String cbpe12;

    private Integer cbpc01;

    private static final long serialVersionUID = 1L;

    public Integer getCbpe01() {
        return cbpe01;
    }

    public void setCbpe01(Integer cbpe01) {
        this.cbpe01 = cbpe01;
    }

    public Integer getCbpe02() {
        return cbpe02;
    }

    public void setCbpe02(Integer cbpe02) {
        this.cbpe02 = cbpe02;
    }

    public Date getCbpe03() {
        return cbpe03;
    }

    public void setCbpe03(Date cbpe03) {
        this.cbpe03 = cbpe03;
    }

    public Integer getCbpe04() {
        return cbpe04;
    }

    public void setCbpe04(Integer cbpe04) {
        this.cbpe04 = cbpe04;
    }

    public Date getCbpe05() {
        return cbpe05;
    }

    public void setCbpe05(Date cbpe05) {
        this.cbpe05 = cbpe05;
    }

    public Integer getCbpe06() {
        return cbpe06;
    }

    public void setCbpe06(Integer cbpe06) {
        this.cbpe06 = cbpe06;
    }

    public Integer getCbpe07() {
        return cbpe07;
    }

    public void setCbpe07(Integer cbpe07) {
        this.cbpe07 = cbpe07;
    }

    public Integer getCbpe08() {
        return cbpe08;
    }

    public void setCbpe08(Integer cbpe08) {
        this.cbpe08 = cbpe08;
    }

    public String getCbpe09() {
        return cbpe09;
    }

    public void setCbpe09(String cbpe09) {
        this.cbpe09 = cbpe09 == null ? null : cbpe09.trim();
    }

    public Integer getCbpe10() {
        return cbpe10;
    }

    public void setCbpe10(Integer cbpe10) {
        this.cbpe10 = cbpe10;
    }

    public Integer getCbpe11() {
        return cbpe11;
    }

    public void setCbpe11(Integer cbpe11) {
        this.cbpe11 = cbpe11;
    }

    public String getCbpe12() {
        return cbpe12;
    }

    public void setCbpe12(String cbpe12) {
        this.cbpe12 = cbpe12 == null ? null : cbpe12.trim();
    }

    public Integer getCbpc01() {
        return cbpc01;
    }

    public void setCbpc01(Integer cbpc01) {
        this.cbpc01 = cbpc01;
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
        Cbpe other = (Cbpe) that;
        return (this.getCbpe01() == null ? other.getCbpe01() == null : this.getCbpe01().equals(other.getCbpe01()))
            && (this.getCbpe02() == null ? other.getCbpe02() == null : this.getCbpe02().equals(other.getCbpe02()))
            && (this.getCbpe03() == null ? other.getCbpe03() == null : this.getCbpe03().equals(other.getCbpe03()))
            && (this.getCbpe04() == null ? other.getCbpe04() == null : this.getCbpe04().equals(other.getCbpe04()))
            && (this.getCbpe05() == null ? other.getCbpe05() == null : this.getCbpe05().equals(other.getCbpe05()))
            && (this.getCbpe06() == null ? other.getCbpe06() == null : this.getCbpe06().equals(other.getCbpe06()))
            && (this.getCbpe07() == null ? other.getCbpe07() == null : this.getCbpe07().equals(other.getCbpe07()))
            && (this.getCbpe08() == null ? other.getCbpe08() == null : this.getCbpe08().equals(other.getCbpe08()))
            && (this.getCbpe09() == null ? other.getCbpe09() == null : this.getCbpe09().equals(other.getCbpe09()))
            && (this.getCbpe10() == null ? other.getCbpe10() == null : this.getCbpe10().equals(other.getCbpe10()))
            && (this.getCbpe11() == null ? other.getCbpe11() == null : this.getCbpe11().equals(other.getCbpe11()))
            && (this.getCbpe12() == null ? other.getCbpe12() == null : this.getCbpe12().equals(other.getCbpe12()))
            && (this.getCbpc01() == null ? other.getCbpc01() == null : this.getCbpc01().equals(other.getCbpc01()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpe01() == null) ? 0 : getCbpe01().hashCode());
        result = prime * result + ((getCbpe02() == null) ? 0 : getCbpe02().hashCode());
        result = prime * result + ((getCbpe03() == null) ? 0 : getCbpe03().hashCode());
        result = prime * result + ((getCbpe04() == null) ? 0 : getCbpe04().hashCode());
        result = prime * result + ((getCbpe05() == null) ? 0 : getCbpe05().hashCode());
        result = prime * result + ((getCbpe06() == null) ? 0 : getCbpe06().hashCode());
        result = prime * result + ((getCbpe07() == null) ? 0 : getCbpe07().hashCode());
        result = prime * result + ((getCbpe08() == null) ? 0 : getCbpe08().hashCode());
        result = prime * result + ((getCbpe09() == null) ? 0 : getCbpe09().hashCode());
        result = prime * result + ((getCbpe10() == null) ? 0 : getCbpe10().hashCode());
        result = prime * result + ((getCbpe11() == null) ? 0 : getCbpe11().hashCode());
        result = prime * result + ((getCbpe12() == null) ? 0 : getCbpe12().hashCode());
        result = prime * result + ((getCbpc01() == null) ? 0 : getCbpc01().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpe01=").append(cbpe01);
        sb.append(", cbpe02=").append(cbpe02);
        sb.append(", cbpe03=").append(cbpe03);
        sb.append(", cbpe04=").append(cbpe04);
        sb.append(", cbpe05=").append(cbpe05);
        sb.append(", cbpe06=").append(cbpe06);
        sb.append(", cbpe07=").append(cbpe07);
        sb.append(", cbpe08=").append(cbpe08);
        sb.append(", cbpe09=").append(cbpe09);
        sb.append(", cbpe10=").append(cbpe10);
        sb.append(", cbpe11=").append(cbpe11);
        sb.append(", cbpe12=").append(cbpe12);
        sb.append(", cbpc01=").append(cbpc01);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbba implements Serializable {
    private Integer cbba01;

    private Date cbba02;

    private Integer cbba03;

    private Date cbba04;

    private Integer cbba05;

    private Integer cbba06;

    private String cbba07;

    private Integer cbba08;

    private Double cbba09;

    private Integer cbba10;

    private Double cbba11;

    private Integer cbba12;

    private Double cbba13;

    private Double cbba14;

    private Integer cbba15;

    private static final long serialVersionUID = 1L;

    public Integer getCbba01() {
        return cbba01;
    }

    public void setCbba01(Integer cbba01) {
        this.cbba01 = cbba01;
    }

    public Date getCbba02() {
        return cbba02;
    }

    public void setCbba02(Date cbba02) {
        this.cbba02 = cbba02;
    }

    public Integer getCbba03() {
        return cbba03;
    }

    public void setCbba03(Integer cbba03) {
        this.cbba03 = cbba03;
    }

    public Date getCbba04() {
        return cbba04;
    }

    public void setCbba04(Date cbba04) {
        this.cbba04 = cbba04;
    }

    public Integer getCbba05() {
        return cbba05;
    }

    public void setCbba05(Integer cbba05) {
        this.cbba05 = cbba05;
    }

    public Integer getCbba06() {
        return cbba06;
    }

    public void setCbba06(Integer cbba06) {
        this.cbba06 = cbba06;
    }

    public String getCbba07() {
        return cbba07;
    }

    public void setCbba07(String cbba07) {
        this.cbba07 = cbba07 == null ? null : cbba07.trim();
    }

    public Integer getCbba08() {
        return cbba08;
    }

    public void setCbba08(Integer cbba08) {
        this.cbba08 = cbba08;
    }

    public Double getCbba09() {
        return cbba09;
    }

    public void setCbba09(Double cbba09) {
        this.cbba09 = cbba09;
    }

    public Integer getCbba10() {
        return cbba10;
    }

    public void setCbba10(Integer cbba10) {
        this.cbba10 = cbba10;
    }

    public Double getCbba11() {
        return cbba11;
    }

    public void setCbba11(Double cbba11) {
        this.cbba11 = cbba11;
    }

    public Integer getCbba12() {
        return cbba12;
    }

    public void setCbba12(Integer cbba12) {
        this.cbba12 = cbba12;
    }

    public Double getCbba13() {
        return cbba13;
    }

    public void setCbba13(Double cbba13) {
        this.cbba13 = cbba13;
    }

    public Double getCbba14() {
        return cbba14;
    }

    public void setCbba14(Double cbba14) {
        this.cbba14 = cbba14;
    }

    public Integer getCbba15() {
        return cbba15;
    }

    public void setCbba15(Integer cbba15) {
        this.cbba15 = cbba15;
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
        Cbba other = (Cbba) that;
        return (this.getCbba01() == null ? other.getCbba01() == null : this.getCbba01().equals(other.getCbba01()))
            && (this.getCbba02() == null ? other.getCbba02() == null : this.getCbba02().equals(other.getCbba02()))
            && (this.getCbba03() == null ? other.getCbba03() == null : this.getCbba03().equals(other.getCbba03()))
            && (this.getCbba04() == null ? other.getCbba04() == null : this.getCbba04().equals(other.getCbba04()))
            && (this.getCbba05() == null ? other.getCbba05() == null : this.getCbba05().equals(other.getCbba05()))
            && (this.getCbba06() == null ? other.getCbba06() == null : this.getCbba06().equals(other.getCbba06()))
            && (this.getCbba07() == null ? other.getCbba07() == null : this.getCbba07().equals(other.getCbba07()))
            && (this.getCbba08() == null ? other.getCbba08() == null : this.getCbba08().equals(other.getCbba08()))
            && (this.getCbba09() == null ? other.getCbba09() == null : this.getCbba09().equals(other.getCbba09()))
            && (this.getCbba10() == null ? other.getCbba10() == null : this.getCbba10().equals(other.getCbba10()))
            && (this.getCbba11() == null ? other.getCbba11() == null : this.getCbba11().equals(other.getCbba11()))
            && (this.getCbba12() == null ? other.getCbba12() == null : this.getCbba12().equals(other.getCbba12()))
            && (this.getCbba13() == null ? other.getCbba13() == null : this.getCbba13().equals(other.getCbba13()))
            && (this.getCbba14() == null ? other.getCbba14() == null : this.getCbba14().equals(other.getCbba14()))
            && (this.getCbba15() == null ? other.getCbba15() == null : this.getCbba15().equals(other.getCbba15()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbba01() == null) ? 0 : getCbba01().hashCode());
        result = prime * result + ((getCbba02() == null) ? 0 : getCbba02().hashCode());
        result = prime * result + ((getCbba03() == null) ? 0 : getCbba03().hashCode());
        result = prime * result + ((getCbba04() == null) ? 0 : getCbba04().hashCode());
        result = prime * result + ((getCbba05() == null) ? 0 : getCbba05().hashCode());
        result = prime * result + ((getCbba06() == null) ? 0 : getCbba06().hashCode());
        result = prime * result + ((getCbba07() == null) ? 0 : getCbba07().hashCode());
        result = prime * result + ((getCbba08() == null) ? 0 : getCbba08().hashCode());
        result = prime * result + ((getCbba09() == null) ? 0 : getCbba09().hashCode());
        result = prime * result + ((getCbba10() == null) ? 0 : getCbba10().hashCode());
        result = prime * result + ((getCbba11() == null) ? 0 : getCbba11().hashCode());
        result = prime * result + ((getCbba12() == null) ? 0 : getCbba12().hashCode());
        result = prime * result + ((getCbba13() == null) ? 0 : getCbba13().hashCode());
        result = prime * result + ((getCbba14() == null) ? 0 : getCbba14().hashCode());
        result = prime * result + ((getCbba15() == null) ? 0 : getCbba15().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbba01=").append(cbba01);
        sb.append(", cbba02=").append(cbba02);
        sb.append(", cbba03=").append(cbba03);
        sb.append(", cbba04=").append(cbba04);
        sb.append(", cbba05=").append(cbba05);
        sb.append(", cbba06=").append(cbba06);
        sb.append(", cbba07=").append(cbba07);
        sb.append(", cbba08=").append(cbba08);
        sb.append(", cbba09=").append(cbba09);
        sb.append(", cbba10=").append(cbba10);
        sb.append(", cbba11=").append(cbba11);
        sb.append(", cbba12=").append(cbba12);
        sb.append(", cbba13=").append(cbba13);
        sb.append(", cbba14=").append(cbba14);
        sb.append(", cbba15=").append(cbba15);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
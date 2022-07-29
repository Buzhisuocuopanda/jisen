package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpd implements Serializable {
    private Integer cbpd01;

    private Integer cbpd02;

    private Date cbpd03;

    private Integer cbpd04;

    private Date cbpd05;

    private Integer cbpd06;

    private Integer cbpd07;

    private Integer cbpd08;

    private Double cbpd09;

    private Double cbpd10;

    private Double cbpd11;

    private Double cbpd12;

    private String cbpd13;

    private Integer cbpc01;

    private static final long serialVersionUID = 1L;

    public Integer getCbpd01() {
        return cbpd01;
    }

    public void setCbpd01(Integer cbpd01) {
        this.cbpd01 = cbpd01;
    }

    public Integer getCbpd02() {
        return cbpd02;
    }

    public void setCbpd02(Integer cbpd02) {
        this.cbpd02 = cbpd02;
    }

    public Date getCbpd03() {
        return cbpd03;
    }

    public void setCbpd03(Date cbpd03) {
        this.cbpd03 = cbpd03;
    }

    public Integer getCbpd04() {
        return cbpd04;
    }

    public void setCbpd04(Integer cbpd04) {
        this.cbpd04 = cbpd04;
    }

    public Date getCbpd05() {
        return cbpd05;
    }

    public void setCbpd05(Date cbpd05) {
        this.cbpd05 = cbpd05;
    }

    public Integer getCbpd06() {
        return cbpd06;
    }

    public void setCbpd06(Integer cbpd06) {
        this.cbpd06 = cbpd06;
    }

    public Integer getCbpd07() {
        return cbpd07;
    }

    public void setCbpd07(Integer cbpd07) {
        this.cbpd07 = cbpd07;
    }

    public Integer getCbpd08() {
        return cbpd08;
    }

    public void setCbpd08(Integer cbpd08) {
        this.cbpd08 = cbpd08;
    }

    public Double getCbpd09() {
        return cbpd09;
    }

    public void setCbpd09(Double cbpd09) {
        this.cbpd09 = cbpd09;
    }

    public Double getCbpd10() {
        return cbpd10;
    }

    public void setCbpd10(Double cbpd10) {
        this.cbpd10 = cbpd10;
    }

    public Double getCbpd11() {
        return cbpd11;
    }

    public void setCbpd11(Double cbpd11) {
        this.cbpd11 = cbpd11;
    }

    public Double getCbpd12() {
        return cbpd12;
    }

    public void setCbpd12(Double cbpd12) {
        this.cbpd12 = cbpd12;
    }

    public String getCbpd13() {
        return cbpd13;
    }

    public void setCbpd13(String cbpd13) {
        this.cbpd13 = cbpd13 == null ? null : cbpd13.trim();
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
        Cbpd other = (Cbpd) that;
        return (this.getCbpd01() == null ? other.getCbpd01() == null : this.getCbpd01().equals(other.getCbpd01()))
            && (this.getCbpd02() == null ? other.getCbpd02() == null : this.getCbpd02().equals(other.getCbpd02()))
            && (this.getCbpd03() == null ? other.getCbpd03() == null : this.getCbpd03().equals(other.getCbpd03()))
            && (this.getCbpd04() == null ? other.getCbpd04() == null : this.getCbpd04().equals(other.getCbpd04()))
            && (this.getCbpd05() == null ? other.getCbpd05() == null : this.getCbpd05().equals(other.getCbpd05()))
            && (this.getCbpd06() == null ? other.getCbpd06() == null : this.getCbpd06().equals(other.getCbpd06()))
            && (this.getCbpd07() == null ? other.getCbpd07() == null : this.getCbpd07().equals(other.getCbpd07()))
            && (this.getCbpd08() == null ? other.getCbpd08() == null : this.getCbpd08().equals(other.getCbpd08()))
            && (this.getCbpd09() == null ? other.getCbpd09() == null : this.getCbpd09().equals(other.getCbpd09()))
            && (this.getCbpd10() == null ? other.getCbpd10() == null : this.getCbpd10().equals(other.getCbpd10()))
            && (this.getCbpd11() == null ? other.getCbpd11() == null : this.getCbpd11().equals(other.getCbpd11()))
            && (this.getCbpd12() == null ? other.getCbpd12() == null : this.getCbpd12().equals(other.getCbpd12()))
            && (this.getCbpd13() == null ? other.getCbpd13() == null : this.getCbpd13().equals(other.getCbpd13()))
            && (this.getCbpc01() == null ? other.getCbpc01() == null : this.getCbpc01().equals(other.getCbpc01()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpd01() == null) ? 0 : getCbpd01().hashCode());
        result = prime * result + ((getCbpd02() == null) ? 0 : getCbpd02().hashCode());
        result = prime * result + ((getCbpd03() == null) ? 0 : getCbpd03().hashCode());
        result = prime * result + ((getCbpd04() == null) ? 0 : getCbpd04().hashCode());
        result = prime * result + ((getCbpd05() == null) ? 0 : getCbpd05().hashCode());
        result = prime * result + ((getCbpd06() == null) ? 0 : getCbpd06().hashCode());
        result = prime * result + ((getCbpd07() == null) ? 0 : getCbpd07().hashCode());
        result = prime * result + ((getCbpd08() == null) ? 0 : getCbpd08().hashCode());
        result = prime * result + ((getCbpd09() == null) ? 0 : getCbpd09().hashCode());
        result = prime * result + ((getCbpd10() == null) ? 0 : getCbpd10().hashCode());
        result = prime * result + ((getCbpd11() == null) ? 0 : getCbpd11().hashCode());
        result = prime * result + ((getCbpd12() == null) ? 0 : getCbpd12().hashCode());
        result = prime * result + ((getCbpd13() == null) ? 0 : getCbpd13().hashCode());
        result = prime * result + ((getCbpc01() == null) ? 0 : getCbpc01().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpd01=").append(cbpd01);
        sb.append(", cbpd02=").append(cbpd02);
        sb.append(", cbpd03=").append(cbpd03);
        sb.append(", cbpd04=").append(cbpd04);
        sb.append(", cbpd05=").append(cbpd05);
        sb.append(", cbpd06=").append(cbpd06);
        sb.append(", cbpd07=").append(cbpd07);
        sb.append(", cbpd08=").append(cbpd08);
        sb.append(", cbpd09=").append(cbpd09);
        sb.append(", cbpd10=").append(cbpd10);
        sb.append(", cbpd11=").append(cbpd11);
        sb.append(", cbpd12=").append(cbpd12);
        sb.append(", cbpd13=").append(cbpd13);
        sb.append(", cbpc01=").append(cbpc01);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpf implements Serializable {
    private Integer cbpf01;

    private Integer cbpf02;

    private Integer cbpf03;

    private Double cbpf04;

    private Double cbpf05;

    private Integer cbpb01;

    private Integer cbpf06;

    private Date cbpf07;

    private static final long serialVersionUID = 1L;

    public Integer getCbpf01() {
        return cbpf01;
    }

    public void setCbpf01(Integer cbpf01) {
        this.cbpf01 = cbpf01;
    }

    public Integer getCbpf02() {
        return cbpf02;
    }

    public void setCbpf02(Integer cbpf02) {
        this.cbpf02 = cbpf02;
    }

    public Integer getCbpf03() {
        return cbpf03;
    }

    public void setCbpf03(Integer cbpf03) {
        this.cbpf03 = cbpf03;
    }

    public Double getCbpf04() {
        return cbpf04;
    }

    public void setCbpf04(Double cbpf04) {
        this.cbpf04 = cbpf04;
    }

    public Double getCbpf05() {
        return cbpf05;
    }

    public void setCbpf05(Double cbpf05) {
        this.cbpf05 = cbpf05;
    }

    public Integer getCbpb01() {
        return cbpb01;
    }

    public void setCbpb01(Integer cbpb01) {
        this.cbpb01 = cbpb01;
    }

    public Integer getCbpf06() {
        return cbpf06;
    }

    public void setCbpf06(Integer cbpf06) {
        this.cbpf06 = cbpf06;
    }

    public Date getCbpf07() {
        return cbpf07;
    }

    public void setCbpf07(Date cbpf07) {
        this.cbpf07 = cbpf07;
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
        Cbpf other = (Cbpf) that;
        return (this.getCbpf01() == null ? other.getCbpf01() == null : this.getCbpf01().equals(other.getCbpf01()))
            && (this.getCbpf02() == null ? other.getCbpf02() == null : this.getCbpf02().equals(other.getCbpf02()))
            && (this.getCbpf03() == null ? other.getCbpf03() == null : this.getCbpf03().equals(other.getCbpf03()))
            && (this.getCbpf04() == null ? other.getCbpf04() == null : this.getCbpf04().equals(other.getCbpf04()))
            && (this.getCbpf05() == null ? other.getCbpf05() == null : this.getCbpf05().equals(other.getCbpf05()))
            && (this.getCbpb01() == null ? other.getCbpb01() == null : this.getCbpb01().equals(other.getCbpb01()))
            && (this.getCbpf06() == null ? other.getCbpf06() == null : this.getCbpf06().equals(other.getCbpf06()))
            && (this.getCbpf07() == null ? other.getCbpf07() == null : this.getCbpf07().equals(other.getCbpf07()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpf01() == null) ? 0 : getCbpf01().hashCode());
        result = prime * result + ((getCbpf02() == null) ? 0 : getCbpf02().hashCode());
        result = prime * result + ((getCbpf03() == null) ? 0 : getCbpf03().hashCode());
        result = prime * result + ((getCbpf04() == null) ? 0 : getCbpf04().hashCode());
        result = prime * result + ((getCbpf05() == null) ? 0 : getCbpf05().hashCode());
        result = prime * result + ((getCbpb01() == null) ? 0 : getCbpb01().hashCode());
        result = prime * result + ((getCbpf06() == null) ? 0 : getCbpf06().hashCode());
        result = prime * result + ((getCbpf07() == null) ? 0 : getCbpf07().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpf01=").append(cbpf01);
        sb.append(", cbpf02=").append(cbpf02);
        sb.append(", cbpf03=").append(cbpf03);
        sb.append(", cbpf04=").append(cbpf04);
        sb.append(", cbpf05=").append(cbpf05);
        sb.append(", cbpb01=").append(cbpb01);
        sb.append(", cbpf06=").append(cbpf06);
        sb.append(", cbpf07=").append(cbpf07);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
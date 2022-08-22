package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpm implements Serializable {
    private Integer cbpm01;

    private Integer cbpm02;

    private Date cbpm03;

    private Integer cbpm04;

    private Date cbpm05;

    private Integer cbpm06;

    private Integer cbpm07;

    private Integer cbpm08;

    private String cbpm09;

    private Integer cbpm10;

    private Integer cbpm11;

    private String cbpm12;

    private Integer cbpk01;

    private static final long serialVersionUID = 1L;

    public Integer getCbpm01() {
        return cbpm01;
    }

    public void setCbpm01(Integer cbpm01) {
        this.cbpm01 = cbpm01;
    }

    public Integer getCbpm02() {
        return cbpm02;
    }

    public void setCbpm02(Integer cbpm02) {
        this.cbpm02 = cbpm02;
    }

    public Date getCbpm03() {
        return cbpm03;
    }

    public void setCbpm03(Date cbpm03) {
        this.cbpm03 = cbpm03;
    }

    public Integer getCbpm04() {
        return cbpm04;
    }

    public void setCbpm04(Integer cbpm04) {
        this.cbpm04 = cbpm04;
    }

    public Date getCbpm05() {
        return cbpm05;
    }

    public void setCbpm05(Date cbpm05) {
        this.cbpm05 = cbpm05;
    }

    public Integer getCbpm06() {
        return cbpm06;
    }

    public void setCbpm06(Integer cbpm06) {
        this.cbpm06 = cbpm06;
    }

    public Integer getCbpm07() {
        return cbpm07;
    }

    public void setCbpm07(Integer cbpm07) {
        this.cbpm07 = cbpm07;
    }

    public Integer getCbpm08() {
        return cbpm08;
    }

    public void setCbpm08(Integer cbpm08) {
        this.cbpm08 = cbpm08;
    }

    public String getCbpm09() {
        return cbpm09;
    }

    public void setCbpm09(String cbpm09) {
        this.cbpm09 = cbpm09 == null ? null : cbpm09.trim();
    }

    public Integer getCbpm10() {
        return cbpm10;
    }

    public void setCbpm10(Integer cbpm10) {
        this.cbpm10 = cbpm10;
    }

    public Integer getCbpm11() {
        return cbpm11;
    }

    public void setCbpm11(Integer cbpm11) {
        this.cbpm11 = cbpm11;
    }

    public String getCbpm12() {
        return cbpm12;
    }

    public void setCbpm12(String cbpm12) {
        this.cbpm12 = cbpm12 == null ? null : cbpm12.trim();
    }

    public Integer getCbpk01() {
        return cbpk01;
    }

    public void setCbpk01(Integer cbpk01) {
        this.cbpk01 = cbpk01;
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
        Cbpm other = (Cbpm) that;
        return (this.getCbpm01() == null ? other.getCbpm01() == null : this.getCbpm01().equals(other.getCbpm01()))
            && (this.getCbpm02() == null ? other.getCbpm02() == null : this.getCbpm02().equals(other.getCbpm02()))
            && (this.getCbpm03() == null ? other.getCbpm03() == null : this.getCbpm03().equals(other.getCbpm03()))
            && (this.getCbpm04() == null ? other.getCbpm04() == null : this.getCbpm04().equals(other.getCbpm04()))
            && (this.getCbpm05() == null ? other.getCbpm05() == null : this.getCbpm05().equals(other.getCbpm05()))
            && (this.getCbpm06() == null ? other.getCbpm06() == null : this.getCbpm06().equals(other.getCbpm06()))
            && (this.getCbpm07() == null ? other.getCbpm07() == null : this.getCbpm07().equals(other.getCbpm07()))
            && (this.getCbpm08() == null ? other.getCbpm08() == null : this.getCbpm08().equals(other.getCbpm08()))
            && (this.getCbpm09() == null ? other.getCbpm09() == null : this.getCbpm09().equals(other.getCbpm09()))
            && (this.getCbpm10() == null ? other.getCbpm10() == null : this.getCbpm10().equals(other.getCbpm10()))
            && (this.getCbpm11() == null ? other.getCbpm11() == null : this.getCbpm11().equals(other.getCbpm11()))
            && (this.getCbpm12() == null ? other.getCbpm12() == null : this.getCbpm12().equals(other.getCbpm12()))
            && (this.getCbpk01() == null ? other.getCbpk01() == null : this.getCbpk01().equals(other.getCbpk01()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpm01() == null) ? 0 : getCbpm01().hashCode());
        result = prime * result + ((getCbpm02() == null) ? 0 : getCbpm02().hashCode());
        result = prime * result + ((getCbpm03() == null) ? 0 : getCbpm03().hashCode());
        result = prime * result + ((getCbpm04() == null) ? 0 : getCbpm04().hashCode());
        result = prime * result + ((getCbpm05() == null) ? 0 : getCbpm05().hashCode());
        result = prime * result + ((getCbpm06() == null) ? 0 : getCbpm06().hashCode());
        result = prime * result + ((getCbpm07() == null) ? 0 : getCbpm07().hashCode());
        result = prime * result + ((getCbpm08() == null) ? 0 : getCbpm08().hashCode());
        result = prime * result + ((getCbpm09() == null) ? 0 : getCbpm09().hashCode());
        result = prime * result + ((getCbpm10() == null) ? 0 : getCbpm10().hashCode());
        result = prime * result + ((getCbpm11() == null) ? 0 : getCbpm11().hashCode());
        result = prime * result + ((getCbpm12() == null) ? 0 : getCbpm12().hashCode());
        result = prime * result + ((getCbpk01() == null) ? 0 : getCbpk01().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpm01=").append(cbpm01);
        sb.append(", cbpm02=").append(cbpm02);
        sb.append(", cbpm03=").append(cbpm03);
        sb.append(", cbpm04=").append(cbpm04);
        sb.append(", cbpm05=").append(cbpm05);
        sb.append(", cbpm06=").append(cbpm06);
        sb.append(", cbpm07=").append(cbpm07);
        sb.append(", cbpm08=").append(cbpm08);
        sb.append(", cbpm09=").append(cbpm09);
        sb.append(", cbpm10=").append(cbpm10);
        sb.append(", cbpm11=").append(cbpm11);
        sb.append(", cbpm12=").append(cbpm12);
        sb.append(", cbpk01=").append(cbpk01);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
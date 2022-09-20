package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbob implements Serializable {
    private Integer cbob01;

    private Integer cbob02;

    private Date cbob03;

    private Integer cbob04;

    private Date cbob05;

    private Integer cbob06;

    private Integer cbob07;

    private Integer cbob08;

    private Double cbob09;

    private Double cbob10;

    private Double cbob11;

    private Double cbob12;

    private String cbob13;

    private Integer cboa01;

    private Double cbob14;

    private Double cbob15;

    private Integer cbob16;

    private Integer cbob17;

    private String cbob18;

    private Double confirmQty;

    private static final long serialVersionUID = 1L;

    public Integer getCbob01() {
        return cbob01;
    }

    public void setCbob01(Integer cbob01) {
        this.cbob01 = cbob01;
    }

    public Integer getCbob02() {
        return cbob02;
    }

    public void setCbob02(Integer cbob02) {
        this.cbob02 = cbob02;
    }

    public Date getCbob03() {
        return cbob03;
    }

    public void setCbob03(Date cbob03) {
        this.cbob03 = cbob03;
    }

    public Integer getCbob04() {
        return cbob04;
    }

    public void setCbob04(Integer cbob04) {
        this.cbob04 = cbob04;
    }

    public Date getCbob05() {
        return cbob05;
    }

    public void setCbob05(Date cbob05) {
        this.cbob05 = cbob05;
    }

    public Integer getCbob06() {
        return cbob06;
    }

    public void setCbob06(Integer cbob06) {
        this.cbob06 = cbob06;
    }

    public Integer getCbob07() {
        return cbob07;
    }

    public void setCbob07(Integer cbob07) {
        this.cbob07 = cbob07;
    }

    public Integer getCbob08() {
        return cbob08;
    }

    public void setCbob08(Integer cbob08) {
        this.cbob08 = cbob08;
    }

    public Double getCbob09() {
        return cbob09;
    }

    public void setCbob09(Double cbob09) {
        this.cbob09 = cbob09;
    }

    public Double getCbob10() {
        return cbob10;
    }

    public void setCbob10(Double cbob10) {
        this.cbob10 = cbob10;
    }

    public Double getCbob11() {
        return cbob11;
    }

    public void setCbob11(Double cbob11) {
        this.cbob11 = cbob11;
    }

    public Double getCbob12() {
        return cbob12;
    }

    public void setCbob12(Double cbob12) {
        this.cbob12 = cbob12;
    }

    public String getCbob13() {
        return cbob13;
    }

    public void setCbob13(String cbob13) {
        this.cbob13 = cbob13 == null ? null : cbob13.trim();
    }

    public Integer getCboa01() {
        return cboa01;
    }

    public void setCboa01(Integer cboa01) {
        this.cboa01 = cboa01;
    }

    public Double getCbob14() {
        return cbob14;
    }

    public void setCbob14(Double cbob14) {
        this.cbob14 = cbob14;
    }

    public Double getCbob15() {
        return cbob15;
    }

    public void setCbob15(Double cbob15) {
        this.cbob15 = cbob15;
    }

    public Integer getCbob16() {
        return cbob16;
    }

    public void setCbob16(Integer cbob16) {
        this.cbob16 = cbob16;
    }

    public Integer getCbob17() {
        return cbob17;
    }

    public void setCbob17(Integer cbob17) {
        this.cbob17 = cbob17;
    }

    public String getCbob18() {
        return cbob18;
    }

    public void setCbob18(String cbob18) {
        this.cbob18 = cbob18 == null ? null : cbob18.trim();
    }

    public Double getConfirmQty() {
        return confirmQty;
    }

    public void setConfirmQty(Double confirmQty) {
        this.confirmQty = confirmQty;
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
        Cbob other = (Cbob) that;
        return (this.getCbob01() == null ? other.getCbob01() == null : this.getCbob01().equals(other.getCbob01()))
            && (this.getCbob02() == null ? other.getCbob02() == null : this.getCbob02().equals(other.getCbob02()))
            && (this.getCbob03() == null ? other.getCbob03() == null : this.getCbob03().equals(other.getCbob03()))
            && (this.getCbob04() == null ? other.getCbob04() == null : this.getCbob04().equals(other.getCbob04()))
            && (this.getCbob05() == null ? other.getCbob05() == null : this.getCbob05().equals(other.getCbob05()))
            && (this.getCbob06() == null ? other.getCbob06() == null : this.getCbob06().equals(other.getCbob06()))
            && (this.getCbob07() == null ? other.getCbob07() == null : this.getCbob07().equals(other.getCbob07()))
            && (this.getCbob08() == null ? other.getCbob08() == null : this.getCbob08().equals(other.getCbob08()))
            && (this.getCbob09() == null ? other.getCbob09() == null : this.getCbob09().equals(other.getCbob09()))
            && (this.getCbob10() == null ? other.getCbob10() == null : this.getCbob10().equals(other.getCbob10()))
            && (this.getCbob11() == null ? other.getCbob11() == null : this.getCbob11().equals(other.getCbob11()))
            && (this.getCbob12() == null ? other.getCbob12() == null : this.getCbob12().equals(other.getCbob12()))
            && (this.getCbob13() == null ? other.getCbob13() == null : this.getCbob13().equals(other.getCbob13()))
            && (this.getCboa01() == null ? other.getCboa01() == null : this.getCboa01().equals(other.getCboa01()))
            && (this.getCbob14() == null ? other.getCbob14() == null : this.getCbob14().equals(other.getCbob14()))
            && (this.getCbob15() == null ? other.getCbob15() == null : this.getCbob15().equals(other.getCbob15()))
            && (this.getCbob16() == null ? other.getCbob16() == null : this.getCbob16().equals(other.getCbob16()))
            && (this.getCbob17() == null ? other.getCbob17() == null : this.getCbob17().equals(other.getCbob17()))
            && (this.getCbob18() == null ? other.getCbob18() == null : this.getCbob18().equals(other.getCbob18()))
            && (this.getConfirmQty() == null ? other.getConfirmQty() == null : this.getConfirmQty().equals(other.getConfirmQty()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbob01() == null) ? 0 : getCbob01().hashCode());
        result = prime * result + ((getCbob02() == null) ? 0 : getCbob02().hashCode());
        result = prime * result + ((getCbob03() == null) ? 0 : getCbob03().hashCode());
        result = prime * result + ((getCbob04() == null) ? 0 : getCbob04().hashCode());
        result = prime * result + ((getCbob05() == null) ? 0 : getCbob05().hashCode());
        result = prime * result + ((getCbob06() == null) ? 0 : getCbob06().hashCode());
        result = prime * result + ((getCbob07() == null) ? 0 : getCbob07().hashCode());
        result = prime * result + ((getCbob08() == null) ? 0 : getCbob08().hashCode());
        result = prime * result + ((getCbob09() == null) ? 0 : getCbob09().hashCode());
        result = prime * result + ((getCbob10() == null) ? 0 : getCbob10().hashCode());
        result = prime * result + ((getCbob11() == null) ? 0 : getCbob11().hashCode());
        result = prime * result + ((getCbob12() == null) ? 0 : getCbob12().hashCode());
        result = prime * result + ((getCbob13() == null) ? 0 : getCbob13().hashCode());
        result = prime * result + ((getCboa01() == null) ? 0 : getCboa01().hashCode());
        result = prime * result + ((getCbob14() == null) ? 0 : getCbob14().hashCode());
        result = prime * result + ((getCbob15() == null) ? 0 : getCbob15().hashCode());
        result = prime * result + ((getCbob16() == null) ? 0 : getCbob16().hashCode());
        result = prime * result + ((getCbob17() == null) ? 0 : getCbob17().hashCode());
        result = prime * result + ((getCbob18() == null) ? 0 : getCbob18().hashCode());
        result = prime * result + ((getConfirmQty() == null) ? 0 : getConfirmQty().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbob01=").append(cbob01);
        sb.append(", cbob02=").append(cbob02);
        sb.append(", cbob03=").append(cbob03);
        sb.append(", cbob04=").append(cbob04);
        sb.append(", cbob05=").append(cbob05);
        sb.append(", cbob06=").append(cbob06);
        sb.append(", cbob07=").append(cbob07);
        sb.append(", cbob08=").append(cbob08);
        sb.append(", cbob09=").append(cbob09);
        sb.append(", cbob10=").append(cbob10);
        sb.append(", cbob11=").append(cbob11);
        sb.append(", cbob12=").append(cbob12);
        sb.append(", cbob13=").append(cbob13);
        sb.append(", cboa01=").append(cboa01);
        sb.append(", cbob14=").append(cbob14);
        sb.append(", cbob15=").append(cbob15);
        sb.append(", cbob16=").append(cbob16);
        sb.append(", cbob17=").append(cbob17);
        sb.append(", cbob18=").append(cbob18);
        sb.append(", confirmQty=").append(confirmQty);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
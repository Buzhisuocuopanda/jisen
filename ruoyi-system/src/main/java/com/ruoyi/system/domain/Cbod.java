package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbod implements Serializable {
    private Integer cbod01;

    private Integer cbod02;

    private Date cbod03;

    private Integer cbod04;

    private Date cbod05;

    private Integer cbod06;

    private Integer cbod07;

    private Integer cbod08;

    private Double cbod09;

    private Double cbod10;

    private Double cbod11;

    private Double cbod12;

    private String cbod13;

    private Double cbod14;

    private Double cbod15;

    private Integer cbod16;

    private Double cbod17;

    private Double cbod18;

    private Integer cboc01;

    private Double befPrice;

    private Double befQty;

    private Integer cbobid;

    private static final long serialVersionUID = 1L;

    public Integer getCbod01() {
        return cbod01;
    }

    public void setCbod01(Integer cbod01) {
        this.cbod01 = cbod01;
    }

    public Integer getCbod02() {
        return cbod02;
    }

    public void setCbod02(Integer cbod02) {
        this.cbod02 = cbod02;
    }

    public Date getCbod03() {
        return cbod03;
    }

    public void setCbod03(Date cbod03) {
        this.cbod03 = cbod03;
    }

    public Integer getCbod04() {
        return cbod04;
    }

    public void setCbod04(Integer cbod04) {
        this.cbod04 = cbod04;
    }

    public Date getCbod05() {
        return cbod05;
    }

    public void setCbod05(Date cbod05) {
        this.cbod05 = cbod05;
    }

    public Integer getCbod06() {
        return cbod06;
    }

    public void setCbod06(Integer cbod06) {
        this.cbod06 = cbod06;
    }

    public Integer getCbod07() {
        return cbod07;
    }

    public void setCbod07(Integer cbod07) {
        this.cbod07 = cbod07;
    }

    public Integer getCbod08() {
        return cbod08;
    }

    public void setCbod08(Integer cbod08) {
        this.cbod08 = cbod08;
    }

    public Double getCbod09() {
        return cbod09;
    }

    public void setCbod09(Double cbod09) {
        this.cbod09 = cbod09;
    }

    public Double getCbod10() {
        return cbod10;
    }

    public void setCbod10(Double cbod10) {
        this.cbod10 = cbod10;
    }

    public Double getCbod11() {
        return cbod11;
    }

    public void setCbod11(Double cbod11) {
        this.cbod11 = cbod11;
    }

    public Double getCbod12() {
        return cbod12;
    }

    public void setCbod12(Double cbod12) {
        this.cbod12 = cbod12;
    }

    public String getCbod13() {
        return cbod13;
    }

    public void setCbod13(String cbod13) {
        this.cbod13 = cbod13 == null ? null : cbod13.trim();
    }

    public Double getCbod14() {
        return cbod14;
    }

    public void setCbod14(Double cbod14) {
        this.cbod14 = cbod14;
    }

    public Double getCbod15() {
        return cbod15;
    }

    public void setCbod15(Double cbod15) {
        this.cbod15 = cbod15;
    }

    public Integer getCbod16() {
        return cbod16;
    }

    public void setCbod16(Integer cbod16) {
        this.cbod16 = cbod16;
    }

    public Double getCbod17() {
        return cbod17;
    }

    public void setCbod17(Double cbod17) {
        this.cbod17 = cbod17;
    }

    public Double getCbod18() {
        return cbod18;
    }

    public void setCbod18(Double cbod18) {
        this.cbod18 = cbod18;
    }

    public Integer getCboc01() {
        return cboc01;
    }

    public void setCboc01(Integer cboc01) {
        this.cboc01 = cboc01;
    }

    public Double getBefPrice() {
        return befPrice;
    }

    public void setBefPrice(Double befPrice) {
        this.befPrice = befPrice;
    }

    public Double getBefQty() {
        return befQty;
    }

    public void setBefQty(Double befQty) {
        this.befQty = befQty;
    }

    public Integer getCbobid() {
        return cbobid;
    }

    public void setCbobid(Integer cbobid) {
        this.cbobid = cbobid;
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
        Cbod other = (Cbod) that;
        return (this.getCbod01() == null ? other.getCbod01() == null : this.getCbod01().equals(other.getCbod01()))
            && (this.getCbod02() == null ? other.getCbod02() == null : this.getCbod02().equals(other.getCbod02()))
            && (this.getCbod03() == null ? other.getCbod03() == null : this.getCbod03().equals(other.getCbod03()))
            && (this.getCbod04() == null ? other.getCbod04() == null : this.getCbod04().equals(other.getCbod04()))
            && (this.getCbod05() == null ? other.getCbod05() == null : this.getCbod05().equals(other.getCbod05()))
            && (this.getCbod06() == null ? other.getCbod06() == null : this.getCbod06().equals(other.getCbod06()))
            && (this.getCbod07() == null ? other.getCbod07() == null : this.getCbod07().equals(other.getCbod07()))
            && (this.getCbod08() == null ? other.getCbod08() == null : this.getCbod08().equals(other.getCbod08()))
            && (this.getCbod09() == null ? other.getCbod09() == null : this.getCbod09().equals(other.getCbod09()))
            && (this.getCbod10() == null ? other.getCbod10() == null : this.getCbod10().equals(other.getCbod10()))
            && (this.getCbod11() == null ? other.getCbod11() == null : this.getCbod11().equals(other.getCbod11()))
            && (this.getCbod12() == null ? other.getCbod12() == null : this.getCbod12().equals(other.getCbod12()))
            && (this.getCbod13() == null ? other.getCbod13() == null : this.getCbod13().equals(other.getCbod13()))
            && (this.getCbod14() == null ? other.getCbod14() == null : this.getCbod14().equals(other.getCbod14()))
            && (this.getCbod15() == null ? other.getCbod15() == null : this.getCbod15().equals(other.getCbod15()))
            && (this.getCbod16() == null ? other.getCbod16() == null : this.getCbod16().equals(other.getCbod16()))
            && (this.getCbod17() == null ? other.getCbod17() == null : this.getCbod17().equals(other.getCbod17()))
            && (this.getCbod18() == null ? other.getCbod18() == null : this.getCbod18().equals(other.getCbod18()))
            && (this.getCboc01() == null ? other.getCboc01() == null : this.getCboc01().equals(other.getCboc01()))
            && (this.getBefPrice() == null ? other.getBefPrice() == null : this.getBefPrice().equals(other.getBefPrice()))
            && (this.getBefQty() == null ? other.getBefQty() == null : this.getBefQty().equals(other.getBefQty()))
            && (this.getCbobid() == null ? other.getCbobid() == null : this.getCbobid().equals(other.getCbobid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbod01() == null) ? 0 : getCbod01().hashCode());
        result = prime * result + ((getCbod02() == null) ? 0 : getCbod02().hashCode());
        result = prime * result + ((getCbod03() == null) ? 0 : getCbod03().hashCode());
        result = prime * result + ((getCbod04() == null) ? 0 : getCbod04().hashCode());
        result = prime * result + ((getCbod05() == null) ? 0 : getCbod05().hashCode());
        result = prime * result + ((getCbod06() == null) ? 0 : getCbod06().hashCode());
        result = prime * result + ((getCbod07() == null) ? 0 : getCbod07().hashCode());
        result = prime * result + ((getCbod08() == null) ? 0 : getCbod08().hashCode());
        result = prime * result + ((getCbod09() == null) ? 0 : getCbod09().hashCode());
        result = prime * result + ((getCbod10() == null) ? 0 : getCbod10().hashCode());
        result = prime * result + ((getCbod11() == null) ? 0 : getCbod11().hashCode());
        result = prime * result + ((getCbod12() == null) ? 0 : getCbod12().hashCode());
        result = prime * result + ((getCbod13() == null) ? 0 : getCbod13().hashCode());
        result = prime * result + ((getCbod14() == null) ? 0 : getCbod14().hashCode());
        result = prime * result + ((getCbod15() == null) ? 0 : getCbod15().hashCode());
        result = prime * result + ((getCbod16() == null) ? 0 : getCbod16().hashCode());
        result = prime * result + ((getCbod17() == null) ? 0 : getCbod17().hashCode());
        result = prime * result + ((getCbod18() == null) ? 0 : getCbod18().hashCode());
        result = prime * result + ((getCboc01() == null) ? 0 : getCboc01().hashCode());
        result = prime * result + ((getBefPrice() == null) ? 0 : getBefPrice().hashCode());
        result = prime * result + ((getBefQty() == null) ? 0 : getBefQty().hashCode());
        result = prime * result + ((getCbobid() == null) ? 0 : getCbobid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbod01=").append(cbod01);
        sb.append(", cbod02=").append(cbod02);
        sb.append(", cbod03=").append(cbod03);
        sb.append(", cbod04=").append(cbod04);
        sb.append(", cbod05=").append(cbod05);
        sb.append(", cbod06=").append(cbod06);
        sb.append(", cbod07=").append(cbod07);
        sb.append(", cbod08=").append(cbod08);
        sb.append(", cbod09=").append(cbod09);
        sb.append(", cbod10=").append(cbod10);
        sb.append(", cbod11=").append(cbod11);
        sb.append(", cbod12=").append(cbod12);
        sb.append(", cbod13=").append(cbod13);
        sb.append(", cbod14=").append(cbod14);
        sb.append(", cbod15=").append(cbod15);
        sb.append(", cbod16=").append(cbod16);
        sb.append(", cbod17=").append(cbod17);
        sb.append(", cbod18=").append(cbod18);
        sb.append(", cboc01=").append(cboc01);
        sb.append(", befPrice=").append(befPrice);
        sb.append(", befQty=").append(befQty);
        sb.append(", cbobid=").append(cbobid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
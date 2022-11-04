package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpl implements Serializable {
    private Integer cbpl01;

    private Integer cbpl02;

    private Date cbpl03;

    private Integer cbpl04;

    private Date cbpl05;

    private Integer cbpl06;

    private Integer cbpl07;

    private Integer cbpl08;

    private Double cbpl09;

    private Double cbpl10;

    private Double cbpl11;

    private Double cbpl12;

    private String cbpl13;

    private Integer cbpl14;

    private Integer cbpl15;

    private Integer cbpl16;

    private Integer cbpk01;

    private Double goodProductQty;

    private Integer cbobId;

    private static final long serialVersionUID = 1L;

    public Integer getCbpl01() {
        return cbpl01;
    }

    public void setCbpl01(Integer cbpl01) {
        this.cbpl01 = cbpl01;
    }

    public Integer getCbpl02() {
        return cbpl02;
    }

    public void setCbpl02(Integer cbpl02) {
        this.cbpl02 = cbpl02;
    }

    public Date getCbpl03() {
        return cbpl03;
    }

    public void setCbpl03(Date cbpl03) {
        this.cbpl03 = cbpl03;
    }

    public Integer getCbpl04() {
        return cbpl04;
    }

    public void setCbpl04(Integer cbpl04) {
        this.cbpl04 = cbpl04;
    }

    public Date getCbpl05() {
        return cbpl05;
    }

    public void setCbpl05(Date cbpl05) {
        this.cbpl05 = cbpl05;
    }

    public Integer getCbpl06() {
        return cbpl06;
    }

    public void setCbpl06(Integer cbpl06) {
        this.cbpl06 = cbpl06;
    }

    public Integer getCbpl07() {
        return cbpl07;
    }

    public void setCbpl07(Integer cbpl07) {
        this.cbpl07 = cbpl07;
    }

    public Integer getCbpl08() {
        return cbpl08;
    }

    public void setCbpl08(Integer cbpl08) {
        this.cbpl08 = cbpl08;
    }

    public Double getCbpl09() {
        return cbpl09;
    }

    public void setCbpl09(Double cbpl09) {
        this.cbpl09 = cbpl09;
    }

    public Double getCbpl10() {
        return cbpl10;
    }

    public void setCbpl10(Double cbpl10) {
        this.cbpl10 = cbpl10;
    }

    public Double getCbpl11() {
        return cbpl11;
    }

    public void setCbpl11(Double cbpl11) {
        this.cbpl11 = cbpl11;
    }

    public Double getCbpl12() {
        return cbpl12;
    }

    public void setCbpl12(Double cbpl12) {
        this.cbpl12 = cbpl12;
    }

    public String getCbpl13() {
        return cbpl13;
    }

    public void setCbpl13(String cbpl13) {
        this.cbpl13 = cbpl13 == null ? null : cbpl13.trim();
    }

    public Integer getCbpl14() {
        return cbpl14;
    }

    public void setCbpl14(Integer cbpl14) {
        this.cbpl14 = cbpl14;
    }

    public Integer getCbpl15() {
        return cbpl15;
    }

    public void setCbpl15(Integer cbpl15) {
        this.cbpl15 = cbpl15;
    }

    public Integer getCbpl16() {
        return cbpl16;
    }

    public void setCbpl16(Integer cbpl16) {
        this.cbpl16 = cbpl16;
    }

    public Integer getCbpk01() {
        return cbpk01;
    }

    public void setCbpk01(Integer cbpk01) {
        this.cbpk01 = cbpk01;
    }

    public Double getGoodProductQty() {
        return goodProductQty;
    }

    public void setGoodProductQty(Double goodProductQty) {
        this.goodProductQty = goodProductQty;
    }

    public Integer getCbobId() {
        return cbobId;
    }

    public void setCbobId(Integer cbobId) {
        this.cbobId = cbobId;
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
        Cbpl other = (Cbpl) that;
        return (this.getCbpl01() == null ? other.getCbpl01() == null : this.getCbpl01().equals(other.getCbpl01()))
            && (this.getCbpl02() == null ? other.getCbpl02() == null : this.getCbpl02().equals(other.getCbpl02()))
            && (this.getCbpl03() == null ? other.getCbpl03() == null : this.getCbpl03().equals(other.getCbpl03()))
            && (this.getCbpl04() == null ? other.getCbpl04() == null : this.getCbpl04().equals(other.getCbpl04()))
            && (this.getCbpl05() == null ? other.getCbpl05() == null : this.getCbpl05().equals(other.getCbpl05()))
            && (this.getCbpl06() == null ? other.getCbpl06() == null : this.getCbpl06().equals(other.getCbpl06()))
            && (this.getCbpl07() == null ? other.getCbpl07() == null : this.getCbpl07().equals(other.getCbpl07()))
            && (this.getCbpl08() == null ? other.getCbpl08() == null : this.getCbpl08().equals(other.getCbpl08()))
            && (this.getCbpl09() == null ? other.getCbpl09() == null : this.getCbpl09().equals(other.getCbpl09()))
            && (this.getCbpl10() == null ? other.getCbpl10() == null : this.getCbpl10().equals(other.getCbpl10()))
            && (this.getCbpl11() == null ? other.getCbpl11() == null : this.getCbpl11().equals(other.getCbpl11()))
            && (this.getCbpl12() == null ? other.getCbpl12() == null : this.getCbpl12().equals(other.getCbpl12()))
            && (this.getCbpl13() == null ? other.getCbpl13() == null : this.getCbpl13().equals(other.getCbpl13()))
            && (this.getCbpl14() == null ? other.getCbpl14() == null : this.getCbpl14().equals(other.getCbpl14()))
            && (this.getCbpl15() == null ? other.getCbpl15() == null : this.getCbpl15().equals(other.getCbpl15()))
            && (this.getCbpl16() == null ? other.getCbpl16() == null : this.getCbpl16().equals(other.getCbpl16()))
            && (this.getCbpk01() == null ? other.getCbpk01() == null : this.getCbpk01().equals(other.getCbpk01()))
            && (this.getGoodProductQty() == null ? other.getGoodProductQty() == null : this.getGoodProductQty().equals(other.getGoodProductQty()))
            && (this.getCbobId() == null ? other.getCbobId() == null : this.getCbobId().equals(other.getCbobId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpl01() == null) ? 0 : getCbpl01().hashCode());
        result = prime * result + ((getCbpl02() == null) ? 0 : getCbpl02().hashCode());
        result = prime * result + ((getCbpl03() == null) ? 0 : getCbpl03().hashCode());
        result = prime * result + ((getCbpl04() == null) ? 0 : getCbpl04().hashCode());
        result = prime * result + ((getCbpl05() == null) ? 0 : getCbpl05().hashCode());
        result = prime * result + ((getCbpl06() == null) ? 0 : getCbpl06().hashCode());
        result = prime * result + ((getCbpl07() == null) ? 0 : getCbpl07().hashCode());
        result = prime * result + ((getCbpl08() == null) ? 0 : getCbpl08().hashCode());
        result = prime * result + ((getCbpl09() == null) ? 0 : getCbpl09().hashCode());
        result = prime * result + ((getCbpl10() == null) ? 0 : getCbpl10().hashCode());
        result = prime * result + ((getCbpl11() == null) ? 0 : getCbpl11().hashCode());
        result = prime * result + ((getCbpl12() == null) ? 0 : getCbpl12().hashCode());
        result = prime * result + ((getCbpl13() == null) ? 0 : getCbpl13().hashCode());
        result = prime * result + ((getCbpl14() == null) ? 0 : getCbpl14().hashCode());
        result = prime * result + ((getCbpl15() == null) ? 0 : getCbpl15().hashCode());
        result = prime * result + ((getCbpl16() == null) ? 0 : getCbpl16().hashCode());
        result = prime * result + ((getCbpk01() == null) ? 0 : getCbpk01().hashCode());
        result = prime * result + ((getGoodProductQty() == null) ? 0 : getGoodProductQty().hashCode());
        result = prime * result + ((getCbobId() == null) ? 0 : getCbobId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpl01=").append(cbpl01);
        sb.append(", cbpl02=").append(cbpl02);
        sb.append(", cbpl03=").append(cbpl03);
        sb.append(", cbpl04=").append(cbpl04);
        sb.append(", cbpl05=").append(cbpl05);
        sb.append(", cbpl06=").append(cbpl06);
        sb.append(", cbpl07=").append(cbpl07);
        sb.append(", cbpl08=").append(cbpl08);
        sb.append(", cbpl09=").append(cbpl09);
        sb.append(", cbpl10=").append(cbpl10);
        sb.append(", cbpl11=").append(cbpl11);
        sb.append(", cbpl12=").append(cbpl12);
        sb.append(", cbpl13=").append(cbpl13);
        sb.append(", cbpl14=").append(cbpl14);
        sb.append(", cbpl15=").append(cbpl15);
        sb.append(", cbpl16=").append(cbpl16);
        sb.append(", cbpk01=").append(cbpk01);
        sb.append(", goodProductQty=").append(goodProductQty);
        sb.append(", cbobId=").append(cbobId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbab implements Serializable {
    private Integer cbab01;

    private Integer cbab02;

    private Date cbab03;

    private Integer cbab04;

    private Date cbab05;

    private Integer cbab06;

    private Integer cbab07;

    private Integer cbab08;

    private Double cbab09;

    private Double cbab10;

    private Double cbab11;

    private Double cbab12;

    private String cbab13;

    private Integer cbaa01;

    private Integer cbab14;

    private Integer cbab15;

    private Integer cbab16;

    private Integer cbab17;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbab01() {
        return cbab01;
    }

    public void setCbab01(Integer cbab01) {
        this.cbab01 = cbab01;
    }

    public Integer getCbab02() {
        return cbab02;
    }

    public void setCbab02(Integer cbab02) {
        this.cbab02 = cbab02;
    }

    public Date getCbab03() {
        return cbab03;
    }

    public void setCbab03(Date cbab03) {
        this.cbab03 = cbab03;
    }

    public Integer getCbab04() {
        return cbab04;
    }

    public void setCbab04(Integer cbab04) {
        this.cbab04 = cbab04;
    }

    public Date getCbab05() {
        return cbab05;
    }

    public void setCbab05(Date cbab05) {
        this.cbab05 = cbab05;
    }

    public Integer getCbab06() {
        return cbab06;
    }

    public void setCbab06(Integer cbab06) {
        this.cbab06 = cbab06;
    }

    public Integer getCbab07() {
        return cbab07;
    }

    public void setCbab07(Integer cbab07) {
        this.cbab07 = cbab07;
    }

    public Integer getCbab08() {
        return cbab08;
    }

    public void setCbab08(Integer cbab08) {
        this.cbab08 = cbab08;
    }

    public Double getCbab09() {
        return cbab09;
    }

    public void setCbab09(Double cbab09) {
        this.cbab09 = cbab09;
    }

    public Double getCbab10() {
        return cbab10;
    }

    public void setCbab10(Double cbab10) {
        this.cbab10 = cbab10;
    }

    public Double getCbab11() {
        return cbab11;
    }

    public void setCbab11(Double cbab11) {
        this.cbab11 = cbab11;
    }

    public Double getCbab12() {
        return cbab12;
    }

    public void setCbab12(Double cbab12) {
        this.cbab12 = cbab12;
    }

    public String getCbab13() {
        return cbab13;
    }

    public void setCbab13(String cbab13) {
        this.cbab13 = cbab13 == null ? null : cbab13.trim();
    }

    public Integer getCbaa01() {
        return cbaa01;
    }

    public void setCbaa01(Integer cbaa01) {
        this.cbaa01 = cbaa01;
    }

    public Integer getCbab14() {
        return cbab14;
    }

    public void setCbab14(Integer cbab14) {
        this.cbab14 = cbab14;
    }

    public Integer getCbab15() {
        return cbab15;
    }

    public void setCbab15(Integer cbab15) {
        this.cbab15 = cbab15;
    }

    public Integer getCbab16() {
        return cbab16;
    }

    public void setCbab16(Integer cbab16) {
        this.cbab16 = cbab16;
    }

    public Integer getCbab17() {
        return cbab17;
    }

    public void setCbab17(Integer cbab17) {
        this.cbab17 = cbab17;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        Cbab other = (Cbab) that;
        return (this.getCbab01() == null ? other.getCbab01() == null : this.getCbab01().equals(other.getCbab01()))
            && (this.getCbab02() == null ? other.getCbab02() == null : this.getCbab02().equals(other.getCbab02()))
            && (this.getCbab03() == null ? other.getCbab03() == null : this.getCbab03().equals(other.getCbab03()))
            && (this.getCbab04() == null ? other.getCbab04() == null : this.getCbab04().equals(other.getCbab04()))
            && (this.getCbab05() == null ? other.getCbab05() == null : this.getCbab05().equals(other.getCbab05()))
            && (this.getCbab06() == null ? other.getCbab06() == null : this.getCbab06().equals(other.getCbab06()))
            && (this.getCbab07() == null ? other.getCbab07() == null : this.getCbab07().equals(other.getCbab07()))
            && (this.getCbab08() == null ? other.getCbab08() == null : this.getCbab08().equals(other.getCbab08()))
            && (this.getCbab09() == null ? other.getCbab09() == null : this.getCbab09().equals(other.getCbab09()))
            && (this.getCbab10() == null ? other.getCbab10() == null : this.getCbab10().equals(other.getCbab10()))
            && (this.getCbab11() == null ? other.getCbab11() == null : this.getCbab11().equals(other.getCbab11()))
            && (this.getCbab12() == null ? other.getCbab12() == null : this.getCbab12().equals(other.getCbab12()))
            && (this.getCbab13() == null ? other.getCbab13() == null : this.getCbab13().equals(other.getCbab13()))
            && (this.getCbaa01() == null ? other.getCbaa01() == null : this.getCbaa01().equals(other.getCbaa01()))
            && (this.getCbab14() == null ? other.getCbab14() == null : this.getCbab14().equals(other.getCbab14()))
            && (this.getCbab15() == null ? other.getCbab15() == null : this.getCbab15().equals(other.getCbab15()))
            && (this.getCbab16() == null ? other.getCbab16() == null : this.getCbab16().equals(other.getCbab16()))
            && (this.getCbab17() == null ? other.getCbab17() == null : this.getCbab17().equals(other.getCbab17()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbab01() == null) ? 0 : getCbab01().hashCode());
        result = prime * result + ((getCbab02() == null) ? 0 : getCbab02().hashCode());
        result = prime * result + ((getCbab03() == null) ? 0 : getCbab03().hashCode());
        result = prime * result + ((getCbab04() == null) ? 0 : getCbab04().hashCode());
        result = prime * result + ((getCbab05() == null) ? 0 : getCbab05().hashCode());
        result = prime * result + ((getCbab06() == null) ? 0 : getCbab06().hashCode());
        result = prime * result + ((getCbab07() == null) ? 0 : getCbab07().hashCode());
        result = prime * result + ((getCbab08() == null) ? 0 : getCbab08().hashCode());
        result = prime * result + ((getCbab09() == null) ? 0 : getCbab09().hashCode());
        result = prime * result + ((getCbab10() == null) ? 0 : getCbab10().hashCode());
        result = prime * result + ((getCbab11() == null) ? 0 : getCbab11().hashCode());
        result = prime * result + ((getCbab12() == null) ? 0 : getCbab12().hashCode());
        result = prime * result + ((getCbab13() == null) ? 0 : getCbab13().hashCode());
        result = prime * result + ((getCbaa01() == null) ? 0 : getCbaa01().hashCode());
        result = prime * result + ((getCbab14() == null) ? 0 : getCbab14().hashCode());
        result = prime * result + ((getCbab15() == null) ? 0 : getCbab15().hashCode());
        result = prime * result + ((getCbab16() == null) ? 0 : getCbab16().hashCode());
        result = prime * result + ((getCbab17() == null) ? 0 : getCbab17().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbab01=").append(cbab01);
        sb.append(", cbab02=").append(cbab02);
        sb.append(", cbab03=").append(cbab03);
        sb.append(", cbab04=").append(cbab04);
        sb.append(", cbab05=").append(cbab05);
        sb.append(", cbab06=").append(cbab06);
        sb.append(", cbab07=").append(cbab07);
        sb.append(", cbab08=").append(cbab08);
        sb.append(", cbab09=").append(cbab09);
        sb.append(", cbab10=").append(cbab10);
        sb.append(", cbab11=").append(cbab11);
        sb.append(", cbab12=").append(cbab12);
        sb.append(", cbab13=").append(cbab13);
        sb.append(", cbaa01=").append(cbaa01);
        sb.append(", cbab14=").append(cbab14);
        sb.append(", cbab15=").append(cbab15);
        sb.append(", cbab16=").append(cbab16);
        sb.append(", cbab17=").append(cbab17);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
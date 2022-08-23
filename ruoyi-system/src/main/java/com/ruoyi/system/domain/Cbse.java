package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbse implements Serializable {
    private Integer cbse01;

    private Date cbse02;

    private Integer cbse03;

    private Date cbse04;

    private Integer cbse05;

    private Integer cbse06;

    private String cbse07;

    private Date cbse08;

    private Integer cbse09;

    private Integer cbse10;

    private Integer cbse11;

    private Integer cbse12;

    private Date cbse13;

    private Integer cbse14;

    private Date cbse15;

    private Integer cbse16;

    private String cbse17;

    private Integer cbse18;

    private Integer userId;

    private Integer changeType;

    private static final long serialVersionUID = 1L;

    public Integer getCbse01() {
        return cbse01;
    }

    public void setCbse01(Integer cbse01) {
        this.cbse01 = cbse01;
    }

    public Date getCbse02() {
        return cbse02;
    }

    public void setCbse02(Date cbse02) {
        this.cbse02 = cbse02;
    }

    public Integer getCbse03() {
        return cbse03;
    }

    public void setCbse03(Integer cbse03) {
        this.cbse03 = cbse03;
    }

    public Date getCbse04() {
        return cbse04;
    }

    public void setCbse04(Date cbse04) {
        this.cbse04 = cbse04;
    }

    public Integer getCbse05() {
        return cbse05;
    }

    public void setCbse05(Integer cbse05) {
        this.cbse05 = cbse05;
    }

    public Integer getCbse06() {
        return cbse06;
    }

    public void setCbse06(Integer cbse06) {
        this.cbse06 = cbse06;
    }

    public String getCbse07() {
        return cbse07;
    }

    public void setCbse07(String cbse07) {
        this.cbse07 = cbse07 == null ? null : cbse07.trim();
    }

    public Date getCbse08() {
        return cbse08;
    }

    public void setCbse08(Date cbse08) {
        this.cbse08 = cbse08;
    }

    public Integer getCbse09() {
        return cbse09;
    }

    public void setCbse09(Integer cbse09) {
        this.cbse09 = cbse09;
    }

    public Integer getCbse10() {
        return cbse10;
    }

    public void setCbse10(Integer cbse10) {
        this.cbse10 = cbse10;
    }

    public Integer getCbse11() {
        return cbse11;
    }

    public void setCbse11(Integer cbse11) {
        this.cbse11 = cbse11;
    }

    public Integer getCbse12() {
        return cbse12;
    }

    public void setCbse12(Integer cbse12) {
        this.cbse12 = cbse12;
    }

    public Date getCbse13() {
        return cbse13;
    }

    public void setCbse13(Date cbse13) {
        this.cbse13 = cbse13;
    }

    public Integer getCbse14() {
        return cbse14;
    }

    public void setCbse14(Integer cbse14) {
        this.cbse14 = cbse14;
    }

    public Date getCbse15() {
        return cbse15;
    }

    public void setCbse15(Date cbse15) {
        this.cbse15 = cbse15;
    }

    public Integer getCbse16() {
        return cbse16;
    }

    public void setCbse16(Integer cbse16) {
        this.cbse16 = cbse16;
    }

    public String getCbse17() {
        return cbse17;
    }

    public void setCbse17(String cbse17) {
        this.cbse17 = cbse17 == null ? null : cbse17.trim();
    }

    public Integer getCbse18() {
        return cbse18;
    }

    public void setCbse18(Integer cbse18) {
        this.cbse18 = cbse18;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
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
        Cbse other = (Cbse) that;
        return (this.getCbse01() == null ? other.getCbse01() == null : this.getCbse01().equals(other.getCbse01()))
            && (this.getCbse02() == null ? other.getCbse02() == null : this.getCbse02().equals(other.getCbse02()))
            && (this.getCbse03() == null ? other.getCbse03() == null : this.getCbse03().equals(other.getCbse03()))
            && (this.getCbse04() == null ? other.getCbse04() == null : this.getCbse04().equals(other.getCbse04()))
            && (this.getCbse05() == null ? other.getCbse05() == null : this.getCbse05().equals(other.getCbse05()))
            && (this.getCbse06() == null ? other.getCbse06() == null : this.getCbse06().equals(other.getCbse06()))
            && (this.getCbse07() == null ? other.getCbse07() == null : this.getCbse07().equals(other.getCbse07()))
            && (this.getCbse08() == null ? other.getCbse08() == null : this.getCbse08().equals(other.getCbse08()))
            && (this.getCbse09() == null ? other.getCbse09() == null : this.getCbse09().equals(other.getCbse09()))
            && (this.getCbse10() == null ? other.getCbse10() == null : this.getCbse10().equals(other.getCbse10()))
            && (this.getCbse11() == null ? other.getCbse11() == null : this.getCbse11().equals(other.getCbse11()))
            && (this.getCbse12() == null ? other.getCbse12() == null : this.getCbse12().equals(other.getCbse12()))
            && (this.getCbse13() == null ? other.getCbse13() == null : this.getCbse13().equals(other.getCbse13()))
            && (this.getCbse14() == null ? other.getCbse14() == null : this.getCbse14().equals(other.getCbse14()))
            && (this.getCbse15() == null ? other.getCbse15() == null : this.getCbse15().equals(other.getCbse15()))
            && (this.getCbse16() == null ? other.getCbse16() == null : this.getCbse16().equals(other.getCbse16()))
            && (this.getCbse17() == null ? other.getCbse17() == null : this.getCbse17().equals(other.getCbse17()))
            && (this.getCbse18() == null ? other.getCbse18() == null : this.getCbse18().equals(other.getCbse18()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getChangeType() == null ? other.getChangeType() == null : this.getChangeType().equals(other.getChangeType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbse01() == null) ? 0 : getCbse01().hashCode());
        result = prime * result + ((getCbse02() == null) ? 0 : getCbse02().hashCode());
        result = prime * result + ((getCbse03() == null) ? 0 : getCbse03().hashCode());
        result = prime * result + ((getCbse04() == null) ? 0 : getCbse04().hashCode());
        result = prime * result + ((getCbse05() == null) ? 0 : getCbse05().hashCode());
        result = prime * result + ((getCbse06() == null) ? 0 : getCbse06().hashCode());
        result = prime * result + ((getCbse07() == null) ? 0 : getCbse07().hashCode());
        result = prime * result + ((getCbse08() == null) ? 0 : getCbse08().hashCode());
        result = prime * result + ((getCbse09() == null) ? 0 : getCbse09().hashCode());
        result = prime * result + ((getCbse10() == null) ? 0 : getCbse10().hashCode());
        result = prime * result + ((getCbse11() == null) ? 0 : getCbse11().hashCode());
        result = prime * result + ((getCbse12() == null) ? 0 : getCbse12().hashCode());
        result = prime * result + ((getCbse13() == null) ? 0 : getCbse13().hashCode());
        result = prime * result + ((getCbse14() == null) ? 0 : getCbse14().hashCode());
        result = prime * result + ((getCbse15() == null) ? 0 : getCbse15().hashCode());
        result = prime * result + ((getCbse16() == null) ? 0 : getCbse16().hashCode());
        result = prime * result + ((getCbse17() == null) ? 0 : getCbse17().hashCode());
        result = prime * result + ((getCbse18() == null) ? 0 : getCbse18().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getChangeType() == null) ? 0 : getChangeType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbse01=").append(cbse01);
        sb.append(", cbse02=").append(cbse02);
        sb.append(", cbse03=").append(cbse03);
        sb.append(", cbse04=").append(cbse04);
        sb.append(", cbse05=").append(cbse05);
        sb.append(", cbse06=").append(cbse06);
        sb.append(", cbse07=").append(cbse07);
        sb.append(", cbse08=").append(cbse08);
        sb.append(", cbse09=").append(cbse09);
        sb.append(", cbse10=").append(cbse10);
        sb.append(", cbse11=").append(cbse11);
        sb.append(", cbse12=").append(cbse12);
        sb.append(", cbse13=").append(cbse13);
        sb.append(", cbse14=").append(cbse14);
        sb.append(", cbse15=").append(cbse15);
        sb.append(", cbse16=").append(cbse16);
        sb.append(", cbse17=").append(cbse17);
        sb.append(", cbse18=").append(cbse18);
        sb.append(", userId=").append(userId);
        sb.append(", changeType=").append(changeType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsj implements Serializable {
    private Integer cbsj01;

    private Integer cbsj02;

    private Date cbsj03;

    private Integer cbsj04;

    private Date cbsj05;

    private Integer cbsj06;

    private Integer cbsj07;

    private Integer cbsj08;

    private String cbsj09;

    private Integer cbsj10;

    private Integer cbsj11;

    private String cbsj12;

    private Integer cbsh01;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbsj01() {
        return cbsj01;
    }

    public void setCbsj01(Integer cbsj01) {
        this.cbsj01 = cbsj01;
    }

    public Integer getCbsj02() {
        return cbsj02;
    }

    public void setCbsj02(Integer cbsj02) {
        this.cbsj02 = cbsj02;
    }

    public Date getCbsj03() {
        return cbsj03;
    }

    public void setCbsj03(Date cbsj03) {
        this.cbsj03 = cbsj03;
    }

    public Integer getCbsj04() {
        return cbsj04;
    }

    public void setCbsj04(Integer cbsj04) {
        this.cbsj04 = cbsj04;
    }

    public Date getCbsj05() {
        return cbsj05;
    }

    public void setCbsj05(Date cbsj05) {
        this.cbsj05 = cbsj05;
    }

    public Integer getCbsj06() {
        return cbsj06;
    }

    public void setCbsj06(Integer cbsj06) {
        this.cbsj06 = cbsj06;
    }

    public Integer getCbsj07() {
        return cbsj07;
    }

    public void setCbsj07(Integer cbsj07) {
        this.cbsj07 = cbsj07;
    }

    public Integer getCbsj08() {
        return cbsj08;
    }

    public void setCbsj08(Integer cbsj08) {
        this.cbsj08 = cbsj08;
    }

    public String getCbsj09() {
        return cbsj09;
    }

    public void setCbsj09(String cbsj09) {
        this.cbsj09 = cbsj09 == null ? null : cbsj09.trim();
    }

    public Integer getCbsj10() {
        return cbsj10;
    }

    public void setCbsj10(Integer cbsj10) {
        this.cbsj10 = cbsj10;
    }

    public Integer getCbsj11() {
        return cbsj11;
    }

    public void setCbsj11(Integer cbsj11) {
        this.cbsj11 = cbsj11;
    }

    public String getCbsj12() {
        return cbsj12;
    }

    public void setCbsj12(String cbsj12) {
        this.cbsj12 = cbsj12 == null ? null : cbsj12.trim();
    }

    public Integer getCbsh01() {
        return cbsh01;
    }

    public void setCbsh01(Integer cbsh01) {
        this.cbsh01 = cbsh01;
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
        Cbsj other = (Cbsj) that;
        return (this.getCbsj01() == null ? other.getCbsj01() == null : this.getCbsj01().equals(other.getCbsj01()))
            && (this.getCbsj02() == null ? other.getCbsj02() == null : this.getCbsj02().equals(other.getCbsj02()))
            && (this.getCbsj03() == null ? other.getCbsj03() == null : this.getCbsj03().equals(other.getCbsj03()))
            && (this.getCbsj04() == null ? other.getCbsj04() == null : this.getCbsj04().equals(other.getCbsj04()))
            && (this.getCbsj05() == null ? other.getCbsj05() == null : this.getCbsj05().equals(other.getCbsj05()))
            && (this.getCbsj06() == null ? other.getCbsj06() == null : this.getCbsj06().equals(other.getCbsj06()))
            && (this.getCbsj07() == null ? other.getCbsj07() == null : this.getCbsj07().equals(other.getCbsj07()))
            && (this.getCbsj08() == null ? other.getCbsj08() == null : this.getCbsj08().equals(other.getCbsj08()))
            && (this.getCbsj09() == null ? other.getCbsj09() == null : this.getCbsj09().equals(other.getCbsj09()))
            && (this.getCbsj10() == null ? other.getCbsj10() == null : this.getCbsj10().equals(other.getCbsj10()))
            && (this.getCbsj11() == null ? other.getCbsj11() == null : this.getCbsj11().equals(other.getCbsj11()))
            && (this.getCbsj12() == null ? other.getCbsj12() == null : this.getCbsj12().equals(other.getCbsj12()))
            && (this.getCbsh01() == null ? other.getCbsh01() == null : this.getCbsh01().equals(other.getCbsh01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsj01() == null) ? 0 : getCbsj01().hashCode());
        result = prime * result + ((getCbsj02() == null) ? 0 : getCbsj02().hashCode());
        result = prime * result + ((getCbsj03() == null) ? 0 : getCbsj03().hashCode());
        result = prime * result + ((getCbsj04() == null) ? 0 : getCbsj04().hashCode());
        result = prime * result + ((getCbsj05() == null) ? 0 : getCbsj05().hashCode());
        result = prime * result + ((getCbsj06() == null) ? 0 : getCbsj06().hashCode());
        result = prime * result + ((getCbsj07() == null) ? 0 : getCbsj07().hashCode());
        result = prime * result + ((getCbsj08() == null) ? 0 : getCbsj08().hashCode());
        result = prime * result + ((getCbsj09() == null) ? 0 : getCbsj09().hashCode());
        result = prime * result + ((getCbsj10() == null) ? 0 : getCbsj10().hashCode());
        result = prime * result + ((getCbsj11() == null) ? 0 : getCbsj11().hashCode());
        result = prime * result + ((getCbsj12() == null) ? 0 : getCbsj12().hashCode());
        result = prime * result + ((getCbsh01() == null) ? 0 : getCbsh01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsj01=").append(cbsj01);
        sb.append(", cbsj02=").append(cbsj02);
        sb.append(", cbsj03=").append(cbsj03);
        sb.append(", cbsj04=").append(cbsj04);
        sb.append(", cbsj05=").append(cbsj05);
        sb.append(", cbsj06=").append(cbsj06);
        sb.append(", cbsj07=").append(cbsj07);
        sb.append(", cbsj08=").append(cbsj08);
        sb.append(", cbsj09=").append(cbsj09);
        sb.append(", cbsj10=").append(cbsj10);
        sb.append(", cbsj11=").append(cbsj11);
        sb.append(", cbsj12=").append(cbsj12);
        sb.append(", cbsh01=").append(cbsh01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
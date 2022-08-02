package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpi implements Serializable {
    private Integer cbpi01;

    private Integer cbpi02;

    private Date cbpi03;

    private Integer cbpi04;

    private Date cbpi05;

    private Integer cbpi06;

    private Integer cbpi07;

    private Integer cbpi08;

    private String cbpi09;

    private Integer cbpi10;

    private Integer cbpi11;

    private String cbpi12;

    private Integer cbpg01;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbpi01() {
        return cbpi01;
    }

    public void setCbpi01(Integer cbpi01) {
        this.cbpi01 = cbpi01;
    }

    public Integer getCbpi02() {
        return cbpi02;
    }

    public void setCbpi02(Integer cbpi02) {
        this.cbpi02 = cbpi02;
    }

    public Date getCbpi03() {
        return cbpi03;
    }

    public void setCbpi03(Date cbpi03) {
        this.cbpi03 = cbpi03;
    }

    public Integer getCbpi04() {
        return cbpi04;
    }

    public void setCbpi04(Integer cbpi04) {
        this.cbpi04 = cbpi04;
    }

    public Date getCbpi05() {
        return cbpi05;
    }

    public void setCbpi05(Date cbpi05) {
        this.cbpi05 = cbpi05;
    }

    public Integer getCbpi06() {
        return cbpi06;
    }

    public void setCbpi06(Integer cbpi06) {
        this.cbpi06 = cbpi06;
    }

    public Integer getCbpi07() {
        return cbpi07;
    }

    public void setCbpi07(Integer cbpi07) {
        this.cbpi07 = cbpi07;
    }

    public Integer getCbpi08() {
        return cbpi08;
    }

    public void setCbpi08(Integer cbpi08) {
        this.cbpi08 = cbpi08;
    }

    public String getCbpi09() {
        return cbpi09;
    }

    public void setCbpi09(String cbpi09) {
        this.cbpi09 = cbpi09 == null ? null : cbpi09.trim();
    }

    public Integer getCbpi10() {
        return cbpi10;
    }

    public void setCbpi10(Integer cbpi10) {
        this.cbpi10 = cbpi10;
    }

    public Integer getCbpi11() {
        return cbpi11;
    }

    public void setCbpi11(Integer cbpi11) {
        this.cbpi11 = cbpi11;
    }

    public String getCbpi12() {
        return cbpi12;
    }

    public void setCbpi12(String cbpi12) {
        this.cbpi12 = cbpi12 == null ? null : cbpi12.trim();
    }

    public Integer getCbpg01() {
        return cbpg01;
    }

    public void setCbpg01(Integer cbpg01) {
        this.cbpg01 = cbpg01;
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
        Cbpi other = (Cbpi) that;
        return (this.getCbpi01() == null ? other.getCbpi01() == null : this.getCbpi01().equals(other.getCbpi01()))
            && (this.getCbpi02() == null ? other.getCbpi02() == null : this.getCbpi02().equals(other.getCbpi02()))
            && (this.getCbpi03() == null ? other.getCbpi03() == null : this.getCbpi03().equals(other.getCbpi03()))
            && (this.getCbpi04() == null ? other.getCbpi04() == null : this.getCbpi04().equals(other.getCbpi04()))
            && (this.getCbpi05() == null ? other.getCbpi05() == null : this.getCbpi05().equals(other.getCbpi05()))
            && (this.getCbpi06() == null ? other.getCbpi06() == null : this.getCbpi06().equals(other.getCbpi06()))
            && (this.getCbpi07() == null ? other.getCbpi07() == null : this.getCbpi07().equals(other.getCbpi07()))
            && (this.getCbpi08() == null ? other.getCbpi08() == null : this.getCbpi08().equals(other.getCbpi08()))
            && (this.getCbpi09() == null ? other.getCbpi09() == null : this.getCbpi09().equals(other.getCbpi09()))
            && (this.getCbpi10() == null ? other.getCbpi10() == null : this.getCbpi10().equals(other.getCbpi10()))
            && (this.getCbpi11() == null ? other.getCbpi11() == null : this.getCbpi11().equals(other.getCbpi11()))
            && (this.getCbpi12() == null ? other.getCbpi12() == null : this.getCbpi12().equals(other.getCbpi12()))
            && (this.getCbpg01() == null ? other.getCbpg01() == null : this.getCbpg01().equals(other.getCbpg01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpi01() == null) ? 0 : getCbpi01().hashCode());
        result = prime * result + ((getCbpi02() == null) ? 0 : getCbpi02().hashCode());
        result = prime * result + ((getCbpi03() == null) ? 0 : getCbpi03().hashCode());
        result = prime * result + ((getCbpi04() == null) ? 0 : getCbpi04().hashCode());
        result = prime * result + ((getCbpi05() == null) ? 0 : getCbpi05().hashCode());
        result = prime * result + ((getCbpi06() == null) ? 0 : getCbpi06().hashCode());
        result = prime * result + ((getCbpi07() == null) ? 0 : getCbpi07().hashCode());
        result = prime * result + ((getCbpi08() == null) ? 0 : getCbpi08().hashCode());
        result = prime * result + ((getCbpi09() == null) ? 0 : getCbpi09().hashCode());
        result = prime * result + ((getCbpi10() == null) ? 0 : getCbpi10().hashCode());
        result = prime * result + ((getCbpi11() == null) ? 0 : getCbpi11().hashCode());
        result = prime * result + ((getCbpi12() == null) ? 0 : getCbpi12().hashCode());
        result = prime * result + ((getCbpg01() == null) ? 0 : getCbpg01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpi01=").append(cbpi01);
        sb.append(", cbpi02=").append(cbpi02);
        sb.append(", cbpi03=").append(cbpi03);
        sb.append(", cbpi04=").append(cbpi04);
        sb.append(", cbpi05=").append(cbpi05);
        sb.append(", cbpi06=").append(cbpi06);
        sb.append(", cbpi07=").append(cbpi07);
        sb.append(", cbpi08=").append(cbpi08);
        sb.append(", cbpi09=").append(cbpi09);
        sb.append(", cbpi10=").append(cbpi10);
        sb.append(", cbpi11=").append(cbpi11);
        sb.append(", cbpi12=").append(cbpi12);
        sb.append(", cbpg01=").append(cbpg01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
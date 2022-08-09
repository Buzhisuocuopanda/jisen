package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbqb implements Serializable {
    private Integer cbqb01;

    private Integer cbqb02;

    private Date cbqb03;

    private Integer cbqb04;

    private Date cbqb05;

    private Integer cbqb06;

    private Integer cbqb07;

    private Integer cbqb08;

    private String cbqb09;

    private String cbqb10;

    private Integer cbqa01;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbqb01() {
        return cbqb01;
    }

    public void setCbqb01(Integer cbqb01) {
        this.cbqb01 = cbqb01;
    }

    public Integer getCbqb02() {
        return cbqb02;
    }

    public void setCbqb02(Integer cbqb02) {
        this.cbqb02 = cbqb02;
    }

    public Date getCbqb03() {
        return cbqb03;
    }

    public void setCbqb03(Date cbqb03) {
        this.cbqb03 = cbqb03;
    }

    public Integer getCbqb04() {
        return cbqb04;
    }

    public void setCbqb04(Integer cbqb04) {
        this.cbqb04 = cbqb04;
    }

    public Date getCbqb05() {
        return cbqb05;
    }

    public void setCbqb05(Date cbqb05) {
        this.cbqb05 = cbqb05;
    }

    public Integer getCbqb06() {
        return cbqb06;
    }

    public void setCbqb06(Integer cbqb06) {
        this.cbqb06 = cbqb06;
    }

    public Integer getCbqb07() {
        return cbqb07;
    }

    public void setCbqb07(Integer cbqb07) {
        this.cbqb07 = cbqb07;
    }

    public Integer getCbqb08() {
        return cbqb08;
    }

    public void setCbqb08(Integer cbqb08) {
        this.cbqb08 = cbqb08;
    }

    public String getCbqb09() {
        return cbqb09;
    }

    public void setCbqb09(String cbqb09) {
        this.cbqb09 = cbqb09 == null ? null : cbqb09.trim();
    }

    public String getCbqb10() {
        return cbqb10;
    }

    public void setCbqb10(String cbqb10) {
        this.cbqb10 = cbqb10 == null ? null : cbqb10.trim();
    }

    public Integer getCbqa01() {
        return cbqa01;
    }

    public void setCbqa01(Integer cbqa01) {
        this.cbqa01 = cbqa01;
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
        Cbqb other = (Cbqb) that;
        return (this.getCbqb01() == null ? other.getCbqb01() == null : this.getCbqb01().equals(other.getCbqb01()))
            && (this.getCbqb02() == null ? other.getCbqb02() == null : this.getCbqb02().equals(other.getCbqb02()))
            && (this.getCbqb03() == null ? other.getCbqb03() == null : this.getCbqb03().equals(other.getCbqb03()))
            && (this.getCbqb04() == null ? other.getCbqb04() == null : this.getCbqb04().equals(other.getCbqb04()))
            && (this.getCbqb05() == null ? other.getCbqb05() == null : this.getCbqb05().equals(other.getCbqb05()))
            && (this.getCbqb06() == null ? other.getCbqb06() == null : this.getCbqb06().equals(other.getCbqb06()))
            && (this.getCbqb07() == null ? other.getCbqb07() == null : this.getCbqb07().equals(other.getCbqb07()))
            && (this.getCbqb08() == null ? other.getCbqb08() == null : this.getCbqb08().equals(other.getCbqb08()))
            && (this.getCbqb09() == null ? other.getCbqb09() == null : this.getCbqb09().equals(other.getCbqb09()))
            && (this.getCbqb10() == null ? other.getCbqb10() == null : this.getCbqb10().equals(other.getCbqb10()))
            && (this.getCbqa01() == null ? other.getCbqa01() == null : this.getCbqa01().equals(other.getCbqa01()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbqb01() == null) ? 0 : getCbqb01().hashCode());
        result = prime * result + ((getCbqb02() == null) ? 0 : getCbqb02().hashCode());
        result = prime * result + ((getCbqb03() == null) ? 0 : getCbqb03().hashCode());
        result = prime * result + ((getCbqb04() == null) ? 0 : getCbqb04().hashCode());
        result = prime * result + ((getCbqb05() == null) ? 0 : getCbqb05().hashCode());
        result = prime * result + ((getCbqb06() == null) ? 0 : getCbqb06().hashCode());
        result = prime * result + ((getCbqb07() == null) ? 0 : getCbqb07().hashCode());
        result = prime * result + ((getCbqb08() == null) ? 0 : getCbqb08().hashCode());
        result = prime * result + ((getCbqb09() == null) ? 0 : getCbqb09().hashCode());
        result = prime * result + ((getCbqb10() == null) ? 0 : getCbqb10().hashCode());
        result = prime * result + ((getCbqa01() == null) ? 0 : getCbqa01().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbqb01=").append(cbqb01);
        sb.append(", cbqb02=").append(cbqb02);
        sb.append(", cbqb03=").append(cbqb03);
        sb.append(", cbqb04=").append(cbqb04);
        sb.append(", cbqb05=").append(cbqb05);
        sb.append(", cbqb06=").append(cbqb06);
        sb.append(", cbqb07=").append(cbqb07);
        sb.append(", cbqb08=").append(cbqb08);
        sb.append(", cbqb09=").append(cbqb09);
        sb.append(", cbqb10=").append(cbqb10);
        sb.append(", cbqa01=").append(cbqa01);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
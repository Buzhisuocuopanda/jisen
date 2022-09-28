package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbda implements Serializable {
    private Integer cbda01;

    private Integer cbda02;

    private Date cbda03;

    private Integer cbda04;

    private Date cbda05;

    private Integer cbda06;

    private Integer cbda07;

    private Integer cbda08;

    private String cbda09;

    private Integer cbda10;

    private Integer cbda11;

    private String cbda12;

    private Integer cbda13;

    private Integer cbda14;

    private Integer cbda15;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getCbda01() {
        return cbda01;
    }

    public void setCbda01(Integer cbda01) {
        this.cbda01 = cbda01;
    }

    public Integer getCbda02() {
        return cbda02;
    }

    public void setCbda02(Integer cbda02) {
        this.cbda02 = cbda02;
    }

    public Date getCbda03() {
        return cbda03;
    }

    public void setCbda03(Date cbda03) {
        this.cbda03 = cbda03;
    }

    public Integer getCbda04() {
        return cbda04;
    }

    public void setCbda04(Integer cbda04) {
        this.cbda04 = cbda04;
    }

    public Date getCbda05() {
        return cbda05;
    }

    public void setCbda05(Date cbda05) {
        this.cbda05 = cbda05;
    }

    public Integer getCbda06() {
        return cbda06;
    }

    public void setCbda06(Integer cbda06) {
        this.cbda06 = cbda06;
    }

    public Integer getCbda07() {
        return cbda07;
    }

    public void setCbda07(Integer cbda07) {
        this.cbda07 = cbda07;
    }

    public Integer getCbda08() {
        return cbda08;
    }

    public void setCbda08(Integer cbda08) {
        this.cbda08 = cbda08;
    }

    public String getCbda09() {
        return cbda09;
    }

    public void setCbda09(String cbda09) {
        this.cbda09 = cbda09 == null ? null : cbda09.trim();
    }

    public Integer getCbda10() {
        return cbda10;
    }

    public void setCbda10(Integer cbda10) {
        this.cbda10 = cbda10;
    }

    public Integer getCbda11() {
        return cbda11;
    }

    public void setCbda11(Integer cbda11) {
        this.cbda11 = cbda11;
    }

    public String getCbda12() {
        return cbda12;
    }

    public void setCbda12(String cbda12) {
        this.cbda12 = cbda12 == null ? null : cbda12.trim();
    }

    public Integer getCbda13() {
        return cbda13;
    }

    public void setCbda13(Integer cbda13) {
        this.cbda13 = cbda13;
    }

    public Integer getCbda14() {
        return cbda14;
    }

    public void setCbda14(Integer cbda14) {
        this.cbda14 = cbda14;
    }

    public Integer getCbda15() {
        return cbda15;
    }

    public void setCbda15(Integer cbda15) {
        this.cbda15 = cbda15;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        Cbda other = (Cbda) that;
        return (this.getCbda01() == null ? other.getCbda01() == null : this.getCbda01().equals(other.getCbda01()))
            && (this.getCbda02() == null ? other.getCbda02() == null : this.getCbda02().equals(other.getCbda02()))
            && (this.getCbda03() == null ? other.getCbda03() == null : this.getCbda03().equals(other.getCbda03()))
            && (this.getCbda04() == null ? other.getCbda04() == null : this.getCbda04().equals(other.getCbda04()))
            && (this.getCbda05() == null ? other.getCbda05() == null : this.getCbda05().equals(other.getCbda05()))
            && (this.getCbda06() == null ? other.getCbda06() == null : this.getCbda06().equals(other.getCbda06()))
            && (this.getCbda07() == null ? other.getCbda07() == null : this.getCbda07().equals(other.getCbda07()))
            && (this.getCbda08() == null ? other.getCbda08() == null : this.getCbda08().equals(other.getCbda08()))
            && (this.getCbda09() == null ? other.getCbda09() == null : this.getCbda09().equals(other.getCbda09()))
            && (this.getCbda10() == null ? other.getCbda10() == null : this.getCbda10().equals(other.getCbda10()))
            && (this.getCbda11() == null ? other.getCbda11() == null : this.getCbda11().equals(other.getCbda11()))
            && (this.getCbda12() == null ? other.getCbda12() == null : this.getCbda12().equals(other.getCbda12()))
            && (this.getCbda13() == null ? other.getCbda13() == null : this.getCbda13().equals(other.getCbda13()))
            && (this.getCbda14() == null ? other.getCbda14() == null : this.getCbda14().equals(other.getCbda14()))
            && (this.getCbda15() == null ? other.getCbda15() == null : this.getCbda15().equals(other.getCbda15()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbda01() == null) ? 0 : getCbda01().hashCode());
        result = prime * result + ((getCbda02() == null) ? 0 : getCbda02().hashCode());
        result = prime * result + ((getCbda03() == null) ? 0 : getCbda03().hashCode());
        result = prime * result + ((getCbda04() == null) ? 0 : getCbda04().hashCode());
        result = prime * result + ((getCbda05() == null) ? 0 : getCbda05().hashCode());
        result = prime * result + ((getCbda06() == null) ? 0 : getCbda06().hashCode());
        result = prime * result + ((getCbda07() == null) ? 0 : getCbda07().hashCode());
        result = prime * result + ((getCbda08() == null) ? 0 : getCbda08().hashCode());
        result = prime * result + ((getCbda09() == null) ? 0 : getCbda09().hashCode());
        result = prime * result + ((getCbda10() == null) ? 0 : getCbda10().hashCode());
        result = prime * result + ((getCbda11() == null) ? 0 : getCbda11().hashCode());
        result = prime * result + ((getCbda12() == null) ? 0 : getCbda12().hashCode());
        result = prime * result + ((getCbda13() == null) ? 0 : getCbda13().hashCode());
        result = prime * result + ((getCbda14() == null) ? 0 : getCbda14().hashCode());
        result = prime * result + ((getCbda15() == null) ? 0 : getCbda15().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbda01=").append(cbda01);
        sb.append(", cbda02=").append(cbda02);
        sb.append(", cbda03=").append(cbda03);
        sb.append(", cbda04=").append(cbda04);
        sb.append(", cbda05=").append(cbda05);
        sb.append(", cbda06=").append(cbda06);
        sb.append(", cbda07=").append(cbda07);
        sb.append(", cbda08=").append(cbda08);
        sb.append(", cbda09=").append(cbda09);
        sb.append(", cbda10=").append(cbda10);
        sb.append(", cbda11=").append(cbda11);
        sb.append(", cbda12=").append(cbda12);
        sb.append(", cbda13=").append(cbda13);
        sb.append(", cbda14=").append(cbda14);
        sb.append(", cbda15=").append(cbda15);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
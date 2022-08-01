package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbla implements Serializable {
    private Integer cbla01;

    private Date cbla02;

    private Integer cbla03;

    private Date cbla04;

    private Integer cbla05;

    private Integer cbla06;

    private Integer cbla07;

    private String cbla08;

    private String cbla09;

    private Integer cbla10;

    private Double cbla11;

    private String cbla12;

    private String cbla13;

    private static final long serialVersionUID = 1L;

    public Integer getCbla01() {
        return cbla01;
    }

    public void setCbla01(Integer cbla01) {
        this.cbla01 = cbla01;
    }

    public Date getCbla02() {
        return cbla02;
    }

    public void setCbla02(Date cbla02) {
        this.cbla02 = cbla02;
    }

    public Integer getCbla03() {
        return cbla03;
    }

    public void setCbla03(Integer cbla03) {
        this.cbla03 = cbla03;
    }

    public Date getCbla04() {
        return cbla04;
    }

    public void setCbla04(Date cbla04) {
        this.cbla04 = cbla04;
    }

    public Integer getCbla05() {
        return cbla05;
    }

    public void setCbla05(Integer cbla05) {
        this.cbla05 = cbla05;
    }

    public Integer getCbla06() {
        return cbla06;
    }

    public void setCbla06(Integer cbla06) {
        this.cbla06 = cbla06;
    }

    public Integer getCbla07() {
        return cbla07;
    }

    public void setCbla07(Integer cbla07) {
        this.cbla07 = cbla07;
    }

    public String getCbla08() {
        return cbla08;
    }

    public void setCbla08(String cbla08) {
        this.cbla08 = cbla08 == null ? null : cbla08.trim();
    }

    public String getCbla09() {
        return cbla09;
    }

    public void setCbla09(String cbla09) {
        this.cbla09 = cbla09 == null ? null : cbla09.trim();
    }

    public Integer getCbla10() {
        return cbla10;
    }

    public void setCbla10(Integer cbla10) {
        this.cbla10 = cbla10;
    }

    public Double getCbla11() {
        return cbla11;
    }

    public void setCbla11(Double cbla11) {
        this.cbla11 = cbla11;
    }

    public String getCbla12() {
        return cbla12;
    }

    public void setCbla12(String cbla12) {
        this.cbla12 = cbla12 == null ? null : cbla12.trim();
    }

    public String getCbla13() {
        return cbla13;
    }

    public void setCbla13(String cbla13) {
        this.cbla13 = cbla13 == null ? null : cbla13.trim();
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
        Cbla other = (Cbla) that;
        return (this.getCbla01() == null ? other.getCbla01() == null : this.getCbla01().equals(other.getCbla01()))
            && (this.getCbla02() == null ? other.getCbla02() == null : this.getCbla02().equals(other.getCbla02()))
            && (this.getCbla03() == null ? other.getCbla03() == null : this.getCbla03().equals(other.getCbla03()))
            && (this.getCbla04() == null ? other.getCbla04() == null : this.getCbla04().equals(other.getCbla04()))
            && (this.getCbla05() == null ? other.getCbla05() == null : this.getCbla05().equals(other.getCbla05()))
            && (this.getCbla06() == null ? other.getCbla06() == null : this.getCbla06().equals(other.getCbla06()))
            && (this.getCbla07() == null ? other.getCbla07() == null : this.getCbla07().equals(other.getCbla07()))
            && (this.getCbla08() == null ? other.getCbla08() == null : this.getCbla08().equals(other.getCbla08()))
            && (this.getCbla09() == null ? other.getCbla09() == null : this.getCbla09().equals(other.getCbla09()))
            && (this.getCbla10() == null ? other.getCbla10() == null : this.getCbla10().equals(other.getCbla10()))
            && (this.getCbla11() == null ? other.getCbla11() == null : this.getCbla11().equals(other.getCbla11()))
            && (this.getCbla12() == null ? other.getCbla12() == null : this.getCbla12().equals(other.getCbla12()))
            && (this.getCbla13() == null ? other.getCbla13() == null : this.getCbla13().equals(other.getCbla13()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbla01() == null) ? 0 : getCbla01().hashCode());
        result = prime * result + ((getCbla02() == null) ? 0 : getCbla02().hashCode());
        result = prime * result + ((getCbla03() == null) ? 0 : getCbla03().hashCode());
        result = prime * result + ((getCbla04() == null) ? 0 : getCbla04().hashCode());
        result = prime * result + ((getCbla05() == null) ? 0 : getCbla05().hashCode());
        result = prime * result + ((getCbla06() == null) ? 0 : getCbla06().hashCode());
        result = prime * result + ((getCbla07() == null) ? 0 : getCbla07().hashCode());
        result = prime * result + ((getCbla08() == null) ? 0 : getCbla08().hashCode());
        result = prime * result + ((getCbla09() == null) ? 0 : getCbla09().hashCode());
        result = prime * result + ((getCbla10() == null) ? 0 : getCbla10().hashCode());
        result = prime * result + ((getCbla11() == null) ? 0 : getCbla11().hashCode());
        result = prime * result + ((getCbla12() == null) ? 0 : getCbla12().hashCode());
        result = prime * result + ((getCbla13() == null) ? 0 : getCbla13().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbla01=").append(cbla01);
        sb.append(", cbla02=").append(cbla02);
        sb.append(", cbla03=").append(cbla03);
        sb.append(", cbla04=").append(cbla04);
        sb.append(", cbla05=").append(cbla05);
        sb.append(", cbla06=").append(cbla06);
        sb.append(", cbla07=").append(cbla07);
        sb.append(", cbla08=").append(cbla08);
        sb.append(", cbla09=").append(cbla09);
        sb.append(", cbla10=").append(cbla10);
        sb.append(", cbla11=").append(cbla11);
        sb.append(", cbla12=").append(cbla12);
        sb.append(", cbla13=").append(cbla13);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
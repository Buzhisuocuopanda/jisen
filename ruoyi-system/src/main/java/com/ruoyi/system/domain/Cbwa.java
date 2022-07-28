package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbwa implements Serializable {
    private Integer cbwa01;

    private Date cbwa02;

    private Integer cbwa03;

    private Date cbwa04;

    private Integer cbwa05;

    private Integer cbwa06;

    private Integer cbwa07;

    private String cbwa08;

    private String cbwa09;

    private String cbwa10;

    private String cbwa11;

    private String cbwa12;

    private Integer cbwa13;

    private Integer cbwa14;

    private Integer cbwa15;

    private static final long serialVersionUID = 1L;

    public Integer getCbwa01() {
        return cbwa01;
    }

    public void setCbwa01(Integer cbwa01) {
        this.cbwa01 = cbwa01;
    }

    public Date getCbwa02() {
        return cbwa02;
    }

    public void setCbwa02(Date cbwa02) {
        this.cbwa02 = cbwa02;
    }

    public Integer getCbwa03() {
        return cbwa03;
    }

    public void setCbwa03(Integer cbwa03) {
        this.cbwa03 = cbwa03;
    }

    public Date getCbwa04() {
        return cbwa04;
    }

    public void setCbwa04(Date cbwa04) {
        this.cbwa04 = cbwa04;
    }

    public Integer getCbwa05() {
        return cbwa05;
    }

    public void setCbwa05(Integer cbwa05) {
        this.cbwa05 = cbwa05;
    }

    public Integer getCbwa06() {
        return cbwa06;
    }

    public void setCbwa06(Integer cbwa06) {
        this.cbwa06 = cbwa06;
    }

    public Integer getCbwa07() {
        return cbwa07;
    }

    public void setCbwa07(Integer cbwa07) {
        this.cbwa07 = cbwa07;
    }

    public String getCbwa08() {
        return cbwa08;
    }

    public void setCbwa08(String cbwa08) {
        this.cbwa08 = cbwa08 == null ? null : cbwa08.trim();
    }

    public String getCbwa09() {
        return cbwa09;
    }

    public void setCbwa09(String cbwa09) {
        this.cbwa09 = cbwa09 == null ? null : cbwa09.trim();
    }

    public String getCbwa10() {
        return cbwa10;
    }

    public void setCbwa10(String cbwa10) {
        this.cbwa10 = cbwa10 == null ? null : cbwa10.trim();
    }

    public String getCbwa11() {
        return cbwa11;
    }

    public void setCbwa11(String cbwa11) {
        this.cbwa11 = cbwa11 == null ? null : cbwa11.trim();
    }

    public String getCbwa12() {
        return cbwa12;
    }

    public void setCbwa12(String cbwa12) {
        this.cbwa12 = cbwa12 == null ? null : cbwa12.trim();
    }

    public Integer getCbwa13() {
        return cbwa13;
    }

    public void setCbwa13(Integer cbwa13) {
        this.cbwa13 = cbwa13;
    }

    public Integer getCbwa14() {
        return cbwa14;
    }

    public void setCbwa14(Integer cbwa14) {
        this.cbwa14 = cbwa14;
    }

    public Integer getCbwa15() {
        return cbwa15;
    }

    public void setCbwa15(Integer cbwa15) {
        this.cbwa15 = cbwa15;
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
        Cbwa other = (Cbwa) that;
        return (this.getCbwa01() == null ? other.getCbwa01() == null : this.getCbwa01().equals(other.getCbwa01()))
            && (this.getCbwa02() == null ? other.getCbwa02() == null : this.getCbwa02().equals(other.getCbwa02()))
            && (this.getCbwa03() == null ? other.getCbwa03() == null : this.getCbwa03().equals(other.getCbwa03()))
            && (this.getCbwa04() == null ? other.getCbwa04() == null : this.getCbwa04().equals(other.getCbwa04()))
            && (this.getCbwa05() == null ? other.getCbwa05() == null : this.getCbwa05().equals(other.getCbwa05()))
            && (this.getCbwa06() == null ? other.getCbwa06() == null : this.getCbwa06().equals(other.getCbwa06()))
            && (this.getCbwa07() == null ? other.getCbwa07() == null : this.getCbwa07().equals(other.getCbwa07()))
            && (this.getCbwa08() == null ? other.getCbwa08() == null : this.getCbwa08().equals(other.getCbwa08()))
            && (this.getCbwa09() == null ? other.getCbwa09() == null : this.getCbwa09().equals(other.getCbwa09()))
            && (this.getCbwa10() == null ? other.getCbwa10() == null : this.getCbwa10().equals(other.getCbwa10()))
            && (this.getCbwa11() == null ? other.getCbwa11() == null : this.getCbwa11().equals(other.getCbwa11()))
            && (this.getCbwa12() == null ? other.getCbwa12() == null : this.getCbwa12().equals(other.getCbwa12()))
            && (this.getCbwa13() == null ? other.getCbwa13() == null : this.getCbwa13().equals(other.getCbwa13()))
            && (this.getCbwa14() == null ? other.getCbwa14() == null : this.getCbwa14().equals(other.getCbwa14()))
            && (this.getCbwa15() == null ? other.getCbwa15() == null : this.getCbwa15().equals(other.getCbwa15()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbwa01() == null) ? 0 : getCbwa01().hashCode());
        result = prime * result + ((getCbwa02() == null) ? 0 : getCbwa02().hashCode());
        result = prime * result + ((getCbwa03() == null) ? 0 : getCbwa03().hashCode());
        result = prime * result + ((getCbwa04() == null) ? 0 : getCbwa04().hashCode());
        result = prime * result + ((getCbwa05() == null) ? 0 : getCbwa05().hashCode());
        result = prime * result + ((getCbwa06() == null) ? 0 : getCbwa06().hashCode());
        result = prime * result + ((getCbwa07() == null) ? 0 : getCbwa07().hashCode());
        result = prime * result + ((getCbwa08() == null) ? 0 : getCbwa08().hashCode());
        result = prime * result + ((getCbwa09() == null) ? 0 : getCbwa09().hashCode());
        result = prime * result + ((getCbwa10() == null) ? 0 : getCbwa10().hashCode());
        result = prime * result + ((getCbwa11() == null) ? 0 : getCbwa11().hashCode());
        result = prime * result + ((getCbwa12() == null) ? 0 : getCbwa12().hashCode());
        result = prime * result + ((getCbwa13() == null) ? 0 : getCbwa13().hashCode());
        result = prime * result + ((getCbwa14() == null) ? 0 : getCbwa14().hashCode());
        result = prime * result + ((getCbwa15() == null) ? 0 : getCbwa15().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbwa01=").append(cbwa01);
        sb.append(", cbwa02=").append(cbwa02);
        sb.append(", cbwa03=").append(cbwa03);
        sb.append(", cbwa04=").append(cbwa04);
        sb.append(", cbwa05=").append(cbwa05);
        sb.append(", cbwa06=").append(cbwa06);
        sb.append(", cbwa07=").append(cbwa07);
        sb.append(", cbwa08=").append(cbwa08);
        sb.append(", cbwa09=").append(cbwa09);
        sb.append(", cbwa10=").append(cbwa10);
        sb.append(", cbwa11=").append(cbwa11);
        sb.append(", cbwa12=").append(cbwa12);
        sb.append(", cbwa13=").append(cbwa13);
        sb.append(", cbwa14=").append(cbwa14);
        sb.append(", cbwa15=").append(cbwa15);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
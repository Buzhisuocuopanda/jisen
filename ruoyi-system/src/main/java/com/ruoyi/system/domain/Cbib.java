package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbib implements Serializable {
    private Integer cbib01;

    private Integer cbib02;

    private String cbib03;

    private Date cbib04;

    private String cbib05;

    private String cbib06;

    private Integer cbib07;

    private Integer cbib08;

    private Double cbib09;

    private Double cbib10;

    private Double cbib11;

    private Double cbib12;

    private Double cbib13;

    private Double cbib14;

    private Double cbib15;

    private Double cbib16;

    private String cbib17;

    private Integer cbib18;

    private Integer cbib19;

    private static final long serialVersionUID = 1L;

    public Integer getCbib01() {
        return cbib01;
    }

    public void setCbib01(Integer cbib01) {
        this.cbib01 = cbib01;
    }

    public Integer getCbib02() {
        return cbib02;
    }

    public void setCbib02(Integer cbib02) {
        this.cbib02 = cbib02;
    }

    public String getCbib03() {
        return cbib03;
    }

    public void setCbib03(String cbib03) {
        this.cbib03 = cbib03 == null ? null : cbib03.trim();
    }

    public Date getCbib04() {
        return cbib04;
    }

    public void setCbib04(Date cbib04) {
        this.cbib04 = cbib04;
    }

    public String getCbib05() {
        return cbib05;
    }

    public void setCbib05(String cbib05) {
        this.cbib05 = cbib05 == null ? null : cbib05.trim();
    }

    public String getCbib06() {
        return cbib06;
    }

    public void setCbib06(String cbib06) {
        this.cbib06 = cbib06 == null ? null : cbib06.trim();
    }

    public Integer getCbib07() {
        return cbib07;
    }

    public void setCbib07(Integer cbib07) {
        this.cbib07 = cbib07;
    }

    public Integer getCbib08() {
        return cbib08;
    }

    public void setCbib08(Integer cbib08) {
        this.cbib08 = cbib08;
    }

    public Double getCbib09() {
        return cbib09;
    }

    public void setCbib09(Double cbib09) {
        this.cbib09 = cbib09;
    }

    public Double getCbib10() {
        return cbib10;
    }

    public void setCbib10(Double cbib10) {
        this.cbib10 = cbib10;
    }

    public Double getCbib11() {
        return cbib11;
    }

    public void setCbib11(Double cbib11) {
        this.cbib11 = cbib11;
    }

    public Double getCbib12() {
        return cbib12;
    }

    public void setCbib12(Double cbib12) {
        this.cbib12 = cbib12;
    }

    public Double getCbib13() {
        return cbib13;
    }

    public void setCbib13(Double cbib13) {
        this.cbib13 = cbib13;
    }

    public Double getCbib14() {
        return cbib14;
    }

    public void setCbib14(Double cbib14) {
        this.cbib14 = cbib14;
    }

    public Double getCbib15() {
        return cbib15;
    }

    public void setCbib15(Double cbib15) {
        this.cbib15 = cbib15;
    }

    public Double getCbib16() {
        return cbib16;
    }

    public void setCbib16(Double cbib16) {
        this.cbib16 = cbib16;
    }

    public String getCbib17() {
        return cbib17;
    }

    public void setCbib17(String cbib17) {
        this.cbib17 = cbib17 == null ? null : cbib17.trim();
    }

    public Integer getCbib18() {
        return cbib18;
    }

    public void setCbib18(Integer cbib18) {
        this.cbib18 = cbib18;
    }

    public Integer getCbib19() {
        return cbib19;
    }

    public void setCbib19(Integer cbib19) {
        this.cbib19 = cbib19;
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
        Cbib other = (Cbib) that;
        return (this.getCbib01() == null ? other.getCbib01() == null : this.getCbib01().equals(other.getCbib01()))
            && (this.getCbib02() == null ? other.getCbib02() == null : this.getCbib02().equals(other.getCbib02()))
            && (this.getCbib03() == null ? other.getCbib03() == null : this.getCbib03().equals(other.getCbib03()))
            && (this.getCbib04() == null ? other.getCbib04() == null : this.getCbib04().equals(other.getCbib04()))
            && (this.getCbib05() == null ? other.getCbib05() == null : this.getCbib05().equals(other.getCbib05()))
            && (this.getCbib06() == null ? other.getCbib06() == null : this.getCbib06().equals(other.getCbib06()))
            && (this.getCbib07() == null ? other.getCbib07() == null : this.getCbib07().equals(other.getCbib07()))
            && (this.getCbib08() == null ? other.getCbib08() == null : this.getCbib08().equals(other.getCbib08()))
            && (this.getCbib09() == null ? other.getCbib09() == null : this.getCbib09().equals(other.getCbib09()))
            && (this.getCbib10() == null ? other.getCbib10() == null : this.getCbib10().equals(other.getCbib10()))
            && (this.getCbib11() == null ? other.getCbib11() == null : this.getCbib11().equals(other.getCbib11()))
            && (this.getCbib12() == null ? other.getCbib12() == null : this.getCbib12().equals(other.getCbib12()))
            && (this.getCbib13() == null ? other.getCbib13() == null : this.getCbib13().equals(other.getCbib13()))
            && (this.getCbib14() == null ? other.getCbib14() == null : this.getCbib14().equals(other.getCbib14()))
            && (this.getCbib15() == null ? other.getCbib15() == null : this.getCbib15().equals(other.getCbib15()))
            && (this.getCbib16() == null ? other.getCbib16() == null : this.getCbib16().equals(other.getCbib16()))
            && (this.getCbib17() == null ? other.getCbib17() == null : this.getCbib17().equals(other.getCbib17()))
            && (this.getCbib18() == null ? other.getCbib18() == null : this.getCbib18().equals(other.getCbib18()))
            && (this.getCbib19() == null ? other.getCbib19() == null : this.getCbib19().equals(other.getCbib19()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbib01() == null) ? 0 : getCbib01().hashCode());
        result = prime * result + ((getCbib02() == null) ? 0 : getCbib02().hashCode());
        result = prime * result + ((getCbib03() == null) ? 0 : getCbib03().hashCode());
        result = prime * result + ((getCbib04() == null) ? 0 : getCbib04().hashCode());
        result = prime * result + ((getCbib05() == null) ? 0 : getCbib05().hashCode());
        result = prime * result + ((getCbib06() == null) ? 0 : getCbib06().hashCode());
        result = prime * result + ((getCbib07() == null) ? 0 : getCbib07().hashCode());
        result = prime * result + ((getCbib08() == null) ? 0 : getCbib08().hashCode());
        result = prime * result + ((getCbib09() == null) ? 0 : getCbib09().hashCode());
        result = prime * result + ((getCbib10() == null) ? 0 : getCbib10().hashCode());
        result = prime * result + ((getCbib11() == null) ? 0 : getCbib11().hashCode());
        result = prime * result + ((getCbib12() == null) ? 0 : getCbib12().hashCode());
        result = prime * result + ((getCbib13() == null) ? 0 : getCbib13().hashCode());
        result = prime * result + ((getCbib14() == null) ? 0 : getCbib14().hashCode());
        result = prime * result + ((getCbib15() == null) ? 0 : getCbib15().hashCode());
        result = prime * result + ((getCbib16() == null) ? 0 : getCbib16().hashCode());
        result = prime * result + ((getCbib17() == null) ? 0 : getCbib17().hashCode());
        result = prime * result + ((getCbib18() == null) ? 0 : getCbib18().hashCode());
        result = prime * result + ((getCbib19() == null) ? 0 : getCbib19().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbib01=").append(cbib01);
        sb.append(", cbib02=").append(cbib02);
        sb.append(", cbib03=").append(cbib03);
        sb.append(", cbib04=").append(cbib04);
        sb.append(", cbib05=").append(cbib05);
        sb.append(", cbib06=").append(cbib06);
        sb.append(", cbib07=").append(cbib07);
        sb.append(", cbib08=").append(cbib08);
        sb.append(", cbib09=").append(cbib09);
        sb.append(", cbib10=").append(cbib10);
        sb.append(", cbib11=").append(cbib11);
        sb.append(", cbib12=").append(cbib12);
        sb.append(", cbib13=").append(cbib13);
        sb.append(", cbib14=").append(cbib14);
        sb.append(", cbib15=").append(cbib15);
        sb.append(", cbib16=").append(cbib16);
        sb.append(", cbib17=").append(cbib17);
        sb.append(", cbib18=").append(cbib18);
        sb.append(", cbib19=").append(cbib19);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
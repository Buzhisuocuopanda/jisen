package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpb implements Serializable {
    private Integer cbpb01;

    private Date cbpb02;

    private Date cbpb03;

    private Integer cbpb04;

    private Integer cbpb05;

    private Byte cbpb06;

    private String cbpb07;

    private String cbpb08;

    private String cbpb09;

    private Integer cbpb10;

    private Integer cbpb11;

    private String cbpb12;

    private Double cbpb13;

    private Integer cbpb14;

    private String cbpb15;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getCbpb01() {
        return cbpb01;
    }

    public void setCbpb01(Integer cbpb01) {
        this.cbpb01 = cbpb01;
    }

    public Date getCbpb02() {
        return cbpb02;
    }

    public void setCbpb02(Date cbpb02) {
        this.cbpb02 = cbpb02;
    }

    public Date getCbpb03() {
        return cbpb03;
    }

    public void setCbpb03(Date cbpb03) {
        this.cbpb03 = cbpb03;
    }

    public Integer getCbpb04() {
        return cbpb04;
    }

    public void setCbpb04(Integer cbpb04) {
        this.cbpb04 = cbpb04;
    }

    public Integer getCbpb05() {
        return cbpb05;
    }

    public void setCbpb05(Integer cbpb05) {
        this.cbpb05 = cbpb05;
    }

    public Byte getCbpb06() {
        return cbpb06;
    }

    public void setCbpb06(Byte cbpb06) {
        this.cbpb06 = cbpb06;
    }

    public String getCbpb07() {
        return cbpb07;
    }

    public void setCbpb07(String cbpb07) {
        this.cbpb07 = cbpb07 == null ? null : cbpb07.trim();
    }

    public String getCbpb08() {
        return cbpb08;
    }

    public void setCbpb08(String cbpb08) {
        this.cbpb08 = cbpb08 == null ? null : cbpb08.trim();
    }

    public String getCbpb09() {
        return cbpb09;
    }

    public void setCbpb09(String cbpb09) {
        this.cbpb09 = cbpb09 == null ? null : cbpb09.trim();
    }

    public Integer getCbpb10() {
        return cbpb10;
    }

    public void setCbpb10(Integer cbpb10) {
        this.cbpb10 = cbpb10;
    }

    public Integer getCbpb11() {
        return cbpb11;
    }

    public void setCbpb11(Integer cbpb11) {
        this.cbpb11 = cbpb11;
    }

    public String getCbpb12() {
        return cbpb12;
    }

    public void setCbpb12(String cbpb12) {
        this.cbpb12 = cbpb12 == null ? null : cbpb12.trim();
    }

    public Double getCbpb13() {
        return cbpb13;
    }

    public void setCbpb13(Double cbpb13) {
        this.cbpb13 = cbpb13;
    }

    public Integer getCbpb14() {
        return cbpb14;
    }

    public void setCbpb14(Integer cbpb14) {
        this.cbpb14 = cbpb14;
    }

    public String getCbpb15() {
        return cbpb15;
    }

    public void setCbpb15(String cbpb15) {
        this.cbpb15 = cbpb15 == null ? null : cbpb15.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        Cbpb other = (Cbpb) that;
        return (this.getCbpb01() == null ? other.getCbpb01() == null : this.getCbpb01().equals(other.getCbpb01()))
            && (this.getCbpb02() == null ? other.getCbpb02() == null : this.getCbpb02().equals(other.getCbpb02()))
            && (this.getCbpb03() == null ? other.getCbpb03() == null : this.getCbpb03().equals(other.getCbpb03()))
            && (this.getCbpb04() == null ? other.getCbpb04() == null : this.getCbpb04().equals(other.getCbpb04()))
            && (this.getCbpb05() == null ? other.getCbpb05() == null : this.getCbpb05().equals(other.getCbpb05()))
            && (this.getCbpb06() == null ? other.getCbpb06() == null : this.getCbpb06().equals(other.getCbpb06()))
            && (this.getCbpb07() == null ? other.getCbpb07() == null : this.getCbpb07().equals(other.getCbpb07()))
            && (this.getCbpb08() == null ? other.getCbpb08() == null : this.getCbpb08().equals(other.getCbpb08()))
            && (this.getCbpb09() == null ? other.getCbpb09() == null : this.getCbpb09().equals(other.getCbpb09()))
            && (this.getCbpb10() == null ? other.getCbpb10() == null : this.getCbpb10().equals(other.getCbpb10()))
            && (this.getCbpb11() == null ? other.getCbpb11() == null : this.getCbpb11().equals(other.getCbpb11()))
            && (this.getCbpb12() == null ? other.getCbpb12() == null : this.getCbpb12().equals(other.getCbpb12()))
            && (this.getCbpb13() == null ? other.getCbpb13() == null : this.getCbpb13().equals(other.getCbpb13()))
            && (this.getCbpb14() == null ? other.getCbpb14() == null : this.getCbpb14().equals(other.getCbpb14()))
            && (this.getCbpb15() == null ? other.getCbpb15() == null : this.getCbpb15().equals(other.getCbpb15()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpb01() == null) ? 0 : getCbpb01().hashCode());
        result = prime * result + ((getCbpb02() == null) ? 0 : getCbpb02().hashCode());
        result = prime * result + ((getCbpb03() == null) ? 0 : getCbpb03().hashCode());
        result = prime * result + ((getCbpb04() == null) ? 0 : getCbpb04().hashCode());
        result = prime * result + ((getCbpb05() == null) ? 0 : getCbpb05().hashCode());
        result = prime * result + ((getCbpb06() == null) ? 0 : getCbpb06().hashCode());
        result = prime * result + ((getCbpb07() == null) ? 0 : getCbpb07().hashCode());
        result = prime * result + ((getCbpb08() == null) ? 0 : getCbpb08().hashCode());
        result = prime * result + ((getCbpb09() == null) ? 0 : getCbpb09().hashCode());
        result = prime * result + ((getCbpb10() == null) ? 0 : getCbpb10().hashCode());
        result = prime * result + ((getCbpb11() == null) ? 0 : getCbpb11().hashCode());
        result = prime * result + ((getCbpb12() == null) ? 0 : getCbpb12().hashCode());
        result = prime * result + ((getCbpb13() == null) ? 0 : getCbpb13().hashCode());
        result = prime * result + ((getCbpb14() == null) ? 0 : getCbpb14().hashCode());
        result = prime * result + ((getCbpb15() == null) ? 0 : getCbpb15().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpb01=").append(cbpb01);
        sb.append(", cbpb02=").append(cbpb02);
        sb.append(", cbpb03=").append(cbpb03);
        sb.append(", cbpb04=").append(cbpb04);
        sb.append(", cbpb05=").append(cbpb05);
        sb.append(", cbpb06=").append(cbpb06);
        sb.append(", cbpb07=").append(cbpb07);
        sb.append(", cbpb08=").append(cbpb08);
        sb.append(", cbpb09=").append(cbpb09);
        sb.append(", cbpb10=").append(cbpb10);
        sb.append(", cbpb11=").append(cbpb11);
        sb.append(", cbpb12=").append(cbpb12);
        sb.append(", cbpb13=").append(cbpb13);
        sb.append(", cbpb14=").append(cbpb14);
        sb.append(", cbpb15=").append(cbpb15);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
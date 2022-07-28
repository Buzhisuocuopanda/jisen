package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbsa implements Serializable {
    private Integer cbsa01;

    private Date cbsa02;

    private Integer cbsa03;

    private Date cbsa04;

    private Integer cbsa05;

    private Integer cbsa06;

    private String cbsa07;

    private String cbsa08;

    private String cbsa09;

    private String cbsa10;

    private String cbsa11;

    private String cbsa12;

    private String cbsa13;

    private String cbsa14;

    private String cbsa15;

    private String cbsa16;

    private String cbsa17;

    private Integer cbsa18;

    private static final long serialVersionUID = 1L;

    public Integer getCbsa01() {
        return cbsa01;
    }

    public void setCbsa01(Integer cbsa01) {
        this.cbsa01 = cbsa01;
    }

    public Date getCbsa02() {
        return cbsa02;
    }

    public void setCbsa02(Date cbsa02) {
        this.cbsa02 = cbsa02;
    }

    public Integer getCbsa03() {
        return cbsa03;
    }

    public void setCbsa03(Integer cbsa03) {
        this.cbsa03 = cbsa03;
    }

    public Date getCbsa04() {
        return cbsa04;
    }

    public void setCbsa04(Date cbsa04) {
        this.cbsa04 = cbsa04;
    }

    public Integer getCbsa05() {
        return cbsa05;
    }

    public void setCbsa05(Integer cbsa05) {
        this.cbsa05 = cbsa05;
    }

    public Integer getCbsa06() {
        return cbsa06;
    }

    public void setCbsa06(Integer cbsa06) {
        this.cbsa06 = cbsa06;
    }

    public String getCbsa07() {
        return cbsa07;
    }

    public void setCbsa07(String cbsa07) {
        this.cbsa07 = cbsa07 == null ? null : cbsa07.trim();
    }

    public String getCbsa08() {
        return cbsa08;
    }

    public void setCbsa08(String cbsa08) {
        this.cbsa08 = cbsa08 == null ? null : cbsa08.trim();
    }

    public String getCbsa09() {
        return cbsa09;
    }

    public void setCbsa09(String cbsa09) {
        this.cbsa09 = cbsa09 == null ? null : cbsa09.trim();
    }

    public String getCbsa10() {
        return cbsa10;
    }

    public void setCbsa10(String cbsa10) {
        this.cbsa10 = cbsa10 == null ? null : cbsa10.trim();
    }

    public String getCbsa11() {
        return cbsa11;
    }

    public void setCbsa11(String cbsa11) {
        this.cbsa11 = cbsa11 == null ? null : cbsa11.trim();
    }

    public String getCbsa12() {
        return cbsa12;
    }

    public void setCbsa12(String cbsa12) {
        this.cbsa12 = cbsa12 == null ? null : cbsa12.trim();
    }

    public String getCbsa13() {
        return cbsa13;
    }

    public void setCbsa13(String cbsa13) {
        this.cbsa13 = cbsa13 == null ? null : cbsa13.trim();
    }

    public String getCbsa14() {
        return cbsa14;
    }

    public void setCbsa14(String cbsa14) {
        this.cbsa14 = cbsa14 == null ? null : cbsa14.trim();
    }

    public String getCbsa15() {
        return cbsa15;
    }

    public void setCbsa15(String cbsa15) {
        this.cbsa15 = cbsa15 == null ? null : cbsa15.trim();
    }

    public String getCbsa16() {
        return cbsa16;
    }

    public void setCbsa16(String cbsa16) {
        this.cbsa16 = cbsa16 == null ? null : cbsa16.trim();
    }

    public String getCbsa17() {
        return cbsa17;
    }

    public void setCbsa17(String cbsa17) {
        this.cbsa17 = cbsa17 == null ? null : cbsa17.trim();
    }

    public Integer getCbsa18() {
        return cbsa18;
    }

    public void setCbsa18(Integer cbsa18) {
        this.cbsa18 = cbsa18;
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
        Cbsa other = (Cbsa) that;
        return (this.getCbsa01() == null ? other.getCbsa01() == null : this.getCbsa01().equals(other.getCbsa01()))
            && (this.getCbsa02() == null ? other.getCbsa02() == null : this.getCbsa02().equals(other.getCbsa02()))
            && (this.getCbsa03() == null ? other.getCbsa03() == null : this.getCbsa03().equals(other.getCbsa03()))
            && (this.getCbsa04() == null ? other.getCbsa04() == null : this.getCbsa04().equals(other.getCbsa04()))
            && (this.getCbsa05() == null ? other.getCbsa05() == null : this.getCbsa05().equals(other.getCbsa05()))
            && (this.getCbsa06() == null ? other.getCbsa06() == null : this.getCbsa06().equals(other.getCbsa06()))
            && (this.getCbsa07() == null ? other.getCbsa07() == null : this.getCbsa07().equals(other.getCbsa07()))
            && (this.getCbsa08() == null ? other.getCbsa08() == null : this.getCbsa08().equals(other.getCbsa08()))
            && (this.getCbsa09() == null ? other.getCbsa09() == null : this.getCbsa09().equals(other.getCbsa09()))
            && (this.getCbsa10() == null ? other.getCbsa10() == null : this.getCbsa10().equals(other.getCbsa10()))
            && (this.getCbsa11() == null ? other.getCbsa11() == null : this.getCbsa11().equals(other.getCbsa11()))
            && (this.getCbsa12() == null ? other.getCbsa12() == null : this.getCbsa12().equals(other.getCbsa12()))
            && (this.getCbsa13() == null ? other.getCbsa13() == null : this.getCbsa13().equals(other.getCbsa13()))
            && (this.getCbsa14() == null ? other.getCbsa14() == null : this.getCbsa14().equals(other.getCbsa14()))
            && (this.getCbsa15() == null ? other.getCbsa15() == null : this.getCbsa15().equals(other.getCbsa15()))
            && (this.getCbsa16() == null ? other.getCbsa16() == null : this.getCbsa16().equals(other.getCbsa16()))
            && (this.getCbsa17() == null ? other.getCbsa17() == null : this.getCbsa17().equals(other.getCbsa17()))
            && (this.getCbsa18() == null ? other.getCbsa18() == null : this.getCbsa18().equals(other.getCbsa18()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbsa01() == null) ? 0 : getCbsa01().hashCode());
        result = prime * result + ((getCbsa02() == null) ? 0 : getCbsa02().hashCode());
        result = prime * result + ((getCbsa03() == null) ? 0 : getCbsa03().hashCode());
        result = prime * result + ((getCbsa04() == null) ? 0 : getCbsa04().hashCode());
        result = prime * result + ((getCbsa05() == null) ? 0 : getCbsa05().hashCode());
        result = prime * result + ((getCbsa06() == null) ? 0 : getCbsa06().hashCode());
        result = prime * result + ((getCbsa07() == null) ? 0 : getCbsa07().hashCode());
        result = prime * result + ((getCbsa08() == null) ? 0 : getCbsa08().hashCode());
        result = prime * result + ((getCbsa09() == null) ? 0 : getCbsa09().hashCode());
        result = prime * result + ((getCbsa10() == null) ? 0 : getCbsa10().hashCode());
        result = prime * result + ((getCbsa11() == null) ? 0 : getCbsa11().hashCode());
        result = prime * result + ((getCbsa12() == null) ? 0 : getCbsa12().hashCode());
        result = prime * result + ((getCbsa13() == null) ? 0 : getCbsa13().hashCode());
        result = prime * result + ((getCbsa14() == null) ? 0 : getCbsa14().hashCode());
        result = prime * result + ((getCbsa15() == null) ? 0 : getCbsa15().hashCode());
        result = prime * result + ((getCbsa16() == null) ? 0 : getCbsa16().hashCode());
        result = prime * result + ((getCbsa17() == null) ? 0 : getCbsa17().hashCode());
        result = prime * result + ((getCbsa18() == null) ? 0 : getCbsa18().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbsa01=").append(cbsa01);
        sb.append(", cbsa02=").append(cbsa02);
        sb.append(", cbsa03=").append(cbsa03);
        sb.append(", cbsa04=").append(cbsa04);
        sb.append(", cbsa05=").append(cbsa05);
        sb.append(", cbsa06=").append(cbsa06);
        sb.append(", cbsa07=").append(cbsa07);
        sb.append(", cbsa08=").append(cbsa08);
        sb.append(", cbsa09=").append(cbsa09);
        sb.append(", cbsa10=").append(cbsa10);
        sb.append(", cbsa11=").append(cbsa11);
        sb.append(", cbsa12=").append(cbsa12);
        sb.append(", cbsa13=").append(cbsa13);
        sb.append(", cbsa14=").append(cbsa14);
        sb.append(", cbsa15=").append(cbsa15);
        sb.append(", cbsa16=").append(cbsa16);
        sb.append(", cbsa17=").append(cbsa17);
        sb.append(", cbsa18=").append(cbsa18);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
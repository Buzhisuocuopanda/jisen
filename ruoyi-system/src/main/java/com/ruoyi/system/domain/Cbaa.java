package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbaa implements Serializable {
    private Integer cbaa01;

    private Date cbaa02;

    private Integer cbaa03;

    private Date cbaa04;

    private Integer cbaa05;

    private Integer cbaa06;

    private String cbaa07;

    private Date cbaa08;

    private Integer cbaa09;

    private Integer cbaa10;

    private Integer cbaa11;

    private Integer cbaa12;

    private Date cbaa13;

    private Integer cbaa14;

    private Date cbaa15;

    private Integer cbaa16;

    private String cbaa17;

    private Integer cbaa18;

    private Integer cbaa19;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbaa01() {
        return cbaa01;
    }

    public void setCbaa01(Integer cbaa01) {
        this.cbaa01 = cbaa01;
    }

    public Date getCbaa02() {
        return cbaa02;
    }

    public void setCbaa02(Date cbaa02) {
        this.cbaa02 = cbaa02;
    }

    public Integer getCbaa03() {
        return cbaa03;
    }

    public void setCbaa03(Integer cbaa03) {
        this.cbaa03 = cbaa03;
    }

    public Date getCbaa04() {
        return cbaa04;
    }

    public void setCbaa04(Date cbaa04) {
        this.cbaa04 = cbaa04;
    }

    public Integer getCbaa05() {
        return cbaa05;
    }

    public void setCbaa05(Integer cbaa05) {
        this.cbaa05 = cbaa05;
    }

    public Integer getCbaa06() {
        return cbaa06;
    }

    public void setCbaa06(Integer cbaa06) {
        this.cbaa06 = cbaa06;
    }

    public String getCbaa07() {
        return cbaa07;
    }

    public void setCbaa07(String cbaa07) {
        this.cbaa07 = cbaa07 == null ? null : cbaa07.trim();
    }

    public Date getCbaa08() {
        return cbaa08;
    }

    public void setCbaa08(Date cbaa08) {
        this.cbaa08 = cbaa08;
    }

    public Integer getCbaa09() {
        return cbaa09;
    }

    public void setCbaa09(Integer cbaa09) {
        this.cbaa09 = cbaa09;
    }

    public Integer getCbaa10() {
        return cbaa10;
    }

    public void setCbaa10(Integer cbaa10) {
        this.cbaa10 = cbaa10;
    }

    public Integer getCbaa11() {
        return cbaa11;
    }

    public void setCbaa11(Integer cbaa11) {
        this.cbaa11 = cbaa11;
    }

    public Integer getCbaa12() {
        return cbaa12;
    }

    public void setCbaa12(Integer cbaa12) {
        this.cbaa12 = cbaa12;
    }

    public Date getCbaa13() {
        return cbaa13;
    }

    public void setCbaa13(Date cbaa13) {
        this.cbaa13 = cbaa13;
    }

    public Integer getCbaa14() {
        return cbaa14;
    }

    public void setCbaa14(Integer cbaa14) {
        this.cbaa14 = cbaa14;
    }

    public Date getCbaa15() {
        return cbaa15;
    }

    public void setCbaa15(Date cbaa15) {
        this.cbaa15 = cbaa15;
    }

    public Integer getCbaa16() {
        return cbaa16;
    }

    public void setCbaa16(Integer cbaa16) {
        this.cbaa16 = cbaa16;
    }

    public String getCbaa17() {
        return cbaa17;
    }

    public void setCbaa17(String cbaa17) {
        this.cbaa17 = cbaa17 == null ? null : cbaa17.trim();
    }

    public Integer getCbaa18() {
        return cbaa18;
    }

    public void setCbaa18(Integer cbaa18) {
        this.cbaa18 = cbaa18;
    }

    public Integer getCbaa19() {
        return cbaa19;
    }

    public void setCbaa19(Integer cbaa19) {
        this.cbaa19 = cbaa19;
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
        Cbaa other = (Cbaa) that;
        return (this.getCbaa01() == null ? other.getCbaa01() == null : this.getCbaa01().equals(other.getCbaa01()))
            && (this.getCbaa02() == null ? other.getCbaa02() == null : this.getCbaa02().equals(other.getCbaa02()))
            && (this.getCbaa03() == null ? other.getCbaa03() == null : this.getCbaa03().equals(other.getCbaa03()))
            && (this.getCbaa04() == null ? other.getCbaa04() == null : this.getCbaa04().equals(other.getCbaa04()))
            && (this.getCbaa05() == null ? other.getCbaa05() == null : this.getCbaa05().equals(other.getCbaa05()))
            && (this.getCbaa06() == null ? other.getCbaa06() == null : this.getCbaa06().equals(other.getCbaa06()))
            && (this.getCbaa07() == null ? other.getCbaa07() == null : this.getCbaa07().equals(other.getCbaa07()))
            && (this.getCbaa08() == null ? other.getCbaa08() == null : this.getCbaa08().equals(other.getCbaa08()))
            && (this.getCbaa09() == null ? other.getCbaa09() == null : this.getCbaa09().equals(other.getCbaa09()))
            && (this.getCbaa10() == null ? other.getCbaa10() == null : this.getCbaa10().equals(other.getCbaa10()))
            && (this.getCbaa11() == null ? other.getCbaa11() == null : this.getCbaa11().equals(other.getCbaa11()))
            && (this.getCbaa12() == null ? other.getCbaa12() == null : this.getCbaa12().equals(other.getCbaa12()))
            && (this.getCbaa13() == null ? other.getCbaa13() == null : this.getCbaa13().equals(other.getCbaa13()))
            && (this.getCbaa14() == null ? other.getCbaa14() == null : this.getCbaa14().equals(other.getCbaa14()))
            && (this.getCbaa15() == null ? other.getCbaa15() == null : this.getCbaa15().equals(other.getCbaa15()))
            && (this.getCbaa16() == null ? other.getCbaa16() == null : this.getCbaa16().equals(other.getCbaa16()))
            && (this.getCbaa17() == null ? other.getCbaa17() == null : this.getCbaa17().equals(other.getCbaa17()))
            && (this.getCbaa18() == null ? other.getCbaa18() == null : this.getCbaa18().equals(other.getCbaa18()))
            && (this.getCbaa19() == null ? other.getCbaa19() == null : this.getCbaa19().equals(other.getCbaa19()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbaa01() == null) ? 0 : getCbaa01().hashCode());
        result = prime * result + ((getCbaa02() == null) ? 0 : getCbaa02().hashCode());
        result = prime * result + ((getCbaa03() == null) ? 0 : getCbaa03().hashCode());
        result = prime * result + ((getCbaa04() == null) ? 0 : getCbaa04().hashCode());
        result = prime * result + ((getCbaa05() == null) ? 0 : getCbaa05().hashCode());
        result = prime * result + ((getCbaa06() == null) ? 0 : getCbaa06().hashCode());
        result = prime * result + ((getCbaa07() == null) ? 0 : getCbaa07().hashCode());
        result = prime * result + ((getCbaa08() == null) ? 0 : getCbaa08().hashCode());
        result = prime * result + ((getCbaa09() == null) ? 0 : getCbaa09().hashCode());
        result = prime * result + ((getCbaa10() == null) ? 0 : getCbaa10().hashCode());
        result = prime * result + ((getCbaa11() == null) ? 0 : getCbaa11().hashCode());
        result = prime * result + ((getCbaa12() == null) ? 0 : getCbaa12().hashCode());
        result = prime * result + ((getCbaa13() == null) ? 0 : getCbaa13().hashCode());
        result = prime * result + ((getCbaa14() == null) ? 0 : getCbaa14().hashCode());
        result = prime * result + ((getCbaa15() == null) ? 0 : getCbaa15().hashCode());
        result = prime * result + ((getCbaa16() == null) ? 0 : getCbaa16().hashCode());
        result = prime * result + ((getCbaa17() == null) ? 0 : getCbaa17().hashCode());
        result = prime * result + ((getCbaa18() == null) ? 0 : getCbaa18().hashCode());
        result = prime * result + ((getCbaa19() == null) ? 0 : getCbaa19().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbaa01=").append(cbaa01);
        sb.append(", cbaa02=").append(cbaa02);
        sb.append(", cbaa03=").append(cbaa03);
        sb.append(", cbaa04=").append(cbaa04);
        sb.append(", cbaa05=").append(cbaa05);
        sb.append(", cbaa06=").append(cbaa06);
        sb.append(", cbaa07=").append(cbaa07);
        sb.append(", cbaa08=").append(cbaa08);
        sb.append(", cbaa09=").append(cbaa09);
        sb.append(", cbaa10=").append(cbaa10);
        sb.append(", cbaa11=").append(cbaa11);
        sb.append(", cbaa12=").append(cbaa12);
        sb.append(", cbaa13=").append(cbaa13);
        sb.append(", cbaa14=").append(cbaa14);
        sb.append(", cbaa15=").append(cbaa15);
        sb.append(", cbaa16=").append(cbaa16);
        sb.append(", cbaa17=").append(cbaa17);
        sb.append(", cbaa18=").append(cbaa18);
        sb.append(", cbaa19=").append(cbaa19);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
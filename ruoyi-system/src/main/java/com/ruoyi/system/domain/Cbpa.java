package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbpa implements Serializable {
    private Integer cbpa01;

    private Date cbpa02;

    private Date cbpa03;

    private Integer cbpa04;

    private Integer cbpa05;

    private Integer cbpa06;

    private String cbpa07;

    private String cbpa08;

    private Integer cbpa09;

    private String cbpa11;

    private String cbpa12;

    private static final long serialVersionUID = 1L;

    public Integer getCbpa01() {
        return cbpa01;
    }

    public void setCbpa01(Integer cbpa01) {
        this.cbpa01 = cbpa01;
    }

    public Date getCbpa02() {
        return cbpa02;
    }

    public void setCbpa02(Date cbpa02) {
        this.cbpa02 = cbpa02;
    }

    public Date getCbpa03() {
        return cbpa03;
    }

    public void setCbpa03(Date cbpa03) {
        this.cbpa03 = cbpa03;
    }

    public Integer getCbpa04() {
        return cbpa04;
    }

    public void setCbpa04(Integer cbpa04) {
        this.cbpa04 = cbpa04;
    }

    public Integer getCbpa05() {
        return cbpa05;
    }

    public void setCbpa05(Integer cbpa05) {
        this.cbpa05 = cbpa05;
    }

    public Integer getCbpa06() {
        return cbpa06;
    }

    public void setCbpa06(Integer cbpa06) {
        this.cbpa06 = cbpa06;
    }

    public String getCbpa07() {
        return cbpa07;
    }

    public void setCbpa07(String cbpa07) {
        this.cbpa07 = cbpa07 == null ? null : cbpa07.trim();
    }

    public String getCbpa08() {
        return cbpa08;
    }

    public void setCbpa08(String cbpa08) {
        this.cbpa08 = cbpa08 == null ? null : cbpa08.trim();
    }

    public Integer getCbpa09() {
        return cbpa09;
    }

    public void setCbpa09(Integer cbpa09) {
        this.cbpa09 = cbpa09;
    }

    public String getCbpa11() {
        return cbpa11;
    }

    public void setCbpa11(String cbpa11) {
        this.cbpa11 = cbpa11 == null ? null : cbpa11.trim();
    }

    public String getCbpa12() {
        return cbpa12;
    }

    public void setCbpa12(String cbpa12) {
        this.cbpa12 = cbpa12 == null ? null : cbpa12.trim();
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
        Cbpa other = (Cbpa) that;
        return (this.getCbpa01() == null ? other.getCbpa01() == null : this.getCbpa01().equals(other.getCbpa01()))
            && (this.getCbpa02() == null ? other.getCbpa02() == null : this.getCbpa02().equals(other.getCbpa02()))
            && (this.getCbpa03() == null ? other.getCbpa03() == null : this.getCbpa03().equals(other.getCbpa03()))
            && (this.getCbpa04() == null ? other.getCbpa04() == null : this.getCbpa04().equals(other.getCbpa04()))
            && (this.getCbpa05() == null ? other.getCbpa05() == null : this.getCbpa05().equals(other.getCbpa05()))
            && (this.getCbpa06() == null ? other.getCbpa06() == null : this.getCbpa06().equals(other.getCbpa06()))
            && (this.getCbpa07() == null ? other.getCbpa07() == null : this.getCbpa07().equals(other.getCbpa07()))
            && (this.getCbpa08() == null ? other.getCbpa08() == null : this.getCbpa08().equals(other.getCbpa08()))
            && (this.getCbpa09() == null ? other.getCbpa09() == null : this.getCbpa09().equals(other.getCbpa09()))
            && (this.getCbpa11() == null ? other.getCbpa11() == null : this.getCbpa11().equals(other.getCbpa11()))
            && (this.getCbpa12() == null ? other.getCbpa12() == null : this.getCbpa12().equals(other.getCbpa12()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbpa01() == null) ? 0 : getCbpa01().hashCode());
        result = prime * result + ((getCbpa02() == null) ? 0 : getCbpa02().hashCode());
        result = prime * result + ((getCbpa03() == null) ? 0 : getCbpa03().hashCode());
        result = prime * result + ((getCbpa04() == null) ? 0 : getCbpa04().hashCode());
        result = prime * result + ((getCbpa05() == null) ? 0 : getCbpa05().hashCode());
        result = prime * result + ((getCbpa06() == null) ? 0 : getCbpa06().hashCode());
        result = prime * result + ((getCbpa07() == null) ? 0 : getCbpa07().hashCode());
        result = prime * result + ((getCbpa08() == null) ? 0 : getCbpa08().hashCode());
        result = prime * result + ((getCbpa09() == null) ? 0 : getCbpa09().hashCode());
        result = prime * result + ((getCbpa11() == null) ? 0 : getCbpa11().hashCode());
        result = prime * result + ((getCbpa12() == null) ? 0 : getCbpa12().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbpa01=").append(cbpa01);
        sb.append(", cbpa02=").append(cbpa02);
        sb.append(", cbpa03=").append(cbpa03);
        sb.append(", cbpa04=").append(cbpa04);
        sb.append(", cbpa05=").append(cbpa05);
        sb.append(", cbpa06=").append(cbpa06);
        sb.append(", cbpa07=").append(cbpa07);
        sb.append(", cbpa08=").append(cbpa08);
        sb.append(", cbpa09=").append(cbpa09);
        sb.append(", cbpa11=").append(cbpa11);
        sb.append(", cbpa12=").append(cbpa12);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
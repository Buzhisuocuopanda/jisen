package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Cbig implements Serializable {
    private Integer cbig01;

    private Integer cbig02;

    private Date cbig03;

    private Integer cbig04;

    private Date cbig05;

    private Integer cbig06;

    private Integer cbig07;

    private Integer cbig08;

    private Integer cbig09;

    private String cbig10;

    private Integer cbig11;

    private String cbig12;

    private Double cbig13;

    private Integer cbie01;

    private Integer cbig14;

    private Date cbig15;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCbig01() {
        return cbig01;
    }

    public void setCbig01(Integer cbig01) {
        this.cbig01 = cbig01;
    }

    public Integer getCbig02() {
        return cbig02;
    }

    public void setCbig02(Integer cbig02) {
        this.cbig02 = cbig02;
    }

    public Date getCbig03() {
        return cbig03;
    }

    public void setCbig03(Date cbig03) {
        this.cbig03 = cbig03;
    }

    public Integer getCbig04() {
        return cbig04;
    }

    public void setCbig04(Integer cbig04) {
        this.cbig04 = cbig04;
    }

    public Date getCbig05() {
        return cbig05;
    }

    public void setCbig05(Date cbig05) {
        this.cbig05 = cbig05;
    }

    public Integer getCbig06() {
        return cbig06;
    }

    public void setCbig06(Integer cbig06) {
        this.cbig06 = cbig06;
    }

    public Integer getCbig07() {
        return cbig07;
    }

    public void setCbig07(Integer cbig07) {
        this.cbig07 = cbig07;
    }

    public Integer getCbig08() {
        return cbig08;
    }

    public void setCbig08(Integer cbig08) {
        this.cbig08 = cbig08;
    }

    public Integer getCbig09() {
        return cbig09;
    }

    public void setCbig09(Integer cbig09) {
        this.cbig09 = cbig09;
    }

    public String getCbig10() {
        return cbig10;
    }

    public void setCbig10(String cbig10) {
        this.cbig10 = cbig10 == null ? null : cbig10.trim();
    }

    public Integer getCbig11() {
        return cbig11;
    }

    public void setCbig11(Integer cbig11) {
        this.cbig11 = cbig11;
    }

    public String getCbig12() {
        return cbig12;
    }

    public void setCbig12(String cbig12) {
        this.cbig12 = cbig12 == null ? null : cbig12.trim();
    }

    public Double getCbig13() {
        return cbig13;
    }

    public void setCbig13(Double cbig13) {
        this.cbig13 = cbig13;
    }

    public Integer getCbie01() {
        return cbie01;
    }

    public void setCbie01(Integer cbie01) {
        this.cbie01 = cbie01;
    }

    public Integer getCbig14() {
        return cbig14;
    }

    public void setCbig14(Integer cbig14) {
        this.cbig14 = cbig14;
    }

    public Date getCbig15() {
        return cbig15;
    }

    public void setCbig15(Date cbig15) {
        this.cbig15 = cbig15;
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
        Cbig other = (Cbig) that;
        return (this.getCbig01() == null ? other.getCbig01() == null : this.getCbig01().equals(other.getCbig01()))
            && (this.getCbig02() == null ? other.getCbig02() == null : this.getCbig02().equals(other.getCbig02()))
            && (this.getCbig03() == null ? other.getCbig03() == null : this.getCbig03().equals(other.getCbig03()))
            && (this.getCbig04() == null ? other.getCbig04() == null : this.getCbig04().equals(other.getCbig04()))
            && (this.getCbig05() == null ? other.getCbig05() == null : this.getCbig05().equals(other.getCbig05()))
            && (this.getCbig06() == null ? other.getCbig06() == null : this.getCbig06().equals(other.getCbig06()))
            && (this.getCbig07() == null ? other.getCbig07() == null : this.getCbig07().equals(other.getCbig07()))
            && (this.getCbig08() == null ? other.getCbig08() == null : this.getCbig08().equals(other.getCbig08()))
            && (this.getCbig09() == null ? other.getCbig09() == null : this.getCbig09().equals(other.getCbig09()))
            && (this.getCbig10() == null ? other.getCbig10() == null : this.getCbig10().equals(other.getCbig10()))
            && (this.getCbig11() == null ? other.getCbig11() == null : this.getCbig11().equals(other.getCbig11()))
            && (this.getCbig12() == null ? other.getCbig12() == null : this.getCbig12().equals(other.getCbig12()))
            && (this.getCbig13() == null ? other.getCbig13() == null : this.getCbig13().equals(other.getCbig13()))
            && (this.getCbie01() == null ? other.getCbie01() == null : this.getCbie01().equals(other.getCbie01()))
            && (this.getCbig14() == null ? other.getCbig14() == null : this.getCbig14().equals(other.getCbig14()))
            && (this.getCbig15() == null ? other.getCbig15() == null : this.getCbig15().equals(other.getCbig15()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbig01() == null) ? 0 : getCbig01().hashCode());
        result = prime * result + ((getCbig02() == null) ? 0 : getCbig02().hashCode());
        result = prime * result + ((getCbig03() == null) ? 0 : getCbig03().hashCode());
        result = prime * result + ((getCbig04() == null) ? 0 : getCbig04().hashCode());
        result = prime * result + ((getCbig05() == null) ? 0 : getCbig05().hashCode());
        result = prime * result + ((getCbig06() == null) ? 0 : getCbig06().hashCode());
        result = prime * result + ((getCbig07() == null) ? 0 : getCbig07().hashCode());
        result = prime * result + ((getCbig08() == null) ? 0 : getCbig08().hashCode());
        result = prime * result + ((getCbig09() == null) ? 0 : getCbig09().hashCode());
        result = prime * result + ((getCbig10() == null) ? 0 : getCbig10().hashCode());
        result = prime * result + ((getCbig11() == null) ? 0 : getCbig11().hashCode());
        result = prime * result + ((getCbig12() == null) ? 0 : getCbig12().hashCode());
        result = prime * result + ((getCbig13() == null) ? 0 : getCbig13().hashCode());
        result = prime * result + ((getCbie01() == null) ? 0 : getCbie01().hashCode());
        result = prime * result + ((getCbig14() == null) ? 0 : getCbig14().hashCode());
        result = prime * result + ((getCbig15() == null) ? 0 : getCbig15().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbig01=").append(cbig01);
        sb.append(", cbig02=").append(cbig02);
        sb.append(", cbig03=").append(cbig03);
        sb.append(", cbig04=").append(cbig04);
        sb.append(", cbig05=").append(cbig05);
        sb.append(", cbig06=").append(cbig06);
        sb.append(", cbig07=").append(cbig07);
        sb.append(", cbig08=").append(cbig08);
        sb.append(", cbig09=").append(cbig09);
        sb.append(", cbig10=").append(cbig10);
        sb.append(", cbig11=").append(cbig11);
        sb.append(", cbig12=").append(cbig12);
        sb.append(", cbig13=").append(cbig13);
        sb.append(", cbie01=").append(cbie01);
        sb.append(", cbig14=").append(cbig14);
        sb.append(", cbig15=").append(cbig15);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
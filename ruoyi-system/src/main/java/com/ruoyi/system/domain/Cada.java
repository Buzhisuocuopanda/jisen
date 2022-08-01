package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class Cada  extends BaseEntity implements Serializable {
    private Integer cada01;

    private Integer cada02;

    private Date cada03;

    private Date cada04;

    private Integer cada05;

    private Integer cada06;

    private Integer cada07;

    private String cada08;

    private String cada09;

    private Integer cada10;

    private String cada11;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCada01() {
        return cada01;
    }

    public void setCada01(Integer cada01) {
        this.cada01 = cada01;
    }

    public Integer getCada02() {
        return cada02;
    }

    public void setCada02(Integer cada02) {
        this.cada02 = cada02;
    }

    public Date getCada03() {
        return cada03;
    }

    public void setCada03(Date cada03) {
        this.cada03 = cada03;
    }

    public Date getCada04() {
        return cada04;
    }

    public void setCada04(Date cada04) {
        this.cada04 = cada04;
    }

    public Integer getCada05() {
        return cada05;
    }

    public void setCada05(Integer cada05) {
        this.cada05 = cada05;
    }

    public Integer getCada06() {
        return cada06;
    }

    public void setCada06(Integer cada06) {
        this.cada06 = cada06;
    }

    public Integer getCada07() {
        return cada07;
    }

    public void setCada07(Integer cada07) {
        this.cada07 = cada07;
    }

    public String getCada08() {
        return cada08;
    }

    public void setCada08(String cada08) {
        this.cada08 = cada08 == null ? null : cada08.trim();
    }

    public String getCada09() {
        return cada09;
    }

    public void setCada09(String cada09) {
        this.cada09 = cada09 == null ? null : cada09.trim();
    }

    public Integer getCada10() {
        return cada10;
    }

    public void setCada10(Integer cada10) {
        this.cada10 = cada10;
    }

    public String getCada11() {
        return cada11;
    }

    public void setCada11(String cada11) {
        this.cada11 = cada11 == null ? null : cada11.trim();
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
        Cada other = (Cada) that;
        return (this.getCada01() == null ? other.getCada01() == null : this.getCada01().equals(other.getCada01()))
            && (this.getCada02() == null ? other.getCada02() == null : this.getCada02().equals(other.getCada02()))
            && (this.getCada03() == null ? other.getCada03() == null : this.getCada03().equals(other.getCada03()))
            && (this.getCada04() == null ? other.getCada04() == null : this.getCada04().equals(other.getCada04()))
            && (this.getCada05() == null ? other.getCada05() == null : this.getCada05().equals(other.getCada05()))
            && (this.getCada06() == null ? other.getCada06() == null : this.getCada06().equals(other.getCada06()))
            && (this.getCada07() == null ? other.getCada07() == null : this.getCada07().equals(other.getCada07()))
            && (this.getCada08() == null ? other.getCada08() == null : this.getCada08().equals(other.getCada08()))
            && (this.getCada09() == null ? other.getCada09() == null : this.getCada09().equals(other.getCada09()))
            && (this.getCada10() == null ? other.getCada10() == null : this.getCada10().equals(other.getCada10()))
            && (this.getCada11() == null ? other.getCada11() == null : this.getCada11().equals(other.getCada11()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCada01() == null) ? 0 : getCada01().hashCode());
        result = prime * result + ((getCada02() == null) ? 0 : getCada02().hashCode());
        result = prime * result + ((getCada03() == null) ? 0 : getCada03().hashCode());
        result = prime * result + ((getCada04() == null) ? 0 : getCada04().hashCode());
        result = prime * result + ((getCada05() == null) ? 0 : getCada05().hashCode());
        result = prime * result + ((getCada06() == null) ? 0 : getCada06().hashCode());
        result = prime * result + ((getCada07() == null) ? 0 : getCada07().hashCode());
        result = prime * result + ((getCada08() == null) ? 0 : getCada08().hashCode());
        result = prime * result + ((getCada09() == null) ? 0 : getCada09().hashCode());
        result = prime * result + ((getCada10() == null) ? 0 : getCada10().hashCode());
        result = prime * result + ((getCada11() == null) ? 0 : getCada11().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cada01=").append(cada01);
        sb.append(", cada02=").append(cada02);
        sb.append(", cada03=").append(cada03);
        sb.append(", cada04=").append(cada04);
        sb.append(", cada05=").append(cada05);
        sb.append(", cada06=").append(cada06);
        sb.append(", cada07=").append(cada07);
        sb.append(", cada08=").append(cada08);
        sb.append(", cada09=").append(cada09);
        sb.append(", cada10=").append(cada10);
        sb.append(", cada11=").append(cada11);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

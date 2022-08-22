package com.ruoyi.system.domain;

import java.io.Serializable;

public class I96jmSheet1660096088245WithBLOBs extends I96jmSheet1660096088245 implements Serializable {
    private String dropdown1660096147170;

    private String deptsingle1660196753803;

    private static final long serialVersionUID = 1L;

    public String getDropdown1660096147170() {
        return dropdown1660096147170;
    }

    public void setDropdown1660096147170(String dropdown1660096147170) {
        this.dropdown1660096147170 = dropdown1660096147170 == null ? null : dropdown1660096147170.trim();
    }

    public String getDeptsingle1660196753803() {
        return deptsingle1660196753803;
    }

    public void setDeptsingle1660196753803(String deptsingle1660196753803) {
        this.deptsingle1660196753803 = deptsingle1660196753803 == null ? null : deptsingle1660196753803.trim();
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
        I96jmSheet1660096088245WithBLOBs other = (I96jmSheet1660096088245WithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShorttext1660096116140() == null ? other.getShorttext1660096116140() == null : this.getShorttext1660096116140().equals(other.getShorttext1660096116140()))
            && (this.getDate1660096127382() == null ? other.getDate1660096127382() == null : this.getDate1660096127382().equals(other.getDate1660096127382()))
            && (this.getNumber1660096167450() == null ? other.getNumber1660096167450() == null : this.getNumber1660096167450().equals(other.getNumber1660096167450()))
            && (this.getNumber1660096200806() == null ? other.getNumber1660096200806() == null : this.getNumber1660096200806().equals(other.getNumber1660096200806()))
            && (this.getNumber1660096217930() == null ? other.getNumber1660096217930() == null : this.getNumber1660096217930().equals(other.getNumber1660096217930()))
            && (this.getRelevanceform1660272856363() == null ? other.getRelevanceform1660272856363() == null : this.getRelevanceform1660272856363().equals(other.getRelevanceform1660272856363()))
            && (this.getRelevanceform1660272984690() == null ? other.getRelevanceform1660272984690() == null : this.getRelevanceform1660272984690().equals(other.getRelevanceform1660272984690()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getSortkey() == null ? other.getSortkey() == null : this.getSortkey().equals(other.getSortkey()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifiedtime() == null ? other.getModifiedtime() == null : this.getModifiedtime().equals(other.getModifiedtime()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getNumber1660637832474() == null ? other.getNumber1660637832474() == null : this.getNumber1660637832474().equals(other.getNumber1660637832474()))
            && (this.getDropdown1660096147170() == null ? other.getDropdown1660096147170() == null : this.getDropdown1660096147170().equals(other.getDropdown1660096147170()))
            && (this.getDeptsingle1660196753803() == null ? other.getDeptsingle1660196753803() == null : this.getDeptsingle1660196753803().equals(other.getDeptsingle1660196753803()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShorttext1660096116140() == null) ? 0 : getShorttext1660096116140().hashCode());
        result = prime * result + ((getDate1660096127382() == null) ? 0 : getDate1660096127382().hashCode());
        result = prime * result + ((getNumber1660096167450() == null) ? 0 : getNumber1660096167450().hashCode());
        result = prime * result + ((getNumber1660096200806() == null) ? 0 : getNumber1660096200806().hashCode());
        result = prime * result + ((getNumber1660096217930() == null) ? 0 : getNumber1660096217930().hashCode());
        result = prime * result + ((getRelevanceform1660272856363() == null) ? 0 : getRelevanceform1660272856363().hashCode());
        result = prime * result + ((getRelevanceform1660272984690() == null) ? 0 : getRelevanceform1660272984690().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getSortkey() == null) ? 0 : getSortkey().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifiedtime() == null) ? 0 : getModifiedtime().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getNumber1660637832474() == null) ? 0 : getNumber1660637832474().hashCode());
        result = prime * result + ((getDropdown1660096147170() == null) ? 0 : getDropdown1660096147170().hashCode());
        result = prime * result + ((getDeptsingle1660196753803() == null) ? 0 : getDeptsingle1660196753803().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dropdown1660096147170=").append(dropdown1660096147170);
        sb.append(", deptsingle1660196753803=").append(deptsingle1660196753803);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
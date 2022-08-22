package com.ruoyi.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class I96jmSheet1660096088245 implements Serializable {
    private String id;

    private String shorttext1660096116140;

    private Date date1660096127382;

    private BigDecimal number1660096167450;

    private BigDecimal number1660096200806;

    private BigDecimal number1660096217930;

    private String relevanceform1660272856363;

    private String relevanceform1660272984690;

    private String parentid;

    private BigDecimal sortkey;

    private String modifier;

    private Date modifiedtime;

    private BigDecimal version;

    private BigDecimal number1660637832474;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShorttext1660096116140() {
        return shorttext1660096116140;
    }

    public void setShorttext1660096116140(String shorttext1660096116140) {
        this.shorttext1660096116140 = shorttext1660096116140 == null ? null : shorttext1660096116140.trim();
    }

    public Date getDate1660096127382() {
        return date1660096127382;
    }

    public void setDate1660096127382(Date date1660096127382) {
        this.date1660096127382 = date1660096127382;
    }

    public BigDecimal getNumber1660096167450() {
        return number1660096167450;
    }

    public void setNumber1660096167450(BigDecimal number1660096167450) {
        this.number1660096167450 = number1660096167450;
    }

    public BigDecimal getNumber1660096200806() {
        return number1660096200806;
    }

    public void setNumber1660096200806(BigDecimal number1660096200806) {
        this.number1660096200806 = number1660096200806;
    }

    public BigDecimal getNumber1660096217930() {
        return number1660096217930;
    }

    public void setNumber1660096217930(BigDecimal number1660096217930) {
        this.number1660096217930 = number1660096217930;
    }

    public String getRelevanceform1660272856363() {
        return relevanceform1660272856363;
    }

    public void setRelevanceform1660272856363(String relevanceform1660272856363) {
        this.relevanceform1660272856363 = relevanceform1660272856363 == null ? null : relevanceform1660272856363.trim();
    }

    public String getRelevanceform1660272984690() {
        return relevanceform1660272984690;
    }

    public void setRelevanceform1660272984690(String relevanceform1660272984690) {
        this.relevanceform1660272984690 = relevanceform1660272984690 == null ? null : relevanceform1660272984690.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public BigDecimal getSortkey() {
        return sortkey;
    }

    public void setSortkey(BigDecimal sortkey) {
        this.sortkey = sortkey;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public BigDecimal getNumber1660637832474() {
        return number1660637832474;
    }

    public void setNumber1660637832474(BigDecimal number1660637832474) {
        this.number1660637832474 = number1660637832474;
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
        I96jmSheet1660096088245 other = (I96jmSheet1660096088245) that;
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
            && (this.getNumber1660637832474() == null ? other.getNumber1660637832474() == null : this.getNumber1660637832474().equals(other.getNumber1660637832474()));
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shorttext1660096116140=").append(shorttext1660096116140);
        sb.append(", date1660096127382=").append(date1660096127382);
        sb.append(", number1660096167450=").append(number1660096167450);
        sb.append(", number1660096200806=").append(number1660096200806);
        sb.append(", number1660096217930=").append(number1660096217930);
        sb.append(", relevanceform1660272856363=").append(relevanceform1660272856363);
        sb.append(", relevanceform1660272984690=").append(relevanceform1660272984690);
        sb.append(", parentid=").append(parentid);
        sb.append(", sortkey=").append(sortkey);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifiedtime=").append(modifiedtime);
        sb.append(", version=").append(version);
        sb.append(", number1660637832474=").append(number1660637832474);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
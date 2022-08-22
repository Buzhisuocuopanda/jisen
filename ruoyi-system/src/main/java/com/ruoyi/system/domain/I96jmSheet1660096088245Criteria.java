package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class I96jmSheet1660096088245Criteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public I96jmSheet1660096088245Criteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140IsNull() {
            addCriterion("ShortText1660096116140 is null");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140IsNotNull() {
            addCriterion("ShortText1660096116140 is not null");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140EqualTo(String value) {
            addCriterion("ShortText1660096116140 =", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140NotEqualTo(String value) {
            addCriterion("ShortText1660096116140 <>", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140GreaterThan(String value) {
            addCriterion("ShortText1660096116140 >", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140GreaterThanOrEqualTo(String value) {
            addCriterion("ShortText1660096116140 >=", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140LessThan(String value) {
            addCriterion("ShortText1660096116140 <", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140LessThanOrEqualTo(String value) {
            addCriterion("ShortText1660096116140 <=", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140Like(String value) {
            addCriterion("ShortText1660096116140 like", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140NotLike(String value) {
            addCriterion("ShortText1660096116140 not like", value, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140In(List<String> values) {
            addCriterion("ShortText1660096116140 in", values, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140NotIn(List<String> values) {
            addCriterion("ShortText1660096116140 not in", values, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140Between(String value1, String value2) {
            addCriterion("ShortText1660096116140 between", value1, value2, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andShorttext1660096116140NotBetween(String value1, String value2) {
            addCriterion("ShortText1660096116140 not between", value1, value2, "shorttext1660096116140");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382IsNull() {
            addCriterion("Date1660096127382 is null");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382IsNotNull() {
            addCriterion("Date1660096127382 is not null");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382EqualTo(Date value) {
            addCriterion("Date1660096127382 =", value, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382NotEqualTo(Date value) {
            addCriterion("Date1660096127382 <>", value, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382GreaterThan(Date value) {
            addCriterion("Date1660096127382 >", value, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382GreaterThanOrEqualTo(Date value) {
            addCriterion("Date1660096127382 >=", value, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382LessThan(Date value) {
            addCriterion("Date1660096127382 <", value, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382LessThanOrEqualTo(Date value) {
            addCriterion("Date1660096127382 <=", value, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382In(List<Date> values) {
            addCriterion("Date1660096127382 in", values, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382NotIn(List<Date> values) {
            addCriterion("Date1660096127382 not in", values, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382Between(Date value1, Date value2) {
            addCriterion("Date1660096127382 between", value1, value2, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andDate1660096127382NotBetween(Date value1, Date value2) {
            addCriterion("Date1660096127382 not between", value1, value2, "date1660096127382");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450IsNull() {
            addCriterion("Number1660096167450 is null");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450IsNotNull() {
            addCriterion("Number1660096167450 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450EqualTo(BigDecimal value) {
            addCriterion("Number1660096167450 =", value, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450NotEqualTo(BigDecimal value) {
            addCriterion("Number1660096167450 <>", value, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450GreaterThan(BigDecimal value) {
            addCriterion("Number1660096167450 >", value, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660096167450 >=", value, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450LessThan(BigDecimal value) {
            addCriterion("Number1660096167450 <", value, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450LessThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660096167450 <=", value, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450In(List<BigDecimal> values) {
            addCriterion("Number1660096167450 in", values, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450NotIn(List<BigDecimal> values) {
            addCriterion("Number1660096167450 not in", values, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660096167450 between", value1, value2, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096167450NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660096167450 not between", value1, value2, "number1660096167450");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806IsNull() {
            addCriterion("Number1660096200806 is null");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806IsNotNull() {
            addCriterion("Number1660096200806 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806EqualTo(BigDecimal value) {
            addCriterion("Number1660096200806 =", value, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806NotEqualTo(BigDecimal value) {
            addCriterion("Number1660096200806 <>", value, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806GreaterThan(BigDecimal value) {
            addCriterion("Number1660096200806 >", value, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660096200806 >=", value, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806LessThan(BigDecimal value) {
            addCriterion("Number1660096200806 <", value, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806LessThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660096200806 <=", value, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806In(List<BigDecimal> values) {
            addCriterion("Number1660096200806 in", values, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806NotIn(List<BigDecimal> values) {
            addCriterion("Number1660096200806 not in", values, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660096200806 between", value1, value2, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096200806NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660096200806 not between", value1, value2, "number1660096200806");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930IsNull() {
            addCriterion("Number1660096217930 is null");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930IsNotNull() {
            addCriterion("Number1660096217930 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930EqualTo(BigDecimal value) {
            addCriterion("Number1660096217930 =", value, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930NotEqualTo(BigDecimal value) {
            addCriterion("Number1660096217930 <>", value, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930GreaterThan(BigDecimal value) {
            addCriterion("Number1660096217930 >", value, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660096217930 >=", value, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930LessThan(BigDecimal value) {
            addCriterion("Number1660096217930 <", value, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930LessThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660096217930 <=", value, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930In(List<BigDecimal> values) {
            addCriterion("Number1660096217930 in", values, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930NotIn(List<BigDecimal> values) {
            addCriterion("Number1660096217930 not in", values, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660096217930 between", value1, value2, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andNumber1660096217930NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660096217930 not between", value1, value2, "number1660096217930");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363IsNull() {
            addCriterion("RelevanceForm1660272856363 is null");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363IsNotNull() {
            addCriterion("RelevanceForm1660272856363 is not null");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363EqualTo(String value) {
            addCriterion("RelevanceForm1660272856363 =", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363NotEqualTo(String value) {
            addCriterion("RelevanceForm1660272856363 <>", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363GreaterThan(String value) {
            addCriterion("RelevanceForm1660272856363 >", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363GreaterThanOrEqualTo(String value) {
            addCriterion("RelevanceForm1660272856363 >=", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363LessThan(String value) {
            addCriterion("RelevanceForm1660272856363 <", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363LessThanOrEqualTo(String value) {
            addCriterion("RelevanceForm1660272856363 <=", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363Like(String value) {
            addCriterion("RelevanceForm1660272856363 like", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363NotLike(String value) {
            addCriterion("RelevanceForm1660272856363 not like", value, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363In(List<String> values) {
            addCriterion("RelevanceForm1660272856363 in", values, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363NotIn(List<String> values) {
            addCriterion("RelevanceForm1660272856363 not in", values, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363Between(String value1, String value2) {
            addCriterion("RelevanceForm1660272856363 between", value1, value2, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272856363NotBetween(String value1, String value2) {
            addCriterion("RelevanceForm1660272856363 not between", value1, value2, "relevanceform1660272856363");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690IsNull() {
            addCriterion("RelevanceForm1660272984690 is null");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690IsNotNull() {
            addCriterion("RelevanceForm1660272984690 is not null");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690EqualTo(String value) {
            addCriterion("RelevanceForm1660272984690 =", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690NotEqualTo(String value) {
            addCriterion("RelevanceForm1660272984690 <>", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690GreaterThan(String value) {
            addCriterion("RelevanceForm1660272984690 >", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690GreaterThanOrEqualTo(String value) {
            addCriterion("RelevanceForm1660272984690 >=", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690LessThan(String value) {
            addCriterion("RelevanceForm1660272984690 <", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690LessThanOrEqualTo(String value) {
            addCriterion("RelevanceForm1660272984690 <=", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690Like(String value) {
            addCriterion("RelevanceForm1660272984690 like", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690NotLike(String value) {
            addCriterion("RelevanceForm1660272984690 not like", value, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690In(List<String> values) {
            addCriterion("RelevanceForm1660272984690 in", values, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690NotIn(List<String> values) {
            addCriterion("RelevanceForm1660272984690 not in", values, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690Between(String value1, String value2) {
            addCriterion("RelevanceForm1660272984690 between", value1, value2, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andRelevanceform1660272984690NotBetween(String value1, String value2) {
            addCriterion("RelevanceForm1660272984690 not between", value1, value2, "relevanceform1660272984690");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("parentId like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("parentId not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andSortkeyIsNull() {
            addCriterion("sortKey is null");
            return (Criteria) this;
        }

        public Criteria andSortkeyIsNotNull() {
            addCriterion("sortKey is not null");
            return (Criteria) this;
        }

        public Criteria andSortkeyEqualTo(BigDecimal value) {
            addCriterion("sortKey =", value, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyNotEqualTo(BigDecimal value) {
            addCriterion("sortKey <>", value, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyGreaterThan(BigDecimal value) {
            addCriterion("sortKey >", value, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sortKey >=", value, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyLessThan(BigDecimal value) {
            addCriterion("sortKey <", value, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sortKey <=", value, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyIn(List<BigDecimal> values) {
            addCriterion("sortKey in", values, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyNotIn(List<BigDecimal> values) {
            addCriterion("sortKey not in", values, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sortKey between", value1, value2, "sortkey");
            return (Criteria) this;
        }

        public Criteria andSortkeyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sortKey not between", value1, value2, "sortkey");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNull() {
            addCriterion("modifiedTime is null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNotNull() {
            addCriterion("modifiedTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeEqualTo(Date value) {
            addCriterion("modifiedTime =", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotEqualTo(Date value) {
            addCriterion("modifiedTime <>", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThan(Date value) {
            addCriterion("modifiedTime >", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifiedTime >=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThan(Date value) {
            addCriterion("modifiedTime <", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThanOrEqualTo(Date value) {
            addCriterion("modifiedTime <=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIn(List<Date> values) {
            addCriterion("modifiedTime in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotIn(List<Date> values) {
            addCriterion("modifiedTime not in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeBetween(Date value1, Date value2) {
            addCriterion("modifiedTime between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotBetween(Date value1, Date value2) {
            addCriterion("modifiedTime not between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(BigDecimal value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(BigDecimal value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(BigDecimal value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(BigDecimal value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<BigDecimal> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<BigDecimal> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474IsNull() {
            addCriterion("Number1660637832474 is null");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474IsNotNull() {
            addCriterion("Number1660637832474 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474EqualTo(BigDecimal value) {
            addCriterion("Number1660637832474 =", value, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474NotEqualTo(BigDecimal value) {
            addCriterion("Number1660637832474 <>", value, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474GreaterThan(BigDecimal value) {
            addCriterion("Number1660637832474 >", value, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660637832474 >=", value, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474LessThan(BigDecimal value) {
            addCriterion("Number1660637832474 <", value, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474LessThanOrEqualTo(BigDecimal value) {
            addCriterion("Number1660637832474 <=", value, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474In(List<BigDecimal> values) {
            addCriterion("Number1660637832474 in", values, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474NotIn(List<BigDecimal> values) {
            addCriterion("Number1660637832474 not in", values, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660637832474 between", value1, value2, "number1660637832474");
            return (Criteria) this;
        }

        public Criteria andNumber1660637832474NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Number1660637832474 not between", value1, value2, "number1660637832474");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
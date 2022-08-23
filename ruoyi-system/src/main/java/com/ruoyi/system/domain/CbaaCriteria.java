package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbaaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbaaCriteria() {
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

        public Criteria andCbaa01IsNull() {
            addCriterion("CBAA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa01IsNotNull() {
            addCriterion("CBAA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa01EqualTo(Integer value) {
            addCriterion("CBAA01 =", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotEqualTo(Integer value) {
            addCriterion("CBAA01 <>", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01GreaterThan(Integer value) {
            addCriterion("CBAA01 >", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA01 >=", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01LessThan(Integer value) {
            addCriterion("CBAA01 <", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA01 <=", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01In(List<Integer> values) {
            addCriterion("CBAA01 in", values, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotIn(List<Integer> values) {
            addCriterion("CBAA01 not in", values, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01Between(Integer value1, Integer value2) {
            addCriterion("CBAA01 between", value1, value2, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA01 not between", value1, value2, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa02IsNull() {
            addCriterion("CBAA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa02IsNotNull() {
            addCriterion("CBAA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa02EqualTo(Date value) {
            addCriterion("CBAA02 =", value, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02NotEqualTo(Date value) {
            addCriterion("CBAA02 <>", value, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02GreaterThan(Date value) {
            addCriterion("CBAA02 >", value, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAA02 >=", value, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02LessThan(Date value) {
            addCriterion("CBAA02 <", value, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02LessThanOrEqualTo(Date value) {
            addCriterion("CBAA02 <=", value, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02In(List<Date> values) {
            addCriterion("CBAA02 in", values, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02NotIn(List<Date> values) {
            addCriterion("CBAA02 not in", values, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02Between(Date value1, Date value2) {
            addCriterion("CBAA02 between", value1, value2, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa02NotBetween(Date value1, Date value2) {
            addCriterion("CBAA02 not between", value1, value2, "cbaa02");
            return (Criteria) this;
        }

        public Criteria andCbaa03IsNull() {
            addCriterion("CBAA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa03IsNotNull() {
            addCriterion("CBAA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa03EqualTo(Integer value) {
            addCriterion("CBAA03 =", value, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03NotEqualTo(Integer value) {
            addCriterion("CBAA03 <>", value, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03GreaterThan(Integer value) {
            addCriterion("CBAA03 >", value, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA03 >=", value, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03LessThan(Integer value) {
            addCriterion("CBAA03 <", value, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA03 <=", value, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03In(List<Integer> values) {
            addCriterion("CBAA03 in", values, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03NotIn(List<Integer> values) {
            addCriterion("CBAA03 not in", values, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03Between(Integer value1, Integer value2) {
            addCriterion("CBAA03 between", value1, value2, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA03 not between", value1, value2, "cbaa03");
            return (Criteria) this;
        }

        public Criteria andCbaa04IsNull() {
            addCriterion("CBAA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa04IsNotNull() {
            addCriterion("CBAA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa04EqualTo(Date value) {
            addCriterion("CBAA04 =", value, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04NotEqualTo(Date value) {
            addCriterion("CBAA04 <>", value, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04GreaterThan(Date value) {
            addCriterion("CBAA04 >", value, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAA04 >=", value, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04LessThan(Date value) {
            addCriterion("CBAA04 <", value, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04LessThanOrEqualTo(Date value) {
            addCriterion("CBAA04 <=", value, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04In(List<Date> values) {
            addCriterion("CBAA04 in", values, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04NotIn(List<Date> values) {
            addCriterion("CBAA04 not in", values, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04Between(Date value1, Date value2) {
            addCriterion("CBAA04 between", value1, value2, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa04NotBetween(Date value1, Date value2) {
            addCriterion("CBAA04 not between", value1, value2, "cbaa04");
            return (Criteria) this;
        }

        public Criteria andCbaa05IsNull() {
            addCriterion("CBAA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa05IsNotNull() {
            addCriterion("CBAA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa05EqualTo(Integer value) {
            addCriterion("CBAA05 =", value, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05NotEqualTo(Integer value) {
            addCriterion("CBAA05 <>", value, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05GreaterThan(Integer value) {
            addCriterion("CBAA05 >", value, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA05 >=", value, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05LessThan(Integer value) {
            addCriterion("CBAA05 <", value, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA05 <=", value, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05In(List<Integer> values) {
            addCriterion("CBAA05 in", values, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05NotIn(List<Integer> values) {
            addCriterion("CBAA05 not in", values, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05Between(Integer value1, Integer value2) {
            addCriterion("CBAA05 between", value1, value2, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA05 not between", value1, value2, "cbaa05");
            return (Criteria) this;
        }

        public Criteria andCbaa06IsNull() {
            addCriterion("CBAA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa06IsNotNull() {
            addCriterion("CBAA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa06EqualTo(Integer value) {
            addCriterion("CBAA06 =", value, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06NotEqualTo(Integer value) {
            addCriterion("CBAA06 <>", value, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06GreaterThan(Integer value) {
            addCriterion("CBAA06 >", value, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA06 >=", value, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06LessThan(Integer value) {
            addCriterion("CBAA06 <", value, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA06 <=", value, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06In(List<Integer> values) {
            addCriterion("CBAA06 in", values, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06NotIn(List<Integer> values) {
            addCriterion("CBAA06 not in", values, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06Between(Integer value1, Integer value2) {
            addCriterion("CBAA06 between", value1, value2, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA06 not between", value1, value2, "cbaa06");
            return (Criteria) this;
        }

        public Criteria andCbaa07IsNull() {
            addCriterion("CBAA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa07IsNotNull() {
            addCriterion("CBAA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa07EqualTo(String value) {
            addCriterion("CBAA07 =", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07NotEqualTo(String value) {
            addCriterion("CBAA07 <>", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07GreaterThan(String value) {
            addCriterion("CBAA07 >", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07GreaterThanOrEqualTo(String value) {
            addCriterion("CBAA07 >=", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07LessThan(String value) {
            addCriterion("CBAA07 <", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07LessThanOrEqualTo(String value) {
            addCriterion("CBAA07 <=", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07Like(String value) {
            addCriterion("CBAA07 like", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07NotLike(String value) {
            addCriterion("CBAA07 not like", value, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07In(List<String> values) {
            addCriterion("CBAA07 in", values, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07NotIn(List<String> values) {
            addCriterion("CBAA07 not in", values, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07Between(String value1, String value2) {
            addCriterion("CBAA07 between", value1, value2, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa07NotBetween(String value1, String value2) {
            addCriterion("CBAA07 not between", value1, value2, "cbaa07");
            return (Criteria) this;
        }

        public Criteria andCbaa08IsNull() {
            addCriterion("CBAA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa08IsNotNull() {
            addCriterion("CBAA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa08EqualTo(Date value) {
            addCriterion("CBAA08 =", value, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08NotEqualTo(Date value) {
            addCriterion("CBAA08 <>", value, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08GreaterThan(Date value) {
            addCriterion("CBAA08 >", value, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAA08 >=", value, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08LessThan(Date value) {
            addCriterion("CBAA08 <", value, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08LessThanOrEqualTo(Date value) {
            addCriterion("CBAA08 <=", value, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08In(List<Date> values) {
            addCriterion("CBAA08 in", values, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08NotIn(List<Date> values) {
            addCriterion("CBAA08 not in", values, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08Between(Date value1, Date value2) {
            addCriterion("CBAA08 between", value1, value2, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa08NotBetween(Date value1, Date value2) {
            addCriterion("CBAA08 not between", value1, value2, "cbaa08");
            return (Criteria) this;
        }

        public Criteria andCbaa09IsNull() {
            addCriterion("CBAA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa09IsNotNull() {
            addCriterion("CBAA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa09EqualTo(Integer value) {
            addCriterion("CBAA09 =", value, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09NotEqualTo(Integer value) {
            addCriterion("CBAA09 <>", value, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09GreaterThan(Integer value) {
            addCriterion("CBAA09 >", value, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA09 >=", value, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09LessThan(Integer value) {
            addCriterion("CBAA09 <", value, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA09 <=", value, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09In(List<Integer> values) {
            addCriterion("CBAA09 in", values, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09NotIn(List<Integer> values) {
            addCriterion("CBAA09 not in", values, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09Between(Integer value1, Integer value2) {
            addCriterion("CBAA09 between", value1, value2, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA09 not between", value1, value2, "cbaa09");
            return (Criteria) this;
        }

        public Criteria andCbaa10IsNull() {
            addCriterion("CBAA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa10IsNotNull() {
            addCriterion("CBAA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa10EqualTo(Integer value) {
            addCriterion("CBAA10 =", value, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10NotEqualTo(Integer value) {
            addCriterion("CBAA10 <>", value, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10GreaterThan(Integer value) {
            addCriterion("CBAA10 >", value, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA10 >=", value, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10LessThan(Integer value) {
            addCriterion("CBAA10 <", value, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA10 <=", value, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10In(List<Integer> values) {
            addCriterion("CBAA10 in", values, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10NotIn(List<Integer> values) {
            addCriterion("CBAA10 not in", values, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10Between(Integer value1, Integer value2) {
            addCriterion("CBAA10 between", value1, value2, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA10 not between", value1, value2, "cbaa10");
            return (Criteria) this;
        }

        public Criteria andCbaa11IsNull() {
            addCriterion("CBAA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa11IsNotNull() {
            addCriterion("CBAA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa11EqualTo(Integer value) {
            addCriterion("CBAA11 =", value, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11NotEqualTo(Integer value) {
            addCriterion("CBAA11 <>", value, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11GreaterThan(Integer value) {
            addCriterion("CBAA11 >", value, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA11 >=", value, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11LessThan(Integer value) {
            addCriterion("CBAA11 <", value, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA11 <=", value, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11In(List<Integer> values) {
            addCriterion("CBAA11 in", values, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11NotIn(List<Integer> values) {
            addCriterion("CBAA11 not in", values, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11Between(Integer value1, Integer value2) {
            addCriterion("CBAA11 between", value1, value2, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA11 not between", value1, value2, "cbaa11");
            return (Criteria) this;
        }

        public Criteria andCbaa12IsNull() {
            addCriterion("CBAA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa12IsNotNull() {
            addCriterion("CBAA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa12EqualTo(Integer value) {
            addCriterion("CBAA12 =", value, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12NotEqualTo(Integer value) {
            addCriterion("CBAA12 <>", value, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12GreaterThan(Integer value) {
            addCriterion("CBAA12 >", value, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA12 >=", value, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12LessThan(Integer value) {
            addCriterion("CBAA12 <", value, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA12 <=", value, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12In(List<Integer> values) {
            addCriterion("CBAA12 in", values, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12NotIn(List<Integer> values) {
            addCriterion("CBAA12 not in", values, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12Between(Integer value1, Integer value2) {
            addCriterion("CBAA12 between", value1, value2, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA12 not between", value1, value2, "cbaa12");
            return (Criteria) this;
        }

        public Criteria andCbaa13IsNull() {
            addCriterion("CBAA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa13IsNotNull() {
            addCriterion("CBAA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa13EqualTo(Date value) {
            addCriterion("CBAA13 =", value, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13NotEqualTo(Date value) {
            addCriterion("CBAA13 <>", value, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13GreaterThan(Date value) {
            addCriterion("CBAA13 >", value, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAA13 >=", value, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13LessThan(Date value) {
            addCriterion("CBAA13 <", value, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13LessThanOrEqualTo(Date value) {
            addCriterion("CBAA13 <=", value, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13In(List<Date> values) {
            addCriterion("CBAA13 in", values, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13NotIn(List<Date> values) {
            addCriterion("CBAA13 not in", values, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13Between(Date value1, Date value2) {
            addCriterion("CBAA13 between", value1, value2, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa13NotBetween(Date value1, Date value2) {
            addCriterion("CBAA13 not between", value1, value2, "cbaa13");
            return (Criteria) this;
        }

        public Criteria andCbaa14IsNull() {
            addCriterion("CBAA14 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa14IsNotNull() {
            addCriterion("CBAA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa14EqualTo(Integer value) {
            addCriterion("CBAA14 =", value, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14NotEqualTo(Integer value) {
            addCriterion("CBAA14 <>", value, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14GreaterThan(Integer value) {
            addCriterion("CBAA14 >", value, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA14 >=", value, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14LessThan(Integer value) {
            addCriterion("CBAA14 <", value, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA14 <=", value, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14In(List<Integer> values) {
            addCriterion("CBAA14 in", values, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14NotIn(List<Integer> values) {
            addCriterion("CBAA14 not in", values, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14Between(Integer value1, Integer value2) {
            addCriterion("CBAA14 between", value1, value2, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA14 not between", value1, value2, "cbaa14");
            return (Criteria) this;
        }

        public Criteria andCbaa15IsNull() {
            addCriterion("CBAA15 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa15IsNotNull() {
            addCriterion("CBAA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa15EqualTo(Date value) {
            addCriterion("CBAA15 =", value, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15NotEqualTo(Date value) {
            addCriterion("CBAA15 <>", value, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15GreaterThan(Date value) {
            addCriterion("CBAA15 >", value, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAA15 >=", value, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15LessThan(Date value) {
            addCriterion("CBAA15 <", value, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15LessThanOrEqualTo(Date value) {
            addCriterion("CBAA15 <=", value, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15In(List<Date> values) {
            addCriterion("CBAA15 in", values, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15NotIn(List<Date> values) {
            addCriterion("CBAA15 not in", values, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15Between(Date value1, Date value2) {
            addCriterion("CBAA15 between", value1, value2, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa15NotBetween(Date value1, Date value2) {
            addCriterion("CBAA15 not between", value1, value2, "cbaa15");
            return (Criteria) this;
        }

        public Criteria andCbaa16IsNull() {
            addCriterion("CBAA16 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa16IsNotNull() {
            addCriterion("CBAA16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa16EqualTo(Integer value) {
            addCriterion("CBAA16 =", value, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16NotEqualTo(Integer value) {
            addCriterion("CBAA16 <>", value, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16GreaterThan(Integer value) {
            addCriterion("CBAA16 >", value, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA16 >=", value, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16LessThan(Integer value) {
            addCriterion("CBAA16 <", value, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA16 <=", value, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16In(List<Integer> values) {
            addCriterion("CBAA16 in", values, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16NotIn(List<Integer> values) {
            addCriterion("CBAA16 not in", values, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16Between(Integer value1, Integer value2) {
            addCriterion("CBAA16 between", value1, value2, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA16 not between", value1, value2, "cbaa16");
            return (Criteria) this;
        }

        public Criteria andCbaa17IsNull() {
            addCriterion("CBAA17 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa17IsNotNull() {
            addCriterion("CBAA17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa17EqualTo(String value) {
            addCriterion("CBAA17 =", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17NotEqualTo(String value) {
            addCriterion("CBAA17 <>", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17GreaterThan(String value) {
            addCriterion("CBAA17 >", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17GreaterThanOrEqualTo(String value) {
            addCriterion("CBAA17 >=", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17LessThan(String value) {
            addCriterion("CBAA17 <", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17LessThanOrEqualTo(String value) {
            addCriterion("CBAA17 <=", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17Like(String value) {
            addCriterion("CBAA17 like", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17NotLike(String value) {
            addCriterion("CBAA17 not like", value, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17In(List<String> values) {
            addCriterion("CBAA17 in", values, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17NotIn(List<String> values) {
            addCriterion("CBAA17 not in", values, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17Between(String value1, String value2) {
            addCriterion("CBAA17 between", value1, value2, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa17NotBetween(String value1, String value2) {
            addCriterion("CBAA17 not between", value1, value2, "cbaa17");
            return (Criteria) this;
        }

        public Criteria andCbaa18IsNull() {
            addCriterion("CBAA18 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa18IsNotNull() {
            addCriterion("CBAA18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa18EqualTo(Integer value) {
            addCriterion("CBAA18 =", value, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18NotEqualTo(Integer value) {
            addCriterion("CBAA18 <>", value, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18GreaterThan(Integer value) {
            addCriterion("CBAA18 >", value, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA18 >=", value, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18LessThan(Integer value) {
            addCriterion("CBAA18 <", value, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA18 <=", value, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18In(List<Integer> values) {
            addCriterion("CBAA18 in", values, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18NotIn(List<Integer> values) {
            addCriterion("CBAA18 not in", values, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18Between(Integer value1, Integer value2) {
            addCriterion("CBAA18 between", value1, value2, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa18NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA18 not between", value1, value2, "cbaa18");
            return (Criteria) this;
        }

        public Criteria andCbaa19IsNull() {
            addCriterion("CBAA19 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa19IsNotNull() {
            addCriterion("CBAA19 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa19EqualTo(Integer value) {
            addCriterion("CBAA19 =", value, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19NotEqualTo(Integer value) {
            addCriterion("CBAA19 <>", value, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19GreaterThan(Integer value) {
            addCriterion("CBAA19 >", value, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA19 >=", value, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19LessThan(Integer value) {
            addCriterion("CBAA19 <", value, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA19 <=", value, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19In(List<Integer> values) {
            addCriterion("CBAA19 in", values, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19NotIn(List<Integer> values) {
            addCriterion("CBAA19 not in", values, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19Between(Integer value1, Integer value2) {
            addCriterion("CBAA19 between", value1, value2, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andCbaa19NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA19 not between", value1, value2, "cbaa19");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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
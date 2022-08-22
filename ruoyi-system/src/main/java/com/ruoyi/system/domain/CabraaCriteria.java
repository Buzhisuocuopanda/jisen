package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CabraaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CabraaCriteria() {
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

        public Criteria andCabraa01IsNull() {
            addCriterion("CABRAA01 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa01IsNotNull() {
            addCriterion("CABRAA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa01EqualTo(Integer value) {
            addCriterion("CABRAA01 =", value, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01NotEqualTo(Integer value) {
            addCriterion("CABRAA01 <>", value, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01GreaterThan(Integer value) {
            addCriterion("CABRAA01 >", value, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA01 >=", value, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01LessThan(Integer value) {
            addCriterion("CABRAA01 <", value, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA01 <=", value, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01In(List<Integer> values) {
            addCriterion("CABRAA01 in", values, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01NotIn(List<Integer> values) {
            addCriterion("CABRAA01 not in", values, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01Between(Integer value1, Integer value2) {
            addCriterion("CABRAA01 between", value1, value2, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA01 not between", value1, value2, "cabraa01");
            return (Criteria) this;
        }

        public Criteria andCabraa02IsNull() {
            addCriterion("CABRAA02 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa02IsNotNull() {
            addCriterion("CABRAA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa02EqualTo(Date value) {
            addCriterion("CABRAA02 =", value, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02NotEqualTo(Date value) {
            addCriterion("CABRAA02 <>", value, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02GreaterThan(Date value) {
            addCriterion("CABRAA02 >", value, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CABRAA02 >=", value, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02LessThan(Date value) {
            addCriterion("CABRAA02 <", value, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02LessThanOrEqualTo(Date value) {
            addCriterion("CABRAA02 <=", value, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02In(List<Date> values) {
            addCriterion("CABRAA02 in", values, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02NotIn(List<Date> values) {
            addCriterion("CABRAA02 not in", values, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02Between(Date value1, Date value2) {
            addCriterion("CABRAA02 between", value1, value2, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa02NotBetween(Date value1, Date value2) {
            addCriterion("CABRAA02 not between", value1, value2, "cabraa02");
            return (Criteria) this;
        }

        public Criteria andCabraa03IsNull() {
            addCriterion("CABRAA03 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa03IsNotNull() {
            addCriterion("CABRAA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa03EqualTo(Date value) {
            addCriterion("CABRAA03 =", value, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03NotEqualTo(Date value) {
            addCriterion("CABRAA03 <>", value, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03GreaterThan(Date value) {
            addCriterion("CABRAA03 >", value, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03GreaterThanOrEqualTo(Date value) {
            addCriterion("CABRAA03 >=", value, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03LessThan(Date value) {
            addCriterion("CABRAA03 <", value, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03LessThanOrEqualTo(Date value) {
            addCriterion("CABRAA03 <=", value, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03In(List<Date> values) {
            addCriterion("CABRAA03 in", values, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03NotIn(List<Date> values) {
            addCriterion("CABRAA03 not in", values, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03Between(Date value1, Date value2) {
            addCriterion("CABRAA03 between", value1, value2, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa03NotBetween(Date value1, Date value2) {
            addCriterion("CABRAA03 not between", value1, value2, "cabraa03");
            return (Criteria) this;
        }

        public Criteria andCabraa04IsNull() {
            addCriterion("CABRAA04 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa04IsNotNull() {
            addCriterion("CABRAA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa04EqualTo(Integer value) {
            addCriterion("CABRAA04 =", value, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04NotEqualTo(Integer value) {
            addCriterion("CABRAA04 <>", value, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04GreaterThan(Integer value) {
            addCriterion("CABRAA04 >", value, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA04 >=", value, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04LessThan(Integer value) {
            addCriterion("CABRAA04 <", value, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA04 <=", value, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04In(List<Integer> values) {
            addCriterion("CABRAA04 in", values, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04NotIn(List<Integer> values) {
            addCriterion("CABRAA04 not in", values, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04Between(Integer value1, Integer value2) {
            addCriterion("CABRAA04 between", value1, value2, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa04NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA04 not between", value1, value2, "cabraa04");
            return (Criteria) this;
        }

        public Criteria andCabraa05IsNull() {
            addCriterion("CABRAA05 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa05IsNotNull() {
            addCriterion("CABRAA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa05EqualTo(Integer value) {
            addCriterion("CABRAA05 =", value, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05NotEqualTo(Integer value) {
            addCriterion("CABRAA05 <>", value, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05GreaterThan(Integer value) {
            addCriterion("CABRAA05 >", value, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA05 >=", value, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05LessThan(Integer value) {
            addCriterion("CABRAA05 <", value, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA05 <=", value, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05In(List<Integer> values) {
            addCriterion("CABRAA05 in", values, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05NotIn(List<Integer> values) {
            addCriterion("CABRAA05 not in", values, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05Between(Integer value1, Integer value2) {
            addCriterion("CABRAA05 between", value1, value2, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA05 not between", value1, value2, "cabraa05");
            return (Criteria) this;
        }

        public Criteria andCabraa06IsNull() {
            addCriterion("CABRAA06 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa06IsNotNull() {
            addCriterion("CABRAA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa06EqualTo(Integer value) {
            addCriterion("CABRAA06 =", value, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06NotEqualTo(Integer value) {
            addCriterion("CABRAA06 <>", value, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06GreaterThan(Integer value) {
            addCriterion("CABRAA06 >", value, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA06 >=", value, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06LessThan(Integer value) {
            addCriterion("CABRAA06 <", value, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA06 <=", value, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06In(List<Integer> values) {
            addCriterion("CABRAA06 in", values, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06NotIn(List<Integer> values) {
            addCriterion("CABRAA06 not in", values, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06Between(Integer value1, Integer value2) {
            addCriterion("CABRAA06 between", value1, value2, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA06 not between", value1, value2, "cabraa06");
            return (Criteria) this;
        }

        public Criteria andCabraa07IsNull() {
            addCriterion("CABRAA07 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa07IsNotNull() {
            addCriterion("CABRAA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa07EqualTo(String value) {
            addCriterion("CABRAA07 =", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07NotEqualTo(String value) {
            addCriterion("CABRAA07 <>", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07GreaterThan(String value) {
            addCriterion("CABRAA07 >", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA07 >=", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07LessThan(String value) {
            addCriterion("CABRAA07 <", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07LessThanOrEqualTo(String value) {
            addCriterion("CABRAA07 <=", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07Like(String value) {
            addCriterion("CABRAA07 like", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07NotLike(String value) {
            addCriterion("CABRAA07 not like", value, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07In(List<String> values) {
            addCriterion("CABRAA07 in", values, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07NotIn(List<String> values) {
            addCriterion("CABRAA07 not in", values, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07Between(String value1, String value2) {
            addCriterion("CABRAA07 between", value1, value2, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa07NotBetween(String value1, String value2) {
            addCriterion("CABRAA07 not between", value1, value2, "cabraa07");
            return (Criteria) this;
        }

        public Criteria andCabraa08IsNull() {
            addCriterion("CABRAA08 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa08IsNotNull() {
            addCriterion("CABRAA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa08EqualTo(Integer value) {
            addCriterion("CABRAA08 =", value, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08NotEqualTo(Integer value) {
            addCriterion("CABRAA08 <>", value, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08GreaterThan(Integer value) {
            addCriterion("CABRAA08 >", value, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA08 >=", value, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08LessThan(Integer value) {
            addCriterion("CABRAA08 <", value, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA08 <=", value, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08In(List<Integer> values) {
            addCriterion("CABRAA08 in", values, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08NotIn(List<Integer> values) {
            addCriterion("CABRAA08 not in", values, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08Between(Integer value1, Integer value2) {
            addCriterion("CABRAA08 between", value1, value2, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa08NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA08 not between", value1, value2, "cabraa08");
            return (Criteria) this;
        }

        public Criteria andCabraa09IsNull() {
            addCriterion("CABRAA09 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa09IsNotNull() {
            addCriterion("CABRAA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa09EqualTo(String value) {
            addCriterion("CABRAA09 =", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09NotEqualTo(String value) {
            addCriterion("CABRAA09 <>", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09GreaterThan(String value) {
            addCriterion("CABRAA09 >", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA09 >=", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09LessThan(String value) {
            addCriterion("CABRAA09 <", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09LessThanOrEqualTo(String value) {
            addCriterion("CABRAA09 <=", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09Like(String value) {
            addCriterion("CABRAA09 like", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09NotLike(String value) {
            addCriterion("CABRAA09 not like", value, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09In(List<String> values) {
            addCriterion("CABRAA09 in", values, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09NotIn(List<String> values) {
            addCriterion("CABRAA09 not in", values, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09Between(String value1, String value2) {
            addCriterion("CABRAA09 between", value1, value2, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa09NotBetween(String value1, String value2) {
            addCriterion("CABRAA09 not between", value1, value2, "cabraa09");
            return (Criteria) this;
        }

        public Criteria andCabraa10IsNull() {
            addCriterion("CABRAA10 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa10IsNotNull() {
            addCriterion("CABRAA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa10EqualTo(String value) {
            addCriterion("CABRAA10 =", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10NotEqualTo(String value) {
            addCriterion("CABRAA10 <>", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10GreaterThan(String value) {
            addCriterion("CABRAA10 >", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA10 >=", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10LessThan(String value) {
            addCriterion("CABRAA10 <", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10LessThanOrEqualTo(String value) {
            addCriterion("CABRAA10 <=", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10Like(String value) {
            addCriterion("CABRAA10 like", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10NotLike(String value) {
            addCriterion("CABRAA10 not like", value, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10In(List<String> values) {
            addCriterion("CABRAA10 in", values, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10NotIn(List<String> values) {
            addCriterion("CABRAA10 not in", values, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10Between(String value1, String value2) {
            addCriterion("CABRAA10 between", value1, value2, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa10NotBetween(String value1, String value2) {
            addCriterion("CABRAA10 not between", value1, value2, "cabraa10");
            return (Criteria) this;
        }

        public Criteria andCabraa11IsNull() {
            addCriterion("CABRAA11 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa11IsNotNull() {
            addCriterion("CABRAA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa11EqualTo(Integer value) {
            addCriterion("CABRAA11 =", value, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11NotEqualTo(Integer value) {
            addCriterion("CABRAA11 <>", value, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11GreaterThan(Integer value) {
            addCriterion("CABRAA11 >", value, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA11 >=", value, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11LessThan(Integer value) {
            addCriterion("CABRAA11 <", value, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA11 <=", value, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11In(List<Integer> values) {
            addCriterion("CABRAA11 in", values, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11NotIn(List<Integer> values) {
            addCriterion("CABRAA11 not in", values, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11Between(Integer value1, Integer value2) {
            addCriterion("CABRAA11 between", value1, value2, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa11NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA11 not between", value1, value2, "cabraa11");
            return (Criteria) this;
        }

        public Criteria andCabraa12IsNull() {
            addCriterion("CABRAA12 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa12IsNotNull() {
            addCriterion("CABRAA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa12EqualTo(Date value) {
            addCriterion("CABRAA12 =", value, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12NotEqualTo(Date value) {
            addCriterion("CABRAA12 <>", value, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12GreaterThan(Date value) {
            addCriterion("CABRAA12 >", value, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12GreaterThanOrEqualTo(Date value) {
            addCriterion("CABRAA12 >=", value, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12LessThan(Date value) {
            addCriterion("CABRAA12 <", value, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12LessThanOrEqualTo(Date value) {
            addCriterion("CABRAA12 <=", value, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12In(List<Date> values) {
            addCriterion("CABRAA12 in", values, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12NotIn(List<Date> values) {
            addCriterion("CABRAA12 not in", values, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12Between(Date value1, Date value2) {
            addCriterion("CABRAA12 between", value1, value2, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa12NotBetween(Date value1, Date value2) {
            addCriterion("CABRAA12 not between", value1, value2, "cabraa12");
            return (Criteria) this;
        }

        public Criteria andCabraa13IsNull() {
            addCriterion("CABRAA13 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa13IsNotNull() {
            addCriterion("CABRAA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa13EqualTo(Integer value) {
            addCriterion("CABRAA13 =", value, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13NotEqualTo(Integer value) {
            addCriterion("CABRAA13 <>", value, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13GreaterThan(Integer value) {
            addCriterion("CABRAA13 >", value, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA13 >=", value, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13LessThan(Integer value) {
            addCriterion("CABRAA13 <", value, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA13 <=", value, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13In(List<Integer> values) {
            addCriterion("CABRAA13 in", values, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13NotIn(List<Integer> values) {
            addCriterion("CABRAA13 not in", values, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13Between(Integer value1, Integer value2) {
            addCriterion("CABRAA13 between", value1, value2, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa13NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA13 not between", value1, value2, "cabraa13");
            return (Criteria) this;
        }

        public Criteria andCabraa14IsNull() {
            addCriterion("CABRAA14 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa14IsNotNull() {
            addCriterion("CABRAA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa14EqualTo(String value) {
            addCriterion("CABRAA14 =", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14NotEqualTo(String value) {
            addCriterion("CABRAA14 <>", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14GreaterThan(String value) {
            addCriterion("CABRAA14 >", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA14 >=", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14LessThan(String value) {
            addCriterion("CABRAA14 <", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14LessThanOrEqualTo(String value) {
            addCriterion("CABRAA14 <=", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14Like(String value) {
            addCriterion("CABRAA14 like", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14NotLike(String value) {
            addCriterion("CABRAA14 not like", value, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14In(List<String> values) {
            addCriterion("CABRAA14 in", values, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14NotIn(List<String> values) {
            addCriterion("CABRAA14 not in", values, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14Between(String value1, String value2) {
            addCriterion("CABRAA14 between", value1, value2, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa14NotBetween(String value1, String value2) {
            addCriterion("CABRAA14 not between", value1, value2, "cabraa14");
            return (Criteria) this;
        }

        public Criteria andCabraa15IsNull() {
            addCriterion("CABRAA15 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa15IsNotNull() {
            addCriterion("CABRAA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa15EqualTo(Date value) {
            addCriterion("CABRAA15 =", value, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15NotEqualTo(Date value) {
            addCriterion("CABRAA15 <>", value, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15GreaterThan(Date value) {
            addCriterion("CABRAA15 >", value, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15GreaterThanOrEqualTo(Date value) {
            addCriterion("CABRAA15 >=", value, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15LessThan(Date value) {
            addCriterion("CABRAA15 <", value, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15LessThanOrEqualTo(Date value) {
            addCriterion("CABRAA15 <=", value, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15In(List<Date> values) {
            addCriterion("CABRAA15 in", values, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15NotIn(List<Date> values) {
            addCriterion("CABRAA15 not in", values, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15Between(Date value1, Date value2) {
            addCriterion("CABRAA15 between", value1, value2, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa15NotBetween(Date value1, Date value2) {
            addCriterion("CABRAA15 not between", value1, value2, "cabraa15");
            return (Criteria) this;
        }

        public Criteria andCabraa16IsNull() {
            addCriterion("CABRAA16 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa16IsNotNull() {
            addCriterion("CABRAA16 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa16EqualTo(Integer value) {
            addCriterion("CABRAA16 =", value, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16NotEqualTo(Integer value) {
            addCriterion("CABRAA16 <>", value, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16GreaterThan(Integer value) {
            addCriterion("CABRAA16 >", value, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA16 >=", value, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16LessThan(Integer value) {
            addCriterion("CABRAA16 <", value, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA16 <=", value, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16In(List<Integer> values) {
            addCriterion("CABRAA16 in", values, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16NotIn(List<Integer> values) {
            addCriterion("CABRAA16 not in", values, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16Between(Integer value1, Integer value2) {
            addCriterion("CABRAA16 between", value1, value2, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa16NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA16 not between", value1, value2, "cabraa16");
            return (Criteria) this;
        }

        public Criteria andCabraa17IsNull() {
            addCriterion("CABRAA17 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa17IsNotNull() {
            addCriterion("CABRAA17 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa17EqualTo(Integer value) {
            addCriterion("CABRAA17 =", value, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17NotEqualTo(Integer value) {
            addCriterion("CABRAA17 <>", value, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17GreaterThan(Integer value) {
            addCriterion("CABRAA17 >", value, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA17 >=", value, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17LessThan(Integer value) {
            addCriterion("CABRAA17 <", value, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA17 <=", value, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17In(List<Integer> values) {
            addCriterion("CABRAA17 in", values, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17NotIn(List<Integer> values) {
            addCriterion("CABRAA17 not in", values, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17Between(Integer value1, Integer value2) {
            addCriterion("CABRAA17 between", value1, value2, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa17NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA17 not between", value1, value2, "cabraa17");
            return (Criteria) this;
        }

        public Criteria andCabraa18IsNull() {
            addCriterion("CABRAA18 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa18IsNotNull() {
            addCriterion("CABRAA18 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa18EqualTo(String value) {
            addCriterion("CABRAA18 =", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18NotEqualTo(String value) {
            addCriterion("CABRAA18 <>", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18GreaterThan(String value) {
            addCriterion("CABRAA18 >", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA18 >=", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18LessThan(String value) {
            addCriterion("CABRAA18 <", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18LessThanOrEqualTo(String value) {
            addCriterion("CABRAA18 <=", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18Like(String value) {
            addCriterion("CABRAA18 like", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18NotLike(String value) {
            addCriterion("CABRAA18 not like", value, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18In(List<String> values) {
            addCriterion("CABRAA18 in", values, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18NotIn(List<String> values) {
            addCriterion("CABRAA18 not in", values, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18Between(String value1, String value2) {
            addCriterion("CABRAA18 between", value1, value2, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa18NotBetween(String value1, String value2) {
            addCriterion("CABRAA18 not between", value1, value2, "cabraa18");
            return (Criteria) this;
        }

        public Criteria andCabraa19IsNull() {
            addCriterion("CABRAA19 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa19IsNotNull() {
            addCriterion("CABRAA19 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa19EqualTo(String value) {
            addCriterion("CABRAA19 =", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19NotEqualTo(String value) {
            addCriterion("CABRAA19 <>", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19GreaterThan(String value) {
            addCriterion("CABRAA19 >", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA19 >=", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19LessThan(String value) {
            addCriterion("CABRAA19 <", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19LessThanOrEqualTo(String value) {
            addCriterion("CABRAA19 <=", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19Like(String value) {
            addCriterion("CABRAA19 like", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19NotLike(String value) {
            addCriterion("CABRAA19 not like", value, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19In(List<String> values) {
            addCriterion("CABRAA19 in", values, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19NotIn(List<String> values) {
            addCriterion("CABRAA19 not in", values, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19Between(String value1, String value2) {
            addCriterion("CABRAA19 between", value1, value2, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa19NotBetween(String value1, String value2) {
            addCriterion("CABRAA19 not between", value1, value2, "cabraa19");
            return (Criteria) this;
        }

        public Criteria andCabraa20IsNull() {
            addCriterion("CABRAA20 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa20IsNotNull() {
            addCriterion("CABRAA20 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa20EqualTo(Integer value) {
            addCriterion("CABRAA20 =", value, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20NotEqualTo(Integer value) {
            addCriterion("CABRAA20 <>", value, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20GreaterThan(Integer value) {
            addCriterion("CABRAA20 >", value, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20GreaterThanOrEqualTo(Integer value) {
            addCriterion("CABRAA20 >=", value, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20LessThan(Integer value) {
            addCriterion("CABRAA20 <", value, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20LessThanOrEqualTo(Integer value) {
            addCriterion("CABRAA20 <=", value, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20In(List<Integer> values) {
            addCriterion("CABRAA20 in", values, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20NotIn(List<Integer> values) {
            addCriterion("CABRAA20 not in", values, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20Between(Integer value1, Integer value2) {
            addCriterion("CABRAA20 between", value1, value2, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa20NotBetween(Integer value1, Integer value2) {
            addCriterion("CABRAA20 not between", value1, value2, "cabraa20");
            return (Criteria) this;
        }

        public Criteria andCabraa21IsNull() {
            addCriterion("CABRAA21 is null");
            return (Criteria) this;
        }

        public Criteria andCabraa21IsNotNull() {
            addCriterion("CABRAA21 is not null");
            return (Criteria) this;
        }

        public Criteria andCabraa21EqualTo(String value) {
            addCriterion("CABRAA21 =", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21NotEqualTo(String value) {
            addCriterion("CABRAA21 <>", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21GreaterThan(String value) {
            addCriterion("CABRAA21 >", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21GreaterThanOrEqualTo(String value) {
            addCriterion("CABRAA21 >=", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21LessThan(String value) {
            addCriterion("CABRAA21 <", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21LessThanOrEqualTo(String value) {
            addCriterion("CABRAA21 <=", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21Like(String value) {
            addCriterion("CABRAA21 like", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21NotLike(String value) {
            addCriterion("CABRAA21 not like", value, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21In(List<String> values) {
            addCriterion("CABRAA21 in", values, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21NotIn(List<String> values) {
            addCriterion("CABRAA21 not in", values, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21Between(String value1, String value2) {
            addCriterion("CABRAA21 between", value1, value2, "cabraa21");
            return (Criteria) this;
        }

        public Criteria andCabraa21NotBetween(String value1, String value2) {
            addCriterion("CABRAA21 not between", value1, value2, "cabraa21");
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
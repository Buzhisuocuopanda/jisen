package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbbaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbbaCriteria() {
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

        public Criteria andCbba01IsNull() {
            addCriterion("CBBA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbba01IsNotNull() {
            addCriterion("CBBA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba01EqualTo(Integer value) {
            addCriterion("CBBA01 =", value, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01NotEqualTo(Integer value) {
            addCriterion("CBBA01 <>", value, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01GreaterThan(Integer value) {
            addCriterion("CBBA01 >", value, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA01 >=", value, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01LessThan(Integer value) {
            addCriterion("CBBA01 <", value, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA01 <=", value, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01In(List<Integer> values) {
            addCriterion("CBBA01 in", values, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01NotIn(List<Integer> values) {
            addCriterion("CBBA01 not in", values, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01Between(Integer value1, Integer value2) {
            addCriterion("CBBA01 between", value1, value2, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA01 not between", value1, value2, "cbba01");
            return (Criteria) this;
        }

        public Criteria andCbba02IsNull() {
            addCriterion("CBBA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbba02IsNotNull() {
            addCriterion("CBBA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba02EqualTo(Date value) {
            addCriterion("CBBA02 =", value, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02NotEqualTo(Date value) {
            addCriterion("CBBA02 <>", value, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02GreaterThan(Date value) {
            addCriterion("CBBA02 >", value, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBBA02 >=", value, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02LessThan(Date value) {
            addCriterion("CBBA02 <", value, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02LessThanOrEqualTo(Date value) {
            addCriterion("CBBA02 <=", value, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02In(List<Date> values) {
            addCriterion("CBBA02 in", values, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02NotIn(List<Date> values) {
            addCriterion("CBBA02 not in", values, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02Between(Date value1, Date value2) {
            addCriterion("CBBA02 between", value1, value2, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba02NotBetween(Date value1, Date value2) {
            addCriterion("CBBA02 not between", value1, value2, "cbba02");
            return (Criteria) this;
        }

        public Criteria andCbba03IsNull() {
            addCriterion("CBBA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbba03IsNotNull() {
            addCriterion("CBBA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba03EqualTo(Integer value) {
            addCriterion("CBBA03 =", value, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03NotEqualTo(Integer value) {
            addCriterion("CBBA03 <>", value, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03GreaterThan(Integer value) {
            addCriterion("CBBA03 >", value, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA03 >=", value, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03LessThan(Integer value) {
            addCriterion("CBBA03 <", value, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA03 <=", value, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03In(List<Integer> values) {
            addCriterion("CBBA03 in", values, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03NotIn(List<Integer> values) {
            addCriterion("CBBA03 not in", values, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03Between(Integer value1, Integer value2) {
            addCriterion("CBBA03 between", value1, value2, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA03 not between", value1, value2, "cbba03");
            return (Criteria) this;
        }

        public Criteria andCbba04IsNull() {
            addCriterion("CBBA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbba04IsNotNull() {
            addCriterion("CBBA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba04EqualTo(Date value) {
            addCriterion("CBBA04 =", value, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04NotEqualTo(Date value) {
            addCriterion("CBBA04 <>", value, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04GreaterThan(Date value) {
            addCriterion("CBBA04 >", value, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBBA04 >=", value, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04LessThan(Date value) {
            addCriterion("CBBA04 <", value, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04LessThanOrEqualTo(Date value) {
            addCriterion("CBBA04 <=", value, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04In(List<Date> values) {
            addCriterion("CBBA04 in", values, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04NotIn(List<Date> values) {
            addCriterion("CBBA04 not in", values, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04Between(Date value1, Date value2) {
            addCriterion("CBBA04 between", value1, value2, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba04NotBetween(Date value1, Date value2) {
            addCriterion("CBBA04 not between", value1, value2, "cbba04");
            return (Criteria) this;
        }

        public Criteria andCbba05IsNull() {
            addCriterion("CBBA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbba05IsNotNull() {
            addCriterion("CBBA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba05EqualTo(Integer value) {
            addCriterion("CBBA05 =", value, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05NotEqualTo(Integer value) {
            addCriterion("CBBA05 <>", value, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05GreaterThan(Integer value) {
            addCriterion("CBBA05 >", value, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA05 >=", value, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05LessThan(Integer value) {
            addCriterion("CBBA05 <", value, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA05 <=", value, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05In(List<Integer> values) {
            addCriterion("CBBA05 in", values, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05NotIn(List<Integer> values) {
            addCriterion("CBBA05 not in", values, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05Between(Integer value1, Integer value2) {
            addCriterion("CBBA05 between", value1, value2, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA05 not between", value1, value2, "cbba05");
            return (Criteria) this;
        }

        public Criteria andCbba06IsNull() {
            addCriterion("CBBA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbba06IsNotNull() {
            addCriterion("CBBA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba06EqualTo(Integer value) {
            addCriterion("CBBA06 =", value, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06NotEqualTo(Integer value) {
            addCriterion("CBBA06 <>", value, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06GreaterThan(Integer value) {
            addCriterion("CBBA06 >", value, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA06 >=", value, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06LessThan(Integer value) {
            addCriterion("CBBA06 <", value, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA06 <=", value, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06In(List<Integer> values) {
            addCriterion("CBBA06 in", values, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06NotIn(List<Integer> values) {
            addCriterion("CBBA06 not in", values, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06Between(Integer value1, Integer value2) {
            addCriterion("CBBA06 between", value1, value2, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA06 not between", value1, value2, "cbba06");
            return (Criteria) this;
        }

        public Criteria andCbba07IsNull() {
            addCriterion("CBBA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbba07IsNotNull() {
            addCriterion("CBBA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba07EqualTo(String value) {
            addCriterion("CBBA07 =", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07NotEqualTo(String value) {
            addCriterion("CBBA07 <>", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07GreaterThan(String value) {
            addCriterion("CBBA07 >", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07GreaterThanOrEqualTo(String value) {
            addCriterion("CBBA07 >=", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07LessThan(String value) {
            addCriterion("CBBA07 <", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07LessThanOrEqualTo(String value) {
            addCriterion("CBBA07 <=", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07Like(String value) {
            addCriterion("CBBA07 like", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07NotLike(String value) {
            addCriterion("CBBA07 not like", value, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07In(List<String> values) {
            addCriterion("CBBA07 in", values, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07NotIn(List<String> values) {
            addCriterion("CBBA07 not in", values, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07Between(String value1, String value2) {
            addCriterion("CBBA07 between", value1, value2, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba07NotBetween(String value1, String value2) {
            addCriterion("CBBA07 not between", value1, value2, "cbba07");
            return (Criteria) this;
        }

        public Criteria andCbba08IsNull() {
            addCriterion("CBBA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbba08IsNotNull() {
            addCriterion("CBBA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba08EqualTo(Integer value) {
            addCriterion("CBBA08 =", value, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08NotEqualTo(Integer value) {
            addCriterion("CBBA08 <>", value, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08GreaterThan(Integer value) {
            addCriterion("CBBA08 >", value, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA08 >=", value, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08LessThan(Integer value) {
            addCriterion("CBBA08 <", value, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA08 <=", value, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08In(List<Integer> values) {
            addCriterion("CBBA08 in", values, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08NotIn(List<Integer> values) {
            addCriterion("CBBA08 not in", values, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08Between(Integer value1, Integer value2) {
            addCriterion("CBBA08 between", value1, value2, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA08 not between", value1, value2, "cbba08");
            return (Criteria) this;
        }

        public Criteria andCbba09IsNull() {
            addCriterion("CBBA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbba09IsNotNull() {
            addCriterion("CBBA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba09EqualTo(Double value) {
            addCriterion("CBBA09 =", value, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09NotEqualTo(Double value) {
            addCriterion("CBBA09 <>", value, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09GreaterThan(Double value) {
            addCriterion("CBBA09 >", value, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBBA09 >=", value, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09LessThan(Double value) {
            addCriterion("CBBA09 <", value, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09LessThanOrEqualTo(Double value) {
            addCriterion("CBBA09 <=", value, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09In(List<Double> values) {
            addCriterion("CBBA09 in", values, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09NotIn(List<Double> values) {
            addCriterion("CBBA09 not in", values, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09Between(Double value1, Double value2) {
            addCriterion("CBBA09 between", value1, value2, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba09NotBetween(Double value1, Double value2) {
            addCriterion("CBBA09 not between", value1, value2, "cbba09");
            return (Criteria) this;
        }

        public Criteria andCbba10IsNull() {
            addCriterion("CBBA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbba10IsNotNull() {
            addCriterion("CBBA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba10EqualTo(Integer value) {
            addCriterion("CBBA10 =", value, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10NotEqualTo(Integer value) {
            addCriterion("CBBA10 <>", value, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10GreaterThan(Integer value) {
            addCriterion("CBBA10 >", value, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA10 >=", value, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10LessThan(Integer value) {
            addCriterion("CBBA10 <", value, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA10 <=", value, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10In(List<Integer> values) {
            addCriterion("CBBA10 in", values, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10NotIn(List<Integer> values) {
            addCriterion("CBBA10 not in", values, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10Between(Integer value1, Integer value2) {
            addCriterion("CBBA10 between", value1, value2, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA10 not between", value1, value2, "cbba10");
            return (Criteria) this;
        }

        public Criteria andCbba11IsNull() {
            addCriterion("CBBA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbba11IsNotNull() {
            addCriterion("CBBA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba11EqualTo(Double value) {
            addCriterion("CBBA11 =", value, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11NotEqualTo(Double value) {
            addCriterion("CBBA11 <>", value, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11GreaterThan(Double value) {
            addCriterion("CBBA11 >", value, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBBA11 >=", value, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11LessThan(Double value) {
            addCriterion("CBBA11 <", value, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11LessThanOrEqualTo(Double value) {
            addCriterion("CBBA11 <=", value, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11In(List<Double> values) {
            addCriterion("CBBA11 in", values, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11NotIn(List<Double> values) {
            addCriterion("CBBA11 not in", values, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11Between(Double value1, Double value2) {
            addCriterion("CBBA11 between", value1, value2, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba11NotBetween(Double value1, Double value2) {
            addCriterion("CBBA11 not between", value1, value2, "cbba11");
            return (Criteria) this;
        }

        public Criteria andCbba12IsNull() {
            addCriterion("CBBA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbba12IsNotNull() {
            addCriterion("CBBA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba12EqualTo(Integer value) {
            addCriterion("CBBA12 =", value, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12NotEqualTo(Integer value) {
            addCriterion("CBBA12 <>", value, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12GreaterThan(Integer value) {
            addCriterion("CBBA12 >", value, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBBA12 >=", value, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12LessThan(Integer value) {
            addCriterion("CBBA12 <", value, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12LessThanOrEqualTo(Integer value) {
            addCriterion("CBBA12 <=", value, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12In(List<Integer> values) {
            addCriterion("CBBA12 in", values, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12NotIn(List<Integer> values) {
            addCriterion("CBBA12 not in", values, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12Between(Integer value1, Integer value2) {
            addCriterion("CBBA12 between", value1, value2, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBBA12 not between", value1, value2, "cbba12");
            return (Criteria) this;
        }

        public Criteria andCbba13IsNull() {
            addCriterion("CBBA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbba13IsNotNull() {
            addCriterion("CBBA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba13EqualTo(Double value) {
            addCriterion("CBBA13 =", value, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13NotEqualTo(Double value) {
            addCriterion("CBBA13 <>", value, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13GreaterThan(Double value) {
            addCriterion("CBBA13 >", value, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13GreaterThanOrEqualTo(Double value) {
            addCriterion("CBBA13 >=", value, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13LessThan(Double value) {
            addCriterion("CBBA13 <", value, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13LessThanOrEqualTo(Double value) {
            addCriterion("CBBA13 <=", value, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13In(List<Double> values) {
            addCriterion("CBBA13 in", values, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13NotIn(List<Double> values) {
            addCriterion("CBBA13 not in", values, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13Between(Double value1, Double value2) {
            addCriterion("CBBA13 between", value1, value2, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba13NotBetween(Double value1, Double value2) {
            addCriterion("CBBA13 not between", value1, value2, "cbba13");
            return (Criteria) this;
        }

        public Criteria andCbba14IsNull() {
            addCriterion("CBBA14 is null");
            return (Criteria) this;
        }

        public Criteria andCbba14IsNotNull() {
            addCriterion("CBBA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba14EqualTo(Double value) {
            addCriterion("CBBA14 =", value, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14NotEqualTo(Double value) {
            addCriterion("CBBA14 <>", value, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14GreaterThan(Double value) {
            addCriterion("CBBA14 >", value, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14GreaterThanOrEqualTo(Double value) {
            addCriterion("CBBA14 >=", value, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14LessThan(Double value) {
            addCriterion("CBBA14 <", value, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14LessThanOrEqualTo(Double value) {
            addCriterion("CBBA14 <=", value, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14In(List<Double> values) {
            addCriterion("CBBA14 in", values, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14NotIn(List<Double> values) {
            addCriterion("CBBA14 not in", values, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14Between(Double value1, Double value2) {
            addCriterion("CBBA14 between", value1, value2, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba14NotBetween(Double value1, Double value2) {
            addCriterion("CBBA14 not between", value1, value2, "cbba14");
            return (Criteria) this;
        }

        public Criteria andCbba15IsNull() {
            addCriterion("CBBA15 is null");
            return (Criteria) this;
        }

        public Criteria andCbba15IsNotNull() {
            addCriterion("CBBA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbba15EqualTo(Long value) {
            addCriterion("CBBA15 =", value, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15NotEqualTo(Long value) {
            addCriterion("CBBA15 <>", value, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15GreaterThan(Long value) {
            addCriterion("CBBA15 >", value, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15GreaterThanOrEqualTo(Long value) {
            addCriterion("CBBA15 >=", value, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15LessThan(Long value) {
            addCriterion("CBBA15 <", value, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15LessThanOrEqualTo(Long value) {
            addCriterion("CBBA15 <=", value, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15In(List<Long> values) {
            addCriterion("CBBA15 in", values, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15NotIn(List<Long> values) {
            addCriterion("CBBA15 not in", values, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15Between(Long value1, Long value2) {
            addCriterion("CBBA15 between", value1, value2, "cbba15");
            return (Criteria) this;
        }

        public Criteria andCbba15NotBetween(Long value1, Long value2) {
            addCriterion("CBBA15 not between", value1, value2, "cbba15");
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
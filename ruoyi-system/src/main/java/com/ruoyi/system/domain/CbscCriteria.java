package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbscCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbscCriteria() {
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

        public Criteria andCbsc01IsNull() {
            addCriterion("CBSC01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc01IsNotNull() {
            addCriterion("CBSC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc01EqualTo(Integer value) {
            addCriterion("CBSC01 =", value, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01NotEqualTo(Integer value) {
            addCriterion("CBSC01 <>", value, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01GreaterThan(Integer value) {
            addCriterion("CBSC01 >", value, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC01 >=", value, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01LessThan(Integer value) {
            addCriterion("CBSC01 <", value, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC01 <=", value, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01In(List<Integer> values) {
            addCriterion("CBSC01 in", values, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01NotIn(List<Integer> values) {
            addCriterion("CBSC01 not in", values, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01Between(Integer value1, Integer value2) {
            addCriterion("CBSC01 between", value1, value2, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC01 not between", value1, value2, "cbsc01");
            return (Criteria) this;
        }

        public Criteria andCbsc02IsNull() {
            addCriterion("CBSC02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc02IsNotNull() {
            addCriterion("CBSC02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc02EqualTo(Integer value) {
            addCriterion("CBSC02 =", value, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02NotEqualTo(Integer value) {
            addCriterion("CBSC02 <>", value, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02GreaterThan(Integer value) {
            addCriterion("CBSC02 >", value, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC02 >=", value, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02LessThan(Integer value) {
            addCriterion("CBSC02 <", value, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC02 <=", value, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02In(List<Integer> values) {
            addCriterion("CBSC02 in", values, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02NotIn(List<Integer> values) {
            addCriterion("CBSC02 not in", values, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02Between(Integer value1, Integer value2) {
            addCriterion("CBSC02 between", value1, value2, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC02 not between", value1, value2, "cbsc02");
            return (Criteria) this;
        }

        public Criteria andCbsc03IsNull() {
            addCriterion("CBSC03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc03IsNotNull() {
            addCriterion("CBSC03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc03EqualTo(Date value) {
            addCriterion("CBSC03 =", value, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03NotEqualTo(Date value) {
            addCriterion("CBSC03 <>", value, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03GreaterThan(Date value) {
            addCriterion("CBSC03 >", value, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSC03 >=", value, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03LessThan(Date value) {
            addCriterion("CBSC03 <", value, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03LessThanOrEqualTo(Date value) {
            addCriterion("CBSC03 <=", value, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03In(List<Date> values) {
            addCriterion("CBSC03 in", values, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03NotIn(List<Date> values) {
            addCriterion("CBSC03 not in", values, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03Between(Date value1, Date value2) {
            addCriterion("CBSC03 between", value1, value2, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc03NotBetween(Date value1, Date value2) {
            addCriterion("CBSC03 not between", value1, value2, "cbsc03");
            return (Criteria) this;
        }

        public Criteria andCbsc04IsNull() {
            addCriterion("CBSC04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc04IsNotNull() {
            addCriterion("CBSC04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc04EqualTo(Integer value) {
            addCriterion("CBSC04 =", value, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04NotEqualTo(Integer value) {
            addCriterion("CBSC04 <>", value, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04GreaterThan(Integer value) {
            addCriterion("CBSC04 >", value, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC04 >=", value, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04LessThan(Integer value) {
            addCriterion("CBSC04 <", value, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC04 <=", value, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04In(List<Integer> values) {
            addCriterion("CBSC04 in", values, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04NotIn(List<Integer> values) {
            addCriterion("CBSC04 not in", values, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04Between(Integer value1, Integer value2) {
            addCriterion("CBSC04 between", value1, value2, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC04 not between", value1, value2, "cbsc04");
            return (Criteria) this;
        }

        public Criteria andCbsc05IsNull() {
            addCriterion("CBSC05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc05IsNotNull() {
            addCriterion("CBSC05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc05EqualTo(Date value) {
            addCriterion("CBSC05 =", value, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05NotEqualTo(Date value) {
            addCriterion("CBSC05 <>", value, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05GreaterThan(Date value) {
            addCriterion("CBSC05 >", value, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSC05 >=", value, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05LessThan(Date value) {
            addCriterion("CBSC05 <", value, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05LessThanOrEqualTo(Date value) {
            addCriterion("CBSC05 <=", value, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05In(List<Date> values) {
            addCriterion("CBSC05 in", values, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05NotIn(List<Date> values) {
            addCriterion("CBSC05 not in", values, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05Between(Date value1, Date value2) {
            addCriterion("CBSC05 between", value1, value2, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc05NotBetween(Date value1, Date value2) {
            addCriterion("CBSC05 not between", value1, value2, "cbsc05");
            return (Criteria) this;
        }

        public Criteria andCbsc06IsNull() {
            addCriterion("CBSC06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc06IsNotNull() {
            addCriterion("CBSC06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc06EqualTo(Integer value) {
            addCriterion("CBSC06 =", value, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06NotEqualTo(Integer value) {
            addCriterion("CBSC06 <>", value, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06GreaterThan(Integer value) {
            addCriterion("CBSC06 >", value, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC06 >=", value, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06LessThan(Integer value) {
            addCriterion("CBSC06 <", value, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC06 <=", value, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06In(List<Integer> values) {
            addCriterion("CBSC06 in", values, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06NotIn(List<Integer> values) {
            addCriterion("CBSC06 not in", values, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06Between(Integer value1, Integer value2) {
            addCriterion("CBSC06 between", value1, value2, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC06 not between", value1, value2, "cbsc06");
            return (Criteria) this;
        }

        public Criteria andCbsc07IsNull() {
            addCriterion("CBSC07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc07IsNotNull() {
            addCriterion("CBSC07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc07EqualTo(Integer value) {
            addCriterion("CBSC07 =", value, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07NotEqualTo(Integer value) {
            addCriterion("CBSC07 <>", value, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07GreaterThan(Integer value) {
            addCriterion("CBSC07 >", value, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC07 >=", value, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07LessThan(Integer value) {
            addCriterion("CBSC07 <", value, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC07 <=", value, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07In(List<Integer> values) {
            addCriterion("CBSC07 in", values, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07NotIn(List<Integer> values) {
            addCriterion("CBSC07 not in", values, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07Between(Integer value1, Integer value2) {
            addCriterion("CBSC07 between", value1, value2, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC07 not between", value1, value2, "cbsc07");
            return (Criteria) this;
        }

        public Criteria andCbsc08IsNull() {
            addCriterion("CBSC08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc08IsNotNull() {
            addCriterion("CBSC08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc08EqualTo(Integer value) {
            addCriterion("CBSC08 =", value, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08NotEqualTo(Integer value) {
            addCriterion("CBSC08 <>", value, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08GreaterThan(Integer value) {
            addCriterion("CBSC08 >", value, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC08 >=", value, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08LessThan(Integer value) {
            addCriterion("CBSC08 <", value, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC08 <=", value, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08In(List<Integer> values) {
            addCriterion("CBSC08 in", values, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08NotIn(List<Integer> values) {
            addCriterion("CBSC08 not in", values, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08Between(Integer value1, Integer value2) {
            addCriterion("CBSC08 between", value1, value2, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC08 not between", value1, value2, "cbsc08");
            return (Criteria) this;
        }

        public Criteria andCbsc09IsNull() {
            addCriterion("CBSC09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc09IsNotNull() {
            addCriterion("CBSC09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc09EqualTo(Double value) {
            addCriterion("CBSC09 =", value, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09NotEqualTo(Double value) {
            addCriterion("CBSC09 <>", value, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09GreaterThan(Double value) {
            addCriterion("CBSC09 >", value, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSC09 >=", value, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09LessThan(Double value) {
            addCriterion("CBSC09 <", value, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09LessThanOrEqualTo(Double value) {
            addCriterion("CBSC09 <=", value, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09In(List<Double> values) {
            addCriterion("CBSC09 in", values, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09NotIn(List<Double> values) {
            addCriterion("CBSC09 not in", values, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09Between(Double value1, Double value2) {
            addCriterion("CBSC09 between", value1, value2, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc09NotBetween(Double value1, Double value2) {
            addCriterion("CBSC09 not between", value1, value2, "cbsc09");
            return (Criteria) this;
        }

        public Criteria andCbsc10IsNull() {
            addCriterion("CBSC10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc10IsNotNull() {
            addCriterion("CBSC10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc10EqualTo(Double value) {
            addCriterion("CBSC10 =", value, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10NotEqualTo(Double value) {
            addCriterion("CBSC10 <>", value, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10GreaterThan(Double value) {
            addCriterion("CBSC10 >", value, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSC10 >=", value, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10LessThan(Double value) {
            addCriterion("CBSC10 <", value, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10LessThanOrEqualTo(Double value) {
            addCriterion("CBSC10 <=", value, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10In(List<Double> values) {
            addCriterion("CBSC10 in", values, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10NotIn(List<Double> values) {
            addCriterion("CBSC10 not in", values, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10Between(Double value1, Double value2) {
            addCriterion("CBSC10 between", value1, value2, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc10NotBetween(Double value1, Double value2) {
            addCriterion("CBSC10 not between", value1, value2, "cbsc10");
            return (Criteria) this;
        }

        public Criteria andCbsc11IsNull() {
            addCriterion("CBSC11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc11IsNotNull() {
            addCriterion("CBSC11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc11EqualTo(Double value) {
            addCriterion("CBSC11 =", value, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11NotEqualTo(Double value) {
            addCriterion("CBSC11 <>", value, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11GreaterThan(Double value) {
            addCriterion("CBSC11 >", value, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSC11 >=", value, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11LessThan(Double value) {
            addCriterion("CBSC11 <", value, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11LessThanOrEqualTo(Double value) {
            addCriterion("CBSC11 <=", value, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11In(List<Double> values) {
            addCriterion("CBSC11 in", values, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11NotIn(List<Double> values) {
            addCriterion("CBSC11 not in", values, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11Between(Double value1, Double value2) {
            addCriterion("CBSC11 between", value1, value2, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc11NotBetween(Double value1, Double value2) {
            addCriterion("CBSC11 not between", value1, value2, "cbsc11");
            return (Criteria) this;
        }

        public Criteria andCbsc12IsNull() {
            addCriterion("CBSC12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc12IsNotNull() {
            addCriterion("CBSC12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc12EqualTo(Double value) {
            addCriterion("CBSC12 =", value, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12NotEqualTo(Double value) {
            addCriterion("CBSC12 <>", value, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12GreaterThan(Double value) {
            addCriterion("CBSC12 >", value, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSC12 >=", value, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12LessThan(Double value) {
            addCriterion("CBSC12 <", value, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12LessThanOrEqualTo(Double value) {
            addCriterion("CBSC12 <=", value, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12In(List<Double> values) {
            addCriterion("CBSC12 in", values, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12NotIn(List<Double> values) {
            addCriterion("CBSC12 not in", values, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12Between(Double value1, Double value2) {
            addCriterion("CBSC12 between", value1, value2, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc12NotBetween(Double value1, Double value2) {
            addCriterion("CBSC12 not between", value1, value2, "cbsc12");
            return (Criteria) this;
        }

        public Criteria andCbsc13IsNull() {
            addCriterion("CBSC13 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc13IsNotNull() {
            addCriterion("CBSC13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc13EqualTo(String value) {
            addCriterion("CBSC13 =", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13NotEqualTo(String value) {
            addCriterion("CBSC13 <>", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13GreaterThan(String value) {
            addCriterion("CBSC13 >", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13GreaterThanOrEqualTo(String value) {
            addCriterion("CBSC13 >=", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13LessThan(String value) {
            addCriterion("CBSC13 <", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13LessThanOrEqualTo(String value) {
            addCriterion("CBSC13 <=", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13Like(String value) {
            addCriterion("CBSC13 like", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13NotLike(String value) {
            addCriterion("CBSC13 not like", value, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13In(List<String> values) {
            addCriterion("CBSC13 in", values, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13NotIn(List<String> values) {
            addCriterion("CBSC13 not in", values, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13Between(String value1, String value2) {
            addCriterion("CBSC13 between", value1, value2, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsc13NotBetween(String value1, String value2) {
            addCriterion("CBSC13 not between", value1, value2, "cbsc13");
            return (Criteria) this;
        }

        public Criteria andCbsb01IsNull() {
            addCriterion("CBSB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb01IsNotNull() {
            addCriterion("CBSB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb01EqualTo(Integer value) {
            addCriterion("CBSB01 =", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01NotEqualTo(Integer value) {
            addCriterion("CBSB01 <>", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01GreaterThan(Integer value) {
            addCriterion("CBSB01 >", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB01 >=", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01LessThan(Integer value) {
            addCriterion("CBSB01 <", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB01 <=", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01In(List<Integer> values) {
            addCriterion("CBSB01 in", values, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01NotIn(List<Integer> values) {
            addCriterion("CBSB01 not in", values, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01Between(Integer value1, Integer value2) {
            addCriterion("CBSB01 between", value1, value2, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB01 not between", value1, value2, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsc14IsNull() {
            addCriterion("CBSC14 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc14IsNotNull() {
            addCriterion("CBSC14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc14EqualTo(Integer value) {
            addCriterion("CBSC14 =", value, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14NotEqualTo(Integer value) {
            addCriterion("CBSC14 <>", value, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14GreaterThan(Integer value) {
            addCriterion("CBSC14 >", value, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC14 >=", value, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14LessThan(Integer value) {
            addCriterion("CBSC14 <", value, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC14 <=", value, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14In(List<Integer> values) {
            addCriterion("CBSC14 in", values, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14NotIn(List<Integer> values) {
            addCriterion("CBSC14 not in", values, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14Between(Integer value1, Integer value2) {
            addCriterion("CBSC14 between", value1, value2, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC14 not between", value1, value2, "cbsc14");
            return (Criteria) this;
        }

        public Criteria andCbsc15IsNull() {
            addCriterion("CBSC15 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc15IsNotNull() {
            addCriterion("CBSC15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc15EqualTo(Integer value) {
            addCriterion("CBSC15 =", value, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15NotEqualTo(Integer value) {
            addCriterion("CBSC15 <>", value, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15GreaterThan(Integer value) {
            addCriterion("CBSC15 >", value, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC15 >=", value, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15LessThan(Integer value) {
            addCriterion("CBSC15 <", value, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC15 <=", value, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15In(List<Integer> values) {
            addCriterion("CBSC15 in", values, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15NotIn(List<Integer> values) {
            addCriterion("CBSC15 not in", values, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15Between(Integer value1, Integer value2) {
            addCriterion("CBSC15 between", value1, value2, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC15 not between", value1, value2, "cbsc15");
            return (Criteria) this;
        }

        public Criteria andCbsc16IsNull() {
            addCriterion("CBSC16 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc16IsNotNull() {
            addCriterion("CBSC16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc16EqualTo(Integer value) {
            addCriterion("CBSC16 =", value, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16NotEqualTo(Integer value) {
            addCriterion("CBSC16 <>", value, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16GreaterThan(Integer value) {
            addCriterion("CBSC16 >", value, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC16 >=", value, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16LessThan(Integer value) {
            addCriterion("CBSC16 <", value, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC16 <=", value, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16In(List<Integer> values) {
            addCriterion("CBSC16 in", values, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16NotIn(List<Integer> values) {
            addCriterion("CBSC16 not in", values, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16Between(Integer value1, Integer value2) {
            addCriterion("CBSC16 between", value1, value2, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC16 not between", value1, value2, "cbsc16");
            return (Criteria) this;
        }

        public Criteria andCbsc17IsNull() {
            addCriterion("CBSC17 is null");
            return (Criteria) this;
        }

        public Criteria andCbsc17IsNotNull() {
            addCriterion("CBSC17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsc17EqualTo(Integer value) {
            addCriterion("CBSC17 =", value, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17NotEqualTo(Integer value) {
            addCriterion("CBSC17 <>", value, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17GreaterThan(Integer value) {
            addCriterion("CBSC17 >", value, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSC17 >=", value, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17LessThan(Integer value) {
            addCriterion("CBSC17 <", value, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17LessThanOrEqualTo(Integer value) {
            addCriterion("CBSC17 <=", value, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17In(List<Integer> values) {
            addCriterion("CBSC17 in", values, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17NotIn(List<Integer> values) {
            addCriterion("CBSC17 not in", values, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17Between(Integer value1, Integer value2) {
            addCriterion("CBSC17 between", value1, value2, "cbsc17");
            return (Criteria) this;
        }

        public Criteria andCbsc17NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSC17 not between", value1, value2, "cbsc17");
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
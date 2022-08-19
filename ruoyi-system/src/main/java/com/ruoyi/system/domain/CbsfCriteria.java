package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsfCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsfCriteria() {
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

        public Criteria andCbsf01IsNull() {
            addCriterion("CBSF01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf01IsNotNull() {
            addCriterion("CBSF01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf01EqualTo(Integer value) {
            addCriterion("CBSF01 =", value, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01NotEqualTo(Integer value) {
            addCriterion("CBSF01 <>", value, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01GreaterThan(Integer value) {
            addCriterion("CBSF01 >", value, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF01 >=", value, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01LessThan(Integer value) {
            addCriterion("CBSF01 <", value, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF01 <=", value, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01In(List<Integer> values) {
            addCriterion("CBSF01 in", values, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01NotIn(List<Integer> values) {
            addCriterion("CBSF01 not in", values, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01Between(Integer value1, Integer value2) {
            addCriterion("CBSF01 between", value1, value2, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF01 not between", value1, value2, "cbsf01");
            return (Criteria) this;
        }

        public Criteria andCbsf02IsNull() {
            addCriterion("CBSF02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf02IsNotNull() {
            addCriterion("CBSF02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf02EqualTo(Integer value) {
            addCriterion("CBSF02 =", value, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02NotEqualTo(Integer value) {
            addCriterion("CBSF02 <>", value, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02GreaterThan(Integer value) {
            addCriterion("CBSF02 >", value, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF02 >=", value, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02LessThan(Integer value) {
            addCriterion("CBSF02 <", value, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF02 <=", value, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02In(List<Integer> values) {
            addCriterion("CBSF02 in", values, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02NotIn(List<Integer> values) {
            addCriterion("CBSF02 not in", values, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02Between(Integer value1, Integer value2) {
            addCriterion("CBSF02 between", value1, value2, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF02 not between", value1, value2, "cbsf02");
            return (Criteria) this;
        }

        public Criteria andCbsf03IsNull() {
            addCriterion("CBSF03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf03IsNotNull() {
            addCriterion("CBSF03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf03EqualTo(Date value) {
            addCriterion("CBSF03 =", value, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03NotEqualTo(Date value) {
            addCriterion("CBSF03 <>", value, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03GreaterThan(Date value) {
            addCriterion("CBSF03 >", value, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSF03 >=", value, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03LessThan(Date value) {
            addCriterion("CBSF03 <", value, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03LessThanOrEqualTo(Date value) {
            addCriterion("CBSF03 <=", value, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03In(List<Date> values) {
            addCriterion("CBSF03 in", values, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03NotIn(List<Date> values) {
            addCriterion("CBSF03 not in", values, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03Between(Date value1, Date value2) {
            addCriterion("CBSF03 between", value1, value2, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf03NotBetween(Date value1, Date value2) {
            addCriterion("CBSF03 not between", value1, value2, "cbsf03");
            return (Criteria) this;
        }

        public Criteria andCbsf04IsNull() {
            addCriterion("CBSF04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf04IsNotNull() {
            addCriterion("CBSF04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf04EqualTo(Integer value) {
            addCriterion("CBSF04 =", value, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04NotEqualTo(Integer value) {
            addCriterion("CBSF04 <>", value, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04GreaterThan(Integer value) {
            addCriterion("CBSF04 >", value, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF04 >=", value, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04LessThan(Integer value) {
            addCriterion("CBSF04 <", value, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF04 <=", value, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04In(List<Integer> values) {
            addCriterion("CBSF04 in", values, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04NotIn(List<Integer> values) {
            addCriterion("CBSF04 not in", values, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04Between(Integer value1, Integer value2) {
            addCriterion("CBSF04 between", value1, value2, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF04 not between", value1, value2, "cbsf04");
            return (Criteria) this;
        }

        public Criteria andCbsf05IsNull() {
            addCriterion("CBSF05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf05IsNotNull() {
            addCriterion("CBSF05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf05EqualTo(Date value) {
            addCriterion("CBSF05 =", value, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05NotEqualTo(Date value) {
            addCriterion("CBSF05 <>", value, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05GreaterThan(Date value) {
            addCriterion("CBSF05 >", value, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSF05 >=", value, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05LessThan(Date value) {
            addCriterion("CBSF05 <", value, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05LessThanOrEqualTo(Date value) {
            addCriterion("CBSF05 <=", value, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05In(List<Date> values) {
            addCriterion("CBSF05 in", values, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05NotIn(List<Date> values) {
            addCriterion("CBSF05 not in", values, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05Between(Date value1, Date value2) {
            addCriterion("CBSF05 between", value1, value2, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf05NotBetween(Date value1, Date value2) {
            addCriterion("CBSF05 not between", value1, value2, "cbsf05");
            return (Criteria) this;
        }

        public Criteria andCbsf06IsNull() {
            addCriterion("CBSF06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf06IsNotNull() {
            addCriterion("CBSF06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf06EqualTo(Integer value) {
            addCriterion("CBSF06 =", value, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06NotEqualTo(Integer value) {
            addCriterion("CBSF06 <>", value, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06GreaterThan(Integer value) {
            addCriterion("CBSF06 >", value, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF06 >=", value, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06LessThan(Integer value) {
            addCriterion("CBSF06 <", value, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF06 <=", value, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06In(List<Integer> values) {
            addCriterion("CBSF06 in", values, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06NotIn(List<Integer> values) {
            addCriterion("CBSF06 not in", values, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06Between(Integer value1, Integer value2) {
            addCriterion("CBSF06 between", value1, value2, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF06 not between", value1, value2, "cbsf06");
            return (Criteria) this;
        }

        public Criteria andCbsf07IsNull() {
            addCriterion("CBSF07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf07IsNotNull() {
            addCriterion("CBSF07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf07EqualTo(Integer value) {
            addCriterion("CBSF07 =", value, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07NotEqualTo(Integer value) {
            addCriterion("CBSF07 <>", value, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07GreaterThan(Integer value) {
            addCriterion("CBSF07 >", value, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF07 >=", value, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07LessThan(Integer value) {
            addCriterion("CBSF07 <", value, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF07 <=", value, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07In(List<Integer> values) {
            addCriterion("CBSF07 in", values, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07NotIn(List<Integer> values) {
            addCriterion("CBSF07 not in", values, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07Between(Integer value1, Integer value2) {
            addCriterion("CBSF07 between", value1, value2, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF07 not between", value1, value2, "cbsf07");
            return (Criteria) this;
        }

        public Criteria andCbsf08IsNull() {
            addCriterion("CBSF08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf08IsNotNull() {
            addCriterion("CBSF08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf08EqualTo(Integer value) {
            addCriterion("CBSF08 =", value, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08NotEqualTo(Integer value) {
            addCriterion("CBSF08 <>", value, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08GreaterThan(Integer value) {
            addCriterion("CBSF08 >", value, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF08 >=", value, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08LessThan(Integer value) {
            addCriterion("CBSF08 <", value, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF08 <=", value, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08In(List<Integer> values) {
            addCriterion("CBSF08 in", values, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08NotIn(List<Integer> values) {
            addCriterion("CBSF08 not in", values, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08Between(Integer value1, Integer value2) {
            addCriterion("CBSF08 between", value1, value2, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF08 not between", value1, value2, "cbsf08");
            return (Criteria) this;
        }

        public Criteria andCbsf09IsNull() {
            addCriterion("CBSF09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf09IsNotNull() {
            addCriterion("CBSF09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf09EqualTo(Double value) {
            addCriterion("CBSF09 =", value, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09NotEqualTo(Double value) {
            addCriterion("CBSF09 <>", value, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09GreaterThan(Double value) {
            addCriterion("CBSF09 >", value, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSF09 >=", value, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09LessThan(Double value) {
            addCriterion("CBSF09 <", value, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09LessThanOrEqualTo(Double value) {
            addCriterion("CBSF09 <=", value, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09In(List<Double> values) {
            addCriterion("CBSF09 in", values, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09NotIn(List<Double> values) {
            addCriterion("CBSF09 not in", values, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09Between(Double value1, Double value2) {
            addCriterion("CBSF09 between", value1, value2, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf09NotBetween(Double value1, Double value2) {
            addCriterion("CBSF09 not between", value1, value2, "cbsf09");
            return (Criteria) this;
        }

        public Criteria andCbsf10IsNull() {
            addCriterion("CBSF10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf10IsNotNull() {
            addCriterion("CBSF10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf10EqualTo(Double value) {
            addCriterion("CBSF10 =", value, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10NotEqualTo(Double value) {
            addCriterion("CBSF10 <>", value, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10GreaterThan(Double value) {
            addCriterion("CBSF10 >", value, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSF10 >=", value, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10LessThan(Double value) {
            addCriterion("CBSF10 <", value, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10LessThanOrEqualTo(Double value) {
            addCriterion("CBSF10 <=", value, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10In(List<Double> values) {
            addCriterion("CBSF10 in", values, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10NotIn(List<Double> values) {
            addCriterion("CBSF10 not in", values, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10Between(Double value1, Double value2) {
            addCriterion("CBSF10 between", value1, value2, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf10NotBetween(Double value1, Double value2) {
            addCriterion("CBSF10 not between", value1, value2, "cbsf10");
            return (Criteria) this;
        }

        public Criteria andCbsf11IsNull() {
            addCriterion("CBSF11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf11IsNotNull() {
            addCriterion("CBSF11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf11EqualTo(Double value) {
            addCriterion("CBSF11 =", value, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11NotEqualTo(Double value) {
            addCriterion("CBSF11 <>", value, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11GreaterThan(Double value) {
            addCriterion("CBSF11 >", value, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSF11 >=", value, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11LessThan(Double value) {
            addCriterion("CBSF11 <", value, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11LessThanOrEqualTo(Double value) {
            addCriterion("CBSF11 <=", value, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11In(List<Double> values) {
            addCriterion("CBSF11 in", values, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11NotIn(List<Double> values) {
            addCriterion("CBSF11 not in", values, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11Between(Double value1, Double value2) {
            addCriterion("CBSF11 between", value1, value2, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf11NotBetween(Double value1, Double value2) {
            addCriterion("CBSF11 not between", value1, value2, "cbsf11");
            return (Criteria) this;
        }

        public Criteria andCbsf12IsNull() {
            addCriterion("CBSF12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf12IsNotNull() {
            addCriterion("CBSF12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf12EqualTo(Double value) {
            addCriterion("CBSF12 =", value, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12NotEqualTo(Double value) {
            addCriterion("CBSF12 <>", value, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12GreaterThan(Double value) {
            addCriterion("CBSF12 >", value, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSF12 >=", value, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12LessThan(Double value) {
            addCriterion("CBSF12 <", value, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12LessThanOrEqualTo(Double value) {
            addCriterion("CBSF12 <=", value, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12In(List<Double> values) {
            addCriterion("CBSF12 in", values, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12NotIn(List<Double> values) {
            addCriterion("CBSF12 not in", values, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12Between(Double value1, Double value2) {
            addCriterion("CBSF12 between", value1, value2, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf12NotBetween(Double value1, Double value2) {
            addCriterion("CBSF12 not between", value1, value2, "cbsf12");
            return (Criteria) this;
        }

        public Criteria andCbsf13IsNull() {
            addCriterion("CBSF13 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf13IsNotNull() {
            addCriterion("CBSF13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf13EqualTo(String value) {
            addCriterion("CBSF13 =", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13NotEqualTo(String value) {
            addCriterion("CBSF13 <>", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13GreaterThan(String value) {
            addCriterion("CBSF13 >", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13GreaterThanOrEqualTo(String value) {
            addCriterion("CBSF13 >=", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13LessThan(String value) {
            addCriterion("CBSF13 <", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13LessThanOrEqualTo(String value) {
            addCriterion("CBSF13 <=", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13Like(String value) {
            addCriterion("CBSF13 like", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13NotLike(String value) {
            addCriterion("CBSF13 not like", value, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13In(List<String> values) {
            addCriterion("CBSF13 in", values, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13NotIn(List<String> values) {
            addCriterion("CBSF13 not in", values, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13Between(String value1, String value2) {
            addCriterion("CBSF13 between", value1, value2, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbsf13NotBetween(String value1, String value2) {
            addCriterion("CBSF13 not between", value1, value2, "cbsf13");
            return (Criteria) this;
        }

        public Criteria andCbse01IsNull() {
            addCriterion("CBSE01 is null");
            return (Criteria) this;
        }

        public Criteria andCbse01IsNotNull() {
            addCriterion("CBSE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse01EqualTo(Integer value) {
            addCriterion("CBSE01 =", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01NotEqualTo(Integer value) {
            addCriterion("CBSE01 <>", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01GreaterThan(Integer value) {
            addCriterion("CBSE01 >", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE01 >=", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01LessThan(Integer value) {
            addCriterion("CBSE01 <", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE01 <=", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01In(List<Integer> values) {
            addCriterion("CBSE01 in", values, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01NotIn(List<Integer> values) {
            addCriterion("CBSE01 not in", values, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01Between(Integer value1, Integer value2) {
            addCriterion("CBSE01 between", value1, value2, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE01 not between", value1, value2, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbsf14IsNull() {
            addCriterion("CBSF14 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf14IsNotNull() {
            addCriterion("CBSF14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf14EqualTo(Integer value) {
            addCriterion("CBSF14 =", value, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14NotEqualTo(Integer value) {
            addCriterion("CBSF14 <>", value, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14GreaterThan(Integer value) {
            addCriterion("CBSF14 >", value, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF14 >=", value, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14LessThan(Integer value) {
            addCriterion("CBSF14 <", value, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF14 <=", value, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14In(List<Integer> values) {
            addCriterion("CBSF14 in", values, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14NotIn(List<Integer> values) {
            addCriterion("CBSF14 not in", values, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14Between(Integer value1, Integer value2) {
            addCriterion("CBSF14 between", value1, value2, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF14 not between", value1, value2, "cbsf14");
            return (Criteria) this;
        }

        public Criteria andCbsf15IsNull() {
            addCriterion("CBSF15 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf15IsNotNull() {
            addCriterion("CBSF15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf15EqualTo(Integer value) {
            addCriterion("CBSF15 =", value, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15NotEqualTo(Integer value) {
            addCriterion("CBSF15 <>", value, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15GreaterThan(Integer value) {
            addCriterion("CBSF15 >", value, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF15 >=", value, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15LessThan(Integer value) {
            addCriterion("CBSF15 <", value, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF15 <=", value, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15In(List<Integer> values) {
            addCriterion("CBSF15 in", values, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15NotIn(List<Integer> values) {
            addCriterion("CBSF15 not in", values, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15Between(Integer value1, Integer value2) {
            addCriterion("CBSF15 between", value1, value2, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF15 not between", value1, value2, "cbsf15");
            return (Criteria) this;
        }

        public Criteria andCbsf16IsNull() {
            addCriterion("CBSF16 is null");
            return (Criteria) this;
        }

        public Criteria andCbsf16IsNotNull() {
            addCriterion("CBSF16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsf16EqualTo(Integer value) {
            addCriterion("CBSF16 =", value, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16NotEqualTo(Integer value) {
            addCriterion("CBSF16 <>", value, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16GreaterThan(Integer value) {
            addCriterion("CBSF16 >", value, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSF16 >=", value, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16LessThan(Integer value) {
            addCriterion("CBSF16 <", value, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16LessThanOrEqualTo(Integer value) {
            addCriterion("CBSF16 <=", value, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16In(List<Integer> values) {
            addCriterion("CBSF16 in", values, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16NotIn(List<Integer> values) {
            addCriterion("CBSF16 not in", values, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16Between(Integer value1, Integer value2) {
            addCriterion("CBSF16 between", value1, value2, "cbsf16");
            return (Criteria) this;
        }

        public Criteria andCbsf16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSF16 not between", value1, value2, "cbsf16");
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
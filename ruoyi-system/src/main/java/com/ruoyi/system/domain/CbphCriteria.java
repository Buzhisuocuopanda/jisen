package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbphCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbphCriteria() {
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

        public Criteria andCbph01IsNull() {
            addCriterion("CBPH01 is null");
            return (Criteria) this;
        }

        public Criteria andCbph01IsNotNull() {
            addCriterion("CBPH01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph01EqualTo(Integer value) {
            addCriterion("CBPH01 =", value, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01NotEqualTo(Integer value) {
            addCriterion("CBPH01 <>", value, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01GreaterThan(Integer value) {
            addCriterion("CBPH01 >", value, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPH01 >=", value, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01LessThan(Integer value) {
            addCriterion("CBPH01 <", value, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPH01 <=", value, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01In(List<Integer> values) {
            addCriterion("CBPH01 in", values, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01NotIn(List<Integer> values) {
            addCriterion("CBPH01 not in", values, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01Between(Integer value1, Integer value2) {
            addCriterion("CBPH01 between", value1, value2, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPH01 not between", value1, value2, "cbph01");
            return (Criteria) this;
        }

        public Criteria andCbph02IsNull() {
            addCriterion("CBPH02 is null");
            return (Criteria) this;
        }

        public Criteria andCbph02IsNotNull() {
            addCriterion("CBPH02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph02EqualTo(Integer value) {
            addCriterion("CBPH02 =", value, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02NotEqualTo(Integer value) {
            addCriterion("CBPH02 <>", value, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02GreaterThan(Integer value) {
            addCriterion("CBPH02 >", value, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPH02 >=", value, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02LessThan(Integer value) {
            addCriterion("CBPH02 <", value, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPH02 <=", value, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02In(List<Integer> values) {
            addCriterion("CBPH02 in", values, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02NotIn(List<Integer> values) {
            addCriterion("CBPH02 not in", values, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02Between(Integer value1, Integer value2) {
            addCriterion("CBPH02 between", value1, value2, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPH02 not between", value1, value2, "cbph02");
            return (Criteria) this;
        }

        public Criteria andCbph03IsNull() {
            addCriterion("CBPH03 is null");
            return (Criteria) this;
        }

        public Criteria andCbph03IsNotNull() {
            addCriterion("CBPH03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph03EqualTo(Date value) {
            addCriterion("CBPH03 =", value, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03NotEqualTo(Date value) {
            addCriterion("CBPH03 <>", value, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03GreaterThan(Date value) {
            addCriterion("CBPH03 >", value, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPH03 >=", value, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03LessThan(Date value) {
            addCriterion("CBPH03 <", value, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03LessThanOrEqualTo(Date value) {
            addCriterion("CBPH03 <=", value, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03In(List<Date> values) {
            addCriterion("CBPH03 in", values, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03NotIn(List<Date> values) {
            addCriterion("CBPH03 not in", values, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03Between(Date value1, Date value2) {
            addCriterion("CBPH03 between", value1, value2, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph03NotBetween(Date value1, Date value2) {
            addCriterion("CBPH03 not between", value1, value2, "cbph03");
            return (Criteria) this;
        }

        public Criteria andCbph04IsNull() {
            addCriterion("CBPH04 is null");
            return (Criteria) this;
        }

        public Criteria andCbph04IsNotNull() {
            addCriterion("CBPH04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph04EqualTo(Integer value) {
            addCriterion("CBPH04 =", value, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04NotEqualTo(Integer value) {
            addCriterion("CBPH04 <>", value, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04GreaterThan(Integer value) {
            addCriterion("CBPH04 >", value, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPH04 >=", value, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04LessThan(Integer value) {
            addCriterion("CBPH04 <", value, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPH04 <=", value, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04In(List<Integer> values) {
            addCriterion("CBPH04 in", values, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04NotIn(List<Integer> values) {
            addCriterion("CBPH04 not in", values, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04Between(Integer value1, Integer value2) {
            addCriterion("CBPH04 between", value1, value2, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPH04 not between", value1, value2, "cbph04");
            return (Criteria) this;
        }

        public Criteria andCbph05IsNull() {
            addCriterion("CBPH05 is null");
            return (Criteria) this;
        }

        public Criteria andCbph05IsNotNull() {
            addCriterion("CBPH05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph05EqualTo(Date value) {
            addCriterion("CBPH05 =", value, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05NotEqualTo(Date value) {
            addCriterion("CBPH05 <>", value, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05GreaterThan(Date value) {
            addCriterion("CBPH05 >", value, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPH05 >=", value, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05LessThan(Date value) {
            addCriterion("CBPH05 <", value, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05LessThanOrEqualTo(Date value) {
            addCriterion("CBPH05 <=", value, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05In(List<Date> values) {
            addCriterion("CBPH05 in", values, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05NotIn(List<Date> values) {
            addCriterion("CBPH05 not in", values, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05Between(Date value1, Date value2) {
            addCriterion("CBPH05 between", value1, value2, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph05NotBetween(Date value1, Date value2) {
            addCriterion("CBPH05 not between", value1, value2, "cbph05");
            return (Criteria) this;
        }

        public Criteria andCbph06IsNull() {
            addCriterion("CBPH06 is null");
            return (Criteria) this;
        }

        public Criteria andCbph06IsNotNull() {
            addCriterion("CBPH06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph06EqualTo(Integer value) {
            addCriterion("CBPH06 =", value, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06NotEqualTo(Integer value) {
            addCriterion("CBPH06 <>", value, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06GreaterThan(Integer value) {
            addCriterion("CBPH06 >", value, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPH06 >=", value, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06LessThan(Integer value) {
            addCriterion("CBPH06 <", value, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPH06 <=", value, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06In(List<Integer> values) {
            addCriterion("CBPH06 in", values, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06NotIn(List<Integer> values) {
            addCriterion("CBPH06 not in", values, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06Between(Integer value1, Integer value2) {
            addCriterion("CBPH06 between", value1, value2, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPH06 not between", value1, value2, "cbph06");
            return (Criteria) this;
        }

        public Criteria andCbph07IsNull() {
            addCriterion("CBPH07 is null");
            return (Criteria) this;
        }

        public Criteria andCbph07IsNotNull() {
            addCriterion("CBPH07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph07EqualTo(Integer value) {
            addCriterion("CBPH07 =", value, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07NotEqualTo(Integer value) {
            addCriterion("CBPH07 <>", value, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07GreaterThan(Integer value) {
            addCriterion("CBPH07 >", value, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPH07 >=", value, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07LessThan(Integer value) {
            addCriterion("CBPH07 <", value, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07LessThanOrEqualTo(Integer value) {
            addCriterion("CBPH07 <=", value, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07In(List<Integer> values) {
            addCriterion("CBPH07 in", values, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07NotIn(List<Integer> values) {
            addCriterion("CBPH07 not in", values, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07Between(Integer value1, Integer value2) {
            addCriterion("CBPH07 between", value1, value2, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPH07 not between", value1, value2, "cbph07");
            return (Criteria) this;
        }

        public Criteria andCbph08IsNull() {
            addCriterion("CBPH08 is null");
            return (Criteria) this;
        }

        public Criteria andCbph08IsNotNull() {
            addCriterion("CBPH08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph08EqualTo(Integer value) {
            addCriterion("CBPH08 =", value, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08NotEqualTo(Integer value) {
            addCriterion("CBPH08 <>", value, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08GreaterThan(Integer value) {
            addCriterion("CBPH08 >", value, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPH08 >=", value, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08LessThan(Integer value) {
            addCriterion("CBPH08 <", value, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08LessThanOrEqualTo(Integer value) {
            addCriterion("CBPH08 <=", value, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08In(List<Integer> values) {
            addCriterion("CBPH08 in", values, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08NotIn(List<Integer> values) {
            addCriterion("CBPH08 not in", values, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08Between(Integer value1, Integer value2) {
            addCriterion("CBPH08 between", value1, value2, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPH08 not between", value1, value2, "cbph08");
            return (Criteria) this;
        }

        public Criteria andCbph09IsNull() {
            addCriterion("CBPH09 is null");
            return (Criteria) this;
        }

        public Criteria andCbph09IsNotNull() {
            addCriterion("CBPH09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph09EqualTo(Double value) {
            addCriterion("CBPH09 =", value, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09NotEqualTo(Double value) {
            addCriterion("CBPH09 <>", value, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09GreaterThan(Double value) {
            addCriterion("CBPH09 >", value, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPH09 >=", value, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09LessThan(Double value) {
            addCriterion("CBPH09 <", value, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09LessThanOrEqualTo(Double value) {
            addCriterion("CBPH09 <=", value, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09In(List<Double> values) {
            addCriterion("CBPH09 in", values, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09NotIn(List<Double> values) {
            addCriterion("CBPH09 not in", values, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09Between(Double value1, Double value2) {
            addCriterion("CBPH09 between", value1, value2, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph09NotBetween(Double value1, Double value2) {
            addCriterion("CBPH09 not between", value1, value2, "cbph09");
            return (Criteria) this;
        }

        public Criteria andCbph10IsNull() {
            addCriterion("CBPH10 is null");
            return (Criteria) this;
        }

        public Criteria andCbph10IsNotNull() {
            addCriterion("CBPH10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph10EqualTo(Double value) {
            addCriterion("CBPH10 =", value, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10NotEqualTo(Double value) {
            addCriterion("CBPH10 <>", value, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10GreaterThan(Double value) {
            addCriterion("CBPH10 >", value, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPH10 >=", value, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10LessThan(Double value) {
            addCriterion("CBPH10 <", value, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10LessThanOrEqualTo(Double value) {
            addCriterion("CBPH10 <=", value, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10In(List<Double> values) {
            addCriterion("CBPH10 in", values, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10NotIn(List<Double> values) {
            addCriterion("CBPH10 not in", values, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10Between(Double value1, Double value2) {
            addCriterion("CBPH10 between", value1, value2, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph10NotBetween(Double value1, Double value2) {
            addCriterion("CBPH10 not between", value1, value2, "cbph10");
            return (Criteria) this;
        }

        public Criteria andCbph11IsNull() {
            addCriterion("CBPH11 is null");
            return (Criteria) this;
        }

        public Criteria andCbph11IsNotNull() {
            addCriterion("CBPH11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph11EqualTo(Double value) {
            addCriterion("CBPH11 =", value, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11NotEqualTo(Double value) {
            addCriterion("CBPH11 <>", value, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11GreaterThan(Double value) {
            addCriterion("CBPH11 >", value, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPH11 >=", value, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11LessThan(Double value) {
            addCriterion("CBPH11 <", value, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11LessThanOrEqualTo(Double value) {
            addCriterion("CBPH11 <=", value, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11In(List<Double> values) {
            addCriterion("CBPH11 in", values, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11NotIn(List<Double> values) {
            addCriterion("CBPH11 not in", values, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11Between(Double value1, Double value2) {
            addCriterion("CBPH11 between", value1, value2, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph11NotBetween(Double value1, Double value2) {
            addCriterion("CBPH11 not between", value1, value2, "cbph11");
            return (Criteria) this;
        }

        public Criteria andCbph12IsNull() {
            addCriterion("CBPH12 is null");
            return (Criteria) this;
        }

        public Criteria andCbph12IsNotNull() {
            addCriterion("CBPH12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph12EqualTo(Double value) {
            addCriterion("CBPH12 =", value, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12NotEqualTo(Double value) {
            addCriterion("CBPH12 <>", value, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12GreaterThan(Double value) {
            addCriterion("CBPH12 >", value, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPH12 >=", value, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12LessThan(Double value) {
            addCriterion("CBPH12 <", value, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12LessThanOrEqualTo(Double value) {
            addCriterion("CBPH12 <=", value, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12In(List<Double> values) {
            addCriterion("CBPH12 in", values, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12NotIn(List<Double> values) {
            addCriterion("CBPH12 not in", values, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12Between(Double value1, Double value2) {
            addCriterion("CBPH12 between", value1, value2, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph12NotBetween(Double value1, Double value2) {
            addCriterion("CBPH12 not between", value1, value2, "cbph12");
            return (Criteria) this;
        }

        public Criteria andCbph13IsNull() {
            addCriterion("CBPH13 is null");
            return (Criteria) this;
        }

        public Criteria andCbph13IsNotNull() {
            addCriterion("CBPH13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbph13EqualTo(String value) {
            addCriterion("CBPH13 =", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13NotEqualTo(String value) {
            addCriterion("CBPH13 <>", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13GreaterThan(String value) {
            addCriterion("CBPH13 >", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13GreaterThanOrEqualTo(String value) {
            addCriterion("CBPH13 >=", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13LessThan(String value) {
            addCriterion("CBPH13 <", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13LessThanOrEqualTo(String value) {
            addCriterion("CBPH13 <=", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13Like(String value) {
            addCriterion("CBPH13 like", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13NotLike(String value) {
            addCriterion("CBPH13 not like", value, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13In(List<String> values) {
            addCriterion("CBPH13 in", values, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13NotIn(List<String> values) {
            addCriterion("CBPH13 not in", values, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13Between(String value1, String value2) {
            addCriterion("CBPH13 between", value1, value2, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbph13NotBetween(String value1, String value2) {
            addCriterion("CBPH13 not between", value1, value2, "cbph13");
            return (Criteria) this;
        }

        public Criteria andCbpg01IsNull() {
            addCriterion("CBPG01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg01IsNotNull() {
            addCriterion("CBPG01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg01EqualTo(Integer value) {
            addCriterion("CBPG01 =", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotEqualTo(Integer value) {
            addCriterion("CBPG01 <>", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01GreaterThan(Integer value) {
            addCriterion("CBPG01 >", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG01 >=", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01LessThan(Integer value) {
            addCriterion("CBPG01 <", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG01 <=", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01In(List<Integer> values) {
            addCriterion("CBPG01 in", values, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotIn(List<Integer> values) {
            addCriterion("CBPG01 not in", values, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01Between(Integer value1, Integer value2) {
            addCriterion("CBPG01 between", value1, value2, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG01 not between", value1, value2, "cbpg01");
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
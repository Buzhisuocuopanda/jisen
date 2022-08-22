package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbifCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbifCriteria() {
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

        public Criteria andCbif01IsNull() {
            addCriterion("CBIF01 is null");
            return (Criteria) this;
        }

        public Criteria andCbif01IsNotNull() {
            addCriterion("CBIF01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif01EqualTo(Integer value) {
            addCriterion("CBIF01 =", value, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01NotEqualTo(Integer value) {
            addCriterion("CBIF01 <>", value, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01GreaterThan(Integer value) {
            addCriterion("CBIF01 >", value, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF01 >=", value, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01LessThan(Integer value) {
            addCriterion("CBIF01 <", value, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF01 <=", value, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01In(List<Integer> values) {
            addCriterion("CBIF01 in", values, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01NotIn(List<Integer> values) {
            addCriterion("CBIF01 not in", values, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01Between(Integer value1, Integer value2) {
            addCriterion("CBIF01 between", value1, value2, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF01 not between", value1, value2, "cbif01");
            return (Criteria) this;
        }

        public Criteria andCbif02IsNull() {
            addCriterion("CBIF02 is null");
            return (Criteria) this;
        }

        public Criteria andCbif02IsNotNull() {
            addCriterion("CBIF02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif02EqualTo(Integer value) {
            addCriterion("CBIF02 =", value, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02NotEqualTo(Integer value) {
            addCriterion("CBIF02 <>", value, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02GreaterThan(Integer value) {
            addCriterion("CBIF02 >", value, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF02 >=", value, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02LessThan(Integer value) {
            addCriterion("CBIF02 <", value, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF02 <=", value, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02In(List<Integer> values) {
            addCriterion("CBIF02 in", values, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02NotIn(List<Integer> values) {
            addCriterion("CBIF02 not in", values, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02Between(Integer value1, Integer value2) {
            addCriterion("CBIF02 between", value1, value2, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF02 not between", value1, value2, "cbif02");
            return (Criteria) this;
        }

        public Criteria andCbif03IsNull() {
            addCriterion("CBIF03 is null");
            return (Criteria) this;
        }

        public Criteria andCbif03IsNotNull() {
            addCriterion("CBIF03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif03EqualTo(Date value) {
            addCriterion("CBIF03 =", value, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03NotEqualTo(Date value) {
            addCriterion("CBIF03 <>", value, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03GreaterThan(Date value) {
            addCriterion("CBIF03 >", value, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIF03 >=", value, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03LessThan(Date value) {
            addCriterion("CBIF03 <", value, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03LessThanOrEqualTo(Date value) {
            addCriterion("CBIF03 <=", value, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03In(List<Date> values) {
            addCriterion("CBIF03 in", values, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03NotIn(List<Date> values) {
            addCriterion("CBIF03 not in", values, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03Between(Date value1, Date value2) {
            addCriterion("CBIF03 between", value1, value2, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif03NotBetween(Date value1, Date value2) {
            addCriterion("CBIF03 not between", value1, value2, "cbif03");
            return (Criteria) this;
        }

        public Criteria andCbif04IsNull() {
            addCriterion("CBIF04 is null");
            return (Criteria) this;
        }

        public Criteria andCbif04IsNotNull() {
            addCriterion("CBIF04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif04EqualTo(Integer value) {
            addCriterion("CBIF04 =", value, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04NotEqualTo(Integer value) {
            addCriterion("CBIF04 <>", value, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04GreaterThan(Integer value) {
            addCriterion("CBIF04 >", value, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF04 >=", value, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04LessThan(Integer value) {
            addCriterion("CBIF04 <", value, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF04 <=", value, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04In(List<Integer> values) {
            addCriterion("CBIF04 in", values, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04NotIn(List<Integer> values) {
            addCriterion("CBIF04 not in", values, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04Between(Integer value1, Integer value2) {
            addCriterion("CBIF04 between", value1, value2, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF04 not between", value1, value2, "cbif04");
            return (Criteria) this;
        }

        public Criteria andCbif05IsNull() {
            addCriterion("CBIF05 is null");
            return (Criteria) this;
        }

        public Criteria andCbif05IsNotNull() {
            addCriterion("CBIF05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif05EqualTo(Date value) {
            addCriterion("CBIF05 =", value, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05NotEqualTo(Date value) {
            addCriterion("CBIF05 <>", value, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05GreaterThan(Date value) {
            addCriterion("CBIF05 >", value, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIF05 >=", value, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05LessThan(Date value) {
            addCriterion("CBIF05 <", value, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05LessThanOrEqualTo(Date value) {
            addCriterion("CBIF05 <=", value, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05In(List<Date> values) {
            addCriterion("CBIF05 in", values, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05NotIn(List<Date> values) {
            addCriterion("CBIF05 not in", values, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05Between(Date value1, Date value2) {
            addCriterion("CBIF05 between", value1, value2, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif05NotBetween(Date value1, Date value2) {
            addCriterion("CBIF05 not between", value1, value2, "cbif05");
            return (Criteria) this;
        }

        public Criteria andCbif06IsNull() {
            addCriterion("CBIF06 is null");
            return (Criteria) this;
        }

        public Criteria andCbif06IsNotNull() {
            addCriterion("CBIF06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif06EqualTo(Integer value) {
            addCriterion("CBIF06 =", value, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06NotEqualTo(Integer value) {
            addCriterion("CBIF06 <>", value, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06GreaterThan(Integer value) {
            addCriterion("CBIF06 >", value, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF06 >=", value, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06LessThan(Integer value) {
            addCriterion("CBIF06 <", value, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF06 <=", value, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06In(List<Integer> values) {
            addCriterion("CBIF06 in", values, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06NotIn(List<Integer> values) {
            addCriterion("CBIF06 not in", values, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06Between(Integer value1, Integer value2) {
            addCriterion("CBIF06 between", value1, value2, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF06 not between", value1, value2, "cbif06");
            return (Criteria) this;
        }

        public Criteria andCbif07IsNull() {
            addCriterion("CBIF07 is null");
            return (Criteria) this;
        }

        public Criteria andCbif07IsNotNull() {
            addCriterion("CBIF07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif07EqualTo(Integer value) {
            addCriterion("CBIF07 =", value, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07NotEqualTo(Integer value) {
            addCriterion("CBIF07 <>", value, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07GreaterThan(Integer value) {
            addCriterion("CBIF07 >", value, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF07 >=", value, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07LessThan(Integer value) {
            addCriterion("CBIF07 <", value, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF07 <=", value, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07In(List<Integer> values) {
            addCriterion("CBIF07 in", values, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07NotIn(List<Integer> values) {
            addCriterion("CBIF07 not in", values, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07Between(Integer value1, Integer value2) {
            addCriterion("CBIF07 between", value1, value2, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF07 not between", value1, value2, "cbif07");
            return (Criteria) this;
        }

        public Criteria andCbif08IsNull() {
            addCriterion("CBIF08 is null");
            return (Criteria) this;
        }

        public Criteria andCbif08IsNotNull() {
            addCriterion("CBIF08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif08EqualTo(Integer value) {
            addCriterion("CBIF08 =", value, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08NotEqualTo(Integer value) {
            addCriterion("CBIF08 <>", value, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08GreaterThan(Integer value) {
            addCriterion("CBIF08 >", value, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF08 >=", value, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08LessThan(Integer value) {
            addCriterion("CBIF08 <", value, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF08 <=", value, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08In(List<Integer> values) {
            addCriterion("CBIF08 in", values, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08NotIn(List<Integer> values) {
            addCriterion("CBIF08 not in", values, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08Between(Integer value1, Integer value2) {
            addCriterion("CBIF08 between", value1, value2, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF08 not between", value1, value2, "cbif08");
            return (Criteria) this;
        }

        public Criteria andCbif09IsNull() {
            addCriterion("CBIF09 is null");
            return (Criteria) this;
        }

        public Criteria andCbif09IsNotNull() {
            addCriterion("CBIF09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif09EqualTo(Double value) {
            addCriterion("CBIF09 =", value, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09NotEqualTo(Double value) {
            addCriterion("CBIF09 <>", value, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09GreaterThan(Double value) {
            addCriterion("CBIF09 >", value, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIF09 >=", value, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09LessThan(Double value) {
            addCriterion("CBIF09 <", value, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09LessThanOrEqualTo(Double value) {
            addCriterion("CBIF09 <=", value, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09In(List<Double> values) {
            addCriterion("CBIF09 in", values, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09NotIn(List<Double> values) {
            addCriterion("CBIF09 not in", values, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09Between(Double value1, Double value2) {
            addCriterion("CBIF09 between", value1, value2, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif09NotBetween(Double value1, Double value2) {
            addCriterion("CBIF09 not between", value1, value2, "cbif09");
            return (Criteria) this;
        }

        public Criteria andCbif10IsNull() {
            addCriterion("CBIF10 is null");
            return (Criteria) this;
        }

        public Criteria andCbif10IsNotNull() {
            addCriterion("CBIF10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif10EqualTo(Double value) {
            addCriterion("CBIF10 =", value, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10NotEqualTo(Double value) {
            addCriterion("CBIF10 <>", value, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10GreaterThan(Double value) {
            addCriterion("CBIF10 >", value, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIF10 >=", value, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10LessThan(Double value) {
            addCriterion("CBIF10 <", value, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10LessThanOrEqualTo(Double value) {
            addCriterion("CBIF10 <=", value, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10In(List<Double> values) {
            addCriterion("CBIF10 in", values, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10NotIn(List<Double> values) {
            addCriterion("CBIF10 not in", values, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10Between(Double value1, Double value2) {
            addCriterion("CBIF10 between", value1, value2, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif10NotBetween(Double value1, Double value2) {
            addCriterion("CBIF10 not between", value1, value2, "cbif10");
            return (Criteria) this;
        }

        public Criteria andCbif11IsNull() {
            addCriterion("CBIF11 is null");
            return (Criteria) this;
        }

        public Criteria andCbif11IsNotNull() {
            addCriterion("CBIF11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif11EqualTo(Double value) {
            addCriterion("CBIF11 =", value, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11NotEqualTo(Double value) {
            addCriterion("CBIF11 <>", value, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11GreaterThan(Double value) {
            addCriterion("CBIF11 >", value, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIF11 >=", value, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11LessThan(Double value) {
            addCriterion("CBIF11 <", value, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11LessThanOrEqualTo(Double value) {
            addCriterion("CBIF11 <=", value, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11In(List<Double> values) {
            addCriterion("CBIF11 in", values, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11NotIn(List<Double> values) {
            addCriterion("CBIF11 not in", values, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11Between(Double value1, Double value2) {
            addCriterion("CBIF11 between", value1, value2, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif11NotBetween(Double value1, Double value2) {
            addCriterion("CBIF11 not between", value1, value2, "cbif11");
            return (Criteria) this;
        }

        public Criteria andCbif12IsNull() {
            addCriterion("CBIF12 is null");
            return (Criteria) this;
        }

        public Criteria andCbif12IsNotNull() {
            addCriterion("CBIF12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif12EqualTo(Double value) {
            addCriterion("CBIF12 =", value, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12NotEqualTo(Double value) {
            addCriterion("CBIF12 <>", value, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12GreaterThan(Double value) {
            addCriterion("CBIF12 >", value, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIF12 >=", value, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12LessThan(Double value) {
            addCriterion("CBIF12 <", value, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12LessThanOrEqualTo(Double value) {
            addCriterion("CBIF12 <=", value, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12In(List<Double> values) {
            addCriterion("CBIF12 in", values, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12NotIn(List<Double> values) {
            addCriterion("CBIF12 not in", values, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12Between(Double value1, Double value2) {
            addCriterion("CBIF12 between", value1, value2, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif12NotBetween(Double value1, Double value2) {
            addCriterion("CBIF12 not between", value1, value2, "cbif12");
            return (Criteria) this;
        }

        public Criteria andCbif13IsNull() {
            addCriterion("CBIF13 is null");
            return (Criteria) this;
        }

        public Criteria andCbif13IsNotNull() {
            addCriterion("CBIF13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif13EqualTo(String value) {
            addCriterion("CBIF13 =", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13NotEqualTo(String value) {
            addCriterion("CBIF13 <>", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13GreaterThan(String value) {
            addCriterion("CBIF13 >", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13GreaterThanOrEqualTo(String value) {
            addCriterion("CBIF13 >=", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13LessThan(String value) {
            addCriterion("CBIF13 <", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13LessThanOrEqualTo(String value) {
            addCriterion("CBIF13 <=", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13Like(String value) {
            addCriterion("CBIF13 like", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13NotLike(String value) {
            addCriterion("CBIF13 not like", value, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13In(List<String> values) {
            addCriterion("CBIF13 in", values, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13NotIn(List<String> values) {
            addCriterion("CBIF13 not in", values, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13Between(String value1, String value2) {
            addCriterion("CBIF13 between", value1, value2, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbif13NotBetween(String value1, String value2) {
            addCriterion("CBIF13 not between", value1, value2, "cbif13");
            return (Criteria) this;
        }

        public Criteria andCbie01IsNull() {
            addCriterion("CBIE01 is null");
            return (Criteria) this;
        }

        public Criteria andCbie01IsNotNull() {
            addCriterion("CBIE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie01EqualTo(Integer value) {
            addCriterion("CBIE01 =", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotEqualTo(Integer value) {
            addCriterion("CBIE01 <>", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01GreaterThan(Integer value) {
            addCriterion("CBIE01 >", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE01 >=", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01LessThan(Integer value) {
            addCriterion("CBIE01 <", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE01 <=", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01In(List<Integer> values) {
            addCriterion("CBIE01 in", values, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotIn(List<Integer> values) {
            addCriterion("CBIE01 not in", values, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01Between(Integer value1, Integer value2) {
            addCriterion("CBIE01 between", value1, value2, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE01 not between", value1, value2, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbif14IsNull() {
            addCriterion("CBIF14 is null");
            return (Criteria) this;
        }

        public Criteria andCbif14IsNotNull() {
            addCriterion("CBIF14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbif14EqualTo(Integer value) {
            addCriterion("CBIF14 =", value, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14NotEqualTo(Integer value) {
            addCriterion("CBIF14 <>", value, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14GreaterThan(Integer value) {
            addCriterion("CBIF14 >", value, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIF14 >=", value, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14LessThan(Integer value) {
            addCriterion("CBIF14 <", value, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14LessThanOrEqualTo(Integer value) {
            addCriterion("CBIF14 <=", value, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14In(List<Integer> values) {
            addCriterion("CBIF14 in", values, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14NotIn(List<Integer> values) {
            addCriterion("CBIF14 not in", values, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14Between(Integer value1, Integer value2) {
            addCriterion("CBIF14 between", value1, value2, "cbif14");
            return (Criteria) this;
        }

        public Criteria andCbif14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIF14 not between", value1, value2, "cbif14");
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
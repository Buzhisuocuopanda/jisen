package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbobCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbobCriteria() {
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

        public Criteria andCbob01IsNull() {
            addCriterion("CBOB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbob01IsNotNull() {
            addCriterion("CBOB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob01EqualTo(Integer value) {
            addCriterion("CBOB01 =", value, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01NotEqualTo(Integer value) {
            addCriterion("CBOB01 <>", value, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01GreaterThan(Integer value) {
            addCriterion("CBOB01 >", value, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB01 >=", value, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01LessThan(Integer value) {
            addCriterion("CBOB01 <", value, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB01 <=", value, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01In(List<Integer> values) {
            addCriterion("CBOB01 in", values, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01NotIn(List<Integer> values) {
            addCriterion("CBOB01 not in", values, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01Between(Integer value1, Integer value2) {
            addCriterion("CBOB01 between", value1, value2, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB01 not between", value1, value2, "cbob01");
            return (Criteria) this;
        }

        public Criteria andCbob02IsNull() {
            addCriterion("CBOB02 is null");
            return (Criteria) this;
        }

        public Criteria andCbob02IsNotNull() {
            addCriterion("CBOB02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob02EqualTo(Integer value) {
            addCriterion("CBOB02 =", value, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02NotEqualTo(Integer value) {
            addCriterion("CBOB02 <>", value, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02GreaterThan(Integer value) {
            addCriterion("CBOB02 >", value, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB02 >=", value, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02LessThan(Integer value) {
            addCriterion("CBOB02 <", value, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB02 <=", value, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02In(List<Integer> values) {
            addCriterion("CBOB02 in", values, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02NotIn(List<Integer> values) {
            addCriterion("CBOB02 not in", values, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02Between(Integer value1, Integer value2) {
            addCriterion("CBOB02 between", value1, value2, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB02 not between", value1, value2, "cbob02");
            return (Criteria) this;
        }

        public Criteria andCbob03IsNull() {
            addCriterion("CBOB03 is null");
            return (Criteria) this;
        }

        public Criteria andCbob03IsNotNull() {
            addCriterion("CBOB03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob03EqualTo(Date value) {
            addCriterion("CBOB03 =", value, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03NotEqualTo(Date value) {
            addCriterion("CBOB03 <>", value, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03GreaterThan(Date value) {
            addCriterion("CBOB03 >", value, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOB03 >=", value, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03LessThan(Date value) {
            addCriterion("CBOB03 <", value, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03LessThanOrEqualTo(Date value) {
            addCriterion("CBOB03 <=", value, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03In(List<Date> values) {
            addCriterion("CBOB03 in", values, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03NotIn(List<Date> values) {
            addCriterion("CBOB03 not in", values, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03Between(Date value1, Date value2) {
            addCriterion("CBOB03 between", value1, value2, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob03NotBetween(Date value1, Date value2) {
            addCriterion("CBOB03 not between", value1, value2, "cbob03");
            return (Criteria) this;
        }

        public Criteria andCbob04IsNull() {
            addCriterion("CBOB04 is null");
            return (Criteria) this;
        }

        public Criteria andCbob04IsNotNull() {
            addCriterion("CBOB04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob04EqualTo(Integer value) {
            addCriterion("CBOB04 =", value, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04NotEqualTo(Integer value) {
            addCriterion("CBOB04 <>", value, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04GreaterThan(Integer value) {
            addCriterion("CBOB04 >", value, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB04 >=", value, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04LessThan(Integer value) {
            addCriterion("CBOB04 <", value, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB04 <=", value, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04In(List<Integer> values) {
            addCriterion("CBOB04 in", values, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04NotIn(List<Integer> values) {
            addCriterion("CBOB04 not in", values, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04Between(Integer value1, Integer value2) {
            addCriterion("CBOB04 between", value1, value2, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB04 not between", value1, value2, "cbob04");
            return (Criteria) this;
        }

        public Criteria andCbob05IsNull() {
            addCriterion("CBOB05 is null");
            return (Criteria) this;
        }

        public Criteria andCbob05IsNotNull() {
            addCriterion("CBOB05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob05EqualTo(Date value) {
            addCriterion("CBOB05 =", value, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05NotEqualTo(Date value) {
            addCriterion("CBOB05 <>", value, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05GreaterThan(Date value) {
            addCriterion("CBOB05 >", value, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOB05 >=", value, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05LessThan(Date value) {
            addCriterion("CBOB05 <", value, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05LessThanOrEqualTo(Date value) {
            addCriterion("CBOB05 <=", value, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05In(List<Date> values) {
            addCriterion("CBOB05 in", values, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05NotIn(List<Date> values) {
            addCriterion("CBOB05 not in", values, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05Between(Date value1, Date value2) {
            addCriterion("CBOB05 between", value1, value2, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob05NotBetween(Date value1, Date value2) {
            addCriterion("CBOB05 not between", value1, value2, "cbob05");
            return (Criteria) this;
        }

        public Criteria andCbob06IsNull() {
            addCriterion("CBOB06 is null");
            return (Criteria) this;
        }

        public Criteria andCbob06IsNotNull() {
            addCriterion("CBOB06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob06EqualTo(Integer value) {
            addCriterion("CBOB06 =", value, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06NotEqualTo(Integer value) {
            addCriterion("CBOB06 <>", value, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06GreaterThan(Integer value) {
            addCriterion("CBOB06 >", value, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB06 >=", value, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06LessThan(Integer value) {
            addCriterion("CBOB06 <", value, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB06 <=", value, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06In(List<Integer> values) {
            addCriterion("CBOB06 in", values, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06NotIn(List<Integer> values) {
            addCriterion("CBOB06 not in", values, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06Between(Integer value1, Integer value2) {
            addCriterion("CBOB06 between", value1, value2, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB06 not between", value1, value2, "cbob06");
            return (Criteria) this;
        }

        public Criteria andCbob07IsNull() {
            addCriterion("CBOB07 is null");
            return (Criteria) this;
        }

        public Criteria andCbob07IsNotNull() {
            addCriterion("CBOB07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob07EqualTo(Integer value) {
            addCriterion("CBOB07 =", value, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07NotEqualTo(Integer value) {
            addCriterion("CBOB07 <>", value, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07GreaterThan(Integer value) {
            addCriterion("CBOB07 >", value, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB07 >=", value, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07LessThan(Integer value) {
            addCriterion("CBOB07 <", value, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB07 <=", value, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07In(List<Integer> values) {
            addCriterion("CBOB07 in", values, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07NotIn(List<Integer> values) {
            addCriterion("CBOB07 not in", values, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07Between(Integer value1, Integer value2) {
            addCriterion("CBOB07 between", value1, value2, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB07 not between", value1, value2, "cbob07");
            return (Criteria) this;
        }

        public Criteria andCbob08IsNull() {
            addCriterion("CBOB08 is null");
            return (Criteria) this;
        }

        public Criteria andCbob08IsNotNull() {
            addCriterion("CBOB08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob08EqualTo(Integer value) {
            addCriterion("CBOB08 =", value, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08NotEqualTo(Integer value) {
            addCriterion("CBOB08 <>", value, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08GreaterThan(Integer value) {
            addCriterion("CBOB08 >", value, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB08 >=", value, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08LessThan(Integer value) {
            addCriterion("CBOB08 <", value, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB08 <=", value, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08In(List<Integer> values) {
            addCriterion("CBOB08 in", values, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08NotIn(List<Integer> values) {
            addCriterion("CBOB08 not in", values, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08Between(Integer value1, Integer value2) {
            addCriterion("CBOB08 between", value1, value2, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB08 not between", value1, value2, "cbob08");
            return (Criteria) this;
        }

        public Criteria andCbob09IsNull() {
            addCriterion("CBOB09 is null");
            return (Criteria) this;
        }

        public Criteria andCbob09IsNotNull() {
            addCriterion("CBOB09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob09EqualTo(Double value) {
            addCriterion("CBOB09 =", value, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09NotEqualTo(Double value) {
            addCriterion("CBOB09 <>", value, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09GreaterThan(Double value) {
            addCriterion("CBOB09 >", value, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOB09 >=", value, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09LessThan(Double value) {
            addCriterion("CBOB09 <", value, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09LessThanOrEqualTo(Double value) {
            addCriterion("CBOB09 <=", value, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09In(List<Double> values) {
            addCriterion("CBOB09 in", values, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09NotIn(List<Double> values) {
            addCriterion("CBOB09 not in", values, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09Between(Double value1, Double value2) {
            addCriterion("CBOB09 between", value1, value2, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob09NotBetween(Double value1, Double value2) {
            addCriterion("CBOB09 not between", value1, value2, "cbob09");
            return (Criteria) this;
        }

        public Criteria andCbob10IsNull() {
            addCriterion("CBOB10 is null");
            return (Criteria) this;
        }

        public Criteria andCbob10IsNotNull() {
            addCriterion("CBOB10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob10EqualTo(Double value) {
            addCriterion("CBOB10 =", value, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10NotEqualTo(Double value) {
            addCriterion("CBOB10 <>", value, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10GreaterThan(Double value) {
            addCriterion("CBOB10 >", value, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOB10 >=", value, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10LessThan(Double value) {
            addCriterion("CBOB10 <", value, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10LessThanOrEqualTo(Double value) {
            addCriterion("CBOB10 <=", value, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10In(List<Double> values) {
            addCriterion("CBOB10 in", values, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10NotIn(List<Double> values) {
            addCriterion("CBOB10 not in", values, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10Between(Double value1, Double value2) {
            addCriterion("CBOB10 between", value1, value2, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob10NotBetween(Double value1, Double value2) {
            addCriterion("CBOB10 not between", value1, value2, "cbob10");
            return (Criteria) this;
        }

        public Criteria andCbob11IsNull() {
            addCriterion("CBOB11 is null");
            return (Criteria) this;
        }

        public Criteria andCbob11IsNotNull() {
            addCriterion("CBOB11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob11EqualTo(Double value) {
            addCriterion("CBOB11 =", value, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11NotEqualTo(Double value) {
            addCriterion("CBOB11 <>", value, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11GreaterThan(Double value) {
            addCriterion("CBOB11 >", value, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOB11 >=", value, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11LessThan(Double value) {
            addCriterion("CBOB11 <", value, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11LessThanOrEqualTo(Double value) {
            addCriterion("CBOB11 <=", value, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11In(List<Double> values) {
            addCriterion("CBOB11 in", values, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11NotIn(List<Double> values) {
            addCriterion("CBOB11 not in", values, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11Between(Double value1, Double value2) {
            addCriterion("CBOB11 between", value1, value2, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob11NotBetween(Double value1, Double value2) {
            addCriterion("CBOB11 not between", value1, value2, "cbob11");
            return (Criteria) this;
        }

        public Criteria andCbob12IsNull() {
            addCriterion("CBOB12 is null");
            return (Criteria) this;
        }

        public Criteria andCbob12IsNotNull() {
            addCriterion("CBOB12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob12EqualTo(Double value) {
            addCriterion("CBOB12 =", value, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12NotEqualTo(Double value) {
            addCriterion("CBOB12 <>", value, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12GreaterThan(Double value) {
            addCriterion("CBOB12 >", value, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOB12 >=", value, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12LessThan(Double value) {
            addCriterion("CBOB12 <", value, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12LessThanOrEqualTo(Double value) {
            addCriterion("CBOB12 <=", value, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12In(List<Double> values) {
            addCriterion("CBOB12 in", values, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12NotIn(List<Double> values) {
            addCriterion("CBOB12 not in", values, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12Between(Double value1, Double value2) {
            addCriterion("CBOB12 between", value1, value2, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob12NotBetween(Double value1, Double value2) {
            addCriterion("CBOB12 not between", value1, value2, "cbob12");
            return (Criteria) this;
        }

        public Criteria andCbob13IsNull() {
            addCriterion("CBOB13 is null");
            return (Criteria) this;
        }

        public Criteria andCbob13IsNotNull() {
            addCriterion("CBOB13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob13EqualTo(String value) {
            addCriterion("CBOB13 =", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13NotEqualTo(String value) {
            addCriterion("CBOB13 <>", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13GreaterThan(String value) {
            addCriterion("CBOB13 >", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13GreaterThanOrEqualTo(String value) {
            addCriterion("CBOB13 >=", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13LessThan(String value) {
            addCriterion("CBOB13 <", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13LessThanOrEqualTo(String value) {
            addCriterion("CBOB13 <=", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13Like(String value) {
            addCriterion("CBOB13 like", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13NotLike(String value) {
            addCriterion("CBOB13 not like", value, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13In(List<String> values) {
            addCriterion("CBOB13 in", values, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13NotIn(List<String> values) {
            addCriterion("CBOB13 not in", values, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13Between(String value1, String value2) {
            addCriterion("CBOB13 between", value1, value2, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCbob13NotBetween(String value1, String value2) {
            addCriterion("CBOB13 not between", value1, value2, "cbob13");
            return (Criteria) this;
        }

        public Criteria andCboa01IsNull() {
            addCriterion("CBOA01 is null");
            return (Criteria) this;
        }

        public Criteria andCboa01IsNotNull() {
            addCriterion("CBOA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa01EqualTo(Integer value) {
            addCriterion("CBOA01 =", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01NotEqualTo(Integer value) {
            addCriterion("CBOA01 <>", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01GreaterThan(Integer value) {
            addCriterion("CBOA01 >", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA01 >=", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01LessThan(Integer value) {
            addCriterion("CBOA01 <", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA01 <=", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01In(List<Integer> values) {
            addCriterion("CBOA01 in", values, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01NotIn(List<Integer> values) {
            addCriterion("CBOA01 not in", values, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01Between(Integer value1, Integer value2) {
            addCriterion("CBOA01 between", value1, value2, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA01 not between", value1, value2, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCbob14IsNull() {
            addCriterion("CBOB14 is null");
            return (Criteria) this;
        }

        public Criteria andCbob14IsNotNull() {
            addCriterion("CBOB14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob14EqualTo(Double value) {
            addCriterion("CBOB14 =", value, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14NotEqualTo(Double value) {
            addCriterion("CBOB14 <>", value, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14GreaterThan(Double value) {
            addCriterion("CBOB14 >", value, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOB14 >=", value, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14LessThan(Double value) {
            addCriterion("CBOB14 <", value, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14LessThanOrEqualTo(Double value) {
            addCriterion("CBOB14 <=", value, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14In(List<Double> values) {
            addCriterion("CBOB14 in", values, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14NotIn(List<Double> values) {
            addCriterion("CBOB14 not in", values, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14Between(Double value1, Double value2) {
            addCriterion("CBOB14 between", value1, value2, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob14NotBetween(Double value1, Double value2) {
            addCriterion("CBOB14 not between", value1, value2, "cbob14");
            return (Criteria) this;
        }

        public Criteria andCbob15IsNull() {
            addCriterion("CBOB15 is null");
            return (Criteria) this;
        }

        public Criteria andCbob15IsNotNull() {
            addCriterion("CBOB15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob15EqualTo(Double value) {
            addCriterion("CBOB15 =", value, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15NotEqualTo(Double value) {
            addCriterion("CBOB15 <>", value, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15GreaterThan(Double value) {
            addCriterion("CBOB15 >", value, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOB15 >=", value, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15LessThan(Double value) {
            addCriterion("CBOB15 <", value, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15LessThanOrEqualTo(Double value) {
            addCriterion("CBOB15 <=", value, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15In(List<Double> values) {
            addCriterion("CBOB15 in", values, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15NotIn(List<Double> values) {
            addCriterion("CBOB15 not in", values, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15Between(Double value1, Double value2) {
            addCriterion("CBOB15 between", value1, value2, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob15NotBetween(Double value1, Double value2) {
            addCriterion("CBOB15 not between", value1, value2, "cbob15");
            return (Criteria) this;
        }

        public Criteria andCbob16IsNull() {
            addCriterion("CBOB16 is null");
            return (Criteria) this;
        }

        public Criteria andCbob16IsNotNull() {
            addCriterion("CBOB16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob16EqualTo(Integer value) {
            addCriterion("CBOB16 =", value, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16NotEqualTo(Integer value) {
            addCriterion("CBOB16 <>", value, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16GreaterThan(Integer value) {
            addCriterion("CBOB16 >", value, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB16 >=", value, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16LessThan(Integer value) {
            addCriterion("CBOB16 <", value, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB16 <=", value, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16In(List<Integer> values) {
            addCriterion("CBOB16 in", values, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16NotIn(List<Integer> values) {
            addCriterion("CBOB16 not in", values, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16Between(Integer value1, Integer value2) {
            addCriterion("CBOB16 between", value1, value2, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB16 not between", value1, value2, "cbob16");
            return (Criteria) this;
        }

        public Criteria andCbob17IsNull() {
            addCriterion("CBOB17 is null");
            return (Criteria) this;
        }

        public Criteria andCbob17IsNotNull() {
            addCriterion("CBOB17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob17EqualTo(Integer value) {
            addCriterion("CBOB17 =", value, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17NotEqualTo(Integer value) {
            addCriterion("CBOB17 <>", value, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17GreaterThan(Integer value) {
            addCriterion("CBOB17 >", value, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOB17 >=", value, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17LessThan(Integer value) {
            addCriterion("CBOB17 <", value, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17LessThanOrEqualTo(Integer value) {
            addCriterion("CBOB17 <=", value, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17In(List<Integer> values) {
            addCriterion("CBOB17 in", values, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17NotIn(List<Integer> values) {
            addCriterion("CBOB17 not in", values, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17Between(Integer value1, Integer value2) {
            addCriterion("CBOB17 between", value1, value2, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob17NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOB17 not between", value1, value2, "cbob17");
            return (Criteria) this;
        }

        public Criteria andCbob18IsNull() {
            addCriterion("CBOB18 is null");
            return (Criteria) this;
        }

        public Criteria andCbob18IsNotNull() {
            addCriterion("CBOB18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbob18EqualTo(String value) {
            addCriterion("CBOB18 =", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18NotEqualTo(String value) {
            addCriterion("CBOB18 <>", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18GreaterThan(String value) {
            addCriterion("CBOB18 >", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18GreaterThanOrEqualTo(String value) {
            addCriterion("CBOB18 >=", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18LessThan(String value) {
            addCriterion("CBOB18 <", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18LessThanOrEqualTo(String value) {
            addCriterion("CBOB18 <=", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18Like(String value) {
            addCriterion("CBOB18 like", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18NotLike(String value) {
            addCriterion("CBOB18 not like", value, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18In(List<String> values) {
            addCriterion("CBOB18 in", values, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18NotIn(List<String> values) {
            addCriterion("CBOB18 not in", values, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18Between(String value1, String value2) {
            addCriterion("CBOB18 between", value1, value2, "cbob18");
            return (Criteria) this;
        }

        public Criteria andCbob18NotBetween(String value1, String value2) {
            addCriterion("CBOB18 not between", value1, value2, "cbob18");
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
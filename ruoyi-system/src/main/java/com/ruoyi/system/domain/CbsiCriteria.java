package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsiCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsiCriteria() {
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

        public Criteria andCbsi01IsNull() {
            addCriterion("CBSI01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi01IsNotNull() {
            addCriterion("CBSI01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi01EqualTo(Integer value) {
            addCriterion("CBSI01 =", value, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01NotEqualTo(Integer value) {
            addCriterion("CBSI01 <>", value, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01GreaterThan(Integer value) {
            addCriterion("CBSI01 >", value, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSI01 >=", value, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01LessThan(Integer value) {
            addCriterion("CBSI01 <", value, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSI01 <=", value, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01In(List<Integer> values) {
            addCriterion("CBSI01 in", values, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01NotIn(List<Integer> values) {
            addCriterion("CBSI01 not in", values, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01Between(Integer value1, Integer value2) {
            addCriterion("CBSI01 between", value1, value2, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSI01 not between", value1, value2, "cbsi01");
            return (Criteria) this;
        }

        public Criteria andCbsi02IsNull() {
            addCriterion("CBSI02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi02IsNotNull() {
            addCriterion("CBSI02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi02EqualTo(Integer value) {
            addCriterion("CBSI02 =", value, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02NotEqualTo(Integer value) {
            addCriterion("CBSI02 <>", value, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02GreaterThan(Integer value) {
            addCriterion("CBSI02 >", value, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSI02 >=", value, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02LessThan(Integer value) {
            addCriterion("CBSI02 <", value, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02LessThanOrEqualTo(Integer value) {
            addCriterion("CBSI02 <=", value, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02In(List<Integer> values) {
            addCriterion("CBSI02 in", values, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02NotIn(List<Integer> values) {
            addCriterion("CBSI02 not in", values, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02Between(Integer value1, Integer value2) {
            addCriterion("CBSI02 between", value1, value2, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSI02 not between", value1, value2, "cbsi02");
            return (Criteria) this;
        }

        public Criteria andCbsi03IsNull() {
            addCriterion("CBSI03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi03IsNotNull() {
            addCriterion("CBSI03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi03EqualTo(Date value) {
            addCriterion("CBSI03 =", value, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03NotEqualTo(Date value) {
            addCriterion("CBSI03 <>", value, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03GreaterThan(Date value) {
            addCriterion("CBSI03 >", value, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSI03 >=", value, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03LessThan(Date value) {
            addCriterion("CBSI03 <", value, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03LessThanOrEqualTo(Date value) {
            addCriterion("CBSI03 <=", value, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03In(List<Date> values) {
            addCriterion("CBSI03 in", values, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03NotIn(List<Date> values) {
            addCriterion("CBSI03 not in", values, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03Between(Date value1, Date value2) {
            addCriterion("CBSI03 between", value1, value2, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi03NotBetween(Date value1, Date value2) {
            addCriterion("CBSI03 not between", value1, value2, "cbsi03");
            return (Criteria) this;
        }

        public Criteria andCbsi04IsNull() {
            addCriterion("CBSI04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi04IsNotNull() {
            addCriterion("CBSI04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi04EqualTo(Date value) {
            addCriterion("CBSI04 =", value, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04NotEqualTo(Date value) {
            addCriterion("CBSI04 <>", value, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04GreaterThan(Date value) {
            addCriterion("CBSI04 >", value, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSI04 >=", value, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04LessThan(Date value) {
            addCriterion("CBSI04 <", value, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04LessThanOrEqualTo(Date value) {
            addCriterion("CBSI04 <=", value, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04In(List<Date> values) {
            addCriterion("CBSI04 in", values, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04NotIn(List<Date> values) {
            addCriterion("CBSI04 not in", values, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04Between(Date value1, Date value2) {
            addCriterion("CBSI04 between", value1, value2, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi04NotBetween(Date value1, Date value2) {
            addCriterion("CBSI04 not between", value1, value2, "cbsi04");
            return (Criteria) this;
        }

        public Criteria andCbsi05IsNull() {
            addCriterion("CBSI05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi05IsNotNull() {
            addCriterion("CBSI05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi05EqualTo(Integer value) {
            addCriterion("CBSI05 =", value, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05NotEqualTo(Integer value) {
            addCriterion("CBSI05 <>", value, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05GreaterThan(Integer value) {
            addCriterion("CBSI05 >", value, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSI05 >=", value, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05LessThan(Integer value) {
            addCriterion("CBSI05 <", value, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05LessThanOrEqualTo(Integer value) {
            addCriterion("CBSI05 <=", value, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05In(List<Integer> values) {
            addCriterion("CBSI05 in", values, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05NotIn(List<Integer> values) {
            addCriterion("CBSI05 not in", values, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05Between(Integer value1, Integer value2) {
            addCriterion("CBSI05 between", value1, value2, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSI05 not between", value1, value2, "cbsi05");
            return (Criteria) this;
        }

        public Criteria andCbsi06IsNull() {
            addCriterion("CBSI06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi06IsNotNull() {
            addCriterion("CBSI06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi06EqualTo(Integer value) {
            addCriterion("CBSI06 =", value, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06NotEqualTo(Integer value) {
            addCriterion("CBSI06 <>", value, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06GreaterThan(Integer value) {
            addCriterion("CBSI06 >", value, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSI06 >=", value, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06LessThan(Integer value) {
            addCriterion("CBSI06 <", value, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSI06 <=", value, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06In(List<Integer> values) {
            addCriterion("CBSI06 in", values, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06NotIn(List<Integer> values) {
            addCriterion("CBSI06 not in", values, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06Between(Integer value1, Integer value2) {
            addCriterion("CBSI06 between", value1, value2, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSI06 not between", value1, value2, "cbsi06");
            return (Criteria) this;
        }

        public Criteria andCbsi07IsNull() {
            addCriterion("CBSI07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi07IsNotNull() {
            addCriterion("CBSI07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi07EqualTo(Integer value) {
            addCriterion("CBSI07 =", value, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07NotEqualTo(Integer value) {
            addCriterion("CBSI07 <>", value, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07GreaterThan(Integer value) {
            addCriterion("CBSI07 >", value, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSI07 >=", value, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07LessThan(Integer value) {
            addCriterion("CBSI07 <", value, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07LessThanOrEqualTo(Integer value) {
            addCriterion("CBSI07 <=", value, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07In(List<Integer> values) {
            addCriterion("CBSI07 in", values, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07NotIn(List<Integer> values) {
            addCriterion("CBSI07 not in", values, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07Between(Integer value1, Integer value2) {
            addCriterion("CBSI07 between", value1, value2, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSI07 not between", value1, value2, "cbsi07");
            return (Criteria) this;
        }

        public Criteria andCbsi08IsNull() {
            addCriterion("CBSI08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi08IsNotNull() {
            addCriterion("CBSI08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi08EqualTo(Integer value) {
            addCriterion("CBSI08 =", value, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08NotEqualTo(Integer value) {
            addCriterion("CBSI08 <>", value, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08GreaterThan(Integer value) {
            addCriterion("CBSI08 >", value, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSI08 >=", value, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08LessThan(Integer value) {
            addCriterion("CBSI08 <", value, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08LessThanOrEqualTo(Integer value) {
            addCriterion("CBSI08 <=", value, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08In(List<Integer> values) {
            addCriterion("CBSI08 in", values, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08NotIn(List<Integer> values) {
            addCriterion("CBSI08 not in", values, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08Between(Integer value1, Integer value2) {
            addCriterion("CBSI08 between", value1, value2, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSI08 not between", value1, value2, "cbsi08");
            return (Criteria) this;
        }

        public Criteria andCbsi09IsNull() {
            addCriterion("CBSI09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi09IsNotNull() {
            addCriterion("CBSI09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi09EqualTo(Double value) {
            addCriterion("CBSI09 =", value, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09NotEqualTo(Double value) {
            addCriterion("CBSI09 <>", value, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09GreaterThan(Double value) {
            addCriterion("CBSI09 >", value, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSI09 >=", value, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09LessThan(Double value) {
            addCriterion("CBSI09 <", value, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09LessThanOrEqualTo(Double value) {
            addCriterion("CBSI09 <=", value, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09In(List<Double> values) {
            addCriterion("CBSI09 in", values, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09NotIn(List<Double> values) {
            addCriterion("CBSI09 not in", values, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09Between(Double value1, Double value2) {
            addCriterion("CBSI09 between", value1, value2, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi09NotBetween(Double value1, Double value2) {
            addCriterion("CBSI09 not between", value1, value2, "cbsi09");
            return (Criteria) this;
        }

        public Criteria andCbsi10IsNull() {
            addCriterion("CBSI10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi10IsNotNull() {
            addCriterion("CBSI10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi10EqualTo(Double value) {
            addCriterion("CBSI10 =", value, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10NotEqualTo(Double value) {
            addCriterion("CBSI10 <>", value, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10GreaterThan(Double value) {
            addCriterion("CBSI10 >", value, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSI10 >=", value, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10LessThan(Double value) {
            addCriterion("CBSI10 <", value, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10LessThanOrEqualTo(Double value) {
            addCriterion("CBSI10 <=", value, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10In(List<Double> values) {
            addCriterion("CBSI10 in", values, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10NotIn(List<Double> values) {
            addCriterion("CBSI10 not in", values, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10Between(Double value1, Double value2) {
            addCriterion("CBSI10 between", value1, value2, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi10NotBetween(Double value1, Double value2) {
            addCriterion("CBSI10 not between", value1, value2, "cbsi10");
            return (Criteria) this;
        }

        public Criteria andCbsi11IsNull() {
            addCriterion("CBSI11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi11IsNotNull() {
            addCriterion("CBSI11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi11EqualTo(String value) {
            addCriterion("CBSI11 =", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11NotEqualTo(String value) {
            addCriterion("CBSI11 <>", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11GreaterThan(String value) {
            addCriterion("CBSI11 >", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11GreaterThanOrEqualTo(String value) {
            addCriterion("CBSI11 >=", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11LessThan(String value) {
            addCriterion("CBSI11 <", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11LessThanOrEqualTo(String value) {
            addCriterion("CBSI11 <=", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11Like(String value) {
            addCriterion("CBSI11 like", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11NotLike(String value) {
            addCriterion("CBSI11 not like", value, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11In(List<String> values) {
            addCriterion("CBSI11 in", values, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11NotIn(List<String> values) {
            addCriterion("CBSI11 not in", values, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11Between(String value1, String value2) {
            addCriterion("CBSI11 between", value1, value2, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi11NotBetween(String value1, String value2) {
            addCriterion("CBSI11 not between", value1, value2, "cbsi11");
            return (Criteria) this;
        }

        public Criteria andCbsi12IsNull() {
            addCriterion("CBSI12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi12IsNotNull() {
            addCriterion("CBSI12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi12EqualTo(Double value) {
            addCriterion("CBSI12 =", value, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12NotEqualTo(Double value) {
            addCriterion("CBSI12 <>", value, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12GreaterThan(Double value) {
            addCriterion("CBSI12 >", value, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSI12 >=", value, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12LessThan(Double value) {
            addCriterion("CBSI12 <", value, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12LessThanOrEqualTo(Double value) {
            addCriterion("CBSI12 <=", value, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12In(List<Double> values) {
            addCriterion("CBSI12 in", values, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12NotIn(List<Double> values) {
            addCriterion("CBSI12 not in", values, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12Between(Double value1, Double value2) {
            addCriterion("CBSI12 between", value1, value2, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi12NotBetween(Double value1, Double value2) {
            addCriterion("CBSI12 not between", value1, value2, "cbsi12");
            return (Criteria) this;
        }

        public Criteria andCbsi13IsNull() {
            addCriterion("CBSI13 is null");
            return (Criteria) this;
        }

        public Criteria andCbsi13IsNotNull() {
            addCriterion("CBSI13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsi13EqualTo(Double value) {
            addCriterion("CBSI13 =", value, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13NotEqualTo(Double value) {
            addCriterion("CBSI13 <>", value, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13GreaterThan(Double value) {
            addCriterion("CBSI13 >", value, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13GreaterThanOrEqualTo(Double value) {
            addCriterion("CBSI13 >=", value, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13LessThan(Double value) {
            addCriterion("CBSI13 <", value, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13LessThanOrEqualTo(Double value) {
            addCriterion("CBSI13 <=", value, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13In(List<Double> values) {
            addCriterion("CBSI13 in", values, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13NotIn(List<Double> values) {
            addCriterion("CBSI13 not in", values, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13Between(Double value1, Double value2) {
            addCriterion("CBSI13 between", value1, value2, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsi13NotBetween(Double value1, Double value2) {
            addCriterion("CBSI13 not between", value1, value2, "cbsi13");
            return (Criteria) this;
        }

        public Criteria andCbsh01IsNull() {
            addCriterion("CBSH01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh01IsNotNull() {
            addCriterion("CBSH01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh01EqualTo(Integer value) {
            addCriterion("CBSH01 =", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01NotEqualTo(Integer value) {
            addCriterion("CBSH01 <>", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01GreaterThan(Integer value) {
            addCriterion("CBSH01 >", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH01 >=", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01LessThan(Integer value) {
            addCriterion("CBSH01 <", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH01 <=", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01In(List<Integer> values) {
            addCriterion("CBSH01 in", values, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01NotIn(List<Integer> values) {
            addCriterion("CBSH01 not in", values, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01Between(Integer value1, Integer value2) {
            addCriterion("CBSH01 between", value1, value2, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH01 not between", value1, value2, "cbsh01");
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
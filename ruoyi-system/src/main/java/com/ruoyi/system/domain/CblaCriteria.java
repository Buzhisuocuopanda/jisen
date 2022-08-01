package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CblaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CblaCriteria() {
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

        public Criteria andCbla01IsNull() {
            addCriterion("CBLA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbla01IsNotNull() {
            addCriterion("CBLA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla01EqualTo(Integer value) {
            addCriterion("CBLA01 =", value, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01NotEqualTo(Integer value) {
            addCriterion("CBLA01 <>", value, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01GreaterThan(Integer value) {
            addCriterion("CBLA01 >", value, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBLA01 >=", value, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01LessThan(Integer value) {
            addCriterion("CBLA01 <", value, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01LessThanOrEqualTo(Integer value) {
            addCriterion("CBLA01 <=", value, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01In(List<Integer> values) {
            addCriterion("CBLA01 in", values, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01NotIn(List<Integer> values) {
            addCriterion("CBLA01 not in", values, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01Between(Integer value1, Integer value2) {
            addCriterion("CBLA01 between", value1, value2, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBLA01 not between", value1, value2, "cbla01");
            return (Criteria) this;
        }

        public Criteria andCbla02IsNull() {
            addCriterion("CBLA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbla02IsNotNull() {
            addCriterion("CBLA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla02EqualTo(Date value) {
            addCriterion("CBLA02 =", value, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02NotEqualTo(Date value) {
            addCriterion("CBLA02 <>", value, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02GreaterThan(Date value) {
            addCriterion("CBLA02 >", value, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBLA02 >=", value, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02LessThan(Date value) {
            addCriterion("CBLA02 <", value, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02LessThanOrEqualTo(Date value) {
            addCriterion("CBLA02 <=", value, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02In(List<Date> values) {
            addCriterion("CBLA02 in", values, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02NotIn(List<Date> values) {
            addCriterion("CBLA02 not in", values, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02Between(Date value1, Date value2) {
            addCriterion("CBLA02 between", value1, value2, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla02NotBetween(Date value1, Date value2) {
            addCriterion("CBLA02 not between", value1, value2, "cbla02");
            return (Criteria) this;
        }

        public Criteria andCbla03IsNull() {
            addCriterion("CBLA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbla03IsNotNull() {
            addCriterion("CBLA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla03EqualTo(Integer value) {
            addCriterion("CBLA03 =", value, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03NotEqualTo(Integer value) {
            addCriterion("CBLA03 <>", value, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03GreaterThan(Integer value) {
            addCriterion("CBLA03 >", value, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBLA03 >=", value, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03LessThan(Integer value) {
            addCriterion("CBLA03 <", value, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03LessThanOrEqualTo(Integer value) {
            addCriterion("CBLA03 <=", value, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03In(List<Integer> values) {
            addCriterion("CBLA03 in", values, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03NotIn(List<Integer> values) {
            addCriterion("CBLA03 not in", values, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03Between(Integer value1, Integer value2) {
            addCriterion("CBLA03 between", value1, value2, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBLA03 not between", value1, value2, "cbla03");
            return (Criteria) this;
        }

        public Criteria andCbla04IsNull() {
            addCriterion("CBLA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbla04IsNotNull() {
            addCriterion("CBLA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla04EqualTo(Date value) {
            addCriterion("CBLA04 =", value, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04NotEqualTo(Date value) {
            addCriterion("CBLA04 <>", value, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04GreaterThan(Date value) {
            addCriterion("CBLA04 >", value, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBLA04 >=", value, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04LessThan(Date value) {
            addCriterion("CBLA04 <", value, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04LessThanOrEqualTo(Date value) {
            addCriterion("CBLA04 <=", value, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04In(List<Date> values) {
            addCriterion("CBLA04 in", values, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04NotIn(List<Date> values) {
            addCriterion("CBLA04 not in", values, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04Between(Date value1, Date value2) {
            addCriterion("CBLA04 between", value1, value2, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla04NotBetween(Date value1, Date value2) {
            addCriterion("CBLA04 not between", value1, value2, "cbla04");
            return (Criteria) this;
        }

        public Criteria andCbla05IsNull() {
            addCriterion("CBLA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbla05IsNotNull() {
            addCriterion("CBLA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla05EqualTo(Integer value) {
            addCriterion("CBLA05 =", value, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05NotEqualTo(Integer value) {
            addCriterion("CBLA05 <>", value, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05GreaterThan(Integer value) {
            addCriterion("CBLA05 >", value, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBLA05 >=", value, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05LessThan(Integer value) {
            addCriterion("CBLA05 <", value, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05LessThanOrEqualTo(Integer value) {
            addCriterion("CBLA05 <=", value, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05In(List<Integer> values) {
            addCriterion("CBLA05 in", values, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05NotIn(List<Integer> values) {
            addCriterion("CBLA05 not in", values, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05Between(Integer value1, Integer value2) {
            addCriterion("CBLA05 between", value1, value2, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBLA05 not between", value1, value2, "cbla05");
            return (Criteria) this;
        }

        public Criteria andCbla06IsNull() {
            addCriterion("CBLA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbla06IsNotNull() {
            addCriterion("CBLA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla06EqualTo(Integer value) {
            addCriterion("CBLA06 =", value, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06NotEqualTo(Integer value) {
            addCriterion("CBLA06 <>", value, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06GreaterThan(Integer value) {
            addCriterion("CBLA06 >", value, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBLA06 >=", value, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06LessThan(Integer value) {
            addCriterion("CBLA06 <", value, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06LessThanOrEqualTo(Integer value) {
            addCriterion("CBLA06 <=", value, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06In(List<Integer> values) {
            addCriterion("CBLA06 in", values, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06NotIn(List<Integer> values) {
            addCriterion("CBLA06 not in", values, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06Between(Integer value1, Integer value2) {
            addCriterion("CBLA06 between", value1, value2, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBLA06 not between", value1, value2, "cbla06");
            return (Criteria) this;
        }

        public Criteria andCbla07IsNull() {
            addCriterion("CBLA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbla07IsNotNull() {
            addCriterion("CBLA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla07EqualTo(Integer value) {
            addCriterion("CBLA07 =", value, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07NotEqualTo(Integer value) {
            addCriterion("CBLA07 <>", value, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07GreaterThan(Integer value) {
            addCriterion("CBLA07 >", value, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBLA07 >=", value, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07LessThan(Integer value) {
            addCriterion("CBLA07 <", value, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07LessThanOrEqualTo(Integer value) {
            addCriterion("CBLA07 <=", value, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07In(List<Integer> values) {
            addCriterion("CBLA07 in", values, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07NotIn(List<Integer> values) {
            addCriterion("CBLA07 not in", values, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07Between(Integer value1, Integer value2) {
            addCriterion("CBLA07 between", value1, value2, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBLA07 not between", value1, value2, "cbla07");
            return (Criteria) this;
        }

        public Criteria andCbla08IsNull() {
            addCriterion("CBLA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbla08IsNotNull() {
            addCriterion("CBLA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla08EqualTo(String value) {
            addCriterion("CBLA08 =", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08NotEqualTo(String value) {
            addCriterion("CBLA08 <>", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08GreaterThan(String value) {
            addCriterion("CBLA08 >", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08GreaterThanOrEqualTo(String value) {
            addCriterion("CBLA08 >=", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08LessThan(String value) {
            addCriterion("CBLA08 <", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08LessThanOrEqualTo(String value) {
            addCriterion("CBLA08 <=", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08Like(String value) {
            addCriterion("CBLA08 like", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08NotLike(String value) {
            addCriterion("CBLA08 not like", value, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08In(List<String> values) {
            addCriterion("CBLA08 in", values, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08NotIn(List<String> values) {
            addCriterion("CBLA08 not in", values, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08Between(String value1, String value2) {
            addCriterion("CBLA08 between", value1, value2, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla08NotBetween(String value1, String value2) {
            addCriterion("CBLA08 not between", value1, value2, "cbla08");
            return (Criteria) this;
        }

        public Criteria andCbla09IsNull() {
            addCriterion("CBLA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbla09IsNotNull() {
            addCriterion("CBLA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla09EqualTo(String value) {
            addCriterion("CBLA09 =", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09NotEqualTo(String value) {
            addCriterion("CBLA09 <>", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09GreaterThan(String value) {
            addCriterion("CBLA09 >", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09GreaterThanOrEqualTo(String value) {
            addCriterion("CBLA09 >=", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09LessThan(String value) {
            addCriterion("CBLA09 <", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09LessThanOrEqualTo(String value) {
            addCriterion("CBLA09 <=", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09Like(String value) {
            addCriterion("CBLA09 like", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09NotLike(String value) {
            addCriterion("CBLA09 not like", value, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09In(List<String> values) {
            addCriterion("CBLA09 in", values, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09NotIn(List<String> values) {
            addCriterion("CBLA09 not in", values, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09Between(String value1, String value2) {
            addCriterion("CBLA09 between", value1, value2, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla09NotBetween(String value1, String value2) {
            addCriterion("CBLA09 not between", value1, value2, "cbla09");
            return (Criteria) this;
        }

        public Criteria andCbla10IsNull() {
            addCriterion("CBLA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbla10IsNotNull() {
            addCriterion("CBLA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla10EqualTo(Integer value) {
            addCriterion("CBLA10 =", value, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10NotEqualTo(Integer value) {
            addCriterion("CBLA10 <>", value, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10GreaterThan(Integer value) {
            addCriterion("CBLA10 >", value, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBLA10 >=", value, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10LessThan(Integer value) {
            addCriterion("CBLA10 <", value, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10LessThanOrEqualTo(Integer value) {
            addCriterion("CBLA10 <=", value, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10In(List<Integer> values) {
            addCriterion("CBLA10 in", values, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10NotIn(List<Integer> values) {
            addCriterion("CBLA10 not in", values, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10Between(Integer value1, Integer value2) {
            addCriterion("CBLA10 between", value1, value2, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBLA10 not between", value1, value2, "cbla10");
            return (Criteria) this;
        }

        public Criteria andCbla11IsNull() {
            addCriterion("CBLA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbla11IsNotNull() {
            addCriterion("CBLA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla11EqualTo(Double value) {
            addCriterion("CBLA11 =", value, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11NotEqualTo(Double value) {
            addCriterion("CBLA11 <>", value, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11GreaterThan(Double value) {
            addCriterion("CBLA11 >", value, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBLA11 >=", value, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11LessThan(Double value) {
            addCriterion("CBLA11 <", value, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11LessThanOrEqualTo(Double value) {
            addCriterion("CBLA11 <=", value, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11In(List<Double> values) {
            addCriterion("CBLA11 in", values, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11NotIn(List<Double> values) {
            addCriterion("CBLA11 not in", values, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11Between(Double value1, Double value2) {
            addCriterion("CBLA11 between", value1, value2, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla11NotBetween(Double value1, Double value2) {
            addCriterion("CBLA11 not between", value1, value2, "cbla11");
            return (Criteria) this;
        }

        public Criteria andCbla12IsNull() {
            addCriterion("CBLA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbla12IsNotNull() {
            addCriterion("CBLA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla12EqualTo(String value) {
            addCriterion("CBLA12 =", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12NotEqualTo(String value) {
            addCriterion("CBLA12 <>", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12GreaterThan(String value) {
            addCriterion("CBLA12 >", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12GreaterThanOrEqualTo(String value) {
            addCriterion("CBLA12 >=", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12LessThan(String value) {
            addCriterion("CBLA12 <", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12LessThanOrEqualTo(String value) {
            addCriterion("CBLA12 <=", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12Like(String value) {
            addCriterion("CBLA12 like", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12NotLike(String value) {
            addCriterion("CBLA12 not like", value, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12In(List<String> values) {
            addCriterion("CBLA12 in", values, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12NotIn(List<String> values) {
            addCriterion("CBLA12 not in", values, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12Between(String value1, String value2) {
            addCriterion("CBLA12 between", value1, value2, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla12NotBetween(String value1, String value2) {
            addCriterion("CBLA12 not between", value1, value2, "cbla12");
            return (Criteria) this;
        }

        public Criteria andCbla13IsNull() {
            addCriterion("CBLA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbla13IsNotNull() {
            addCriterion("CBLA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbla13EqualTo(String value) {
            addCriterion("CBLA13 =", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13NotEqualTo(String value) {
            addCriterion("CBLA13 <>", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13GreaterThan(String value) {
            addCriterion("CBLA13 >", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13GreaterThanOrEqualTo(String value) {
            addCriterion("CBLA13 >=", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13LessThan(String value) {
            addCriterion("CBLA13 <", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13LessThanOrEqualTo(String value) {
            addCriterion("CBLA13 <=", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13Like(String value) {
            addCriterion("CBLA13 like", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13NotLike(String value) {
            addCriterion("CBLA13 not like", value, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13In(List<String> values) {
            addCriterion("CBLA13 in", values, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13NotIn(List<String> values) {
            addCriterion("CBLA13 not in", values, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13Between(String value1, String value2) {
            addCriterion("CBLA13 between", value1, value2, "cbla13");
            return (Criteria) this;
        }

        public Criteria andCbla13NotBetween(String value1, String value2) {
            addCriterion("CBLA13 not between", value1, value2, "cbla13");
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
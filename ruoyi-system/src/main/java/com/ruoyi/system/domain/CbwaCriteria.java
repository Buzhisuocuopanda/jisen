package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbwaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbwaCriteria() {
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

        public Criteria andCbwa01IsNull() {
            addCriterion("CBWA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa01IsNotNull() {
            addCriterion("CBWA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa01EqualTo(Integer value) {
            addCriterion("CBWA01 =", value, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01NotEqualTo(Integer value) {
            addCriterion("CBWA01 <>", value, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01GreaterThan(Integer value) {
            addCriterion("CBWA01 >", value, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA01 >=", value, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01LessThan(Integer value) {
            addCriterion("CBWA01 <", value, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA01 <=", value, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01In(List<Integer> values) {
            addCriterion("CBWA01 in", values, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01NotIn(List<Integer> values) {
            addCriterion("CBWA01 not in", values, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01Between(Integer value1, Integer value2) {
            addCriterion("CBWA01 between", value1, value2, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA01 not between", value1, value2, "cbwa01");
            return (Criteria) this;
        }

        public Criteria andCbwa02IsNull() {
            addCriterion("CBWA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa02IsNotNull() {
            addCriterion("CBWA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa02EqualTo(Date value) {
            addCriterion("CBWA02 =", value, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02NotEqualTo(Date value) {
            addCriterion("CBWA02 <>", value, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02GreaterThan(Date value) {
            addCriterion("CBWA02 >", value, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBWA02 >=", value, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02LessThan(Date value) {
            addCriterion("CBWA02 <", value, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02LessThanOrEqualTo(Date value) {
            addCriterion("CBWA02 <=", value, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02In(List<Date> values) {
            addCriterion("CBWA02 in", values, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02NotIn(List<Date> values) {
            addCriterion("CBWA02 not in", values, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02Between(Date value1, Date value2) {
            addCriterion("CBWA02 between", value1, value2, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa02NotBetween(Date value1, Date value2) {
            addCriterion("CBWA02 not between", value1, value2, "cbwa02");
            return (Criteria) this;
        }

        public Criteria andCbwa03IsNull() {
            addCriterion("CBWA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa03IsNotNull() {
            addCriterion("CBWA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa03EqualTo(Integer value) {
            addCriterion("CBWA03 =", value, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03NotEqualTo(Integer value) {
            addCriterion("CBWA03 <>", value, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03GreaterThan(Integer value) {
            addCriterion("CBWA03 >", value, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA03 >=", value, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03LessThan(Integer value) {
            addCriterion("CBWA03 <", value, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA03 <=", value, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03In(List<Integer> values) {
            addCriterion("CBWA03 in", values, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03NotIn(List<Integer> values) {
            addCriterion("CBWA03 not in", values, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03Between(Integer value1, Integer value2) {
            addCriterion("CBWA03 between", value1, value2, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA03 not between", value1, value2, "cbwa03");
            return (Criteria) this;
        }

        public Criteria andCbwa04IsNull() {
            addCriterion("CBWA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa04IsNotNull() {
            addCriterion("CBWA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa04EqualTo(Date value) {
            addCriterion("CBWA04 =", value, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04NotEqualTo(Date value) {
            addCriterion("CBWA04 <>", value, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04GreaterThan(Date value) {
            addCriterion("CBWA04 >", value, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBWA04 >=", value, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04LessThan(Date value) {
            addCriterion("CBWA04 <", value, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04LessThanOrEqualTo(Date value) {
            addCriterion("CBWA04 <=", value, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04In(List<Date> values) {
            addCriterion("CBWA04 in", values, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04NotIn(List<Date> values) {
            addCriterion("CBWA04 not in", values, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04Between(Date value1, Date value2) {
            addCriterion("CBWA04 between", value1, value2, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa04NotBetween(Date value1, Date value2) {
            addCriterion("CBWA04 not between", value1, value2, "cbwa04");
            return (Criteria) this;
        }

        public Criteria andCbwa05IsNull() {
            addCriterion("CBWA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa05IsNotNull() {
            addCriterion("CBWA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa05EqualTo(Integer value) {
            addCriterion("CBWA05 =", value, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05NotEqualTo(Integer value) {
            addCriterion("CBWA05 <>", value, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05GreaterThan(Integer value) {
            addCriterion("CBWA05 >", value, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA05 >=", value, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05LessThan(Integer value) {
            addCriterion("CBWA05 <", value, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA05 <=", value, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05In(List<Integer> values) {
            addCriterion("CBWA05 in", values, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05NotIn(List<Integer> values) {
            addCriterion("CBWA05 not in", values, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05Between(Integer value1, Integer value2) {
            addCriterion("CBWA05 between", value1, value2, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA05 not between", value1, value2, "cbwa05");
            return (Criteria) this;
        }

        public Criteria andCbwa06IsNull() {
            addCriterion("CBWA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa06IsNotNull() {
            addCriterion("CBWA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa06EqualTo(Integer value) {
            addCriterion("CBWA06 =", value, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06NotEqualTo(Integer value) {
            addCriterion("CBWA06 <>", value, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06GreaterThan(Integer value) {
            addCriterion("CBWA06 >", value, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA06 >=", value, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06LessThan(Integer value) {
            addCriterion("CBWA06 <", value, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA06 <=", value, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06In(List<Integer> values) {
            addCriterion("CBWA06 in", values, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06NotIn(List<Integer> values) {
            addCriterion("CBWA06 not in", values, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06Between(Integer value1, Integer value2) {
            addCriterion("CBWA06 between", value1, value2, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA06 not between", value1, value2, "cbwa06");
            return (Criteria) this;
        }

        public Criteria andCbwa07IsNull() {
            addCriterion("CBWA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa07IsNotNull() {
            addCriterion("CBWA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa07EqualTo(Integer value) {
            addCriterion("CBWA07 =", value, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07NotEqualTo(Integer value) {
            addCriterion("CBWA07 <>", value, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07GreaterThan(Integer value) {
            addCriterion("CBWA07 >", value, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA07 >=", value, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07LessThan(Integer value) {
            addCriterion("CBWA07 <", value, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA07 <=", value, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07In(List<Integer> values) {
            addCriterion("CBWA07 in", values, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07NotIn(List<Integer> values) {
            addCriterion("CBWA07 not in", values, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07Between(Integer value1, Integer value2) {
            addCriterion("CBWA07 between", value1, value2, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA07 not between", value1, value2, "cbwa07");
            return (Criteria) this;
        }

        public Criteria andCbwa08IsNull() {
            addCriterion("CBWA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa08IsNotNull() {
            addCriterion("CBWA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa08EqualTo(String value) {
            addCriterion("CBWA08 =", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08NotEqualTo(String value) {
            addCriterion("CBWA08 <>", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08GreaterThan(String value) {
            addCriterion("CBWA08 >", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08GreaterThanOrEqualTo(String value) {
            addCriterion("CBWA08 >=", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08LessThan(String value) {
            addCriterion("CBWA08 <", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08LessThanOrEqualTo(String value) {
            addCriterion("CBWA08 <=", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08Like(String value) {
            addCriterion("CBWA08 like", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08NotLike(String value) {
            addCriterion("CBWA08 not like", value, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08In(List<String> values) {
            addCriterion("CBWA08 in", values, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08NotIn(List<String> values) {
            addCriterion("CBWA08 not in", values, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08Between(String value1, String value2) {
            addCriterion("CBWA08 between", value1, value2, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa08NotBetween(String value1, String value2) {
            addCriterion("CBWA08 not between", value1, value2, "cbwa08");
            return (Criteria) this;
        }

        public Criteria andCbwa09IsNull() {
            addCriterion("CBWA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa09IsNotNull() {
            addCriterion("CBWA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa09EqualTo(String value) {
            addCriterion("CBWA09 =", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09NotEqualTo(String value) {
            addCriterion("CBWA09 <>", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09GreaterThan(String value) {
            addCriterion("CBWA09 >", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09GreaterThanOrEqualTo(String value) {
            addCriterion("CBWA09 >=", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09LessThan(String value) {
            addCriterion("CBWA09 <", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09LessThanOrEqualTo(String value) {
            addCriterion("CBWA09 <=", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09Like(String value) {
            addCriterion("CBWA09 like", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09NotLike(String value) {
            addCriterion("CBWA09 not like", value, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09In(List<String> values) {
            addCriterion("CBWA09 in", values, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09NotIn(List<String> values) {
            addCriterion("CBWA09 not in", values, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09Between(String value1, String value2) {
            addCriterion("CBWA09 between", value1, value2, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa09NotBetween(String value1, String value2) {
            addCriterion("CBWA09 not between", value1, value2, "cbwa09");
            return (Criteria) this;
        }

        public Criteria andCbwa10IsNull() {
            addCriterion("CBWA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa10IsNotNull() {
            addCriterion("CBWA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa10EqualTo(String value) {
            addCriterion("CBWA10 =", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10NotEqualTo(String value) {
            addCriterion("CBWA10 <>", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10GreaterThan(String value) {
            addCriterion("CBWA10 >", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10GreaterThanOrEqualTo(String value) {
            addCriterion("CBWA10 >=", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10LessThan(String value) {
            addCriterion("CBWA10 <", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10LessThanOrEqualTo(String value) {
            addCriterion("CBWA10 <=", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10Like(String value) {
            addCriterion("CBWA10 like", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10NotLike(String value) {
            addCriterion("CBWA10 not like", value, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10In(List<String> values) {
            addCriterion("CBWA10 in", values, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10NotIn(List<String> values) {
            addCriterion("CBWA10 not in", values, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10Between(String value1, String value2) {
            addCriterion("CBWA10 between", value1, value2, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa10NotBetween(String value1, String value2) {
            addCriterion("CBWA10 not between", value1, value2, "cbwa10");
            return (Criteria) this;
        }

        public Criteria andCbwa11IsNull() {
            addCriterion("CBWA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa11IsNotNull() {
            addCriterion("CBWA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa11EqualTo(String value) {
            addCriterion("CBWA11 =", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11NotEqualTo(String value) {
            addCriterion("CBWA11 <>", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11GreaterThan(String value) {
            addCriterion("CBWA11 >", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11GreaterThanOrEqualTo(String value) {
            addCriterion("CBWA11 >=", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11LessThan(String value) {
            addCriterion("CBWA11 <", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11LessThanOrEqualTo(String value) {
            addCriterion("CBWA11 <=", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11Like(String value) {
            addCriterion("CBWA11 like", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11NotLike(String value) {
            addCriterion("CBWA11 not like", value, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11In(List<String> values) {
            addCriterion("CBWA11 in", values, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11NotIn(List<String> values) {
            addCriterion("CBWA11 not in", values, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11Between(String value1, String value2) {
            addCriterion("CBWA11 between", value1, value2, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa11NotBetween(String value1, String value2) {
            addCriterion("CBWA11 not between", value1, value2, "cbwa11");
            return (Criteria) this;
        }

        public Criteria andCbwa12IsNull() {
            addCriterion("CBWA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa12IsNotNull() {
            addCriterion("CBWA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa12EqualTo(String value) {
            addCriterion("CBWA12 =", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12NotEqualTo(String value) {
            addCriterion("CBWA12 <>", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12GreaterThan(String value) {
            addCriterion("CBWA12 >", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12GreaterThanOrEqualTo(String value) {
            addCriterion("CBWA12 >=", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12LessThan(String value) {
            addCriterion("CBWA12 <", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12LessThanOrEqualTo(String value) {
            addCriterion("CBWA12 <=", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12Like(String value) {
            addCriterion("CBWA12 like", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12NotLike(String value) {
            addCriterion("CBWA12 not like", value, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12In(List<String> values) {
            addCriterion("CBWA12 in", values, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12NotIn(List<String> values) {
            addCriterion("CBWA12 not in", values, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12Between(String value1, String value2) {
            addCriterion("CBWA12 between", value1, value2, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa12NotBetween(String value1, String value2) {
            addCriterion("CBWA12 not between", value1, value2, "cbwa12");
            return (Criteria) this;
        }

        public Criteria andCbwa13IsNull() {
            addCriterion("CBWA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa13IsNotNull() {
            addCriterion("CBWA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa13EqualTo(Integer value) {
            addCriterion("CBWA13 =", value, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13NotEqualTo(Integer value) {
            addCriterion("CBWA13 <>", value, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13GreaterThan(Integer value) {
            addCriterion("CBWA13 >", value, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA13 >=", value, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13LessThan(Integer value) {
            addCriterion("CBWA13 <", value, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA13 <=", value, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13In(List<Integer> values) {
            addCriterion("CBWA13 in", values, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13NotIn(List<Integer> values) {
            addCriterion("CBWA13 not in", values, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13Between(Integer value1, Integer value2) {
            addCriterion("CBWA13 between", value1, value2, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa13NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA13 not between", value1, value2, "cbwa13");
            return (Criteria) this;
        }

        public Criteria andCbwa14IsNull() {
            addCriterion("CBWA14 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa14IsNotNull() {
            addCriterion("CBWA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa14EqualTo(Integer value) {
            addCriterion("CBWA14 =", value, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14NotEqualTo(Integer value) {
            addCriterion("CBWA14 <>", value, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14GreaterThan(Integer value) {
            addCriterion("CBWA14 >", value, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA14 >=", value, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14LessThan(Integer value) {
            addCriterion("CBWA14 <", value, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA14 <=", value, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14In(List<Integer> values) {
            addCriterion("CBWA14 in", values, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14NotIn(List<Integer> values) {
            addCriterion("CBWA14 not in", values, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14Between(Integer value1, Integer value2) {
            addCriterion("CBWA14 between", value1, value2, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA14 not between", value1, value2, "cbwa14");
            return (Criteria) this;
        }

        public Criteria andCbwa15IsNull() {
            addCriterion("CBWA15 is null");
            return (Criteria) this;
        }

        public Criteria andCbwa15IsNotNull() {
            addCriterion("CBWA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbwa15EqualTo(Integer value) {
            addCriterion("CBWA15 =", value, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15NotEqualTo(Integer value) {
            addCriterion("CBWA15 <>", value, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15GreaterThan(Integer value) {
            addCriterion("CBWA15 >", value, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBWA15 >=", value, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15LessThan(Integer value) {
            addCriterion("CBWA15 <", value, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15LessThanOrEqualTo(Integer value) {
            addCriterion("CBWA15 <=", value, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15In(List<Integer> values) {
            addCriterion("CBWA15 in", values, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15NotIn(List<Integer> values) {
            addCriterion("CBWA15 not in", values, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15Between(Integer value1, Integer value2) {
            addCriterion("CBWA15 between", value1, value2, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andCbwa15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBWA15 not between", value1, value2, "cbwa15");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagIsNull() {
            addCriterion("allocation_flag is null");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagIsNotNull() {
            addCriterion("allocation_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagEqualTo(Byte value) {
            addCriterion("allocation_flag =", value, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagNotEqualTo(Byte value) {
            addCriterion("allocation_flag <>", value, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagGreaterThan(Byte value) {
            addCriterion("allocation_flag >", value, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("allocation_flag >=", value, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagLessThan(Byte value) {
            addCriterion("allocation_flag <", value, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagLessThanOrEqualTo(Byte value) {
            addCriterion("allocation_flag <=", value, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagIn(List<Byte> values) {
            addCriterion("allocation_flag in", values, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagNotIn(List<Byte> values) {
            addCriterion("allocation_flag not in", values, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagBetween(Byte value1, Byte value2) {
            addCriterion("allocation_flag between", value1, value2, "allocationFlag");
            return (Criteria) this;
        }

        public Criteria andAllocationFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("allocation_flag not between", value1, value2, "allocationFlag");
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
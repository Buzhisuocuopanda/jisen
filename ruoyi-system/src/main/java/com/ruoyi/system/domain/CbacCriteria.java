package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbacCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbacCriteria() {
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

        public Criteria andCbac01IsNull() {
            addCriterion("CBAC01 is null");
            return (Criteria) this;
        }

        public Criteria andCbac01IsNotNull() {
            addCriterion("CBAC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac01EqualTo(Integer value) {
            addCriterion("CBAC01 =", value, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01NotEqualTo(Integer value) {
            addCriterion("CBAC01 <>", value, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01GreaterThan(Integer value) {
            addCriterion("CBAC01 >", value, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC01 >=", value, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01LessThan(Integer value) {
            addCriterion("CBAC01 <", value, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC01 <=", value, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01In(List<Integer> values) {
            addCriterion("CBAC01 in", values, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01NotIn(List<Integer> values) {
            addCriterion("CBAC01 not in", values, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01Between(Integer value1, Integer value2) {
            addCriterion("CBAC01 between", value1, value2, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC01 not between", value1, value2, "cbac01");
            return (Criteria) this;
        }

        public Criteria andCbac02IsNull() {
            addCriterion("CBAC02 is null");
            return (Criteria) this;
        }

        public Criteria andCbac02IsNotNull() {
            addCriterion("CBAC02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac02EqualTo(Integer value) {
            addCriterion("CBAC02 =", value, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02NotEqualTo(Integer value) {
            addCriterion("CBAC02 <>", value, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02GreaterThan(Integer value) {
            addCriterion("CBAC02 >", value, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC02 >=", value, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02LessThan(Integer value) {
            addCriterion("CBAC02 <", value, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC02 <=", value, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02In(List<Integer> values) {
            addCriterion("CBAC02 in", values, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02NotIn(List<Integer> values) {
            addCriterion("CBAC02 not in", values, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02Between(Integer value1, Integer value2) {
            addCriterion("CBAC02 between", value1, value2, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC02 not between", value1, value2, "cbac02");
            return (Criteria) this;
        }

        public Criteria andCbac03IsNull() {
            addCriterion("CBAC03 is null");
            return (Criteria) this;
        }

        public Criteria andCbac03IsNotNull() {
            addCriterion("CBAC03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac03EqualTo(Date value) {
            addCriterion("CBAC03 =", value, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03NotEqualTo(Date value) {
            addCriterion("CBAC03 <>", value, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03GreaterThan(Date value) {
            addCriterion("CBAC03 >", value, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAC03 >=", value, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03LessThan(Date value) {
            addCriterion("CBAC03 <", value, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03LessThanOrEqualTo(Date value) {
            addCriterion("CBAC03 <=", value, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03In(List<Date> values) {
            addCriterion("CBAC03 in", values, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03NotIn(List<Date> values) {
            addCriterion("CBAC03 not in", values, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03Between(Date value1, Date value2) {
            addCriterion("CBAC03 between", value1, value2, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac03NotBetween(Date value1, Date value2) {
            addCriterion("CBAC03 not between", value1, value2, "cbac03");
            return (Criteria) this;
        }

        public Criteria andCbac04IsNull() {
            addCriterion("CBAC04 is null");
            return (Criteria) this;
        }

        public Criteria andCbac04IsNotNull() {
            addCriterion("CBAC04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac04EqualTo(Integer value) {
            addCriterion("CBAC04 =", value, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04NotEqualTo(Integer value) {
            addCriterion("CBAC04 <>", value, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04GreaterThan(Integer value) {
            addCriterion("CBAC04 >", value, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC04 >=", value, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04LessThan(Integer value) {
            addCriterion("CBAC04 <", value, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC04 <=", value, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04In(List<Integer> values) {
            addCriterion("CBAC04 in", values, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04NotIn(List<Integer> values) {
            addCriterion("CBAC04 not in", values, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04Between(Integer value1, Integer value2) {
            addCriterion("CBAC04 between", value1, value2, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC04 not between", value1, value2, "cbac04");
            return (Criteria) this;
        }

        public Criteria andCbac05IsNull() {
            addCriterion("CBAC05 is null");
            return (Criteria) this;
        }

        public Criteria andCbac05IsNotNull() {
            addCriterion("CBAC05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac05EqualTo(Date value) {
            addCriterion("CBAC05 =", value, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05NotEqualTo(Date value) {
            addCriterion("CBAC05 <>", value, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05GreaterThan(Date value) {
            addCriterion("CBAC05 >", value, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAC05 >=", value, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05LessThan(Date value) {
            addCriterion("CBAC05 <", value, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05LessThanOrEqualTo(Date value) {
            addCriterion("CBAC05 <=", value, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05In(List<Date> values) {
            addCriterion("CBAC05 in", values, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05NotIn(List<Date> values) {
            addCriterion("CBAC05 not in", values, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05Between(Date value1, Date value2) {
            addCriterion("CBAC05 between", value1, value2, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac05NotBetween(Date value1, Date value2) {
            addCriterion("CBAC05 not between", value1, value2, "cbac05");
            return (Criteria) this;
        }

        public Criteria andCbac06IsNull() {
            addCriterion("CBAC06 is null");
            return (Criteria) this;
        }

        public Criteria andCbac06IsNotNull() {
            addCriterion("CBAC06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac06EqualTo(Integer value) {
            addCriterion("CBAC06 =", value, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06NotEqualTo(Integer value) {
            addCriterion("CBAC06 <>", value, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06GreaterThan(Integer value) {
            addCriterion("CBAC06 >", value, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC06 >=", value, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06LessThan(Integer value) {
            addCriterion("CBAC06 <", value, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC06 <=", value, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06In(List<Integer> values) {
            addCriterion("CBAC06 in", values, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06NotIn(List<Integer> values) {
            addCriterion("CBAC06 not in", values, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06Between(Integer value1, Integer value2) {
            addCriterion("CBAC06 between", value1, value2, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC06 not between", value1, value2, "cbac06");
            return (Criteria) this;
        }

        public Criteria andCbac07IsNull() {
            addCriterion("CBAC07 is null");
            return (Criteria) this;
        }

        public Criteria andCbac07IsNotNull() {
            addCriterion("CBAC07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac07EqualTo(Integer value) {
            addCriterion("CBAC07 =", value, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07NotEqualTo(Integer value) {
            addCriterion("CBAC07 <>", value, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07GreaterThan(Integer value) {
            addCriterion("CBAC07 >", value, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC07 >=", value, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07LessThan(Integer value) {
            addCriterion("CBAC07 <", value, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC07 <=", value, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07In(List<Integer> values) {
            addCriterion("CBAC07 in", values, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07NotIn(List<Integer> values) {
            addCriterion("CBAC07 not in", values, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07Between(Integer value1, Integer value2) {
            addCriterion("CBAC07 between", value1, value2, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC07 not between", value1, value2, "cbac07");
            return (Criteria) this;
        }

        public Criteria andCbac08IsNull() {
            addCriterion("CBAC08 is null");
            return (Criteria) this;
        }

        public Criteria andCbac08IsNotNull() {
            addCriterion("CBAC08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac08EqualTo(Integer value) {
            addCriterion("CBAC08 =", value, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08NotEqualTo(Integer value) {
            addCriterion("CBAC08 <>", value, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08GreaterThan(Integer value) {
            addCriterion("CBAC08 >", value, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC08 >=", value, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08LessThan(Integer value) {
            addCriterion("CBAC08 <", value, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC08 <=", value, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08In(List<Integer> values) {
            addCriterion("CBAC08 in", values, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08NotIn(List<Integer> values) {
            addCriterion("CBAC08 not in", values, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08Between(Integer value1, Integer value2) {
            addCriterion("CBAC08 between", value1, value2, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC08 not between", value1, value2, "cbac08");
            return (Criteria) this;
        }

        public Criteria andCbac09IsNull() {
            addCriterion("CBAC09 is null");
            return (Criteria) this;
        }

        public Criteria andCbac09IsNotNull() {
            addCriterion("CBAC09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac09EqualTo(String value) {
            addCriterion("CBAC09 =", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09NotEqualTo(String value) {
            addCriterion("CBAC09 <>", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09GreaterThan(String value) {
            addCriterion("CBAC09 >", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09GreaterThanOrEqualTo(String value) {
            addCriterion("CBAC09 >=", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09LessThan(String value) {
            addCriterion("CBAC09 <", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09LessThanOrEqualTo(String value) {
            addCriterion("CBAC09 <=", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09Like(String value) {
            addCriterion("CBAC09 like", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09NotLike(String value) {
            addCriterion("CBAC09 not like", value, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09In(List<String> values) {
            addCriterion("CBAC09 in", values, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09NotIn(List<String> values) {
            addCriterion("CBAC09 not in", values, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09Between(String value1, String value2) {
            addCriterion("CBAC09 between", value1, value2, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac09NotBetween(String value1, String value2) {
            addCriterion("CBAC09 not between", value1, value2, "cbac09");
            return (Criteria) this;
        }

        public Criteria andCbac10IsNull() {
            addCriterion("CBAC10 is null");
            return (Criteria) this;
        }

        public Criteria andCbac10IsNotNull() {
            addCriterion("CBAC10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac10EqualTo(Integer value) {
            addCriterion("CBAC10 =", value, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10NotEqualTo(Integer value) {
            addCriterion("CBAC10 <>", value, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10GreaterThan(Integer value) {
            addCriterion("CBAC10 >", value, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC10 >=", value, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10LessThan(Integer value) {
            addCriterion("CBAC10 <", value, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC10 <=", value, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10In(List<Integer> values) {
            addCriterion("CBAC10 in", values, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10NotIn(List<Integer> values) {
            addCriterion("CBAC10 not in", values, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10Between(Integer value1, Integer value2) {
            addCriterion("CBAC10 between", value1, value2, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC10 not between", value1, value2, "cbac10");
            return (Criteria) this;
        }

        public Criteria andCbac11IsNull() {
            addCriterion("CBAC11 is null");
            return (Criteria) this;
        }

        public Criteria andCbac11IsNotNull() {
            addCriterion("CBAC11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac11EqualTo(Integer value) {
            addCriterion("CBAC11 =", value, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11NotEqualTo(Integer value) {
            addCriterion("CBAC11 <>", value, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11GreaterThan(Integer value) {
            addCriterion("CBAC11 >", value, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC11 >=", value, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11LessThan(Integer value) {
            addCriterion("CBAC11 <", value, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC11 <=", value, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11In(List<Integer> values) {
            addCriterion("CBAC11 in", values, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11NotIn(List<Integer> values) {
            addCriterion("CBAC11 not in", values, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11Between(Integer value1, Integer value2) {
            addCriterion("CBAC11 between", value1, value2, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC11 not between", value1, value2, "cbac11");
            return (Criteria) this;
        }

        public Criteria andCbac12IsNull() {
            addCriterion("CBAC12 is null");
            return (Criteria) this;
        }

        public Criteria andCbac12IsNotNull() {
            addCriterion("CBAC12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac12EqualTo(String value) {
            addCriterion("CBAC12 =", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12NotEqualTo(String value) {
            addCriterion("CBAC12 <>", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12GreaterThan(String value) {
            addCriterion("CBAC12 >", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12GreaterThanOrEqualTo(String value) {
            addCriterion("CBAC12 >=", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12LessThan(String value) {
            addCriterion("CBAC12 <", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12LessThanOrEqualTo(String value) {
            addCriterion("CBAC12 <=", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12Like(String value) {
            addCriterion("CBAC12 like", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12NotLike(String value) {
            addCriterion("CBAC12 not like", value, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12In(List<String> values) {
            addCriterion("CBAC12 in", values, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12NotIn(List<String> values) {
            addCriterion("CBAC12 not in", values, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12Between(String value1, String value2) {
            addCriterion("CBAC12 between", value1, value2, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbac12NotBetween(String value1, String value2) {
            addCriterion("CBAC12 not between", value1, value2, "cbac12");
            return (Criteria) this;
        }

        public Criteria andCbaa01IsNull() {
            addCriterion("CBAA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa01IsNotNull() {
            addCriterion("CBAA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa01EqualTo(Integer value) {
            addCriterion("CBAA01 =", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotEqualTo(Integer value) {
            addCriterion("CBAA01 <>", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01GreaterThan(Integer value) {
            addCriterion("CBAA01 >", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA01 >=", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01LessThan(Integer value) {
            addCriterion("CBAA01 <", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA01 <=", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01In(List<Integer> values) {
            addCriterion("CBAA01 in", values, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotIn(List<Integer> values) {
            addCriterion("CBAA01 not in", values, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01Between(Integer value1, Integer value2) {
            addCriterion("CBAA01 between", value1, value2, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA01 not between", value1, value2, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbac13IsNull() {
            addCriterion("CBAC13 is null");
            return (Criteria) this;
        }

        public Criteria andCbac13IsNotNull() {
            addCriterion("CBAC13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac13EqualTo(Integer value) {
            addCriterion("CBAC13 =", value, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13NotEqualTo(Integer value) {
            addCriterion("CBAC13 <>", value, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13GreaterThan(Integer value) {
            addCriterion("CBAC13 >", value, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC13 >=", value, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13LessThan(Integer value) {
            addCriterion("CBAC13 <", value, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC13 <=", value, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13In(List<Integer> values) {
            addCriterion("CBAC13 in", values, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13NotIn(List<Integer> values) {
            addCriterion("CBAC13 not in", values, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13Between(Integer value1, Integer value2) {
            addCriterion("CBAC13 between", value1, value2, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac13NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC13 not between", value1, value2, "cbac13");
            return (Criteria) this;
        }

        public Criteria andCbac14IsNull() {
            addCriterion("CBAC14 is null");
            return (Criteria) this;
        }

        public Criteria andCbac14IsNotNull() {
            addCriterion("CBAC14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbac14EqualTo(Integer value) {
            addCriterion("CBAC14 =", value, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14NotEqualTo(Integer value) {
            addCriterion("CBAC14 <>", value, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14GreaterThan(Integer value) {
            addCriterion("CBAC14 >", value, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAC14 >=", value, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14LessThan(Integer value) {
            addCriterion("CBAC14 <", value, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14LessThanOrEqualTo(Integer value) {
            addCriterion("CBAC14 <=", value, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14In(List<Integer> values) {
            addCriterion("CBAC14 in", values, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14NotIn(List<Integer> values) {
            addCriterion("CBAC14 not in", values, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14Between(Integer value1, Integer value2) {
            addCriterion("CBAC14 between", value1, value2, "cbac14");
            return (Criteria) this;
        }

        public Criteria andCbac14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAC14 not between", value1, value2, "cbac14");
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
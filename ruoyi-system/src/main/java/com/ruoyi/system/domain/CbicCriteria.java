package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbicCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbicCriteria() {
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

        public Criteria andCbic01IsNull() {
            addCriterion("CBIC01 is null");
            return (Criteria) this;
        }

        public Criteria andCbic01IsNotNull() {
            addCriterion("CBIC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic01EqualTo(Integer value) {
            addCriterion("CBIC01 =", value, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01NotEqualTo(Integer value) {
            addCriterion("CBIC01 <>", value, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01GreaterThan(Integer value) {
            addCriterion("CBIC01 >", value, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC01 >=", value, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01LessThan(Integer value) {
            addCriterion("CBIC01 <", value, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC01 <=", value, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01In(List<Integer> values) {
            addCriterion("CBIC01 in", values, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01NotIn(List<Integer> values) {
            addCriterion("CBIC01 not in", values, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01Between(Integer value1, Integer value2) {
            addCriterion("CBIC01 between", value1, value2, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC01 not between", value1, value2, "cbic01");
            return (Criteria) this;
        }

        public Criteria andCbic02IsNull() {
            addCriterion("CBIC02 is null");
            return (Criteria) this;
        }

        public Criteria andCbic02IsNotNull() {
            addCriterion("CBIC02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic02EqualTo(Date value) {
            addCriterion("CBIC02 =", value, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02NotEqualTo(Date value) {
            addCriterion("CBIC02 <>", value, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02GreaterThan(Date value) {
            addCriterion("CBIC02 >", value, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIC02 >=", value, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02LessThan(Date value) {
            addCriterion("CBIC02 <", value, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02LessThanOrEqualTo(Date value) {
            addCriterion("CBIC02 <=", value, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02In(List<Date> values) {
            addCriterion("CBIC02 in", values, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02NotIn(List<Date> values) {
            addCriterion("CBIC02 not in", values, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02Between(Date value1, Date value2) {
            addCriterion("CBIC02 between", value1, value2, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic02NotBetween(Date value1, Date value2) {
            addCriterion("CBIC02 not between", value1, value2, "cbic02");
            return (Criteria) this;
        }

        public Criteria andCbic03IsNull() {
            addCriterion("CBIC03 is null");
            return (Criteria) this;
        }

        public Criteria andCbic03IsNotNull() {
            addCriterion("CBIC03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic03EqualTo(Date value) {
            addCriterion("CBIC03 =", value, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03NotEqualTo(Date value) {
            addCriterion("CBIC03 <>", value, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03GreaterThan(Date value) {
            addCriterion("CBIC03 >", value, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIC03 >=", value, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03LessThan(Date value) {
            addCriterion("CBIC03 <", value, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03LessThanOrEqualTo(Date value) {
            addCriterion("CBIC03 <=", value, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03In(List<Date> values) {
            addCriterion("CBIC03 in", values, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03NotIn(List<Date> values) {
            addCriterion("CBIC03 not in", values, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03Between(Date value1, Date value2) {
            addCriterion("CBIC03 between", value1, value2, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic03NotBetween(Date value1, Date value2) {
            addCriterion("CBIC03 not between", value1, value2, "cbic03");
            return (Criteria) this;
        }

        public Criteria andCbic04IsNull() {
            addCriterion("CBIC04 is null");
            return (Criteria) this;
        }

        public Criteria andCbic04IsNotNull() {
            addCriterion("CBIC04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic04EqualTo(Integer value) {
            addCriterion("CBIC04 =", value, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04NotEqualTo(Integer value) {
            addCriterion("CBIC04 <>", value, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04GreaterThan(Integer value) {
            addCriterion("CBIC04 >", value, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC04 >=", value, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04LessThan(Integer value) {
            addCriterion("CBIC04 <", value, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC04 <=", value, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04In(List<Integer> values) {
            addCriterion("CBIC04 in", values, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04NotIn(List<Integer> values) {
            addCriterion("CBIC04 not in", values, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04Between(Integer value1, Integer value2) {
            addCriterion("CBIC04 between", value1, value2, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC04 not between", value1, value2, "cbic04");
            return (Criteria) this;
        }

        public Criteria andCbic05IsNull() {
            addCriterion("CBIC05 is null");
            return (Criteria) this;
        }

        public Criteria andCbic05IsNotNull() {
            addCriterion("CBIC05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic05EqualTo(Integer value) {
            addCriterion("CBIC05 =", value, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05NotEqualTo(Integer value) {
            addCriterion("CBIC05 <>", value, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05GreaterThan(Integer value) {
            addCriterion("CBIC05 >", value, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC05 >=", value, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05LessThan(Integer value) {
            addCriterion("CBIC05 <", value, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC05 <=", value, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05In(List<Integer> values) {
            addCriterion("CBIC05 in", values, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05NotIn(List<Integer> values) {
            addCriterion("CBIC05 not in", values, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05Between(Integer value1, Integer value2) {
            addCriterion("CBIC05 between", value1, value2, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC05 not between", value1, value2, "cbic05");
            return (Criteria) this;
        }

        public Criteria andCbic06IsNull() {
            addCriterion("CBIC06 is null");
            return (Criteria) this;
        }

        public Criteria andCbic06IsNotNull() {
            addCriterion("CBIC06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic06EqualTo(Integer value) {
            addCriterion("CBIC06 =", value, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06NotEqualTo(Integer value) {
            addCriterion("CBIC06 <>", value, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06GreaterThan(Integer value) {
            addCriterion("CBIC06 >", value, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC06 >=", value, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06LessThan(Integer value) {
            addCriterion("CBIC06 <", value, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC06 <=", value, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06In(List<Integer> values) {
            addCriterion("CBIC06 in", values, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06NotIn(List<Integer> values) {
            addCriterion("CBIC06 not in", values, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06Between(Integer value1, Integer value2) {
            addCriterion("CBIC06 between", value1, value2, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC06 not between", value1, value2, "cbic06");
            return (Criteria) this;
        }

        public Criteria andCbic07IsNull() {
            addCriterion("CBIC07 is null");
            return (Criteria) this;
        }

        public Criteria andCbic07IsNotNull() {
            addCriterion("CBIC07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic07EqualTo(Integer value) {
            addCriterion("CBIC07 =", value, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07NotEqualTo(Integer value) {
            addCriterion("CBIC07 <>", value, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07GreaterThan(Integer value) {
            addCriterion("CBIC07 >", value, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC07 >=", value, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07LessThan(Integer value) {
            addCriterion("CBIC07 <", value, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC07 <=", value, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07In(List<Integer> values) {
            addCriterion("CBIC07 in", values, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07NotIn(List<Integer> values) {
            addCriterion("CBIC07 not in", values, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07Between(Integer value1, Integer value2) {
            addCriterion("CBIC07 between", value1, value2, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC07 not between", value1, value2, "cbic07");
            return (Criteria) this;
        }

        public Criteria andCbic08IsNull() {
            addCriterion("CBIC08 is null");
            return (Criteria) this;
        }

        public Criteria andCbic08IsNotNull() {
            addCriterion("CBIC08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic08EqualTo(Integer value) {
            addCriterion("CBIC08 =", value, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08NotEqualTo(Integer value) {
            addCriterion("CBIC08 <>", value, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08GreaterThan(Integer value) {
            addCriterion("CBIC08 >", value, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC08 >=", value, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08LessThan(Integer value) {
            addCriterion("CBIC08 <", value, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC08 <=", value, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08In(List<Integer> values) {
            addCriterion("CBIC08 in", values, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08NotIn(List<Integer> values) {
            addCriterion("CBIC08 not in", values, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08Between(Integer value1, Integer value2) {
            addCriterion("CBIC08 between", value1, value2, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC08 not between", value1, value2, "cbic08");
            return (Criteria) this;
        }

        public Criteria andCbic09IsNull() {
            addCriterion("CBIC09 is null");
            return (Criteria) this;
        }

        public Criteria andCbic09IsNotNull() {
            addCriterion("CBIC09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic09EqualTo(Integer value) {
            addCriterion("CBIC09 =", value, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09NotEqualTo(Integer value) {
            addCriterion("CBIC09 <>", value, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09GreaterThan(Integer value) {
            addCriterion("CBIC09 >", value, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC09 >=", value, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09LessThan(Integer value) {
            addCriterion("CBIC09 <", value, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC09 <=", value, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09In(List<Integer> values) {
            addCriterion("CBIC09 in", values, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09NotIn(List<Integer> values) {
            addCriterion("CBIC09 not in", values, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09Between(Integer value1, Integer value2) {
            addCriterion("CBIC09 between", value1, value2, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC09 not between", value1, value2, "cbic09");
            return (Criteria) this;
        }

        public Criteria andCbic10IsNull() {
            addCriterion("CBIC10 is null");
            return (Criteria) this;
        }

        public Criteria andCbic10IsNotNull() {
            addCriterion("CBIC10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic10EqualTo(String value) {
            addCriterion("CBIC10 =", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10NotEqualTo(String value) {
            addCriterion("CBIC10 <>", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10GreaterThan(String value) {
            addCriterion("CBIC10 >", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10GreaterThanOrEqualTo(String value) {
            addCriterion("CBIC10 >=", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10LessThan(String value) {
            addCriterion("CBIC10 <", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10LessThanOrEqualTo(String value) {
            addCriterion("CBIC10 <=", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10Like(String value) {
            addCriterion("CBIC10 like", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10NotLike(String value) {
            addCriterion("CBIC10 not like", value, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10In(List<String> values) {
            addCriterion("CBIC10 in", values, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10NotIn(List<String> values) {
            addCriterion("CBIC10 not in", values, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10Between(String value1, String value2) {
            addCriterion("CBIC10 between", value1, value2, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic10NotBetween(String value1, String value2) {
            addCriterion("CBIC10 not between", value1, value2, "cbic10");
            return (Criteria) this;
        }

        public Criteria andCbic11IsNull() {
            addCriterion("CBIC11 is null");
            return (Criteria) this;
        }

        public Criteria andCbic11IsNotNull() {
            addCriterion("CBIC11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic11EqualTo(Integer value) {
            addCriterion("CBIC11 =", value, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11NotEqualTo(Integer value) {
            addCriterion("CBIC11 <>", value, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11GreaterThan(Integer value) {
            addCriterion("CBIC11 >", value, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC11 >=", value, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11LessThan(Integer value) {
            addCriterion("CBIC11 <", value, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC11 <=", value, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11In(List<Integer> values) {
            addCriterion("CBIC11 in", values, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11NotIn(List<Integer> values) {
            addCriterion("CBIC11 not in", values, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11Between(Integer value1, Integer value2) {
            addCriterion("CBIC11 between", value1, value2, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC11 not between", value1, value2, "cbic11");
            return (Criteria) this;
        }

        public Criteria andCbic12IsNull() {
            addCriterion("CBIC12 is null");
            return (Criteria) this;
        }

        public Criteria andCbic12IsNotNull() {
            addCriterion("CBIC12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic12EqualTo(Date value) {
            addCriterion("CBIC12 =", value, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12NotEqualTo(Date value) {
            addCriterion("CBIC12 <>", value, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12GreaterThan(Date value) {
            addCriterion("CBIC12 >", value, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIC12 >=", value, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12LessThan(Date value) {
            addCriterion("CBIC12 <", value, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12LessThanOrEqualTo(Date value) {
            addCriterion("CBIC12 <=", value, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12In(List<Date> values) {
            addCriterion("CBIC12 in", values, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12NotIn(List<Date> values) {
            addCriterion("CBIC12 not in", values, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12Between(Date value1, Date value2) {
            addCriterion("CBIC12 between", value1, value2, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic12NotBetween(Date value1, Date value2) {
            addCriterion("CBIC12 not between", value1, value2, "cbic12");
            return (Criteria) this;
        }

        public Criteria andCbic13IsNull() {
            addCriterion("CBIC13 is null");
            return (Criteria) this;
        }

        public Criteria andCbic13IsNotNull() {
            addCriterion("CBIC13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic13EqualTo(Integer value) {
            addCriterion("CBIC13 =", value, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13NotEqualTo(Integer value) {
            addCriterion("CBIC13 <>", value, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13GreaterThan(Integer value) {
            addCriterion("CBIC13 >", value, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC13 >=", value, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13LessThan(Integer value) {
            addCriterion("CBIC13 <", value, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC13 <=", value, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13In(List<Integer> values) {
            addCriterion("CBIC13 in", values, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13NotIn(List<Integer> values) {
            addCriterion("CBIC13 not in", values, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13Between(Integer value1, Integer value2) {
            addCriterion("CBIC13 between", value1, value2, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic13NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC13 not between", value1, value2, "cbic13");
            return (Criteria) this;
        }

        public Criteria andCbic14IsNull() {
            addCriterion("CBIC14 is null");
            return (Criteria) this;
        }

        public Criteria andCbic14IsNotNull() {
            addCriterion("CBIC14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic14EqualTo(Integer value) {
            addCriterion("CBIC14 =", value, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14NotEqualTo(Integer value) {
            addCriterion("CBIC14 <>", value, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14GreaterThan(Integer value) {
            addCriterion("CBIC14 >", value, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC14 >=", value, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14LessThan(Integer value) {
            addCriterion("CBIC14 <", value, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC14 <=", value, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14In(List<Integer> values) {
            addCriterion("CBIC14 in", values, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14NotIn(List<Integer> values) {
            addCriterion("CBIC14 not in", values, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14Between(Integer value1, Integer value2) {
            addCriterion("CBIC14 between", value1, value2, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC14 not between", value1, value2, "cbic14");
            return (Criteria) this;
        }

        public Criteria andCbic15IsNull() {
            addCriterion("CBIC15 is null");
            return (Criteria) this;
        }

        public Criteria andCbic15IsNotNull() {
            addCriterion("CBIC15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbic15EqualTo(Integer value) {
            addCriterion("CBIC15 =", value, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15NotEqualTo(Integer value) {
            addCriterion("CBIC15 <>", value, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15GreaterThan(Integer value) {
            addCriterion("CBIC15 >", value, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIC15 >=", value, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15LessThan(Integer value) {
            addCriterion("CBIC15 <", value, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15LessThanOrEqualTo(Integer value) {
            addCriterion("CBIC15 <=", value, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15In(List<Integer> values) {
            addCriterion("CBIC15 in", values, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15NotIn(List<Integer> values) {
            addCriterion("CBIC15 not in", values, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15Between(Integer value1, Integer value2) {
            addCriterion("CBIC15 between", value1, value2, "cbic15");
            return (Criteria) this;
        }

        public Criteria andCbic15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIC15 not between", value1, value2, "cbic15");
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
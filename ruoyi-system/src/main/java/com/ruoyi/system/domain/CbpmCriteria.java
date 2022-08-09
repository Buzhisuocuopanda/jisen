package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpmCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpmCriteria() {
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

        public Criteria andCbpm01IsNull() {
            addCriterion("CBPM01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm01IsNotNull() {
            addCriterion("CBPM01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm01EqualTo(Integer value) {
            addCriterion("CBPM01 =", value, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01NotEqualTo(Integer value) {
            addCriterion("CBPM01 <>", value, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01GreaterThan(Integer value) {
            addCriterion("CBPM01 >", value, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM01 >=", value, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01LessThan(Integer value) {
            addCriterion("CBPM01 <", value, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM01 <=", value, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01In(List<Integer> values) {
            addCriterion("CBPM01 in", values, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01NotIn(List<Integer> values) {
            addCriterion("CBPM01 not in", values, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01Between(Integer value1, Integer value2) {
            addCriterion("CBPM01 between", value1, value2, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM01 not between", value1, value2, "cbpm01");
            return (Criteria) this;
        }

        public Criteria andCbpm02IsNull() {
            addCriterion("CBPM02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm02IsNotNull() {
            addCriterion("CBPM02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm02EqualTo(Integer value) {
            addCriterion("CBPM02 =", value, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02NotEqualTo(Integer value) {
            addCriterion("CBPM02 <>", value, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02GreaterThan(Integer value) {
            addCriterion("CBPM02 >", value, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM02 >=", value, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02LessThan(Integer value) {
            addCriterion("CBPM02 <", value, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM02 <=", value, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02In(List<Integer> values) {
            addCriterion("CBPM02 in", values, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02NotIn(List<Integer> values) {
            addCriterion("CBPM02 not in", values, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02Between(Integer value1, Integer value2) {
            addCriterion("CBPM02 between", value1, value2, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM02 not between", value1, value2, "cbpm02");
            return (Criteria) this;
        }

        public Criteria andCbpm03IsNull() {
            addCriterion("CBPM03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm03IsNotNull() {
            addCriterion("CBPM03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm03EqualTo(Date value) {
            addCriterion("CBPM03 =", value, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03NotEqualTo(Date value) {
            addCriterion("CBPM03 <>", value, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03GreaterThan(Date value) {
            addCriterion("CBPM03 >", value, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPM03 >=", value, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03LessThan(Date value) {
            addCriterion("CBPM03 <", value, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03LessThanOrEqualTo(Date value) {
            addCriterion("CBPM03 <=", value, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03In(List<Date> values) {
            addCriterion("CBPM03 in", values, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03NotIn(List<Date> values) {
            addCriterion("CBPM03 not in", values, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03Between(Date value1, Date value2) {
            addCriterion("CBPM03 between", value1, value2, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm03NotBetween(Date value1, Date value2) {
            addCriterion("CBPM03 not between", value1, value2, "cbpm03");
            return (Criteria) this;
        }

        public Criteria andCbpm04IsNull() {
            addCriterion("CBPM04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm04IsNotNull() {
            addCriterion("CBPM04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm04EqualTo(Integer value) {
            addCriterion("CBPM04 =", value, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04NotEqualTo(Integer value) {
            addCriterion("CBPM04 <>", value, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04GreaterThan(Integer value) {
            addCriterion("CBPM04 >", value, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM04 >=", value, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04LessThan(Integer value) {
            addCriterion("CBPM04 <", value, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM04 <=", value, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04In(List<Integer> values) {
            addCriterion("CBPM04 in", values, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04NotIn(List<Integer> values) {
            addCriterion("CBPM04 not in", values, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04Between(Integer value1, Integer value2) {
            addCriterion("CBPM04 between", value1, value2, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM04 not between", value1, value2, "cbpm04");
            return (Criteria) this;
        }

        public Criteria andCbpm05IsNull() {
            addCriterion("CBPM05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm05IsNotNull() {
            addCriterion("CBPM05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm05EqualTo(Date value) {
            addCriterion("CBPM05 =", value, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05NotEqualTo(Date value) {
            addCriterion("CBPM05 <>", value, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05GreaterThan(Date value) {
            addCriterion("CBPM05 >", value, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPM05 >=", value, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05LessThan(Date value) {
            addCriterion("CBPM05 <", value, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05LessThanOrEqualTo(Date value) {
            addCriterion("CBPM05 <=", value, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05In(List<Date> values) {
            addCriterion("CBPM05 in", values, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05NotIn(List<Date> values) {
            addCriterion("CBPM05 not in", values, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05Between(Date value1, Date value2) {
            addCriterion("CBPM05 between", value1, value2, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm05NotBetween(Date value1, Date value2) {
            addCriterion("CBPM05 not between", value1, value2, "cbpm05");
            return (Criteria) this;
        }

        public Criteria andCbpm06IsNull() {
            addCriterion("CBPM06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm06IsNotNull() {
            addCriterion("CBPM06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm06EqualTo(Integer value) {
            addCriterion("CBPM06 =", value, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06NotEqualTo(Integer value) {
            addCriterion("CBPM06 <>", value, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06GreaterThan(Integer value) {
            addCriterion("CBPM06 >", value, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM06 >=", value, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06LessThan(Integer value) {
            addCriterion("CBPM06 <", value, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM06 <=", value, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06In(List<Integer> values) {
            addCriterion("CBPM06 in", values, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06NotIn(List<Integer> values) {
            addCriterion("CBPM06 not in", values, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06Between(Integer value1, Integer value2) {
            addCriterion("CBPM06 between", value1, value2, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM06 not between", value1, value2, "cbpm06");
            return (Criteria) this;
        }

        public Criteria andCbpm07IsNull() {
            addCriterion("CBPM07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm07IsNotNull() {
            addCriterion("CBPM07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm07EqualTo(Integer value) {
            addCriterion("CBPM07 =", value, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07NotEqualTo(Integer value) {
            addCriterion("CBPM07 <>", value, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07GreaterThan(Integer value) {
            addCriterion("CBPM07 >", value, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM07 >=", value, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07LessThan(Integer value) {
            addCriterion("CBPM07 <", value, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM07 <=", value, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07In(List<Integer> values) {
            addCriterion("CBPM07 in", values, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07NotIn(List<Integer> values) {
            addCriterion("CBPM07 not in", values, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07Between(Integer value1, Integer value2) {
            addCriterion("CBPM07 between", value1, value2, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM07 not between", value1, value2, "cbpm07");
            return (Criteria) this;
        }

        public Criteria andCbpm08IsNull() {
            addCriterion("CBPM08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm08IsNotNull() {
            addCriterion("CBPM08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm08EqualTo(Integer value) {
            addCriterion("CBPM08 =", value, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08NotEqualTo(Integer value) {
            addCriterion("CBPM08 <>", value, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08GreaterThan(Integer value) {
            addCriterion("CBPM08 >", value, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM08 >=", value, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08LessThan(Integer value) {
            addCriterion("CBPM08 <", value, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM08 <=", value, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08In(List<Integer> values) {
            addCriterion("CBPM08 in", values, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08NotIn(List<Integer> values) {
            addCriterion("CBPM08 not in", values, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08Between(Integer value1, Integer value2) {
            addCriterion("CBPM08 between", value1, value2, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM08 not between", value1, value2, "cbpm08");
            return (Criteria) this;
        }

        public Criteria andCbpm09IsNull() {
            addCriterion("CBPM09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm09IsNotNull() {
            addCriterion("CBPM09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm09EqualTo(String value) {
            addCriterion("CBPM09 =", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09NotEqualTo(String value) {
            addCriterion("CBPM09 <>", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09GreaterThan(String value) {
            addCriterion("CBPM09 >", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09GreaterThanOrEqualTo(String value) {
            addCriterion("CBPM09 >=", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09LessThan(String value) {
            addCriterion("CBPM09 <", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09LessThanOrEqualTo(String value) {
            addCriterion("CBPM09 <=", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09Like(String value) {
            addCriterion("CBPM09 like", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09NotLike(String value) {
            addCriterion("CBPM09 not like", value, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09In(List<String> values) {
            addCriterion("CBPM09 in", values, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09NotIn(List<String> values) {
            addCriterion("CBPM09 not in", values, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09Between(String value1, String value2) {
            addCriterion("CBPM09 between", value1, value2, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm09NotBetween(String value1, String value2) {
            addCriterion("CBPM09 not between", value1, value2, "cbpm09");
            return (Criteria) this;
        }

        public Criteria andCbpm10IsNull() {
            addCriterion("CBPM10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm10IsNotNull() {
            addCriterion("CBPM10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm10EqualTo(Integer value) {
            addCriterion("CBPM10 =", value, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10NotEqualTo(Integer value) {
            addCriterion("CBPM10 <>", value, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10GreaterThan(Integer value) {
            addCriterion("CBPM10 >", value, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM10 >=", value, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10LessThan(Integer value) {
            addCriterion("CBPM10 <", value, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM10 <=", value, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10In(List<Integer> values) {
            addCriterion("CBPM10 in", values, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10NotIn(List<Integer> values) {
            addCriterion("CBPM10 not in", values, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10Between(Integer value1, Integer value2) {
            addCriterion("CBPM10 between", value1, value2, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM10 not between", value1, value2, "cbpm10");
            return (Criteria) this;
        }

        public Criteria andCbpm11IsNull() {
            addCriterion("CBPM11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm11IsNotNull() {
            addCriterion("CBPM11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm11EqualTo(Integer value) {
            addCriterion("CBPM11 =", value, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11NotEqualTo(Integer value) {
            addCriterion("CBPM11 <>", value, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11GreaterThan(Integer value) {
            addCriterion("CBPM11 >", value, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPM11 >=", value, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11LessThan(Integer value) {
            addCriterion("CBPM11 <", value, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPM11 <=", value, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11In(List<Integer> values) {
            addCriterion("CBPM11 in", values, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11NotIn(List<Integer> values) {
            addCriterion("CBPM11 not in", values, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11Between(Integer value1, Integer value2) {
            addCriterion("CBPM11 between", value1, value2, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPM11 not between", value1, value2, "cbpm11");
            return (Criteria) this;
        }

        public Criteria andCbpm12IsNull() {
            addCriterion("CBPM12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpm12IsNotNull() {
            addCriterion("CBPM12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpm12EqualTo(String value) {
            addCriterion("CBPM12 =", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12NotEqualTo(String value) {
            addCriterion("CBPM12 <>", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12GreaterThan(String value) {
            addCriterion("CBPM12 >", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12GreaterThanOrEqualTo(String value) {
            addCriterion("CBPM12 >=", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12LessThan(String value) {
            addCriterion("CBPM12 <", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12LessThanOrEqualTo(String value) {
            addCriterion("CBPM12 <=", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12Like(String value) {
            addCriterion("CBPM12 like", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12NotLike(String value) {
            addCriterion("CBPM12 not like", value, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12In(List<String> values) {
            addCriterion("CBPM12 in", values, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12NotIn(List<String> values) {
            addCriterion("CBPM12 not in", values, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12Between(String value1, String value2) {
            addCriterion("CBPM12 between", value1, value2, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpm12NotBetween(String value1, String value2) {
            addCriterion("CBPM12 not between", value1, value2, "cbpm12");
            return (Criteria) this;
        }

        public Criteria andCbpk01IsNull() {
            addCriterion("CBPK01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk01IsNotNull() {
            addCriterion("CBPK01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk01EqualTo(Integer value) {
            addCriterion("CBPK01 =", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01NotEqualTo(Integer value) {
            addCriterion("CBPK01 <>", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01GreaterThan(Integer value) {
            addCriterion("CBPK01 >", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK01 >=", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01LessThan(Integer value) {
            addCriterion("CBPK01 <", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK01 <=", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01In(List<Integer> values) {
            addCriterion("CBPK01 in", values, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01NotIn(List<Integer> values) {
            addCriterion("CBPK01 not in", values, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01Between(Integer value1, Integer value2) {
            addCriterion("CBPK01 between", value1, value2, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK01 not between", value1, value2, "cbpk01");
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
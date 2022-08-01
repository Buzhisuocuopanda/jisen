package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CadaCriteria() {
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

        public Criteria andCada01IsNull() {
            addCriterion("CADA01 is null");
            return (Criteria) this;
        }

        public Criteria andCada01IsNotNull() {
            addCriterion("CADA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCada01EqualTo(Integer value) {
            addCriterion("CADA01 =", value, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01NotEqualTo(Integer value) {
            addCriterion("CADA01 <>", value, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01GreaterThan(Integer value) {
            addCriterion("CADA01 >", value, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CADA01 >=", value, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01LessThan(Integer value) {
            addCriterion("CADA01 <", value, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01LessThanOrEqualTo(Integer value) {
            addCriterion("CADA01 <=", value, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01In(List<Integer> values) {
            addCriterion("CADA01 in", values, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01NotIn(List<Integer> values) {
            addCriterion("CADA01 not in", values, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01Between(Integer value1, Integer value2) {
            addCriterion("CADA01 between", value1, value2, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada01NotBetween(Integer value1, Integer value2) {
            addCriterion("CADA01 not between", value1, value2, "cada01");
            return (Criteria) this;
        }

        public Criteria andCada02IsNull() {
            addCriterion("CADA02 is null");
            return (Criteria) this;
        }

        public Criteria andCada02IsNotNull() {
            addCriterion("CADA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCada02EqualTo(Integer value) {
            addCriterion("CADA02 =", value, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02NotEqualTo(Integer value) {
            addCriterion("CADA02 <>", value, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02GreaterThan(Integer value) {
            addCriterion("CADA02 >", value, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CADA02 >=", value, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02LessThan(Integer value) {
            addCriterion("CADA02 <", value, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02LessThanOrEqualTo(Integer value) {
            addCriterion("CADA02 <=", value, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02In(List<Integer> values) {
            addCriterion("CADA02 in", values, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02NotIn(List<Integer> values) {
            addCriterion("CADA02 not in", values, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02Between(Integer value1, Integer value2) {
            addCriterion("CADA02 between", value1, value2, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada02NotBetween(Integer value1, Integer value2) {
            addCriterion("CADA02 not between", value1, value2, "cada02");
            return (Criteria) this;
        }

        public Criteria andCada03IsNull() {
            addCriterion("CADA03 is null");
            return (Criteria) this;
        }

        public Criteria andCada03IsNotNull() {
            addCriterion("CADA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCada03EqualTo(Date value) {
            addCriterion("CADA03 =", value, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03NotEqualTo(Date value) {
            addCriterion("CADA03 <>", value, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03GreaterThan(Date value) {
            addCriterion("CADA03 >", value, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03GreaterThanOrEqualTo(Date value) {
            addCriterion("CADA03 >=", value, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03LessThan(Date value) {
            addCriterion("CADA03 <", value, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03LessThanOrEqualTo(Date value) {
            addCriterion("CADA03 <=", value, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03In(List<Date> values) {
            addCriterion("CADA03 in", values, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03NotIn(List<Date> values) {
            addCriterion("CADA03 not in", values, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03Between(Date value1, Date value2) {
            addCriterion("CADA03 between", value1, value2, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada03NotBetween(Date value1, Date value2) {
            addCriterion("CADA03 not between", value1, value2, "cada03");
            return (Criteria) this;
        }

        public Criteria andCada04IsNull() {
            addCriterion("CADA04 is null");
            return (Criteria) this;
        }

        public Criteria andCada04IsNotNull() {
            addCriterion("CADA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCada04EqualTo(Date value) {
            addCriterion("CADA04 =", value, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04NotEqualTo(Date value) {
            addCriterion("CADA04 <>", value, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04GreaterThan(Date value) {
            addCriterion("CADA04 >", value, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04GreaterThanOrEqualTo(Date value) {
            addCriterion("CADA04 >=", value, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04LessThan(Date value) {
            addCriterion("CADA04 <", value, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04LessThanOrEqualTo(Date value) {
            addCriterion("CADA04 <=", value, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04In(List<Date> values) {
            addCriterion("CADA04 in", values, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04NotIn(List<Date> values) {
            addCriterion("CADA04 not in", values, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04Between(Date value1, Date value2) {
            addCriterion("CADA04 between", value1, value2, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada04NotBetween(Date value1, Date value2) {
            addCriterion("CADA04 not between", value1, value2, "cada04");
            return (Criteria) this;
        }

        public Criteria andCada05IsNull() {
            addCriterion("CADA05 is null");
            return (Criteria) this;
        }

        public Criteria andCada05IsNotNull() {
            addCriterion("CADA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCada05EqualTo(Integer value) {
            addCriterion("CADA05 =", value, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05NotEqualTo(Integer value) {
            addCriterion("CADA05 <>", value, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05GreaterThan(Integer value) {
            addCriterion("CADA05 >", value, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CADA05 >=", value, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05LessThan(Integer value) {
            addCriterion("CADA05 <", value, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05LessThanOrEqualTo(Integer value) {
            addCriterion("CADA05 <=", value, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05In(List<Integer> values) {
            addCriterion("CADA05 in", values, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05NotIn(List<Integer> values) {
            addCriterion("CADA05 not in", values, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05Between(Integer value1, Integer value2) {
            addCriterion("CADA05 between", value1, value2, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada05NotBetween(Integer value1, Integer value2) {
            addCriterion("CADA05 not between", value1, value2, "cada05");
            return (Criteria) this;
        }

        public Criteria andCada06IsNull() {
            addCriterion("CADA06 is null");
            return (Criteria) this;
        }

        public Criteria andCada06IsNotNull() {
            addCriterion("CADA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCada06EqualTo(Integer value) {
            addCriterion("CADA06 =", value, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06NotEqualTo(Integer value) {
            addCriterion("CADA06 <>", value, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06GreaterThan(Integer value) {
            addCriterion("CADA06 >", value, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CADA06 >=", value, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06LessThan(Integer value) {
            addCriterion("CADA06 <", value, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06LessThanOrEqualTo(Integer value) {
            addCriterion("CADA06 <=", value, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06In(List<Integer> values) {
            addCriterion("CADA06 in", values, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06NotIn(List<Integer> values) {
            addCriterion("CADA06 not in", values, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06Between(Integer value1, Integer value2) {
            addCriterion("CADA06 between", value1, value2, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada06NotBetween(Integer value1, Integer value2) {
            addCriterion("CADA06 not between", value1, value2, "cada06");
            return (Criteria) this;
        }

        public Criteria andCada07IsNull() {
            addCriterion("CADA07 is null");
            return (Criteria) this;
        }

        public Criteria andCada07IsNotNull() {
            addCriterion("CADA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCada07EqualTo(Integer value) {
            addCriterion("CADA07 =", value, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07NotEqualTo(Integer value) {
            addCriterion("CADA07 <>", value, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07GreaterThan(Integer value) {
            addCriterion("CADA07 >", value, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CADA07 >=", value, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07LessThan(Integer value) {
            addCriterion("CADA07 <", value, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07LessThanOrEqualTo(Integer value) {
            addCriterion("CADA07 <=", value, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07In(List<Integer> values) {
            addCriterion("CADA07 in", values, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07NotIn(List<Integer> values) {
            addCriterion("CADA07 not in", values, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07Between(Integer value1, Integer value2) {
            addCriterion("CADA07 between", value1, value2, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada07NotBetween(Integer value1, Integer value2) {
            addCriterion("CADA07 not between", value1, value2, "cada07");
            return (Criteria) this;
        }

        public Criteria andCada08IsNull() {
            addCriterion("CADA08 is null");
            return (Criteria) this;
        }

        public Criteria andCada08IsNotNull() {
            addCriterion("CADA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCada08EqualTo(String value) {
            addCriterion("CADA08 =", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08NotEqualTo(String value) {
            addCriterion("CADA08 <>", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08GreaterThan(String value) {
            addCriterion("CADA08 >", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08GreaterThanOrEqualTo(String value) {
            addCriterion("CADA08 >=", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08LessThan(String value) {
            addCriterion("CADA08 <", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08LessThanOrEqualTo(String value) {
            addCriterion("CADA08 <=", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08Like(String value) {
            addCriterion("CADA08 like", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08NotLike(String value) {
            addCriterion("CADA08 not like", value, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08In(List<String> values) {
            addCriterion("CADA08 in", values, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08NotIn(List<String> values) {
            addCriterion("CADA08 not in", values, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08Between(String value1, String value2) {
            addCriterion("CADA08 between", value1, value2, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada08NotBetween(String value1, String value2) {
            addCriterion("CADA08 not between", value1, value2, "cada08");
            return (Criteria) this;
        }

        public Criteria andCada09IsNull() {
            addCriterion("CADA09 is null");
            return (Criteria) this;
        }

        public Criteria andCada09IsNotNull() {
            addCriterion("CADA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCada09EqualTo(String value) {
            addCriterion("CADA09 =", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09NotEqualTo(String value) {
            addCriterion("CADA09 <>", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09GreaterThan(String value) {
            addCriterion("CADA09 >", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09GreaterThanOrEqualTo(String value) {
            addCriterion("CADA09 >=", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09LessThan(String value) {
            addCriterion("CADA09 <", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09LessThanOrEqualTo(String value) {
            addCriterion("CADA09 <=", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09Like(String value) {
            addCriterion("CADA09 like", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09NotLike(String value) {
            addCriterion("CADA09 not like", value, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09In(List<String> values) {
            addCriterion("CADA09 in", values, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09NotIn(List<String> values) {
            addCriterion("CADA09 not in", values, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09Between(String value1, String value2) {
            addCriterion("CADA09 between", value1, value2, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada09NotBetween(String value1, String value2) {
            addCriterion("CADA09 not between", value1, value2, "cada09");
            return (Criteria) this;
        }

        public Criteria andCada10IsNull() {
            addCriterion("CADA10 is null");
            return (Criteria) this;
        }

        public Criteria andCada10IsNotNull() {
            addCriterion("CADA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCada10EqualTo(Integer value) {
            addCriterion("CADA10 =", value, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10NotEqualTo(Integer value) {
            addCriterion("CADA10 <>", value, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10GreaterThan(Integer value) {
            addCriterion("CADA10 >", value, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CADA10 >=", value, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10LessThan(Integer value) {
            addCriterion("CADA10 <", value, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10LessThanOrEqualTo(Integer value) {
            addCriterion("CADA10 <=", value, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10In(List<Integer> values) {
            addCriterion("CADA10 in", values, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10NotIn(List<Integer> values) {
            addCriterion("CADA10 not in", values, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10Between(Integer value1, Integer value2) {
            addCriterion("CADA10 between", value1, value2, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada10NotBetween(Integer value1, Integer value2) {
            addCriterion("CADA10 not between", value1, value2, "cada10");
            return (Criteria) this;
        }

        public Criteria andCada11IsNull() {
            addCriterion("CADA11 is null");
            return (Criteria) this;
        }

        public Criteria andCada11IsNotNull() {
            addCriterion("CADA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCada11EqualTo(String value) {
            addCriterion("CADA11 =", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11NotEqualTo(String value) {
            addCriterion("CADA11 <>", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11GreaterThan(String value) {
            addCriterion("CADA11 >", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11GreaterThanOrEqualTo(String value) {
            addCriterion("CADA11 >=", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11LessThan(String value) {
            addCriterion("CADA11 <", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11LessThanOrEqualTo(String value) {
            addCriterion("CADA11 <=", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11Like(String value) {
            addCriterion("CADA11 like", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11NotLike(String value) {
            addCriterion("CADA11 not like", value, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11In(List<String> values) {
            addCriterion("CADA11 in", values, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11NotIn(List<String> values) {
            addCriterion("CADA11 not in", values, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11Between(String value1, String value2) {
            addCriterion("CADA11 between", value1, value2, "cada11");
            return (Criteria) this;
        }

        public Criteria andCada11NotBetween(String value1, String value2) {
            addCriterion("CADA11 not between", value1, value2, "cada11");
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
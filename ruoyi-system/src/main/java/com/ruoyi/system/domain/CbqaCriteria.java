package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbqaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbqaCriteria() {
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

        public Criteria andCbqa01IsNull() {
            addCriterion("CBQA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa01IsNotNull() {
            addCriterion("CBQA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa01EqualTo(Integer value) {
            addCriterion("CBQA01 =", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01NotEqualTo(Integer value) {
            addCriterion("CBQA01 <>", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01GreaterThan(Integer value) {
            addCriterion("CBQA01 >", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA01 >=", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01LessThan(Integer value) {
            addCriterion("CBQA01 <", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA01 <=", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01In(List<Integer> values) {
            addCriterion("CBQA01 in", values, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01NotIn(List<Integer> values) {
            addCriterion("CBQA01 not in", values, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01Between(Integer value1, Integer value2) {
            addCriterion("CBQA01 between", value1, value2, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA01 not between", value1, value2, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa02IsNull() {
            addCriterion("CBQA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa02IsNotNull() {
            addCriterion("CBQA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa02EqualTo(Date value) {
            addCriterion("CBQA02 =", value, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02NotEqualTo(Date value) {
            addCriterion("CBQA02 <>", value, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02GreaterThan(Date value) {
            addCriterion("CBQA02 >", value, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBQA02 >=", value, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02LessThan(Date value) {
            addCriterion("CBQA02 <", value, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02LessThanOrEqualTo(Date value) {
            addCriterion("CBQA02 <=", value, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02In(List<Date> values) {
            addCriterion("CBQA02 in", values, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02NotIn(List<Date> values) {
            addCriterion("CBQA02 not in", values, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02Between(Date value1, Date value2) {
            addCriterion("CBQA02 between", value1, value2, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa02NotBetween(Date value1, Date value2) {
            addCriterion("CBQA02 not between", value1, value2, "cbqa02");
            return (Criteria) this;
        }

        public Criteria andCbqa03IsNull() {
            addCriterion("CBQA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa03IsNotNull() {
            addCriterion("CBQA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa03EqualTo(Integer value) {
            addCriterion("CBQA03 =", value, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03NotEqualTo(Integer value) {
            addCriterion("CBQA03 <>", value, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03GreaterThan(Integer value) {
            addCriterion("CBQA03 >", value, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA03 >=", value, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03LessThan(Integer value) {
            addCriterion("CBQA03 <", value, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA03 <=", value, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03In(List<Integer> values) {
            addCriterion("CBQA03 in", values, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03NotIn(List<Integer> values) {
            addCriterion("CBQA03 not in", values, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03Between(Integer value1, Integer value2) {
            addCriterion("CBQA03 between", value1, value2, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA03 not between", value1, value2, "cbqa03");
            return (Criteria) this;
        }

        public Criteria andCbqa04IsNull() {
            addCriterion("CBQA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa04IsNotNull() {
            addCriterion("CBQA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa04EqualTo(Date value) {
            addCriterion("CBQA04 =", value, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04NotEqualTo(Date value) {
            addCriterion("CBQA04 <>", value, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04GreaterThan(Date value) {
            addCriterion("CBQA04 >", value, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBQA04 >=", value, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04LessThan(Date value) {
            addCriterion("CBQA04 <", value, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04LessThanOrEqualTo(Date value) {
            addCriterion("CBQA04 <=", value, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04In(List<Date> values) {
            addCriterion("CBQA04 in", values, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04NotIn(List<Date> values) {
            addCriterion("CBQA04 not in", values, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04Between(Date value1, Date value2) {
            addCriterion("CBQA04 between", value1, value2, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa04NotBetween(Date value1, Date value2) {
            addCriterion("CBQA04 not between", value1, value2, "cbqa04");
            return (Criteria) this;
        }

        public Criteria andCbqa05IsNull() {
            addCriterion("CBQA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa05IsNotNull() {
            addCriterion("CBQA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa05EqualTo(Integer value) {
            addCriterion("CBQA05 =", value, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05NotEqualTo(Integer value) {
            addCriterion("CBQA05 <>", value, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05GreaterThan(Integer value) {
            addCriterion("CBQA05 >", value, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA05 >=", value, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05LessThan(Integer value) {
            addCriterion("CBQA05 <", value, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA05 <=", value, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05In(List<Integer> values) {
            addCriterion("CBQA05 in", values, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05NotIn(List<Integer> values) {
            addCriterion("CBQA05 not in", values, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05Between(Integer value1, Integer value2) {
            addCriterion("CBQA05 between", value1, value2, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA05 not between", value1, value2, "cbqa05");
            return (Criteria) this;
        }

        public Criteria andCbqa06IsNull() {
            addCriterion("CBQA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa06IsNotNull() {
            addCriterion("CBQA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa06EqualTo(Integer value) {
            addCriterion("CBQA06 =", value, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06NotEqualTo(Integer value) {
            addCriterion("CBQA06 <>", value, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06GreaterThan(Integer value) {
            addCriterion("CBQA06 >", value, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA06 >=", value, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06LessThan(Integer value) {
            addCriterion("CBQA06 <", value, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA06 <=", value, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06In(List<Integer> values) {
            addCriterion("CBQA06 in", values, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06NotIn(List<Integer> values) {
            addCriterion("CBQA06 not in", values, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06Between(Integer value1, Integer value2) {
            addCriterion("CBQA06 between", value1, value2, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA06 not between", value1, value2, "cbqa06");
            return (Criteria) this;
        }

        public Criteria andCbqa07IsNull() {
            addCriterion("CBQA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa07IsNotNull() {
            addCriterion("CBQA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa07EqualTo(String value) {
            addCriterion("CBQA07 =", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07NotEqualTo(String value) {
            addCriterion("CBQA07 <>", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07GreaterThan(String value) {
            addCriterion("CBQA07 >", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07GreaterThanOrEqualTo(String value) {
            addCriterion("CBQA07 >=", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07LessThan(String value) {
            addCriterion("CBQA07 <", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07LessThanOrEqualTo(String value) {
            addCriterion("CBQA07 <=", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07Like(String value) {
            addCriterion("CBQA07 like", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07NotLike(String value) {
            addCriterion("CBQA07 not like", value, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07In(List<String> values) {
            addCriterion("CBQA07 in", values, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07NotIn(List<String> values) {
            addCriterion("CBQA07 not in", values, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07Between(String value1, String value2) {
            addCriterion("CBQA07 between", value1, value2, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa07NotBetween(String value1, String value2) {
            addCriterion("CBQA07 not between", value1, value2, "cbqa07");
            return (Criteria) this;
        }

        public Criteria andCbqa08IsNull() {
            addCriterion("CBQA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa08IsNotNull() {
            addCriterion("CBQA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa08EqualTo(Date value) {
            addCriterion("CBQA08 =", value, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08NotEqualTo(Date value) {
            addCriterion("CBQA08 <>", value, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08GreaterThan(Date value) {
            addCriterion("CBQA08 >", value, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBQA08 >=", value, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08LessThan(Date value) {
            addCriterion("CBQA08 <", value, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08LessThanOrEqualTo(Date value) {
            addCriterion("CBQA08 <=", value, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08In(List<Date> values) {
            addCriterion("CBQA08 in", values, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08NotIn(List<Date> values) {
            addCriterion("CBQA08 not in", values, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08Between(Date value1, Date value2) {
            addCriterion("CBQA08 between", value1, value2, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa08NotBetween(Date value1, Date value2) {
            addCriterion("CBQA08 not between", value1, value2, "cbqa08");
            return (Criteria) this;
        }

        public Criteria andCbqa09IsNull() {
            addCriterion("CBQA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa09IsNotNull() {
            addCriterion("CBQA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa09EqualTo(Integer value) {
            addCriterion("CBQA09 =", value, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09NotEqualTo(Integer value) {
            addCriterion("CBQA09 <>", value, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09GreaterThan(Integer value) {
            addCriterion("CBQA09 >", value, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA09 >=", value, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09LessThan(Integer value) {
            addCriterion("CBQA09 <", value, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA09 <=", value, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09In(List<Integer> values) {
            addCriterion("CBQA09 in", values, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09NotIn(List<Integer> values) {
            addCriterion("CBQA09 not in", values, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09Between(Integer value1, Integer value2) {
            addCriterion("CBQA09 between", value1, value2, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA09 not between", value1, value2, "cbqa09");
            return (Criteria) this;
        }

        public Criteria andCbqa10IsNull() {
            addCriterion("CBQA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa10IsNotNull() {
            addCriterion("CBQA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa10EqualTo(Integer value) {
            addCriterion("CBQA10 =", value, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10NotEqualTo(Integer value) {
            addCriterion("CBQA10 <>", value, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10GreaterThan(Integer value) {
            addCriterion("CBQA10 >", value, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA10 >=", value, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10LessThan(Integer value) {
            addCriterion("CBQA10 <", value, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA10 <=", value, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10In(List<Integer> values) {
            addCriterion("CBQA10 in", values, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10NotIn(List<Integer> values) {
            addCriterion("CBQA10 not in", values, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10Between(Integer value1, Integer value2) {
            addCriterion("CBQA10 between", value1, value2, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA10 not between", value1, value2, "cbqa10");
            return (Criteria) this;
        }

        public Criteria andCbqa11IsNull() {
            addCriterion("CBQA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa11IsNotNull() {
            addCriterion("CBQA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa11EqualTo(Date value) {
            addCriterion("CBQA11 =", value, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11NotEqualTo(Date value) {
            addCriterion("CBQA11 <>", value, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11GreaterThan(Date value) {
            addCriterion("CBQA11 >", value, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11GreaterThanOrEqualTo(Date value) {
            addCriterion("CBQA11 >=", value, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11LessThan(Date value) {
            addCriterion("CBQA11 <", value, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11LessThanOrEqualTo(Date value) {
            addCriterion("CBQA11 <=", value, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11In(List<Date> values) {
            addCriterion("CBQA11 in", values, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11NotIn(List<Date> values) {
            addCriterion("CBQA11 not in", values, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11Between(Date value1, Date value2) {
            addCriterion("CBQA11 between", value1, value2, "cbqa11");
            return (Criteria) this;
        }

        public Criteria andCbqa11NotBetween(Date value1, Date value2) {
            addCriterion("CBQA11 not between", value1, value2, "cbqa11");
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
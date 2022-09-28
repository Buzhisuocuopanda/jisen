package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbdaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbdaCriteria() {
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

        public Criteria andCbda01IsNull() {
            addCriterion("CBDA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbda01IsNotNull() {
            addCriterion("CBDA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda01EqualTo(Integer value) {
            addCriterion("CBDA01 =", value, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01NotEqualTo(Integer value) {
            addCriterion("CBDA01 <>", value, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01GreaterThan(Integer value) {
            addCriterion("CBDA01 >", value, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA01 >=", value, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01LessThan(Integer value) {
            addCriterion("CBDA01 <", value, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA01 <=", value, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01In(List<Integer> values) {
            addCriterion("CBDA01 in", values, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01NotIn(List<Integer> values) {
            addCriterion("CBDA01 not in", values, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01Between(Integer value1, Integer value2) {
            addCriterion("CBDA01 between", value1, value2, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA01 not between", value1, value2, "cbda01");
            return (Criteria) this;
        }

        public Criteria andCbda02IsNull() {
            addCriterion("CBDA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbda02IsNotNull() {
            addCriterion("CBDA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda02EqualTo(Integer value) {
            addCriterion("CBDA02 =", value, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02NotEqualTo(Integer value) {
            addCriterion("CBDA02 <>", value, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02GreaterThan(Integer value) {
            addCriterion("CBDA02 >", value, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA02 >=", value, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02LessThan(Integer value) {
            addCriterion("CBDA02 <", value, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA02 <=", value, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02In(List<Integer> values) {
            addCriterion("CBDA02 in", values, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02NotIn(List<Integer> values) {
            addCriterion("CBDA02 not in", values, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02Between(Integer value1, Integer value2) {
            addCriterion("CBDA02 between", value1, value2, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA02 not between", value1, value2, "cbda02");
            return (Criteria) this;
        }

        public Criteria andCbda03IsNull() {
            addCriterion("CBDA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbda03IsNotNull() {
            addCriterion("CBDA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda03EqualTo(Date value) {
            addCriterion("CBDA03 =", value, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03NotEqualTo(Date value) {
            addCriterion("CBDA03 <>", value, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03GreaterThan(Date value) {
            addCriterion("CBDA03 >", value, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBDA03 >=", value, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03LessThan(Date value) {
            addCriterion("CBDA03 <", value, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03LessThanOrEqualTo(Date value) {
            addCriterion("CBDA03 <=", value, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03In(List<Date> values) {
            addCriterion("CBDA03 in", values, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03NotIn(List<Date> values) {
            addCriterion("CBDA03 not in", values, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03Between(Date value1, Date value2) {
            addCriterion("CBDA03 between", value1, value2, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda03NotBetween(Date value1, Date value2) {
            addCriterion("CBDA03 not between", value1, value2, "cbda03");
            return (Criteria) this;
        }

        public Criteria andCbda04IsNull() {
            addCriterion("CBDA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbda04IsNotNull() {
            addCriterion("CBDA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda04EqualTo(Integer value) {
            addCriterion("CBDA04 =", value, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04NotEqualTo(Integer value) {
            addCriterion("CBDA04 <>", value, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04GreaterThan(Integer value) {
            addCriterion("CBDA04 >", value, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA04 >=", value, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04LessThan(Integer value) {
            addCriterion("CBDA04 <", value, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA04 <=", value, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04In(List<Integer> values) {
            addCriterion("CBDA04 in", values, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04NotIn(List<Integer> values) {
            addCriterion("CBDA04 not in", values, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04Between(Integer value1, Integer value2) {
            addCriterion("CBDA04 between", value1, value2, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA04 not between", value1, value2, "cbda04");
            return (Criteria) this;
        }

        public Criteria andCbda05IsNull() {
            addCriterion("CBDA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbda05IsNotNull() {
            addCriterion("CBDA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda05EqualTo(Date value) {
            addCriterion("CBDA05 =", value, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05NotEqualTo(Date value) {
            addCriterion("CBDA05 <>", value, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05GreaterThan(Date value) {
            addCriterion("CBDA05 >", value, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBDA05 >=", value, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05LessThan(Date value) {
            addCriterion("CBDA05 <", value, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05LessThanOrEqualTo(Date value) {
            addCriterion("CBDA05 <=", value, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05In(List<Date> values) {
            addCriterion("CBDA05 in", values, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05NotIn(List<Date> values) {
            addCriterion("CBDA05 not in", values, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05Between(Date value1, Date value2) {
            addCriterion("CBDA05 between", value1, value2, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda05NotBetween(Date value1, Date value2) {
            addCriterion("CBDA05 not between", value1, value2, "cbda05");
            return (Criteria) this;
        }

        public Criteria andCbda06IsNull() {
            addCriterion("CBDA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbda06IsNotNull() {
            addCriterion("CBDA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda06EqualTo(Integer value) {
            addCriterion("CBDA06 =", value, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06NotEqualTo(Integer value) {
            addCriterion("CBDA06 <>", value, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06GreaterThan(Integer value) {
            addCriterion("CBDA06 >", value, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA06 >=", value, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06LessThan(Integer value) {
            addCriterion("CBDA06 <", value, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA06 <=", value, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06In(List<Integer> values) {
            addCriterion("CBDA06 in", values, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06NotIn(List<Integer> values) {
            addCriterion("CBDA06 not in", values, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06Between(Integer value1, Integer value2) {
            addCriterion("CBDA06 between", value1, value2, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA06 not between", value1, value2, "cbda06");
            return (Criteria) this;
        }

        public Criteria andCbda07IsNull() {
            addCriterion("CBDA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbda07IsNotNull() {
            addCriterion("CBDA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda07EqualTo(Integer value) {
            addCriterion("CBDA07 =", value, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07NotEqualTo(Integer value) {
            addCriterion("CBDA07 <>", value, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07GreaterThan(Integer value) {
            addCriterion("CBDA07 >", value, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA07 >=", value, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07LessThan(Integer value) {
            addCriterion("CBDA07 <", value, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA07 <=", value, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07In(List<Integer> values) {
            addCriterion("CBDA07 in", values, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07NotIn(List<Integer> values) {
            addCriterion("CBDA07 not in", values, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07Between(Integer value1, Integer value2) {
            addCriterion("CBDA07 between", value1, value2, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA07 not between", value1, value2, "cbda07");
            return (Criteria) this;
        }

        public Criteria andCbda08IsNull() {
            addCriterion("CBDA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbda08IsNotNull() {
            addCriterion("CBDA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda08EqualTo(Integer value) {
            addCriterion("CBDA08 =", value, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08NotEqualTo(Integer value) {
            addCriterion("CBDA08 <>", value, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08GreaterThan(Integer value) {
            addCriterion("CBDA08 >", value, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA08 >=", value, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08LessThan(Integer value) {
            addCriterion("CBDA08 <", value, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA08 <=", value, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08In(List<Integer> values) {
            addCriterion("CBDA08 in", values, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08NotIn(List<Integer> values) {
            addCriterion("CBDA08 not in", values, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08Between(Integer value1, Integer value2) {
            addCriterion("CBDA08 between", value1, value2, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA08 not between", value1, value2, "cbda08");
            return (Criteria) this;
        }

        public Criteria andCbda09IsNull() {
            addCriterion("CBDA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbda09IsNotNull() {
            addCriterion("CBDA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda09EqualTo(String value) {
            addCriterion("CBDA09 =", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09NotEqualTo(String value) {
            addCriterion("CBDA09 <>", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09GreaterThan(String value) {
            addCriterion("CBDA09 >", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09GreaterThanOrEqualTo(String value) {
            addCriterion("CBDA09 >=", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09LessThan(String value) {
            addCriterion("CBDA09 <", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09LessThanOrEqualTo(String value) {
            addCriterion("CBDA09 <=", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09Like(String value) {
            addCriterion("CBDA09 like", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09NotLike(String value) {
            addCriterion("CBDA09 not like", value, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09In(List<String> values) {
            addCriterion("CBDA09 in", values, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09NotIn(List<String> values) {
            addCriterion("CBDA09 not in", values, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09Between(String value1, String value2) {
            addCriterion("CBDA09 between", value1, value2, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda09NotBetween(String value1, String value2) {
            addCriterion("CBDA09 not between", value1, value2, "cbda09");
            return (Criteria) this;
        }

        public Criteria andCbda10IsNull() {
            addCriterion("CBDA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbda10IsNotNull() {
            addCriterion("CBDA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda10EqualTo(Integer value) {
            addCriterion("CBDA10 =", value, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10NotEqualTo(Integer value) {
            addCriterion("CBDA10 <>", value, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10GreaterThan(Integer value) {
            addCriterion("CBDA10 >", value, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA10 >=", value, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10LessThan(Integer value) {
            addCriterion("CBDA10 <", value, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA10 <=", value, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10In(List<Integer> values) {
            addCriterion("CBDA10 in", values, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10NotIn(List<Integer> values) {
            addCriterion("CBDA10 not in", values, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10Between(Integer value1, Integer value2) {
            addCriterion("CBDA10 between", value1, value2, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA10 not between", value1, value2, "cbda10");
            return (Criteria) this;
        }

        public Criteria andCbda11IsNull() {
            addCriterion("CBDA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbda11IsNotNull() {
            addCriterion("CBDA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda11EqualTo(Integer value) {
            addCriterion("CBDA11 =", value, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11NotEqualTo(Integer value) {
            addCriterion("CBDA11 <>", value, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11GreaterThan(Integer value) {
            addCriterion("CBDA11 >", value, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA11 >=", value, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11LessThan(Integer value) {
            addCriterion("CBDA11 <", value, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA11 <=", value, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11In(List<Integer> values) {
            addCriterion("CBDA11 in", values, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11NotIn(List<Integer> values) {
            addCriterion("CBDA11 not in", values, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11Between(Integer value1, Integer value2) {
            addCriterion("CBDA11 between", value1, value2, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA11 not between", value1, value2, "cbda11");
            return (Criteria) this;
        }

        public Criteria andCbda12IsNull() {
            addCriterion("CBDA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbda12IsNotNull() {
            addCriterion("CBDA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda12EqualTo(String value) {
            addCriterion("CBDA12 =", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12NotEqualTo(String value) {
            addCriterion("CBDA12 <>", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12GreaterThan(String value) {
            addCriterion("CBDA12 >", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12GreaterThanOrEqualTo(String value) {
            addCriterion("CBDA12 >=", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12LessThan(String value) {
            addCriterion("CBDA12 <", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12LessThanOrEqualTo(String value) {
            addCriterion("CBDA12 <=", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12Like(String value) {
            addCriterion("CBDA12 like", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12NotLike(String value) {
            addCriterion("CBDA12 not like", value, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12In(List<String> values) {
            addCriterion("CBDA12 in", values, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12NotIn(List<String> values) {
            addCriterion("CBDA12 not in", values, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12Between(String value1, String value2) {
            addCriterion("CBDA12 between", value1, value2, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda12NotBetween(String value1, String value2) {
            addCriterion("CBDA12 not between", value1, value2, "cbda12");
            return (Criteria) this;
        }

        public Criteria andCbda13IsNull() {
            addCriterion("CBDA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbda13IsNotNull() {
            addCriterion("CBDA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda13EqualTo(Integer value) {
            addCriterion("CBDA13 =", value, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13NotEqualTo(Integer value) {
            addCriterion("CBDA13 <>", value, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13GreaterThan(Integer value) {
            addCriterion("CBDA13 >", value, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA13 >=", value, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13LessThan(Integer value) {
            addCriterion("CBDA13 <", value, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA13 <=", value, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13In(List<Integer> values) {
            addCriterion("CBDA13 in", values, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13NotIn(List<Integer> values) {
            addCriterion("CBDA13 not in", values, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13Between(Integer value1, Integer value2) {
            addCriterion("CBDA13 between", value1, value2, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda13NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA13 not between", value1, value2, "cbda13");
            return (Criteria) this;
        }

        public Criteria andCbda14IsNull() {
            addCriterion("CBDA14 is null");
            return (Criteria) this;
        }

        public Criteria andCbda14IsNotNull() {
            addCriterion("CBDA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda14EqualTo(Integer value) {
            addCriterion("CBDA14 =", value, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14NotEqualTo(Integer value) {
            addCriterion("CBDA14 <>", value, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14GreaterThan(Integer value) {
            addCriterion("CBDA14 >", value, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA14 >=", value, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14LessThan(Integer value) {
            addCriterion("CBDA14 <", value, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA14 <=", value, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14In(List<Integer> values) {
            addCriterion("CBDA14 in", values, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14NotIn(List<Integer> values) {
            addCriterion("CBDA14 not in", values, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14Between(Integer value1, Integer value2) {
            addCriterion("CBDA14 between", value1, value2, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA14 not between", value1, value2, "cbda14");
            return (Criteria) this;
        }

        public Criteria andCbda15IsNull() {
            addCriterion("CBDA15 is null");
            return (Criteria) this;
        }

        public Criteria andCbda15IsNotNull() {
            addCriterion("CBDA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbda15EqualTo(Integer value) {
            addCriterion("CBDA15 =", value, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15NotEqualTo(Integer value) {
            addCriterion("CBDA15 <>", value, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15GreaterThan(Integer value) {
            addCriterion("CBDA15 >", value, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBDA15 >=", value, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15LessThan(Integer value) {
            addCriterion("CBDA15 <", value, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15LessThanOrEqualTo(Integer value) {
            addCriterion("CBDA15 <=", value, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15In(List<Integer> values) {
            addCriterion("CBDA15 in", values, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15NotIn(List<Integer> values) {
            addCriterion("CBDA15 not in", values, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15Between(Integer value1, Integer value2) {
            addCriterion("CBDA15 between", value1, value2, "cbda15");
            return (Criteria) this;
        }

        public Criteria andCbda15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBDA15 not between", value1, value2, "cbda15");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
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
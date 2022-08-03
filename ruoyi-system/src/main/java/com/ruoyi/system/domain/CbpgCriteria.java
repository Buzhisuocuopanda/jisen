package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpgCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpgCriteria() {
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

        public Criteria andCbpg01IsNull() {
            addCriterion("CBPG01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg01IsNotNull() {
            addCriterion("CBPG01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg01EqualTo(Integer value) {
            addCriterion("CBPG01 =", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotEqualTo(Integer value) {
            addCriterion("CBPG01 <>", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01GreaterThan(Integer value) {
            addCriterion("CBPG01 >", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG01 >=", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01LessThan(Integer value) {
            addCriterion("CBPG01 <", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG01 <=", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01In(List<Integer> values) {
            addCriterion("CBPG01 in", values, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotIn(List<Integer> values) {
            addCriterion("CBPG01 not in", values, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01Between(Integer value1, Integer value2) {
            addCriterion("CBPG01 between", value1, value2, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG01 not between", value1, value2, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg02IsNull() {
            addCriterion("CBPG02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg02IsNotNull() {
            addCriterion("CBPG02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg02EqualTo(Date value) {
            addCriterion("CBPG02 =", value, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02NotEqualTo(Date value) {
            addCriterion("CBPG02 <>", value, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02GreaterThan(Date value) {
            addCriterion("CBPG02 >", value, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPG02 >=", value, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02LessThan(Date value) {
            addCriterion("CBPG02 <", value, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02LessThanOrEqualTo(Date value) {
            addCriterion("CBPG02 <=", value, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02In(List<Date> values) {
            addCriterion("CBPG02 in", values, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02NotIn(List<Date> values) {
            addCriterion("CBPG02 not in", values, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02Between(Date value1, Date value2) {
            addCriterion("CBPG02 between", value1, value2, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg02NotBetween(Date value1, Date value2) {
            addCriterion("CBPG02 not between", value1, value2, "cbpg02");
            return (Criteria) this;
        }

        public Criteria andCbpg03IsNull() {
            addCriterion("CBPG03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg03IsNotNull() {
            addCriterion("CBPG03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg03EqualTo(Integer value) {
            addCriterion("CBPG03 =", value, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03NotEqualTo(Integer value) {
            addCriterion("CBPG03 <>", value, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03GreaterThan(Integer value) {
            addCriterion("CBPG03 >", value, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG03 >=", value, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03LessThan(Integer value) {
            addCriterion("CBPG03 <", value, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG03 <=", value, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03In(List<Integer> values) {
            addCriterion("CBPG03 in", values, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03NotIn(List<Integer> values) {
            addCriterion("CBPG03 not in", values, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03Between(Integer value1, Integer value2) {
            addCriterion("CBPG03 between", value1, value2, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG03 not between", value1, value2, "cbpg03");
            return (Criteria) this;
        }

        public Criteria andCbpg04IsNull() {
            addCriterion("CBPG04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg04IsNotNull() {
            addCriterion("CBPG04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg04EqualTo(Date value) {
            addCriterion("CBPG04 =", value, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04NotEqualTo(Date value) {
            addCriterion("CBPG04 <>", value, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04GreaterThan(Date value) {
            addCriterion("CBPG04 >", value, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPG04 >=", value, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04LessThan(Date value) {
            addCriterion("CBPG04 <", value, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04LessThanOrEqualTo(Date value) {
            addCriterion("CBPG04 <=", value, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04In(List<Date> values) {
            addCriterion("CBPG04 in", values, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04NotIn(List<Date> values) {
            addCriterion("CBPG04 not in", values, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04Between(Date value1, Date value2) {
            addCriterion("CBPG04 between", value1, value2, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg04NotBetween(Date value1, Date value2) {
            addCriterion("CBPG04 not between", value1, value2, "cbpg04");
            return (Criteria) this;
        }

        public Criteria andCbpg05IsNull() {
            addCriterion("CBPG05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg05IsNotNull() {
            addCriterion("CBPG05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg05EqualTo(Integer value) {
            addCriterion("CBPG05 =", value, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05NotEqualTo(Integer value) {
            addCriterion("CBPG05 <>", value, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05GreaterThan(Integer value) {
            addCriterion("CBPG05 >", value, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG05 >=", value, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05LessThan(Integer value) {
            addCriterion("CBPG05 <", value, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG05 <=", value, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05In(List<Integer> values) {
            addCriterion("CBPG05 in", values, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05NotIn(List<Integer> values) {
            addCriterion("CBPG05 not in", values, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05Between(Integer value1, Integer value2) {
            addCriterion("CBPG05 between", value1, value2, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG05 not between", value1, value2, "cbpg05");
            return (Criteria) this;
        }

        public Criteria andCbpg06IsNull() {
            addCriterion("CBPG06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg06IsNotNull() {
            addCriterion("CBPG06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg06EqualTo(Integer value) {
            addCriterion("CBPG06 =", value, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06NotEqualTo(Integer value) {
            addCriterion("CBPG06 <>", value, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06GreaterThan(Integer value) {
            addCriterion("CBPG06 >", value, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG06 >=", value, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06LessThan(Integer value) {
            addCriterion("CBPG06 <", value, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG06 <=", value, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06In(List<Integer> values) {
            addCriterion("CBPG06 in", values, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06NotIn(List<Integer> values) {
            addCriterion("CBPG06 not in", values, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06Between(Integer value1, Integer value2) {
            addCriterion("CBPG06 between", value1, value2, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG06 not between", value1, value2, "cbpg06");
            return (Criteria) this;
        }

        public Criteria andCbpg07IsNull() {
            addCriterion("CBPG07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg07IsNotNull() {
            addCriterion("CBPG07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg07EqualTo(String value) {
            addCriterion("CBPG07 =", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07NotEqualTo(String value) {
            addCriterion("CBPG07 <>", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07GreaterThan(String value) {
            addCriterion("CBPG07 >", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07GreaterThanOrEqualTo(String value) {
            addCriterion("CBPG07 >=", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07LessThan(String value) {
            addCriterion("CBPG07 <", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07LessThanOrEqualTo(String value) {
            addCriterion("CBPG07 <=", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07Like(String value) {
            addCriterion("CBPG07 like", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07NotLike(String value) {
            addCriterion("CBPG07 not like", value, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07In(List<String> values) {
            addCriterion("CBPG07 in", values, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07NotIn(List<String> values) {
            addCriterion("CBPG07 not in", values, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07Between(String value1, String value2) {
            addCriterion("CBPG07 between", value1, value2, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg07NotBetween(String value1, String value2) {
            addCriterion("CBPG07 not between", value1, value2, "cbpg07");
            return (Criteria) this;
        }

        public Criteria andCbpg08IsNull() {
            addCriterion("CBPG08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg08IsNotNull() {
            addCriterion("CBPG08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg08EqualTo(Date value) {
            addCriterion("CBPG08 =", value, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08NotEqualTo(Date value) {
            addCriterion("CBPG08 <>", value, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08GreaterThan(Date value) {
            addCriterion("CBPG08 >", value, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPG08 >=", value, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08LessThan(Date value) {
            addCriterion("CBPG08 <", value, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08LessThanOrEqualTo(Date value) {
            addCriterion("CBPG08 <=", value, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08In(List<Date> values) {
            addCriterion("CBPG08 in", values, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08NotIn(List<Date> values) {
            addCriterion("CBPG08 not in", values, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08Between(Date value1, Date value2) {
            addCriterion("CBPG08 between", value1, value2, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg08NotBetween(Date value1, Date value2) {
            addCriterion("CBPG08 not between", value1, value2, "cbpg08");
            return (Criteria) this;
        }

        public Criteria andCbpg09IsNull() {
            addCriterion("CBPG09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg09IsNotNull() {
            addCriterion("CBPG09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg09EqualTo(Integer value) {
            addCriterion("CBPG09 =", value, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09NotEqualTo(Integer value) {
            addCriterion("CBPG09 <>", value, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09GreaterThan(Integer value) {
            addCriterion("CBPG09 >", value, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG09 >=", value, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09LessThan(Integer value) {
            addCriterion("CBPG09 <", value, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG09 <=", value, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09In(List<Integer> values) {
            addCriterion("CBPG09 in", values, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09NotIn(List<Integer> values) {
            addCriterion("CBPG09 not in", values, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09Between(Integer value1, Integer value2) {
            addCriterion("CBPG09 between", value1, value2, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG09 not between", value1, value2, "cbpg09");
            return (Criteria) this;
        }

        public Criteria andCbpg10IsNull() {
            addCriterion("CBPG10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg10IsNotNull() {
            addCriterion("CBPG10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg10EqualTo(Integer value) {
            addCriterion("CBPG10 =", value, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10NotEqualTo(Integer value) {
            addCriterion("CBPG10 <>", value, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10GreaterThan(Integer value) {
            addCriterion("CBPG10 >", value, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG10 >=", value, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10LessThan(Integer value) {
            addCriterion("CBPG10 <", value, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG10 <=", value, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10In(List<Integer> values) {
            addCriterion("CBPG10 in", values, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10NotIn(List<Integer> values) {
            addCriterion("CBPG10 not in", values, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10Between(Integer value1, Integer value2) {
            addCriterion("CBPG10 between", value1, value2, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG10 not between", value1, value2, "cbpg10");
            return (Criteria) this;
        }

        public Criteria andCbpg11IsNull() {
            addCriterion("CBPG11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg11IsNotNull() {
            addCriterion("CBPG11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg11EqualTo(Integer value) {
            addCriterion("CBPG11 =", value, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11NotEqualTo(Integer value) {
            addCriterion("CBPG11 <>", value, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11GreaterThan(Integer value) {
            addCriterion("CBPG11 >", value, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG11 >=", value, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11LessThan(Integer value) {
            addCriterion("CBPG11 <", value, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG11 <=", value, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11In(List<Integer> values) {
            addCriterion("CBPG11 in", values, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11NotIn(List<Integer> values) {
            addCriterion("CBPG11 not in", values, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11Between(Integer value1, Integer value2) {
            addCriterion("CBPG11 between", value1, value2, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG11 not between", value1, value2, "cbpg11");
            return (Criteria) this;
        }

        public Criteria andCbpg12IsNull() {
            addCriterion("CBPG12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg12IsNotNull() {
            addCriterion("CBPG12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg12EqualTo(Integer value) {
            addCriterion("CBPG12 =", value, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12NotEqualTo(Integer value) {
            addCriterion("CBPG12 <>", value, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12GreaterThan(Integer value) {
            addCriterion("CBPG12 >", value, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG12 >=", value, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12LessThan(Integer value) {
            addCriterion("CBPG12 <", value, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG12 <=", value, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12In(List<Integer> values) {
            addCriterion("CBPG12 in", values, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12NotIn(List<Integer> values) {
            addCriterion("CBPG12 not in", values, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12Between(Integer value1, Integer value2) {
            addCriterion("CBPG12 between", value1, value2, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG12 not between", value1, value2, "cbpg12");
            return (Criteria) this;
        }

        public Criteria andCbpg13IsNull() {
            addCriterion("CBPG13 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg13IsNotNull() {
            addCriterion("CBPG13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg13EqualTo(Date value) {
            addCriterion("CBPG13 =", value, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13NotEqualTo(Date value) {
            addCriterion("CBPG13 <>", value, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13GreaterThan(Date value) {
            addCriterion("CBPG13 >", value, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPG13 >=", value, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13LessThan(Date value) {
            addCriterion("CBPG13 <", value, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13LessThanOrEqualTo(Date value) {
            addCriterion("CBPG13 <=", value, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13In(List<Date> values) {
            addCriterion("CBPG13 in", values, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13NotIn(List<Date> values) {
            addCriterion("CBPG13 not in", values, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13Between(Date value1, Date value2) {
            addCriterion("CBPG13 between", value1, value2, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg13NotBetween(Date value1, Date value2) {
            addCriterion("CBPG13 not between", value1, value2, "cbpg13");
            return (Criteria) this;
        }

        public Criteria andCbpg14IsNull() {
            addCriterion("CBPG14 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg14IsNotNull() {
            addCriterion("CBPG14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg14EqualTo(Integer value) {
            addCriterion("CBPG14 =", value, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14NotEqualTo(Integer value) {
            addCriterion("CBPG14 <>", value, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14GreaterThan(Integer value) {
            addCriterion("CBPG14 >", value, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG14 >=", value, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14LessThan(Integer value) {
            addCriterion("CBPG14 <", value, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG14 <=", value, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14In(List<Integer> values) {
            addCriterion("CBPG14 in", values, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14NotIn(List<Integer> values) {
            addCriterion("CBPG14 not in", values, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14Between(Integer value1, Integer value2) {
            addCriterion("CBPG14 between", value1, value2, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG14 not between", value1, value2, "cbpg14");
            return (Criteria) this;
        }

        public Criteria andCbpg15IsNull() {
            addCriterion("CBPG15 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg15IsNotNull() {
            addCriterion("CBPG15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg15EqualTo(Date value) {
            addCriterion("CBPG15 =", value, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15NotEqualTo(Date value) {
            addCriterion("CBPG15 <>", value, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15GreaterThan(Date value) {
            addCriterion("CBPG15 >", value, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPG15 >=", value, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15LessThan(Date value) {
            addCriterion("CBPG15 <", value, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15LessThanOrEqualTo(Date value) {
            addCriterion("CBPG15 <=", value, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15In(List<Date> values) {
            addCriterion("CBPG15 in", values, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15NotIn(List<Date> values) {
            addCriterion("CBPG15 not in", values, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15Between(Date value1, Date value2) {
            addCriterion("CBPG15 between", value1, value2, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg15NotBetween(Date value1, Date value2) {
            addCriterion("CBPG15 not between", value1, value2, "cbpg15");
            return (Criteria) this;
        }

        public Criteria andCbpg16IsNull() {
            addCriterion("CBPG16 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg16IsNotNull() {
            addCriterion("CBPG16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg16EqualTo(Integer value) {
            addCriterion("CBPG16 =", value, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16NotEqualTo(Integer value) {
            addCriterion("CBPG16 <>", value, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16GreaterThan(Integer value) {
            addCriterion("CBPG16 >", value, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG16 >=", value, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16LessThan(Integer value) {
            addCriterion("CBPG16 <", value, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG16 <=", value, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16In(List<Integer> values) {
            addCriterion("CBPG16 in", values, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16NotIn(List<Integer> values) {
            addCriterion("CBPG16 not in", values, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16Between(Integer value1, Integer value2) {
            addCriterion("CBPG16 between", value1, value2, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG16 not between", value1, value2, "cbpg16");
            return (Criteria) this;
        }

        public Criteria andCbpg17IsNull() {
            addCriterion("CBPG17 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg17IsNotNull() {
            addCriterion("CBPG17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg17EqualTo(String value) {
            addCriterion("CBPG17 =", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17NotEqualTo(String value) {
            addCriterion("CBPG17 <>", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17GreaterThan(String value) {
            addCriterion("CBPG17 >", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17GreaterThanOrEqualTo(String value) {
            addCriterion("CBPG17 >=", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17LessThan(String value) {
            addCriterion("CBPG17 <", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17LessThanOrEqualTo(String value) {
            addCriterion("CBPG17 <=", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17Like(String value) {
            addCriterion("CBPG17 like", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17NotLike(String value) {
            addCriterion("CBPG17 not like", value, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17In(List<String> values) {
            addCriterion("CBPG17 in", values, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17NotIn(List<String> values) {
            addCriterion("CBPG17 not in", values, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17Between(String value1, String value2) {
            addCriterion("CBPG17 between", value1, value2, "cbpg17");
            return (Criteria) this;
        }

        public Criteria andCbpg17NotBetween(String value1, String value2) {
            addCriterion("CBPG17 not between", value1, value2, "cbpg17");
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
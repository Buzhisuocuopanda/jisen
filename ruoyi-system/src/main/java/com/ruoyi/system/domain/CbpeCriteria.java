package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpeCriteria() {
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

        public Criteria andCbpe01IsNull() {
            addCriterion("CBPE01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe01IsNotNull() {
            addCriterion("CBPE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe01EqualTo(Integer value) {
            addCriterion("CBPE01 =", value, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01NotEqualTo(Integer value) {
            addCriterion("CBPE01 <>", value, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01GreaterThan(Integer value) {
            addCriterion("CBPE01 >", value, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE01 >=", value, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01LessThan(Integer value) {
            addCriterion("CBPE01 <", value, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE01 <=", value, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01In(List<Integer> values) {
            addCriterion("CBPE01 in", values, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01NotIn(List<Integer> values) {
            addCriterion("CBPE01 not in", values, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01Between(Integer value1, Integer value2) {
            addCriterion("CBPE01 between", value1, value2, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE01 not between", value1, value2, "cbpe01");
            return (Criteria) this;
        }

        public Criteria andCbpe02IsNull() {
            addCriterion("CBPE02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe02IsNotNull() {
            addCriterion("CBPE02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe02EqualTo(Integer value) {
            addCriterion("CBPE02 =", value, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02NotEqualTo(Integer value) {
            addCriterion("CBPE02 <>", value, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02GreaterThan(Integer value) {
            addCriterion("CBPE02 >", value, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE02 >=", value, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02LessThan(Integer value) {
            addCriterion("CBPE02 <", value, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE02 <=", value, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02In(List<Integer> values) {
            addCriterion("CBPE02 in", values, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02NotIn(List<Integer> values) {
            addCriterion("CBPE02 not in", values, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02Between(Integer value1, Integer value2) {
            addCriterion("CBPE02 between", value1, value2, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE02 not between", value1, value2, "cbpe02");
            return (Criteria) this;
        }

        public Criteria andCbpe03IsNull() {
            addCriterion("CBPE03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe03IsNotNull() {
            addCriterion("CBPE03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe03EqualTo(Date value) {
            addCriterion("CBPE03 =", value, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03NotEqualTo(Date value) {
            addCriterion("CBPE03 <>", value, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03GreaterThan(Date value) {
            addCriterion("CBPE03 >", value, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPE03 >=", value, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03LessThan(Date value) {
            addCriterion("CBPE03 <", value, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03LessThanOrEqualTo(Date value) {
            addCriterion("CBPE03 <=", value, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03In(List<Date> values) {
            addCriterion("CBPE03 in", values, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03NotIn(List<Date> values) {
            addCriterion("CBPE03 not in", values, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03Between(Date value1, Date value2) {
            addCriterion("CBPE03 between", value1, value2, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe03NotBetween(Date value1, Date value2) {
            addCriterion("CBPE03 not between", value1, value2, "cbpe03");
            return (Criteria) this;
        }

        public Criteria andCbpe04IsNull() {
            addCriterion("CBPE04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe04IsNotNull() {
            addCriterion("CBPE04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe04EqualTo(Integer value) {
            addCriterion("CBPE04 =", value, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04NotEqualTo(Integer value) {
            addCriterion("CBPE04 <>", value, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04GreaterThan(Integer value) {
            addCriterion("CBPE04 >", value, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE04 >=", value, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04LessThan(Integer value) {
            addCriterion("CBPE04 <", value, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE04 <=", value, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04In(List<Integer> values) {
            addCriterion("CBPE04 in", values, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04NotIn(List<Integer> values) {
            addCriterion("CBPE04 not in", values, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04Between(Integer value1, Integer value2) {
            addCriterion("CBPE04 between", value1, value2, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE04 not between", value1, value2, "cbpe04");
            return (Criteria) this;
        }

        public Criteria andCbpe05IsNull() {
            addCriterion("CBPE05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe05IsNotNull() {
            addCriterion("CBPE05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe05EqualTo(Date value) {
            addCriterion("CBPE05 =", value, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05NotEqualTo(Date value) {
            addCriterion("CBPE05 <>", value, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05GreaterThan(Date value) {
            addCriterion("CBPE05 >", value, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPE05 >=", value, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05LessThan(Date value) {
            addCriterion("CBPE05 <", value, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05LessThanOrEqualTo(Date value) {
            addCriterion("CBPE05 <=", value, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05In(List<Date> values) {
            addCriterion("CBPE05 in", values, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05NotIn(List<Date> values) {
            addCriterion("CBPE05 not in", values, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05Between(Date value1, Date value2) {
            addCriterion("CBPE05 between", value1, value2, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe05NotBetween(Date value1, Date value2) {
            addCriterion("CBPE05 not between", value1, value2, "cbpe05");
            return (Criteria) this;
        }

        public Criteria andCbpe06IsNull() {
            addCriterion("CBPE06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe06IsNotNull() {
            addCriterion("CBPE06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe06EqualTo(Integer value) {
            addCriterion("CBPE06 =", value, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06NotEqualTo(Integer value) {
            addCriterion("CBPE06 <>", value, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06GreaterThan(Integer value) {
            addCriterion("CBPE06 >", value, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE06 >=", value, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06LessThan(Integer value) {
            addCriterion("CBPE06 <", value, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE06 <=", value, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06In(List<Integer> values) {
            addCriterion("CBPE06 in", values, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06NotIn(List<Integer> values) {
            addCriterion("CBPE06 not in", values, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06Between(Integer value1, Integer value2) {
            addCriterion("CBPE06 between", value1, value2, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE06 not between", value1, value2, "cbpe06");
            return (Criteria) this;
        }

        public Criteria andCbpe07IsNull() {
            addCriterion("CBPE07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe07IsNotNull() {
            addCriterion("CBPE07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe07EqualTo(Integer value) {
            addCriterion("CBPE07 =", value, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07NotEqualTo(Integer value) {
            addCriterion("CBPE07 <>", value, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07GreaterThan(Integer value) {
            addCriterion("CBPE07 >", value, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE07 >=", value, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07LessThan(Integer value) {
            addCriterion("CBPE07 <", value, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE07 <=", value, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07In(List<Integer> values) {
            addCriterion("CBPE07 in", values, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07NotIn(List<Integer> values) {
            addCriterion("CBPE07 not in", values, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07Between(Integer value1, Integer value2) {
            addCriterion("CBPE07 between", value1, value2, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE07 not between", value1, value2, "cbpe07");
            return (Criteria) this;
        }

        public Criteria andCbpe08IsNull() {
            addCriterion("CBPE08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe08IsNotNull() {
            addCriterion("CBPE08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe08EqualTo(Integer value) {
            addCriterion("CBPE08 =", value, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08NotEqualTo(Integer value) {
            addCriterion("CBPE08 <>", value, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08GreaterThan(Integer value) {
            addCriterion("CBPE08 >", value, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE08 >=", value, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08LessThan(Integer value) {
            addCriterion("CBPE08 <", value, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE08 <=", value, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08In(List<Integer> values) {
            addCriterion("CBPE08 in", values, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08NotIn(List<Integer> values) {
            addCriterion("CBPE08 not in", values, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08Between(Integer value1, Integer value2) {
            addCriterion("CBPE08 between", value1, value2, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE08 not between", value1, value2, "cbpe08");
            return (Criteria) this;
        }

        public Criteria andCbpe09IsNull() {
            addCriterion("CBPE09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe09IsNotNull() {
            addCriterion("CBPE09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe09EqualTo(String value) {
            addCriterion("CBPE09 =", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09NotEqualTo(String value) {
            addCriterion("CBPE09 <>", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09GreaterThan(String value) {
            addCriterion("CBPE09 >", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09GreaterThanOrEqualTo(String value) {
            addCriterion("CBPE09 >=", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09LessThan(String value) {
            addCriterion("CBPE09 <", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09LessThanOrEqualTo(String value) {
            addCriterion("CBPE09 <=", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09Like(String value) {
            addCriterion("CBPE09 like", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09NotLike(String value) {
            addCriterion("CBPE09 not like", value, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09In(List<String> values) {
            addCriterion("CBPE09 in", values, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09NotIn(List<String> values) {
            addCriterion("CBPE09 not in", values, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09Between(String value1, String value2) {
            addCriterion("CBPE09 between", value1, value2, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe09NotBetween(String value1, String value2) {
            addCriterion("CBPE09 not between", value1, value2, "cbpe09");
            return (Criteria) this;
        }

        public Criteria andCbpe10IsNull() {
            addCriterion("CBPE10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe10IsNotNull() {
            addCriterion("CBPE10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe10EqualTo(Integer value) {
            addCriterion("CBPE10 =", value, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10NotEqualTo(Integer value) {
            addCriterion("CBPE10 <>", value, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10GreaterThan(Integer value) {
            addCriterion("CBPE10 >", value, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE10 >=", value, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10LessThan(Integer value) {
            addCriterion("CBPE10 <", value, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE10 <=", value, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10In(List<Integer> values) {
            addCriterion("CBPE10 in", values, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10NotIn(List<Integer> values) {
            addCriterion("CBPE10 not in", values, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10Between(Integer value1, Integer value2) {
            addCriterion("CBPE10 between", value1, value2, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE10 not between", value1, value2, "cbpe10");
            return (Criteria) this;
        }

        public Criteria andCbpe11IsNull() {
            addCriterion("CBPE11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe11IsNotNull() {
            addCriterion("CBPE11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe11EqualTo(Integer value) {
            addCriterion("CBPE11 =", value, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11NotEqualTo(Integer value) {
            addCriterion("CBPE11 <>", value, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11GreaterThan(Integer value) {
            addCriterion("CBPE11 >", value, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPE11 >=", value, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11LessThan(Integer value) {
            addCriterion("CBPE11 <", value, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPE11 <=", value, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11In(List<Integer> values) {
            addCriterion("CBPE11 in", values, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11NotIn(List<Integer> values) {
            addCriterion("CBPE11 not in", values, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11Between(Integer value1, Integer value2) {
            addCriterion("CBPE11 between", value1, value2, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPE11 not between", value1, value2, "cbpe11");
            return (Criteria) this;
        }

        public Criteria andCbpe12IsNull() {
            addCriterion("CBPE12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpe12IsNotNull() {
            addCriterion("CBPE12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpe12EqualTo(String value) {
            addCriterion("CBPE12 =", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12NotEqualTo(String value) {
            addCriterion("CBPE12 <>", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12GreaterThan(String value) {
            addCriterion("CBPE12 >", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12GreaterThanOrEqualTo(String value) {
            addCriterion("CBPE12 >=", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12LessThan(String value) {
            addCriterion("CBPE12 <", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12LessThanOrEqualTo(String value) {
            addCriterion("CBPE12 <=", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12Like(String value) {
            addCriterion("CBPE12 like", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12NotLike(String value) {
            addCriterion("CBPE12 not like", value, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12In(List<String> values) {
            addCriterion("CBPE12 in", values, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12NotIn(List<String> values) {
            addCriterion("CBPE12 not in", values, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12Between(String value1, String value2) {
            addCriterion("CBPE12 between", value1, value2, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpe12NotBetween(String value1, String value2) {
            addCriterion("CBPE12 not between", value1, value2, "cbpe12");
            return (Criteria) this;
        }

        public Criteria andCbpc01IsNull() {
            addCriterion("CBPC01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc01IsNotNull() {
            addCriterion("CBPC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc01EqualTo(Integer value) {
            addCriterion("CBPC01 =", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01NotEqualTo(Integer value) {
            addCriterion("CBPC01 <>", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01GreaterThan(Integer value) {
            addCriterion("CBPC01 >", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC01 >=", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01LessThan(Integer value) {
            addCriterion("CBPC01 <", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC01 <=", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01In(List<Integer> values) {
            addCriterion("CBPC01 in", values, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01NotIn(List<Integer> values) {
            addCriterion("CBPC01 not in", values, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01Between(Integer value1, Integer value2) {
            addCriterion("CBPC01 between", value1, value2, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC01 not between", value1, value2, "cbpc01");
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
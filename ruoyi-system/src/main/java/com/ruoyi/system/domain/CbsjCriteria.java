package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsjCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsjCriteria() {
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

        public Criteria andCbsj01IsNull() {
            addCriterion("CBSJ01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj01IsNotNull() {
            addCriterion("CBSJ01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj01EqualTo(Integer value) {
            addCriterion("CBSJ01 =", value, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01NotEqualTo(Integer value) {
            addCriterion("CBSJ01 <>", value, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01GreaterThan(Integer value) {
            addCriterion("CBSJ01 >", value, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ01 >=", value, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01LessThan(Integer value) {
            addCriterion("CBSJ01 <", value, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ01 <=", value, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01In(List<Integer> values) {
            addCriterion("CBSJ01 in", values, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01NotIn(List<Integer> values) {
            addCriterion("CBSJ01 not in", values, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01Between(Integer value1, Integer value2) {
            addCriterion("CBSJ01 between", value1, value2, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ01 not between", value1, value2, "cbsj01");
            return (Criteria) this;
        }

        public Criteria andCbsj02IsNull() {
            addCriterion("CBSJ02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj02IsNotNull() {
            addCriterion("CBSJ02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj02EqualTo(Integer value) {
            addCriterion("CBSJ02 =", value, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02NotEqualTo(Integer value) {
            addCriterion("CBSJ02 <>", value, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02GreaterThan(Integer value) {
            addCriterion("CBSJ02 >", value, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ02 >=", value, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02LessThan(Integer value) {
            addCriterion("CBSJ02 <", value, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ02 <=", value, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02In(List<Integer> values) {
            addCriterion("CBSJ02 in", values, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02NotIn(List<Integer> values) {
            addCriterion("CBSJ02 not in", values, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02Between(Integer value1, Integer value2) {
            addCriterion("CBSJ02 between", value1, value2, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ02 not between", value1, value2, "cbsj02");
            return (Criteria) this;
        }

        public Criteria andCbsj03IsNull() {
            addCriterion("CBSJ03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj03IsNotNull() {
            addCriterion("CBSJ03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj03EqualTo(Date value) {
            addCriterion("CBSJ03 =", value, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03NotEqualTo(Date value) {
            addCriterion("CBSJ03 <>", value, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03GreaterThan(Date value) {
            addCriterion("CBSJ03 >", value, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSJ03 >=", value, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03LessThan(Date value) {
            addCriterion("CBSJ03 <", value, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03LessThanOrEqualTo(Date value) {
            addCriterion("CBSJ03 <=", value, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03In(List<Date> values) {
            addCriterion("CBSJ03 in", values, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03NotIn(List<Date> values) {
            addCriterion("CBSJ03 not in", values, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03Between(Date value1, Date value2) {
            addCriterion("CBSJ03 between", value1, value2, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj03NotBetween(Date value1, Date value2) {
            addCriterion("CBSJ03 not between", value1, value2, "cbsj03");
            return (Criteria) this;
        }

        public Criteria andCbsj04IsNull() {
            addCriterion("CBSJ04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj04IsNotNull() {
            addCriterion("CBSJ04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj04EqualTo(Integer value) {
            addCriterion("CBSJ04 =", value, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04NotEqualTo(Integer value) {
            addCriterion("CBSJ04 <>", value, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04GreaterThan(Integer value) {
            addCriterion("CBSJ04 >", value, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ04 >=", value, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04LessThan(Integer value) {
            addCriterion("CBSJ04 <", value, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ04 <=", value, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04In(List<Integer> values) {
            addCriterion("CBSJ04 in", values, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04NotIn(List<Integer> values) {
            addCriterion("CBSJ04 not in", values, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04Between(Integer value1, Integer value2) {
            addCriterion("CBSJ04 between", value1, value2, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ04 not between", value1, value2, "cbsj04");
            return (Criteria) this;
        }

        public Criteria andCbsj05IsNull() {
            addCriterion("CBSJ05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj05IsNotNull() {
            addCriterion("CBSJ05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj05EqualTo(Date value) {
            addCriterion("CBSJ05 =", value, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05NotEqualTo(Date value) {
            addCriterion("CBSJ05 <>", value, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05GreaterThan(Date value) {
            addCriterion("CBSJ05 >", value, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSJ05 >=", value, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05LessThan(Date value) {
            addCriterion("CBSJ05 <", value, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05LessThanOrEqualTo(Date value) {
            addCriterion("CBSJ05 <=", value, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05In(List<Date> values) {
            addCriterion("CBSJ05 in", values, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05NotIn(List<Date> values) {
            addCriterion("CBSJ05 not in", values, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05Between(Date value1, Date value2) {
            addCriterion("CBSJ05 between", value1, value2, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj05NotBetween(Date value1, Date value2) {
            addCriterion("CBSJ05 not between", value1, value2, "cbsj05");
            return (Criteria) this;
        }

        public Criteria andCbsj06IsNull() {
            addCriterion("CBSJ06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj06IsNotNull() {
            addCriterion("CBSJ06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj06EqualTo(Integer value) {
            addCriterion("CBSJ06 =", value, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06NotEqualTo(Integer value) {
            addCriterion("CBSJ06 <>", value, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06GreaterThan(Integer value) {
            addCriterion("CBSJ06 >", value, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ06 >=", value, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06LessThan(Integer value) {
            addCriterion("CBSJ06 <", value, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ06 <=", value, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06In(List<Integer> values) {
            addCriterion("CBSJ06 in", values, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06NotIn(List<Integer> values) {
            addCriterion("CBSJ06 not in", values, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06Between(Integer value1, Integer value2) {
            addCriterion("CBSJ06 between", value1, value2, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ06 not between", value1, value2, "cbsj06");
            return (Criteria) this;
        }

        public Criteria andCbsj07IsNull() {
            addCriterion("CBSJ07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj07IsNotNull() {
            addCriterion("CBSJ07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj07EqualTo(Integer value) {
            addCriterion("CBSJ07 =", value, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07NotEqualTo(Integer value) {
            addCriterion("CBSJ07 <>", value, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07GreaterThan(Integer value) {
            addCriterion("CBSJ07 >", value, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ07 >=", value, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07LessThan(Integer value) {
            addCriterion("CBSJ07 <", value, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ07 <=", value, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07In(List<Integer> values) {
            addCriterion("CBSJ07 in", values, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07NotIn(List<Integer> values) {
            addCriterion("CBSJ07 not in", values, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07Between(Integer value1, Integer value2) {
            addCriterion("CBSJ07 between", value1, value2, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ07 not between", value1, value2, "cbsj07");
            return (Criteria) this;
        }

        public Criteria andCbsj08IsNull() {
            addCriterion("CBSJ08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj08IsNotNull() {
            addCriterion("CBSJ08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj08EqualTo(Integer value) {
            addCriterion("CBSJ08 =", value, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08NotEqualTo(Integer value) {
            addCriterion("CBSJ08 <>", value, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08GreaterThan(Integer value) {
            addCriterion("CBSJ08 >", value, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ08 >=", value, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08LessThan(Integer value) {
            addCriterion("CBSJ08 <", value, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ08 <=", value, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08In(List<Integer> values) {
            addCriterion("CBSJ08 in", values, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08NotIn(List<Integer> values) {
            addCriterion("CBSJ08 not in", values, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08Between(Integer value1, Integer value2) {
            addCriterion("CBSJ08 between", value1, value2, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ08 not between", value1, value2, "cbsj08");
            return (Criteria) this;
        }

        public Criteria andCbsj09IsNull() {
            addCriterion("CBSJ09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj09IsNotNull() {
            addCriterion("CBSJ09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj09EqualTo(String value) {
            addCriterion("CBSJ09 =", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09NotEqualTo(String value) {
            addCriterion("CBSJ09 <>", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09GreaterThan(String value) {
            addCriterion("CBSJ09 >", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09GreaterThanOrEqualTo(String value) {
            addCriterion("CBSJ09 >=", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09LessThan(String value) {
            addCriterion("CBSJ09 <", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09LessThanOrEqualTo(String value) {
            addCriterion("CBSJ09 <=", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09Like(String value) {
            addCriterion("CBSJ09 like", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09NotLike(String value) {
            addCriterion("CBSJ09 not like", value, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09In(List<String> values) {
            addCriterion("CBSJ09 in", values, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09NotIn(List<String> values) {
            addCriterion("CBSJ09 not in", values, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09Between(String value1, String value2) {
            addCriterion("CBSJ09 between", value1, value2, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj09NotBetween(String value1, String value2) {
            addCriterion("CBSJ09 not between", value1, value2, "cbsj09");
            return (Criteria) this;
        }

        public Criteria andCbsj10IsNull() {
            addCriterion("CBSJ10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj10IsNotNull() {
            addCriterion("CBSJ10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj10EqualTo(Integer value) {
            addCriterion("CBSJ10 =", value, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10NotEqualTo(Integer value) {
            addCriterion("CBSJ10 <>", value, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10GreaterThan(Integer value) {
            addCriterion("CBSJ10 >", value, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ10 >=", value, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10LessThan(Integer value) {
            addCriterion("CBSJ10 <", value, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ10 <=", value, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10In(List<Integer> values) {
            addCriterion("CBSJ10 in", values, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10NotIn(List<Integer> values) {
            addCriterion("CBSJ10 not in", values, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10Between(Integer value1, Integer value2) {
            addCriterion("CBSJ10 between", value1, value2, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ10 not between", value1, value2, "cbsj10");
            return (Criteria) this;
        }

        public Criteria andCbsj11IsNull() {
            addCriterion("CBSJ11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj11IsNotNull() {
            addCriterion("CBSJ11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj11EqualTo(Integer value) {
            addCriterion("CBSJ11 =", value, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11NotEqualTo(Integer value) {
            addCriterion("CBSJ11 <>", value, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11GreaterThan(Integer value) {
            addCriterion("CBSJ11 >", value, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSJ11 >=", value, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11LessThan(Integer value) {
            addCriterion("CBSJ11 <", value, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11LessThanOrEqualTo(Integer value) {
            addCriterion("CBSJ11 <=", value, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11In(List<Integer> values) {
            addCriterion("CBSJ11 in", values, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11NotIn(List<Integer> values) {
            addCriterion("CBSJ11 not in", values, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11Between(Integer value1, Integer value2) {
            addCriterion("CBSJ11 between", value1, value2, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSJ11 not between", value1, value2, "cbsj11");
            return (Criteria) this;
        }

        public Criteria andCbsj12IsNull() {
            addCriterion("CBSJ12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsj12IsNotNull() {
            addCriterion("CBSJ12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsj12EqualTo(String value) {
            addCriterion("CBSJ12 =", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12NotEqualTo(String value) {
            addCriterion("CBSJ12 <>", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12GreaterThan(String value) {
            addCriterion("CBSJ12 >", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12GreaterThanOrEqualTo(String value) {
            addCriterion("CBSJ12 >=", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12LessThan(String value) {
            addCriterion("CBSJ12 <", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12LessThanOrEqualTo(String value) {
            addCriterion("CBSJ12 <=", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12Like(String value) {
            addCriterion("CBSJ12 like", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12NotLike(String value) {
            addCriterion("CBSJ12 not like", value, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12In(List<String> values) {
            addCriterion("CBSJ12 in", values, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12NotIn(List<String> values) {
            addCriterion("CBSJ12 not in", values, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12Between(String value1, String value2) {
            addCriterion("CBSJ12 between", value1, value2, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsj12NotBetween(String value1, String value2) {
            addCriterion("CBSJ12 not between", value1, value2, "cbsj12");
            return (Criteria) this;
        }

        public Criteria andCbsh01IsNull() {
            addCriterion("CBSH01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh01IsNotNull() {
            addCriterion("CBSH01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh01EqualTo(Integer value) {
            addCriterion("CBSH01 =", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01NotEqualTo(Integer value) {
            addCriterion("CBSH01 <>", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01GreaterThan(Integer value) {
            addCriterion("CBSH01 >", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH01 >=", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01LessThan(Integer value) {
            addCriterion("CBSH01 <", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH01 <=", value, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01In(List<Integer> values) {
            addCriterion("CBSH01 in", values, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01NotIn(List<Integer> values) {
            addCriterion("CBSH01 not in", values, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01Between(Integer value1, Integer value2) {
            addCriterion("CBSH01 between", value1, value2, "cbsh01");
            return (Criteria) this;
        }

        public Criteria andCbsh01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH01 not between", value1, value2, "cbsh01");
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
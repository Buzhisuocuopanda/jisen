package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CauaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CauaCriteria() {
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

        public Criteria andCaua01IsNull() {
            addCriterion("CAUA01 is null");
            return (Criteria) this;
        }

        public Criteria andCaua01IsNotNull() {
            addCriterion("CAUA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua01EqualTo(Integer value) {
            addCriterion("CAUA01 =", value, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01NotEqualTo(Integer value) {
            addCriterion("CAUA01 <>", value, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01GreaterThan(Integer value) {
            addCriterion("CAUA01 >", value, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA01 >=", value, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01LessThan(Integer value) {
            addCriterion("CAUA01 <", value, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA01 <=", value, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01In(List<Integer> values) {
            addCriterion("CAUA01 in", values, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01NotIn(List<Integer> values) {
            addCriterion("CAUA01 not in", values, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01Between(Integer value1, Integer value2) {
            addCriterion("CAUA01 between", value1, value2, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua01NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA01 not between", value1, value2, "caua01");
            return (Criteria) this;
        }

        public Criteria andCaua02IsNull() {
            addCriterion("CAUA02 is null");
            return (Criteria) this;
        }

        public Criteria andCaua02IsNotNull() {
            addCriterion("CAUA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua02EqualTo(Date value) {
            addCriterion("CAUA02 =", value, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02NotEqualTo(Date value) {
            addCriterion("CAUA02 <>", value, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02GreaterThan(Date value) {
            addCriterion("CAUA02 >", value, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02GreaterThanOrEqualTo(Date value) {
            addCriterion("CAUA02 >=", value, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02LessThan(Date value) {
            addCriterion("CAUA02 <", value, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02LessThanOrEqualTo(Date value) {
            addCriterion("CAUA02 <=", value, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02In(List<Date> values) {
            addCriterion("CAUA02 in", values, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02NotIn(List<Date> values) {
            addCriterion("CAUA02 not in", values, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02Between(Date value1, Date value2) {
            addCriterion("CAUA02 between", value1, value2, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua02NotBetween(Date value1, Date value2) {
            addCriterion("CAUA02 not between", value1, value2, "caua02");
            return (Criteria) this;
        }

        public Criteria andCaua03IsNull() {
            addCriterion("CAUA03 is null");
            return (Criteria) this;
        }

        public Criteria andCaua03IsNotNull() {
            addCriterion("CAUA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua03EqualTo(Date value) {
            addCriterion("CAUA03 =", value, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03NotEqualTo(Date value) {
            addCriterion("CAUA03 <>", value, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03GreaterThan(Date value) {
            addCriterion("CAUA03 >", value, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03GreaterThanOrEqualTo(Date value) {
            addCriterion("CAUA03 >=", value, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03LessThan(Date value) {
            addCriterion("CAUA03 <", value, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03LessThanOrEqualTo(Date value) {
            addCriterion("CAUA03 <=", value, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03In(List<Date> values) {
            addCriterion("CAUA03 in", values, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03NotIn(List<Date> values) {
            addCriterion("CAUA03 not in", values, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03Between(Date value1, Date value2) {
            addCriterion("CAUA03 between", value1, value2, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua03NotBetween(Date value1, Date value2) {
            addCriterion("CAUA03 not between", value1, value2, "caua03");
            return (Criteria) this;
        }

        public Criteria andCaua04IsNull() {
            addCriterion("CAUA04 is null");
            return (Criteria) this;
        }

        public Criteria andCaua04IsNotNull() {
            addCriterion("CAUA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua04EqualTo(Integer value) {
            addCriterion("CAUA04 =", value, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04NotEqualTo(Integer value) {
            addCriterion("CAUA04 <>", value, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04GreaterThan(Integer value) {
            addCriterion("CAUA04 >", value, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA04 >=", value, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04LessThan(Integer value) {
            addCriterion("CAUA04 <", value, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA04 <=", value, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04In(List<Integer> values) {
            addCriterion("CAUA04 in", values, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04NotIn(List<Integer> values) {
            addCriterion("CAUA04 not in", values, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04Between(Integer value1, Integer value2) {
            addCriterion("CAUA04 between", value1, value2, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua04NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA04 not between", value1, value2, "caua04");
            return (Criteria) this;
        }

        public Criteria andCaua05IsNull() {
            addCriterion("CAUA05 is null");
            return (Criteria) this;
        }

        public Criteria andCaua05IsNotNull() {
            addCriterion("CAUA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua05EqualTo(Integer value) {
            addCriterion("CAUA05 =", value, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05NotEqualTo(Integer value) {
            addCriterion("CAUA05 <>", value, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05GreaterThan(Integer value) {
            addCriterion("CAUA05 >", value, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA05 >=", value, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05LessThan(Integer value) {
            addCriterion("CAUA05 <", value, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA05 <=", value, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05In(List<Integer> values) {
            addCriterion("CAUA05 in", values, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05NotIn(List<Integer> values) {
            addCriterion("CAUA05 not in", values, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05Between(Integer value1, Integer value2) {
            addCriterion("CAUA05 between", value1, value2, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua05NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA05 not between", value1, value2, "caua05");
            return (Criteria) this;
        }

        public Criteria andCaua06IsNull() {
            addCriterion("CAUA06 is null");
            return (Criteria) this;
        }

        public Criteria andCaua06IsNotNull() {
            addCriterion("CAUA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua06EqualTo(Integer value) {
            addCriterion("CAUA06 =", value, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06NotEqualTo(Integer value) {
            addCriterion("CAUA06 <>", value, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06GreaterThan(Integer value) {
            addCriterion("CAUA06 >", value, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA06 >=", value, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06LessThan(Integer value) {
            addCriterion("CAUA06 <", value, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA06 <=", value, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06In(List<Integer> values) {
            addCriterion("CAUA06 in", values, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06NotIn(List<Integer> values) {
            addCriterion("CAUA06 not in", values, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06Between(Integer value1, Integer value2) {
            addCriterion("CAUA06 between", value1, value2, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua06NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA06 not between", value1, value2, "caua06");
            return (Criteria) this;
        }

        public Criteria andCaua07IsNull() {
            addCriterion("CAUA07 is null");
            return (Criteria) this;
        }

        public Criteria andCaua07IsNotNull() {
            addCriterion("CAUA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua07EqualTo(String value) {
            addCriterion("CAUA07 =", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07NotEqualTo(String value) {
            addCriterion("CAUA07 <>", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07GreaterThan(String value) {
            addCriterion("CAUA07 >", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA07 >=", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07LessThan(String value) {
            addCriterion("CAUA07 <", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07LessThanOrEqualTo(String value) {
            addCriterion("CAUA07 <=", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07Like(String value) {
            addCriterion("CAUA07 like", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07NotLike(String value) {
            addCriterion("CAUA07 not like", value, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07In(List<String> values) {
            addCriterion("CAUA07 in", values, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07NotIn(List<String> values) {
            addCriterion("CAUA07 not in", values, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07Between(String value1, String value2) {
            addCriterion("CAUA07 between", value1, value2, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua07NotBetween(String value1, String value2) {
            addCriterion("CAUA07 not between", value1, value2, "caua07");
            return (Criteria) this;
        }

        public Criteria andCaua08IsNull() {
            addCriterion("CAUA08 is null");
            return (Criteria) this;
        }

        public Criteria andCaua08IsNotNull() {
            addCriterion("CAUA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua08EqualTo(String value) {
            addCriterion("CAUA08 =", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08NotEqualTo(String value) {
            addCriterion("CAUA08 <>", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08GreaterThan(String value) {
            addCriterion("CAUA08 >", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA08 >=", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08LessThan(String value) {
            addCriterion("CAUA08 <", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08LessThanOrEqualTo(String value) {
            addCriterion("CAUA08 <=", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08Like(String value) {
            addCriterion("CAUA08 like", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08NotLike(String value) {
            addCriterion("CAUA08 not like", value, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08In(List<String> values) {
            addCriterion("CAUA08 in", values, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08NotIn(List<String> values) {
            addCriterion("CAUA08 not in", values, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08Between(String value1, String value2) {
            addCriterion("CAUA08 between", value1, value2, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua08NotBetween(String value1, String value2) {
            addCriterion("CAUA08 not between", value1, value2, "caua08");
            return (Criteria) this;
        }

        public Criteria andCaua09IsNull() {
            addCriterion("CAUA09 is null");
            return (Criteria) this;
        }

        public Criteria andCaua09IsNotNull() {
            addCriterion("CAUA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua09EqualTo(String value) {
            addCriterion("CAUA09 =", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09NotEqualTo(String value) {
            addCriterion("CAUA09 <>", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09GreaterThan(String value) {
            addCriterion("CAUA09 >", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA09 >=", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09LessThan(String value) {
            addCriterion("CAUA09 <", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09LessThanOrEqualTo(String value) {
            addCriterion("CAUA09 <=", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09Like(String value) {
            addCriterion("CAUA09 like", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09NotLike(String value) {
            addCriterion("CAUA09 not like", value, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09In(List<String> values) {
            addCriterion("CAUA09 in", values, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09NotIn(List<String> values) {
            addCriterion("CAUA09 not in", values, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09Between(String value1, String value2) {
            addCriterion("CAUA09 between", value1, value2, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua09NotBetween(String value1, String value2) {
            addCriterion("CAUA09 not between", value1, value2, "caua09");
            return (Criteria) this;
        }

        public Criteria andCaua10IsNull() {
            addCriterion("CAUA10 is null");
            return (Criteria) this;
        }

        public Criteria andCaua10IsNotNull() {
            addCriterion("CAUA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua10EqualTo(String value) {
            addCriterion("CAUA10 =", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10NotEqualTo(String value) {
            addCriterion("CAUA10 <>", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10GreaterThan(String value) {
            addCriterion("CAUA10 >", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA10 >=", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10LessThan(String value) {
            addCriterion("CAUA10 <", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10LessThanOrEqualTo(String value) {
            addCriterion("CAUA10 <=", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10Like(String value) {
            addCriterion("CAUA10 like", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10NotLike(String value) {
            addCriterion("CAUA10 not like", value, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10In(List<String> values) {
            addCriterion("CAUA10 in", values, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10NotIn(List<String> values) {
            addCriterion("CAUA10 not in", values, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10Between(String value1, String value2) {
            addCriterion("CAUA10 between", value1, value2, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua10NotBetween(String value1, String value2) {
            addCriterion("CAUA10 not between", value1, value2, "caua10");
            return (Criteria) this;
        }

        public Criteria andCaua11IsNull() {
            addCriterion("CAUA11 is null");
            return (Criteria) this;
        }

        public Criteria andCaua11IsNotNull() {
            addCriterion("CAUA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua11EqualTo(Integer value) {
            addCriterion("CAUA11 =", value, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11NotEqualTo(Integer value) {
            addCriterion("CAUA11 <>", value, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11GreaterThan(Integer value) {
            addCriterion("CAUA11 >", value, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA11 >=", value, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11LessThan(Integer value) {
            addCriterion("CAUA11 <", value, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA11 <=", value, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11In(List<Integer> values) {
            addCriterion("CAUA11 in", values, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11NotIn(List<Integer> values) {
            addCriterion("CAUA11 not in", values, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11Between(Integer value1, Integer value2) {
            addCriterion("CAUA11 between", value1, value2, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua11NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA11 not between", value1, value2, "caua11");
            return (Criteria) this;
        }

        public Criteria andCaua12IsNull() {
            addCriterion("CAUA12 is null");
            return (Criteria) this;
        }

        public Criteria andCaua12IsNotNull() {
            addCriterion("CAUA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua12EqualTo(String value) {
            addCriterion("CAUA12 =", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12NotEqualTo(String value) {
            addCriterion("CAUA12 <>", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12GreaterThan(String value) {
            addCriterion("CAUA12 >", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA12 >=", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12LessThan(String value) {
            addCriterion("CAUA12 <", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12LessThanOrEqualTo(String value) {
            addCriterion("CAUA12 <=", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12Like(String value) {
            addCriterion("CAUA12 like", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12NotLike(String value) {
            addCriterion("CAUA12 not like", value, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12In(List<String> values) {
            addCriterion("CAUA12 in", values, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12NotIn(List<String> values) {
            addCriterion("CAUA12 not in", values, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12Between(String value1, String value2) {
            addCriterion("CAUA12 between", value1, value2, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua12NotBetween(String value1, String value2) {
            addCriterion("CAUA12 not between", value1, value2, "caua12");
            return (Criteria) this;
        }

        public Criteria andCaua13IsNull() {
            addCriterion("CAUA13 is null");
            return (Criteria) this;
        }

        public Criteria andCaua13IsNotNull() {
            addCriterion("CAUA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua13EqualTo(String value) {
            addCriterion("CAUA13 =", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13NotEqualTo(String value) {
            addCriterion("CAUA13 <>", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13GreaterThan(String value) {
            addCriterion("CAUA13 >", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA13 >=", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13LessThan(String value) {
            addCriterion("CAUA13 <", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13LessThanOrEqualTo(String value) {
            addCriterion("CAUA13 <=", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13Like(String value) {
            addCriterion("CAUA13 like", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13NotLike(String value) {
            addCriterion("CAUA13 not like", value, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13In(List<String> values) {
            addCriterion("CAUA13 in", values, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13NotIn(List<String> values) {
            addCriterion("CAUA13 not in", values, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13Between(String value1, String value2) {
            addCriterion("CAUA13 between", value1, value2, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua13NotBetween(String value1, String value2) {
            addCriterion("CAUA13 not between", value1, value2, "caua13");
            return (Criteria) this;
        }

        public Criteria andCaua14IsNull() {
            addCriterion("CAUA14 is null");
            return (Criteria) this;
        }

        public Criteria andCaua14IsNotNull() {
            addCriterion("CAUA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua14EqualTo(String value) {
            addCriterion("CAUA14 =", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14NotEqualTo(String value) {
            addCriterion("CAUA14 <>", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14GreaterThan(String value) {
            addCriterion("CAUA14 >", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA14 >=", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14LessThan(String value) {
            addCriterion("CAUA14 <", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14LessThanOrEqualTo(String value) {
            addCriterion("CAUA14 <=", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14Like(String value) {
            addCriterion("CAUA14 like", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14NotLike(String value) {
            addCriterion("CAUA14 not like", value, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14In(List<String> values) {
            addCriterion("CAUA14 in", values, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14NotIn(List<String> values) {
            addCriterion("CAUA14 not in", values, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14Between(String value1, String value2) {
            addCriterion("CAUA14 between", value1, value2, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua14NotBetween(String value1, String value2) {
            addCriterion("CAUA14 not between", value1, value2, "caua14");
            return (Criteria) this;
        }

        public Criteria andCaua15IsNull() {
            addCriterion("CAUA15 is null");
            return (Criteria) this;
        }

        public Criteria andCaua15IsNotNull() {
            addCriterion("CAUA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua15EqualTo(String value) {
            addCriterion("CAUA15 =", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15NotEqualTo(String value) {
            addCriterion("CAUA15 <>", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15GreaterThan(String value) {
            addCriterion("CAUA15 >", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA15 >=", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15LessThan(String value) {
            addCriterion("CAUA15 <", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15LessThanOrEqualTo(String value) {
            addCriterion("CAUA15 <=", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15Like(String value) {
            addCriterion("CAUA15 like", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15NotLike(String value) {
            addCriterion("CAUA15 not like", value, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15In(List<String> values) {
            addCriterion("CAUA15 in", values, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15NotIn(List<String> values) {
            addCriterion("CAUA15 not in", values, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15Between(String value1, String value2) {
            addCriterion("CAUA15 between", value1, value2, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua15NotBetween(String value1, String value2) {
            addCriterion("CAUA15 not between", value1, value2, "caua15");
            return (Criteria) this;
        }

        public Criteria andCaua16IsNull() {
            addCriterion("CAUA16 is null");
            return (Criteria) this;
        }

        public Criteria andCaua16IsNotNull() {
            addCriterion("CAUA16 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua16EqualTo(String value) {
            addCriterion("CAUA16 =", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16NotEqualTo(String value) {
            addCriterion("CAUA16 <>", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16GreaterThan(String value) {
            addCriterion("CAUA16 >", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA16 >=", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16LessThan(String value) {
            addCriterion("CAUA16 <", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16LessThanOrEqualTo(String value) {
            addCriterion("CAUA16 <=", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16Like(String value) {
            addCriterion("CAUA16 like", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16NotLike(String value) {
            addCriterion("CAUA16 not like", value, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16In(List<String> values) {
            addCriterion("CAUA16 in", values, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16NotIn(List<String> values) {
            addCriterion("CAUA16 not in", values, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16Between(String value1, String value2) {
            addCriterion("CAUA16 between", value1, value2, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua16NotBetween(String value1, String value2) {
            addCriterion("CAUA16 not between", value1, value2, "caua16");
            return (Criteria) this;
        }

        public Criteria andCaua17IsNull() {
            addCriterion("CAUA17 is null");
            return (Criteria) this;
        }

        public Criteria andCaua17IsNotNull() {
            addCriterion("CAUA17 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua17EqualTo(String value) {
            addCriterion("CAUA17 =", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17NotEqualTo(String value) {
            addCriterion("CAUA17 <>", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17GreaterThan(String value) {
            addCriterion("CAUA17 >", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA17 >=", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17LessThan(String value) {
            addCriterion("CAUA17 <", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17LessThanOrEqualTo(String value) {
            addCriterion("CAUA17 <=", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17Like(String value) {
            addCriterion("CAUA17 like", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17NotLike(String value) {
            addCriterion("CAUA17 not like", value, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17In(List<String> values) {
            addCriterion("CAUA17 in", values, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17NotIn(List<String> values) {
            addCriterion("CAUA17 not in", values, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17Between(String value1, String value2) {
            addCriterion("CAUA17 between", value1, value2, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua17NotBetween(String value1, String value2) {
            addCriterion("CAUA17 not between", value1, value2, "caua17");
            return (Criteria) this;
        }

        public Criteria andCaua18IsNull() {
            addCriterion("CAUA18 is null");
            return (Criteria) this;
        }

        public Criteria andCaua18IsNotNull() {
            addCriterion("CAUA18 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua18EqualTo(Integer value) {
            addCriterion("CAUA18 =", value, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18NotEqualTo(Integer value) {
            addCriterion("CAUA18 <>", value, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18GreaterThan(Integer value) {
            addCriterion("CAUA18 >", value, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA18 >=", value, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18LessThan(Integer value) {
            addCriterion("CAUA18 <", value, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA18 <=", value, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18In(List<Integer> values) {
            addCriterion("CAUA18 in", values, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18NotIn(List<Integer> values) {
            addCriterion("CAUA18 not in", values, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18Between(Integer value1, Integer value2) {
            addCriterion("CAUA18 between", value1, value2, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua18NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA18 not between", value1, value2, "caua18");
            return (Criteria) this;
        }

        public Criteria andCaua19IsNull() {
            addCriterion("CAUA19 is null");
            return (Criteria) this;
        }

        public Criteria andCaua19IsNotNull() {
            addCriterion("CAUA19 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua19EqualTo(String value) {
            addCriterion("CAUA19 =", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19NotEqualTo(String value) {
            addCriterion("CAUA19 <>", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19GreaterThan(String value) {
            addCriterion("CAUA19 >", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA19 >=", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19LessThan(String value) {
            addCriterion("CAUA19 <", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19LessThanOrEqualTo(String value) {
            addCriterion("CAUA19 <=", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19Like(String value) {
            addCriterion("CAUA19 like", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19NotLike(String value) {
            addCriterion("CAUA19 not like", value, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19In(List<String> values) {
            addCriterion("CAUA19 in", values, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19NotIn(List<String> values) {
            addCriterion("CAUA19 not in", values, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19Between(String value1, String value2) {
            addCriterion("CAUA19 between", value1, value2, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua19NotBetween(String value1, String value2) {
            addCriterion("CAUA19 not between", value1, value2, "caua19");
            return (Criteria) this;
        }

        public Criteria andCaua20IsNull() {
            addCriterion("CAUA20 is null");
            return (Criteria) this;
        }

        public Criteria andCaua20IsNotNull() {
            addCriterion("CAUA20 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua20EqualTo(Integer value) {
            addCriterion("CAUA20 =", value, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20NotEqualTo(Integer value) {
            addCriterion("CAUA20 <>", value, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20GreaterThan(Integer value) {
            addCriterion("CAUA20 >", value, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20GreaterThanOrEqualTo(Integer value) {
            addCriterion("CAUA20 >=", value, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20LessThan(Integer value) {
            addCriterion("CAUA20 <", value, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20LessThanOrEqualTo(Integer value) {
            addCriterion("CAUA20 <=", value, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20In(List<Integer> values) {
            addCriterion("CAUA20 in", values, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20NotIn(List<Integer> values) {
            addCriterion("CAUA20 not in", values, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20Between(Integer value1, Integer value2) {
            addCriterion("CAUA20 between", value1, value2, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua20NotBetween(Integer value1, Integer value2) {
            addCriterion("CAUA20 not between", value1, value2, "caua20");
            return (Criteria) this;
        }

        public Criteria andCaua21IsNull() {
            addCriterion("CAUA21 is null");
            return (Criteria) this;
        }

        public Criteria andCaua21IsNotNull() {
            addCriterion("CAUA21 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua21EqualTo(String value) {
            addCriterion("CAUA21 =", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21NotEqualTo(String value) {
            addCriterion("CAUA21 <>", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21GreaterThan(String value) {
            addCriterion("CAUA21 >", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA21 >=", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21LessThan(String value) {
            addCriterion("CAUA21 <", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21LessThanOrEqualTo(String value) {
            addCriterion("CAUA21 <=", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21Like(String value) {
            addCriterion("CAUA21 like", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21NotLike(String value) {
            addCriterion("CAUA21 not like", value, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21In(List<String> values) {
            addCriterion("CAUA21 in", values, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21NotIn(List<String> values) {
            addCriterion("CAUA21 not in", values, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21Between(String value1, String value2) {
            addCriterion("CAUA21 between", value1, value2, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua21NotBetween(String value1, String value2) {
            addCriterion("CAUA21 not between", value1, value2, "caua21");
            return (Criteria) this;
        }

        public Criteria andCaua22IsNull() {
            addCriterion("CAUA22 is null");
            return (Criteria) this;
        }

        public Criteria andCaua22IsNotNull() {
            addCriterion("CAUA22 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua22EqualTo(String value) {
            addCriterion("CAUA22 =", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22NotEqualTo(String value) {
            addCriterion("CAUA22 <>", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22GreaterThan(String value) {
            addCriterion("CAUA22 >", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA22 >=", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22LessThan(String value) {
            addCriterion("CAUA22 <", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22LessThanOrEqualTo(String value) {
            addCriterion("CAUA22 <=", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22Like(String value) {
            addCriterion("CAUA22 like", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22NotLike(String value) {
            addCriterion("CAUA22 not like", value, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22In(List<String> values) {
            addCriterion("CAUA22 in", values, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22NotIn(List<String> values) {
            addCriterion("CAUA22 not in", values, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22Between(String value1, String value2) {
            addCriterion("CAUA22 between", value1, value2, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua22NotBetween(String value1, String value2) {
            addCriterion("CAUA22 not between", value1, value2, "caua22");
            return (Criteria) this;
        }

        public Criteria andCaua23IsNull() {
            addCriterion("CAUA23 is null");
            return (Criteria) this;
        }

        public Criteria andCaua23IsNotNull() {
            addCriterion("CAUA23 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua23EqualTo(String value) {
            addCriterion("CAUA23 =", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23NotEqualTo(String value) {
            addCriterion("CAUA23 <>", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23GreaterThan(String value) {
            addCriterion("CAUA23 >", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA23 >=", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23LessThan(String value) {
            addCriterion("CAUA23 <", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23LessThanOrEqualTo(String value) {
            addCriterion("CAUA23 <=", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23Like(String value) {
            addCriterion("CAUA23 like", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23NotLike(String value) {
            addCriterion("CAUA23 not like", value, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23In(List<String> values) {
            addCriterion("CAUA23 in", values, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23NotIn(List<String> values) {
            addCriterion("CAUA23 not in", values, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23Between(String value1, String value2) {
            addCriterion("CAUA23 between", value1, value2, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua23NotBetween(String value1, String value2) {
            addCriterion("CAUA23 not between", value1, value2, "caua23");
            return (Criteria) this;
        }

        public Criteria andCaua24IsNull() {
            addCriterion("CAUA24 is null");
            return (Criteria) this;
        }

        public Criteria andCaua24IsNotNull() {
            addCriterion("CAUA24 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua24EqualTo(String value) {
            addCriterion("CAUA24 =", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24NotEqualTo(String value) {
            addCriterion("CAUA24 <>", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24GreaterThan(String value) {
            addCriterion("CAUA24 >", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA24 >=", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24LessThan(String value) {
            addCriterion("CAUA24 <", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24LessThanOrEqualTo(String value) {
            addCriterion("CAUA24 <=", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24Like(String value) {
            addCriterion("CAUA24 like", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24NotLike(String value) {
            addCriterion("CAUA24 not like", value, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24In(List<String> values) {
            addCriterion("CAUA24 in", values, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24NotIn(List<String> values) {
            addCriterion("CAUA24 not in", values, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24Between(String value1, String value2) {
            addCriterion("CAUA24 between", value1, value2, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua24NotBetween(String value1, String value2) {
            addCriterion("CAUA24 not between", value1, value2, "caua24");
            return (Criteria) this;
        }

        public Criteria andCaua25IsNull() {
            addCriterion("CAUA25 is null");
            return (Criteria) this;
        }

        public Criteria andCaua25IsNotNull() {
            addCriterion("CAUA25 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua25EqualTo(String value) {
            addCriterion("CAUA25 =", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25NotEqualTo(String value) {
            addCriterion("CAUA25 <>", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25GreaterThan(String value) {
            addCriterion("CAUA25 >", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA25 >=", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25LessThan(String value) {
            addCriterion("CAUA25 <", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25LessThanOrEqualTo(String value) {
            addCriterion("CAUA25 <=", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25Like(String value) {
            addCriterion("CAUA25 like", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25NotLike(String value) {
            addCriterion("CAUA25 not like", value, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25In(List<String> values) {
            addCriterion("CAUA25 in", values, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25NotIn(List<String> values) {
            addCriterion("CAUA25 not in", values, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25Between(String value1, String value2) {
            addCriterion("CAUA25 between", value1, value2, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua25NotBetween(String value1, String value2) {
            addCriterion("CAUA25 not between", value1, value2, "caua25");
            return (Criteria) this;
        }

        public Criteria andCaua26IsNull() {
            addCriterion("CAUA26 is null");
            return (Criteria) this;
        }

        public Criteria andCaua26IsNotNull() {
            addCriterion("CAUA26 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua26EqualTo(String value) {
            addCriterion("CAUA26 =", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26NotEqualTo(String value) {
            addCriterion("CAUA26 <>", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26GreaterThan(String value) {
            addCriterion("CAUA26 >", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA26 >=", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26LessThan(String value) {
            addCriterion("CAUA26 <", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26LessThanOrEqualTo(String value) {
            addCriterion("CAUA26 <=", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26Like(String value) {
            addCriterion("CAUA26 like", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26NotLike(String value) {
            addCriterion("CAUA26 not like", value, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26In(List<String> values) {
            addCriterion("CAUA26 in", values, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26NotIn(List<String> values) {
            addCriterion("CAUA26 not in", values, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26Between(String value1, String value2) {
            addCriterion("CAUA26 between", value1, value2, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua26NotBetween(String value1, String value2) {
            addCriterion("CAUA26 not between", value1, value2, "caua26");
            return (Criteria) this;
        }

        public Criteria andCaua27IsNull() {
            addCriterion("CAUA27 is null");
            return (Criteria) this;
        }

        public Criteria andCaua27IsNotNull() {
            addCriterion("CAUA27 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua27EqualTo(String value) {
            addCriterion("CAUA27 =", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27NotEqualTo(String value) {
            addCriterion("CAUA27 <>", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27GreaterThan(String value) {
            addCriterion("CAUA27 >", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA27 >=", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27LessThan(String value) {
            addCriterion("CAUA27 <", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27LessThanOrEqualTo(String value) {
            addCriterion("CAUA27 <=", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27Like(String value) {
            addCriterion("CAUA27 like", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27NotLike(String value) {
            addCriterion("CAUA27 not like", value, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27In(List<String> values) {
            addCriterion("CAUA27 in", values, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27NotIn(List<String> values) {
            addCriterion("CAUA27 not in", values, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27Between(String value1, String value2) {
            addCriterion("CAUA27 between", value1, value2, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua27NotBetween(String value1, String value2) {
            addCriterion("CAUA27 not between", value1, value2, "caua27");
            return (Criteria) this;
        }

        public Criteria andCaua28IsNull() {
            addCriterion("CAUA28 is null");
            return (Criteria) this;
        }

        public Criteria andCaua28IsNotNull() {
            addCriterion("CAUA28 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua28EqualTo(String value) {
            addCriterion("CAUA28 =", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28NotEqualTo(String value) {
            addCriterion("CAUA28 <>", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28GreaterThan(String value) {
            addCriterion("CAUA28 >", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA28 >=", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28LessThan(String value) {
            addCriterion("CAUA28 <", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28LessThanOrEqualTo(String value) {
            addCriterion("CAUA28 <=", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28Like(String value) {
            addCriterion("CAUA28 like", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28NotLike(String value) {
            addCriterion("CAUA28 not like", value, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28In(List<String> values) {
            addCriterion("CAUA28 in", values, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28NotIn(List<String> values) {
            addCriterion("CAUA28 not in", values, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28Between(String value1, String value2) {
            addCriterion("CAUA28 between", value1, value2, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua28NotBetween(String value1, String value2) {
            addCriterion("CAUA28 not between", value1, value2, "caua28");
            return (Criteria) this;
        }

        public Criteria andCaua29IsNull() {
            addCriterion("CAUA29 is null");
            return (Criteria) this;
        }

        public Criteria andCaua29IsNotNull() {
            addCriterion("CAUA29 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua29EqualTo(String value) {
            addCriterion("CAUA29 =", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29NotEqualTo(String value) {
            addCriterion("CAUA29 <>", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29GreaterThan(String value) {
            addCriterion("CAUA29 >", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA29 >=", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29LessThan(String value) {
            addCriterion("CAUA29 <", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29LessThanOrEqualTo(String value) {
            addCriterion("CAUA29 <=", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29Like(String value) {
            addCriterion("CAUA29 like", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29NotLike(String value) {
            addCriterion("CAUA29 not like", value, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29In(List<String> values) {
            addCriterion("CAUA29 in", values, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29NotIn(List<String> values) {
            addCriterion("CAUA29 not in", values, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29Between(String value1, String value2) {
            addCriterion("CAUA29 between", value1, value2, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua29NotBetween(String value1, String value2) {
            addCriterion("CAUA29 not between", value1, value2, "caua29");
            return (Criteria) this;
        }

        public Criteria andCaua30IsNull() {
            addCriterion("CAUA30 is null");
            return (Criteria) this;
        }

        public Criteria andCaua30IsNotNull() {
            addCriterion("CAUA30 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua30EqualTo(String value) {
            addCriterion("CAUA30 =", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30NotEqualTo(String value) {
            addCriterion("CAUA30 <>", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30GreaterThan(String value) {
            addCriterion("CAUA30 >", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA30 >=", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30LessThan(String value) {
            addCriterion("CAUA30 <", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30LessThanOrEqualTo(String value) {
            addCriterion("CAUA30 <=", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30Like(String value) {
            addCriterion("CAUA30 like", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30NotLike(String value) {
            addCriterion("CAUA30 not like", value, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30In(List<String> values) {
            addCriterion("CAUA30 in", values, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30NotIn(List<String> values) {
            addCriterion("CAUA30 not in", values, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30Between(String value1, String value2) {
            addCriterion("CAUA30 between", value1, value2, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua30NotBetween(String value1, String value2) {
            addCriterion("CAUA30 not between", value1, value2, "caua30");
            return (Criteria) this;
        }

        public Criteria andCaua31IsNull() {
            addCriterion("CAUA31 is null");
            return (Criteria) this;
        }

        public Criteria andCaua31IsNotNull() {
            addCriterion("CAUA31 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua31EqualTo(String value) {
            addCriterion("CAUA31 =", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31NotEqualTo(String value) {
            addCriterion("CAUA31 <>", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31GreaterThan(String value) {
            addCriterion("CAUA31 >", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA31 >=", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31LessThan(String value) {
            addCriterion("CAUA31 <", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31LessThanOrEqualTo(String value) {
            addCriterion("CAUA31 <=", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31Like(String value) {
            addCriterion("CAUA31 like", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31NotLike(String value) {
            addCriterion("CAUA31 not like", value, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31In(List<String> values) {
            addCriterion("CAUA31 in", values, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31NotIn(List<String> values) {
            addCriterion("CAUA31 not in", values, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31Between(String value1, String value2) {
            addCriterion("CAUA31 between", value1, value2, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua31NotBetween(String value1, String value2) {
            addCriterion("CAUA31 not between", value1, value2, "caua31");
            return (Criteria) this;
        }

        public Criteria andCaua32IsNull() {
            addCriterion("CAUA32 is null");
            return (Criteria) this;
        }

        public Criteria andCaua32IsNotNull() {
            addCriterion("CAUA32 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua32EqualTo(String value) {
            addCriterion("CAUA32 =", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32NotEqualTo(String value) {
            addCriterion("CAUA32 <>", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32GreaterThan(String value) {
            addCriterion("CAUA32 >", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA32 >=", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32LessThan(String value) {
            addCriterion("CAUA32 <", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32LessThanOrEqualTo(String value) {
            addCriterion("CAUA32 <=", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32Like(String value) {
            addCriterion("CAUA32 like", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32NotLike(String value) {
            addCriterion("CAUA32 not like", value, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32In(List<String> values) {
            addCriterion("CAUA32 in", values, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32NotIn(List<String> values) {
            addCriterion("CAUA32 not in", values, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32Between(String value1, String value2) {
            addCriterion("CAUA32 between", value1, value2, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua32NotBetween(String value1, String value2) {
            addCriterion("CAUA32 not between", value1, value2, "caua32");
            return (Criteria) this;
        }

        public Criteria andCaua33IsNull() {
            addCriterion("CAUA33 is null");
            return (Criteria) this;
        }

        public Criteria andCaua33IsNotNull() {
            addCriterion("CAUA33 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua33EqualTo(String value) {
            addCriterion("CAUA33 =", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33NotEqualTo(String value) {
            addCriterion("CAUA33 <>", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33GreaterThan(String value) {
            addCriterion("CAUA33 >", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA33 >=", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33LessThan(String value) {
            addCriterion("CAUA33 <", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33LessThanOrEqualTo(String value) {
            addCriterion("CAUA33 <=", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33Like(String value) {
            addCriterion("CAUA33 like", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33NotLike(String value) {
            addCriterion("CAUA33 not like", value, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33In(List<String> values) {
            addCriterion("CAUA33 in", values, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33NotIn(List<String> values) {
            addCriterion("CAUA33 not in", values, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33Between(String value1, String value2) {
            addCriterion("CAUA33 between", value1, value2, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua33NotBetween(String value1, String value2) {
            addCriterion("CAUA33 not between", value1, value2, "caua33");
            return (Criteria) this;
        }

        public Criteria andCaua34IsNull() {
            addCriterion("CAUA34 is null");
            return (Criteria) this;
        }

        public Criteria andCaua34IsNotNull() {
            addCriterion("CAUA34 is not null");
            return (Criteria) this;
        }

        public Criteria andCaua34EqualTo(String value) {
            addCriterion("CAUA34 =", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34NotEqualTo(String value) {
            addCriterion("CAUA34 <>", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34GreaterThan(String value) {
            addCriterion("CAUA34 >", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34GreaterThanOrEqualTo(String value) {
            addCriterion("CAUA34 >=", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34LessThan(String value) {
            addCriterion("CAUA34 <", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34LessThanOrEqualTo(String value) {
            addCriterion("CAUA34 <=", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34Like(String value) {
            addCriterion("CAUA34 like", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34NotLike(String value) {
            addCriterion("CAUA34 not like", value, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34In(List<String> values) {
            addCriterion("CAUA34 in", values, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34NotIn(List<String> values) {
            addCriterion("CAUA34 not in", values, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34Between(String value1, String value2) {
            addCriterion("CAUA34 between", value1, value2, "caua34");
            return (Criteria) this;
        }

        public Criteria andCaua34NotBetween(String value1, String value2) {
            addCriterion("CAUA34 not between", value1, value2, "caua34");
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
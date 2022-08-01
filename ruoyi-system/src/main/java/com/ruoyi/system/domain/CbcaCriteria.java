package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbcaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbcaCriteria() {
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

        public Criteria andCbca01IsNull() {
            addCriterion("CBCA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbca01IsNotNull() {
            addCriterion("CBCA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca01EqualTo(Integer value) {
            addCriterion("CBCA01 =", value, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01NotEqualTo(Integer value) {
            addCriterion("CBCA01 <>", value, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01GreaterThan(Integer value) {
            addCriterion("CBCA01 >", value, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBCA01 >=", value, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01LessThan(Integer value) {
            addCriterion("CBCA01 <", value, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01LessThanOrEqualTo(Integer value) {
            addCriterion("CBCA01 <=", value, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01In(List<Integer> values) {
            addCriterion("CBCA01 in", values, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01NotIn(List<Integer> values) {
            addCriterion("CBCA01 not in", values, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01Between(Integer value1, Integer value2) {
            addCriterion("CBCA01 between", value1, value2, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBCA01 not between", value1, value2, "cbca01");
            return (Criteria) this;
        }

        public Criteria andCbca02IsNull() {
            addCriterion("CBCA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbca02IsNotNull() {
            addCriterion("CBCA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca02EqualTo(Date value) {
            addCriterion("CBCA02 =", value, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02NotEqualTo(Date value) {
            addCriterion("CBCA02 <>", value, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02GreaterThan(Date value) {
            addCriterion("CBCA02 >", value, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBCA02 >=", value, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02LessThan(Date value) {
            addCriterion("CBCA02 <", value, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02LessThanOrEqualTo(Date value) {
            addCriterion("CBCA02 <=", value, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02In(List<Date> values) {
            addCriterion("CBCA02 in", values, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02NotIn(List<Date> values) {
            addCriterion("CBCA02 not in", values, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02Between(Date value1, Date value2) {
            addCriterion("CBCA02 between", value1, value2, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca02NotBetween(Date value1, Date value2) {
            addCriterion("CBCA02 not between", value1, value2, "cbca02");
            return (Criteria) this;
        }

        public Criteria andCbca03IsNull() {
            addCriterion("CBCA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbca03IsNotNull() {
            addCriterion("CBCA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca03EqualTo(Integer value) {
            addCriterion("CBCA03 =", value, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03NotEqualTo(Integer value) {
            addCriterion("CBCA03 <>", value, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03GreaterThan(Integer value) {
            addCriterion("CBCA03 >", value, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBCA03 >=", value, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03LessThan(Integer value) {
            addCriterion("CBCA03 <", value, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03LessThanOrEqualTo(Integer value) {
            addCriterion("CBCA03 <=", value, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03In(List<Integer> values) {
            addCriterion("CBCA03 in", values, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03NotIn(List<Integer> values) {
            addCriterion("CBCA03 not in", values, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03Between(Integer value1, Integer value2) {
            addCriterion("CBCA03 between", value1, value2, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBCA03 not between", value1, value2, "cbca03");
            return (Criteria) this;
        }

        public Criteria andCbca04IsNull() {
            addCriterion("CBCA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbca04IsNotNull() {
            addCriterion("CBCA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca04EqualTo(Date value) {
            addCriterion("CBCA04 =", value, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04NotEqualTo(Date value) {
            addCriterion("CBCA04 <>", value, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04GreaterThan(Date value) {
            addCriterion("CBCA04 >", value, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBCA04 >=", value, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04LessThan(Date value) {
            addCriterion("CBCA04 <", value, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04LessThanOrEqualTo(Date value) {
            addCriterion("CBCA04 <=", value, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04In(List<Date> values) {
            addCriterion("CBCA04 in", values, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04NotIn(List<Date> values) {
            addCriterion("CBCA04 not in", values, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04Between(Date value1, Date value2) {
            addCriterion("CBCA04 between", value1, value2, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca04NotBetween(Date value1, Date value2) {
            addCriterion("CBCA04 not between", value1, value2, "cbca04");
            return (Criteria) this;
        }

        public Criteria andCbca05IsNull() {
            addCriterion("CBCA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbca05IsNotNull() {
            addCriterion("CBCA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca05EqualTo(Integer value) {
            addCriterion("CBCA05 =", value, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05NotEqualTo(Integer value) {
            addCriterion("CBCA05 <>", value, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05GreaterThan(Integer value) {
            addCriterion("CBCA05 >", value, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBCA05 >=", value, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05LessThan(Integer value) {
            addCriterion("CBCA05 <", value, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05LessThanOrEqualTo(Integer value) {
            addCriterion("CBCA05 <=", value, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05In(List<Integer> values) {
            addCriterion("CBCA05 in", values, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05NotIn(List<Integer> values) {
            addCriterion("CBCA05 not in", values, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05Between(Integer value1, Integer value2) {
            addCriterion("CBCA05 between", value1, value2, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBCA05 not between", value1, value2, "cbca05");
            return (Criteria) this;
        }

        public Criteria andCbca06IsNull() {
            addCriterion("CBCA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbca06IsNotNull() {
            addCriterion("CBCA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca06EqualTo(Integer value) {
            addCriterion("CBCA06 =", value, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06NotEqualTo(Integer value) {
            addCriterion("CBCA06 <>", value, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06GreaterThan(Integer value) {
            addCriterion("CBCA06 >", value, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBCA06 >=", value, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06LessThan(Integer value) {
            addCriterion("CBCA06 <", value, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06LessThanOrEqualTo(Integer value) {
            addCriterion("CBCA06 <=", value, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06In(List<Integer> values) {
            addCriterion("CBCA06 in", values, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06NotIn(List<Integer> values) {
            addCriterion("CBCA06 not in", values, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06Between(Integer value1, Integer value2) {
            addCriterion("CBCA06 between", value1, value2, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBCA06 not between", value1, value2, "cbca06");
            return (Criteria) this;
        }

        public Criteria andCbca07IsNull() {
            addCriterion("CBCA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbca07IsNotNull() {
            addCriterion("CBCA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca07EqualTo(String value) {
            addCriterion("CBCA07 =", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07NotEqualTo(String value) {
            addCriterion("CBCA07 <>", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07GreaterThan(String value) {
            addCriterion("CBCA07 >", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA07 >=", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07LessThan(String value) {
            addCriterion("CBCA07 <", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07LessThanOrEqualTo(String value) {
            addCriterion("CBCA07 <=", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07Like(String value) {
            addCriterion("CBCA07 like", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07NotLike(String value) {
            addCriterion("CBCA07 not like", value, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07In(List<String> values) {
            addCriterion("CBCA07 in", values, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07NotIn(List<String> values) {
            addCriterion("CBCA07 not in", values, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07Between(String value1, String value2) {
            addCriterion("CBCA07 between", value1, value2, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca07NotBetween(String value1, String value2) {
            addCriterion("CBCA07 not between", value1, value2, "cbca07");
            return (Criteria) this;
        }

        public Criteria andCbca08IsNull() {
            addCriterion("CBCA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbca08IsNotNull() {
            addCriterion("CBCA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca08EqualTo(String value) {
            addCriterion("CBCA08 =", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08NotEqualTo(String value) {
            addCriterion("CBCA08 <>", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08GreaterThan(String value) {
            addCriterion("CBCA08 >", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA08 >=", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08LessThan(String value) {
            addCriterion("CBCA08 <", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08LessThanOrEqualTo(String value) {
            addCriterion("CBCA08 <=", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08Like(String value) {
            addCriterion("CBCA08 like", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08NotLike(String value) {
            addCriterion("CBCA08 not like", value, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08In(List<String> values) {
            addCriterion("CBCA08 in", values, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08NotIn(List<String> values) {
            addCriterion("CBCA08 not in", values, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08Between(String value1, String value2) {
            addCriterion("CBCA08 between", value1, value2, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca08NotBetween(String value1, String value2) {
            addCriterion("CBCA08 not between", value1, value2, "cbca08");
            return (Criteria) this;
        }

        public Criteria andCbca09IsNull() {
            addCriterion("CBCA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbca09IsNotNull() {
            addCriterion("CBCA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca09EqualTo(String value) {
            addCriterion("CBCA09 =", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09NotEqualTo(String value) {
            addCriterion("CBCA09 <>", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09GreaterThan(String value) {
            addCriterion("CBCA09 >", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA09 >=", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09LessThan(String value) {
            addCriterion("CBCA09 <", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09LessThanOrEqualTo(String value) {
            addCriterion("CBCA09 <=", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09Like(String value) {
            addCriterion("CBCA09 like", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09NotLike(String value) {
            addCriterion("CBCA09 not like", value, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09In(List<String> values) {
            addCriterion("CBCA09 in", values, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09NotIn(List<String> values) {
            addCriterion("CBCA09 not in", values, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09Between(String value1, String value2) {
            addCriterion("CBCA09 between", value1, value2, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca09NotBetween(String value1, String value2) {
            addCriterion("CBCA09 not between", value1, value2, "cbca09");
            return (Criteria) this;
        }

        public Criteria andCbca10IsNull() {
            addCriterion("CBCA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbca10IsNotNull() {
            addCriterion("CBCA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca10EqualTo(String value) {
            addCriterion("CBCA10 =", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10NotEqualTo(String value) {
            addCriterion("CBCA10 <>", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10GreaterThan(String value) {
            addCriterion("CBCA10 >", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA10 >=", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10LessThan(String value) {
            addCriterion("CBCA10 <", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10LessThanOrEqualTo(String value) {
            addCriterion("CBCA10 <=", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10Like(String value) {
            addCriterion("CBCA10 like", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10NotLike(String value) {
            addCriterion("CBCA10 not like", value, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10In(List<String> values) {
            addCriterion("CBCA10 in", values, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10NotIn(List<String> values) {
            addCriterion("CBCA10 not in", values, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10Between(String value1, String value2) {
            addCriterion("CBCA10 between", value1, value2, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca10NotBetween(String value1, String value2) {
            addCriterion("CBCA10 not between", value1, value2, "cbca10");
            return (Criteria) this;
        }

        public Criteria andCbca11IsNull() {
            addCriterion("CBCA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbca11IsNotNull() {
            addCriterion("CBCA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca11EqualTo(String value) {
            addCriterion("CBCA11 =", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11NotEqualTo(String value) {
            addCriterion("CBCA11 <>", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11GreaterThan(String value) {
            addCriterion("CBCA11 >", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA11 >=", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11LessThan(String value) {
            addCriterion("CBCA11 <", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11LessThanOrEqualTo(String value) {
            addCriterion("CBCA11 <=", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11Like(String value) {
            addCriterion("CBCA11 like", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11NotLike(String value) {
            addCriterion("CBCA11 not like", value, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11In(List<String> values) {
            addCriterion("CBCA11 in", values, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11NotIn(List<String> values) {
            addCriterion("CBCA11 not in", values, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11Between(String value1, String value2) {
            addCriterion("CBCA11 between", value1, value2, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca11NotBetween(String value1, String value2) {
            addCriterion("CBCA11 not between", value1, value2, "cbca11");
            return (Criteria) this;
        }

        public Criteria andCbca12IsNull() {
            addCriterion("CBCA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbca12IsNotNull() {
            addCriterion("CBCA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca12EqualTo(String value) {
            addCriterion("CBCA12 =", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12NotEqualTo(String value) {
            addCriterion("CBCA12 <>", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12GreaterThan(String value) {
            addCriterion("CBCA12 >", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA12 >=", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12LessThan(String value) {
            addCriterion("CBCA12 <", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12LessThanOrEqualTo(String value) {
            addCriterion("CBCA12 <=", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12Like(String value) {
            addCriterion("CBCA12 like", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12NotLike(String value) {
            addCriterion("CBCA12 not like", value, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12In(List<String> values) {
            addCriterion("CBCA12 in", values, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12NotIn(List<String> values) {
            addCriterion("CBCA12 not in", values, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12Between(String value1, String value2) {
            addCriterion("CBCA12 between", value1, value2, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca12NotBetween(String value1, String value2) {
            addCriterion("CBCA12 not between", value1, value2, "cbca12");
            return (Criteria) this;
        }

        public Criteria andCbca13IsNull() {
            addCriterion("CBCA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbca13IsNotNull() {
            addCriterion("CBCA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca13EqualTo(String value) {
            addCriterion("CBCA13 =", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13NotEqualTo(String value) {
            addCriterion("CBCA13 <>", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13GreaterThan(String value) {
            addCriterion("CBCA13 >", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA13 >=", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13LessThan(String value) {
            addCriterion("CBCA13 <", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13LessThanOrEqualTo(String value) {
            addCriterion("CBCA13 <=", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13Like(String value) {
            addCriterion("CBCA13 like", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13NotLike(String value) {
            addCriterion("CBCA13 not like", value, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13In(List<String> values) {
            addCriterion("CBCA13 in", values, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13NotIn(List<String> values) {
            addCriterion("CBCA13 not in", values, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13Between(String value1, String value2) {
            addCriterion("CBCA13 between", value1, value2, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca13NotBetween(String value1, String value2) {
            addCriterion("CBCA13 not between", value1, value2, "cbca13");
            return (Criteria) this;
        }

        public Criteria andCbca14IsNull() {
            addCriterion("CBCA14 is null");
            return (Criteria) this;
        }

        public Criteria andCbca14IsNotNull() {
            addCriterion("CBCA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca14EqualTo(String value) {
            addCriterion("CBCA14 =", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14NotEqualTo(String value) {
            addCriterion("CBCA14 <>", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14GreaterThan(String value) {
            addCriterion("CBCA14 >", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA14 >=", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14LessThan(String value) {
            addCriterion("CBCA14 <", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14LessThanOrEqualTo(String value) {
            addCriterion("CBCA14 <=", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14Like(String value) {
            addCriterion("CBCA14 like", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14NotLike(String value) {
            addCriterion("CBCA14 not like", value, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14In(List<String> values) {
            addCriterion("CBCA14 in", values, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14NotIn(List<String> values) {
            addCriterion("CBCA14 not in", values, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14Between(String value1, String value2) {
            addCriterion("CBCA14 between", value1, value2, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca14NotBetween(String value1, String value2) {
            addCriterion("CBCA14 not between", value1, value2, "cbca14");
            return (Criteria) this;
        }

        public Criteria andCbca15IsNull() {
            addCriterion("CBCA15 is null");
            return (Criteria) this;
        }

        public Criteria andCbca15IsNotNull() {
            addCriterion("CBCA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca15EqualTo(String value) {
            addCriterion("CBCA15 =", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15NotEqualTo(String value) {
            addCriterion("CBCA15 <>", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15GreaterThan(String value) {
            addCriterion("CBCA15 >", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA15 >=", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15LessThan(String value) {
            addCriterion("CBCA15 <", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15LessThanOrEqualTo(String value) {
            addCriterion("CBCA15 <=", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15Like(String value) {
            addCriterion("CBCA15 like", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15NotLike(String value) {
            addCriterion("CBCA15 not like", value, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15In(List<String> values) {
            addCriterion("CBCA15 in", values, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15NotIn(List<String> values) {
            addCriterion("CBCA15 not in", values, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15Between(String value1, String value2) {
            addCriterion("CBCA15 between", value1, value2, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca15NotBetween(String value1, String value2) {
            addCriterion("CBCA15 not between", value1, value2, "cbca15");
            return (Criteria) this;
        }

        public Criteria andCbca16IsNull() {
            addCriterion("CBCA16 is null");
            return (Criteria) this;
        }

        public Criteria andCbca16IsNotNull() {
            addCriterion("CBCA16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca16EqualTo(String value) {
            addCriterion("CBCA16 =", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16NotEqualTo(String value) {
            addCriterion("CBCA16 <>", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16GreaterThan(String value) {
            addCriterion("CBCA16 >", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA16 >=", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16LessThan(String value) {
            addCriterion("CBCA16 <", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16LessThanOrEqualTo(String value) {
            addCriterion("CBCA16 <=", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16Like(String value) {
            addCriterion("CBCA16 like", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16NotLike(String value) {
            addCriterion("CBCA16 not like", value, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16In(List<String> values) {
            addCriterion("CBCA16 in", values, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16NotIn(List<String> values) {
            addCriterion("CBCA16 not in", values, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16Between(String value1, String value2) {
            addCriterion("CBCA16 between", value1, value2, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca16NotBetween(String value1, String value2) {
            addCriterion("CBCA16 not between", value1, value2, "cbca16");
            return (Criteria) this;
        }

        public Criteria andCbca17IsNull() {
            addCriterion("CBCA17 is null");
            return (Criteria) this;
        }

        public Criteria andCbca17IsNotNull() {
            addCriterion("CBCA17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca17EqualTo(String value) {
            addCriterion("CBCA17 =", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17NotEqualTo(String value) {
            addCriterion("CBCA17 <>", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17GreaterThan(String value) {
            addCriterion("CBCA17 >", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA17 >=", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17LessThan(String value) {
            addCriterion("CBCA17 <", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17LessThanOrEqualTo(String value) {
            addCriterion("CBCA17 <=", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17Like(String value) {
            addCriterion("CBCA17 like", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17NotLike(String value) {
            addCriterion("CBCA17 not like", value, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17In(List<String> values) {
            addCriterion("CBCA17 in", values, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17NotIn(List<String> values) {
            addCriterion("CBCA17 not in", values, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17Between(String value1, String value2) {
            addCriterion("CBCA17 between", value1, value2, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca17NotBetween(String value1, String value2) {
            addCriterion("CBCA17 not between", value1, value2, "cbca17");
            return (Criteria) this;
        }

        public Criteria andCbca18IsNull() {
            addCriterion("CBCA18 is null");
            return (Criteria) this;
        }

        public Criteria andCbca18IsNotNull() {
            addCriterion("CBCA18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca18EqualTo(String value) {
            addCriterion("CBCA18 =", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18NotEqualTo(String value) {
            addCriterion("CBCA18 <>", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18GreaterThan(String value) {
            addCriterion("CBCA18 >", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA18 >=", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18LessThan(String value) {
            addCriterion("CBCA18 <", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18LessThanOrEqualTo(String value) {
            addCriterion("CBCA18 <=", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18Like(String value) {
            addCriterion("CBCA18 like", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18NotLike(String value) {
            addCriterion("CBCA18 not like", value, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18In(List<String> values) {
            addCriterion("CBCA18 in", values, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18NotIn(List<String> values) {
            addCriterion("CBCA18 not in", values, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18Between(String value1, String value2) {
            addCriterion("CBCA18 between", value1, value2, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca18NotBetween(String value1, String value2) {
            addCriterion("CBCA18 not between", value1, value2, "cbca18");
            return (Criteria) this;
        }

        public Criteria andCbca19IsNull() {
            addCriterion("CBCA19 is null");
            return (Criteria) this;
        }

        public Criteria andCbca19IsNotNull() {
            addCriterion("CBCA19 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca19EqualTo(String value) {
            addCriterion("CBCA19 =", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19NotEqualTo(String value) {
            addCriterion("CBCA19 <>", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19GreaterThan(String value) {
            addCriterion("CBCA19 >", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA19 >=", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19LessThan(String value) {
            addCriterion("CBCA19 <", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19LessThanOrEqualTo(String value) {
            addCriterion("CBCA19 <=", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19Like(String value) {
            addCriterion("CBCA19 like", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19NotLike(String value) {
            addCriterion("CBCA19 not like", value, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19In(List<String> values) {
            addCriterion("CBCA19 in", values, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19NotIn(List<String> values) {
            addCriterion("CBCA19 not in", values, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19Between(String value1, String value2) {
            addCriterion("CBCA19 between", value1, value2, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca19NotBetween(String value1, String value2) {
            addCriterion("CBCA19 not between", value1, value2, "cbca19");
            return (Criteria) this;
        }

        public Criteria andCbca20IsNull() {
            addCriterion("CBCA20 is null");
            return (Criteria) this;
        }

        public Criteria andCbca20IsNotNull() {
            addCriterion("CBCA20 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca20EqualTo(String value) {
            addCriterion("CBCA20 =", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20NotEqualTo(String value) {
            addCriterion("CBCA20 <>", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20GreaterThan(String value) {
            addCriterion("CBCA20 >", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA20 >=", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20LessThan(String value) {
            addCriterion("CBCA20 <", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20LessThanOrEqualTo(String value) {
            addCriterion("CBCA20 <=", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20Like(String value) {
            addCriterion("CBCA20 like", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20NotLike(String value) {
            addCriterion("CBCA20 not like", value, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20In(List<String> values) {
            addCriterion("CBCA20 in", values, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20NotIn(List<String> values) {
            addCriterion("CBCA20 not in", values, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20Between(String value1, String value2) {
            addCriterion("CBCA20 between", value1, value2, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca20NotBetween(String value1, String value2) {
            addCriterion("CBCA20 not between", value1, value2, "cbca20");
            return (Criteria) this;
        }

        public Criteria andCbca21IsNull() {
            addCriterion("CBCA21 is null");
            return (Criteria) this;
        }

        public Criteria andCbca21IsNotNull() {
            addCriterion("CBCA21 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca21EqualTo(String value) {
            addCriterion("CBCA21 =", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21NotEqualTo(String value) {
            addCriterion("CBCA21 <>", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21GreaterThan(String value) {
            addCriterion("CBCA21 >", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA21 >=", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21LessThan(String value) {
            addCriterion("CBCA21 <", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21LessThanOrEqualTo(String value) {
            addCriterion("CBCA21 <=", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21Like(String value) {
            addCriterion("CBCA21 like", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21NotLike(String value) {
            addCriterion("CBCA21 not like", value, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21In(List<String> values) {
            addCriterion("CBCA21 in", values, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21NotIn(List<String> values) {
            addCriterion("CBCA21 not in", values, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21Between(String value1, String value2) {
            addCriterion("CBCA21 between", value1, value2, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca21NotBetween(String value1, String value2) {
            addCriterion("CBCA21 not between", value1, value2, "cbca21");
            return (Criteria) this;
        }

        public Criteria andCbca22IsNull() {
            addCriterion("CBCA22 is null");
            return (Criteria) this;
        }

        public Criteria andCbca22IsNotNull() {
            addCriterion("CBCA22 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca22EqualTo(String value) {
            addCriterion("CBCA22 =", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22NotEqualTo(String value) {
            addCriterion("CBCA22 <>", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22GreaterThan(String value) {
            addCriterion("CBCA22 >", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA22 >=", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22LessThan(String value) {
            addCriterion("CBCA22 <", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22LessThanOrEqualTo(String value) {
            addCriterion("CBCA22 <=", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22Like(String value) {
            addCriterion("CBCA22 like", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22NotLike(String value) {
            addCriterion("CBCA22 not like", value, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22In(List<String> values) {
            addCriterion("CBCA22 in", values, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22NotIn(List<String> values) {
            addCriterion("CBCA22 not in", values, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22Between(String value1, String value2) {
            addCriterion("CBCA22 between", value1, value2, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca22NotBetween(String value1, String value2) {
            addCriterion("CBCA22 not between", value1, value2, "cbca22");
            return (Criteria) this;
        }

        public Criteria andCbca23IsNull() {
            addCriterion("CBCA23 is null");
            return (Criteria) this;
        }

        public Criteria andCbca23IsNotNull() {
            addCriterion("CBCA23 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca23EqualTo(String value) {
            addCriterion("CBCA23 =", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23NotEqualTo(String value) {
            addCriterion("CBCA23 <>", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23GreaterThan(String value) {
            addCriterion("CBCA23 >", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA23 >=", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23LessThan(String value) {
            addCriterion("CBCA23 <", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23LessThanOrEqualTo(String value) {
            addCriterion("CBCA23 <=", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23Like(String value) {
            addCriterion("CBCA23 like", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23NotLike(String value) {
            addCriterion("CBCA23 not like", value, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23In(List<String> values) {
            addCriterion("CBCA23 in", values, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23NotIn(List<String> values) {
            addCriterion("CBCA23 not in", values, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23Between(String value1, String value2) {
            addCriterion("CBCA23 between", value1, value2, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca23NotBetween(String value1, String value2) {
            addCriterion("CBCA23 not between", value1, value2, "cbca23");
            return (Criteria) this;
        }

        public Criteria andCbca24IsNull() {
            addCriterion("CBCA24 is null");
            return (Criteria) this;
        }

        public Criteria andCbca24IsNotNull() {
            addCriterion("CBCA24 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca24EqualTo(String value) {
            addCriterion("CBCA24 =", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24NotEqualTo(String value) {
            addCriterion("CBCA24 <>", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24GreaterThan(String value) {
            addCriterion("CBCA24 >", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA24 >=", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24LessThan(String value) {
            addCriterion("CBCA24 <", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24LessThanOrEqualTo(String value) {
            addCriterion("CBCA24 <=", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24Like(String value) {
            addCriterion("CBCA24 like", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24NotLike(String value) {
            addCriterion("CBCA24 not like", value, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24In(List<String> values) {
            addCriterion("CBCA24 in", values, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24NotIn(List<String> values) {
            addCriterion("CBCA24 not in", values, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24Between(String value1, String value2) {
            addCriterion("CBCA24 between", value1, value2, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca24NotBetween(String value1, String value2) {
            addCriterion("CBCA24 not between", value1, value2, "cbca24");
            return (Criteria) this;
        }

        public Criteria andCbca25IsNull() {
            addCriterion("CBCA25 is null");
            return (Criteria) this;
        }

        public Criteria andCbca25IsNotNull() {
            addCriterion("CBCA25 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca25EqualTo(String value) {
            addCriterion("CBCA25 =", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25NotEqualTo(String value) {
            addCriterion("CBCA25 <>", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25GreaterThan(String value) {
            addCriterion("CBCA25 >", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA25 >=", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25LessThan(String value) {
            addCriterion("CBCA25 <", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25LessThanOrEqualTo(String value) {
            addCriterion("CBCA25 <=", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25Like(String value) {
            addCriterion("CBCA25 like", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25NotLike(String value) {
            addCriterion("CBCA25 not like", value, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25In(List<String> values) {
            addCriterion("CBCA25 in", values, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25NotIn(List<String> values) {
            addCriterion("CBCA25 not in", values, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25Between(String value1, String value2) {
            addCriterion("CBCA25 between", value1, value2, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca25NotBetween(String value1, String value2) {
            addCriterion("CBCA25 not between", value1, value2, "cbca25");
            return (Criteria) this;
        }

        public Criteria andCbca26IsNull() {
            addCriterion("CBCA26 is null");
            return (Criteria) this;
        }

        public Criteria andCbca26IsNotNull() {
            addCriterion("CBCA26 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca26EqualTo(String value) {
            addCriterion("CBCA26 =", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26NotEqualTo(String value) {
            addCriterion("CBCA26 <>", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26GreaterThan(String value) {
            addCriterion("CBCA26 >", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA26 >=", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26LessThan(String value) {
            addCriterion("CBCA26 <", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26LessThanOrEqualTo(String value) {
            addCriterion("CBCA26 <=", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26Like(String value) {
            addCriterion("CBCA26 like", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26NotLike(String value) {
            addCriterion("CBCA26 not like", value, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26In(List<String> values) {
            addCriterion("CBCA26 in", values, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26NotIn(List<String> values) {
            addCriterion("CBCA26 not in", values, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26Between(String value1, String value2) {
            addCriterion("CBCA26 between", value1, value2, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca26NotBetween(String value1, String value2) {
            addCriterion("CBCA26 not between", value1, value2, "cbca26");
            return (Criteria) this;
        }

        public Criteria andCbca27IsNull() {
            addCriterion("CBCA27 is null");
            return (Criteria) this;
        }

        public Criteria andCbca27IsNotNull() {
            addCriterion("CBCA27 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca27EqualTo(String value) {
            addCriterion("CBCA27 =", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27NotEqualTo(String value) {
            addCriterion("CBCA27 <>", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27GreaterThan(String value) {
            addCriterion("CBCA27 >", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27GreaterThanOrEqualTo(String value) {
            addCriterion("CBCA27 >=", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27LessThan(String value) {
            addCriterion("CBCA27 <", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27LessThanOrEqualTo(String value) {
            addCriterion("CBCA27 <=", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27Like(String value) {
            addCriterion("CBCA27 like", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27NotLike(String value) {
            addCriterion("CBCA27 not like", value, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27In(List<String> values) {
            addCriterion("CBCA27 in", values, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27NotIn(List<String> values) {
            addCriterion("CBCA27 not in", values, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27Between(String value1, String value2) {
            addCriterion("CBCA27 between", value1, value2, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca27NotBetween(String value1, String value2) {
            addCriterion("CBCA27 not between", value1, value2, "cbca27");
            return (Criteria) this;
        }

        public Criteria andCbca28IsNull() {
            addCriterion("CBCA28 is null");
            return (Criteria) this;
        }

        public Criteria andCbca28IsNotNull() {
            addCriterion("CBCA28 is not null");
            return (Criteria) this;
        }

        public Criteria andCbca28EqualTo(Integer value) {
            addCriterion("CBCA28 =", value, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28NotEqualTo(Integer value) {
            addCriterion("CBCA28 <>", value, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28GreaterThan(Integer value) {
            addCriterion("CBCA28 >", value, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBCA28 >=", value, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28LessThan(Integer value) {
            addCriterion("CBCA28 <", value, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28LessThanOrEqualTo(Integer value) {
            addCriterion("CBCA28 <=", value, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28In(List<Integer> values) {
            addCriterion("CBCA28 in", values, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28NotIn(List<Integer> values) {
            addCriterion("CBCA28 not in", values, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28Between(Integer value1, Integer value2) {
            addCriterion("CBCA28 between", value1, value2, "cbca28");
            return (Criteria) this;
        }

        public Criteria andCbca28NotBetween(Integer value1, Integer value2) {
            addCriterion("CBCA28 not between", value1, value2, "cbca28");
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
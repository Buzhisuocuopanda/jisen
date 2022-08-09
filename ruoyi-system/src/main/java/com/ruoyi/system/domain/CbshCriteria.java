package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbshCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbshCriteria() {
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

        public Criteria andCbsh02IsNull() {
            addCriterion("CBSH02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh02IsNotNull() {
            addCriterion("CBSH02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh02EqualTo(Date value) {
            addCriterion("CBSH02 =", value, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02NotEqualTo(Date value) {
            addCriterion("CBSH02 <>", value, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02GreaterThan(Date value) {
            addCriterion("CBSH02 >", value, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSH02 >=", value, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02LessThan(Date value) {
            addCriterion("CBSH02 <", value, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02LessThanOrEqualTo(Date value) {
            addCriterion("CBSH02 <=", value, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02In(List<Date> values) {
            addCriterion("CBSH02 in", values, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02NotIn(List<Date> values) {
            addCriterion("CBSH02 not in", values, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02Between(Date value1, Date value2) {
            addCriterion("CBSH02 between", value1, value2, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh02NotBetween(Date value1, Date value2) {
            addCriterion("CBSH02 not between", value1, value2, "cbsh02");
            return (Criteria) this;
        }

        public Criteria andCbsh03IsNull() {
            addCriterion("CBSH03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh03IsNotNull() {
            addCriterion("CBSH03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh03EqualTo(Date value) {
            addCriterion("CBSH03 =", value, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03NotEqualTo(Date value) {
            addCriterion("CBSH03 <>", value, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03GreaterThan(Date value) {
            addCriterion("CBSH03 >", value, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSH03 >=", value, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03LessThan(Date value) {
            addCriterion("CBSH03 <", value, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03LessThanOrEqualTo(Date value) {
            addCriterion("CBSH03 <=", value, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03In(List<Date> values) {
            addCriterion("CBSH03 in", values, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03NotIn(List<Date> values) {
            addCriterion("CBSH03 not in", values, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03Between(Date value1, Date value2) {
            addCriterion("CBSH03 between", value1, value2, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh03NotBetween(Date value1, Date value2) {
            addCriterion("CBSH03 not between", value1, value2, "cbsh03");
            return (Criteria) this;
        }

        public Criteria andCbsh04IsNull() {
            addCriterion("CBSH04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh04IsNotNull() {
            addCriterion("CBSH04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh04EqualTo(Integer value) {
            addCriterion("CBSH04 =", value, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04NotEqualTo(Integer value) {
            addCriterion("CBSH04 <>", value, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04GreaterThan(Integer value) {
            addCriterion("CBSH04 >", value, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH04 >=", value, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04LessThan(Integer value) {
            addCriterion("CBSH04 <", value, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH04 <=", value, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04In(List<Integer> values) {
            addCriterion("CBSH04 in", values, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04NotIn(List<Integer> values) {
            addCriterion("CBSH04 not in", values, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04Between(Integer value1, Integer value2) {
            addCriterion("CBSH04 between", value1, value2, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH04 not between", value1, value2, "cbsh04");
            return (Criteria) this;
        }

        public Criteria andCbsh05IsNull() {
            addCriterion("CBSH05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh05IsNotNull() {
            addCriterion("CBSH05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh05EqualTo(Integer value) {
            addCriterion("CBSH05 =", value, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05NotEqualTo(Integer value) {
            addCriterion("CBSH05 <>", value, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05GreaterThan(Integer value) {
            addCriterion("CBSH05 >", value, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH05 >=", value, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05LessThan(Integer value) {
            addCriterion("CBSH05 <", value, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH05 <=", value, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05In(List<Integer> values) {
            addCriterion("CBSH05 in", values, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05NotIn(List<Integer> values) {
            addCriterion("CBSH05 not in", values, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05Between(Integer value1, Integer value2) {
            addCriterion("CBSH05 between", value1, value2, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH05 not between", value1, value2, "cbsh05");
            return (Criteria) this;
        }

        public Criteria andCbsh06IsNull() {
            addCriterion("CBSH06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh06IsNotNull() {
            addCriterion("CBSH06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh06EqualTo(Integer value) {
            addCriterion("CBSH06 =", value, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06NotEqualTo(Integer value) {
            addCriterion("CBSH06 <>", value, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06GreaterThan(Integer value) {
            addCriterion("CBSH06 >", value, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH06 >=", value, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06LessThan(Integer value) {
            addCriterion("CBSH06 <", value, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH06 <=", value, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06In(List<Integer> values) {
            addCriterion("CBSH06 in", values, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06NotIn(List<Integer> values) {
            addCriterion("CBSH06 not in", values, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06Between(Integer value1, Integer value2) {
            addCriterion("CBSH06 between", value1, value2, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH06 not between", value1, value2, "cbsh06");
            return (Criteria) this;
        }

        public Criteria andCbsh07IsNull() {
            addCriterion("CBSH07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh07IsNotNull() {
            addCriterion("CBSH07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh07EqualTo(String value) {
            addCriterion("CBSH07 =", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07NotEqualTo(String value) {
            addCriterion("CBSH07 <>", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07GreaterThan(String value) {
            addCriterion("CBSH07 >", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07GreaterThanOrEqualTo(String value) {
            addCriterion("CBSH07 >=", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07LessThan(String value) {
            addCriterion("CBSH07 <", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07LessThanOrEqualTo(String value) {
            addCriterion("CBSH07 <=", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07Like(String value) {
            addCriterion("CBSH07 like", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07NotLike(String value) {
            addCriterion("CBSH07 not like", value, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07In(List<String> values) {
            addCriterion("CBSH07 in", values, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07NotIn(List<String> values) {
            addCriterion("CBSH07 not in", values, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07Between(String value1, String value2) {
            addCriterion("CBSH07 between", value1, value2, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh07NotBetween(String value1, String value2) {
            addCriterion("CBSH07 not between", value1, value2, "cbsh07");
            return (Criteria) this;
        }

        public Criteria andCbsh08IsNull() {
            addCriterion("CBSH08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh08IsNotNull() {
            addCriterion("CBSH08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh08EqualTo(Date value) {
            addCriterion("CBSH08 =", value, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08NotEqualTo(Date value) {
            addCriterion("CBSH08 <>", value, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08GreaterThan(Date value) {
            addCriterion("CBSH08 >", value, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSH08 >=", value, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08LessThan(Date value) {
            addCriterion("CBSH08 <", value, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08LessThanOrEqualTo(Date value) {
            addCriterion("CBSH08 <=", value, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08In(List<Date> values) {
            addCriterion("CBSH08 in", values, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08NotIn(List<Date> values) {
            addCriterion("CBSH08 not in", values, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08Between(Date value1, Date value2) {
            addCriterion("CBSH08 between", value1, value2, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh08NotBetween(Date value1, Date value2) {
            addCriterion("CBSH08 not between", value1, value2, "cbsh08");
            return (Criteria) this;
        }

        public Criteria andCbsh09IsNull() {
            addCriterion("CBSH09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh09IsNotNull() {
            addCriterion("CBSH09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh09EqualTo(Integer value) {
            addCriterion("CBSH09 =", value, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09NotEqualTo(Integer value) {
            addCriterion("CBSH09 <>", value, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09GreaterThan(Integer value) {
            addCriterion("CBSH09 >", value, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH09 >=", value, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09LessThan(Integer value) {
            addCriterion("CBSH09 <", value, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH09 <=", value, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09In(List<Integer> values) {
            addCriterion("CBSH09 in", values, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09NotIn(List<Integer> values) {
            addCriterion("CBSH09 not in", values, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09Between(Integer value1, Integer value2) {
            addCriterion("CBSH09 between", value1, value2, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH09 not between", value1, value2, "cbsh09");
            return (Criteria) this;
        }

        public Criteria andCbsh10IsNull() {
            addCriterion("CBSH10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh10IsNotNull() {
            addCriterion("CBSH10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh10EqualTo(Integer value) {
            addCriterion("CBSH10 =", value, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10NotEqualTo(Integer value) {
            addCriterion("CBSH10 <>", value, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10GreaterThan(Integer value) {
            addCriterion("CBSH10 >", value, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH10 >=", value, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10LessThan(Integer value) {
            addCriterion("CBSH10 <", value, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH10 <=", value, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10In(List<Integer> values) {
            addCriterion("CBSH10 in", values, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10NotIn(List<Integer> values) {
            addCriterion("CBSH10 not in", values, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10Between(Integer value1, Integer value2) {
            addCriterion("CBSH10 between", value1, value2, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH10 not between", value1, value2, "cbsh10");
            return (Criteria) this;
        }

        public Criteria andCbsh11IsNull() {
            addCriterion("CBSH11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh11IsNotNull() {
            addCriterion("CBSH11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh11EqualTo(Integer value) {
            addCriterion("CBSH11 =", value, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11NotEqualTo(Integer value) {
            addCriterion("CBSH11 <>", value, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11GreaterThan(Integer value) {
            addCriterion("CBSH11 >", value, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH11 >=", value, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11LessThan(Integer value) {
            addCriterion("CBSH11 <", value, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH11 <=", value, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11In(List<Integer> values) {
            addCriterion("CBSH11 in", values, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11NotIn(List<Integer> values) {
            addCriterion("CBSH11 not in", values, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11Between(Integer value1, Integer value2) {
            addCriterion("CBSH11 between", value1, value2, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH11 not between", value1, value2, "cbsh11");
            return (Criteria) this;
        }

        public Criteria andCbsh12IsNull() {
            addCriterion("CBSH12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh12IsNotNull() {
            addCriterion("CBSH12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh12EqualTo(Date value) {
            addCriterion("CBSH12 =", value, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12NotEqualTo(Date value) {
            addCriterion("CBSH12 <>", value, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12GreaterThan(Date value) {
            addCriterion("CBSH12 >", value, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSH12 >=", value, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12LessThan(Date value) {
            addCriterion("CBSH12 <", value, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12LessThanOrEqualTo(Date value) {
            addCriterion("CBSH12 <=", value, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12In(List<Date> values) {
            addCriterion("CBSH12 in", values, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12NotIn(List<Date> values) {
            addCriterion("CBSH12 not in", values, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12Between(Date value1, Date value2) {
            addCriterion("CBSH12 between", value1, value2, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh12NotBetween(Date value1, Date value2) {
            addCriterion("CBSH12 not between", value1, value2, "cbsh12");
            return (Criteria) this;
        }

        public Criteria andCbsh13IsNull() {
            addCriterion("CBSH13 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh13IsNotNull() {
            addCriterion("CBSH13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh13EqualTo(Integer value) {
            addCriterion("CBSH13 =", value, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13NotEqualTo(Integer value) {
            addCriterion("CBSH13 <>", value, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13GreaterThan(Integer value) {
            addCriterion("CBSH13 >", value, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSH13 >=", value, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13LessThan(Integer value) {
            addCriterion("CBSH13 <", value, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13LessThanOrEqualTo(Integer value) {
            addCriterion("CBSH13 <=", value, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13In(List<Integer> values) {
            addCriterion("CBSH13 in", values, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13NotIn(List<Integer> values) {
            addCriterion("CBSH13 not in", values, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13Between(Integer value1, Integer value2) {
            addCriterion("CBSH13 between", value1, value2, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh13NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSH13 not between", value1, value2, "cbsh13");
            return (Criteria) this;
        }

        public Criteria andCbsh14IsNull() {
            addCriterion("CBSH14 is null");
            return (Criteria) this;
        }

        public Criteria andCbsh14IsNotNull() {
            addCriterion("CBSH14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsh14EqualTo(Date value) {
            addCriterion("CBSH14 =", value, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14NotEqualTo(Date value) {
            addCriterion("CBSH14 <>", value, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14GreaterThan(Date value) {
            addCriterion("CBSH14 >", value, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSH14 >=", value, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14LessThan(Date value) {
            addCriterion("CBSH14 <", value, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14LessThanOrEqualTo(Date value) {
            addCriterion("CBSH14 <=", value, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14In(List<Date> values) {
            addCriterion("CBSH14 in", values, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14NotIn(List<Date> values) {
            addCriterion("CBSH14 not in", values, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14Between(Date value1, Date value2) {
            addCriterion("CBSH14 between", value1, value2, "cbsh14");
            return (Criteria) this;
        }

        public Criteria andCbsh14NotBetween(Date value1, Date value2) {
            addCriterion("CBSH14 not between", value1, value2, "cbsh14");
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
package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpcCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpcCriteria() {
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

        public Criteria andCbpc02IsNull() {
            addCriterion("CBPC02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc02IsNotNull() {
            addCriterion("CBPC02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc02EqualTo(Date value) {
            addCriterion("CBPC02 =", value, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02NotEqualTo(Date value) {
            addCriterion("CBPC02 <>", value, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02GreaterThan(Date value) {
            addCriterion("CBPC02 >", value, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPC02 >=", value, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02LessThan(Date value) {
            addCriterion("CBPC02 <", value, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02LessThanOrEqualTo(Date value) {
            addCriterion("CBPC02 <=", value, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02In(List<Date> values) {
            addCriterion("CBPC02 in", values, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02NotIn(List<Date> values) {
            addCriterion("CBPC02 not in", values, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02Between(Date value1, Date value2) {
            addCriterion("CBPC02 between", value1, value2, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc02NotBetween(Date value1, Date value2) {
            addCriterion("CBPC02 not between", value1, value2, "cbpc02");
            return (Criteria) this;
        }

        public Criteria andCbpc03IsNull() {
            addCriterion("CBPC03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc03IsNotNull() {
            addCriterion("CBPC03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc03EqualTo(Integer value) {
            addCriterion("CBPC03 =", value, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03NotEqualTo(Integer value) {
            addCriterion("CBPC03 <>", value, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03GreaterThan(Integer value) {
            addCriterion("CBPC03 >", value, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC03 >=", value, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03LessThan(Integer value) {
            addCriterion("CBPC03 <", value, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC03 <=", value, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03In(List<Integer> values) {
            addCriterion("CBPC03 in", values, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03NotIn(List<Integer> values) {
            addCriterion("CBPC03 not in", values, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03Between(Integer value1, Integer value2) {
            addCriterion("CBPC03 between", value1, value2, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC03 not between", value1, value2, "cbpc03");
            return (Criteria) this;
        }

        public Criteria andCbpc04IsNull() {
            addCriterion("CBPC04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc04IsNotNull() {
            addCriterion("CBPC04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc04EqualTo(Date value) {
            addCriterion("CBPC04 =", value, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04NotEqualTo(Date value) {
            addCriterion("CBPC04 <>", value, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04GreaterThan(Date value) {
            addCriterion("CBPC04 >", value, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPC04 >=", value, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04LessThan(Date value) {
            addCriterion("CBPC04 <", value, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04LessThanOrEqualTo(Date value) {
            addCriterion("CBPC04 <=", value, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04In(List<Date> values) {
            addCriterion("CBPC04 in", values, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04NotIn(List<Date> values) {
            addCriterion("CBPC04 not in", values, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04Between(Date value1, Date value2) {
            addCriterion("CBPC04 between", value1, value2, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc04NotBetween(Date value1, Date value2) {
            addCriterion("CBPC04 not between", value1, value2, "cbpc04");
            return (Criteria) this;
        }

        public Criteria andCbpc05IsNull() {
            addCriterion("CBPC05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc05IsNotNull() {
            addCriterion("CBPC05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc05EqualTo(Integer value) {
            addCriterion("CBPC05 =", value, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05NotEqualTo(Integer value) {
            addCriterion("CBPC05 <>", value, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05GreaterThan(Integer value) {
            addCriterion("CBPC05 >", value, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC05 >=", value, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05LessThan(Integer value) {
            addCriterion("CBPC05 <", value, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC05 <=", value, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05In(List<Integer> values) {
            addCriterion("CBPC05 in", values, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05NotIn(List<Integer> values) {
            addCriterion("CBPC05 not in", values, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05Between(Integer value1, Integer value2) {
            addCriterion("CBPC05 between", value1, value2, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC05 not between", value1, value2, "cbpc05");
            return (Criteria) this;
        }

        public Criteria andCbpc06IsNull() {
            addCriterion("CBPC06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc06IsNotNull() {
            addCriterion("CBPC06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc06EqualTo(Integer value) {
            addCriterion("CBPC06 =", value, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06NotEqualTo(Integer value) {
            addCriterion("CBPC06 <>", value, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06GreaterThan(Integer value) {
            addCriterion("CBPC06 >", value, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC06 >=", value, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06LessThan(Integer value) {
            addCriterion("CBPC06 <", value, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC06 <=", value, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06In(List<Integer> values) {
            addCriterion("CBPC06 in", values, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06NotIn(List<Integer> values) {
            addCriterion("CBPC06 not in", values, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06Between(Integer value1, Integer value2) {
            addCriterion("CBPC06 between", value1, value2, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC06 not between", value1, value2, "cbpc06");
            return (Criteria) this;
        }

        public Criteria andCbpc07IsNull() {
            addCriterion("CBPC07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc07IsNotNull() {
            addCriterion("CBPC07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc07EqualTo(String value) {
            addCriterion("CBPC07 =", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07NotEqualTo(String value) {
            addCriterion("CBPC07 <>", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07GreaterThan(String value) {
            addCriterion("CBPC07 >", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07GreaterThanOrEqualTo(String value) {
            addCriterion("CBPC07 >=", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07LessThan(String value) {
            addCriterion("CBPC07 <", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07LessThanOrEqualTo(String value) {
            addCriterion("CBPC07 <=", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07Like(String value) {
            addCriterion("CBPC07 like", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07NotLike(String value) {
            addCriterion("CBPC07 not like", value, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07In(List<String> values) {
            addCriterion("CBPC07 in", values, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07NotIn(List<String> values) {
            addCriterion("CBPC07 not in", values, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07Between(String value1, String value2) {
            addCriterion("CBPC07 between", value1, value2, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc07NotBetween(String value1, String value2) {
            addCriterion("CBPC07 not between", value1, value2, "cbpc07");
            return (Criteria) this;
        }

        public Criteria andCbpc08IsNull() {
            addCriterion("CBPC08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc08IsNotNull() {
            addCriterion("CBPC08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc08EqualTo(Date value) {
            addCriterion("CBPC08 =", value, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08NotEqualTo(Date value) {
            addCriterion("CBPC08 <>", value, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08GreaterThan(Date value) {
            addCriterion("CBPC08 >", value, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPC08 >=", value, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08LessThan(Date value) {
            addCriterion("CBPC08 <", value, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08LessThanOrEqualTo(Date value) {
            addCriterion("CBPC08 <=", value, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08In(List<Date> values) {
            addCriterion("CBPC08 in", values, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08NotIn(List<Date> values) {
            addCriterion("CBPC08 not in", values, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08Between(Date value1, Date value2) {
            addCriterion("CBPC08 between", value1, value2, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc08NotBetween(Date value1, Date value2) {
            addCriterion("CBPC08 not between", value1, value2, "cbpc08");
            return (Criteria) this;
        }

        public Criteria andCbpc09IsNull() {
            addCriterion("CBPC09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc09IsNotNull() {
            addCriterion("CBPC09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc09EqualTo(Integer value) {
            addCriterion("CBPC09 =", value, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09NotEqualTo(Integer value) {
            addCriterion("CBPC09 <>", value, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09GreaterThan(Integer value) {
            addCriterion("CBPC09 >", value, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC09 >=", value, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09LessThan(Integer value) {
            addCriterion("CBPC09 <", value, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC09 <=", value, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09In(List<Integer> values) {
            addCriterion("CBPC09 in", values, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09NotIn(List<Integer> values) {
            addCriterion("CBPC09 not in", values, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09Between(Integer value1, Integer value2) {
            addCriterion("CBPC09 between", value1, value2, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC09 not between", value1, value2, "cbpc09");
            return (Criteria) this;
        }

        public Criteria andCbpc10IsNull() {
            addCriterion("CBPC10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc10IsNotNull() {
            addCriterion("CBPC10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc10EqualTo(Integer value) {
            addCriterion("CBPC10 =", value, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10NotEqualTo(Integer value) {
            addCriterion("CBPC10 <>", value, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10GreaterThan(Integer value) {
            addCriterion("CBPC10 >", value, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC10 >=", value, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10LessThan(Integer value) {
            addCriterion("CBPC10 <", value, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC10 <=", value, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10In(List<Integer> values) {
            addCriterion("CBPC10 in", values, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10NotIn(List<Integer> values) {
            addCriterion("CBPC10 not in", values, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10Between(Integer value1, Integer value2) {
            addCriterion("CBPC10 between", value1, value2, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC10 not between", value1, value2, "cbpc10");
            return (Criteria) this;
        }

        public Criteria andCbpc11IsNull() {
            addCriterion("CBPC11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc11IsNotNull() {
            addCriterion("CBPC11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc11EqualTo(Integer value) {
            addCriterion("CBPC11 =", value, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11NotEqualTo(Integer value) {
            addCriterion("CBPC11 <>", value, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11GreaterThan(Integer value) {
            addCriterion("CBPC11 >", value, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC11 >=", value, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11LessThan(Integer value) {
            addCriterion("CBPC11 <", value, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC11 <=", value, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11In(List<Integer> values) {
            addCriterion("CBPC11 in", values, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11NotIn(List<Integer> values) {
            addCriterion("CBPC11 not in", values, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11Between(Integer value1, Integer value2) {
            addCriterion("CBPC11 between", value1, value2, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC11 not between", value1, value2, "cbpc11");
            return (Criteria) this;
        }

        public Criteria andCbpc12IsNull() {
            addCriterion("CBPC12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc12IsNotNull() {
            addCriterion("CBPC12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc12EqualTo(Integer value) {
            addCriterion("CBPC12 =", value, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12NotEqualTo(Integer value) {
            addCriterion("CBPC12 <>", value, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12GreaterThan(Integer value) {
            addCriterion("CBPC12 >", value, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC12 >=", value, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12LessThan(Integer value) {
            addCriterion("CBPC12 <", value, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC12 <=", value, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12In(List<Integer> values) {
            addCriterion("CBPC12 in", values, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12NotIn(List<Integer> values) {
            addCriterion("CBPC12 not in", values, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12Between(Integer value1, Integer value2) {
            addCriterion("CBPC12 between", value1, value2, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC12 not between", value1, value2, "cbpc12");
            return (Criteria) this;
        }

        public Criteria andCbpc13IsNull() {
            addCriterion("CBPC13 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc13IsNotNull() {
            addCriterion("CBPC13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc13EqualTo(Date value) {
            addCriterion("CBPC13 =", value, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13NotEqualTo(Date value) {
            addCriterion("CBPC13 <>", value, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13GreaterThan(Date value) {
            addCriterion("CBPC13 >", value, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPC13 >=", value, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13LessThan(Date value) {
            addCriterion("CBPC13 <", value, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13LessThanOrEqualTo(Date value) {
            addCriterion("CBPC13 <=", value, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13In(List<Date> values) {
            addCriterion("CBPC13 in", values, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13NotIn(List<Date> values) {
            addCriterion("CBPC13 not in", values, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13Between(Date value1, Date value2) {
            addCriterion("CBPC13 between", value1, value2, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc13NotBetween(Date value1, Date value2) {
            addCriterion("CBPC13 not between", value1, value2, "cbpc13");
            return (Criteria) this;
        }

        public Criteria andCbpc14IsNull() {
            addCriterion("CBPC14 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc14IsNotNull() {
            addCriterion("CBPC14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc14EqualTo(Integer value) {
            addCriterion("CBPC14 =", value, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14NotEqualTo(Integer value) {
            addCriterion("CBPC14 <>", value, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14GreaterThan(Integer value) {
            addCriterion("CBPC14 >", value, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC14 >=", value, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14LessThan(Integer value) {
            addCriterion("CBPC14 <", value, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC14 <=", value, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14In(List<Integer> values) {
            addCriterion("CBPC14 in", values, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14NotIn(List<Integer> values) {
            addCriterion("CBPC14 not in", values, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14Between(Integer value1, Integer value2) {
            addCriterion("CBPC14 between", value1, value2, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC14 not between", value1, value2, "cbpc14");
            return (Criteria) this;
        }

        public Criteria andCbpc15IsNull() {
            addCriterion("CBPC15 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc15IsNotNull() {
            addCriterion("CBPC15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc15EqualTo(Date value) {
            addCriterion("CBPC15 =", value, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15NotEqualTo(Date value) {
            addCriterion("CBPC15 <>", value, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15GreaterThan(Date value) {
            addCriterion("CBPC15 >", value, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPC15 >=", value, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15LessThan(Date value) {
            addCriterion("CBPC15 <", value, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15LessThanOrEqualTo(Date value) {
            addCriterion("CBPC15 <=", value, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15In(List<Date> values) {
            addCriterion("CBPC15 in", values, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15NotIn(List<Date> values) {
            addCriterion("CBPC15 not in", values, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15Between(Date value1, Date value2) {
            addCriterion("CBPC15 between", value1, value2, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc15NotBetween(Date value1, Date value2) {
            addCriterion("CBPC15 not between", value1, value2, "cbpc15");
            return (Criteria) this;
        }

        public Criteria andCbpc16IsNull() {
            addCriterion("CBPC16 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc16IsNotNull() {
            addCriterion("CBPC16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc16EqualTo(Integer value) {
            addCriterion("CBPC16 =", value, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16NotEqualTo(Integer value) {
            addCriterion("CBPC16 <>", value, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16GreaterThan(Integer value) {
            addCriterion("CBPC16 >", value, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC16 >=", value, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16LessThan(Integer value) {
            addCriterion("CBPC16 <", value, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC16 <=", value, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16In(List<Integer> values) {
            addCriterion("CBPC16 in", values, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16NotIn(List<Integer> values) {
            addCriterion("CBPC16 not in", values, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16Between(Integer value1, Integer value2) {
            addCriterion("CBPC16 between", value1, value2, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC16 not between", value1, value2, "cbpc16");
            return (Criteria) this;
        }

        public Criteria andCbpc17IsNull() {
            addCriterion("CBPC17 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc17IsNotNull() {
            addCriterion("CBPC17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc17EqualTo(String value) {
            addCriterion("CBPC17 =", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17NotEqualTo(String value) {
            addCriterion("CBPC17 <>", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17GreaterThan(String value) {
            addCriterion("CBPC17 >", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17GreaterThanOrEqualTo(String value) {
            addCriterion("CBPC17 >=", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17LessThan(String value) {
            addCriterion("CBPC17 <", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17LessThanOrEqualTo(String value) {
            addCriterion("CBPC17 <=", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17Like(String value) {
            addCriterion("CBPC17 like", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17NotLike(String value) {
            addCriterion("CBPC17 not like", value, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17In(List<String> values) {
            addCriterion("CBPC17 in", values, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17NotIn(List<String> values) {
            addCriterion("CBPC17 not in", values, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17Between(String value1, String value2) {
            addCriterion("CBPC17 between", value1, value2, "cbpc17");
            return (Criteria) this;
        }

        public Criteria andCbpc17NotBetween(String value1, String value2) {
            addCriterion("CBPC17 not between", value1, value2, "cbpc17");
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
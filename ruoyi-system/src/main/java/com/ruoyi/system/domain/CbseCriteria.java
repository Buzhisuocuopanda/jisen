package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbseCriteria() {
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

        public Criteria andCbse01IsNull() {
            addCriterion("CBSE01 is null");
            return (Criteria) this;
        }

        public Criteria andCbse01IsNotNull() {
            addCriterion("CBSE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse01EqualTo(Integer value) {
            addCriterion("CBSE01 =", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01NotEqualTo(Integer value) {
            addCriterion("CBSE01 <>", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01GreaterThan(Integer value) {
            addCriterion("CBSE01 >", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE01 >=", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01LessThan(Integer value) {
            addCriterion("CBSE01 <", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE01 <=", value, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01In(List<Integer> values) {
            addCriterion("CBSE01 in", values, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01NotIn(List<Integer> values) {
            addCriterion("CBSE01 not in", values, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01Between(Integer value1, Integer value2) {
            addCriterion("CBSE01 between", value1, value2, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE01 not between", value1, value2, "cbse01");
            return (Criteria) this;
        }

        public Criteria andCbse02IsNull() {
            addCriterion("CBSE02 is null");
            return (Criteria) this;
        }

        public Criteria andCbse02IsNotNull() {
            addCriterion("CBSE02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse02EqualTo(Date value) {
            addCriterion("CBSE02 =", value, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02NotEqualTo(Date value) {
            addCriterion("CBSE02 <>", value, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02GreaterThan(Date value) {
            addCriterion("CBSE02 >", value, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSE02 >=", value, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02LessThan(Date value) {
            addCriterion("CBSE02 <", value, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02LessThanOrEqualTo(Date value) {
            addCriterion("CBSE02 <=", value, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02In(List<Date> values) {
            addCriterion("CBSE02 in", values, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02NotIn(List<Date> values) {
            addCriterion("CBSE02 not in", values, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02Between(Date value1, Date value2) {
            addCriterion("CBSE02 between", value1, value2, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse02NotBetween(Date value1, Date value2) {
            addCriterion("CBSE02 not between", value1, value2, "cbse02");
            return (Criteria) this;
        }

        public Criteria andCbse03IsNull() {
            addCriterion("CBSE03 is null");
            return (Criteria) this;
        }

        public Criteria andCbse03IsNotNull() {
            addCriterion("CBSE03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse03EqualTo(Integer value) {
            addCriterion("CBSE03 =", value, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03NotEqualTo(Integer value) {
            addCriterion("CBSE03 <>", value, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03GreaterThan(Integer value) {
            addCriterion("CBSE03 >", value, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE03 >=", value, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03LessThan(Integer value) {
            addCriterion("CBSE03 <", value, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE03 <=", value, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03In(List<Integer> values) {
            addCriterion("CBSE03 in", values, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03NotIn(List<Integer> values) {
            addCriterion("CBSE03 not in", values, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03Between(Integer value1, Integer value2) {
            addCriterion("CBSE03 between", value1, value2, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE03 not between", value1, value2, "cbse03");
            return (Criteria) this;
        }

        public Criteria andCbse04IsNull() {
            addCriterion("CBSE04 is null");
            return (Criteria) this;
        }

        public Criteria andCbse04IsNotNull() {
            addCriterion("CBSE04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse04EqualTo(Date value) {
            addCriterion("CBSE04 =", value, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04NotEqualTo(Date value) {
            addCriterion("CBSE04 <>", value, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04GreaterThan(Date value) {
            addCriterion("CBSE04 >", value, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSE04 >=", value, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04LessThan(Date value) {
            addCriterion("CBSE04 <", value, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04LessThanOrEqualTo(Date value) {
            addCriterion("CBSE04 <=", value, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04In(List<Date> values) {
            addCriterion("CBSE04 in", values, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04NotIn(List<Date> values) {
            addCriterion("CBSE04 not in", values, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04Between(Date value1, Date value2) {
            addCriterion("CBSE04 between", value1, value2, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse04NotBetween(Date value1, Date value2) {
            addCriterion("CBSE04 not between", value1, value2, "cbse04");
            return (Criteria) this;
        }

        public Criteria andCbse05IsNull() {
            addCriterion("CBSE05 is null");
            return (Criteria) this;
        }

        public Criteria andCbse05IsNotNull() {
            addCriterion("CBSE05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse05EqualTo(Integer value) {
            addCriterion("CBSE05 =", value, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05NotEqualTo(Integer value) {
            addCriterion("CBSE05 <>", value, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05GreaterThan(Integer value) {
            addCriterion("CBSE05 >", value, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE05 >=", value, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05LessThan(Integer value) {
            addCriterion("CBSE05 <", value, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE05 <=", value, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05In(List<Integer> values) {
            addCriterion("CBSE05 in", values, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05NotIn(List<Integer> values) {
            addCriterion("CBSE05 not in", values, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05Between(Integer value1, Integer value2) {
            addCriterion("CBSE05 between", value1, value2, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE05 not between", value1, value2, "cbse05");
            return (Criteria) this;
        }

        public Criteria andCbse06IsNull() {
            addCriterion("CBSE06 is null");
            return (Criteria) this;
        }

        public Criteria andCbse06IsNotNull() {
            addCriterion("CBSE06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse06EqualTo(Integer value) {
            addCriterion("CBSE06 =", value, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06NotEqualTo(Integer value) {
            addCriterion("CBSE06 <>", value, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06GreaterThan(Integer value) {
            addCriterion("CBSE06 >", value, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE06 >=", value, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06LessThan(Integer value) {
            addCriterion("CBSE06 <", value, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE06 <=", value, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06In(List<Integer> values) {
            addCriterion("CBSE06 in", values, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06NotIn(List<Integer> values) {
            addCriterion("CBSE06 not in", values, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06Between(Integer value1, Integer value2) {
            addCriterion("CBSE06 between", value1, value2, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE06 not between", value1, value2, "cbse06");
            return (Criteria) this;
        }

        public Criteria andCbse07IsNull() {
            addCriterion("CBSE07 is null");
            return (Criteria) this;
        }

        public Criteria andCbse07IsNotNull() {
            addCriterion("CBSE07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse07EqualTo(String value) {
            addCriterion("CBSE07 =", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07NotEqualTo(String value) {
            addCriterion("CBSE07 <>", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07GreaterThan(String value) {
            addCriterion("CBSE07 >", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07GreaterThanOrEqualTo(String value) {
            addCriterion("CBSE07 >=", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07LessThan(String value) {
            addCriterion("CBSE07 <", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07LessThanOrEqualTo(String value) {
            addCriterion("CBSE07 <=", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07Like(String value) {
            addCriterion("CBSE07 like", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07NotLike(String value) {
            addCriterion("CBSE07 not like", value, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07In(List<String> values) {
            addCriterion("CBSE07 in", values, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07NotIn(List<String> values) {
            addCriterion("CBSE07 not in", values, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07Between(String value1, String value2) {
            addCriterion("CBSE07 between", value1, value2, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse07NotBetween(String value1, String value2) {
            addCriterion("CBSE07 not between", value1, value2, "cbse07");
            return (Criteria) this;
        }

        public Criteria andCbse08IsNull() {
            addCriterion("CBSE08 is null");
            return (Criteria) this;
        }

        public Criteria andCbse08IsNotNull() {
            addCriterion("CBSE08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse08EqualTo(Date value) {
            addCriterion("CBSE08 =", value, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08NotEqualTo(Date value) {
            addCriterion("CBSE08 <>", value, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08GreaterThan(Date value) {
            addCriterion("CBSE08 >", value, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSE08 >=", value, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08LessThan(Date value) {
            addCriterion("CBSE08 <", value, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08LessThanOrEqualTo(Date value) {
            addCriterion("CBSE08 <=", value, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08In(List<Date> values) {
            addCriterion("CBSE08 in", values, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08NotIn(List<Date> values) {
            addCriterion("CBSE08 not in", values, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08Between(Date value1, Date value2) {
            addCriterion("CBSE08 between", value1, value2, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse08NotBetween(Date value1, Date value2) {
            addCriterion("CBSE08 not between", value1, value2, "cbse08");
            return (Criteria) this;
        }

        public Criteria andCbse09IsNull() {
            addCriterion("CBSE09 is null");
            return (Criteria) this;
        }

        public Criteria andCbse09IsNotNull() {
            addCriterion("CBSE09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse09EqualTo(Integer value) {
            addCriterion("CBSE09 =", value, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09NotEqualTo(Integer value) {
            addCriterion("CBSE09 <>", value, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09GreaterThan(Integer value) {
            addCriterion("CBSE09 >", value, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE09 >=", value, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09LessThan(Integer value) {
            addCriterion("CBSE09 <", value, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE09 <=", value, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09In(List<Integer> values) {
            addCriterion("CBSE09 in", values, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09NotIn(List<Integer> values) {
            addCriterion("CBSE09 not in", values, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09Between(Integer value1, Integer value2) {
            addCriterion("CBSE09 between", value1, value2, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE09 not between", value1, value2, "cbse09");
            return (Criteria) this;
        }

        public Criteria andCbse10IsNull() {
            addCriterion("CBSE10 is null");
            return (Criteria) this;
        }

        public Criteria andCbse10IsNotNull() {
            addCriterion("CBSE10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse10EqualTo(Integer value) {
            addCriterion("CBSE10 =", value, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10NotEqualTo(Integer value) {
            addCriterion("CBSE10 <>", value, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10GreaterThan(Integer value) {
            addCriterion("CBSE10 >", value, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE10 >=", value, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10LessThan(Integer value) {
            addCriterion("CBSE10 <", value, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE10 <=", value, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10In(List<Integer> values) {
            addCriterion("CBSE10 in", values, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10NotIn(List<Integer> values) {
            addCriterion("CBSE10 not in", values, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10Between(Integer value1, Integer value2) {
            addCriterion("CBSE10 between", value1, value2, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE10 not between", value1, value2, "cbse10");
            return (Criteria) this;
        }

        public Criteria andCbse11IsNull() {
            addCriterion("CBSE11 is null");
            return (Criteria) this;
        }

        public Criteria andCbse11IsNotNull() {
            addCriterion("CBSE11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse11EqualTo(Integer value) {
            addCriterion("CBSE11 =", value, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11NotEqualTo(Integer value) {
            addCriterion("CBSE11 <>", value, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11GreaterThan(Integer value) {
            addCriterion("CBSE11 >", value, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE11 >=", value, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11LessThan(Integer value) {
            addCriterion("CBSE11 <", value, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE11 <=", value, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11In(List<Integer> values) {
            addCriterion("CBSE11 in", values, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11NotIn(List<Integer> values) {
            addCriterion("CBSE11 not in", values, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11Between(Integer value1, Integer value2) {
            addCriterion("CBSE11 between", value1, value2, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE11 not between", value1, value2, "cbse11");
            return (Criteria) this;
        }

        public Criteria andCbse12IsNull() {
            addCriterion("CBSE12 is null");
            return (Criteria) this;
        }

        public Criteria andCbse12IsNotNull() {
            addCriterion("CBSE12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse12EqualTo(Integer value) {
            addCriterion("CBSE12 =", value, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12NotEqualTo(Integer value) {
            addCriterion("CBSE12 <>", value, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12GreaterThan(Integer value) {
            addCriterion("CBSE12 >", value, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE12 >=", value, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12LessThan(Integer value) {
            addCriterion("CBSE12 <", value, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE12 <=", value, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12In(List<Integer> values) {
            addCriterion("CBSE12 in", values, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12NotIn(List<Integer> values) {
            addCriterion("CBSE12 not in", values, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12Between(Integer value1, Integer value2) {
            addCriterion("CBSE12 between", value1, value2, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE12 not between", value1, value2, "cbse12");
            return (Criteria) this;
        }

        public Criteria andCbse13IsNull() {
            addCriterion("CBSE13 is null");
            return (Criteria) this;
        }

        public Criteria andCbse13IsNotNull() {
            addCriterion("CBSE13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse13EqualTo(Date value) {
            addCriterion("CBSE13 =", value, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13NotEqualTo(Date value) {
            addCriterion("CBSE13 <>", value, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13GreaterThan(Date value) {
            addCriterion("CBSE13 >", value, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSE13 >=", value, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13LessThan(Date value) {
            addCriterion("CBSE13 <", value, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13LessThanOrEqualTo(Date value) {
            addCriterion("CBSE13 <=", value, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13In(List<Date> values) {
            addCriterion("CBSE13 in", values, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13NotIn(List<Date> values) {
            addCriterion("CBSE13 not in", values, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13Between(Date value1, Date value2) {
            addCriterion("CBSE13 between", value1, value2, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse13NotBetween(Date value1, Date value2) {
            addCriterion("CBSE13 not between", value1, value2, "cbse13");
            return (Criteria) this;
        }

        public Criteria andCbse14IsNull() {
            addCriterion("CBSE14 is null");
            return (Criteria) this;
        }

        public Criteria andCbse14IsNotNull() {
            addCriterion("CBSE14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse14EqualTo(Integer value) {
            addCriterion("CBSE14 =", value, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14NotEqualTo(Integer value) {
            addCriterion("CBSE14 <>", value, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14GreaterThan(Integer value) {
            addCriterion("CBSE14 >", value, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE14 >=", value, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14LessThan(Integer value) {
            addCriterion("CBSE14 <", value, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE14 <=", value, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14In(List<Integer> values) {
            addCriterion("CBSE14 in", values, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14NotIn(List<Integer> values) {
            addCriterion("CBSE14 not in", values, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14Between(Integer value1, Integer value2) {
            addCriterion("CBSE14 between", value1, value2, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE14 not between", value1, value2, "cbse14");
            return (Criteria) this;
        }

        public Criteria andCbse15IsNull() {
            addCriterion("CBSE15 is null");
            return (Criteria) this;
        }

        public Criteria andCbse15IsNotNull() {
            addCriterion("CBSE15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse15EqualTo(Date value) {
            addCriterion("CBSE15 =", value, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15NotEqualTo(Date value) {
            addCriterion("CBSE15 <>", value, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15GreaterThan(Date value) {
            addCriterion("CBSE15 >", value, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSE15 >=", value, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15LessThan(Date value) {
            addCriterion("CBSE15 <", value, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15LessThanOrEqualTo(Date value) {
            addCriterion("CBSE15 <=", value, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15In(List<Date> values) {
            addCriterion("CBSE15 in", values, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15NotIn(List<Date> values) {
            addCriterion("CBSE15 not in", values, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15Between(Date value1, Date value2) {
            addCriterion("CBSE15 between", value1, value2, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse15NotBetween(Date value1, Date value2) {
            addCriterion("CBSE15 not between", value1, value2, "cbse15");
            return (Criteria) this;
        }

        public Criteria andCbse16IsNull() {
            addCriterion("CBSE16 is null");
            return (Criteria) this;
        }

        public Criteria andCbse16IsNotNull() {
            addCriterion("CBSE16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse16EqualTo(Integer value) {
            addCriterion("CBSE16 =", value, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16NotEqualTo(Integer value) {
            addCriterion("CBSE16 <>", value, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16GreaterThan(Integer value) {
            addCriterion("CBSE16 >", value, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE16 >=", value, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16LessThan(Integer value) {
            addCriterion("CBSE16 <", value, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE16 <=", value, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16In(List<Integer> values) {
            addCriterion("CBSE16 in", values, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16NotIn(List<Integer> values) {
            addCriterion("CBSE16 not in", values, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16Between(Integer value1, Integer value2) {
            addCriterion("CBSE16 between", value1, value2, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE16 not between", value1, value2, "cbse16");
            return (Criteria) this;
        }

        public Criteria andCbse17IsNull() {
            addCriterion("CBSE17 is null");
            return (Criteria) this;
        }

        public Criteria andCbse17IsNotNull() {
            addCriterion("CBSE17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse17EqualTo(String value) {
            addCriterion("CBSE17 =", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17NotEqualTo(String value) {
            addCriterion("CBSE17 <>", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17GreaterThan(String value) {
            addCriterion("CBSE17 >", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17GreaterThanOrEqualTo(String value) {
            addCriterion("CBSE17 >=", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17LessThan(String value) {
            addCriterion("CBSE17 <", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17LessThanOrEqualTo(String value) {
            addCriterion("CBSE17 <=", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17Like(String value) {
            addCriterion("CBSE17 like", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17NotLike(String value) {
            addCriterion("CBSE17 not like", value, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17In(List<String> values) {
            addCriterion("CBSE17 in", values, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17NotIn(List<String> values) {
            addCriterion("CBSE17 not in", values, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17Between(String value1, String value2) {
            addCriterion("CBSE17 between", value1, value2, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse17NotBetween(String value1, String value2) {
            addCriterion("CBSE17 not between", value1, value2, "cbse17");
            return (Criteria) this;
        }

        public Criteria andCbse18IsNull() {
            addCriterion("CBSE18 is null");
            return (Criteria) this;
        }

        public Criteria andCbse18IsNotNull() {
            addCriterion("CBSE18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbse18EqualTo(Integer value) {
            addCriterion("CBSE18 =", value, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18NotEqualTo(Integer value) {
            addCriterion("CBSE18 <>", value, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18GreaterThan(Integer value) {
            addCriterion("CBSE18 >", value, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSE18 >=", value, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18LessThan(Integer value) {
            addCriterion("CBSE18 <", value, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18LessThanOrEqualTo(Integer value) {
            addCriterion("CBSE18 <=", value, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18In(List<Integer> values) {
            addCriterion("CBSE18 in", values, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18NotIn(List<Integer> values) {
            addCriterion("CBSE18 not in", values, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18Between(Integer value1, Integer value2) {
            addCriterion("CBSE18 between", value1, value2, "cbse18");
            return (Criteria) this;
        }

        public Criteria andCbse18NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSE18 not between", value1, value2, "cbse18");
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

        public Criteria andChangeTypeIsNull() {
            addCriterion("change_type is null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIsNotNull() {
            addCriterion("change_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeEqualTo(Integer value) {
            addCriterion("change_type =", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotEqualTo(Integer value) {
            addCriterion("change_type <>", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThan(Integer value) {
            addCriterion("change_type >", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_type >=", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThan(Integer value) {
            addCriterion("change_type <", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("change_type <=", value, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIn(List<Integer> values) {
            addCriterion("change_type in", values, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotIn(List<Integer> values) {
            addCriterion("change_type not in", values, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeBetween(Integer value1, Integer value2) {
            addCriterion("change_type between", value1, value2, "changeType");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("change_type not between", value1, value2, "changeType");
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
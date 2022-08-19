package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsgCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsgCriteria() {
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

        public Criteria andCbsg01IsNull() {
            addCriterion("CBSG01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg01IsNotNull() {
            addCriterion("CBSG01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg01EqualTo(Integer value) {
            addCriterion("CBSG01 =", value, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01NotEqualTo(Integer value) {
            addCriterion("CBSG01 <>", value, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01GreaterThan(Integer value) {
            addCriterion("CBSG01 >", value, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG01 >=", value, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01LessThan(Integer value) {
            addCriterion("CBSG01 <", value, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG01 <=", value, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01In(List<Integer> values) {
            addCriterion("CBSG01 in", values, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01NotIn(List<Integer> values) {
            addCriterion("CBSG01 not in", values, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01Between(Integer value1, Integer value2) {
            addCriterion("CBSG01 between", value1, value2, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG01 not between", value1, value2, "cbsg01");
            return (Criteria) this;
        }

        public Criteria andCbsg02IsNull() {
            addCriterion("CBSG02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg02IsNotNull() {
            addCriterion("CBSG02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg02EqualTo(Integer value) {
            addCriterion("CBSG02 =", value, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02NotEqualTo(Integer value) {
            addCriterion("CBSG02 <>", value, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02GreaterThan(Integer value) {
            addCriterion("CBSG02 >", value, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG02 >=", value, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02LessThan(Integer value) {
            addCriterion("CBSG02 <", value, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG02 <=", value, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02In(List<Integer> values) {
            addCriterion("CBSG02 in", values, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02NotIn(List<Integer> values) {
            addCriterion("CBSG02 not in", values, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02Between(Integer value1, Integer value2) {
            addCriterion("CBSG02 between", value1, value2, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG02 not between", value1, value2, "cbsg02");
            return (Criteria) this;
        }

        public Criteria andCbsg03IsNull() {
            addCriterion("CBSG03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg03IsNotNull() {
            addCriterion("CBSG03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg03EqualTo(Date value) {
            addCriterion("CBSG03 =", value, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03NotEqualTo(Date value) {
            addCriterion("CBSG03 <>", value, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03GreaterThan(Date value) {
            addCriterion("CBSG03 >", value, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSG03 >=", value, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03LessThan(Date value) {
            addCriterion("CBSG03 <", value, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03LessThanOrEqualTo(Date value) {
            addCriterion("CBSG03 <=", value, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03In(List<Date> values) {
            addCriterion("CBSG03 in", values, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03NotIn(List<Date> values) {
            addCriterion("CBSG03 not in", values, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03Between(Date value1, Date value2) {
            addCriterion("CBSG03 between", value1, value2, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg03NotBetween(Date value1, Date value2) {
            addCriterion("CBSG03 not between", value1, value2, "cbsg03");
            return (Criteria) this;
        }

        public Criteria andCbsg04IsNull() {
            addCriterion("CBSG04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg04IsNotNull() {
            addCriterion("CBSG04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg04EqualTo(Integer value) {
            addCriterion("CBSG04 =", value, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04NotEqualTo(Integer value) {
            addCriterion("CBSG04 <>", value, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04GreaterThan(Integer value) {
            addCriterion("CBSG04 >", value, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG04 >=", value, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04LessThan(Integer value) {
            addCriterion("CBSG04 <", value, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG04 <=", value, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04In(List<Integer> values) {
            addCriterion("CBSG04 in", values, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04NotIn(List<Integer> values) {
            addCriterion("CBSG04 not in", values, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04Between(Integer value1, Integer value2) {
            addCriterion("CBSG04 between", value1, value2, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG04 not between", value1, value2, "cbsg04");
            return (Criteria) this;
        }

        public Criteria andCbsg05IsNull() {
            addCriterion("CBSG05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg05IsNotNull() {
            addCriterion("CBSG05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg05EqualTo(Date value) {
            addCriterion("CBSG05 =", value, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05NotEqualTo(Date value) {
            addCriterion("CBSG05 <>", value, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05GreaterThan(Date value) {
            addCriterion("CBSG05 >", value, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSG05 >=", value, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05LessThan(Date value) {
            addCriterion("CBSG05 <", value, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05LessThanOrEqualTo(Date value) {
            addCriterion("CBSG05 <=", value, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05In(List<Date> values) {
            addCriterion("CBSG05 in", values, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05NotIn(List<Date> values) {
            addCriterion("CBSG05 not in", values, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05Between(Date value1, Date value2) {
            addCriterion("CBSG05 between", value1, value2, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg05NotBetween(Date value1, Date value2) {
            addCriterion("CBSG05 not between", value1, value2, "cbsg05");
            return (Criteria) this;
        }

        public Criteria andCbsg06IsNull() {
            addCriterion("CBSG06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg06IsNotNull() {
            addCriterion("CBSG06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg06EqualTo(Integer value) {
            addCriterion("CBSG06 =", value, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06NotEqualTo(Integer value) {
            addCriterion("CBSG06 <>", value, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06GreaterThan(Integer value) {
            addCriterion("CBSG06 >", value, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG06 >=", value, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06LessThan(Integer value) {
            addCriterion("CBSG06 <", value, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG06 <=", value, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06In(List<Integer> values) {
            addCriterion("CBSG06 in", values, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06NotIn(List<Integer> values) {
            addCriterion("CBSG06 not in", values, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06Between(Integer value1, Integer value2) {
            addCriterion("CBSG06 between", value1, value2, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG06 not between", value1, value2, "cbsg06");
            return (Criteria) this;
        }

        public Criteria andCbsg07IsNull() {
            addCriterion("CBSG07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg07IsNotNull() {
            addCriterion("CBSG07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg07EqualTo(Integer value) {
            addCriterion("CBSG07 =", value, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07NotEqualTo(Integer value) {
            addCriterion("CBSG07 <>", value, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07GreaterThan(Integer value) {
            addCriterion("CBSG07 >", value, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG07 >=", value, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07LessThan(Integer value) {
            addCriterion("CBSG07 <", value, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG07 <=", value, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07In(List<Integer> values) {
            addCriterion("CBSG07 in", values, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07NotIn(List<Integer> values) {
            addCriterion("CBSG07 not in", values, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07Between(Integer value1, Integer value2) {
            addCriterion("CBSG07 between", value1, value2, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG07 not between", value1, value2, "cbsg07");
            return (Criteria) this;
        }

        public Criteria andCbsg08IsNull() {
            addCriterion("CBSG08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg08IsNotNull() {
            addCriterion("CBSG08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg08EqualTo(Integer value) {
            addCriterion("CBSG08 =", value, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08NotEqualTo(Integer value) {
            addCriterion("CBSG08 <>", value, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08GreaterThan(Integer value) {
            addCriterion("CBSG08 >", value, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG08 >=", value, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08LessThan(Integer value) {
            addCriterion("CBSG08 <", value, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG08 <=", value, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08In(List<Integer> values) {
            addCriterion("CBSG08 in", values, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08NotIn(List<Integer> values) {
            addCriterion("CBSG08 not in", values, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08Between(Integer value1, Integer value2) {
            addCriterion("CBSG08 between", value1, value2, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG08 not between", value1, value2, "cbsg08");
            return (Criteria) this;
        }

        public Criteria andCbsg09IsNull() {
            addCriterion("CBSG09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg09IsNotNull() {
            addCriterion("CBSG09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg09EqualTo(String value) {
            addCriterion("CBSG09 =", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09NotEqualTo(String value) {
            addCriterion("CBSG09 <>", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09GreaterThan(String value) {
            addCriterion("CBSG09 >", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09GreaterThanOrEqualTo(String value) {
            addCriterion("CBSG09 >=", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09LessThan(String value) {
            addCriterion("CBSG09 <", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09LessThanOrEqualTo(String value) {
            addCriterion("CBSG09 <=", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09Like(String value) {
            addCriterion("CBSG09 like", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09NotLike(String value) {
            addCriterion("CBSG09 not like", value, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09In(List<String> values) {
            addCriterion("CBSG09 in", values, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09NotIn(List<String> values) {
            addCriterion("CBSG09 not in", values, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09Between(String value1, String value2) {
            addCriterion("CBSG09 between", value1, value2, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg09NotBetween(String value1, String value2) {
            addCriterion("CBSG09 not between", value1, value2, "cbsg09");
            return (Criteria) this;
        }

        public Criteria andCbsg10IsNull() {
            addCriterion("CBSG10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg10IsNotNull() {
            addCriterion("CBSG10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg10EqualTo(Integer value) {
            addCriterion("CBSG10 =", value, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10NotEqualTo(Integer value) {
            addCriterion("CBSG10 <>", value, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10GreaterThan(Integer value) {
            addCriterion("CBSG10 >", value, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG10 >=", value, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10LessThan(Integer value) {
            addCriterion("CBSG10 <", value, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG10 <=", value, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10In(List<Integer> values) {
            addCriterion("CBSG10 in", values, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10NotIn(List<Integer> values) {
            addCriterion("CBSG10 not in", values, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10Between(Integer value1, Integer value2) {
            addCriterion("CBSG10 between", value1, value2, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG10 not between", value1, value2, "cbsg10");
            return (Criteria) this;
        }

        public Criteria andCbsg11IsNull() {
            addCriterion("CBSG11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg11IsNotNull() {
            addCriterion("CBSG11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg11EqualTo(Integer value) {
            addCriterion("CBSG11 =", value, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11NotEqualTo(Integer value) {
            addCriterion("CBSG11 <>", value, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11GreaterThan(Integer value) {
            addCriterion("CBSG11 >", value, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSG11 >=", value, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11LessThan(Integer value) {
            addCriterion("CBSG11 <", value, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11LessThanOrEqualTo(Integer value) {
            addCriterion("CBSG11 <=", value, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11In(List<Integer> values) {
            addCriterion("CBSG11 in", values, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11NotIn(List<Integer> values) {
            addCriterion("CBSG11 not in", values, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11Between(Integer value1, Integer value2) {
            addCriterion("CBSG11 between", value1, value2, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSG11 not between", value1, value2, "cbsg11");
            return (Criteria) this;
        }

        public Criteria andCbsg12IsNull() {
            addCriterion("CBSG12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsg12IsNotNull() {
            addCriterion("CBSG12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsg12EqualTo(String value) {
            addCriterion("CBSG12 =", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12NotEqualTo(String value) {
            addCriterion("CBSG12 <>", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12GreaterThan(String value) {
            addCriterion("CBSG12 >", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12GreaterThanOrEqualTo(String value) {
            addCriterion("CBSG12 >=", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12LessThan(String value) {
            addCriterion("CBSG12 <", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12LessThanOrEqualTo(String value) {
            addCriterion("CBSG12 <=", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12Like(String value) {
            addCriterion("CBSG12 like", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12NotLike(String value) {
            addCriterion("CBSG12 not like", value, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12In(List<String> values) {
            addCriterion("CBSG12 in", values, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12NotIn(List<String> values) {
            addCriterion("CBSG12 not in", values, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12Between(String value1, String value2) {
            addCriterion("CBSG12 between", value1, value2, "cbsg12");
            return (Criteria) this;
        }

        public Criteria andCbsg12NotBetween(String value1, String value2) {
            addCriterion("CBSG12 not between", value1, value2, "cbsg12");
            return (Criteria) this;
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
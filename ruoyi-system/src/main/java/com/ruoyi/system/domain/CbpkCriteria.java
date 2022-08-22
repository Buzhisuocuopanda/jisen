package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpkCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpkCriteria() {
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

        public Criteria andCbpk01IsNull() {
            addCriterion("CBPK01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk01IsNotNull() {
            addCriterion("CBPK01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk01EqualTo(Integer value) {
            addCriterion("CBPK01 =", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01NotEqualTo(Integer value) {
            addCriterion("CBPK01 <>", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01GreaterThan(Integer value) {
            addCriterion("CBPK01 >", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK01 >=", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01LessThan(Integer value) {
            addCriterion("CBPK01 <", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK01 <=", value, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01In(List<Integer> values) {
            addCriterion("CBPK01 in", values, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01NotIn(List<Integer> values) {
            addCriterion("CBPK01 not in", values, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01Between(Integer value1, Integer value2) {
            addCriterion("CBPK01 between", value1, value2, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK01 not between", value1, value2, "cbpk01");
            return (Criteria) this;
        }

        public Criteria andCbpk02IsNull() {
            addCriterion("CBPK02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk02IsNotNull() {
            addCriterion("CBPK02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk02EqualTo(Date value) {
            addCriterion("CBPK02 =", value, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02NotEqualTo(Date value) {
            addCriterion("CBPK02 <>", value, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02GreaterThan(Date value) {
            addCriterion("CBPK02 >", value, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPK02 >=", value, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02LessThan(Date value) {
            addCriterion("CBPK02 <", value, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02LessThanOrEqualTo(Date value) {
            addCriterion("CBPK02 <=", value, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02In(List<Date> values) {
            addCriterion("CBPK02 in", values, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02NotIn(List<Date> values) {
            addCriterion("CBPK02 not in", values, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02Between(Date value1, Date value2) {
            addCriterion("CBPK02 between", value1, value2, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk02NotBetween(Date value1, Date value2) {
            addCriterion("CBPK02 not between", value1, value2, "cbpk02");
            return (Criteria) this;
        }

        public Criteria andCbpk03IsNull() {
            addCriterion("CBPK03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk03IsNotNull() {
            addCriterion("CBPK03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk03EqualTo(Integer value) {
            addCriterion("CBPK03 =", value, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03NotEqualTo(Integer value) {
            addCriterion("CBPK03 <>", value, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03GreaterThan(Integer value) {
            addCriterion("CBPK03 >", value, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK03 >=", value, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03LessThan(Integer value) {
            addCriterion("CBPK03 <", value, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK03 <=", value, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03In(List<Integer> values) {
            addCriterion("CBPK03 in", values, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03NotIn(List<Integer> values) {
            addCriterion("CBPK03 not in", values, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03Between(Integer value1, Integer value2) {
            addCriterion("CBPK03 between", value1, value2, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK03 not between", value1, value2, "cbpk03");
            return (Criteria) this;
        }

        public Criteria andCbpk04IsNull() {
            addCriterion("CBPK04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk04IsNotNull() {
            addCriterion("CBPK04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk04EqualTo(Date value) {
            addCriterion("CBPK04 =", value, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04NotEqualTo(Date value) {
            addCriterion("CBPK04 <>", value, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04GreaterThan(Date value) {
            addCriterion("CBPK04 >", value, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPK04 >=", value, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04LessThan(Date value) {
            addCriterion("CBPK04 <", value, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04LessThanOrEqualTo(Date value) {
            addCriterion("CBPK04 <=", value, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04In(List<Date> values) {
            addCriterion("CBPK04 in", values, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04NotIn(List<Date> values) {
            addCriterion("CBPK04 not in", values, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04Between(Date value1, Date value2) {
            addCriterion("CBPK04 between", value1, value2, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk04NotBetween(Date value1, Date value2) {
            addCriterion("CBPK04 not between", value1, value2, "cbpk04");
            return (Criteria) this;
        }

        public Criteria andCbpk05IsNull() {
            addCriterion("CBPK05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk05IsNotNull() {
            addCriterion("CBPK05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk05EqualTo(Integer value) {
            addCriterion("CBPK05 =", value, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05NotEqualTo(Integer value) {
            addCriterion("CBPK05 <>", value, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05GreaterThan(Integer value) {
            addCriterion("CBPK05 >", value, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK05 >=", value, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05LessThan(Integer value) {
            addCriterion("CBPK05 <", value, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK05 <=", value, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05In(List<Integer> values) {
            addCriterion("CBPK05 in", values, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05NotIn(List<Integer> values) {
            addCriterion("CBPK05 not in", values, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05Between(Integer value1, Integer value2) {
            addCriterion("CBPK05 between", value1, value2, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK05 not between", value1, value2, "cbpk05");
            return (Criteria) this;
        }

        public Criteria andCbpk06IsNull() {
            addCriterion("CBPK06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk06IsNotNull() {
            addCriterion("CBPK06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk06EqualTo(Integer value) {
            addCriterion("CBPK06 =", value, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06NotEqualTo(Integer value) {
            addCriterion("CBPK06 <>", value, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06GreaterThan(Integer value) {
            addCriterion("CBPK06 >", value, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK06 >=", value, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06LessThan(Integer value) {
            addCriterion("CBPK06 <", value, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK06 <=", value, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06In(List<Integer> values) {
            addCriterion("CBPK06 in", values, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06NotIn(List<Integer> values) {
            addCriterion("CBPK06 not in", values, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06Between(Integer value1, Integer value2) {
            addCriterion("CBPK06 between", value1, value2, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK06 not between", value1, value2, "cbpk06");
            return (Criteria) this;
        }

        public Criteria andCbpk07IsNull() {
            addCriterion("CBPK07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk07IsNotNull() {
            addCriterion("CBPK07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk07EqualTo(String value) {
            addCriterion("CBPK07 =", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07NotEqualTo(String value) {
            addCriterion("CBPK07 <>", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07GreaterThan(String value) {
            addCriterion("CBPK07 >", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK07 >=", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07LessThan(String value) {
            addCriterion("CBPK07 <", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07LessThanOrEqualTo(String value) {
            addCriterion("CBPK07 <=", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07Like(String value) {
            addCriterion("CBPK07 like", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07NotLike(String value) {
            addCriterion("CBPK07 not like", value, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07In(List<String> values) {
            addCriterion("CBPK07 in", values, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07NotIn(List<String> values) {
            addCriterion("CBPK07 not in", values, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07Between(String value1, String value2) {
            addCriterion("CBPK07 between", value1, value2, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk07NotBetween(String value1, String value2) {
            addCriterion("CBPK07 not between", value1, value2, "cbpk07");
            return (Criteria) this;
        }

        public Criteria andCbpk08IsNull() {
            addCriterion("CBPK08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk08IsNotNull() {
            addCriterion("CBPK08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk08EqualTo(Date value) {
            addCriterion("CBPK08 =", value, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08NotEqualTo(Date value) {
            addCriterion("CBPK08 <>", value, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08GreaterThan(Date value) {
            addCriterion("CBPK08 >", value, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPK08 >=", value, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08LessThan(Date value) {
            addCriterion("CBPK08 <", value, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08LessThanOrEqualTo(Date value) {
            addCriterion("CBPK08 <=", value, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08In(List<Date> values) {
            addCriterion("CBPK08 in", values, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08NotIn(List<Date> values) {
            addCriterion("CBPK08 not in", values, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08Between(Date value1, Date value2) {
            addCriterion("CBPK08 between", value1, value2, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk08NotBetween(Date value1, Date value2) {
            addCriterion("CBPK08 not between", value1, value2, "cbpk08");
            return (Criteria) this;
        }

        public Criteria andCbpk09IsNull() {
            addCriterion("CBPK09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk09IsNotNull() {
            addCriterion("CBPK09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk09EqualTo(Integer value) {
            addCriterion("CBPK09 =", value, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09NotEqualTo(Integer value) {
            addCriterion("CBPK09 <>", value, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09GreaterThan(Integer value) {
            addCriterion("CBPK09 >", value, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK09 >=", value, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09LessThan(Integer value) {
            addCriterion("CBPK09 <", value, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK09 <=", value, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09In(List<Integer> values) {
            addCriterion("CBPK09 in", values, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09NotIn(List<Integer> values) {
            addCriterion("CBPK09 not in", values, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09Between(Integer value1, Integer value2) {
            addCriterion("CBPK09 between", value1, value2, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK09 not between", value1, value2, "cbpk09");
            return (Criteria) this;
        }

        public Criteria andCbpk10IsNull() {
            addCriterion("CBPK10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk10IsNotNull() {
            addCriterion("CBPK10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk10EqualTo(Integer value) {
            addCriterion("CBPK10 =", value, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10NotEqualTo(Integer value) {
            addCriterion("CBPK10 <>", value, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10GreaterThan(Integer value) {
            addCriterion("CBPK10 >", value, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK10 >=", value, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10LessThan(Integer value) {
            addCriterion("CBPK10 <", value, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK10 <=", value, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10In(List<Integer> values) {
            addCriterion("CBPK10 in", values, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10NotIn(List<Integer> values) {
            addCriterion("CBPK10 not in", values, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10Between(Integer value1, Integer value2) {
            addCriterion("CBPK10 between", value1, value2, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK10 not between", value1, value2, "cbpk10");
            return (Criteria) this;
        }

        public Criteria andCbpk11IsNull() {
            addCriterion("CBPK11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk11IsNotNull() {
            addCriterion("CBPK11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk11EqualTo(Integer value) {
            addCriterion("CBPK11 =", value, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11NotEqualTo(Integer value) {
            addCriterion("CBPK11 <>", value, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11GreaterThan(Integer value) {
            addCriterion("CBPK11 >", value, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK11 >=", value, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11LessThan(Integer value) {
            addCriterion("CBPK11 <", value, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK11 <=", value, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11In(List<Integer> values) {
            addCriterion("CBPK11 in", values, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11NotIn(List<Integer> values) {
            addCriterion("CBPK11 not in", values, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11Between(Integer value1, Integer value2) {
            addCriterion("CBPK11 between", value1, value2, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK11 not between", value1, value2, "cbpk11");
            return (Criteria) this;
        }

        public Criteria andCbpk12IsNull() {
            addCriterion("CBPK12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk12IsNotNull() {
            addCriterion("CBPK12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk12EqualTo(Integer value) {
            addCriterion("CBPK12 =", value, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12NotEqualTo(Integer value) {
            addCriterion("CBPK12 <>", value, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12GreaterThan(Integer value) {
            addCriterion("CBPK12 >", value, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK12 >=", value, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12LessThan(Integer value) {
            addCriterion("CBPK12 <", value, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK12 <=", value, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12In(List<Integer> values) {
            addCriterion("CBPK12 in", values, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12NotIn(List<Integer> values) {
            addCriterion("CBPK12 not in", values, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12Between(Integer value1, Integer value2) {
            addCriterion("CBPK12 between", value1, value2, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK12 not between", value1, value2, "cbpk12");
            return (Criteria) this;
        }

        public Criteria andCbpk13IsNull() {
            addCriterion("CBPK13 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk13IsNotNull() {
            addCriterion("CBPK13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk13EqualTo(Date value) {
            addCriterion("CBPK13 =", value, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13NotEqualTo(Date value) {
            addCriterion("CBPK13 <>", value, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13GreaterThan(Date value) {
            addCriterion("CBPK13 >", value, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPK13 >=", value, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13LessThan(Date value) {
            addCriterion("CBPK13 <", value, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13LessThanOrEqualTo(Date value) {
            addCriterion("CBPK13 <=", value, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13In(List<Date> values) {
            addCriterion("CBPK13 in", values, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13NotIn(List<Date> values) {
            addCriterion("CBPK13 not in", values, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13Between(Date value1, Date value2) {
            addCriterion("CBPK13 between", value1, value2, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk13NotBetween(Date value1, Date value2) {
            addCriterion("CBPK13 not between", value1, value2, "cbpk13");
            return (Criteria) this;
        }

        public Criteria andCbpk14IsNull() {
            addCriterion("CBPK14 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk14IsNotNull() {
            addCriterion("CBPK14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk14EqualTo(Integer value) {
            addCriterion("CBPK14 =", value, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14NotEqualTo(Integer value) {
            addCriterion("CBPK14 <>", value, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14GreaterThan(Integer value) {
            addCriterion("CBPK14 >", value, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK14 >=", value, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14LessThan(Integer value) {
            addCriterion("CBPK14 <", value, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK14 <=", value, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14In(List<Integer> values) {
            addCriterion("CBPK14 in", values, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14NotIn(List<Integer> values) {
            addCriterion("CBPK14 not in", values, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14Between(Integer value1, Integer value2) {
            addCriterion("CBPK14 between", value1, value2, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK14 not between", value1, value2, "cbpk14");
            return (Criteria) this;
        }

        public Criteria andCbpk15IsNull() {
            addCriterion("CBPK15 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk15IsNotNull() {
            addCriterion("CBPK15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk15EqualTo(Date value) {
            addCriterion("CBPK15 =", value, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15NotEqualTo(Date value) {
            addCriterion("CBPK15 <>", value, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15GreaterThan(Date value) {
            addCriterion("CBPK15 >", value, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPK15 >=", value, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15LessThan(Date value) {
            addCriterion("CBPK15 <", value, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15LessThanOrEqualTo(Date value) {
            addCriterion("CBPK15 <=", value, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15In(List<Date> values) {
            addCriterion("CBPK15 in", values, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15NotIn(List<Date> values) {
            addCriterion("CBPK15 not in", values, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15Between(Date value1, Date value2) {
            addCriterion("CBPK15 between", value1, value2, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk15NotBetween(Date value1, Date value2) {
            addCriterion("CBPK15 not between", value1, value2, "cbpk15");
            return (Criteria) this;
        }

        public Criteria andCbpk16IsNull() {
            addCriterion("CBPK16 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk16IsNotNull() {
            addCriterion("CBPK16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk16EqualTo(Integer value) {
            addCriterion("CBPK16 =", value, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16NotEqualTo(Integer value) {
            addCriterion("CBPK16 <>", value, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16GreaterThan(Integer value) {
            addCriterion("CBPK16 >", value, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK16 >=", value, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16LessThan(Integer value) {
            addCriterion("CBPK16 <", value, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK16 <=", value, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16In(List<Integer> values) {
            addCriterion("CBPK16 in", values, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16NotIn(List<Integer> values) {
            addCriterion("CBPK16 not in", values, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16Between(Integer value1, Integer value2) {
            addCriterion("CBPK16 between", value1, value2, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK16 not between", value1, value2, "cbpk16");
            return (Criteria) this;
        }

        public Criteria andCbpk17IsNull() {
            addCriterion("CBPK17 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk17IsNotNull() {
            addCriterion("CBPK17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk17EqualTo(Integer value) {
            addCriterion("CBPK17 =", value, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17NotEqualTo(Integer value) {
            addCriterion("CBPK17 <>", value, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17GreaterThan(Integer value) {
            addCriterion("CBPK17 >", value, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK17 >=", value, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17LessThan(Integer value) {
            addCriterion("CBPK17 <", value, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK17 <=", value, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17In(List<Integer> values) {
            addCriterion("CBPK17 in", values, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17NotIn(List<Integer> values) {
            addCriterion("CBPK17 not in", values, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17Between(Integer value1, Integer value2) {
            addCriterion("CBPK17 between", value1, value2, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk17NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK17 not between", value1, value2, "cbpk17");
            return (Criteria) this;
        }

        public Criteria andCbpk18IsNull() {
            addCriterion("CBPK18 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk18IsNotNull() {
            addCriterion("CBPK18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk18EqualTo(String value) {
            addCriterion("CBPK18 =", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18NotEqualTo(String value) {
            addCriterion("CBPK18 <>", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18GreaterThan(String value) {
            addCriterion("CBPK18 >", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK18 >=", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18LessThan(String value) {
            addCriterion("CBPK18 <", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18LessThanOrEqualTo(String value) {
            addCriterion("CBPK18 <=", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18Like(String value) {
            addCriterion("CBPK18 like", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18NotLike(String value) {
            addCriterion("CBPK18 not like", value, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18In(List<String> values) {
            addCriterion("CBPK18 in", values, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18NotIn(List<String> values) {
            addCriterion("CBPK18 not in", values, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18Between(String value1, String value2) {
            addCriterion("CBPK18 between", value1, value2, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk18NotBetween(String value1, String value2) {
            addCriterion("CBPK18 not between", value1, value2, "cbpk18");
            return (Criteria) this;
        }

        public Criteria andCbpk19IsNull() {
            addCriterion("CBPK19 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk19IsNotNull() {
            addCriterion("CBPK19 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk19EqualTo(String value) {
            addCriterion("CBPK19 =", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19NotEqualTo(String value) {
            addCriterion("CBPK19 <>", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19GreaterThan(String value) {
            addCriterion("CBPK19 >", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK19 >=", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19LessThan(String value) {
            addCriterion("CBPK19 <", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19LessThanOrEqualTo(String value) {
            addCriterion("CBPK19 <=", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19Like(String value) {
            addCriterion("CBPK19 like", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19NotLike(String value) {
            addCriterion("CBPK19 not like", value, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19In(List<String> values) {
            addCriterion("CBPK19 in", values, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19NotIn(List<String> values) {
            addCriterion("CBPK19 not in", values, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19Between(String value1, String value2) {
            addCriterion("CBPK19 between", value1, value2, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk19NotBetween(String value1, String value2) {
            addCriterion("CBPK19 not between", value1, value2, "cbpk19");
            return (Criteria) this;
        }

        public Criteria andCbpk20IsNull() {
            addCriterion("CBPK20 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk20IsNotNull() {
            addCriterion("CBPK20 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk20EqualTo(Integer value) {
            addCriterion("CBPK20 =", value, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20NotEqualTo(Integer value) {
            addCriterion("CBPK20 <>", value, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20GreaterThan(Integer value) {
            addCriterion("CBPK20 >", value, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK20 >=", value, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20LessThan(Integer value) {
            addCriterion("CBPK20 <", value, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK20 <=", value, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20In(List<Integer> values) {
            addCriterion("CBPK20 in", values, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20NotIn(List<Integer> values) {
            addCriterion("CBPK20 not in", values, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20Between(Integer value1, Integer value2) {
            addCriterion("CBPK20 between", value1, value2, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk20NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK20 not between", value1, value2, "cbpk20");
            return (Criteria) this;
        }

        public Criteria andCbpk21IsNull() {
            addCriterion("CBPK21 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk21IsNotNull() {
            addCriterion("CBPK21 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk21EqualTo(String value) {
            addCriterion("CBPK21 =", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21NotEqualTo(String value) {
            addCriterion("CBPK21 <>", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21GreaterThan(String value) {
            addCriterion("CBPK21 >", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK21 >=", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21LessThan(String value) {
            addCriterion("CBPK21 <", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21LessThanOrEqualTo(String value) {
            addCriterion("CBPK21 <=", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21Like(String value) {
            addCriterion("CBPK21 like", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21NotLike(String value) {
            addCriterion("CBPK21 not like", value, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21In(List<String> values) {
            addCriterion("CBPK21 in", values, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21NotIn(List<String> values) {
            addCriterion("CBPK21 not in", values, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21Between(String value1, String value2) {
            addCriterion("CBPK21 between", value1, value2, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk21NotBetween(String value1, String value2) {
            addCriterion("CBPK21 not between", value1, value2, "cbpk21");
            return (Criteria) this;
        }

        public Criteria andCbpk22IsNull() {
            addCriterion("CBPK22 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk22IsNotNull() {
            addCriterion("CBPK22 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk22EqualTo(String value) {
            addCriterion("CBPK22 =", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22NotEqualTo(String value) {
            addCriterion("CBPK22 <>", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22GreaterThan(String value) {
            addCriterion("CBPK22 >", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK22 >=", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22LessThan(String value) {
            addCriterion("CBPK22 <", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22LessThanOrEqualTo(String value) {
            addCriterion("CBPK22 <=", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22Like(String value) {
            addCriterion("CBPK22 like", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22NotLike(String value) {
            addCriterion("CBPK22 not like", value, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22In(List<String> values) {
            addCriterion("CBPK22 in", values, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22NotIn(List<String> values) {
            addCriterion("CBPK22 not in", values, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22Between(String value1, String value2) {
            addCriterion("CBPK22 between", value1, value2, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk22NotBetween(String value1, String value2) {
            addCriterion("CBPK22 not between", value1, value2, "cbpk22");
            return (Criteria) this;
        }

        public Criteria andCbpk23IsNull() {
            addCriterion("CBPK23 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk23IsNotNull() {
            addCriterion("CBPK23 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk23EqualTo(String value) {
            addCriterion("CBPK23 =", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23NotEqualTo(String value) {
            addCriterion("CBPK23 <>", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23GreaterThan(String value) {
            addCriterion("CBPK23 >", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK23 >=", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23LessThan(String value) {
            addCriterion("CBPK23 <", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23LessThanOrEqualTo(String value) {
            addCriterion("CBPK23 <=", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23Like(String value) {
            addCriterion("CBPK23 like", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23NotLike(String value) {
            addCriterion("CBPK23 not like", value, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23In(List<String> values) {
            addCriterion("CBPK23 in", values, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23NotIn(List<String> values) {
            addCriterion("CBPK23 not in", values, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23Between(String value1, String value2) {
            addCriterion("CBPK23 between", value1, value2, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk23NotBetween(String value1, String value2) {
            addCriterion("CBPK23 not between", value1, value2, "cbpk23");
            return (Criteria) this;
        }

        public Criteria andCbpk24IsNull() {
            addCriterion("CBPK24 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk24IsNotNull() {
            addCriterion("CBPK24 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk24EqualTo(String value) {
            addCriterion("CBPK24 =", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24NotEqualTo(String value) {
            addCriterion("CBPK24 <>", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24GreaterThan(String value) {
            addCriterion("CBPK24 >", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK24 >=", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24LessThan(String value) {
            addCriterion("CBPK24 <", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24LessThanOrEqualTo(String value) {
            addCriterion("CBPK24 <=", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24Like(String value) {
            addCriterion("CBPK24 like", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24NotLike(String value) {
            addCriterion("CBPK24 not like", value, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24In(List<String> values) {
            addCriterion("CBPK24 in", values, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24NotIn(List<String> values) {
            addCriterion("CBPK24 not in", values, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24Between(String value1, String value2) {
            addCriterion("CBPK24 between", value1, value2, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk24NotBetween(String value1, String value2) {
            addCriterion("CBPK24 not between", value1, value2, "cbpk24");
            return (Criteria) this;
        }

        public Criteria andCbpk25IsNull() {
            addCriterion("CBPK25 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk25IsNotNull() {
            addCriterion("CBPK25 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk25EqualTo(String value) {
            addCriterion("CBPK25 =", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25NotEqualTo(String value) {
            addCriterion("CBPK25 <>", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25GreaterThan(String value) {
            addCriterion("CBPK25 >", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK25 >=", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25LessThan(String value) {
            addCriterion("CBPK25 <", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25LessThanOrEqualTo(String value) {
            addCriterion("CBPK25 <=", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25Like(String value) {
            addCriterion("CBPK25 like", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25NotLike(String value) {
            addCriterion("CBPK25 not like", value, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25In(List<String> values) {
            addCriterion("CBPK25 in", values, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25NotIn(List<String> values) {
            addCriterion("CBPK25 not in", values, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25Between(String value1, String value2) {
            addCriterion("CBPK25 between", value1, value2, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk25NotBetween(String value1, String value2) {
            addCriterion("CBPK25 not between", value1, value2, "cbpk25");
            return (Criteria) this;
        }

        public Criteria andCbpk26IsNull() {
            addCriterion("CBPK26 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk26IsNotNull() {
            addCriterion("CBPK26 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk26EqualTo(String value) {
            addCriterion("CBPK26 =", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26NotEqualTo(String value) {
            addCriterion("CBPK26 <>", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26GreaterThan(String value) {
            addCriterion("CBPK26 >", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK26 >=", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26LessThan(String value) {
            addCriterion("CBPK26 <", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26LessThanOrEqualTo(String value) {
            addCriterion("CBPK26 <=", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26Like(String value) {
            addCriterion("CBPK26 like", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26NotLike(String value) {
            addCriterion("CBPK26 not like", value, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26In(List<String> values) {
            addCriterion("CBPK26 in", values, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26NotIn(List<String> values) {
            addCriterion("CBPK26 not in", values, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26Between(String value1, String value2) {
            addCriterion("CBPK26 between", value1, value2, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk26NotBetween(String value1, String value2) {
            addCriterion("CBPK26 not between", value1, value2, "cbpk26");
            return (Criteria) this;
        }

        public Criteria andCbpk27IsNull() {
            addCriterion("CBPK27 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk27IsNotNull() {
            addCriterion("CBPK27 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk27EqualTo(String value) {
            addCriterion("CBPK27 =", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27NotEqualTo(String value) {
            addCriterion("CBPK27 <>", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27GreaterThan(String value) {
            addCriterion("CBPK27 >", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK27 >=", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27LessThan(String value) {
            addCriterion("CBPK27 <", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27LessThanOrEqualTo(String value) {
            addCriterion("CBPK27 <=", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27Like(String value) {
            addCriterion("CBPK27 like", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27NotLike(String value) {
            addCriterion("CBPK27 not like", value, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27In(List<String> values) {
            addCriterion("CBPK27 in", values, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27NotIn(List<String> values) {
            addCriterion("CBPK27 not in", values, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27Between(String value1, String value2) {
            addCriterion("CBPK27 between", value1, value2, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk27NotBetween(String value1, String value2) {
            addCriterion("CBPK27 not between", value1, value2, "cbpk27");
            return (Criteria) this;
        }

        public Criteria andCbpk28IsNull() {
            addCriterion("CBPK28 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk28IsNotNull() {
            addCriterion("CBPK28 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk28EqualTo(String value) {
            addCriterion("CBPK28 =", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28NotEqualTo(String value) {
            addCriterion("CBPK28 <>", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28GreaterThan(String value) {
            addCriterion("CBPK28 >", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK28 >=", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28LessThan(String value) {
            addCriterion("CBPK28 <", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28LessThanOrEqualTo(String value) {
            addCriterion("CBPK28 <=", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28Like(String value) {
            addCriterion("CBPK28 like", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28NotLike(String value) {
            addCriterion("CBPK28 not like", value, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28In(List<String> values) {
            addCriterion("CBPK28 in", values, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28NotIn(List<String> values) {
            addCriterion("CBPK28 not in", values, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28Between(String value1, String value2) {
            addCriterion("CBPK28 between", value1, value2, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk28NotBetween(String value1, String value2) {
            addCriterion("CBPK28 not between", value1, value2, "cbpk28");
            return (Criteria) this;
        }

        public Criteria andCbpk29IsNull() {
            addCriterion("CBPK29 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk29IsNotNull() {
            addCriterion("CBPK29 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk29EqualTo(String value) {
            addCriterion("CBPK29 =", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29NotEqualTo(String value) {
            addCriterion("CBPK29 <>", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29GreaterThan(String value) {
            addCriterion("CBPK29 >", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK29 >=", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29LessThan(String value) {
            addCriterion("CBPK29 <", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29LessThanOrEqualTo(String value) {
            addCriterion("CBPK29 <=", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29Like(String value) {
            addCriterion("CBPK29 like", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29NotLike(String value) {
            addCriterion("CBPK29 not like", value, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29In(List<String> values) {
            addCriterion("CBPK29 in", values, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29NotIn(List<String> values) {
            addCriterion("CBPK29 not in", values, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29Between(String value1, String value2) {
            addCriterion("CBPK29 between", value1, value2, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk29NotBetween(String value1, String value2) {
            addCriterion("CBPK29 not between", value1, value2, "cbpk29");
            return (Criteria) this;
        }

        public Criteria andCbpk30IsNull() {
            addCriterion("CBPK30 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk30IsNotNull() {
            addCriterion("CBPK30 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk30EqualTo(String value) {
            addCriterion("CBPK30 =", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30NotEqualTo(String value) {
            addCriterion("CBPK30 <>", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30GreaterThan(String value) {
            addCriterion("CBPK30 >", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30GreaterThanOrEqualTo(String value) {
            addCriterion("CBPK30 >=", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30LessThan(String value) {
            addCriterion("CBPK30 <", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30LessThanOrEqualTo(String value) {
            addCriterion("CBPK30 <=", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30Like(String value) {
            addCriterion("CBPK30 like", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30NotLike(String value) {
            addCriterion("CBPK30 not like", value, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30In(List<String> values) {
            addCriterion("CBPK30 in", values, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30NotIn(List<String> values) {
            addCriterion("CBPK30 not in", values, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30Between(String value1, String value2) {
            addCriterion("CBPK30 between", value1, value2, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk30NotBetween(String value1, String value2) {
            addCriterion("CBPK30 not between", value1, value2, "cbpk30");
            return (Criteria) this;
        }

        public Criteria andCbpk31IsNull() {
            addCriterion("CBPK31 is null");
            return (Criteria) this;
        }

        public Criteria andCbpk31IsNotNull() {
            addCriterion("CBPK31 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpk31EqualTo(Integer value) {
            addCriterion("CBPK31 =", value, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31NotEqualTo(Integer value) {
            addCriterion("CBPK31 <>", value, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31GreaterThan(Integer value) {
            addCriterion("CBPK31 >", value, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPK31 >=", value, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31LessThan(Integer value) {
            addCriterion("CBPK31 <", value, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31LessThanOrEqualTo(Integer value) {
            addCriterion("CBPK31 <=", value, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31In(List<Integer> values) {
            addCriterion("CBPK31 in", values, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31NotIn(List<Integer> values) {
            addCriterion("CBPK31 not in", values, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31Between(Integer value1, Integer value2) {
            addCriterion("CBPK31 between", value1, value2, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCbpk31NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPK31 not between", value1, value2, "cbpk31");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Byte value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Byte value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Byte value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Byte value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Byte value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Byte> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Byte> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Byte value1, Byte value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoIsNull() {
            addCriterion("sale_order_no is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoIsNotNull() {
            addCriterion("sale_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoEqualTo(String value) {
            addCriterion("sale_order_no =", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotEqualTo(String value) {
            addCriterion("sale_order_no <>", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoGreaterThan(String value) {
            addCriterion("sale_order_no >", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("sale_order_no >=", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoLessThan(String value) {
            addCriterion("sale_order_no <", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoLessThanOrEqualTo(String value) {
            addCriterion("sale_order_no <=", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoLike(String value) {
            addCriterion("sale_order_no like", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotLike(String value) {
            addCriterion("sale_order_no not like", value, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoIn(List<String> values) {
            addCriterion("sale_order_no in", values, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotIn(List<String> values) {
            addCriterion("sale_order_no not in", values, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoBetween(String value1, String value2) {
            addCriterion("sale_order_no between", value1, value2, "saleOrderNo");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNoNotBetween(String value1, String value2) {
            addCriterion("sale_order_no not between", value1, value2, "saleOrderNo");
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
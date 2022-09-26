package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CboaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CboaCriteria() {
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

        public Criteria andCboa01IsNull() {
            addCriterion("CBOA01 is null");
            return (Criteria) this;
        }

        public Criteria andCboa01IsNotNull() {
            addCriterion("CBOA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa01EqualTo(Integer value) {
            addCriterion("CBOA01 =", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01NotEqualTo(Integer value) {
            addCriterion("CBOA01 <>", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01GreaterThan(Integer value) {
            addCriterion("CBOA01 >", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA01 >=", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01LessThan(Integer value) {
            addCriterion("CBOA01 <", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA01 <=", value, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01In(List<Integer> values) {
            addCriterion("CBOA01 in", values, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01NotIn(List<Integer> values) {
            addCriterion("CBOA01 not in", values, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01Between(Integer value1, Integer value2) {
            addCriterion("CBOA01 between", value1, value2, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA01 not between", value1, value2, "cboa01");
            return (Criteria) this;
        }

        public Criteria andCboa02IsNull() {
            addCriterion("CBOA02 is null");
            return (Criteria) this;
        }

        public Criteria andCboa02IsNotNull() {
            addCriterion("CBOA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa02EqualTo(Date value) {
            addCriterion("CBOA02 =", value, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02NotEqualTo(Date value) {
            addCriterion("CBOA02 <>", value, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02GreaterThan(Date value) {
            addCriterion("CBOA02 >", value, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOA02 >=", value, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02LessThan(Date value) {
            addCriterion("CBOA02 <", value, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02LessThanOrEqualTo(Date value) {
            addCriterion("CBOA02 <=", value, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02In(List<Date> values) {
            addCriterion("CBOA02 in", values, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02NotIn(List<Date> values) {
            addCriterion("CBOA02 not in", values, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02Between(Date value1, Date value2) {
            addCriterion("CBOA02 between", value1, value2, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa02NotBetween(Date value1, Date value2) {
            addCriterion("CBOA02 not between", value1, value2, "cboa02");
            return (Criteria) this;
        }

        public Criteria andCboa03IsNull() {
            addCriterion("CBOA03 is null");
            return (Criteria) this;
        }

        public Criteria andCboa03IsNotNull() {
            addCriterion("CBOA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa03EqualTo(Integer value) {
            addCriterion("CBOA03 =", value, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03NotEqualTo(Integer value) {
            addCriterion("CBOA03 <>", value, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03GreaterThan(Integer value) {
            addCriterion("CBOA03 >", value, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA03 >=", value, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03LessThan(Integer value) {
            addCriterion("CBOA03 <", value, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA03 <=", value, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03In(List<Integer> values) {
            addCriterion("CBOA03 in", values, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03NotIn(List<Integer> values) {
            addCriterion("CBOA03 not in", values, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03Between(Integer value1, Integer value2) {
            addCriterion("CBOA03 between", value1, value2, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA03 not between", value1, value2, "cboa03");
            return (Criteria) this;
        }

        public Criteria andCboa04IsNull() {
            addCriterion("CBOA04 is null");
            return (Criteria) this;
        }

        public Criteria andCboa04IsNotNull() {
            addCriterion("CBOA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa04EqualTo(Date value) {
            addCriterion("CBOA04 =", value, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04NotEqualTo(Date value) {
            addCriterion("CBOA04 <>", value, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04GreaterThan(Date value) {
            addCriterion("CBOA04 >", value, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOA04 >=", value, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04LessThan(Date value) {
            addCriterion("CBOA04 <", value, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04LessThanOrEqualTo(Date value) {
            addCriterion("CBOA04 <=", value, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04In(List<Date> values) {
            addCriterion("CBOA04 in", values, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04NotIn(List<Date> values) {
            addCriterion("CBOA04 not in", values, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04Between(Date value1, Date value2) {
            addCriterion("CBOA04 between", value1, value2, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa04NotBetween(Date value1, Date value2) {
            addCriterion("CBOA04 not between", value1, value2, "cboa04");
            return (Criteria) this;
        }

        public Criteria andCboa05IsNull() {
            addCriterion("CBOA05 is null");
            return (Criteria) this;
        }

        public Criteria andCboa05IsNotNull() {
            addCriterion("CBOA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa05EqualTo(Integer value) {
            addCriterion("CBOA05 =", value, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05NotEqualTo(Integer value) {
            addCriterion("CBOA05 <>", value, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05GreaterThan(Integer value) {
            addCriterion("CBOA05 >", value, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA05 >=", value, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05LessThan(Integer value) {
            addCriterion("CBOA05 <", value, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA05 <=", value, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05In(List<Integer> values) {
            addCriterion("CBOA05 in", values, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05NotIn(List<Integer> values) {
            addCriterion("CBOA05 not in", values, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05Between(Integer value1, Integer value2) {
            addCriterion("CBOA05 between", value1, value2, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA05 not between", value1, value2, "cboa05");
            return (Criteria) this;
        }

        public Criteria andCboa06IsNull() {
            addCriterion("CBOA06 is null");
            return (Criteria) this;
        }

        public Criteria andCboa06IsNotNull() {
            addCriterion("CBOA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa06EqualTo(Integer value) {
            addCriterion("CBOA06 =", value, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06NotEqualTo(Integer value) {
            addCriterion("CBOA06 <>", value, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06GreaterThan(Integer value) {
            addCriterion("CBOA06 >", value, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA06 >=", value, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06LessThan(Integer value) {
            addCriterion("CBOA06 <", value, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA06 <=", value, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06In(List<Integer> values) {
            addCriterion("CBOA06 in", values, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06NotIn(List<Integer> values) {
            addCriterion("CBOA06 not in", values, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06Between(Integer value1, Integer value2) {
            addCriterion("CBOA06 between", value1, value2, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA06 not between", value1, value2, "cboa06");
            return (Criteria) this;
        }

        public Criteria andCboa07IsNull() {
            addCriterion("CBOA07 is null");
            return (Criteria) this;
        }

        public Criteria andCboa07IsNotNull() {
            addCriterion("CBOA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa07EqualTo(String value) {
            addCriterion("CBOA07 =", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07NotEqualTo(String value) {
            addCriterion("CBOA07 <>", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07GreaterThan(String value) {
            addCriterion("CBOA07 >", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA07 >=", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07LessThan(String value) {
            addCriterion("CBOA07 <", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07LessThanOrEqualTo(String value) {
            addCriterion("CBOA07 <=", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07Like(String value) {
            addCriterion("CBOA07 like", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07NotLike(String value) {
            addCriterion("CBOA07 not like", value, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07In(List<String> values) {
            addCriterion("CBOA07 in", values, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07NotIn(List<String> values) {
            addCriterion("CBOA07 not in", values, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07Between(String value1, String value2) {
            addCriterion("CBOA07 between", value1, value2, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa07NotBetween(String value1, String value2) {
            addCriterion("CBOA07 not between", value1, value2, "cboa07");
            return (Criteria) this;
        }

        public Criteria andCboa08IsNull() {
            addCriterion("CBOA08 is null");
            return (Criteria) this;
        }

        public Criteria andCboa08IsNotNull() {
            addCriterion("CBOA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa08EqualTo(Date value) {
            addCriterion("CBOA08 =", value, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08NotEqualTo(Date value) {
            addCriterion("CBOA08 <>", value, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08GreaterThan(Date value) {
            addCriterion("CBOA08 >", value, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOA08 >=", value, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08LessThan(Date value) {
            addCriterion("CBOA08 <", value, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08LessThanOrEqualTo(Date value) {
            addCriterion("CBOA08 <=", value, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08In(List<Date> values) {
            addCriterion("CBOA08 in", values, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08NotIn(List<Date> values) {
            addCriterion("CBOA08 not in", values, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08Between(Date value1, Date value2) {
            addCriterion("CBOA08 between", value1, value2, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa08NotBetween(Date value1, Date value2) {
            addCriterion("CBOA08 not between", value1, value2, "cboa08");
            return (Criteria) this;
        }

        public Criteria andCboa09IsNull() {
            addCriterion("CBOA09 is null");
            return (Criteria) this;
        }

        public Criteria andCboa09IsNotNull() {
            addCriterion("CBOA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa09EqualTo(Integer value) {
            addCriterion("CBOA09 =", value, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09NotEqualTo(Integer value) {
            addCriterion("CBOA09 <>", value, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09GreaterThan(Integer value) {
            addCriterion("CBOA09 >", value, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA09 >=", value, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09LessThan(Integer value) {
            addCriterion("CBOA09 <", value, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA09 <=", value, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09In(List<Integer> values) {
            addCriterion("CBOA09 in", values, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09NotIn(List<Integer> values) {
            addCriterion("CBOA09 not in", values, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09Between(Integer value1, Integer value2) {
            addCriterion("CBOA09 between", value1, value2, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA09 not between", value1, value2, "cboa09");
            return (Criteria) this;
        }

        public Criteria andCboa10IsNull() {
            addCriterion("CBOA10 is null");
            return (Criteria) this;
        }

        public Criteria andCboa10IsNotNull() {
            addCriterion("CBOA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa10EqualTo(Integer value) {
            addCriterion("CBOA10 =", value, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10NotEqualTo(Integer value) {
            addCriterion("CBOA10 <>", value, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10GreaterThan(Integer value) {
            addCriterion("CBOA10 >", value, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA10 >=", value, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10LessThan(Integer value) {
            addCriterion("CBOA10 <", value, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA10 <=", value, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10In(List<Integer> values) {
            addCriterion("CBOA10 in", values, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10NotIn(List<Integer> values) {
            addCriterion("CBOA10 not in", values, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10Between(Integer value1, Integer value2) {
            addCriterion("CBOA10 between", value1, value2, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA10 not between", value1, value2, "cboa10");
            return (Criteria) this;
        }

        public Criteria andCboa11IsNull() {
            addCriterion("CBOA11 is null");
            return (Criteria) this;
        }

        public Criteria andCboa11IsNotNull() {
            addCriterion("CBOA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa11EqualTo(Integer value) {
            addCriterion("CBOA11 =", value, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11NotEqualTo(Integer value) {
            addCriterion("CBOA11 <>", value, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11GreaterThan(Integer value) {
            addCriterion("CBOA11 >", value, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA11 >=", value, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11LessThan(Integer value) {
            addCriterion("CBOA11 <", value, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA11 <=", value, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11In(List<Integer> values) {
            addCriterion("CBOA11 in", values, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11NotIn(List<Integer> values) {
            addCriterion("CBOA11 not in", values, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11Between(Integer value1, Integer value2) {
            addCriterion("CBOA11 between", value1, value2, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA11 not between", value1, value2, "cboa11");
            return (Criteria) this;
        }

        public Criteria andCboa12IsNull() {
            addCriterion("CBOA12 is null");
            return (Criteria) this;
        }

        public Criteria andCboa12IsNotNull() {
            addCriterion("CBOA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa12EqualTo(Integer value) {
            addCriterion("CBOA12 =", value, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12NotEqualTo(Integer value) {
            addCriterion("CBOA12 <>", value, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12GreaterThan(Integer value) {
            addCriterion("CBOA12 >", value, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA12 >=", value, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12LessThan(Integer value) {
            addCriterion("CBOA12 <", value, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA12 <=", value, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12In(List<Integer> values) {
            addCriterion("CBOA12 in", values, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12NotIn(List<Integer> values) {
            addCriterion("CBOA12 not in", values, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12Between(Integer value1, Integer value2) {
            addCriterion("CBOA12 between", value1, value2, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA12 not between", value1, value2, "cboa12");
            return (Criteria) this;
        }

        public Criteria andCboa13IsNull() {
            addCriterion("CBOA13 is null");
            return (Criteria) this;
        }

        public Criteria andCboa13IsNotNull() {
            addCriterion("CBOA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa13EqualTo(Date value) {
            addCriterion("CBOA13 =", value, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13NotEqualTo(Date value) {
            addCriterion("CBOA13 <>", value, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13GreaterThan(Date value) {
            addCriterion("CBOA13 >", value, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOA13 >=", value, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13LessThan(Date value) {
            addCriterion("CBOA13 <", value, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13LessThanOrEqualTo(Date value) {
            addCriterion("CBOA13 <=", value, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13In(List<Date> values) {
            addCriterion("CBOA13 in", values, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13NotIn(List<Date> values) {
            addCriterion("CBOA13 not in", values, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13Between(Date value1, Date value2) {
            addCriterion("CBOA13 between", value1, value2, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa13NotBetween(Date value1, Date value2) {
            addCriterion("CBOA13 not between", value1, value2, "cboa13");
            return (Criteria) this;
        }

        public Criteria andCboa14IsNull() {
            addCriterion("CBOA14 is null");
            return (Criteria) this;
        }

        public Criteria andCboa14IsNotNull() {
            addCriterion("CBOA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa14EqualTo(Integer value) {
            addCriterion("CBOA14 =", value, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14NotEqualTo(Integer value) {
            addCriterion("CBOA14 <>", value, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14GreaterThan(Integer value) {
            addCriterion("CBOA14 >", value, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA14 >=", value, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14LessThan(Integer value) {
            addCriterion("CBOA14 <", value, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA14 <=", value, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14In(List<Integer> values) {
            addCriterion("CBOA14 in", values, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14NotIn(List<Integer> values) {
            addCriterion("CBOA14 not in", values, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14Between(Integer value1, Integer value2) {
            addCriterion("CBOA14 between", value1, value2, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA14 not between", value1, value2, "cboa14");
            return (Criteria) this;
        }

        public Criteria andCboa15IsNull() {
            addCriterion("CBOA15 is null");
            return (Criteria) this;
        }

        public Criteria andCboa15IsNotNull() {
            addCriterion("CBOA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa15EqualTo(Date value) {
            addCriterion("CBOA15 =", value, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15NotEqualTo(Date value) {
            addCriterion("CBOA15 <>", value, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15GreaterThan(Date value) {
            addCriterion("CBOA15 >", value, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOA15 >=", value, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15LessThan(Date value) {
            addCriterion("CBOA15 <", value, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15LessThanOrEqualTo(Date value) {
            addCriterion("CBOA15 <=", value, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15In(List<Date> values) {
            addCriterion("CBOA15 in", values, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15NotIn(List<Date> values) {
            addCriterion("CBOA15 not in", values, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15Between(Date value1, Date value2) {
            addCriterion("CBOA15 between", value1, value2, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa15NotBetween(Date value1, Date value2) {
            addCriterion("CBOA15 not between", value1, value2, "cboa15");
            return (Criteria) this;
        }

        public Criteria andCboa16IsNull() {
            addCriterion("CBOA16 is null");
            return (Criteria) this;
        }

        public Criteria andCboa16IsNotNull() {
            addCriterion("CBOA16 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa16EqualTo(Integer value) {
            addCriterion("CBOA16 =", value, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16NotEqualTo(Integer value) {
            addCriterion("CBOA16 <>", value, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16GreaterThan(Integer value) {
            addCriterion("CBOA16 >", value, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA16 >=", value, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16LessThan(Integer value) {
            addCriterion("CBOA16 <", value, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA16 <=", value, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16In(List<Integer> values) {
            addCriterion("CBOA16 in", values, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16NotIn(List<Integer> values) {
            addCriterion("CBOA16 not in", values, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16Between(Integer value1, Integer value2) {
            addCriterion("CBOA16 between", value1, value2, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA16 not between", value1, value2, "cboa16");
            return (Criteria) this;
        }

        public Criteria andCboa17IsNull() {
            addCriterion("CBOA17 is null");
            return (Criteria) this;
        }

        public Criteria andCboa17IsNotNull() {
            addCriterion("CBOA17 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa17EqualTo(String value) {
            addCriterion("CBOA17 =", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17NotEqualTo(String value) {
            addCriterion("CBOA17 <>", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17GreaterThan(String value) {
            addCriterion("CBOA17 >", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA17 >=", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17LessThan(String value) {
            addCriterion("CBOA17 <", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17LessThanOrEqualTo(String value) {
            addCriterion("CBOA17 <=", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17Like(String value) {
            addCriterion("CBOA17 like", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17NotLike(String value) {
            addCriterion("CBOA17 not like", value, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17In(List<String> values) {
            addCriterion("CBOA17 in", values, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17NotIn(List<String> values) {
            addCriterion("CBOA17 not in", values, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17Between(String value1, String value2) {
            addCriterion("CBOA17 between", value1, value2, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa17NotBetween(String value1, String value2) {
            addCriterion("CBOA17 not between", value1, value2, "cboa17");
            return (Criteria) this;
        }

        public Criteria andCboa18IsNull() {
            addCriterion("CBOA18 is null");
            return (Criteria) this;
        }

        public Criteria andCboa18IsNotNull() {
            addCriterion("CBOA18 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa18EqualTo(String value) {
            addCriterion("CBOA18 =", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18NotEqualTo(String value) {
            addCriterion("CBOA18 <>", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18GreaterThan(String value) {
            addCriterion("CBOA18 >", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA18 >=", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18LessThan(String value) {
            addCriterion("CBOA18 <", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18LessThanOrEqualTo(String value) {
            addCriterion("CBOA18 <=", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18Like(String value) {
            addCriterion("CBOA18 like", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18NotLike(String value) {
            addCriterion("CBOA18 not like", value, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18In(List<String> values) {
            addCriterion("CBOA18 in", values, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18NotIn(List<String> values) {
            addCriterion("CBOA18 not in", values, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18Between(String value1, String value2) {
            addCriterion("CBOA18 between", value1, value2, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa18NotBetween(String value1, String value2) {
            addCriterion("CBOA18 not between", value1, value2, "cboa18");
            return (Criteria) this;
        }

        public Criteria andCboa19IsNull() {
            addCriterion("CBOA19 is null");
            return (Criteria) this;
        }

        public Criteria andCboa19IsNotNull() {
            addCriterion("CBOA19 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa19EqualTo(String value) {
            addCriterion("CBOA19 =", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19NotEqualTo(String value) {
            addCriterion("CBOA19 <>", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19GreaterThan(String value) {
            addCriterion("CBOA19 >", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA19 >=", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19LessThan(String value) {
            addCriterion("CBOA19 <", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19LessThanOrEqualTo(String value) {
            addCriterion("CBOA19 <=", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19Like(String value) {
            addCriterion("CBOA19 like", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19NotLike(String value) {
            addCriterion("CBOA19 not like", value, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19In(List<String> values) {
            addCriterion("CBOA19 in", values, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19NotIn(List<String> values) {
            addCriterion("CBOA19 not in", values, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19Between(String value1, String value2) {
            addCriterion("CBOA19 between", value1, value2, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa19NotBetween(String value1, String value2) {
            addCriterion("CBOA19 not between", value1, value2, "cboa19");
            return (Criteria) this;
        }

        public Criteria andCboa20IsNull() {
            addCriterion("CBOA20 is null");
            return (Criteria) this;
        }

        public Criteria andCboa20IsNotNull() {
            addCriterion("CBOA20 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa20EqualTo(String value) {
            addCriterion("CBOA20 =", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20NotEqualTo(String value) {
            addCriterion("CBOA20 <>", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20GreaterThan(String value) {
            addCriterion("CBOA20 >", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA20 >=", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20LessThan(String value) {
            addCriterion("CBOA20 <", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20LessThanOrEqualTo(String value) {
            addCriterion("CBOA20 <=", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20Like(String value) {
            addCriterion("CBOA20 like", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20NotLike(String value) {
            addCriterion("CBOA20 not like", value, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20In(List<String> values) {
            addCriterion("CBOA20 in", values, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20NotIn(List<String> values) {
            addCriterion("CBOA20 not in", values, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20Between(String value1, String value2) {
            addCriterion("CBOA20 between", value1, value2, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa20NotBetween(String value1, String value2) {
            addCriterion("CBOA20 not between", value1, value2, "cboa20");
            return (Criteria) this;
        }

        public Criteria andCboa21IsNull() {
            addCriterion("CBOA21 is null");
            return (Criteria) this;
        }

        public Criteria andCboa21IsNotNull() {
            addCriterion("CBOA21 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa21EqualTo(String value) {
            addCriterion("CBOA21 =", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21NotEqualTo(String value) {
            addCriterion("CBOA21 <>", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21GreaterThan(String value) {
            addCriterion("CBOA21 >", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA21 >=", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21LessThan(String value) {
            addCriterion("CBOA21 <", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21LessThanOrEqualTo(String value) {
            addCriterion("CBOA21 <=", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21Like(String value) {
            addCriterion("CBOA21 like", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21NotLike(String value) {
            addCriterion("CBOA21 not like", value, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21In(List<String> values) {
            addCriterion("CBOA21 in", values, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21NotIn(List<String> values) {
            addCriterion("CBOA21 not in", values, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21Between(String value1, String value2) {
            addCriterion("CBOA21 between", value1, value2, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa21NotBetween(String value1, String value2) {
            addCriterion("CBOA21 not between", value1, value2, "cboa21");
            return (Criteria) this;
        }

        public Criteria andCboa22IsNull() {
            addCriterion("CBOA22 is null");
            return (Criteria) this;
        }

        public Criteria andCboa22IsNotNull() {
            addCriterion("CBOA22 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa22EqualTo(String value) {
            addCriterion("CBOA22 =", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22NotEqualTo(String value) {
            addCriterion("CBOA22 <>", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22GreaterThan(String value) {
            addCriterion("CBOA22 >", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA22 >=", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22LessThan(String value) {
            addCriterion("CBOA22 <", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22LessThanOrEqualTo(String value) {
            addCriterion("CBOA22 <=", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22Like(String value) {
            addCriterion("CBOA22 like", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22NotLike(String value) {
            addCriterion("CBOA22 not like", value, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22In(List<String> values) {
            addCriterion("CBOA22 in", values, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22NotIn(List<String> values) {
            addCriterion("CBOA22 not in", values, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22Between(String value1, String value2) {
            addCriterion("CBOA22 between", value1, value2, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa22NotBetween(String value1, String value2) {
            addCriterion("CBOA22 not between", value1, value2, "cboa22");
            return (Criteria) this;
        }

        public Criteria andCboa23IsNull() {
            addCriterion("CBOA23 is null");
            return (Criteria) this;
        }

        public Criteria andCboa23IsNotNull() {
            addCriterion("CBOA23 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa23EqualTo(Integer value) {
            addCriterion("CBOA23 =", value, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23NotEqualTo(Integer value) {
            addCriterion("CBOA23 <>", value, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23GreaterThan(Integer value) {
            addCriterion("CBOA23 >", value, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA23 >=", value, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23LessThan(Integer value) {
            addCriterion("CBOA23 <", value, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA23 <=", value, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23In(List<Integer> values) {
            addCriterion("CBOA23 in", values, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23NotIn(List<Integer> values) {
            addCriterion("CBOA23 not in", values, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23Between(Integer value1, Integer value2) {
            addCriterion("CBOA23 between", value1, value2, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa23NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA23 not between", value1, value2, "cboa23");
            return (Criteria) this;
        }

        public Criteria andCboa24IsNull() {
            addCriterion("CBOA24 is null");
            return (Criteria) this;
        }

        public Criteria andCboa24IsNotNull() {
            addCriterion("CBOA24 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa24EqualTo(Integer value) {
            addCriterion("CBOA24 =", value, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24NotEqualTo(Integer value) {
            addCriterion("CBOA24 <>", value, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24GreaterThan(Integer value) {
            addCriterion("CBOA24 >", value, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA24 >=", value, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24LessThan(Integer value) {
            addCriterion("CBOA24 <", value, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA24 <=", value, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24In(List<Integer> values) {
            addCriterion("CBOA24 in", values, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24NotIn(List<Integer> values) {
            addCriterion("CBOA24 not in", values, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24Between(Integer value1, Integer value2) {
            addCriterion("CBOA24 between", value1, value2, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa24NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA24 not between", value1, value2, "cboa24");
            return (Criteria) this;
        }

        public Criteria andCboa25IsNull() {
            addCriterion("CBOA25 is null");
            return (Criteria) this;
        }

        public Criteria andCboa25IsNotNull() {
            addCriterion("CBOA25 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa25EqualTo(String value) {
            addCriterion("CBOA25 =", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25NotEqualTo(String value) {
            addCriterion("CBOA25 <>", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25GreaterThan(String value) {
            addCriterion("CBOA25 >", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA25 >=", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25LessThan(String value) {
            addCriterion("CBOA25 <", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25LessThanOrEqualTo(String value) {
            addCriterion("CBOA25 <=", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25Like(String value) {
            addCriterion("CBOA25 like", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25NotLike(String value) {
            addCriterion("CBOA25 not like", value, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25In(List<String> values) {
            addCriterion("CBOA25 in", values, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25NotIn(List<String> values) {
            addCriterion("CBOA25 not in", values, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25Between(String value1, String value2) {
            addCriterion("CBOA25 between", value1, value2, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa25NotBetween(String value1, String value2) {
            addCriterion("CBOA25 not between", value1, value2, "cboa25");
            return (Criteria) this;
        }

        public Criteria andCboa26IsNull() {
            addCriterion("CBOA26 is null");
            return (Criteria) this;
        }

        public Criteria andCboa26IsNotNull() {
            addCriterion("CBOA26 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa26EqualTo(String value) {
            addCriterion("CBOA26 =", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26NotEqualTo(String value) {
            addCriterion("CBOA26 <>", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26GreaterThan(String value) {
            addCriterion("CBOA26 >", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26GreaterThanOrEqualTo(String value) {
            addCriterion("CBOA26 >=", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26LessThan(String value) {
            addCriterion("CBOA26 <", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26LessThanOrEqualTo(String value) {
            addCriterion("CBOA26 <=", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26Like(String value) {
            addCriterion("CBOA26 like", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26NotLike(String value) {
            addCriterion("CBOA26 not like", value, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26In(List<String> values) {
            addCriterion("CBOA26 in", values, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26NotIn(List<String> values) {
            addCriterion("CBOA26 not in", values, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26Between(String value1, String value2) {
            addCriterion("CBOA26 between", value1, value2, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa26NotBetween(String value1, String value2) {
            addCriterion("CBOA26 not between", value1, value2, "cboa26");
            return (Criteria) this;
        }

        public Criteria andCboa27IsNull() {
            addCriterion("CBOA27 is null");
            return (Criteria) this;
        }

        public Criteria andCboa27IsNotNull() {
            addCriterion("CBOA27 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa27EqualTo(Integer value) {
            addCriterion("CBOA27 =", value, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27NotEqualTo(Integer value) {
            addCriterion("CBOA27 <>", value, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27GreaterThan(Integer value) {
            addCriterion("CBOA27 >", value, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA27 >=", value, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27LessThan(Integer value) {
            addCriterion("CBOA27 <", value, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA27 <=", value, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27In(List<Integer> values) {
            addCriterion("CBOA27 in", values, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27NotIn(List<Integer> values) {
            addCriterion("CBOA27 not in", values, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27Between(Integer value1, Integer value2) {
            addCriterion("CBOA27 between", value1, value2, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa27NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA27 not between", value1, value2, "cboa27");
            return (Criteria) this;
        }

        public Criteria andCboa28IsNull() {
            addCriterion("CBOA28 is null");
            return (Criteria) this;
        }

        public Criteria andCboa28IsNotNull() {
            addCriterion("CBOA28 is not null");
            return (Criteria) this;
        }

        public Criteria andCboa28EqualTo(Integer value) {
            addCriterion("CBOA28 =", value, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28NotEqualTo(Integer value) {
            addCriterion("CBOA28 <>", value, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28GreaterThan(Integer value) {
            addCriterion("CBOA28 >", value, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOA28 >=", value, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28LessThan(Integer value) {
            addCriterion("CBOA28 <", value, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28LessThanOrEqualTo(Integer value) {
            addCriterion("CBOA28 <=", value, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28In(List<Integer> values) {
            addCriterion("CBOA28 in", values, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28NotIn(List<Integer> values) {
            addCriterion("CBOA28 not in", values, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28Between(Integer value1, Integer value2) {
            addCriterion("CBOA28 between", value1, value2, "cboa28");
            return (Criteria) this;
        }

        public Criteria andCboa28NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOA28 not between", value1, value2, "cboa28");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusIsNull() {
            addCriterion("confirm_sku_status is null");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusIsNotNull() {
            addCriterion("confirm_sku_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusEqualTo(Byte value) {
            addCriterion("confirm_sku_status =", value, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusNotEqualTo(Byte value) {
            addCriterion("confirm_sku_status <>", value, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusGreaterThan(Byte value) {
            addCriterion("confirm_sku_status >", value, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("confirm_sku_status >=", value, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusLessThan(Byte value) {
            addCriterion("confirm_sku_status <", value, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusLessThanOrEqualTo(Byte value) {
            addCriterion("confirm_sku_status <=", value, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusIn(List<Byte> values) {
            addCriterion("confirm_sku_status in", values, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusNotIn(List<Byte> values) {
            addCriterion("confirm_sku_status not in", values, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusBetween(Byte value1, Byte value2) {
            addCriterion("confirm_sku_status between", value1, value2, "confirmSkuStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmSkuStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("confirm_sku_status not between", value1, value2, "confirmSkuStatus");
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
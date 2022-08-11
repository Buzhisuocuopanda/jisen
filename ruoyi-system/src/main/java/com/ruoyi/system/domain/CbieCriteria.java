package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbieCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbieCriteria() {
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

        public Criteria andCbie01IsNull() {
            addCriterion("CBIE01 is null");
            return (Criteria) this;
        }

        public Criteria andCbie01IsNotNull() {
            addCriterion("CBIE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie01EqualTo(Integer value) {
            addCriterion("CBIE01 =", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotEqualTo(Integer value) {
            addCriterion("CBIE01 <>", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01GreaterThan(Integer value) {
            addCriterion("CBIE01 >", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE01 >=", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01LessThan(Integer value) {
            addCriterion("CBIE01 <", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE01 <=", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01In(List<Integer> values) {
            addCriterion("CBIE01 in", values, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotIn(List<Integer> values) {
            addCriterion("CBIE01 not in", values, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01Between(Integer value1, Integer value2) {
            addCriterion("CBIE01 between", value1, value2, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE01 not between", value1, value2, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie02IsNull() {
            addCriterion("CBIE02 is null");
            return (Criteria) this;
        }

        public Criteria andCbie02IsNotNull() {
            addCriterion("CBIE02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie02EqualTo(Date value) {
            addCriterion("CBIE02 =", value, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02NotEqualTo(Date value) {
            addCriterion("CBIE02 <>", value, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02GreaterThan(Date value) {
            addCriterion("CBIE02 >", value, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIE02 >=", value, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02LessThan(Date value) {
            addCriterion("CBIE02 <", value, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02LessThanOrEqualTo(Date value) {
            addCriterion("CBIE02 <=", value, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02In(List<Date> values) {
            addCriterion("CBIE02 in", values, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02NotIn(List<Date> values) {
            addCriterion("CBIE02 not in", values, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02Between(Date value1, Date value2) {
            addCriterion("CBIE02 between", value1, value2, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie02NotBetween(Date value1, Date value2) {
            addCriterion("CBIE02 not between", value1, value2, "cbie02");
            return (Criteria) this;
        }

        public Criteria andCbie03IsNull() {
            addCriterion("CBIE03 is null");
            return (Criteria) this;
        }

        public Criteria andCbie03IsNotNull() {
            addCriterion("CBIE03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie03EqualTo(Integer value) {
            addCriterion("CBIE03 =", value, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03NotEqualTo(Integer value) {
            addCriterion("CBIE03 <>", value, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03GreaterThan(Integer value) {
            addCriterion("CBIE03 >", value, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE03 >=", value, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03LessThan(Integer value) {
            addCriterion("CBIE03 <", value, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE03 <=", value, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03In(List<Integer> values) {
            addCriterion("CBIE03 in", values, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03NotIn(List<Integer> values) {
            addCriterion("CBIE03 not in", values, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03Between(Integer value1, Integer value2) {
            addCriterion("CBIE03 between", value1, value2, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE03 not between", value1, value2, "cbie03");
            return (Criteria) this;
        }

        public Criteria andCbie04IsNull() {
            addCriterion("CBIE04 is null");
            return (Criteria) this;
        }

        public Criteria andCbie04IsNotNull() {
            addCriterion("CBIE04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie04EqualTo(Date value) {
            addCriterion("CBIE04 =", value, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04NotEqualTo(Date value) {
            addCriterion("CBIE04 <>", value, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04GreaterThan(Date value) {
            addCriterion("CBIE04 >", value, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIE04 >=", value, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04LessThan(Date value) {
            addCriterion("CBIE04 <", value, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04LessThanOrEqualTo(Date value) {
            addCriterion("CBIE04 <=", value, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04In(List<Date> values) {
            addCriterion("CBIE04 in", values, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04NotIn(List<Date> values) {
            addCriterion("CBIE04 not in", values, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04Between(Date value1, Date value2) {
            addCriterion("CBIE04 between", value1, value2, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie04NotBetween(Date value1, Date value2) {
            addCriterion("CBIE04 not between", value1, value2, "cbie04");
            return (Criteria) this;
        }

        public Criteria andCbie05IsNull() {
            addCriterion("CBIE05 is null");
            return (Criteria) this;
        }

        public Criteria andCbie05IsNotNull() {
            addCriterion("CBIE05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie05EqualTo(Integer value) {
            addCriterion("CBIE05 =", value, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05NotEqualTo(Integer value) {
            addCriterion("CBIE05 <>", value, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05GreaterThan(Integer value) {
            addCriterion("CBIE05 >", value, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE05 >=", value, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05LessThan(Integer value) {
            addCriterion("CBIE05 <", value, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE05 <=", value, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05In(List<Integer> values) {
            addCriterion("CBIE05 in", values, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05NotIn(List<Integer> values) {
            addCriterion("CBIE05 not in", values, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05Between(Integer value1, Integer value2) {
            addCriterion("CBIE05 between", value1, value2, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE05 not between", value1, value2, "cbie05");
            return (Criteria) this;
        }

        public Criteria andCbie06IsNull() {
            addCriterion("CBIE06 is null");
            return (Criteria) this;
        }

        public Criteria andCbie06IsNotNull() {
            addCriterion("CBIE06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie06EqualTo(Integer value) {
            addCriterion("CBIE06 =", value, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06NotEqualTo(Integer value) {
            addCriterion("CBIE06 <>", value, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06GreaterThan(Integer value) {
            addCriterion("CBIE06 >", value, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE06 >=", value, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06LessThan(Integer value) {
            addCriterion("CBIE06 <", value, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE06 <=", value, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06In(List<Integer> values) {
            addCriterion("CBIE06 in", values, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06NotIn(List<Integer> values) {
            addCriterion("CBIE06 not in", values, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06Between(Integer value1, Integer value2) {
            addCriterion("CBIE06 between", value1, value2, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE06 not between", value1, value2, "cbie06");
            return (Criteria) this;
        }

        public Criteria andCbie07IsNull() {
            addCriterion("CBIE07 is null");
            return (Criteria) this;
        }

        public Criteria andCbie07IsNotNull() {
            addCriterion("CBIE07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie07EqualTo(String value) {
            addCriterion("CBIE07 =", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07NotEqualTo(String value) {
            addCriterion("CBIE07 <>", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07GreaterThan(String value) {
            addCriterion("CBIE07 >", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07GreaterThanOrEqualTo(String value) {
            addCriterion("CBIE07 >=", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07LessThan(String value) {
            addCriterion("CBIE07 <", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07LessThanOrEqualTo(String value) {
            addCriterion("CBIE07 <=", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07Like(String value) {
            addCriterion("CBIE07 like", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07NotLike(String value) {
            addCriterion("CBIE07 not like", value, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07In(List<String> values) {
            addCriterion("CBIE07 in", values, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07NotIn(List<String> values) {
            addCriterion("CBIE07 not in", values, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07Between(String value1, String value2) {
            addCriterion("CBIE07 between", value1, value2, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie07NotBetween(String value1, String value2) {
            addCriterion("CBIE07 not between", value1, value2, "cbie07");
            return (Criteria) this;
        }

        public Criteria andCbie08IsNull() {
            addCriterion("CBIE08 is null");
            return (Criteria) this;
        }

        public Criteria andCbie08IsNotNull() {
            addCriterion("CBIE08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie08EqualTo(Date value) {
            addCriterion("CBIE08 =", value, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08NotEqualTo(Date value) {
            addCriterion("CBIE08 <>", value, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08GreaterThan(Date value) {
            addCriterion("CBIE08 >", value, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIE08 >=", value, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08LessThan(Date value) {
            addCriterion("CBIE08 <", value, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08LessThanOrEqualTo(Date value) {
            addCriterion("CBIE08 <=", value, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08In(List<Date> values) {
            addCriterion("CBIE08 in", values, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08NotIn(List<Date> values) {
            addCriterion("CBIE08 not in", values, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08Between(Date value1, Date value2) {
            addCriterion("CBIE08 between", value1, value2, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie08NotBetween(Date value1, Date value2) {
            addCriterion("CBIE08 not between", value1, value2, "cbie08");
            return (Criteria) this;
        }

        public Criteria andCbie09IsNull() {
            addCriterion("CBIE09 is null");
            return (Criteria) this;
        }

        public Criteria andCbie09IsNotNull() {
            addCriterion("CBIE09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie09EqualTo(Integer value) {
            addCriterion("CBIE09 =", value, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09NotEqualTo(Integer value) {
            addCriterion("CBIE09 <>", value, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09GreaterThan(Integer value) {
            addCriterion("CBIE09 >", value, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE09 >=", value, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09LessThan(Integer value) {
            addCriterion("CBIE09 <", value, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE09 <=", value, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09In(List<Integer> values) {
            addCriterion("CBIE09 in", values, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09NotIn(List<Integer> values) {
            addCriterion("CBIE09 not in", values, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09Between(Integer value1, Integer value2) {
            addCriterion("CBIE09 between", value1, value2, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE09 not between", value1, value2, "cbie09");
            return (Criteria) this;
        }

        public Criteria andCbie10IsNull() {
            addCriterion("CBIE10 is null");
            return (Criteria) this;
        }

        public Criteria andCbie10IsNotNull() {
            addCriterion("CBIE10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie10EqualTo(Integer value) {
            addCriterion("CBIE10 =", value, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10NotEqualTo(Integer value) {
            addCriterion("CBIE10 <>", value, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10GreaterThan(Integer value) {
            addCriterion("CBIE10 >", value, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE10 >=", value, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10LessThan(Integer value) {
            addCriterion("CBIE10 <", value, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE10 <=", value, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10In(List<Integer> values) {
            addCriterion("CBIE10 in", values, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10NotIn(List<Integer> values) {
            addCriterion("CBIE10 not in", values, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10Between(Integer value1, Integer value2) {
            addCriterion("CBIE10 between", value1, value2, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE10 not between", value1, value2, "cbie10");
            return (Criteria) this;
        }

        public Criteria andCbie11IsNull() {
            addCriterion("CBIE11 is null");
            return (Criteria) this;
        }

        public Criteria andCbie11IsNotNull() {
            addCriterion("CBIE11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie11EqualTo(Integer value) {
            addCriterion("CBIE11 =", value, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11NotEqualTo(Integer value) {
            addCriterion("CBIE11 <>", value, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11GreaterThan(Integer value) {
            addCriterion("CBIE11 >", value, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE11 >=", value, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11LessThan(Integer value) {
            addCriterion("CBIE11 <", value, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE11 <=", value, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11In(List<Integer> values) {
            addCriterion("CBIE11 in", values, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11NotIn(List<Integer> values) {
            addCriterion("CBIE11 not in", values, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11Between(Integer value1, Integer value2) {
            addCriterion("CBIE11 between", value1, value2, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE11 not between", value1, value2, "cbie11");
            return (Criteria) this;
        }

        public Criteria andCbie12IsNull() {
            addCriterion("CBIE12 is null");
            return (Criteria) this;
        }

        public Criteria andCbie12IsNotNull() {
            addCriterion("CBIE12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie12EqualTo(Date value) {
            addCriterion("CBIE12 =", value, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12NotEqualTo(Date value) {
            addCriterion("CBIE12 <>", value, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12GreaterThan(Date value) {
            addCriterion("CBIE12 >", value, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIE12 >=", value, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12LessThan(Date value) {
            addCriterion("CBIE12 <", value, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12LessThanOrEqualTo(Date value) {
            addCriterion("CBIE12 <=", value, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12In(List<Date> values) {
            addCriterion("CBIE12 in", values, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12NotIn(List<Date> values) {
            addCriterion("CBIE12 not in", values, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12Between(Date value1, Date value2) {
            addCriterion("CBIE12 between", value1, value2, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie12NotBetween(Date value1, Date value2) {
            addCriterion("CBIE12 not between", value1, value2, "cbie12");
            return (Criteria) this;
        }

        public Criteria andCbie13IsNull() {
            addCriterion("CBIE13 is null");
            return (Criteria) this;
        }

        public Criteria andCbie13IsNotNull() {
            addCriterion("CBIE13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie13EqualTo(Integer value) {
            addCriterion("CBIE13 =", value, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13NotEqualTo(Integer value) {
            addCriterion("CBIE13 <>", value, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13GreaterThan(Integer value) {
            addCriterion("CBIE13 >", value, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE13 >=", value, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13LessThan(Integer value) {
            addCriterion("CBIE13 <", value, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE13 <=", value, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13In(List<Integer> values) {
            addCriterion("CBIE13 in", values, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13NotIn(List<Integer> values) {
            addCriterion("CBIE13 not in", values, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13Between(Integer value1, Integer value2) {
            addCriterion("CBIE13 between", value1, value2, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie13NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE13 not between", value1, value2, "cbie13");
            return (Criteria) this;
        }

        public Criteria andCbie14IsNull() {
            addCriterion("CBIE14 is null");
            return (Criteria) this;
        }

        public Criteria andCbie14IsNotNull() {
            addCriterion("CBIE14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie14EqualTo(Date value) {
            addCriterion("CBIE14 =", value, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14NotEqualTo(Date value) {
            addCriterion("CBIE14 <>", value, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14GreaterThan(Date value) {
            addCriterion("CBIE14 >", value, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIE14 >=", value, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14LessThan(Date value) {
            addCriterion("CBIE14 <", value, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14LessThanOrEqualTo(Date value) {
            addCriterion("CBIE14 <=", value, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14In(List<Date> values) {
            addCriterion("CBIE14 in", values, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14NotIn(List<Date> values) {
            addCriterion("CBIE14 not in", values, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14Between(Date value1, Date value2) {
            addCriterion("CBIE14 between", value1, value2, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie14NotBetween(Date value1, Date value2) {
            addCriterion("CBIE14 not between", value1, value2, "cbie14");
            return (Criteria) this;
        }

        public Criteria andCbie15IsNull() {
            addCriterion("CBIE15 is null");
            return (Criteria) this;
        }

        public Criteria andCbie15IsNotNull() {
            addCriterion("CBIE15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie15EqualTo(String value) {
            addCriterion("CBIE15 =", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15NotEqualTo(String value) {
            addCriterion("CBIE15 <>", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15GreaterThan(String value) {
            addCriterion("CBIE15 >", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15GreaterThanOrEqualTo(String value) {
            addCriterion("CBIE15 >=", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15LessThan(String value) {
            addCriterion("CBIE15 <", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15LessThanOrEqualTo(String value) {
            addCriterion("CBIE15 <=", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15Like(String value) {
            addCriterion("CBIE15 like", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15NotLike(String value) {
            addCriterion("CBIE15 not like", value, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15In(List<String> values) {
            addCriterion("CBIE15 in", values, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15NotIn(List<String> values) {
            addCriterion("CBIE15 not in", values, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15Between(String value1, String value2) {
            addCriterion("CBIE15 between", value1, value2, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie15NotBetween(String value1, String value2) {
            addCriterion("CBIE15 not between", value1, value2, "cbie15");
            return (Criteria) this;
        }

        public Criteria andCbie16IsNull() {
            addCriterion("CBIE16 is null");
            return (Criteria) this;
        }

        public Criteria andCbie16IsNotNull() {
            addCriterion("CBIE16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie16EqualTo(Integer value) {
            addCriterion("CBIE16 =", value, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16NotEqualTo(Integer value) {
            addCriterion("CBIE16 <>", value, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16GreaterThan(Integer value) {
            addCriterion("CBIE16 >", value, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE16 >=", value, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16LessThan(Integer value) {
            addCriterion("CBIE16 <", value, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE16 <=", value, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16In(List<Integer> values) {
            addCriterion("CBIE16 in", values, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16NotIn(List<Integer> values) {
            addCriterion("CBIE16 not in", values, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16Between(Integer value1, Integer value2) {
            addCriterion("CBIE16 between", value1, value2, "cbie16");
            return (Criteria) this;
        }

        public Criteria andCbie16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE16 not between", value1, value2, "cbie16");
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
package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbibCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbibCriteria() {
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

        public Criteria andCbib01IsNull() {
            addCriterion("CBIB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbib01IsNotNull() {
            addCriterion("CBIB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib01EqualTo(Integer value) {
            addCriterion("CBIB01 =", value, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01NotEqualTo(Integer value) {
            addCriterion("CBIB01 <>", value, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01GreaterThan(Integer value) {
            addCriterion("CBIB01 >", value, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIB01 >=", value, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01LessThan(Integer value) {
            addCriterion("CBIB01 <", value, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIB01 <=", value, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01In(List<Integer> values) {
            addCriterion("CBIB01 in", values, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01NotIn(List<Integer> values) {
            addCriterion("CBIB01 not in", values, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01Between(Integer value1, Integer value2) {
            addCriterion("CBIB01 between", value1, value2, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIB01 not between", value1, value2, "cbib01");
            return (Criteria) this;
        }

        public Criteria andCbib02IsNull() {
            addCriterion("CBIB02 is null");
            return (Criteria) this;
        }

        public Criteria andCbib02IsNotNull() {
            addCriterion("CBIB02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib02EqualTo(Integer value) {
            addCriterion("CBIB02 =", value, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02NotEqualTo(Integer value) {
            addCriterion("CBIB02 <>", value, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02GreaterThan(Integer value) {
            addCriterion("CBIB02 >", value, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIB02 >=", value, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02LessThan(Integer value) {
            addCriterion("CBIB02 <", value, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02LessThanOrEqualTo(Integer value) {
            addCriterion("CBIB02 <=", value, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02In(List<Integer> values) {
            addCriterion("CBIB02 in", values, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02NotIn(List<Integer> values) {
            addCriterion("CBIB02 not in", values, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02Between(Integer value1, Integer value2) {
            addCriterion("CBIB02 between", value1, value2, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIB02 not between", value1, value2, "cbib02");
            return (Criteria) this;
        }

        public Criteria andCbib03IsNull() {
            addCriterion("CBIB03 is null");
            return (Criteria) this;
        }

        public Criteria andCbib03IsNotNull() {
            addCriterion("CBIB03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib03EqualTo(String value) {
            addCriterion("CBIB03 =", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03NotEqualTo(String value) {
            addCriterion("CBIB03 <>", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03GreaterThan(String value) {
            addCriterion("CBIB03 >", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03GreaterThanOrEqualTo(String value) {
            addCriterion("CBIB03 >=", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03LessThan(String value) {
            addCriterion("CBIB03 <", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03LessThanOrEqualTo(String value) {
            addCriterion("CBIB03 <=", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03Like(String value) {
            addCriterion("CBIB03 like", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03NotLike(String value) {
            addCriterion("CBIB03 not like", value, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03In(List<String> values) {
            addCriterion("CBIB03 in", values, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03NotIn(List<String> values) {
            addCriterion("CBIB03 not in", values, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03Between(String value1, String value2) {
            addCriterion("CBIB03 between", value1, value2, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib03NotBetween(String value1, String value2) {
            addCriterion("CBIB03 not between", value1, value2, "cbib03");
            return (Criteria) this;
        }

        public Criteria andCbib04IsNull() {
            addCriterion("CBIB04 is null");
            return (Criteria) this;
        }

        public Criteria andCbib04IsNotNull() {
            addCriterion("CBIB04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib04EqualTo(Date value) {
            addCriterion("CBIB04 =", value, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04NotEqualTo(Date value) {
            addCriterion("CBIB04 <>", value, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04GreaterThan(Date value) {
            addCriterion("CBIB04 >", value, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIB04 >=", value, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04LessThan(Date value) {
            addCriterion("CBIB04 <", value, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04LessThanOrEqualTo(Date value) {
            addCriterion("CBIB04 <=", value, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04In(List<Date> values) {
            addCriterion("CBIB04 in", values, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04NotIn(List<Date> values) {
            addCriterion("CBIB04 not in", values, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04Between(Date value1, Date value2) {
            addCriterion("CBIB04 between", value1, value2, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib04NotBetween(Date value1, Date value2) {
            addCriterion("CBIB04 not between", value1, value2, "cbib04");
            return (Criteria) this;
        }

        public Criteria andCbib05IsNull() {
            addCriterion("CBIB05 is null");
            return (Criteria) this;
        }

        public Criteria andCbib05IsNotNull() {
            addCriterion("CBIB05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib05EqualTo(String value) {
            addCriterion("CBIB05 =", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05NotEqualTo(String value) {
            addCriterion("CBIB05 <>", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05GreaterThan(String value) {
            addCriterion("CBIB05 >", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05GreaterThanOrEqualTo(String value) {
            addCriterion("CBIB05 >=", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05LessThan(String value) {
            addCriterion("CBIB05 <", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05LessThanOrEqualTo(String value) {
            addCriterion("CBIB05 <=", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05Like(String value) {
            addCriterion("CBIB05 like", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05NotLike(String value) {
            addCriterion("CBIB05 not like", value, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05In(List<String> values) {
            addCriterion("CBIB05 in", values, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05NotIn(List<String> values) {
            addCriterion("CBIB05 not in", values, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05Between(String value1, String value2) {
            addCriterion("CBIB05 between", value1, value2, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib05NotBetween(String value1, String value2) {
            addCriterion("CBIB05 not between", value1, value2, "cbib05");
            return (Criteria) this;
        }

        public Criteria andCbib06IsNull() {
            addCriterion("CBIB06 is null");
            return (Criteria) this;
        }

        public Criteria andCbib06IsNotNull() {
            addCriterion("CBIB06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib06EqualTo(String value) {
            addCriterion("CBIB06 =", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06NotEqualTo(String value) {
            addCriterion("CBIB06 <>", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06GreaterThan(String value) {
            addCriterion("CBIB06 >", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06GreaterThanOrEqualTo(String value) {
            addCriterion("CBIB06 >=", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06LessThan(String value) {
            addCriterion("CBIB06 <", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06LessThanOrEqualTo(String value) {
            addCriterion("CBIB06 <=", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06Like(String value) {
            addCriterion("CBIB06 like", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06NotLike(String value) {
            addCriterion("CBIB06 not like", value, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06In(List<String> values) {
            addCriterion("CBIB06 in", values, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06NotIn(List<String> values) {
            addCriterion("CBIB06 not in", values, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06Between(String value1, String value2) {
            addCriterion("CBIB06 between", value1, value2, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib06NotBetween(String value1, String value2) {
            addCriterion("CBIB06 not between", value1, value2, "cbib06");
            return (Criteria) this;
        }

        public Criteria andCbib07IsNull() {
            addCriterion("CBIB07 is null");
            return (Criteria) this;
        }

        public Criteria andCbib07IsNotNull() {
            addCriterion("CBIB07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib07EqualTo(Integer value) {
            addCriterion("CBIB07 =", value, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07NotEqualTo(Integer value) {
            addCriterion("CBIB07 <>", value, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07GreaterThan(Integer value) {
            addCriterion("CBIB07 >", value, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIB07 >=", value, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07LessThan(Integer value) {
            addCriterion("CBIB07 <", value, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07LessThanOrEqualTo(Integer value) {
            addCriterion("CBIB07 <=", value, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07In(List<Integer> values) {
            addCriterion("CBIB07 in", values, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07NotIn(List<Integer> values) {
            addCriterion("CBIB07 not in", values, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07Between(Integer value1, Integer value2) {
            addCriterion("CBIB07 between", value1, value2, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIB07 not between", value1, value2, "cbib07");
            return (Criteria) this;
        }

        public Criteria andCbib08IsNull() {
            addCriterion("CBIB08 is null");
            return (Criteria) this;
        }

        public Criteria andCbib08IsNotNull() {
            addCriterion("CBIB08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib08EqualTo(Integer value) {
            addCriterion("CBIB08 =", value, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08NotEqualTo(Integer value) {
            addCriterion("CBIB08 <>", value, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08GreaterThan(Integer value) {
            addCriterion("CBIB08 >", value, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIB08 >=", value, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08LessThan(Integer value) {
            addCriterion("CBIB08 <", value, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08LessThanOrEqualTo(Integer value) {
            addCriterion("CBIB08 <=", value, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08In(List<Integer> values) {
            addCriterion("CBIB08 in", values, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08NotIn(List<Integer> values) {
            addCriterion("CBIB08 not in", values, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08Between(Integer value1, Integer value2) {
            addCriterion("CBIB08 between", value1, value2, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIB08 not between", value1, value2, "cbib08");
            return (Criteria) this;
        }

        public Criteria andCbib09IsNull() {
            addCriterion("CBIB09 is null");
            return (Criteria) this;
        }

        public Criteria andCbib09IsNotNull() {
            addCriterion("CBIB09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib09EqualTo(Double value) {
            addCriterion("CBIB09 =", value, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09NotEqualTo(Double value) {
            addCriterion("CBIB09 <>", value, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09GreaterThan(Double value) {
            addCriterion("CBIB09 >", value, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB09 >=", value, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09LessThan(Double value) {
            addCriterion("CBIB09 <", value, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09LessThanOrEqualTo(Double value) {
            addCriterion("CBIB09 <=", value, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09In(List<Double> values) {
            addCriterion("CBIB09 in", values, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09NotIn(List<Double> values) {
            addCriterion("CBIB09 not in", values, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09Between(Double value1, Double value2) {
            addCriterion("CBIB09 between", value1, value2, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib09NotBetween(Double value1, Double value2) {
            addCriterion("CBIB09 not between", value1, value2, "cbib09");
            return (Criteria) this;
        }

        public Criteria andCbib10IsNull() {
            addCriterion("CBIB10 is null");
            return (Criteria) this;
        }

        public Criteria andCbib10IsNotNull() {
            addCriterion("CBIB10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib10EqualTo(Double value) {
            addCriterion("CBIB10 =", value, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10NotEqualTo(Double value) {
            addCriterion("CBIB10 <>", value, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10GreaterThan(Double value) {
            addCriterion("CBIB10 >", value, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB10 >=", value, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10LessThan(Double value) {
            addCriterion("CBIB10 <", value, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10LessThanOrEqualTo(Double value) {
            addCriterion("CBIB10 <=", value, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10In(List<Double> values) {
            addCriterion("CBIB10 in", values, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10NotIn(List<Double> values) {
            addCriterion("CBIB10 not in", values, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10Between(Double value1, Double value2) {
            addCriterion("CBIB10 between", value1, value2, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib10NotBetween(Double value1, Double value2) {
            addCriterion("CBIB10 not between", value1, value2, "cbib10");
            return (Criteria) this;
        }

        public Criteria andCbib11IsNull() {
            addCriterion("CBIB11 is null");
            return (Criteria) this;
        }

        public Criteria andCbib11IsNotNull() {
            addCriterion("CBIB11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib11EqualTo(Double value) {
            addCriterion("CBIB11 =", value, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11NotEqualTo(Double value) {
            addCriterion("CBIB11 <>", value, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11GreaterThan(Double value) {
            addCriterion("CBIB11 >", value, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB11 >=", value, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11LessThan(Double value) {
            addCriterion("CBIB11 <", value, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11LessThanOrEqualTo(Double value) {
            addCriterion("CBIB11 <=", value, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11In(List<Double> values) {
            addCriterion("CBIB11 in", values, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11NotIn(List<Double> values) {
            addCriterion("CBIB11 not in", values, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11Between(Double value1, Double value2) {
            addCriterion("CBIB11 between", value1, value2, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib11NotBetween(Double value1, Double value2) {
            addCriterion("CBIB11 not between", value1, value2, "cbib11");
            return (Criteria) this;
        }

        public Criteria andCbib12IsNull() {
            addCriterion("CBIB12 is null");
            return (Criteria) this;
        }

        public Criteria andCbib12IsNotNull() {
            addCriterion("CBIB12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib12EqualTo(Double value) {
            addCriterion("CBIB12 =", value, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12NotEqualTo(Double value) {
            addCriterion("CBIB12 <>", value, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12GreaterThan(Double value) {
            addCriterion("CBIB12 >", value, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB12 >=", value, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12LessThan(Double value) {
            addCriterion("CBIB12 <", value, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12LessThanOrEqualTo(Double value) {
            addCriterion("CBIB12 <=", value, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12In(List<Double> values) {
            addCriterion("CBIB12 in", values, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12NotIn(List<Double> values) {
            addCriterion("CBIB12 not in", values, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12Between(Double value1, Double value2) {
            addCriterion("CBIB12 between", value1, value2, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib12NotBetween(Double value1, Double value2) {
            addCriterion("CBIB12 not between", value1, value2, "cbib12");
            return (Criteria) this;
        }

        public Criteria andCbib13IsNull() {
            addCriterion("CBIB13 is null");
            return (Criteria) this;
        }

        public Criteria andCbib13IsNotNull() {
            addCriterion("CBIB13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib13EqualTo(Double value) {
            addCriterion("CBIB13 =", value, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13NotEqualTo(Double value) {
            addCriterion("CBIB13 <>", value, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13GreaterThan(Double value) {
            addCriterion("CBIB13 >", value, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB13 >=", value, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13LessThan(Double value) {
            addCriterion("CBIB13 <", value, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13LessThanOrEqualTo(Double value) {
            addCriterion("CBIB13 <=", value, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13In(List<Double> values) {
            addCriterion("CBIB13 in", values, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13NotIn(List<Double> values) {
            addCriterion("CBIB13 not in", values, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13Between(Double value1, Double value2) {
            addCriterion("CBIB13 between", value1, value2, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib13NotBetween(Double value1, Double value2) {
            addCriterion("CBIB13 not between", value1, value2, "cbib13");
            return (Criteria) this;
        }

        public Criteria andCbib14IsNull() {
            addCriterion("CBIB14 is null");
            return (Criteria) this;
        }

        public Criteria andCbib14IsNotNull() {
            addCriterion("CBIB14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib14EqualTo(Double value) {
            addCriterion("CBIB14 =", value, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14NotEqualTo(Double value) {
            addCriterion("CBIB14 <>", value, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14GreaterThan(Double value) {
            addCriterion("CBIB14 >", value, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB14 >=", value, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14LessThan(Double value) {
            addCriterion("CBIB14 <", value, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14LessThanOrEqualTo(Double value) {
            addCriterion("CBIB14 <=", value, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14In(List<Double> values) {
            addCriterion("CBIB14 in", values, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14NotIn(List<Double> values) {
            addCriterion("CBIB14 not in", values, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14Between(Double value1, Double value2) {
            addCriterion("CBIB14 between", value1, value2, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib14NotBetween(Double value1, Double value2) {
            addCriterion("CBIB14 not between", value1, value2, "cbib14");
            return (Criteria) this;
        }

        public Criteria andCbib15IsNull() {
            addCriterion("CBIB15 is null");
            return (Criteria) this;
        }

        public Criteria andCbib15IsNotNull() {
            addCriterion("CBIB15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib15EqualTo(Double value) {
            addCriterion("CBIB15 =", value, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15NotEqualTo(Double value) {
            addCriterion("CBIB15 <>", value, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15GreaterThan(Double value) {
            addCriterion("CBIB15 >", value, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB15 >=", value, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15LessThan(Double value) {
            addCriterion("CBIB15 <", value, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15LessThanOrEqualTo(Double value) {
            addCriterion("CBIB15 <=", value, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15In(List<Double> values) {
            addCriterion("CBIB15 in", values, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15NotIn(List<Double> values) {
            addCriterion("CBIB15 not in", values, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15Between(Double value1, Double value2) {
            addCriterion("CBIB15 between", value1, value2, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib15NotBetween(Double value1, Double value2) {
            addCriterion("CBIB15 not between", value1, value2, "cbib15");
            return (Criteria) this;
        }

        public Criteria andCbib16IsNull() {
            addCriterion("CBIB16 is null");
            return (Criteria) this;
        }

        public Criteria andCbib16IsNotNull() {
            addCriterion("CBIB16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib16EqualTo(Double value) {
            addCriterion("CBIB16 =", value, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16NotEqualTo(Double value) {
            addCriterion("CBIB16 <>", value, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16GreaterThan(Double value) {
            addCriterion("CBIB16 >", value, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIB16 >=", value, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16LessThan(Double value) {
            addCriterion("CBIB16 <", value, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16LessThanOrEqualTo(Double value) {
            addCriterion("CBIB16 <=", value, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16In(List<Double> values) {
            addCriterion("CBIB16 in", values, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16NotIn(List<Double> values) {
            addCriterion("CBIB16 not in", values, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16Between(Double value1, Double value2) {
            addCriterion("CBIB16 between", value1, value2, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib16NotBetween(Double value1, Double value2) {
            addCriterion("CBIB16 not between", value1, value2, "cbib16");
            return (Criteria) this;
        }

        public Criteria andCbib17IsNull() {
            addCriterion("CBIB17 is null");
            return (Criteria) this;
        }

        public Criteria andCbib17IsNotNull() {
            addCriterion("CBIB17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib17EqualTo(String value) {
            addCriterion("CBIB17 =", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17NotEqualTo(String value) {
            addCriterion("CBIB17 <>", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17GreaterThan(String value) {
            addCriterion("CBIB17 >", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17GreaterThanOrEqualTo(String value) {
            addCriterion("CBIB17 >=", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17LessThan(String value) {
            addCriterion("CBIB17 <", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17LessThanOrEqualTo(String value) {
            addCriterion("CBIB17 <=", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17Like(String value) {
            addCriterion("CBIB17 like", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17NotLike(String value) {
            addCriterion("CBIB17 not like", value, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17In(List<String> values) {
            addCriterion("CBIB17 in", values, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17NotIn(List<String> values) {
            addCriterion("CBIB17 not in", values, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17Between(String value1, String value2) {
            addCriterion("CBIB17 between", value1, value2, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib17NotBetween(String value1, String value2) {
            addCriterion("CBIB17 not between", value1, value2, "cbib17");
            return (Criteria) this;
        }

        public Criteria andCbib18IsNull() {
            addCriterion("CBIB18 is null");
            return (Criteria) this;
        }

        public Criteria andCbib18IsNotNull() {
            addCriterion("CBIB18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib18EqualTo(Integer value) {
            addCriterion("CBIB18 =", value, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18NotEqualTo(Integer value) {
            addCriterion("CBIB18 <>", value, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18GreaterThan(Integer value) {
            addCriterion("CBIB18 >", value, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIB18 >=", value, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18LessThan(Integer value) {
            addCriterion("CBIB18 <", value, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18LessThanOrEqualTo(Integer value) {
            addCriterion("CBIB18 <=", value, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18In(List<Integer> values) {
            addCriterion("CBIB18 in", values, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18NotIn(List<Integer> values) {
            addCriterion("CBIB18 not in", values, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18Between(Integer value1, Integer value2) {
            addCriterion("CBIB18 between", value1, value2, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib18NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIB18 not between", value1, value2, "cbib18");
            return (Criteria) this;
        }

        public Criteria andCbib19IsNull() {
            addCriterion("CBIB19 is null");
            return (Criteria) this;
        }

        public Criteria andCbib19IsNotNull() {
            addCriterion("CBIB19 is not null");
            return (Criteria) this;
        }

        public Criteria andCbib19EqualTo(Integer value) {
            addCriterion("CBIB19 =", value, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19NotEqualTo(Integer value) {
            addCriterion("CBIB19 <>", value, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19GreaterThan(Integer value) {
            addCriterion("CBIB19 >", value, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIB19 >=", value, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19LessThan(Integer value) {
            addCriterion("CBIB19 <", value, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19LessThanOrEqualTo(Integer value) {
            addCriterion("CBIB19 <=", value, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19In(List<Integer> values) {
            addCriterion("CBIB19 in", values, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19NotIn(List<Integer> values) {
            addCriterion("CBIB19 not in", values, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19Between(Integer value1, Integer value2) {
            addCriterion("CBIB19 between", value1, value2, "cbib19");
            return (Criteria) this;
        }

        public Criteria andCbib19NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIB19 not between", value1, value2, "cbib19");
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
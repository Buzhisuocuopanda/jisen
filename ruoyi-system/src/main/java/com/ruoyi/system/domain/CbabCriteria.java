package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbabCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbabCriteria() {
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

        public Criteria andCbab01IsNull() {
            addCriterion("CBAB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbab01IsNotNull() {
            addCriterion("CBAB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab01EqualTo(Integer value) {
            addCriterion("CBAB01 =", value, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01NotEqualTo(Integer value) {
            addCriterion("CBAB01 <>", value, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01GreaterThan(Integer value) {
            addCriterion("CBAB01 >", value, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB01 >=", value, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01LessThan(Integer value) {
            addCriterion("CBAB01 <", value, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB01 <=", value, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01In(List<Integer> values) {
            addCriterion("CBAB01 in", values, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01NotIn(List<Integer> values) {
            addCriterion("CBAB01 not in", values, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01Between(Integer value1, Integer value2) {
            addCriterion("CBAB01 between", value1, value2, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB01 not between", value1, value2, "cbab01");
            return (Criteria) this;
        }

        public Criteria andCbab02IsNull() {
            addCriterion("CBAB02 is null");
            return (Criteria) this;
        }

        public Criteria andCbab02IsNotNull() {
            addCriterion("CBAB02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab02EqualTo(Integer value) {
            addCriterion("CBAB02 =", value, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02NotEqualTo(Integer value) {
            addCriterion("CBAB02 <>", value, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02GreaterThan(Integer value) {
            addCriterion("CBAB02 >", value, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB02 >=", value, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02LessThan(Integer value) {
            addCriterion("CBAB02 <", value, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB02 <=", value, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02In(List<Integer> values) {
            addCriterion("CBAB02 in", values, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02NotIn(List<Integer> values) {
            addCriterion("CBAB02 not in", values, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02Between(Integer value1, Integer value2) {
            addCriterion("CBAB02 between", value1, value2, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB02 not between", value1, value2, "cbab02");
            return (Criteria) this;
        }

        public Criteria andCbab03IsNull() {
            addCriterion("CBAB03 is null");
            return (Criteria) this;
        }

        public Criteria andCbab03IsNotNull() {
            addCriterion("CBAB03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab03EqualTo(Date value) {
            addCriterion("CBAB03 =", value, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03NotEqualTo(Date value) {
            addCriterion("CBAB03 <>", value, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03GreaterThan(Date value) {
            addCriterion("CBAB03 >", value, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAB03 >=", value, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03LessThan(Date value) {
            addCriterion("CBAB03 <", value, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03LessThanOrEqualTo(Date value) {
            addCriterion("CBAB03 <=", value, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03In(List<Date> values) {
            addCriterion("CBAB03 in", values, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03NotIn(List<Date> values) {
            addCriterion("CBAB03 not in", values, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03Between(Date value1, Date value2) {
            addCriterion("CBAB03 between", value1, value2, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab03NotBetween(Date value1, Date value2) {
            addCriterion("CBAB03 not between", value1, value2, "cbab03");
            return (Criteria) this;
        }

        public Criteria andCbab04IsNull() {
            addCriterion("CBAB04 is null");
            return (Criteria) this;
        }

        public Criteria andCbab04IsNotNull() {
            addCriterion("CBAB04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab04EqualTo(Integer value) {
            addCriterion("CBAB04 =", value, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04NotEqualTo(Integer value) {
            addCriterion("CBAB04 <>", value, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04GreaterThan(Integer value) {
            addCriterion("CBAB04 >", value, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB04 >=", value, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04LessThan(Integer value) {
            addCriterion("CBAB04 <", value, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB04 <=", value, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04In(List<Integer> values) {
            addCriterion("CBAB04 in", values, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04NotIn(List<Integer> values) {
            addCriterion("CBAB04 not in", values, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04Between(Integer value1, Integer value2) {
            addCriterion("CBAB04 between", value1, value2, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB04 not between", value1, value2, "cbab04");
            return (Criteria) this;
        }

        public Criteria andCbab05IsNull() {
            addCriterion("CBAB05 is null");
            return (Criteria) this;
        }

        public Criteria andCbab05IsNotNull() {
            addCriterion("CBAB05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab05EqualTo(Date value) {
            addCriterion("CBAB05 =", value, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05NotEqualTo(Date value) {
            addCriterion("CBAB05 <>", value, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05GreaterThan(Date value) {
            addCriterion("CBAB05 >", value, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBAB05 >=", value, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05LessThan(Date value) {
            addCriterion("CBAB05 <", value, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05LessThanOrEqualTo(Date value) {
            addCriterion("CBAB05 <=", value, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05In(List<Date> values) {
            addCriterion("CBAB05 in", values, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05NotIn(List<Date> values) {
            addCriterion("CBAB05 not in", values, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05Between(Date value1, Date value2) {
            addCriterion("CBAB05 between", value1, value2, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab05NotBetween(Date value1, Date value2) {
            addCriterion("CBAB05 not between", value1, value2, "cbab05");
            return (Criteria) this;
        }

        public Criteria andCbab06IsNull() {
            addCriterion("CBAB06 is null");
            return (Criteria) this;
        }

        public Criteria andCbab06IsNotNull() {
            addCriterion("CBAB06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab06EqualTo(Integer value) {
            addCriterion("CBAB06 =", value, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06NotEqualTo(Integer value) {
            addCriterion("CBAB06 <>", value, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06GreaterThan(Integer value) {
            addCriterion("CBAB06 >", value, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB06 >=", value, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06LessThan(Integer value) {
            addCriterion("CBAB06 <", value, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB06 <=", value, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06In(List<Integer> values) {
            addCriterion("CBAB06 in", values, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06NotIn(List<Integer> values) {
            addCriterion("CBAB06 not in", values, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06Between(Integer value1, Integer value2) {
            addCriterion("CBAB06 between", value1, value2, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB06 not between", value1, value2, "cbab06");
            return (Criteria) this;
        }

        public Criteria andCbab07IsNull() {
            addCriterion("CBAB07 is null");
            return (Criteria) this;
        }

        public Criteria andCbab07IsNotNull() {
            addCriterion("CBAB07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab07EqualTo(Integer value) {
            addCriterion("CBAB07 =", value, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07NotEqualTo(Integer value) {
            addCriterion("CBAB07 <>", value, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07GreaterThan(Integer value) {
            addCriterion("CBAB07 >", value, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB07 >=", value, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07LessThan(Integer value) {
            addCriterion("CBAB07 <", value, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB07 <=", value, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07In(List<Integer> values) {
            addCriterion("CBAB07 in", values, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07NotIn(List<Integer> values) {
            addCriterion("CBAB07 not in", values, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07Between(Integer value1, Integer value2) {
            addCriterion("CBAB07 between", value1, value2, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB07 not between", value1, value2, "cbab07");
            return (Criteria) this;
        }

        public Criteria andCbab08IsNull() {
            addCriterion("CBAB08 is null");
            return (Criteria) this;
        }

        public Criteria andCbab08IsNotNull() {
            addCriterion("CBAB08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab08EqualTo(Integer value) {
            addCriterion("CBAB08 =", value, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08NotEqualTo(Integer value) {
            addCriterion("CBAB08 <>", value, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08GreaterThan(Integer value) {
            addCriterion("CBAB08 >", value, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB08 >=", value, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08LessThan(Integer value) {
            addCriterion("CBAB08 <", value, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB08 <=", value, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08In(List<Integer> values) {
            addCriterion("CBAB08 in", values, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08NotIn(List<Integer> values) {
            addCriterion("CBAB08 not in", values, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08Between(Integer value1, Integer value2) {
            addCriterion("CBAB08 between", value1, value2, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB08 not between", value1, value2, "cbab08");
            return (Criteria) this;
        }

        public Criteria andCbab09IsNull() {
            addCriterion("CBAB09 is null");
            return (Criteria) this;
        }

        public Criteria andCbab09IsNotNull() {
            addCriterion("CBAB09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab09EqualTo(Double value) {
            addCriterion("CBAB09 =", value, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09NotEqualTo(Double value) {
            addCriterion("CBAB09 <>", value, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09GreaterThan(Double value) {
            addCriterion("CBAB09 >", value, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBAB09 >=", value, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09LessThan(Double value) {
            addCriterion("CBAB09 <", value, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09LessThanOrEqualTo(Double value) {
            addCriterion("CBAB09 <=", value, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09In(List<Double> values) {
            addCriterion("CBAB09 in", values, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09NotIn(List<Double> values) {
            addCriterion("CBAB09 not in", values, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09Between(Double value1, Double value2) {
            addCriterion("CBAB09 between", value1, value2, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab09NotBetween(Double value1, Double value2) {
            addCriterion("CBAB09 not between", value1, value2, "cbab09");
            return (Criteria) this;
        }

        public Criteria andCbab10IsNull() {
            addCriterion("CBAB10 is null");
            return (Criteria) this;
        }

        public Criteria andCbab10IsNotNull() {
            addCriterion("CBAB10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab10EqualTo(Double value) {
            addCriterion("CBAB10 =", value, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10NotEqualTo(Double value) {
            addCriterion("CBAB10 <>", value, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10GreaterThan(Double value) {
            addCriterion("CBAB10 >", value, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBAB10 >=", value, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10LessThan(Double value) {
            addCriterion("CBAB10 <", value, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10LessThanOrEqualTo(Double value) {
            addCriterion("CBAB10 <=", value, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10In(List<Double> values) {
            addCriterion("CBAB10 in", values, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10NotIn(List<Double> values) {
            addCriterion("CBAB10 not in", values, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10Between(Double value1, Double value2) {
            addCriterion("CBAB10 between", value1, value2, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab10NotBetween(Double value1, Double value2) {
            addCriterion("CBAB10 not between", value1, value2, "cbab10");
            return (Criteria) this;
        }

        public Criteria andCbab11IsNull() {
            addCriterion("CBAB11 is null");
            return (Criteria) this;
        }

        public Criteria andCbab11IsNotNull() {
            addCriterion("CBAB11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab11EqualTo(Double value) {
            addCriterion("CBAB11 =", value, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11NotEqualTo(Double value) {
            addCriterion("CBAB11 <>", value, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11GreaterThan(Double value) {
            addCriterion("CBAB11 >", value, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBAB11 >=", value, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11LessThan(Double value) {
            addCriterion("CBAB11 <", value, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11LessThanOrEqualTo(Double value) {
            addCriterion("CBAB11 <=", value, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11In(List<Double> values) {
            addCriterion("CBAB11 in", values, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11NotIn(List<Double> values) {
            addCriterion("CBAB11 not in", values, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11Between(Double value1, Double value2) {
            addCriterion("CBAB11 between", value1, value2, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab11NotBetween(Double value1, Double value2) {
            addCriterion("CBAB11 not between", value1, value2, "cbab11");
            return (Criteria) this;
        }

        public Criteria andCbab12IsNull() {
            addCriterion("CBAB12 is null");
            return (Criteria) this;
        }

        public Criteria andCbab12IsNotNull() {
            addCriterion("CBAB12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab12EqualTo(Double value) {
            addCriterion("CBAB12 =", value, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12NotEqualTo(Double value) {
            addCriterion("CBAB12 <>", value, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12GreaterThan(Double value) {
            addCriterion("CBAB12 >", value, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBAB12 >=", value, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12LessThan(Double value) {
            addCriterion("CBAB12 <", value, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12LessThanOrEqualTo(Double value) {
            addCriterion("CBAB12 <=", value, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12In(List<Double> values) {
            addCriterion("CBAB12 in", values, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12NotIn(List<Double> values) {
            addCriterion("CBAB12 not in", values, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12Between(Double value1, Double value2) {
            addCriterion("CBAB12 between", value1, value2, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab12NotBetween(Double value1, Double value2) {
            addCriterion("CBAB12 not between", value1, value2, "cbab12");
            return (Criteria) this;
        }

        public Criteria andCbab13IsNull() {
            addCriterion("CBAB13 is null");
            return (Criteria) this;
        }

        public Criteria andCbab13IsNotNull() {
            addCriterion("CBAB13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab13EqualTo(String value) {
            addCriterion("CBAB13 =", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13NotEqualTo(String value) {
            addCriterion("CBAB13 <>", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13GreaterThan(String value) {
            addCriterion("CBAB13 >", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13GreaterThanOrEqualTo(String value) {
            addCriterion("CBAB13 >=", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13LessThan(String value) {
            addCriterion("CBAB13 <", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13LessThanOrEqualTo(String value) {
            addCriterion("CBAB13 <=", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13Like(String value) {
            addCriterion("CBAB13 like", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13NotLike(String value) {
            addCriterion("CBAB13 not like", value, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13In(List<String> values) {
            addCriterion("CBAB13 in", values, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13NotIn(List<String> values) {
            addCriterion("CBAB13 not in", values, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13Between(String value1, String value2) {
            addCriterion("CBAB13 between", value1, value2, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbab13NotBetween(String value1, String value2) {
            addCriterion("CBAB13 not between", value1, value2, "cbab13");
            return (Criteria) this;
        }

        public Criteria andCbaa01IsNull() {
            addCriterion("CBAA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbaa01IsNotNull() {
            addCriterion("CBAA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbaa01EqualTo(Integer value) {
            addCriterion("CBAA01 =", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotEqualTo(Integer value) {
            addCriterion("CBAA01 <>", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01GreaterThan(Integer value) {
            addCriterion("CBAA01 >", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAA01 >=", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01LessThan(Integer value) {
            addCriterion("CBAA01 <", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBAA01 <=", value, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01In(List<Integer> values) {
            addCriterion("CBAA01 in", values, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotIn(List<Integer> values) {
            addCriterion("CBAA01 not in", values, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01Between(Integer value1, Integer value2) {
            addCriterion("CBAA01 between", value1, value2, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbaa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAA01 not between", value1, value2, "cbaa01");
            return (Criteria) this;
        }

        public Criteria andCbab14IsNull() {
            addCriterion("CBAB14 is null");
            return (Criteria) this;
        }

        public Criteria andCbab14IsNotNull() {
            addCriterion("CBAB14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab14EqualTo(Integer value) {
            addCriterion("CBAB14 =", value, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14NotEqualTo(Integer value) {
            addCriterion("CBAB14 <>", value, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14GreaterThan(Integer value) {
            addCriterion("CBAB14 >", value, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB14 >=", value, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14LessThan(Integer value) {
            addCriterion("CBAB14 <", value, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB14 <=", value, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14In(List<Integer> values) {
            addCriterion("CBAB14 in", values, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14NotIn(List<Integer> values) {
            addCriterion("CBAB14 not in", values, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14Between(Integer value1, Integer value2) {
            addCriterion("CBAB14 between", value1, value2, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB14 not between", value1, value2, "cbab14");
            return (Criteria) this;
        }

        public Criteria andCbab15IsNull() {
            addCriterion("CBAB15 is null");
            return (Criteria) this;
        }

        public Criteria andCbab15IsNotNull() {
            addCriterion("CBAB15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab15EqualTo(Integer value) {
            addCriterion("CBAB15 =", value, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15NotEqualTo(Integer value) {
            addCriterion("CBAB15 <>", value, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15GreaterThan(Integer value) {
            addCriterion("CBAB15 >", value, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB15 >=", value, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15LessThan(Integer value) {
            addCriterion("CBAB15 <", value, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB15 <=", value, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15In(List<Integer> values) {
            addCriterion("CBAB15 in", values, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15NotIn(List<Integer> values) {
            addCriterion("CBAB15 not in", values, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15Between(Integer value1, Integer value2) {
            addCriterion("CBAB15 between", value1, value2, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB15 not between", value1, value2, "cbab15");
            return (Criteria) this;
        }

        public Criteria andCbab16IsNull() {
            addCriterion("CBAB16 is null");
            return (Criteria) this;
        }

        public Criteria andCbab16IsNotNull() {
            addCriterion("CBAB16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab16EqualTo(Integer value) {
            addCriterion("CBAB16 =", value, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16NotEqualTo(Integer value) {
            addCriterion("CBAB16 <>", value, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16GreaterThan(Integer value) {
            addCriterion("CBAB16 >", value, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB16 >=", value, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16LessThan(Integer value) {
            addCriterion("CBAB16 <", value, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB16 <=", value, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16In(List<Integer> values) {
            addCriterion("CBAB16 in", values, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16NotIn(List<Integer> values) {
            addCriterion("CBAB16 not in", values, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16Between(Integer value1, Integer value2) {
            addCriterion("CBAB16 between", value1, value2, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB16 not between", value1, value2, "cbab16");
            return (Criteria) this;
        }

        public Criteria andCbab17IsNull() {
            addCriterion("CBAB17 is null");
            return (Criteria) this;
        }

        public Criteria andCbab17IsNotNull() {
            addCriterion("CBAB17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbab17EqualTo(Integer value) {
            addCriterion("CBAB17 =", value, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17NotEqualTo(Integer value) {
            addCriterion("CBAB17 <>", value, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17GreaterThan(Integer value) {
            addCriterion("CBAB17 >", value, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBAB17 >=", value, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17LessThan(Integer value) {
            addCriterion("CBAB17 <", value, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17LessThanOrEqualTo(Integer value) {
            addCriterion("CBAB17 <=", value, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17In(List<Integer> values) {
            addCriterion("CBAB17 in", values, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17NotIn(List<Integer> values) {
            addCriterion("CBAB17 not in", values, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17Between(Integer value1, Integer value2) {
            addCriterion("CBAB17 between", value1, value2, "cbab17");
            return (Criteria) this;
        }

        public Criteria andCbab17NotBetween(Integer value1, Integer value2) {
            addCriterion("CBAB17 not between", value1, value2, "cbab17");
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
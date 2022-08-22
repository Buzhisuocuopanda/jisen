package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbplCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbplCriteria() {
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

        public Criteria andCbpl01IsNull() {
            addCriterion("CBPL01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl01IsNotNull() {
            addCriterion("CBPL01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl01EqualTo(Integer value) {
            addCriterion("CBPL01 =", value, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01NotEqualTo(Integer value) {
            addCriterion("CBPL01 <>", value, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01GreaterThan(Integer value) {
            addCriterion("CBPL01 >", value, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL01 >=", value, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01LessThan(Integer value) {
            addCriterion("CBPL01 <", value, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL01 <=", value, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01In(List<Integer> values) {
            addCriterion("CBPL01 in", values, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01NotIn(List<Integer> values) {
            addCriterion("CBPL01 not in", values, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01Between(Integer value1, Integer value2) {
            addCriterion("CBPL01 between", value1, value2, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL01 not between", value1, value2, "cbpl01");
            return (Criteria) this;
        }

        public Criteria andCbpl02IsNull() {
            addCriterion("CBPL02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl02IsNotNull() {
            addCriterion("CBPL02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl02EqualTo(Integer value) {
            addCriterion("CBPL02 =", value, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02NotEqualTo(Integer value) {
            addCriterion("CBPL02 <>", value, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02GreaterThan(Integer value) {
            addCriterion("CBPL02 >", value, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL02 >=", value, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02LessThan(Integer value) {
            addCriterion("CBPL02 <", value, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL02 <=", value, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02In(List<Integer> values) {
            addCriterion("CBPL02 in", values, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02NotIn(List<Integer> values) {
            addCriterion("CBPL02 not in", values, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02Between(Integer value1, Integer value2) {
            addCriterion("CBPL02 between", value1, value2, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL02 not between", value1, value2, "cbpl02");
            return (Criteria) this;
        }

        public Criteria andCbpl03IsNull() {
            addCriterion("CBPL03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl03IsNotNull() {
            addCriterion("CBPL03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl03EqualTo(Date value) {
            addCriterion("CBPL03 =", value, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03NotEqualTo(Date value) {
            addCriterion("CBPL03 <>", value, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03GreaterThan(Date value) {
            addCriterion("CBPL03 >", value, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPL03 >=", value, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03LessThan(Date value) {
            addCriterion("CBPL03 <", value, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03LessThanOrEqualTo(Date value) {
            addCriterion("CBPL03 <=", value, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03In(List<Date> values) {
            addCriterion("CBPL03 in", values, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03NotIn(List<Date> values) {
            addCriterion("CBPL03 not in", values, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03Between(Date value1, Date value2) {
            addCriterion("CBPL03 between", value1, value2, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl03NotBetween(Date value1, Date value2) {
            addCriterion("CBPL03 not between", value1, value2, "cbpl03");
            return (Criteria) this;
        }

        public Criteria andCbpl04IsNull() {
            addCriterion("CBPL04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl04IsNotNull() {
            addCriterion("CBPL04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl04EqualTo(Integer value) {
            addCriterion("CBPL04 =", value, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04NotEqualTo(Integer value) {
            addCriterion("CBPL04 <>", value, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04GreaterThan(Integer value) {
            addCriterion("CBPL04 >", value, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL04 >=", value, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04LessThan(Integer value) {
            addCriterion("CBPL04 <", value, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL04 <=", value, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04In(List<Integer> values) {
            addCriterion("CBPL04 in", values, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04NotIn(List<Integer> values) {
            addCriterion("CBPL04 not in", values, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04Between(Integer value1, Integer value2) {
            addCriterion("CBPL04 between", value1, value2, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL04 not between", value1, value2, "cbpl04");
            return (Criteria) this;
        }

        public Criteria andCbpl05IsNull() {
            addCriterion("CBPL05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl05IsNotNull() {
            addCriterion("CBPL05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl05EqualTo(Date value) {
            addCriterion("CBPL05 =", value, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05NotEqualTo(Date value) {
            addCriterion("CBPL05 <>", value, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05GreaterThan(Date value) {
            addCriterion("CBPL05 >", value, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPL05 >=", value, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05LessThan(Date value) {
            addCriterion("CBPL05 <", value, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05LessThanOrEqualTo(Date value) {
            addCriterion("CBPL05 <=", value, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05In(List<Date> values) {
            addCriterion("CBPL05 in", values, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05NotIn(List<Date> values) {
            addCriterion("CBPL05 not in", values, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05Between(Date value1, Date value2) {
            addCriterion("CBPL05 between", value1, value2, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl05NotBetween(Date value1, Date value2) {
            addCriterion("CBPL05 not between", value1, value2, "cbpl05");
            return (Criteria) this;
        }

        public Criteria andCbpl06IsNull() {
            addCriterion("CBPL06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl06IsNotNull() {
            addCriterion("CBPL06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl06EqualTo(Integer value) {
            addCriterion("CBPL06 =", value, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06NotEqualTo(Integer value) {
            addCriterion("CBPL06 <>", value, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06GreaterThan(Integer value) {
            addCriterion("CBPL06 >", value, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL06 >=", value, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06LessThan(Integer value) {
            addCriterion("CBPL06 <", value, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL06 <=", value, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06In(List<Integer> values) {
            addCriterion("CBPL06 in", values, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06NotIn(List<Integer> values) {
            addCriterion("CBPL06 not in", values, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06Between(Integer value1, Integer value2) {
            addCriterion("CBPL06 between", value1, value2, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL06 not between", value1, value2, "cbpl06");
            return (Criteria) this;
        }

        public Criteria andCbpl07IsNull() {
            addCriterion("CBPL07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl07IsNotNull() {
            addCriterion("CBPL07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl07EqualTo(Integer value) {
            addCriterion("CBPL07 =", value, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07NotEqualTo(Integer value) {
            addCriterion("CBPL07 <>", value, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07GreaterThan(Integer value) {
            addCriterion("CBPL07 >", value, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL07 >=", value, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07LessThan(Integer value) {
            addCriterion("CBPL07 <", value, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL07 <=", value, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07In(List<Integer> values) {
            addCriterion("CBPL07 in", values, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07NotIn(List<Integer> values) {
            addCriterion("CBPL07 not in", values, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07Between(Integer value1, Integer value2) {
            addCriterion("CBPL07 between", value1, value2, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL07 not between", value1, value2, "cbpl07");
            return (Criteria) this;
        }

        public Criteria andCbpl08IsNull() {
            addCriterion("CBPL08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl08IsNotNull() {
            addCriterion("CBPL08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl08EqualTo(Integer value) {
            addCriterion("CBPL08 =", value, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08NotEqualTo(Integer value) {
            addCriterion("CBPL08 <>", value, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08GreaterThan(Integer value) {
            addCriterion("CBPL08 >", value, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL08 >=", value, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08LessThan(Integer value) {
            addCriterion("CBPL08 <", value, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL08 <=", value, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08In(List<Integer> values) {
            addCriterion("CBPL08 in", values, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08NotIn(List<Integer> values) {
            addCriterion("CBPL08 not in", values, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08Between(Integer value1, Integer value2) {
            addCriterion("CBPL08 between", value1, value2, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL08 not between", value1, value2, "cbpl08");
            return (Criteria) this;
        }

        public Criteria andCbpl09IsNull() {
            addCriterion("CBPL09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl09IsNotNull() {
            addCriterion("CBPL09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl09EqualTo(Double value) {
            addCriterion("CBPL09 =", value, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09NotEqualTo(Double value) {
            addCriterion("CBPL09 <>", value, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09GreaterThan(Double value) {
            addCriterion("CBPL09 >", value, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPL09 >=", value, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09LessThan(Double value) {
            addCriterion("CBPL09 <", value, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09LessThanOrEqualTo(Double value) {
            addCriterion("CBPL09 <=", value, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09In(List<Double> values) {
            addCriterion("CBPL09 in", values, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09NotIn(List<Double> values) {
            addCriterion("CBPL09 not in", values, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09Between(Double value1, Double value2) {
            addCriterion("CBPL09 between", value1, value2, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl09NotBetween(Double value1, Double value2) {
            addCriterion("CBPL09 not between", value1, value2, "cbpl09");
            return (Criteria) this;
        }

        public Criteria andCbpl10IsNull() {
            addCriterion("CBPL10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl10IsNotNull() {
            addCriterion("CBPL10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl10EqualTo(Double value) {
            addCriterion("CBPL10 =", value, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10NotEqualTo(Double value) {
            addCriterion("CBPL10 <>", value, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10GreaterThan(Double value) {
            addCriterion("CBPL10 >", value, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPL10 >=", value, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10LessThan(Double value) {
            addCriterion("CBPL10 <", value, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10LessThanOrEqualTo(Double value) {
            addCriterion("CBPL10 <=", value, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10In(List<Double> values) {
            addCriterion("CBPL10 in", values, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10NotIn(List<Double> values) {
            addCriterion("CBPL10 not in", values, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10Between(Double value1, Double value2) {
            addCriterion("CBPL10 between", value1, value2, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl10NotBetween(Double value1, Double value2) {
            addCriterion("CBPL10 not between", value1, value2, "cbpl10");
            return (Criteria) this;
        }

        public Criteria andCbpl11IsNull() {
            addCriterion("CBPL11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl11IsNotNull() {
            addCriterion("CBPL11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl11EqualTo(Double value) {
            addCriterion("CBPL11 =", value, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11NotEqualTo(Double value) {
            addCriterion("CBPL11 <>", value, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11GreaterThan(Double value) {
            addCriterion("CBPL11 >", value, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPL11 >=", value, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11LessThan(Double value) {
            addCriterion("CBPL11 <", value, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11LessThanOrEqualTo(Double value) {
            addCriterion("CBPL11 <=", value, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11In(List<Double> values) {
            addCriterion("CBPL11 in", values, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11NotIn(List<Double> values) {
            addCriterion("CBPL11 not in", values, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11Between(Double value1, Double value2) {
            addCriterion("CBPL11 between", value1, value2, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl11NotBetween(Double value1, Double value2) {
            addCriterion("CBPL11 not between", value1, value2, "cbpl11");
            return (Criteria) this;
        }

        public Criteria andCbpl12IsNull() {
            addCriterion("CBPL12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl12IsNotNull() {
            addCriterion("CBPL12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl12EqualTo(Double value) {
            addCriterion("CBPL12 =", value, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12NotEqualTo(Double value) {
            addCriterion("CBPL12 <>", value, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12GreaterThan(Double value) {
            addCriterion("CBPL12 >", value, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPL12 >=", value, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12LessThan(Double value) {
            addCriterion("CBPL12 <", value, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12LessThanOrEqualTo(Double value) {
            addCriterion("CBPL12 <=", value, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12In(List<Double> values) {
            addCriterion("CBPL12 in", values, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12NotIn(List<Double> values) {
            addCriterion("CBPL12 not in", values, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12Between(Double value1, Double value2) {
            addCriterion("CBPL12 between", value1, value2, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl12NotBetween(Double value1, Double value2) {
            addCriterion("CBPL12 not between", value1, value2, "cbpl12");
            return (Criteria) this;
        }

        public Criteria andCbpl13IsNull() {
            addCriterion("CBPL13 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl13IsNotNull() {
            addCriterion("CBPL13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl13EqualTo(String value) {
            addCriterion("CBPL13 =", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13NotEqualTo(String value) {
            addCriterion("CBPL13 <>", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13GreaterThan(String value) {
            addCriterion("CBPL13 >", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13GreaterThanOrEqualTo(String value) {
            addCriterion("CBPL13 >=", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13LessThan(String value) {
            addCriterion("CBPL13 <", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13LessThanOrEqualTo(String value) {
            addCriterion("CBPL13 <=", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13Like(String value) {
            addCriterion("CBPL13 like", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13NotLike(String value) {
            addCriterion("CBPL13 not like", value, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13In(List<String> values) {
            addCriterion("CBPL13 in", values, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13NotIn(List<String> values) {
            addCriterion("CBPL13 not in", values, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13Between(String value1, String value2) {
            addCriterion("CBPL13 between", value1, value2, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl13NotBetween(String value1, String value2) {
            addCriterion("CBPL13 not between", value1, value2, "cbpl13");
            return (Criteria) this;
        }

        public Criteria andCbpl14IsNull() {
            addCriterion("CBPL14 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl14IsNotNull() {
            addCriterion("CBPL14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl14EqualTo(Integer value) {
            addCriterion("CBPL14 =", value, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14NotEqualTo(Integer value) {
            addCriterion("CBPL14 <>", value, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14GreaterThan(Integer value) {
            addCriterion("CBPL14 >", value, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL14 >=", value, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14LessThan(Integer value) {
            addCriterion("CBPL14 <", value, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL14 <=", value, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14In(List<Integer> values) {
            addCriterion("CBPL14 in", values, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14NotIn(List<Integer> values) {
            addCriterion("CBPL14 not in", values, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14Between(Integer value1, Integer value2) {
            addCriterion("CBPL14 between", value1, value2, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL14 not between", value1, value2, "cbpl14");
            return (Criteria) this;
        }

        public Criteria andCbpl15IsNull() {
            addCriterion("CBPL15 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl15IsNotNull() {
            addCriterion("CBPL15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl15EqualTo(Integer value) {
            addCriterion("CBPL15 =", value, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15NotEqualTo(Integer value) {
            addCriterion("CBPL15 <>", value, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15GreaterThan(Integer value) {
            addCriterion("CBPL15 >", value, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL15 >=", value, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15LessThan(Integer value) {
            addCriterion("CBPL15 <", value, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL15 <=", value, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15In(List<Integer> values) {
            addCriterion("CBPL15 in", values, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15NotIn(List<Integer> values) {
            addCriterion("CBPL15 not in", values, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15Between(Integer value1, Integer value2) {
            addCriterion("CBPL15 between", value1, value2, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl15NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL15 not between", value1, value2, "cbpl15");
            return (Criteria) this;
        }

        public Criteria andCbpl16IsNull() {
            addCriterion("CBPL16 is null");
            return (Criteria) this;
        }

        public Criteria andCbpl16IsNotNull() {
            addCriterion("CBPL16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpl16EqualTo(Integer value) {
            addCriterion("CBPL16 =", value, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16NotEqualTo(Integer value) {
            addCriterion("CBPL16 <>", value, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16GreaterThan(Integer value) {
            addCriterion("CBPL16 >", value, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPL16 >=", value, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16LessThan(Integer value) {
            addCriterion("CBPL16 <", value, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16LessThanOrEqualTo(Integer value) {
            addCriterion("CBPL16 <=", value, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16In(List<Integer> values) {
            addCriterion("CBPL16 in", values, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16NotIn(List<Integer> values) {
            addCriterion("CBPL16 not in", values, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16Between(Integer value1, Integer value2) {
            addCriterion("CBPL16 between", value1, value2, "cbpl16");
            return (Criteria) this;
        }

        public Criteria andCbpl16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPL16 not between", value1, value2, "cbpl16");
            return (Criteria) this;
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

        public Criteria andGoodProductQtyIsNull() {
            addCriterion("good_product_qty is null");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyIsNotNull() {
            addCriterion("good_product_qty is not null");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyEqualTo(Double value) {
            addCriterion("good_product_qty =", value, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyNotEqualTo(Double value) {
            addCriterion("good_product_qty <>", value, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyGreaterThan(Double value) {
            addCriterion("good_product_qty >", value, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyGreaterThanOrEqualTo(Double value) {
            addCriterion("good_product_qty >=", value, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyLessThan(Double value) {
            addCriterion("good_product_qty <", value, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyLessThanOrEqualTo(Double value) {
            addCriterion("good_product_qty <=", value, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyIn(List<Double> values) {
            addCriterion("good_product_qty in", values, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyNotIn(List<Double> values) {
            addCriterion("good_product_qty not in", values, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyBetween(Double value1, Double value2) {
            addCriterion("good_product_qty between", value1, value2, "goodProductQty");
            return (Criteria) this;
        }

        public Criteria andGoodProductQtyNotBetween(Double value1, Double value2) {
            addCriterion("good_product_qty not between", value1, value2, "goodProductQty");
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
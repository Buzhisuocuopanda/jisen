package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbofCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbofCriteria() {
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

        public Criteria andCbof01IsNull() {
            addCriterion("CBOF01 is null");
            return (Criteria) this;
        }

        public Criteria andCbof01IsNotNull() {
            addCriterion("CBOF01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof01EqualTo(Integer value) {
            addCriterion("CBOF01 =", value, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01NotEqualTo(Integer value) {
            addCriterion("CBOF01 <>", value, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01GreaterThan(Integer value) {
            addCriterion("CBOF01 >", value, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOF01 >=", value, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01LessThan(Integer value) {
            addCriterion("CBOF01 <", value, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOF01 <=", value, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01In(List<Integer> values) {
            addCriterion("CBOF01 in", values, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01NotIn(List<Integer> values) {
            addCriterion("CBOF01 not in", values, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01Between(Integer value1, Integer value2) {
            addCriterion("CBOF01 between", value1, value2, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOF01 not between", value1, value2, "cbof01");
            return (Criteria) this;
        }

        public Criteria andCbof02IsNull() {
            addCriterion("CBOF02 is null");
            return (Criteria) this;
        }

        public Criteria andCbof02IsNotNull() {
            addCriterion("CBOF02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof02EqualTo(Integer value) {
            addCriterion("CBOF02 =", value, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02NotEqualTo(Integer value) {
            addCriterion("CBOF02 <>", value, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02GreaterThan(Integer value) {
            addCriterion("CBOF02 >", value, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOF02 >=", value, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02LessThan(Integer value) {
            addCriterion("CBOF02 <", value, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02LessThanOrEqualTo(Integer value) {
            addCriterion("CBOF02 <=", value, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02In(List<Integer> values) {
            addCriterion("CBOF02 in", values, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02NotIn(List<Integer> values) {
            addCriterion("CBOF02 not in", values, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02Between(Integer value1, Integer value2) {
            addCriterion("CBOF02 between", value1, value2, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOF02 not between", value1, value2, "cbof02");
            return (Criteria) this;
        }

        public Criteria andCbof03IsNull() {
            addCriterion("CBOF03 is null");
            return (Criteria) this;
        }

        public Criteria andCbof03IsNotNull() {
            addCriterion("CBOF03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof03EqualTo(Date value) {
            addCriterion("CBOF03 =", value, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03NotEqualTo(Date value) {
            addCriterion("CBOF03 <>", value, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03GreaterThan(Date value) {
            addCriterion("CBOF03 >", value, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOF03 >=", value, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03LessThan(Date value) {
            addCriterion("CBOF03 <", value, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03LessThanOrEqualTo(Date value) {
            addCriterion("CBOF03 <=", value, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03In(List<Date> values) {
            addCriterion("CBOF03 in", values, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03NotIn(List<Date> values) {
            addCriterion("CBOF03 not in", values, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03Between(Date value1, Date value2) {
            addCriterion("CBOF03 between", value1, value2, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof03NotBetween(Date value1, Date value2) {
            addCriterion("CBOF03 not between", value1, value2, "cbof03");
            return (Criteria) this;
        }

        public Criteria andCbof04IsNull() {
            addCriterion("CBOF04 is null");
            return (Criteria) this;
        }

        public Criteria andCbof04IsNotNull() {
            addCriterion("CBOF04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof04EqualTo(Integer value) {
            addCriterion("CBOF04 =", value, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04NotEqualTo(Integer value) {
            addCriterion("CBOF04 <>", value, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04GreaterThan(Integer value) {
            addCriterion("CBOF04 >", value, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOF04 >=", value, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04LessThan(Integer value) {
            addCriterion("CBOF04 <", value, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04LessThanOrEqualTo(Integer value) {
            addCriterion("CBOF04 <=", value, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04In(List<Integer> values) {
            addCriterion("CBOF04 in", values, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04NotIn(List<Integer> values) {
            addCriterion("CBOF04 not in", values, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04Between(Integer value1, Integer value2) {
            addCriterion("CBOF04 between", value1, value2, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOF04 not between", value1, value2, "cbof04");
            return (Criteria) this;
        }

        public Criteria andCbof05IsNull() {
            addCriterion("CBOF05 is null");
            return (Criteria) this;
        }

        public Criteria andCbof05IsNotNull() {
            addCriterion("CBOF05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof05EqualTo(Date value) {
            addCriterion("CBOF05 =", value, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05NotEqualTo(Date value) {
            addCriterion("CBOF05 <>", value, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05GreaterThan(Date value) {
            addCriterion("CBOF05 >", value, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOF05 >=", value, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05LessThan(Date value) {
            addCriterion("CBOF05 <", value, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05LessThanOrEqualTo(Date value) {
            addCriterion("CBOF05 <=", value, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05In(List<Date> values) {
            addCriterion("CBOF05 in", values, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05NotIn(List<Date> values) {
            addCriterion("CBOF05 not in", values, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05Between(Date value1, Date value2) {
            addCriterion("CBOF05 between", value1, value2, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof05NotBetween(Date value1, Date value2) {
            addCriterion("CBOF05 not between", value1, value2, "cbof05");
            return (Criteria) this;
        }

        public Criteria andCbof06IsNull() {
            addCriterion("CBOF06 is null");
            return (Criteria) this;
        }

        public Criteria andCbof06IsNotNull() {
            addCriterion("CBOF06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof06EqualTo(Integer value) {
            addCriterion("CBOF06 =", value, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06NotEqualTo(Integer value) {
            addCriterion("CBOF06 <>", value, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06GreaterThan(Integer value) {
            addCriterion("CBOF06 >", value, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOF06 >=", value, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06LessThan(Integer value) {
            addCriterion("CBOF06 <", value, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06LessThanOrEqualTo(Integer value) {
            addCriterion("CBOF06 <=", value, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06In(List<Integer> values) {
            addCriterion("CBOF06 in", values, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06NotIn(List<Integer> values) {
            addCriterion("CBOF06 not in", values, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06Between(Integer value1, Integer value2) {
            addCriterion("CBOF06 between", value1, value2, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOF06 not between", value1, value2, "cbof06");
            return (Criteria) this;
        }

        public Criteria andCbof07IsNull() {
            addCriterion("CBOF07 is null");
            return (Criteria) this;
        }

        public Criteria andCbof07IsNotNull() {
            addCriterion("CBOF07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof07EqualTo(Integer value) {
            addCriterion("CBOF07 =", value, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07NotEqualTo(Integer value) {
            addCriterion("CBOF07 <>", value, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07GreaterThan(Integer value) {
            addCriterion("CBOF07 >", value, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOF07 >=", value, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07LessThan(Integer value) {
            addCriterion("CBOF07 <", value, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07LessThanOrEqualTo(Integer value) {
            addCriterion("CBOF07 <=", value, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07In(List<Integer> values) {
            addCriterion("CBOF07 in", values, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07NotIn(List<Integer> values) {
            addCriterion("CBOF07 not in", values, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07Between(Integer value1, Integer value2) {
            addCriterion("CBOF07 between", value1, value2, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOF07 not between", value1, value2, "cbof07");
            return (Criteria) this;
        }

        public Criteria andCbof08IsNull() {
            addCriterion("CBOF08 is null");
            return (Criteria) this;
        }

        public Criteria andCbof08IsNotNull() {
            addCriterion("CBOF08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof08EqualTo(Integer value) {
            addCriterion("CBOF08 =", value, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08NotEqualTo(Integer value) {
            addCriterion("CBOF08 <>", value, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08GreaterThan(Integer value) {
            addCriterion("CBOF08 >", value, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOF08 >=", value, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08LessThan(Integer value) {
            addCriterion("CBOF08 <", value, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08LessThanOrEqualTo(Integer value) {
            addCriterion("CBOF08 <=", value, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08In(List<Integer> values) {
            addCriterion("CBOF08 in", values, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08NotIn(List<Integer> values) {
            addCriterion("CBOF08 not in", values, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08Between(Integer value1, Integer value2) {
            addCriterion("CBOF08 between", value1, value2, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOF08 not between", value1, value2, "cbof08");
            return (Criteria) this;
        }

        public Criteria andCbof09IsNull() {
            addCriterion("CBOF09 is null");
            return (Criteria) this;
        }

        public Criteria andCbof09IsNotNull() {
            addCriterion("CBOF09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof09EqualTo(Double value) {
            addCriterion("CBOF09 =", value, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09NotEqualTo(Double value) {
            addCriterion("CBOF09 <>", value, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09GreaterThan(Double value) {
            addCriterion("CBOF09 >", value, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOF09 >=", value, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09LessThan(Double value) {
            addCriterion("CBOF09 <", value, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09LessThanOrEqualTo(Double value) {
            addCriterion("CBOF09 <=", value, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09In(List<Double> values) {
            addCriterion("CBOF09 in", values, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09NotIn(List<Double> values) {
            addCriterion("CBOF09 not in", values, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09Between(Double value1, Double value2) {
            addCriterion("CBOF09 between", value1, value2, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof09NotBetween(Double value1, Double value2) {
            addCriterion("CBOF09 not between", value1, value2, "cbof09");
            return (Criteria) this;
        }

        public Criteria andCbof13IsNull() {
            addCriterion("CBOF13 is null");
            return (Criteria) this;
        }

        public Criteria andCbof13IsNotNull() {
            addCriterion("CBOF13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbof13EqualTo(String value) {
            addCriterion("CBOF13 =", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13NotEqualTo(String value) {
            addCriterion("CBOF13 <>", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13GreaterThan(String value) {
            addCriterion("CBOF13 >", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13GreaterThanOrEqualTo(String value) {
            addCriterion("CBOF13 >=", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13LessThan(String value) {
            addCriterion("CBOF13 <", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13LessThanOrEqualTo(String value) {
            addCriterion("CBOF13 <=", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13Like(String value) {
            addCriterion("CBOF13 like", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13NotLike(String value) {
            addCriterion("CBOF13 not like", value, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13In(List<String> values) {
            addCriterion("CBOF13 in", values, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13NotIn(List<String> values) {
            addCriterion("CBOF13 not in", values, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13Between(String value1, String value2) {
            addCriterion("CBOF13 between", value1, value2, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCbof13NotBetween(String value1, String value2) {
            addCriterion("CBOF13 not between", value1, value2, "cbof13");
            return (Criteria) this;
        }

        public Criteria andCboe01IsNull() {
            addCriterion("CBOE01 is null");
            return (Criteria) this;
        }

        public Criteria andCboe01IsNotNull() {
            addCriterion("CBOE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe01EqualTo(Integer value) {
            addCriterion("CBOE01 =", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01NotEqualTo(Integer value) {
            addCriterion("CBOE01 <>", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01GreaterThan(Integer value) {
            addCriterion("CBOE01 >", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE01 >=", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01LessThan(Integer value) {
            addCriterion("CBOE01 <", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE01 <=", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01In(List<Integer> values) {
            addCriterion("CBOE01 in", values, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01NotIn(List<Integer> values) {
            addCriterion("CBOE01 not in", values, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01Between(Integer value1, Integer value2) {
            addCriterion("CBOE01 between", value1, value2, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE01 not between", value1, value2, "cboe01");
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
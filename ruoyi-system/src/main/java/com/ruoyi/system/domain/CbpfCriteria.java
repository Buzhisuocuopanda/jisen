package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpfCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpfCriteria() {
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

        public Criteria andCbpf01IsNull() {
            addCriterion("CBPF01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf01IsNotNull() {
            addCriterion("CBPF01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf01EqualTo(Integer value) {
            addCriterion("CBPF01 =", value, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01NotEqualTo(Integer value) {
            addCriterion("CBPF01 <>", value, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01GreaterThan(Integer value) {
            addCriterion("CBPF01 >", value, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPF01 >=", value, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01LessThan(Integer value) {
            addCriterion("CBPF01 <", value, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPF01 <=", value, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01In(List<Integer> values) {
            addCriterion("CBPF01 in", values, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01NotIn(List<Integer> values) {
            addCriterion("CBPF01 not in", values, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01Between(Integer value1, Integer value2) {
            addCriterion("CBPF01 between", value1, value2, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPF01 not between", value1, value2, "cbpf01");
            return (Criteria) this;
        }

        public Criteria andCbpf02IsNull() {
            addCriterion("CBPF02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf02IsNotNull() {
            addCriterion("CBPF02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf02EqualTo(Integer value) {
            addCriterion("CBPF02 =", value, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02NotEqualTo(Integer value) {
            addCriterion("CBPF02 <>", value, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02GreaterThan(Integer value) {
            addCriterion("CBPF02 >", value, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPF02 >=", value, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02LessThan(Integer value) {
            addCriterion("CBPF02 <", value, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPF02 <=", value, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02In(List<Integer> values) {
            addCriterion("CBPF02 in", values, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02NotIn(List<Integer> values) {
            addCriterion("CBPF02 not in", values, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02Between(Integer value1, Integer value2) {
            addCriterion("CBPF02 between", value1, value2, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPF02 not between", value1, value2, "cbpf02");
            return (Criteria) this;
        }

        public Criteria andCbpf03IsNull() {
            addCriterion("CBPF03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf03IsNotNull() {
            addCriterion("CBPF03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf03EqualTo(Integer value) {
            addCriterion("CBPF03 =", value, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03NotEqualTo(Integer value) {
            addCriterion("CBPF03 <>", value, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03GreaterThan(Integer value) {
            addCriterion("CBPF03 >", value, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPF03 >=", value, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03LessThan(Integer value) {
            addCriterion("CBPF03 <", value, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03LessThanOrEqualTo(Integer value) {
            addCriterion("CBPF03 <=", value, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03In(List<Integer> values) {
            addCriterion("CBPF03 in", values, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03NotIn(List<Integer> values) {
            addCriterion("CBPF03 not in", values, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03Between(Integer value1, Integer value2) {
            addCriterion("CBPF03 between", value1, value2, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPF03 not between", value1, value2, "cbpf03");
            return (Criteria) this;
        }

        public Criteria andCbpf04IsNull() {
            addCriterion("CBPF04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf04IsNotNull() {
            addCriterion("CBPF04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf04EqualTo(Double value) {
            addCriterion("CBPF04 =", value, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04NotEqualTo(Double value) {
            addCriterion("CBPF04 <>", value, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04GreaterThan(Double value) {
            addCriterion("CBPF04 >", value, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPF04 >=", value, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04LessThan(Double value) {
            addCriterion("CBPF04 <", value, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04LessThanOrEqualTo(Double value) {
            addCriterion("CBPF04 <=", value, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04In(List<Double> values) {
            addCriterion("CBPF04 in", values, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04NotIn(List<Double> values) {
            addCriterion("CBPF04 not in", values, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04Between(Double value1, Double value2) {
            addCriterion("CBPF04 between", value1, value2, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf04NotBetween(Double value1, Double value2) {
            addCriterion("CBPF04 not between", value1, value2, "cbpf04");
            return (Criteria) this;
        }

        public Criteria andCbpf05IsNull() {
            addCriterion("CBPF05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf05IsNotNull() {
            addCriterion("CBPF05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf05EqualTo(Double value) {
            addCriterion("CBPF05 =", value, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05NotEqualTo(Double value) {
            addCriterion("CBPF05 <>", value, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05GreaterThan(Double value) {
            addCriterion("CBPF05 >", value, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPF05 >=", value, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05LessThan(Double value) {
            addCriterion("CBPF05 <", value, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05LessThanOrEqualTo(Double value) {
            addCriterion("CBPF05 <=", value, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05In(List<Double> values) {
            addCriterion("CBPF05 in", values, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05NotIn(List<Double> values) {
            addCriterion("CBPF05 not in", values, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05Between(Double value1, Double value2) {
            addCriterion("CBPF05 between", value1, value2, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpf05NotBetween(Double value1, Double value2) {
            addCriterion("CBPF05 not between", value1, value2, "cbpf05");
            return (Criteria) this;
        }

        public Criteria andCbpb01IsNull() {
            addCriterion("CBPB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb01IsNotNull() {
            addCriterion("CBPB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb01EqualTo(Integer value) {
            addCriterion("CBPB01 =", value, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01NotEqualTo(Integer value) {
            addCriterion("CBPB01 <>", value, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01GreaterThan(Integer value) {
            addCriterion("CBPB01 >", value, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB01 >=", value, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01LessThan(Integer value) {
            addCriterion("CBPB01 <", value, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB01 <=", value, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01In(List<Integer> values) {
            addCriterion("CBPB01 in", values, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01NotIn(List<Integer> values) {
            addCriterion("CBPB01 not in", values, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01Between(Integer value1, Integer value2) {
            addCriterion("CBPB01 between", value1, value2, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpb01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB01 not between", value1, value2, "cbpb01");
            return (Criteria) this;
        }

        public Criteria andCbpf06IsNull() {
            addCriterion("CBPF06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf06IsNotNull() {
            addCriterion("CBPF06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf06EqualTo(Integer value) {
            addCriterion("CBPF06 =", value, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06NotEqualTo(Integer value) {
            addCriterion("CBPF06 <>", value, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06GreaterThan(Integer value) {
            addCriterion("CBPF06 >", value, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPF06 >=", value, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06LessThan(Integer value) {
            addCriterion("CBPF06 <", value, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPF06 <=", value, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06In(List<Integer> values) {
            addCriterion("CBPF06 in", values, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06NotIn(List<Integer> values) {
            addCriterion("CBPF06 not in", values, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06Between(Integer value1, Integer value2) {
            addCriterion("CBPF06 between", value1, value2, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPF06 not between", value1, value2, "cbpf06");
            return (Criteria) this;
        }

        public Criteria andCbpf07IsNull() {
            addCriterion("CBPF07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpf07IsNotNull() {
            addCriterion("CBPF07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpf07EqualTo(Date value) {
            addCriterion("CBPF07 =", value, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07NotEqualTo(Date value) {
            addCriterion("CBPF07 <>", value, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07GreaterThan(Date value) {
            addCriterion("CBPF07 >", value, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPF07 >=", value, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07LessThan(Date value) {
            addCriterion("CBPF07 <", value, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07LessThanOrEqualTo(Date value) {
            addCriterion("CBPF07 <=", value, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07In(List<Date> values) {
            addCriterion("CBPF07 in", values, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07NotIn(List<Date> values) {
            addCriterion("CBPF07 not in", values, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07Between(Date value1, Date value2) {
            addCriterion("CBPF07 between", value1, value2, "cbpf07");
            return (Criteria) this;
        }

        public Criteria andCbpf07NotBetween(Date value1, Date value2) {
            addCriterion("CBPF07 not between", value1, value2, "cbpf07");
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
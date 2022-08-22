package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbodCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbodCriteria() {
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

        public Criteria andCbod01IsNull() {
            addCriterion("CBOD01 is null");
            return (Criteria) this;
        }

        public Criteria andCbod01IsNotNull() {
            addCriterion("CBOD01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod01EqualTo(Integer value) {
            addCriterion("CBOD01 =", value, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01NotEqualTo(Integer value) {
            addCriterion("CBOD01 <>", value, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01GreaterThan(Integer value) {
            addCriterion("CBOD01 >", value, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD01 >=", value, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01LessThan(Integer value) {
            addCriterion("CBOD01 <", value, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD01 <=", value, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01In(List<Integer> values) {
            addCriterion("CBOD01 in", values, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01NotIn(List<Integer> values) {
            addCriterion("CBOD01 not in", values, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01Between(Integer value1, Integer value2) {
            addCriterion("CBOD01 between", value1, value2, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD01 not between", value1, value2, "cbod01");
            return (Criteria) this;
        }

        public Criteria andCbod02IsNull() {
            addCriterion("CBOD02 is null");
            return (Criteria) this;
        }

        public Criteria andCbod02IsNotNull() {
            addCriterion("CBOD02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod02EqualTo(Integer value) {
            addCriterion("CBOD02 =", value, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02NotEqualTo(Integer value) {
            addCriterion("CBOD02 <>", value, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02GreaterThan(Integer value) {
            addCriterion("CBOD02 >", value, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD02 >=", value, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02LessThan(Integer value) {
            addCriterion("CBOD02 <", value, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD02 <=", value, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02In(List<Integer> values) {
            addCriterion("CBOD02 in", values, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02NotIn(List<Integer> values) {
            addCriterion("CBOD02 not in", values, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02Between(Integer value1, Integer value2) {
            addCriterion("CBOD02 between", value1, value2, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD02 not between", value1, value2, "cbod02");
            return (Criteria) this;
        }

        public Criteria andCbod03IsNull() {
            addCriterion("CBOD03 is null");
            return (Criteria) this;
        }

        public Criteria andCbod03IsNotNull() {
            addCriterion("CBOD03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod03EqualTo(Date value) {
            addCriterion("CBOD03 =", value, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03NotEqualTo(Date value) {
            addCriterion("CBOD03 <>", value, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03GreaterThan(Date value) {
            addCriterion("CBOD03 >", value, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOD03 >=", value, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03LessThan(Date value) {
            addCriterion("CBOD03 <", value, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03LessThanOrEqualTo(Date value) {
            addCriterion("CBOD03 <=", value, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03In(List<Date> values) {
            addCriterion("CBOD03 in", values, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03NotIn(List<Date> values) {
            addCriterion("CBOD03 not in", values, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03Between(Date value1, Date value2) {
            addCriterion("CBOD03 between", value1, value2, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod03NotBetween(Date value1, Date value2) {
            addCriterion("CBOD03 not between", value1, value2, "cbod03");
            return (Criteria) this;
        }

        public Criteria andCbod04IsNull() {
            addCriterion("CBOD04 is null");
            return (Criteria) this;
        }

        public Criteria andCbod04IsNotNull() {
            addCriterion("CBOD04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod04EqualTo(Integer value) {
            addCriterion("CBOD04 =", value, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04NotEqualTo(Integer value) {
            addCriterion("CBOD04 <>", value, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04GreaterThan(Integer value) {
            addCriterion("CBOD04 >", value, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD04 >=", value, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04LessThan(Integer value) {
            addCriterion("CBOD04 <", value, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD04 <=", value, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04In(List<Integer> values) {
            addCriterion("CBOD04 in", values, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04NotIn(List<Integer> values) {
            addCriterion("CBOD04 not in", values, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04Between(Integer value1, Integer value2) {
            addCriterion("CBOD04 between", value1, value2, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD04 not between", value1, value2, "cbod04");
            return (Criteria) this;
        }

        public Criteria andCbod05IsNull() {
            addCriterion("CBOD05 is null");
            return (Criteria) this;
        }

        public Criteria andCbod05IsNotNull() {
            addCriterion("CBOD05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod05EqualTo(Date value) {
            addCriterion("CBOD05 =", value, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05NotEqualTo(Date value) {
            addCriterion("CBOD05 <>", value, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05GreaterThan(Date value) {
            addCriterion("CBOD05 >", value, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOD05 >=", value, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05LessThan(Date value) {
            addCriterion("CBOD05 <", value, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05LessThanOrEqualTo(Date value) {
            addCriterion("CBOD05 <=", value, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05In(List<Date> values) {
            addCriterion("CBOD05 in", values, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05NotIn(List<Date> values) {
            addCriterion("CBOD05 not in", values, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05Between(Date value1, Date value2) {
            addCriterion("CBOD05 between", value1, value2, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod05NotBetween(Date value1, Date value2) {
            addCriterion("CBOD05 not between", value1, value2, "cbod05");
            return (Criteria) this;
        }

        public Criteria andCbod06IsNull() {
            addCriterion("CBOD06 is null");
            return (Criteria) this;
        }

        public Criteria andCbod06IsNotNull() {
            addCriterion("CBOD06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod06EqualTo(Integer value) {
            addCriterion("CBOD06 =", value, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06NotEqualTo(Integer value) {
            addCriterion("CBOD06 <>", value, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06GreaterThan(Integer value) {
            addCriterion("CBOD06 >", value, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD06 >=", value, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06LessThan(Integer value) {
            addCriterion("CBOD06 <", value, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD06 <=", value, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06In(List<Integer> values) {
            addCriterion("CBOD06 in", values, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06NotIn(List<Integer> values) {
            addCriterion("CBOD06 not in", values, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06Between(Integer value1, Integer value2) {
            addCriterion("CBOD06 between", value1, value2, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD06 not between", value1, value2, "cbod06");
            return (Criteria) this;
        }

        public Criteria andCbod07IsNull() {
            addCriterion("CBOD07 is null");
            return (Criteria) this;
        }

        public Criteria andCbod07IsNotNull() {
            addCriterion("CBOD07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod07EqualTo(Integer value) {
            addCriterion("CBOD07 =", value, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07NotEqualTo(Integer value) {
            addCriterion("CBOD07 <>", value, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07GreaterThan(Integer value) {
            addCriterion("CBOD07 >", value, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD07 >=", value, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07LessThan(Integer value) {
            addCriterion("CBOD07 <", value, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD07 <=", value, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07In(List<Integer> values) {
            addCriterion("CBOD07 in", values, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07NotIn(List<Integer> values) {
            addCriterion("CBOD07 not in", values, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07Between(Integer value1, Integer value2) {
            addCriterion("CBOD07 between", value1, value2, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD07 not between", value1, value2, "cbod07");
            return (Criteria) this;
        }

        public Criteria andCbod08IsNull() {
            addCriterion("CBOD08 is null");
            return (Criteria) this;
        }

        public Criteria andCbod08IsNotNull() {
            addCriterion("CBOD08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod08EqualTo(Integer value) {
            addCriterion("CBOD08 =", value, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08NotEqualTo(Integer value) {
            addCriterion("CBOD08 <>", value, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08GreaterThan(Integer value) {
            addCriterion("CBOD08 >", value, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD08 >=", value, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08LessThan(Integer value) {
            addCriterion("CBOD08 <", value, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD08 <=", value, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08In(List<Integer> values) {
            addCriterion("CBOD08 in", values, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08NotIn(List<Integer> values) {
            addCriterion("CBOD08 not in", values, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08Between(Integer value1, Integer value2) {
            addCriterion("CBOD08 between", value1, value2, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD08 not between", value1, value2, "cbod08");
            return (Criteria) this;
        }

        public Criteria andCbod09IsNull() {
            addCriterion("CBOD09 is null");
            return (Criteria) this;
        }

        public Criteria andCbod09IsNotNull() {
            addCriterion("CBOD09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod09EqualTo(Double value) {
            addCriterion("CBOD09 =", value, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09NotEqualTo(Double value) {
            addCriterion("CBOD09 <>", value, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09GreaterThan(Double value) {
            addCriterion("CBOD09 >", value, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD09 >=", value, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09LessThan(Double value) {
            addCriterion("CBOD09 <", value, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09LessThanOrEqualTo(Double value) {
            addCriterion("CBOD09 <=", value, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09In(List<Double> values) {
            addCriterion("CBOD09 in", values, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09NotIn(List<Double> values) {
            addCriterion("CBOD09 not in", values, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09Between(Double value1, Double value2) {
            addCriterion("CBOD09 between", value1, value2, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod09NotBetween(Double value1, Double value2) {
            addCriterion("CBOD09 not between", value1, value2, "cbod09");
            return (Criteria) this;
        }

        public Criteria andCbod10IsNull() {
            addCriterion("CBOD10 is null");
            return (Criteria) this;
        }

        public Criteria andCbod10IsNotNull() {
            addCriterion("CBOD10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod10EqualTo(Double value) {
            addCriterion("CBOD10 =", value, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10NotEqualTo(Double value) {
            addCriterion("CBOD10 <>", value, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10GreaterThan(Double value) {
            addCriterion("CBOD10 >", value, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD10 >=", value, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10LessThan(Double value) {
            addCriterion("CBOD10 <", value, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10LessThanOrEqualTo(Double value) {
            addCriterion("CBOD10 <=", value, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10In(List<Double> values) {
            addCriterion("CBOD10 in", values, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10NotIn(List<Double> values) {
            addCriterion("CBOD10 not in", values, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10Between(Double value1, Double value2) {
            addCriterion("CBOD10 between", value1, value2, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod10NotBetween(Double value1, Double value2) {
            addCriterion("CBOD10 not between", value1, value2, "cbod10");
            return (Criteria) this;
        }

        public Criteria andCbod11IsNull() {
            addCriterion("CBOD11 is null");
            return (Criteria) this;
        }

        public Criteria andCbod11IsNotNull() {
            addCriterion("CBOD11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod11EqualTo(Double value) {
            addCriterion("CBOD11 =", value, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11NotEqualTo(Double value) {
            addCriterion("CBOD11 <>", value, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11GreaterThan(Double value) {
            addCriterion("CBOD11 >", value, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD11 >=", value, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11LessThan(Double value) {
            addCriterion("CBOD11 <", value, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11LessThanOrEqualTo(Double value) {
            addCriterion("CBOD11 <=", value, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11In(List<Double> values) {
            addCriterion("CBOD11 in", values, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11NotIn(List<Double> values) {
            addCriterion("CBOD11 not in", values, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11Between(Double value1, Double value2) {
            addCriterion("CBOD11 between", value1, value2, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod11NotBetween(Double value1, Double value2) {
            addCriterion("CBOD11 not between", value1, value2, "cbod11");
            return (Criteria) this;
        }

        public Criteria andCbod12IsNull() {
            addCriterion("CBOD12 is null");
            return (Criteria) this;
        }

        public Criteria andCbod12IsNotNull() {
            addCriterion("CBOD12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod12EqualTo(Double value) {
            addCriterion("CBOD12 =", value, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12NotEqualTo(Double value) {
            addCriterion("CBOD12 <>", value, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12GreaterThan(Double value) {
            addCriterion("CBOD12 >", value, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD12 >=", value, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12LessThan(Double value) {
            addCriterion("CBOD12 <", value, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12LessThanOrEqualTo(Double value) {
            addCriterion("CBOD12 <=", value, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12In(List<Double> values) {
            addCriterion("CBOD12 in", values, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12NotIn(List<Double> values) {
            addCriterion("CBOD12 not in", values, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12Between(Double value1, Double value2) {
            addCriterion("CBOD12 between", value1, value2, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod12NotBetween(Double value1, Double value2) {
            addCriterion("CBOD12 not between", value1, value2, "cbod12");
            return (Criteria) this;
        }

        public Criteria andCbod13IsNull() {
            addCriterion("CBOD13 is null");
            return (Criteria) this;
        }

        public Criteria andCbod13IsNotNull() {
            addCriterion("CBOD13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod13EqualTo(String value) {
            addCriterion("CBOD13 =", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13NotEqualTo(String value) {
            addCriterion("CBOD13 <>", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13GreaterThan(String value) {
            addCriterion("CBOD13 >", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13GreaterThanOrEqualTo(String value) {
            addCriterion("CBOD13 >=", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13LessThan(String value) {
            addCriterion("CBOD13 <", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13LessThanOrEqualTo(String value) {
            addCriterion("CBOD13 <=", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13Like(String value) {
            addCriterion("CBOD13 like", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13NotLike(String value) {
            addCriterion("CBOD13 not like", value, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13In(List<String> values) {
            addCriterion("CBOD13 in", values, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13NotIn(List<String> values) {
            addCriterion("CBOD13 not in", values, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13Between(String value1, String value2) {
            addCriterion("CBOD13 between", value1, value2, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod13NotBetween(String value1, String value2) {
            addCriterion("CBOD13 not between", value1, value2, "cbod13");
            return (Criteria) this;
        }

        public Criteria andCbod14IsNull() {
            addCriterion("CBOD14 is null");
            return (Criteria) this;
        }

        public Criteria andCbod14IsNotNull() {
            addCriterion("CBOD14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod14EqualTo(Double value) {
            addCriterion("CBOD14 =", value, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14NotEqualTo(Double value) {
            addCriterion("CBOD14 <>", value, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14GreaterThan(Double value) {
            addCriterion("CBOD14 >", value, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD14 >=", value, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14LessThan(Double value) {
            addCriterion("CBOD14 <", value, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14LessThanOrEqualTo(Double value) {
            addCriterion("CBOD14 <=", value, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14In(List<Double> values) {
            addCriterion("CBOD14 in", values, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14NotIn(List<Double> values) {
            addCriterion("CBOD14 not in", values, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14Between(Double value1, Double value2) {
            addCriterion("CBOD14 between", value1, value2, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod14NotBetween(Double value1, Double value2) {
            addCriterion("CBOD14 not between", value1, value2, "cbod14");
            return (Criteria) this;
        }

        public Criteria andCbod15IsNull() {
            addCriterion("CBOD15 is null");
            return (Criteria) this;
        }

        public Criteria andCbod15IsNotNull() {
            addCriterion("CBOD15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod15EqualTo(Double value) {
            addCriterion("CBOD15 =", value, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15NotEqualTo(Double value) {
            addCriterion("CBOD15 <>", value, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15GreaterThan(Double value) {
            addCriterion("CBOD15 >", value, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD15 >=", value, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15LessThan(Double value) {
            addCriterion("CBOD15 <", value, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15LessThanOrEqualTo(Double value) {
            addCriterion("CBOD15 <=", value, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15In(List<Double> values) {
            addCriterion("CBOD15 in", values, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15NotIn(List<Double> values) {
            addCriterion("CBOD15 not in", values, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15Between(Double value1, Double value2) {
            addCriterion("CBOD15 between", value1, value2, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod15NotBetween(Double value1, Double value2) {
            addCriterion("CBOD15 not between", value1, value2, "cbod15");
            return (Criteria) this;
        }

        public Criteria andCbod16IsNull() {
            addCriterion("CBOD16 is null");
            return (Criteria) this;
        }

        public Criteria andCbod16IsNotNull() {
            addCriterion("CBOD16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod16EqualTo(Integer value) {
            addCriterion("CBOD16 =", value, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16NotEqualTo(Integer value) {
            addCriterion("CBOD16 <>", value, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16GreaterThan(Integer value) {
            addCriterion("CBOD16 >", value, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOD16 >=", value, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16LessThan(Integer value) {
            addCriterion("CBOD16 <", value, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16LessThanOrEqualTo(Integer value) {
            addCriterion("CBOD16 <=", value, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16In(List<Integer> values) {
            addCriterion("CBOD16 in", values, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16NotIn(List<Integer> values) {
            addCriterion("CBOD16 not in", values, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16Between(Integer value1, Integer value2) {
            addCriterion("CBOD16 between", value1, value2, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOD16 not between", value1, value2, "cbod16");
            return (Criteria) this;
        }

        public Criteria andCbod17IsNull() {
            addCriterion("CBOD17 is null");
            return (Criteria) this;
        }

        public Criteria andCbod17IsNotNull() {
            addCriterion("CBOD17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod17EqualTo(Double value) {
            addCriterion("CBOD17 =", value, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17NotEqualTo(Double value) {
            addCriterion("CBOD17 <>", value, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17GreaterThan(Double value) {
            addCriterion("CBOD17 >", value, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD17 >=", value, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17LessThan(Double value) {
            addCriterion("CBOD17 <", value, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17LessThanOrEqualTo(Double value) {
            addCriterion("CBOD17 <=", value, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17In(List<Double> values) {
            addCriterion("CBOD17 in", values, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17NotIn(List<Double> values) {
            addCriterion("CBOD17 not in", values, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17Between(Double value1, Double value2) {
            addCriterion("CBOD17 between", value1, value2, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod17NotBetween(Double value1, Double value2) {
            addCriterion("CBOD17 not between", value1, value2, "cbod17");
            return (Criteria) this;
        }

        public Criteria andCbod18IsNull() {
            addCriterion("CBOD18 is null");
            return (Criteria) this;
        }

        public Criteria andCbod18IsNotNull() {
            addCriterion("CBOD18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbod18EqualTo(Double value) {
            addCriterion("CBOD18 =", value, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18NotEqualTo(Double value) {
            addCriterion("CBOD18 <>", value, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18GreaterThan(Double value) {
            addCriterion("CBOD18 >", value, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18GreaterThanOrEqualTo(Double value) {
            addCriterion("CBOD18 >=", value, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18LessThan(Double value) {
            addCriterion("CBOD18 <", value, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18LessThanOrEqualTo(Double value) {
            addCriterion("CBOD18 <=", value, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18In(List<Double> values) {
            addCriterion("CBOD18 in", values, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18NotIn(List<Double> values) {
            addCriterion("CBOD18 not in", values, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18Between(Double value1, Double value2) {
            addCriterion("CBOD18 between", value1, value2, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCbod18NotBetween(Double value1, Double value2) {
            addCriterion("CBOD18 not between", value1, value2, "cbod18");
            return (Criteria) this;
        }

        public Criteria andCboc01IsNull() {
            addCriterion("CBOC01 is null");
            return (Criteria) this;
        }

        public Criteria andCboc01IsNotNull() {
            addCriterion("CBOC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc01EqualTo(Integer value) {
            addCriterion("CBOC01 =", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01NotEqualTo(Integer value) {
            addCriterion("CBOC01 <>", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01GreaterThan(Integer value) {
            addCriterion("CBOC01 >", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC01 >=", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01LessThan(Integer value) {
            addCriterion("CBOC01 <", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC01 <=", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01In(List<Integer> values) {
            addCriterion("CBOC01 in", values, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01NotIn(List<Integer> values) {
            addCriterion("CBOC01 not in", values, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01Between(Integer value1, Integer value2) {
            addCriterion("CBOC01 between", value1, value2, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC01 not between", value1, value2, "cboc01");
            return (Criteria) this;
        }

        public Criteria andBefPriceIsNull() {
            addCriterion("bef_price is null");
            return (Criteria) this;
        }

        public Criteria andBefPriceIsNotNull() {
            addCriterion("bef_price is not null");
            return (Criteria) this;
        }

        public Criteria andBefPriceEqualTo(Double value) {
            addCriterion("bef_price =", value, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceNotEqualTo(Double value) {
            addCriterion("bef_price <>", value, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceGreaterThan(Double value) {
            addCriterion("bef_price >", value, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("bef_price >=", value, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceLessThan(Double value) {
            addCriterion("bef_price <", value, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceLessThanOrEqualTo(Double value) {
            addCriterion("bef_price <=", value, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceIn(List<Double> values) {
            addCriterion("bef_price in", values, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceNotIn(List<Double> values) {
            addCriterion("bef_price not in", values, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceBetween(Double value1, Double value2) {
            addCriterion("bef_price between", value1, value2, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefPriceNotBetween(Double value1, Double value2) {
            addCriterion("bef_price not between", value1, value2, "befPrice");
            return (Criteria) this;
        }

        public Criteria andBefQtyIsNull() {
            addCriterion("bef_qty is null");
            return (Criteria) this;
        }

        public Criteria andBefQtyIsNotNull() {
            addCriterion("bef_qty is not null");
            return (Criteria) this;
        }

        public Criteria andBefQtyEqualTo(Double value) {
            addCriterion("bef_qty =", value, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyNotEqualTo(Double value) {
            addCriterion("bef_qty <>", value, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyGreaterThan(Double value) {
            addCriterion("bef_qty >", value, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyGreaterThanOrEqualTo(Double value) {
            addCriterion("bef_qty >=", value, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyLessThan(Double value) {
            addCriterion("bef_qty <", value, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyLessThanOrEqualTo(Double value) {
            addCriterion("bef_qty <=", value, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyIn(List<Double> values) {
            addCriterion("bef_qty in", values, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyNotIn(List<Double> values) {
            addCriterion("bef_qty not in", values, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyBetween(Double value1, Double value2) {
            addCriterion("bef_qty between", value1, value2, "befQty");
            return (Criteria) this;
        }

        public Criteria andBefQtyNotBetween(Double value1, Double value2) {
            addCriterion("bef_qty not between", value1, value2, "befQty");
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
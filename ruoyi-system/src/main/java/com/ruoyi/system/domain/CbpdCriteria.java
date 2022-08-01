package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpdCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpdCriteria() {
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

        public Criteria andCbpd01IsNull() {
            addCriterion("CBPD01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd01IsNotNull() {
            addCriterion("CBPD01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd01EqualTo(Integer value) {
            addCriterion("CBPD01 =", value, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01NotEqualTo(Integer value) {
            addCriterion("CBPD01 <>", value, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01GreaterThan(Integer value) {
            addCriterion("CBPD01 >", value, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPD01 >=", value, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01LessThan(Integer value) {
            addCriterion("CBPD01 <", value, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPD01 <=", value, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01In(List<Integer> values) {
            addCriterion("CBPD01 in", values, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01NotIn(List<Integer> values) {
            addCriterion("CBPD01 not in", values, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01Between(Integer value1, Integer value2) {
            addCriterion("CBPD01 between", value1, value2, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPD01 not between", value1, value2, "cbpd01");
            return (Criteria) this;
        }

        public Criteria andCbpd02IsNull() {
            addCriterion("CBPD02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd02IsNotNull() {
            addCriterion("CBPD02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd02EqualTo(Integer value) {
            addCriterion("CBPD02 =", value, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02NotEqualTo(Integer value) {
            addCriterion("CBPD02 <>", value, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02GreaterThan(Integer value) {
            addCriterion("CBPD02 >", value, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPD02 >=", value, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02LessThan(Integer value) {
            addCriterion("CBPD02 <", value, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPD02 <=", value, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02In(List<Integer> values) {
            addCriterion("CBPD02 in", values, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02NotIn(List<Integer> values) {
            addCriterion("CBPD02 not in", values, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02Between(Integer value1, Integer value2) {
            addCriterion("CBPD02 between", value1, value2, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPD02 not between", value1, value2, "cbpd02");
            return (Criteria) this;
        }

        public Criteria andCbpd03IsNull() {
            addCriterion("CBPD03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd03IsNotNull() {
            addCriterion("CBPD03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd03EqualTo(Date value) {
            addCriterion("CBPD03 =", value, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03NotEqualTo(Date value) {
            addCriterion("CBPD03 <>", value, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03GreaterThan(Date value) {
            addCriterion("CBPD03 >", value, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPD03 >=", value, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03LessThan(Date value) {
            addCriterion("CBPD03 <", value, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03LessThanOrEqualTo(Date value) {
            addCriterion("CBPD03 <=", value, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03In(List<Date> values) {
            addCriterion("CBPD03 in", values, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03NotIn(List<Date> values) {
            addCriterion("CBPD03 not in", values, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03Between(Date value1, Date value2) {
            addCriterion("CBPD03 between", value1, value2, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd03NotBetween(Date value1, Date value2) {
            addCriterion("CBPD03 not between", value1, value2, "cbpd03");
            return (Criteria) this;
        }

        public Criteria andCbpd04IsNull() {
            addCriterion("CBPD04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd04IsNotNull() {
            addCriterion("CBPD04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd04EqualTo(Integer value) {
            addCriterion("CBPD04 =", value, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04NotEqualTo(Integer value) {
            addCriterion("CBPD04 <>", value, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04GreaterThan(Integer value) {
            addCriterion("CBPD04 >", value, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPD04 >=", value, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04LessThan(Integer value) {
            addCriterion("CBPD04 <", value, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPD04 <=", value, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04In(List<Integer> values) {
            addCriterion("CBPD04 in", values, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04NotIn(List<Integer> values) {
            addCriterion("CBPD04 not in", values, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04Between(Integer value1, Integer value2) {
            addCriterion("CBPD04 between", value1, value2, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPD04 not between", value1, value2, "cbpd04");
            return (Criteria) this;
        }

        public Criteria andCbpd05IsNull() {
            addCriterion("CBPD05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd05IsNotNull() {
            addCriterion("CBPD05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd05EqualTo(Date value) {
            addCriterion("CBPD05 =", value, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05NotEqualTo(Date value) {
            addCriterion("CBPD05 <>", value, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05GreaterThan(Date value) {
            addCriterion("CBPD05 >", value, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPD05 >=", value, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05LessThan(Date value) {
            addCriterion("CBPD05 <", value, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05LessThanOrEqualTo(Date value) {
            addCriterion("CBPD05 <=", value, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05In(List<Date> values) {
            addCriterion("CBPD05 in", values, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05NotIn(List<Date> values) {
            addCriterion("CBPD05 not in", values, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05Between(Date value1, Date value2) {
            addCriterion("CBPD05 between", value1, value2, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd05NotBetween(Date value1, Date value2) {
            addCriterion("CBPD05 not between", value1, value2, "cbpd05");
            return (Criteria) this;
        }

        public Criteria andCbpd06IsNull() {
            addCriterion("CBPD06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd06IsNotNull() {
            addCriterion("CBPD06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd06EqualTo(Integer value) {
            addCriterion("CBPD06 =", value, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06NotEqualTo(Integer value) {
            addCriterion("CBPD06 <>", value, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06GreaterThan(Integer value) {
            addCriterion("CBPD06 >", value, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPD06 >=", value, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06LessThan(Integer value) {
            addCriterion("CBPD06 <", value, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPD06 <=", value, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06In(List<Integer> values) {
            addCriterion("CBPD06 in", values, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06NotIn(List<Integer> values) {
            addCriterion("CBPD06 not in", values, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06Between(Integer value1, Integer value2) {
            addCriterion("CBPD06 between", value1, value2, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPD06 not between", value1, value2, "cbpd06");
            return (Criteria) this;
        }

        public Criteria andCbpd07IsNull() {
            addCriterion("CBPD07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd07IsNotNull() {
            addCriterion("CBPD07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd07EqualTo(Integer value) {
            addCriterion("CBPD07 =", value, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07NotEqualTo(Integer value) {
            addCriterion("CBPD07 <>", value, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07GreaterThan(Integer value) {
            addCriterion("CBPD07 >", value, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPD07 >=", value, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07LessThan(Integer value) {
            addCriterion("CBPD07 <", value, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07LessThanOrEqualTo(Integer value) {
            addCriterion("CBPD07 <=", value, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07In(List<Integer> values) {
            addCriterion("CBPD07 in", values, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07NotIn(List<Integer> values) {
            addCriterion("CBPD07 not in", values, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07Between(Integer value1, Integer value2) {
            addCriterion("CBPD07 between", value1, value2, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPD07 not between", value1, value2, "cbpd07");
            return (Criteria) this;
        }

        public Criteria andCbpd08IsNull() {
            addCriterion("CBPD08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd08IsNotNull() {
            addCriterion("CBPD08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd08EqualTo(Integer value) {
            addCriterion("CBPD08 =", value, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08NotEqualTo(Integer value) {
            addCriterion("CBPD08 <>", value, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08GreaterThan(Integer value) {
            addCriterion("CBPD08 >", value, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPD08 >=", value, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08LessThan(Integer value) {
            addCriterion("CBPD08 <", value, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08LessThanOrEqualTo(Integer value) {
            addCriterion("CBPD08 <=", value, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08In(List<Integer> values) {
            addCriterion("CBPD08 in", values, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08NotIn(List<Integer> values) {
            addCriterion("CBPD08 not in", values, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08Between(Integer value1, Integer value2) {
            addCriterion("CBPD08 between", value1, value2, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPD08 not between", value1, value2, "cbpd08");
            return (Criteria) this;
        }

        public Criteria andCbpd09IsNull() {
            addCriterion("CBPD09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd09IsNotNull() {
            addCriterion("CBPD09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd09EqualTo(Double value) {
            addCriterion("CBPD09 =", value, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09NotEqualTo(Double value) {
            addCriterion("CBPD09 <>", value, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09GreaterThan(Double value) {
            addCriterion("CBPD09 >", value, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPD09 >=", value, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09LessThan(Double value) {
            addCriterion("CBPD09 <", value, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09LessThanOrEqualTo(Double value) {
            addCriterion("CBPD09 <=", value, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09In(List<Double> values) {
            addCriterion("CBPD09 in", values, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09NotIn(List<Double> values) {
            addCriterion("CBPD09 not in", values, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09Between(Double value1, Double value2) {
            addCriterion("CBPD09 between", value1, value2, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd09NotBetween(Double value1, Double value2) {
            addCriterion("CBPD09 not between", value1, value2, "cbpd09");
            return (Criteria) this;
        }

        public Criteria andCbpd10IsNull() {
            addCriterion("CBPD10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd10IsNotNull() {
            addCriterion("CBPD10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd10EqualTo(Double value) {
            addCriterion("CBPD10 =", value, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10NotEqualTo(Double value) {
            addCriterion("CBPD10 <>", value, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10GreaterThan(Double value) {
            addCriterion("CBPD10 >", value, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPD10 >=", value, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10LessThan(Double value) {
            addCriterion("CBPD10 <", value, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10LessThanOrEqualTo(Double value) {
            addCriterion("CBPD10 <=", value, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10In(List<Double> values) {
            addCriterion("CBPD10 in", values, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10NotIn(List<Double> values) {
            addCriterion("CBPD10 not in", values, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10Between(Double value1, Double value2) {
            addCriterion("CBPD10 between", value1, value2, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd10NotBetween(Double value1, Double value2) {
            addCriterion("CBPD10 not between", value1, value2, "cbpd10");
            return (Criteria) this;
        }

        public Criteria andCbpd11IsNull() {
            addCriterion("CBPD11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd11IsNotNull() {
            addCriterion("CBPD11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd11EqualTo(Double value) {
            addCriterion("CBPD11 =", value, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11NotEqualTo(Double value) {
            addCriterion("CBPD11 <>", value, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11GreaterThan(Double value) {
            addCriterion("CBPD11 >", value, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPD11 >=", value, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11LessThan(Double value) {
            addCriterion("CBPD11 <", value, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11LessThanOrEqualTo(Double value) {
            addCriterion("CBPD11 <=", value, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11In(List<Double> values) {
            addCriterion("CBPD11 in", values, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11NotIn(List<Double> values) {
            addCriterion("CBPD11 not in", values, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11Between(Double value1, Double value2) {
            addCriterion("CBPD11 between", value1, value2, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd11NotBetween(Double value1, Double value2) {
            addCriterion("CBPD11 not between", value1, value2, "cbpd11");
            return (Criteria) this;
        }

        public Criteria andCbpd12IsNull() {
            addCriterion("CBPD12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd12IsNotNull() {
            addCriterion("CBPD12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd12EqualTo(Double value) {
            addCriterion("CBPD12 =", value, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12NotEqualTo(Double value) {
            addCriterion("CBPD12 <>", value, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12GreaterThan(Double value) {
            addCriterion("CBPD12 >", value, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPD12 >=", value, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12LessThan(Double value) {
            addCriterion("CBPD12 <", value, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12LessThanOrEqualTo(Double value) {
            addCriterion("CBPD12 <=", value, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12In(List<Double> values) {
            addCriterion("CBPD12 in", values, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12NotIn(List<Double> values) {
            addCriterion("CBPD12 not in", values, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12Between(Double value1, Double value2) {
            addCriterion("CBPD12 between", value1, value2, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd12NotBetween(Double value1, Double value2) {
            addCriterion("CBPD12 not between", value1, value2, "cbpd12");
            return (Criteria) this;
        }

        public Criteria andCbpd13IsNull() {
            addCriterion("CBPD13 is null");
            return (Criteria) this;
        }

        public Criteria andCbpd13IsNotNull() {
            addCriterion("CBPD13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpd13EqualTo(String value) {
            addCriterion("CBPD13 =", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13NotEqualTo(String value) {
            addCriterion("CBPD13 <>", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13GreaterThan(String value) {
            addCriterion("CBPD13 >", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13GreaterThanOrEqualTo(String value) {
            addCriterion("CBPD13 >=", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13LessThan(String value) {
            addCriterion("CBPD13 <", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13LessThanOrEqualTo(String value) {
            addCriterion("CBPD13 <=", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13Like(String value) {
            addCriterion("CBPD13 like", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13NotLike(String value) {
            addCriterion("CBPD13 not like", value, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13In(List<String> values) {
            addCriterion("CBPD13 in", values, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13NotIn(List<String> values) {
            addCriterion("CBPD13 not in", values, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13Between(String value1, String value2) {
            addCriterion("CBPD13 between", value1, value2, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpd13NotBetween(String value1, String value2) {
            addCriterion("CBPD13 not between", value1, value2, "cbpd13");
            return (Criteria) this;
        }

        public Criteria andCbpc01IsNull() {
            addCriterion("CBPC01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpc01IsNotNull() {
            addCriterion("CBPC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpc01EqualTo(Integer value) {
            addCriterion("CBPC01 =", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01NotEqualTo(Integer value) {
            addCriterion("CBPC01 <>", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01GreaterThan(Integer value) {
            addCriterion("CBPC01 >", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPC01 >=", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01LessThan(Integer value) {
            addCriterion("CBPC01 <", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPC01 <=", value, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01In(List<Integer> values) {
            addCriterion("CBPC01 in", values, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01NotIn(List<Integer> values) {
            addCriterion("CBPC01 not in", values, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01Between(Integer value1, Integer value2) {
            addCriterion("CBPC01 between", value1, value2, "cbpc01");
            return (Criteria) this;
        }

        public Criteria andCbpc01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPC01 not between", value1, value2, "cbpc01");
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
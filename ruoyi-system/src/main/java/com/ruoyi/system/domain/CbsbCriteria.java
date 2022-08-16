package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsbCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsbCriteria() {
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

        public Criteria andCbsb01IsNull() {
            addCriterion("CBSB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb01IsNotNull() {
            addCriterion("CBSB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb01EqualTo(Integer value) {
            addCriterion("CBSB01 =", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01NotEqualTo(Integer value) {
            addCriterion("CBSB01 <>", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01GreaterThan(Integer value) {
            addCriterion("CBSB01 >", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB01 >=", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01LessThan(Integer value) {
            addCriterion("CBSB01 <", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB01 <=", value, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01In(List<Integer> values) {
            addCriterion("CBSB01 in", values, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01NotIn(List<Integer> values) {
            addCriterion("CBSB01 not in", values, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01Between(Integer value1, Integer value2) {
            addCriterion("CBSB01 between", value1, value2, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB01 not between", value1, value2, "cbsb01");
            return (Criteria) this;
        }

        public Criteria andCbsb02IsNull() {
            addCriterion("CBSB02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb02IsNotNull() {
            addCriterion("CBSB02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb02EqualTo(Date value) {
            addCriterion("CBSB02 =", value, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02NotEqualTo(Date value) {
            addCriterion("CBSB02 <>", value, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02GreaterThan(Date value) {
            addCriterion("CBSB02 >", value, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSB02 >=", value, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02LessThan(Date value) {
            addCriterion("CBSB02 <", value, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02LessThanOrEqualTo(Date value) {
            addCriterion("CBSB02 <=", value, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02In(List<Date> values) {
            addCriterion("CBSB02 in", values, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02NotIn(List<Date> values) {
            addCriterion("CBSB02 not in", values, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02Between(Date value1, Date value2) {
            addCriterion("CBSB02 between", value1, value2, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb02NotBetween(Date value1, Date value2) {
            addCriterion("CBSB02 not between", value1, value2, "cbsb02");
            return (Criteria) this;
        }

        public Criteria andCbsb03IsNull() {
            addCriterion("CBSB03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb03IsNotNull() {
            addCriterion("CBSB03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb03EqualTo(Integer value) {
            addCriterion("CBSB03 =", value, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03NotEqualTo(Integer value) {
            addCriterion("CBSB03 <>", value, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03GreaterThan(Integer value) {
            addCriterion("CBSB03 >", value, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB03 >=", value, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03LessThan(Integer value) {
            addCriterion("CBSB03 <", value, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB03 <=", value, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03In(List<Integer> values) {
            addCriterion("CBSB03 in", values, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03NotIn(List<Integer> values) {
            addCriterion("CBSB03 not in", values, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03Between(Integer value1, Integer value2) {
            addCriterion("CBSB03 between", value1, value2, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB03 not between", value1, value2, "cbsb03");
            return (Criteria) this;
        }

        public Criteria andCbsb04IsNull() {
            addCriterion("CBSB04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb04IsNotNull() {
            addCriterion("CBSB04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb04EqualTo(Date value) {
            addCriterion("CBSB04 =", value, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04NotEqualTo(Date value) {
            addCriterion("CBSB04 <>", value, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04GreaterThan(Date value) {
            addCriterion("CBSB04 >", value, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSB04 >=", value, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04LessThan(Date value) {
            addCriterion("CBSB04 <", value, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04LessThanOrEqualTo(Date value) {
            addCriterion("CBSB04 <=", value, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04In(List<Date> values) {
            addCriterion("CBSB04 in", values, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04NotIn(List<Date> values) {
            addCriterion("CBSB04 not in", values, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04Between(Date value1, Date value2) {
            addCriterion("CBSB04 between", value1, value2, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb04NotBetween(Date value1, Date value2) {
            addCriterion("CBSB04 not between", value1, value2, "cbsb04");
            return (Criteria) this;
        }

        public Criteria andCbsb05IsNull() {
            addCriterion("CBSB05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb05IsNotNull() {
            addCriterion("CBSB05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb05EqualTo(Integer value) {
            addCriterion("CBSB05 =", value, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05NotEqualTo(Integer value) {
            addCriterion("CBSB05 <>", value, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05GreaterThan(Integer value) {
            addCriterion("CBSB05 >", value, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB05 >=", value, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05LessThan(Integer value) {
            addCriterion("CBSB05 <", value, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB05 <=", value, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05In(List<Integer> values) {
            addCriterion("CBSB05 in", values, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05NotIn(List<Integer> values) {
            addCriterion("CBSB05 not in", values, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05Between(Integer value1, Integer value2) {
            addCriterion("CBSB05 between", value1, value2, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB05 not between", value1, value2, "cbsb05");
            return (Criteria) this;
        }

        public Criteria andCbsb06IsNull() {
            addCriterion("CBSB06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb06IsNotNull() {
            addCriterion("CBSB06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb06EqualTo(Integer value) {
            addCriterion("CBSB06 =", value, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06NotEqualTo(Integer value) {
            addCriterion("CBSB06 <>", value, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06GreaterThan(Integer value) {
            addCriterion("CBSB06 >", value, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB06 >=", value, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06LessThan(Integer value) {
            addCriterion("CBSB06 <", value, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB06 <=", value, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06In(List<Integer> values) {
            addCriterion("CBSB06 in", values, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06NotIn(List<Integer> values) {
            addCriterion("CBSB06 not in", values, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06Between(Integer value1, Integer value2) {
            addCriterion("CBSB06 between", value1, value2, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB06 not between", value1, value2, "cbsb06");
            return (Criteria) this;
        }

        public Criteria andCbsb07IsNull() {
            addCriterion("CBSB07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb07IsNotNull() {
            addCriterion("CBSB07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb07EqualTo(String value) {
            addCriterion("CBSB07 =", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07NotEqualTo(String value) {
            addCriterion("CBSB07 <>", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07GreaterThan(String value) {
            addCriterion("CBSB07 >", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB07 >=", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07LessThan(String value) {
            addCriterion("CBSB07 <", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07LessThanOrEqualTo(String value) {
            addCriterion("CBSB07 <=", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07Like(String value) {
            addCriterion("CBSB07 like", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07NotLike(String value) {
            addCriterion("CBSB07 not like", value, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07In(List<String> values) {
            addCriterion("CBSB07 in", values, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07NotIn(List<String> values) {
            addCriterion("CBSB07 not in", values, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07Between(String value1, String value2) {
            addCriterion("CBSB07 between", value1, value2, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb07NotBetween(String value1, String value2) {
            addCriterion("CBSB07 not between", value1, value2, "cbsb07");
            return (Criteria) this;
        }

        public Criteria andCbsb08IsNull() {
            addCriterion("CBSB08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb08IsNotNull() {
            addCriterion("CBSB08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb08EqualTo(Date value) {
            addCriterion("CBSB08 =", value, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08NotEqualTo(Date value) {
            addCriterion("CBSB08 <>", value, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08GreaterThan(Date value) {
            addCriterion("CBSB08 >", value, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSB08 >=", value, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08LessThan(Date value) {
            addCriterion("CBSB08 <", value, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08LessThanOrEqualTo(Date value) {
            addCriterion("CBSB08 <=", value, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08In(List<Date> values) {
            addCriterion("CBSB08 in", values, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08NotIn(List<Date> values) {
            addCriterion("CBSB08 not in", values, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08Between(Date value1, Date value2) {
            addCriterion("CBSB08 between", value1, value2, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb08NotBetween(Date value1, Date value2) {
            addCriterion("CBSB08 not between", value1, value2, "cbsb08");
            return (Criteria) this;
        }

        public Criteria andCbsb09IsNull() {
            addCriterion("CBSB09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb09IsNotNull() {
            addCriterion("CBSB09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb09EqualTo(Integer value) {
            addCriterion("CBSB09 =", value, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09NotEqualTo(Integer value) {
            addCriterion("CBSB09 <>", value, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09GreaterThan(Integer value) {
            addCriterion("CBSB09 >", value, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB09 >=", value, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09LessThan(Integer value) {
            addCriterion("CBSB09 <", value, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB09 <=", value, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09In(List<Integer> values) {
            addCriterion("CBSB09 in", values, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09NotIn(List<Integer> values) {
            addCriterion("CBSB09 not in", values, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09Between(Integer value1, Integer value2) {
            addCriterion("CBSB09 between", value1, value2, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB09 not between", value1, value2, "cbsb09");
            return (Criteria) this;
        }

        public Criteria andCbsb10IsNull() {
            addCriterion("CBSB10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb10IsNotNull() {
            addCriterion("CBSB10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb10EqualTo(Integer value) {
            addCriterion("CBSB10 =", value, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10NotEqualTo(Integer value) {
            addCriterion("CBSB10 <>", value, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10GreaterThan(Integer value) {
            addCriterion("CBSB10 >", value, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB10 >=", value, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10LessThan(Integer value) {
            addCriterion("CBSB10 <", value, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB10 <=", value, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10In(List<Integer> values) {
            addCriterion("CBSB10 in", values, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10NotIn(List<Integer> values) {
            addCriterion("CBSB10 not in", values, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10Between(Integer value1, Integer value2) {
            addCriterion("CBSB10 between", value1, value2, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB10 not between", value1, value2, "cbsb10");
            return (Criteria) this;
        }

        public Criteria andCbsb11IsNull() {
            addCriterion("CBSB11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb11IsNotNull() {
            addCriterion("CBSB11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb11EqualTo(Integer value) {
            addCriterion("CBSB11 =", value, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11NotEqualTo(Integer value) {
            addCriterion("CBSB11 <>", value, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11GreaterThan(Integer value) {
            addCriterion("CBSB11 >", value, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB11 >=", value, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11LessThan(Integer value) {
            addCriterion("CBSB11 <", value, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB11 <=", value, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11In(List<Integer> values) {
            addCriterion("CBSB11 in", values, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11NotIn(List<Integer> values) {
            addCriterion("CBSB11 not in", values, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11Between(Integer value1, Integer value2) {
            addCriterion("CBSB11 between", value1, value2, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB11 not between", value1, value2, "cbsb11");
            return (Criteria) this;
        }

        public Criteria andCbsb12IsNull() {
            addCriterion("CBSB12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb12IsNotNull() {
            addCriterion("CBSB12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb12EqualTo(Integer value) {
            addCriterion("CBSB12 =", value, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12NotEqualTo(Integer value) {
            addCriterion("CBSB12 <>", value, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12GreaterThan(Integer value) {
            addCriterion("CBSB12 >", value, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB12 >=", value, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12LessThan(Integer value) {
            addCriterion("CBSB12 <", value, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB12 <=", value, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12In(List<Integer> values) {
            addCriterion("CBSB12 in", values, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12NotIn(List<Integer> values) {
            addCriterion("CBSB12 not in", values, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12Between(Integer value1, Integer value2) {
            addCriterion("CBSB12 between", value1, value2, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB12 not between", value1, value2, "cbsb12");
            return (Criteria) this;
        }

        public Criteria andCbsb13IsNull() {
            addCriterion("CBSB13 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb13IsNotNull() {
            addCriterion("CBSB13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb13EqualTo(Date value) {
            addCriterion("CBSB13 =", value, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13NotEqualTo(Date value) {
            addCriterion("CBSB13 <>", value, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13GreaterThan(Date value) {
            addCriterion("CBSB13 >", value, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSB13 >=", value, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13LessThan(Date value) {
            addCriterion("CBSB13 <", value, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13LessThanOrEqualTo(Date value) {
            addCriterion("CBSB13 <=", value, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13In(List<Date> values) {
            addCriterion("CBSB13 in", values, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13NotIn(List<Date> values) {
            addCriterion("CBSB13 not in", values, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13Between(Date value1, Date value2) {
            addCriterion("CBSB13 between", value1, value2, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb13NotBetween(Date value1, Date value2) {
            addCriterion("CBSB13 not between", value1, value2, "cbsb13");
            return (Criteria) this;
        }

        public Criteria andCbsb14IsNull() {
            addCriterion("CBSB14 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb14IsNotNull() {
            addCriterion("CBSB14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb14EqualTo(Integer value) {
            addCriterion("CBSB14 =", value, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14NotEqualTo(Integer value) {
            addCriterion("CBSB14 <>", value, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14GreaterThan(Integer value) {
            addCriterion("CBSB14 >", value, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB14 >=", value, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14LessThan(Integer value) {
            addCriterion("CBSB14 <", value, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB14 <=", value, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14In(List<Integer> values) {
            addCriterion("CBSB14 in", values, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14NotIn(List<Integer> values) {
            addCriterion("CBSB14 not in", values, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14Between(Integer value1, Integer value2) {
            addCriterion("CBSB14 between", value1, value2, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB14 not between", value1, value2, "cbsb14");
            return (Criteria) this;
        }

        public Criteria andCbsb15IsNull() {
            addCriterion("CBSB15 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb15IsNotNull() {
            addCriterion("CBSB15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb15EqualTo(Date value) {
            addCriterion("CBSB15 =", value, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15NotEqualTo(Date value) {
            addCriterion("CBSB15 <>", value, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15GreaterThan(Date value) {
            addCriterion("CBSB15 >", value, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSB15 >=", value, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15LessThan(Date value) {
            addCriterion("CBSB15 <", value, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15LessThanOrEqualTo(Date value) {
            addCriterion("CBSB15 <=", value, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15In(List<Date> values) {
            addCriterion("CBSB15 in", values, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15NotIn(List<Date> values) {
            addCriterion("CBSB15 not in", values, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15Between(Date value1, Date value2) {
            addCriterion("CBSB15 between", value1, value2, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb15NotBetween(Date value1, Date value2) {
            addCriterion("CBSB15 not between", value1, value2, "cbsb15");
            return (Criteria) this;
        }

        public Criteria andCbsb16IsNull() {
            addCriterion("CBSB16 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb16IsNotNull() {
            addCriterion("CBSB16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb16EqualTo(Integer value) {
            addCriterion("CBSB16 =", value, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16NotEqualTo(Integer value) {
            addCriterion("CBSB16 <>", value, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16GreaterThan(Integer value) {
            addCriterion("CBSB16 >", value, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB16 >=", value, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16LessThan(Integer value) {
            addCriterion("CBSB16 <", value, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB16 <=", value, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16In(List<Integer> values) {
            addCriterion("CBSB16 in", values, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16NotIn(List<Integer> values) {
            addCriterion("CBSB16 not in", values, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16Between(Integer value1, Integer value2) {
            addCriterion("CBSB16 between", value1, value2, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB16 not between", value1, value2, "cbsb16");
            return (Criteria) this;
        }

        public Criteria andCbsb17IsNull() {
            addCriterion("CBSB17 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb17IsNotNull() {
            addCriterion("CBSB17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb17EqualTo(String value) {
            addCriterion("CBSB17 =", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17NotEqualTo(String value) {
            addCriterion("CBSB17 <>", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17GreaterThan(String value) {
            addCriterion("CBSB17 >", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB17 >=", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17LessThan(String value) {
            addCriterion("CBSB17 <", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17LessThanOrEqualTo(String value) {
            addCriterion("CBSB17 <=", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17Like(String value) {
            addCriterion("CBSB17 like", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17NotLike(String value) {
            addCriterion("CBSB17 not like", value, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17In(List<String> values) {
            addCriterion("CBSB17 in", values, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17NotIn(List<String> values) {
            addCriterion("CBSB17 not in", values, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17Between(String value1, String value2) {
            addCriterion("CBSB17 between", value1, value2, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb17NotBetween(String value1, String value2) {
            addCriterion("CBSB17 not between", value1, value2, "cbsb17");
            return (Criteria) this;
        }

        public Criteria andCbsb18IsNull() {
            addCriterion("CBSB18 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb18IsNotNull() {
            addCriterion("CBSB18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb18EqualTo(String value) {
            addCriterion("CBSB18 =", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18NotEqualTo(String value) {
            addCriterion("CBSB18 <>", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18GreaterThan(String value) {
            addCriterion("CBSB18 >", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB18 >=", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18LessThan(String value) {
            addCriterion("CBSB18 <", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18LessThanOrEqualTo(String value) {
            addCriterion("CBSB18 <=", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18Like(String value) {
            addCriterion("CBSB18 like", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18NotLike(String value) {
            addCriterion("CBSB18 not like", value, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18In(List<String> values) {
            addCriterion("CBSB18 in", values, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18NotIn(List<String> values) {
            addCriterion("CBSB18 not in", values, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18Between(String value1, String value2) {
            addCriterion("CBSB18 between", value1, value2, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb18NotBetween(String value1, String value2) {
            addCriterion("CBSB18 not between", value1, value2, "cbsb18");
            return (Criteria) this;
        }

        public Criteria andCbsb19IsNull() {
            addCriterion("CBSB19 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb19IsNotNull() {
            addCriterion("CBSB19 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb19EqualTo(String value) {
            addCriterion("CBSB19 =", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19NotEqualTo(String value) {
            addCriterion("CBSB19 <>", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19GreaterThan(String value) {
            addCriterion("CBSB19 >", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB19 >=", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19LessThan(String value) {
            addCriterion("CBSB19 <", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19LessThanOrEqualTo(String value) {
            addCriterion("CBSB19 <=", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19Like(String value) {
            addCriterion("CBSB19 like", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19NotLike(String value) {
            addCriterion("CBSB19 not like", value, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19In(List<String> values) {
            addCriterion("CBSB19 in", values, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19NotIn(List<String> values) {
            addCriterion("CBSB19 not in", values, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19Between(String value1, String value2) {
            addCriterion("CBSB19 between", value1, value2, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb19NotBetween(String value1, String value2) {
            addCriterion("CBSB19 not between", value1, value2, "cbsb19");
            return (Criteria) this;
        }

        public Criteria andCbsb20IsNull() {
            addCriterion("CBSB20 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb20IsNotNull() {
            addCriterion("CBSB20 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb20EqualTo(Integer value) {
            addCriterion("CBSB20 =", value, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20NotEqualTo(Integer value) {
            addCriterion("CBSB20 <>", value, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20GreaterThan(Integer value) {
            addCriterion("CBSB20 >", value, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB20 >=", value, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20LessThan(Integer value) {
            addCriterion("CBSB20 <", value, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB20 <=", value, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20In(List<Integer> values) {
            addCriterion("CBSB20 in", values, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20NotIn(List<Integer> values) {
            addCriterion("CBSB20 not in", values, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20Between(Integer value1, Integer value2) {
            addCriterion("CBSB20 between", value1, value2, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb20NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB20 not between", value1, value2, "cbsb20");
            return (Criteria) this;
        }

        public Criteria andCbsb21IsNull() {
            addCriterion("CBSB21 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb21IsNotNull() {
            addCriterion("CBSB21 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb21EqualTo(String value) {
            addCriterion("CBSB21 =", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21NotEqualTo(String value) {
            addCriterion("CBSB21 <>", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21GreaterThan(String value) {
            addCriterion("CBSB21 >", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB21 >=", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21LessThan(String value) {
            addCriterion("CBSB21 <", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21LessThanOrEqualTo(String value) {
            addCriterion("CBSB21 <=", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21Like(String value) {
            addCriterion("CBSB21 like", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21NotLike(String value) {
            addCriterion("CBSB21 not like", value, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21In(List<String> values) {
            addCriterion("CBSB21 in", values, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21NotIn(List<String> values) {
            addCriterion("CBSB21 not in", values, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21Between(String value1, String value2) {
            addCriterion("CBSB21 between", value1, value2, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb21NotBetween(String value1, String value2) {
            addCriterion("CBSB21 not between", value1, value2, "cbsb21");
            return (Criteria) this;
        }

        public Criteria andCbsb22IsNull() {
            addCriterion("CBSB22 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb22IsNotNull() {
            addCriterion("CBSB22 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb22EqualTo(String value) {
            addCriterion("CBSB22 =", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22NotEqualTo(String value) {
            addCriterion("CBSB22 <>", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22GreaterThan(String value) {
            addCriterion("CBSB22 >", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB22 >=", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22LessThan(String value) {
            addCriterion("CBSB22 <", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22LessThanOrEqualTo(String value) {
            addCriterion("CBSB22 <=", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22Like(String value) {
            addCriterion("CBSB22 like", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22NotLike(String value) {
            addCriterion("CBSB22 not like", value, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22In(List<String> values) {
            addCriterion("CBSB22 in", values, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22NotIn(List<String> values) {
            addCriterion("CBSB22 not in", values, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22Between(String value1, String value2) {
            addCriterion("CBSB22 between", value1, value2, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb22NotBetween(String value1, String value2) {
            addCriterion("CBSB22 not between", value1, value2, "cbsb22");
            return (Criteria) this;
        }

        public Criteria andCbsb23IsNull() {
            addCriterion("CBSB23 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb23IsNotNull() {
            addCriterion("CBSB23 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb23EqualTo(String value) {
            addCriterion("CBSB23 =", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23NotEqualTo(String value) {
            addCriterion("CBSB23 <>", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23GreaterThan(String value) {
            addCriterion("CBSB23 >", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB23 >=", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23LessThan(String value) {
            addCriterion("CBSB23 <", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23LessThanOrEqualTo(String value) {
            addCriterion("CBSB23 <=", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23Like(String value) {
            addCriterion("CBSB23 like", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23NotLike(String value) {
            addCriterion("CBSB23 not like", value, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23In(List<String> values) {
            addCriterion("CBSB23 in", values, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23NotIn(List<String> values) {
            addCriterion("CBSB23 not in", values, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23Between(String value1, String value2) {
            addCriterion("CBSB23 between", value1, value2, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb23NotBetween(String value1, String value2) {
            addCriterion("CBSB23 not between", value1, value2, "cbsb23");
            return (Criteria) this;
        }

        public Criteria andCbsb24IsNull() {
            addCriterion("CBSB24 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb24IsNotNull() {
            addCriterion("CBSB24 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb24EqualTo(String value) {
            addCriterion("CBSB24 =", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24NotEqualTo(String value) {
            addCriterion("CBSB24 <>", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24GreaterThan(String value) {
            addCriterion("CBSB24 >", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB24 >=", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24LessThan(String value) {
            addCriterion("CBSB24 <", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24LessThanOrEqualTo(String value) {
            addCriterion("CBSB24 <=", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24Like(String value) {
            addCriterion("CBSB24 like", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24NotLike(String value) {
            addCriterion("CBSB24 not like", value, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24In(List<String> values) {
            addCriterion("CBSB24 in", values, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24NotIn(List<String> values) {
            addCriterion("CBSB24 not in", values, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24Between(String value1, String value2) {
            addCriterion("CBSB24 between", value1, value2, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb24NotBetween(String value1, String value2) {
            addCriterion("CBSB24 not between", value1, value2, "cbsb24");
            return (Criteria) this;
        }

        public Criteria andCbsb25IsNull() {
            addCriterion("CBSB25 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb25IsNotNull() {
            addCriterion("CBSB25 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb25EqualTo(String value) {
            addCriterion("CBSB25 =", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25NotEqualTo(String value) {
            addCriterion("CBSB25 <>", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25GreaterThan(String value) {
            addCriterion("CBSB25 >", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB25 >=", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25LessThan(String value) {
            addCriterion("CBSB25 <", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25LessThanOrEqualTo(String value) {
            addCriterion("CBSB25 <=", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25Like(String value) {
            addCriterion("CBSB25 like", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25NotLike(String value) {
            addCriterion("CBSB25 not like", value, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25In(List<String> values) {
            addCriterion("CBSB25 in", values, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25NotIn(List<String> values) {
            addCriterion("CBSB25 not in", values, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25Between(String value1, String value2) {
            addCriterion("CBSB25 between", value1, value2, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb25NotBetween(String value1, String value2) {
            addCriterion("CBSB25 not between", value1, value2, "cbsb25");
            return (Criteria) this;
        }

        public Criteria andCbsb26IsNull() {
            addCriterion("CBSB26 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb26IsNotNull() {
            addCriterion("CBSB26 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb26EqualTo(String value) {
            addCriterion("CBSB26 =", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26NotEqualTo(String value) {
            addCriterion("CBSB26 <>", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26GreaterThan(String value) {
            addCriterion("CBSB26 >", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB26 >=", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26LessThan(String value) {
            addCriterion("CBSB26 <", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26LessThanOrEqualTo(String value) {
            addCriterion("CBSB26 <=", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26Like(String value) {
            addCriterion("CBSB26 like", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26NotLike(String value) {
            addCriterion("CBSB26 not like", value, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26In(List<String> values) {
            addCriterion("CBSB26 in", values, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26NotIn(List<String> values) {
            addCriterion("CBSB26 not in", values, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26Between(String value1, String value2) {
            addCriterion("CBSB26 between", value1, value2, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb26NotBetween(String value1, String value2) {
            addCriterion("CBSB26 not between", value1, value2, "cbsb26");
            return (Criteria) this;
        }

        public Criteria andCbsb27IsNull() {
            addCriterion("CBSB27 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb27IsNotNull() {
            addCriterion("CBSB27 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb27EqualTo(String value) {
            addCriterion("CBSB27 =", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27NotEqualTo(String value) {
            addCriterion("CBSB27 <>", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27GreaterThan(String value) {
            addCriterion("CBSB27 >", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB27 >=", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27LessThan(String value) {
            addCriterion("CBSB27 <", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27LessThanOrEqualTo(String value) {
            addCriterion("CBSB27 <=", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27Like(String value) {
            addCriterion("CBSB27 like", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27NotLike(String value) {
            addCriterion("CBSB27 not like", value, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27In(List<String> values) {
            addCriterion("CBSB27 in", values, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27NotIn(List<String> values) {
            addCriterion("CBSB27 not in", values, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27Between(String value1, String value2) {
            addCriterion("CBSB27 between", value1, value2, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb27NotBetween(String value1, String value2) {
            addCriterion("CBSB27 not between", value1, value2, "cbsb27");
            return (Criteria) this;
        }

        public Criteria andCbsb28IsNull() {
            addCriterion("CBSB28 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb28IsNotNull() {
            addCriterion("CBSB28 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb28EqualTo(String value) {
            addCriterion("CBSB28 =", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28NotEqualTo(String value) {
            addCriterion("CBSB28 <>", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28GreaterThan(String value) {
            addCriterion("CBSB28 >", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB28 >=", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28LessThan(String value) {
            addCriterion("CBSB28 <", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28LessThanOrEqualTo(String value) {
            addCriterion("CBSB28 <=", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28Like(String value) {
            addCriterion("CBSB28 like", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28NotLike(String value) {
            addCriterion("CBSB28 not like", value, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28In(List<String> values) {
            addCriterion("CBSB28 in", values, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28NotIn(List<String> values) {
            addCriterion("CBSB28 not in", values, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28Between(String value1, String value2) {
            addCriterion("CBSB28 between", value1, value2, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb28NotBetween(String value1, String value2) {
            addCriterion("CBSB28 not between", value1, value2, "cbsb28");
            return (Criteria) this;
        }

        public Criteria andCbsb29IsNull() {
            addCriterion("CBSB29 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb29IsNotNull() {
            addCriterion("CBSB29 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb29EqualTo(String value) {
            addCriterion("CBSB29 =", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29NotEqualTo(String value) {
            addCriterion("CBSB29 <>", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29GreaterThan(String value) {
            addCriterion("CBSB29 >", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB29 >=", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29LessThan(String value) {
            addCriterion("CBSB29 <", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29LessThanOrEqualTo(String value) {
            addCriterion("CBSB29 <=", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29Like(String value) {
            addCriterion("CBSB29 like", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29NotLike(String value) {
            addCriterion("CBSB29 not like", value, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29In(List<String> values) {
            addCriterion("CBSB29 in", values, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29NotIn(List<String> values) {
            addCriterion("CBSB29 not in", values, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29Between(String value1, String value2) {
            addCriterion("CBSB29 between", value1, value2, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb29NotBetween(String value1, String value2) {
            addCriterion("CBSB29 not between", value1, value2, "cbsb29");
            return (Criteria) this;
        }

        public Criteria andCbsb30IsNull() {
            addCriterion("CBSB30 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb30IsNotNull() {
            addCriterion("CBSB30 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb30EqualTo(String value) {
            addCriterion("CBSB30 =", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30NotEqualTo(String value) {
            addCriterion("CBSB30 <>", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30GreaterThan(String value) {
            addCriterion("CBSB30 >", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30GreaterThanOrEqualTo(String value) {
            addCriterion("CBSB30 >=", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30LessThan(String value) {
            addCriterion("CBSB30 <", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30LessThanOrEqualTo(String value) {
            addCriterion("CBSB30 <=", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30Like(String value) {
            addCriterion("CBSB30 like", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30NotLike(String value) {
            addCriterion("CBSB30 not like", value, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30In(List<String> values) {
            addCriterion("CBSB30 in", values, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30NotIn(List<String> values) {
            addCriterion("CBSB30 not in", values, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30Between(String value1, String value2) {
            addCriterion("CBSB30 between", value1, value2, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb30NotBetween(String value1, String value2) {
            addCriterion("CBSB30 not between", value1, value2, "cbsb30");
            return (Criteria) this;
        }

        public Criteria andCbsb31IsNull() {
            addCriterion("CBSB31 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb31IsNotNull() {
            addCriterion("CBSB31 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb31EqualTo(Integer value) {
            addCriterion("CBSB31 =", value, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31NotEqualTo(Integer value) {
            addCriterion("CBSB31 <>", value, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31GreaterThan(Integer value) {
            addCriterion("CBSB31 >", value, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB31 >=", value, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31LessThan(Integer value) {
            addCriterion("CBSB31 <", value, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB31 <=", value, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31In(List<Integer> values) {
            addCriterion("CBSB31 in", values, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31NotIn(List<Integer> values) {
            addCriterion("CBSB31 not in", values, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31Between(Integer value1, Integer value2) {
            addCriterion("CBSB31 between", value1, value2, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb31NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB31 not between", value1, value2, "cbsb31");
            return (Criteria) this;
        }

        public Criteria andCbsb32IsNull() {
            addCriterion("CBSB32 is null");
            return (Criteria) this;
        }

        public Criteria andCbsb32IsNotNull() {
            addCriterion("CBSB32 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsb32EqualTo(Integer value) {
            addCriterion("CBSB32 =", value, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32NotEqualTo(Integer value) {
            addCriterion("CBSB32 <>", value, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32GreaterThan(Integer value) {
            addCriterion("CBSB32 >", value, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSB32 >=", value, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32LessThan(Integer value) {
            addCriterion("CBSB32 <", value, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32LessThanOrEqualTo(Integer value) {
            addCriterion("CBSB32 <=", value, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32In(List<Integer> values) {
            addCriterion("CBSB32 in", values, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32NotIn(List<Integer> values) {
            addCriterion("CBSB32 not in", values, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32Between(Integer value1, Integer value2) {
            addCriterion("CBSB32 between", value1, value2, "cbsb32");
            return (Criteria) this;
        }

        public Criteria andCbsb32NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSB32 not between", value1, value2, "cbsb32");
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
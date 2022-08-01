package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpbCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpbCriteria() {
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

        public Criteria andCbpb02IsNull() {
            addCriterion("CBPB02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb02IsNotNull() {
            addCriterion("CBPB02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb02EqualTo(Date value) {
            addCriterion("CBPB02 =", value, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02NotEqualTo(Date value) {
            addCriterion("CBPB02 <>", value, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02GreaterThan(Date value) {
            addCriterion("CBPB02 >", value, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPB02 >=", value, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02LessThan(Date value) {
            addCriterion("CBPB02 <", value, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02LessThanOrEqualTo(Date value) {
            addCriterion("CBPB02 <=", value, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02In(List<Date> values) {
            addCriterion("CBPB02 in", values, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02NotIn(List<Date> values) {
            addCriterion("CBPB02 not in", values, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02Between(Date value1, Date value2) {
            addCriterion("CBPB02 between", value1, value2, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb02NotBetween(Date value1, Date value2) {
            addCriterion("CBPB02 not between", value1, value2, "cbpb02");
            return (Criteria) this;
        }

        public Criteria andCbpb03IsNull() {
            addCriterion("CBPB03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb03IsNotNull() {
            addCriterion("CBPB03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb03EqualTo(Date value) {
            addCriterion("CBPB03 =", value, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03NotEqualTo(Date value) {
            addCriterion("CBPB03 <>", value, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03GreaterThan(Date value) {
            addCriterion("CBPB03 >", value, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPB03 >=", value, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03LessThan(Date value) {
            addCriterion("CBPB03 <", value, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03LessThanOrEqualTo(Date value) {
            addCriterion("CBPB03 <=", value, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03In(List<Date> values) {
            addCriterion("CBPB03 in", values, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03NotIn(List<Date> values) {
            addCriterion("CBPB03 not in", values, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03Between(Date value1, Date value2) {
            addCriterion("CBPB03 between", value1, value2, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb03NotBetween(Date value1, Date value2) {
            addCriterion("CBPB03 not between", value1, value2, "cbpb03");
            return (Criteria) this;
        }

        public Criteria andCbpb04IsNull() {
            addCriterion("CBPB04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb04IsNotNull() {
            addCriterion("CBPB04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb04EqualTo(Integer value) {
            addCriterion("CBPB04 =", value, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04NotEqualTo(Integer value) {
            addCriterion("CBPB04 <>", value, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04GreaterThan(Integer value) {
            addCriterion("CBPB04 >", value, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB04 >=", value, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04LessThan(Integer value) {
            addCriterion("CBPB04 <", value, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB04 <=", value, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04In(List<Integer> values) {
            addCriterion("CBPB04 in", values, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04NotIn(List<Integer> values) {
            addCriterion("CBPB04 not in", values, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04Between(Integer value1, Integer value2) {
            addCriterion("CBPB04 between", value1, value2, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB04 not between", value1, value2, "cbpb04");
            return (Criteria) this;
        }

        public Criteria andCbpb05IsNull() {
            addCriterion("CBPB05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb05IsNotNull() {
            addCriterion("CBPB05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb05EqualTo(Integer value) {
            addCriterion("CBPB05 =", value, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05NotEqualTo(Integer value) {
            addCriterion("CBPB05 <>", value, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05GreaterThan(Integer value) {
            addCriterion("CBPB05 >", value, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB05 >=", value, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05LessThan(Integer value) {
            addCriterion("CBPB05 <", value, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB05 <=", value, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05In(List<Integer> values) {
            addCriterion("CBPB05 in", values, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05NotIn(List<Integer> values) {
            addCriterion("CBPB05 not in", values, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05Between(Integer value1, Integer value2) {
            addCriterion("CBPB05 between", value1, value2, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB05 not between", value1, value2, "cbpb05");
            return (Criteria) this;
        }

        public Criteria andCbpb06IsNull() {
            addCriterion("CBPB06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb06IsNotNull() {
            addCriterion("CBPB06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb06EqualTo(Integer value) {
            addCriterion("CBPB06 =", value, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06NotEqualTo(Integer value) {
            addCriterion("CBPB06 <>", value, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06GreaterThan(Integer value) {
            addCriterion("CBPB06 >", value, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB06 >=", value, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06LessThan(Integer value) {
            addCriterion("CBPB06 <", value, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB06 <=", value, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06In(List<Integer> values) {
            addCriterion("CBPB06 in", values, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06NotIn(List<Integer> values) {
            addCriterion("CBPB06 not in", values, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06Between(Integer value1, Integer value2) {
            addCriterion("CBPB06 between", value1, value2, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB06 not between", value1, value2, "cbpb06");
            return (Criteria) this;
        }

        public Criteria andCbpb07IsNull() {
            addCriterion("CBPB07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb07IsNotNull() {
            addCriterion("CBPB07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb07EqualTo(String value) {
            addCriterion("CBPB07 =", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07NotEqualTo(String value) {
            addCriterion("CBPB07 <>", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07GreaterThan(String value) {
            addCriterion("CBPB07 >", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07GreaterThanOrEqualTo(String value) {
            addCriterion("CBPB07 >=", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07LessThan(String value) {
            addCriterion("CBPB07 <", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07LessThanOrEqualTo(String value) {
            addCriterion("CBPB07 <=", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07Like(String value) {
            addCriterion("CBPB07 like", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07NotLike(String value) {
            addCriterion("CBPB07 not like", value, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07In(List<String> values) {
            addCriterion("CBPB07 in", values, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07NotIn(List<String> values) {
            addCriterion("CBPB07 not in", values, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07Between(String value1, String value2) {
            addCriterion("CBPB07 between", value1, value2, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb07NotBetween(String value1, String value2) {
            addCriterion("CBPB07 not between", value1, value2, "cbpb07");
            return (Criteria) this;
        }

        public Criteria andCbpb08IsNull() {
            addCriterion("CBPB08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb08IsNotNull() {
            addCriterion("CBPB08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb08EqualTo(String value) {
            addCriterion("CBPB08 =", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08NotEqualTo(String value) {
            addCriterion("CBPB08 <>", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08GreaterThan(String value) {
            addCriterion("CBPB08 >", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08GreaterThanOrEqualTo(String value) {
            addCriterion("CBPB08 >=", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08LessThan(String value) {
            addCriterion("CBPB08 <", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08LessThanOrEqualTo(String value) {
            addCriterion("CBPB08 <=", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08Like(String value) {
            addCriterion("CBPB08 like", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08NotLike(String value) {
            addCriterion("CBPB08 not like", value, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08In(List<String> values) {
            addCriterion("CBPB08 in", values, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08NotIn(List<String> values) {
            addCriterion("CBPB08 not in", values, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08Between(String value1, String value2) {
            addCriterion("CBPB08 between", value1, value2, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb08NotBetween(String value1, String value2) {
            addCriterion("CBPB08 not between", value1, value2, "cbpb08");
            return (Criteria) this;
        }

        public Criteria andCbpb09IsNull() {
            addCriterion("CBPB09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb09IsNotNull() {
            addCriterion("CBPB09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb09EqualTo(String value) {
            addCriterion("CBPB09 =", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09NotEqualTo(String value) {
            addCriterion("CBPB09 <>", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09GreaterThan(String value) {
            addCriterion("CBPB09 >", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09GreaterThanOrEqualTo(String value) {
            addCriterion("CBPB09 >=", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09LessThan(String value) {
            addCriterion("CBPB09 <", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09LessThanOrEqualTo(String value) {
            addCriterion("CBPB09 <=", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09Like(String value) {
            addCriterion("CBPB09 like", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09NotLike(String value) {
            addCriterion("CBPB09 not like", value, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09In(List<String> values) {
            addCriterion("CBPB09 in", values, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09NotIn(List<String> values) {
            addCriterion("CBPB09 not in", values, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09Between(String value1, String value2) {
            addCriterion("CBPB09 between", value1, value2, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb09NotBetween(String value1, String value2) {
            addCriterion("CBPB09 not between", value1, value2, "cbpb09");
            return (Criteria) this;
        }

        public Criteria andCbpb10IsNull() {
            addCriterion("CBPB10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb10IsNotNull() {
            addCriterion("CBPB10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb10EqualTo(Integer value) {
            addCriterion("CBPB10 =", value, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10NotEqualTo(Integer value) {
            addCriterion("CBPB10 <>", value, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10GreaterThan(Integer value) {
            addCriterion("CBPB10 >", value, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB10 >=", value, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10LessThan(Integer value) {
            addCriterion("CBPB10 <", value, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB10 <=", value, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10In(List<Integer> values) {
            addCriterion("CBPB10 in", values, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10NotIn(List<Integer> values) {
            addCriterion("CBPB10 not in", values, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10Between(Integer value1, Integer value2) {
            addCriterion("CBPB10 between", value1, value2, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB10 not between", value1, value2, "cbpb10");
            return (Criteria) this;
        }

        public Criteria andCbpb11IsNull() {
            addCriterion("CBPB11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb11IsNotNull() {
            addCriterion("CBPB11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb11EqualTo(Integer value) {
            addCriterion("CBPB11 =", value, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11NotEqualTo(Integer value) {
            addCriterion("CBPB11 <>", value, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11GreaterThan(Integer value) {
            addCriterion("CBPB11 >", value, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB11 >=", value, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11LessThan(Integer value) {
            addCriterion("CBPB11 <", value, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB11 <=", value, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11In(List<Integer> values) {
            addCriterion("CBPB11 in", values, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11NotIn(List<Integer> values) {
            addCriterion("CBPB11 not in", values, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11Between(Integer value1, Integer value2) {
            addCriterion("CBPB11 between", value1, value2, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB11 not between", value1, value2, "cbpb11");
            return (Criteria) this;
        }

        public Criteria andCbpb12IsNull() {
            addCriterion("CBPB12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb12IsNotNull() {
            addCriterion("CBPB12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb12EqualTo(String value) {
            addCriterion("CBPB12 =", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12NotEqualTo(String value) {
            addCriterion("CBPB12 <>", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12GreaterThan(String value) {
            addCriterion("CBPB12 >", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12GreaterThanOrEqualTo(String value) {
            addCriterion("CBPB12 >=", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12LessThan(String value) {
            addCriterion("CBPB12 <", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12LessThanOrEqualTo(String value) {
            addCriterion("CBPB12 <=", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12Like(String value) {
            addCriterion("CBPB12 like", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12NotLike(String value) {
            addCriterion("CBPB12 not like", value, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12In(List<String> values) {
            addCriterion("CBPB12 in", values, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12NotIn(List<String> values) {
            addCriterion("CBPB12 not in", values, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12Between(String value1, String value2) {
            addCriterion("CBPB12 between", value1, value2, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb12NotBetween(String value1, String value2) {
            addCriterion("CBPB12 not between", value1, value2, "cbpb12");
            return (Criteria) this;
        }

        public Criteria andCbpb13IsNull() {
            addCriterion("CBPB13 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb13IsNotNull() {
            addCriterion("CBPB13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb13EqualTo(Double value) {
            addCriterion("CBPB13 =", value, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13NotEqualTo(Double value) {
            addCriterion("CBPB13 <>", value, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13GreaterThan(Double value) {
            addCriterion("CBPB13 >", value, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13GreaterThanOrEqualTo(Double value) {
            addCriterion("CBPB13 >=", value, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13LessThan(Double value) {
            addCriterion("CBPB13 <", value, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13LessThanOrEqualTo(Double value) {
            addCriterion("CBPB13 <=", value, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13In(List<Double> values) {
            addCriterion("CBPB13 in", values, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13NotIn(List<Double> values) {
            addCriterion("CBPB13 not in", values, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13Between(Double value1, Double value2) {
            addCriterion("CBPB13 between", value1, value2, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb13NotBetween(Double value1, Double value2) {
            addCriterion("CBPB13 not between", value1, value2, "cbpb13");
            return (Criteria) this;
        }

        public Criteria andCbpb14IsNull() {
            addCriterion("CBPB14 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb14IsNotNull() {
            addCriterion("CBPB14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb14EqualTo(Integer value) {
            addCriterion("CBPB14 =", value, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14NotEqualTo(Integer value) {
            addCriterion("CBPB14 <>", value, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14GreaterThan(Integer value) {
            addCriterion("CBPB14 >", value, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPB14 >=", value, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14LessThan(Integer value) {
            addCriterion("CBPB14 <", value, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14LessThanOrEqualTo(Integer value) {
            addCriterion("CBPB14 <=", value, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14In(List<Integer> values) {
            addCriterion("CBPB14 in", values, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14NotIn(List<Integer> values) {
            addCriterion("CBPB14 not in", values, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14Between(Integer value1, Integer value2) {
            addCriterion("CBPB14 between", value1, value2, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPB14 not between", value1, value2, "cbpb14");
            return (Criteria) this;
        }

        public Criteria andCbpb15IsNull() {
            addCriterion("CBPB15 is null");
            return (Criteria) this;
        }

        public Criteria andCbpb15IsNotNull() {
            addCriterion("CBPB15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpb15EqualTo(String value) {
            addCriterion("CBPB15 =", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15NotEqualTo(String value) {
            addCriterion("CBPB15 <>", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15GreaterThan(String value) {
            addCriterion("CBPB15 >", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15GreaterThanOrEqualTo(String value) {
            addCriterion("CBPB15 >=", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15LessThan(String value) {
            addCriterion("CBPB15 <", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15LessThanOrEqualTo(String value) {
            addCriterion("CBPB15 <=", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15Like(String value) {
            addCriterion("CBPB15 like", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15NotLike(String value) {
            addCriterion("CBPB15 not like", value, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15In(List<String> values) {
            addCriterion("CBPB15 in", values, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15NotIn(List<String> values) {
            addCriterion("CBPB15 not in", values, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15Between(String value1, String value2) {
            addCriterion("CBPB15 between", value1, value2, "cbpb15");
            return (Criteria) this;
        }

        public Criteria andCbpb15NotBetween(String value1, String value2) {
            addCriterion("CBPB15 not between", value1, value2, "cbpb15");
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
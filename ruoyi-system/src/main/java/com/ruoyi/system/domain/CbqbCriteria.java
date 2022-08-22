package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbqbCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbqbCriteria() {
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

        public Criteria andCbqb01IsNull() {
            addCriterion("CBQB01 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb01IsNotNull() {
            addCriterion("CBQB01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb01EqualTo(Integer value) {
            addCriterion("CBQB01 =", value, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01NotEqualTo(Integer value) {
            addCriterion("CBQB01 <>", value, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01GreaterThan(Integer value) {
            addCriterion("CBQB01 >", value, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQB01 >=", value, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01LessThan(Integer value) {
            addCriterion("CBQB01 <", value, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01LessThanOrEqualTo(Integer value) {
            addCriterion("CBQB01 <=", value, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01In(List<Integer> values) {
            addCriterion("CBQB01 in", values, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01NotIn(List<Integer> values) {
            addCriterion("CBQB01 not in", values, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01Between(Integer value1, Integer value2) {
            addCriterion("CBQB01 between", value1, value2, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQB01 not between", value1, value2, "cbqb01");
            return (Criteria) this;
        }

        public Criteria andCbqb02IsNull() {
            addCriterion("CBQB02 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb02IsNotNull() {
            addCriterion("CBQB02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb02EqualTo(Integer value) {
            addCriterion("CBQB02 =", value, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02NotEqualTo(Integer value) {
            addCriterion("CBQB02 <>", value, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02GreaterThan(Integer value) {
            addCriterion("CBQB02 >", value, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQB02 >=", value, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02LessThan(Integer value) {
            addCriterion("CBQB02 <", value, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02LessThanOrEqualTo(Integer value) {
            addCriterion("CBQB02 <=", value, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02In(List<Integer> values) {
            addCriterion("CBQB02 in", values, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02NotIn(List<Integer> values) {
            addCriterion("CBQB02 not in", values, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02Between(Integer value1, Integer value2) {
            addCriterion("CBQB02 between", value1, value2, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQB02 not between", value1, value2, "cbqb02");
            return (Criteria) this;
        }

        public Criteria andCbqb03IsNull() {
            addCriterion("CBQB03 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb03IsNotNull() {
            addCriterion("CBQB03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb03EqualTo(Date value) {
            addCriterion("CBQB03 =", value, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03NotEqualTo(Date value) {
            addCriterion("CBQB03 <>", value, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03GreaterThan(Date value) {
            addCriterion("CBQB03 >", value, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBQB03 >=", value, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03LessThan(Date value) {
            addCriterion("CBQB03 <", value, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03LessThanOrEqualTo(Date value) {
            addCriterion("CBQB03 <=", value, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03In(List<Date> values) {
            addCriterion("CBQB03 in", values, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03NotIn(List<Date> values) {
            addCriterion("CBQB03 not in", values, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03Between(Date value1, Date value2) {
            addCriterion("CBQB03 between", value1, value2, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb03NotBetween(Date value1, Date value2) {
            addCriterion("CBQB03 not between", value1, value2, "cbqb03");
            return (Criteria) this;
        }

        public Criteria andCbqb04IsNull() {
            addCriterion("CBQB04 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb04IsNotNull() {
            addCriterion("CBQB04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb04EqualTo(Integer value) {
            addCriterion("CBQB04 =", value, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04NotEqualTo(Integer value) {
            addCriterion("CBQB04 <>", value, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04GreaterThan(Integer value) {
            addCriterion("CBQB04 >", value, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQB04 >=", value, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04LessThan(Integer value) {
            addCriterion("CBQB04 <", value, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04LessThanOrEqualTo(Integer value) {
            addCriterion("CBQB04 <=", value, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04In(List<Integer> values) {
            addCriterion("CBQB04 in", values, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04NotIn(List<Integer> values) {
            addCriterion("CBQB04 not in", values, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04Between(Integer value1, Integer value2) {
            addCriterion("CBQB04 between", value1, value2, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQB04 not between", value1, value2, "cbqb04");
            return (Criteria) this;
        }

        public Criteria andCbqb05IsNull() {
            addCriterion("CBQB05 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb05IsNotNull() {
            addCriterion("CBQB05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb05EqualTo(Date value) {
            addCriterion("CBQB05 =", value, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05NotEqualTo(Date value) {
            addCriterion("CBQB05 <>", value, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05GreaterThan(Date value) {
            addCriterion("CBQB05 >", value, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBQB05 >=", value, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05LessThan(Date value) {
            addCriterion("CBQB05 <", value, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05LessThanOrEqualTo(Date value) {
            addCriterion("CBQB05 <=", value, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05In(List<Date> values) {
            addCriterion("CBQB05 in", values, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05NotIn(List<Date> values) {
            addCriterion("CBQB05 not in", values, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05Between(Date value1, Date value2) {
            addCriterion("CBQB05 between", value1, value2, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb05NotBetween(Date value1, Date value2) {
            addCriterion("CBQB05 not between", value1, value2, "cbqb05");
            return (Criteria) this;
        }

        public Criteria andCbqb06IsNull() {
            addCriterion("CBQB06 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb06IsNotNull() {
            addCriterion("CBQB06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb06EqualTo(Integer value) {
            addCriterion("CBQB06 =", value, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06NotEqualTo(Integer value) {
            addCriterion("CBQB06 <>", value, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06GreaterThan(Integer value) {
            addCriterion("CBQB06 >", value, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQB06 >=", value, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06LessThan(Integer value) {
            addCriterion("CBQB06 <", value, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06LessThanOrEqualTo(Integer value) {
            addCriterion("CBQB06 <=", value, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06In(List<Integer> values) {
            addCriterion("CBQB06 in", values, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06NotIn(List<Integer> values) {
            addCriterion("CBQB06 not in", values, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06Between(Integer value1, Integer value2) {
            addCriterion("CBQB06 between", value1, value2, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQB06 not between", value1, value2, "cbqb06");
            return (Criteria) this;
        }

        public Criteria andCbqb07IsNull() {
            addCriterion("CBQB07 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb07IsNotNull() {
            addCriterion("CBQB07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb07EqualTo(Integer value) {
            addCriterion("CBQB07 =", value, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07NotEqualTo(Integer value) {
            addCriterion("CBQB07 <>", value, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07GreaterThan(Integer value) {
            addCriterion("CBQB07 >", value, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQB07 >=", value, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07LessThan(Integer value) {
            addCriterion("CBQB07 <", value, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07LessThanOrEqualTo(Integer value) {
            addCriterion("CBQB07 <=", value, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07In(List<Integer> values) {
            addCriterion("CBQB07 in", values, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07NotIn(List<Integer> values) {
            addCriterion("CBQB07 not in", values, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07Between(Integer value1, Integer value2) {
            addCriterion("CBQB07 between", value1, value2, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQB07 not between", value1, value2, "cbqb07");
            return (Criteria) this;
        }

        public Criteria andCbqb08IsNull() {
            addCriterion("CBQB08 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb08IsNotNull() {
            addCriterion("CBQB08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb08EqualTo(Integer value) {
            addCriterion("CBQB08 =", value, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08NotEqualTo(Integer value) {
            addCriterion("CBQB08 <>", value, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08GreaterThan(Integer value) {
            addCriterion("CBQB08 >", value, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQB08 >=", value, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08LessThan(Integer value) {
            addCriterion("CBQB08 <", value, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08LessThanOrEqualTo(Integer value) {
            addCriterion("CBQB08 <=", value, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08In(List<Integer> values) {
            addCriterion("CBQB08 in", values, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08NotIn(List<Integer> values) {
            addCriterion("CBQB08 not in", values, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08Between(Integer value1, Integer value2) {
            addCriterion("CBQB08 between", value1, value2, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQB08 not between", value1, value2, "cbqb08");
            return (Criteria) this;
        }

        public Criteria andCbqb09IsNull() {
            addCriterion("CBQB09 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb09IsNotNull() {
            addCriterion("CBQB09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb09EqualTo(String value) {
            addCriterion("CBQB09 =", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09NotEqualTo(String value) {
            addCriterion("CBQB09 <>", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09GreaterThan(String value) {
            addCriterion("CBQB09 >", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09GreaterThanOrEqualTo(String value) {
            addCriterion("CBQB09 >=", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09LessThan(String value) {
            addCriterion("CBQB09 <", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09LessThanOrEqualTo(String value) {
            addCriterion("CBQB09 <=", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09Like(String value) {
            addCriterion("CBQB09 like", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09NotLike(String value) {
            addCriterion("CBQB09 not like", value, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09In(List<String> values) {
            addCriterion("CBQB09 in", values, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09NotIn(List<String> values) {
            addCriterion("CBQB09 not in", values, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09Between(String value1, String value2) {
            addCriterion("CBQB09 between", value1, value2, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb09NotBetween(String value1, String value2) {
            addCriterion("CBQB09 not between", value1, value2, "cbqb09");
            return (Criteria) this;
        }

        public Criteria andCbqb10IsNull() {
            addCriterion("CBQB10 is null");
            return (Criteria) this;
        }

        public Criteria andCbqb10IsNotNull() {
            addCriterion("CBQB10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqb10EqualTo(String value) {
            addCriterion("CBQB10 =", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10NotEqualTo(String value) {
            addCriterion("CBQB10 <>", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10GreaterThan(String value) {
            addCriterion("CBQB10 >", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10GreaterThanOrEqualTo(String value) {
            addCriterion("CBQB10 >=", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10LessThan(String value) {
            addCriterion("CBQB10 <", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10LessThanOrEqualTo(String value) {
            addCriterion("CBQB10 <=", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10Like(String value) {
            addCriterion("CBQB10 like", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10NotLike(String value) {
            addCriterion("CBQB10 not like", value, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10In(List<String> values) {
            addCriterion("CBQB10 in", values, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10NotIn(List<String> values) {
            addCriterion("CBQB10 not in", values, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10Between(String value1, String value2) {
            addCriterion("CBQB10 between", value1, value2, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqb10NotBetween(String value1, String value2) {
            addCriterion("CBQB10 not between", value1, value2, "cbqb10");
            return (Criteria) this;
        }

        public Criteria andCbqa01IsNull() {
            addCriterion("CBQA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbqa01IsNotNull() {
            addCriterion("CBQA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbqa01EqualTo(Integer value) {
            addCriterion("CBQA01 =", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01NotEqualTo(Integer value) {
            addCriterion("CBQA01 <>", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01GreaterThan(Integer value) {
            addCriterion("CBQA01 >", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBQA01 >=", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01LessThan(Integer value) {
            addCriterion("CBQA01 <", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBQA01 <=", value, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01In(List<Integer> values) {
            addCriterion("CBQA01 in", values, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01NotIn(List<Integer> values) {
            addCriterion("CBQA01 not in", values, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01Between(Integer value1, Integer value2) {
            addCriterion("CBQA01 between", value1, value2, "cbqa01");
            return (Criteria) this;
        }

        public Criteria andCbqa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBQA01 not between", value1, value2, "cbqa01");
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
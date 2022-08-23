package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsdCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsdCriteria() {
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

        public Criteria andCbsd01IsNull() {
            addCriterion("CBSD01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd01IsNotNull() {
            addCriterion("CBSD01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd01EqualTo(Integer value) {
            addCriterion("CBSD01 =", value, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01NotEqualTo(Integer value) {
            addCriterion("CBSD01 <>", value, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01GreaterThan(Integer value) {
            addCriterion("CBSD01 >", value, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD01 >=", value, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01LessThan(Integer value) {
            addCriterion("CBSD01 <", value, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD01 <=", value, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01In(List<Integer> values) {
            addCriterion("CBSD01 in", values, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01NotIn(List<Integer> values) {
            addCriterion("CBSD01 not in", values, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01Between(Integer value1, Integer value2) {
            addCriterion("CBSD01 between", value1, value2, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD01 not between", value1, value2, "cbsd01");
            return (Criteria) this;
        }

        public Criteria andCbsd02IsNull() {
            addCriterion("CBSD02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd02IsNotNull() {
            addCriterion("CBSD02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd02EqualTo(Integer value) {
            addCriterion("CBSD02 =", value, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02NotEqualTo(Integer value) {
            addCriterion("CBSD02 <>", value, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02GreaterThan(Integer value) {
            addCriterion("CBSD02 >", value, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD02 >=", value, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02LessThan(Integer value) {
            addCriterion("CBSD02 <", value, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD02 <=", value, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02In(List<Integer> values) {
            addCriterion("CBSD02 in", values, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02NotIn(List<Integer> values) {
            addCriterion("CBSD02 not in", values, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02Between(Integer value1, Integer value2) {
            addCriterion("CBSD02 between", value1, value2, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD02 not between", value1, value2, "cbsd02");
            return (Criteria) this;
        }

        public Criteria andCbsd03IsNull() {
            addCriterion("CBSD03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd03IsNotNull() {
            addCriterion("CBSD03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd03EqualTo(Date value) {
            addCriterion("CBSD03 =", value, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03NotEqualTo(Date value) {
            addCriterion("CBSD03 <>", value, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03GreaterThan(Date value) {
            addCriterion("CBSD03 >", value, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSD03 >=", value, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03LessThan(Date value) {
            addCriterion("CBSD03 <", value, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03LessThanOrEqualTo(Date value) {
            addCriterion("CBSD03 <=", value, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03In(List<Date> values) {
            addCriterion("CBSD03 in", values, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03NotIn(List<Date> values) {
            addCriterion("CBSD03 not in", values, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03Between(Date value1, Date value2) {
            addCriterion("CBSD03 between", value1, value2, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd03NotBetween(Date value1, Date value2) {
            addCriterion("CBSD03 not between", value1, value2, "cbsd03");
            return (Criteria) this;
        }

        public Criteria andCbsd04IsNull() {
            addCriterion("CBSD04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd04IsNotNull() {
            addCriterion("CBSD04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd04EqualTo(Integer value) {
            addCriterion("CBSD04 =", value, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04NotEqualTo(Integer value) {
            addCriterion("CBSD04 <>", value, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04GreaterThan(Integer value) {
            addCriterion("CBSD04 >", value, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD04 >=", value, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04LessThan(Integer value) {
            addCriterion("CBSD04 <", value, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD04 <=", value, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04In(List<Integer> values) {
            addCriterion("CBSD04 in", values, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04NotIn(List<Integer> values) {
            addCriterion("CBSD04 not in", values, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04Between(Integer value1, Integer value2) {
            addCriterion("CBSD04 between", value1, value2, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD04 not between", value1, value2, "cbsd04");
            return (Criteria) this;
        }

        public Criteria andCbsd05IsNull() {
            addCriterion("CBSD05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd05IsNotNull() {
            addCriterion("CBSD05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd05EqualTo(Date value) {
            addCriterion("CBSD05 =", value, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05NotEqualTo(Date value) {
            addCriterion("CBSD05 <>", value, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05GreaterThan(Date value) {
            addCriterion("CBSD05 >", value, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSD05 >=", value, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05LessThan(Date value) {
            addCriterion("CBSD05 <", value, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05LessThanOrEqualTo(Date value) {
            addCriterion("CBSD05 <=", value, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05In(List<Date> values) {
            addCriterion("CBSD05 in", values, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05NotIn(List<Date> values) {
            addCriterion("CBSD05 not in", values, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05Between(Date value1, Date value2) {
            addCriterion("CBSD05 between", value1, value2, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd05NotBetween(Date value1, Date value2) {
            addCriterion("CBSD05 not between", value1, value2, "cbsd05");
            return (Criteria) this;
        }

        public Criteria andCbsd06IsNull() {
            addCriterion("CBSD06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd06IsNotNull() {
            addCriterion("CBSD06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd06EqualTo(Integer value) {
            addCriterion("CBSD06 =", value, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06NotEqualTo(Integer value) {
            addCriterion("CBSD06 <>", value, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06GreaterThan(Integer value) {
            addCriterion("CBSD06 >", value, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD06 >=", value, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06LessThan(Integer value) {
            addCriterion("CBSD06 <", value, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD06 <=", value, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06In(List<Integer> values) {
            addCriterion("CBSD06 in", values, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06NotIn(List<Integer> values) {
            addCriterion("CBSD06 not in", values, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06Between(Integer value1, Integer value2) {
            addCriterion("CBSD06 between", value1, value2, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD06 not between", value1, value2, "cbsd06");
            return (Criteria) this;
        }

        public Criteria andCbsd07IsNull() {
            addCriterion("CBSD07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd07IsNotNull() {
            addCriterion("CBSD07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd07EqualTo(Integer value) {
            addCriterion("CBSD07 =", value, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07NotEqualTo(Integer value) {
            addCriterion("CBSD07 <>", value, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07GreaterThan(Integer value) {
            addCriterion("CBSD07 >", value, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD07 >=", value, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07LessThan(Integer value) {
            addCriterion("CBSD07 <", value, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD07 <=", value, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07In(List<Integer> values) {
            addCriterion("CBSD07 in", values, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07NotIn(List<Integer> values) {
            addCriterion("CBSD07 not in", values, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07Between(Integer value1, Integer value2) {
            addCriterion("CBSD07 between", value1, value2, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD07 not between", value1, value2, "cbsd07");
            return (Criteria) this;
        }

        public Criteria andCbsd08IsNull() {
            addCriterion("CBSD08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd08IsNotNull() {
            addCriterion("CBSD08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd08EqualTo(Integer value) {
            addCriterion("CBSD08 =", value, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08NotEqualTo(Integer value) {
            addCriterion("CBSD08 <>", value, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08GreaterThan(Integer value) {
            addCriterion("CBSD08 >", value, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD08 >=", value, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08LessThan(Integer value) {
            addCriterion("CBSD08 <", value, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD08 <=", value, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08In(List<Integer> values) {
            addCriterion("CBSD08 in", values, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08NotIn(List<Integer> values) {
            addCriterion("CBSD08 not in", values, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08Between(Integer value1, Integer value2) {
            addCriterion("CBSD08 between", value1, value2, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD08 not between", value1, value2, "cbsd08");
            return (Criteria) this;
        }

        public Criteria andCbsd09IsNull() {
            addCriterion("CBSD09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd09IsNotNull() {
            addCriterion("CBSD09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd09EqualTo(String value) {
            addCriterion("CBSD09 =", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09NotEqualTo(String value) {
            addCriterion("CBSD09 <>", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09GreaterThan(String value) {
            addCriterion("CBSD09 >", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09GreaterThanOrEqualTo(String value) {
            addCriterion("CBSD09 >=", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09LessThan(String value) {
            addCriterion("CBSD09 <", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09LessThanOrEqualTo(String value) {
            addCriterion("CBSD09 <=", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09Like(String value) {
            addCriterion("CBSD09 like", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09NotLike(String value) {
            addCriterion("CBSD09 not like", value, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09In(List<String> values) {
            addCriterion("CBSD09 in", values, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09NotIn(List<String> values) {
            addCriterion("CBSD09 not in", values, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09Between(String value1, String value2) {
            addCriterion("CBSD09 between", value1, value2, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd09NotBetween(String value1, String value2) {
            addCriterion("CBSD09 not between", value1, value2, "cbsd09");
            return (Criteria) this;
        }

        public Criteria andCbsd10IsNull() {
            addCriterion("CBSD10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd10IsNotNull() {
            addCriterion("CBSD10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd10EqualTo(Integer value) {
            addCriterion("CBSD10 =", value, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10NotEqualTo(Integer value) {
            addCriterion("CBSD10 <>", value, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10GreaterThan(Integer value) {
            addCriterion("CBSD10 >", value, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD10 >=", value, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10LessThan(Integer value) {
            addCriterion("CBSD10 <", value, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD10 <=", value, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10In(List<Integer> values) {
            addCriterion("CBSD10 in", values, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10NotIn(List<Integer> values) {
            addCriterion("CBSD10 not in", values, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10Between(Integer value1, Integer value2) {
            addCriterion("CBSD10 between", value1, value2, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD10 not between", value1, value2, "cbsd10");
            return (Criteria) this;
        }

        public Criteria andCbsd11IsNull() {
            addCriterion("CBSD11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd11IsNotNull() {
            addCriterion("CBSD11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd11EqualTo(Integer value) {
            addCriterion("CBSD11 =", value, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11NotEqualTo(Integer value) {
            addCriterion("CBSD11 <>", value, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11GreaterThan(Integer value) {
            addCriterion("CBSD11 >", value, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSD11 >=", value, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11LessThan(Integer value) {
            addCriterion("CBSD11 <", value, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11LessThanOrEqualTo(Integer value) {
            addCriterion("CBSD11 <=", value, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11In(List<Integer> values) {
            addCriterion("CBSD11 in", values, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11NotIn(List<Integer> values) {
            addCriterion("CBSD11 not in", values, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11Between(Integer value1, Integer value2) {
            addCriterion("CBSD11 between", value1, value2, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSD11 not between", value1, value2, "cbsd11");
            return (Criteria) this;
        }

        public Criteria andCbsd12IsNull() {
            addCriterion("CBSD12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsd12IsNotNull() {
            addCriterion("CBSD12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsd12EqualTo(String value) {
            addCriterion("CBSD12 =", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12NotEqualTo(String value) {
            addCriterion("CBSD12 <>", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12GreaterThan(String value) {
            addCriterion("CBSD12 >", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12GreaterThanOrEqualTo(String value) {
            addCriterion("CBSD12 >=", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12LessThan(String value) {
            addCriterion("CBSD12 <", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12LessThanOrEqualTo(String value) {
            addCriterion("CBSD12 <=", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12Like(String value) {
            addCriterion("CBSD12 like", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12NotLike(String value) {
            addCriterion("CBSD12 not like", value, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12In(List<String> values) {
            addCriterion("CBSD12 in", values, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12NotIn(List<String> values) {
            addCriterion("CBSD12 not in", values, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12Between(String value1, String value2) {
            addCriterion("CBSD12 between", value1, value2, "cbsd12");
            return (Criteria) this;
        }

        public Criteria andCbsd12NotBetween(String value1, String value2) {
            addCriterion("CBSD12 not between", value1, value2, "cbsd12");
            return (Criteria) this;
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
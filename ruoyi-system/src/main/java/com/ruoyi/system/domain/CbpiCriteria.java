package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpiCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpiCriteria() {
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

        public Criteria andCbpi01IsNull() {
            addCriterion("CBPI01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi01IsNotNull() {
            addCriterion("CBPI01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi01EqualTo(Integer value) {
            addCriterion("CBPI01 =", value, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01NotEqualTo(Integer value) {
            addCriterion("CBPI01 <>", value, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01GreaterThan(Integer value) {
            addCriterion("CBPI01 >", value, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI01 >=", value, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01LessThan(Integer value) {
            addCriterion("CBPI01 <", value, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI01 <=", value, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01In(List<Integer> values) {
            addCriterion("CBPI01 in", values, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01NotIn(List<Integer> values) {
            addCriterion("CBPI01 not in", values, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01Between(Integer value1, Integer value2) {
            addCriterion("CBPI01 between", value1, value2, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI01 not between", value1, value2, "cbpi01");
            return (Criteria) this;
        }

        public Criteria andCbpi02IsNull() {
            addCriterion("CBPI02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi02IsNotNull() {
            addCriterion("CBPI02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi02EqualTo(Integer value) {
            addCriterion("CBPI02 =", value, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02NotEqualTo(Integer value) {
            addCriterion("CBPI02 <>", value, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02GreaterThan(Integer value) {
            addCriterion("CBPI02 >", value, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI02 >=", value, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02LessThan(Integer value) {
            addCriterion("CBPI02 <", value, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI02 <=", value, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02In(List<Integer> values) {
            addCriterion("CBPI02 in", values, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02NotIn(List<Integer> values) {
            addCriterion("CBPI02 not in", values, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02Between(Integer value1, Integer value2) {
            addCriterion("CBPI02 between", value1, value2, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI02 not between", value1, value2, "cbpi02");
            return (Criteria) this;
        }

        public Criteria andCbpi03IsNull() {
            addCriterion("CBPI03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi03IsNotNull() {
            addCriterion("CBPI03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi03EqualTo(Date value) {
            addCriterion("CBPI03 =", value, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03NotEqualTo(Date value) {
            addCriterion("CBPI03 <>", value, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03GreaterThan(Date value) {
            addCriterion("CBPI03 >", value, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPI03 >=", value, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03LessThan(Date value) {
            addCriterion("CBPI03 <", value, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03LessThanOrEqualTo(Date value) {
            addCriterion("CBPI03 <=", value, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03In(List<Date> values) {
            addCriterion("CBPI03 in", values, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03NotIn(List<Date> values) {
            addCriterion("CBPI03 not in", values, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03Between(Date value1, Date value2) {
            addCriterion("CBPI03 between", value1, value2, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi03NotBetween(Date value1, Date value2) {
            addCriterion("CBPI03 not between", value1, value2, "cbpi03");
            return (Criteria) this;
        }

        public Criteria andCbpi04IsNull() {
            addCriterion("CBPI04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi04IsNotNull() {
            addCriterion("CBPI04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi04EqualTo(Integer value) {
            addCriterion("CBPI04 =", value, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04NotEqualTo(Integer value) {
            addCriterion("CBPI04 <>", value, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04GreaterThan(Integer value) {
            addCriterion("CBPI04 >", value, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI04 >=", value, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04LessThan(Integer value) {
            addCriterion("CBPI04 <", value, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI04 <=", value, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04In(List<Integer> values) {
            addCriterion("CBPI04 in", values, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04NotIn(List<Integer> values) {
            addCriterion("CBPI04 not in", values, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04Between(Integer value1, Integer value2) {
            addCriterion("CBPI04 between", value1, value2, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI04 not between", value1, value2, "cbpi04");
            return (Criteria) this;
        }

        public Criteria andCbpi05IsNull() {
            addCriterion("CBPI05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi05IsNotNull() {
            addCriterion("CBPI05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi05EqualTo(Date value) {
            addCriterion("CBPI05 =", value, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05NotEqualTo(Date value) {
            addCriterion("CBPI05 <>", value, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05GreaterThan(Date value) {
            addCriterion("CBPI05 >", value, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPI05 >=", value, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05LessThan(Date value) {
            addCriterion("CBPI05 <", value, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05LessThanOrEqualTo(Date value) {
            addCriterion("CBPI05 <=", value, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05In(List<Date> values) {
            addCriterion("CBPI05 in", values, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05NotIn(List<Date> values) {
            addCriterion("CBPI05 not in", values, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05Between(Date value1, Date value2) {
            addCriterion("CBPI05 between", value1, value2, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi05NotBetween(Date value1, Date value2) {
            addCriterion("CBPI05 not between", value1, value2, "cbpi05");
            return (Criteria) this;
        }

        public Criteria andCbpi06IsNull() {
            addCriterion("CBPI06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi06IsNotNull() {
            addCriterion("CBPI06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi06EqualTo(Integer value) {
            addCriterion("CBPI06 =", value, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06NotEqualTo(Integer value) {
            addCriterion("CBPI06 <>", value, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06GreaterThan(Integer value) {
            addCriterion("CBPI06 >", value, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI06 >=", value, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06LessThan(Integer value) {
            addCriterion("CBPI06 <", value, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI06 <=", value, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06In(List<Integer> values) {
            addCriterion("CBPI06 in", values, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06NotIn(List<Integer> values) {
            addCriterion("CBPI06 not in", values, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06Between(Integer value1, Integer value2) {
            addCriterion("CBPI06 between", value1, value2, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI06 not between", value1, value2, "cbpi06");
            return (Criteria) this;
        }

        public Criteria andCbpi07IsNull() {
            addCriterion("CBPI07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi07IsNotNull() {
            addCriterion("CBPI07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi07EqualTo(Integer value) {
            addCriterion("CBPI07 =", value, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07NotEqualTo(Integer value) {
            addCriterion("CBPI07 <>", value, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07GreaterThan(Integer value) {
            addCriterion("CBPI07 >", value, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI07 >=", value, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07LessThan(Integer value) {
            addCriterion("CBPI07 <", value, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI07 <=", value, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07In(List<Integer> values) {
            addCriterion("CBPI07 in", values, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07NotIn(List<Integer> values) {
            addCriterion("CBPI07 not in", values, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07Between(Integer value1, Integer value2) {
            addCriterion("CBPI07 between", value1, value2, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI07 not between", value1, value2, "cbpi07");
            return (Criteria) this;
        }

        public Criteria andCbpi08IsNull() {
            addCriterion("CBPI08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi08IsNotNull() {
            addCriterion("CBPI08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi08EqualTo(Integer value) {
            addCriterion("CBPI08 =", value, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08NotEqualTo(Integer value) {
            addCriterion("CBPI08 <>", value, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08GreaterThan(Integer value) {
            addCriterion("CBPI08 >", value, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI08 >=", value, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08LessThan(Integer value) {
            addCriterion("CBPI08 <", value, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI08 <=", value, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08In(List<Integer> values) {
            addCriterion("CBPI08 in", values, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08NotIn(List<Integer> values) {
            addCriterion("CBPI08 not in", values, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08Between(Integer value1, Integer value2) {
            addCriterion("CBPI08 between", value1, value2, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI08 not between", value1, value2, "cbpi08");
            return (Criteria) this;
        }

        public Criteria andCbpi09IsNull() {
            addCriterion("CBPI09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi09IsNotNull() {
            addCriterion("CBPI09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi09EqualTo(String value) {
            addCriterion("CBPI09 =", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09NotEqualTo(String value) {
            addCriterion("CBPI09 <>", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09GreaterThan(String value) {
            addCriterion("CBPI09 >", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09GreaterThanOrEqualTo(String value) {
            addCriterion("CBPI09 >=", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09LessThan(String value) {
            addCriterion("CBPI09 <", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09LessThanOrEqualTo(String value) {
            addCriterion("CBPI09 <=", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09Like(String value) {
            addCriterion("CBPI09 like", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09NotLike(String value) {
            addCriterion("CBPI09 not like", value, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09In(List<String> values) {
            addCriterion("CBPI09 in", values, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09NotIn(List<String> values) {
            addCriterion("CBPI09 not in", values, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09Between(String value1, String value2) {
            addCriterion("CBPI09 between", value1, value2, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi09NotBetween(String value1, String value2) {
            addCriterion("CBPI09 not between", value1, value2, "cbpi09");
            return (Criteria) this;
        }

        public Criteria andCbpi10IsNull() {
            addCriterion("CBPI10 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi10IsNotNull() {
            addCriterion("CBPI10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi10EqualTo(Integer value) {
            addCriterion("CBPI10 =", value, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10NotEqualTo(Integer value) {
            addCriterion("CBPI10 <>", value, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10GreaterThan(Integer value) {
            addCriterion("CBPI10 >", value, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI10 >=", value, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10LessThan(Integer value) {
            addCriterion("CBPI10 <", value, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI10 <=", value, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10In(List<Integer> values) {
            addCriterion("CBPI10 in", values, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10NotIn(List<Integer> values) {
            addCriterion("CBPI10 not in", values, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10Between(Integer value1, Integer value2) {
            addCriterion("CBPI10 between", value1, value2, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI10 not between", value1, value2, "cbpi10");
            return (Criteria) this;
        }

        public Criteria andCbpi11IsNull() {
            addCriterion("CBPI11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi11IsNotNull() {
            addCriterion("CBPI11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi11EqualTo(Integer value) {
            addCriterion("CBPI11 =", value, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11NotEqualTo(Integer value) {
            addCriterion("CBPI11 <>", value, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11GreaterThan(Integer value) {
            addCriterion("CBPI11 >", value, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPI11 >=", value, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11LessThan(Integer value) {
            addCriterion("CBPI11 <", value, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11LessThanOrEqualTo(Integer value) {
            addCriterion("CBPI11 <=", value, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11In(List<Integer> values) {
            addCriterion("CBPI11 in", values, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11NotIn(List<Integer> values) {
            addCriterion("CBPI11 not in", values, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11Between(Integer value1, Integer value2) {
            addCriterion("CBPI11 between", value1, value2, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPI11 not between", value1, value2, "cbpi11");
            return (Criteria) this;
        }

        public Criteria andCbpi12IsNull() {
            addCriterion("CBPI12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpi12IsNotNull() {
            addCriterion("CBPI12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpi12EqualTo(String value) {
            addCriterion("CBPI12 =", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12NotEqualTo(String value) {
            addCriterion("CBPI12 <>", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12GreaterThan(String value) {
            addCriterion("CBPI12 >", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12GreaterThanOrEqualTo(String value) {
            addCriterion("CBPI12 >=", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12LessThan(String value) {
            addCriterion("CBPI12 <", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12LessThanOrEqualTo(String value) {
            addCriterion("CBPI12 <=", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12Like(String value) {
            addCriterion("CBPI12 like", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12NotLike(String value) {
            addCriterion("CBPI12 not like", value, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12In(List<String> values) {
            addCriterion("CBPI12 in", values, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12NotIn(List<String> values) {
            addCriterion("CBPI12 not in", values, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12Between(String value1, String value2) {
            addCriterion("CBPI12 between", value1, value2, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpi12NotBetween(String value1, String value2) {
            addCriterion("CBPI12 not between", value1, value2, "cbpi12");
            return (Criteria) this;
        }

        public Criteria andCbpg01IsNull() {
            addCriterion("CBPG01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpg01IsNotNull() {
            addCriterion("CBPG01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpg01EqualTo(Integer value) {
            addCriterion("CBPG01 =", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotEqualTo(Integer value) {
            addCriterion("CBPG01 <>", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01GreaterThan(Integer value) {
            addCriterion("CBPG01 >", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPG01 >=", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01LessThan(Integer value) {
            addCriterion("CBPG01 <", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPG01 <=", value, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01In(List<Integer> values) {
            addCriterion("CBPG01 in", values, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotIn(List<Integer> values) {
            addCriterion("CBPG01 not in", values, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01Between(Integer value1, Integer value2) {
            addCriterion("CBPG01 between", value1, value2, "cbpg01");
            return (Criteria) this;
        }

        public Criteria andCbpg01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPG01 not between", value1, value2, "cbpg01");
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
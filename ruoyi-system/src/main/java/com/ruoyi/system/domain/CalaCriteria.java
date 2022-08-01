package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CalaCriteria() {
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

        public Criteria andCala01IsNull() {
            addCriterion("CALA01 is null");
            return (Criteria) this;
        }

        public Criteria andCala01IsNotNull() {
            addCriterion("CALA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCala01EqualTo(Integer value) {
            addCriterion("CALA01 =", value, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01NotEqualTo(Integer value) {
            addCriterion("CALA01 <>", value, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01GreaterThan(Integer value) {
            addCriterion("CALA01 >", value, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CALA01 >=", value, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01LessThan(Integer value) {
            addCriterion("CALA01 <", value, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01LessThanOrEqualTo(Integer value) {
            addCriterion("CALA01 <=", value, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01In(List<Integer> values) {
            addCriterion("CALA01 in", values, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01NotIn(List<Integer> values) {
            addCriterion("CALA01 not in", values, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01Between(Integer value1, Integer value2) {
            addCriterion("CALA01 between", value1, value2, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala01NotBetween(Integer value1, Integer value2) {
            addCriterion("CALA01 not between", value1, value2, "cala01");
            return (Criteria) this;
        }

        public Criteria andCala02IsNull() {
            addCriterion("CALA02 is null");
            return (Criteria) this;
        }

        public Criteria andCala02IsNotNull() {
            addCriterion("CALA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCala02EqualTo(String value) {
            addCriterion("CALA02 =", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02NotEqualTo(String value) {
            addCriterion("CALA02 <>", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02GreaterThan(String value) {
            addCriterion("CALA02 >", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02GreaterThanOrEqualTo(String value) {
            addCriterion("CALA02 >=", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02LessThan(String value) {
            addCriterion("CALA02 <", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02LessThanOrEqualTo(String value) {
            addCriterion("CALA02 <=", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02Like(String value) {
            addCriterion("CALA02 like", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02NotLike(String value) {
            addCriterion("CALA02 not like", value, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02In(List<String> values) {
            addCriterion("CALA02 in", values, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02NotIn(List<String> values) {
            addCriterion("CALA02 not in", values, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02Between(String value1, String value2) {
            addCriterion("CALA02 between", value1, value2, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala02NotBetween(String value1, String value2) {
            addCriterion("CALA02 not between", value1, value2, "cala02");
            return (Criteria) this;
        }

        public Criteria andCala03IsNull() {
            addCriterion("CALA03 is null");
            return (Criteria) this;
        }

        public Criteria andCala03IsNotNull() {
            addCriterion("CALA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCala03EqualTo(Date value) {
            addCriterion("CALA03 =", value, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03NotEqualTo(Date value) {
            addCriterion("CALA03 <>", value, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03GreaterThan(Date value) {
            addCriterion("CALA03 >", value, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03GreaterThanOrEqualTo(Date value) {
            addCriterion("CALA03 >=", value, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03LessThan(Date value) {
            addCriterion("CALA03 <", value, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03LessThanOrEqualTo(Date value) {
            addCriterion("CALA03 <=", value, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03In(List<Date> values) {
            addCriterion("CALA03 in", values, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03NotIn(List<Date> values) {
            addCriterion("CALA03 not in", values, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03Between(Date value1, Date value2) {
            addCriterion("CALA03 between", value1, value2, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala03NotBetween(Date value1, Date value2) {
            addCriterion("CALA03 not between", value1, value2, "cala03");
            return (Criteria) this;
        }

        public Criteria andCala04IsNull() {
            addCriterion("CALA04 is null");
            return (Criteria) this;
        }

        public Criteria andCala04IsNotNull() {
            addCriterion("CALA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCala04EqualTo(Date value) {
            addCriterion("CALA04 =", value, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04NotEqualTo(Date value) {
            addCriterion("CALA04 <>", value, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04GreaterThan(Date value) {
            addCriterion("CALA04 >", value, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04GreaterThanOrEqualTo(Date value) {
            addCriterion("CALA04 >=", value, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04LessThan(Date value) {
            addCriterion("CALA04 <", value, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04LessThanOrEqualTo(Date value) {
            addCriterion("CALA04 <=", value, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04In(List<Date> values) {
            addCriterion("CALA04 in", values, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04NotIn(List<Date> values) {
            addCriterion("CALA04 not in", values, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04Between(Date value1, Date value2) {
            addCriterion("CALA04 between", value1, value2, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala04NotBetween(Date value1, Date value2) {
            addCriterion("CALA04 not between", value1, value2, "cala04");
            return (Criteria) this;
        }

        public Criteria andCala05IsNull() {
            addCriterion("CALA05 is null");
            return (Criteria) this;
        }

        public Criteria andCala05IsNotNull() {
            addCriterion("CALA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCala05EqualTo(Integer value) {
            addCriterion("CALA05 =", value, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05NotEqualTo(Integer value) {
            addCriterion("CALA05 <>", value, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05GreaterThan(Integer value) {
            addCriterion("CALA05 >", value, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CALA05 >=", value, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05LessThan(Integer value) {
            addCriterion("CALA05 <", value, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05LessThanOrEqualTo(Integer value) {
            addCriterion("CALA05 <=", value, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05In(List<Integer> values) {
            addCriterion("CALA05 in", values, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05NotIn(List<Integer> values) {
            addCriterion("CALA05 not in", values, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05Between(Integer value1, Integer value2) {
            addCriterion("CALA05 between", value1, value2, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala05NotBetween(Integer value1, Integer value2) {
            addCriterion("CALA05 not between", value1, value2, "cala05");
            return (Criteria) this;
        }

        public Criteria andCala06IsNull() {
            addCriterion("CALA06 is null");
            return (Criteria) this;
        }

        public Criteria andCala06IsNotNull() {
            addCriterion("CALA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCala06EqualTo(Integer value) {
            addCriterion("CALA06 =", value, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06NotEqualTo(Integer value) {
            addCriterion("CALA06 <>", value, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06GreaterThan(Integer value) {
            addCriterion("CALA06 >", value, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CALA06 >=", value, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06LessThan(Integer value) {
            addCriterion("CALA06 <", value, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06LessThanOrEqualTo(Integer value) {
            addCriterion("CALA06 <=", value, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06In(List<Integer> values) {
            addCriterion("CALA06 in", values, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06NotIn(List<Integer> values) {
            addCriterion("CALA06 not in", values, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06Between(Integer value1, Integer value2) {
            addCriterion("CALA06 between", value1, value2, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala06NotBetween(Integer value1, Integer value2) {
            addCriterion("CALA06 not between", value1, value2, "cala06");
            return (Criteria) this;
        }

        public Criteria andCala07IsNull() {
            addCriterion("CALA07 is null");
            return (Criteria) this;
        }

        public Criteria andCala07IsNotNull() {
            addCriterion("CALA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCala07EqualTo(Integer value) {
            addCriterion("CALA07 =", value, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07NotEqualTo(Integer value) {
            addCriterion("CALA07 <>", value, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07GreaterThan(Integer value) {
            addCriterion("CALA07 >", value, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CALA07 >=", value, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07LessThan(Integer value) {
            addCriterion("CALA07 <", value, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07LessThanOrEqualTo(Integer value) {
            addCriterion("CALA07 <=", value, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07In(List<Integer> values) {
            addCriterion("CALA07 in", values, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07NotIn(List<Integer> values) {
            addCriterion("CALA07 not in", values, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07Between(Integer value1, Integer value2) {
            addCriterion("CALA07 between", value1, value2, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala07NotBetween(Integer value1, Integer value2) {
            addCriterion("CALA07 not between", value1, value2, "cala07");
            return (Criteria) this;
        }

        public Criteria andCala08IsNull() {
            addCriterion("CALA08 is null");
            return (Criteria) this;
        }

        public Criteria andCala08IsNotNull() {
            addCriterion("CALA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCala08EqualTo(String value) {
            addCriterion("CALA08 =", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08NotEqualTo(String value) {
            addCriterion("CALA08 <>", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08GreaterThan(String value) {
            addCriterion("CALA08 >", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08GreaterThanOrEqualTo(String value) {
            addCriterion("CALA08 >=", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08LessThan(String value) {
            addCriterion("CALA08 <", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08LessThanOrEqualTo(String value) {
            addCriterion("CALA08 <=", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08Like(String value) {
            addCriterion("CALA08 like", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08NotLike(String value) {
            addCriterion("CALA08 not like", value, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08In(List<String> values) {
            addCriterion("CALA08 in", values, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08NotIn(List<String> values) {
            addCriterion("CALA08 not in", values, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08Between(String value1, String value2) {
            addCriterion("CALA08 between", value1, value2, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala08NotBetween(String value1, String value2) {
            addCriterion("CALA08 not between", value1, value2, "cala08");
            return (Criteria) this;
        }

        public Criteria andCala09IsNull() {
            addCriterion("CALA09 is null");
            return (Criteria) this;
        }

        public Criteria andCala09IsNotNull() {
            addCriterion("CALA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCala09EqualTo(String value) {
            addCriterion("CALA09 =", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09NotEqualTo(String value) {
            addCriterion("CALA09 <>", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09GreaterThan(String value) {
            addCriterion("CALA09 >", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09GreaterThanOrEqualTo(String value) {
            addCriterion("CALA09 >=", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09LessThan(String value) {
            addCriterion("CALA09 <", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09LessThanOrEqualTo(String value) {
            addCriterion("CALA09 <=", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09Like(String value) {
            addCriterion("CALA09 like", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09NotLike(String value) {
            addCriterion("CALA09 not like", value, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09In(List<String> values) {
            addCriterion("CALA09 in", values, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09NotIn(List<String> values) {
            addCriterion("CALA09 not in", values, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09Between(String value1, String value2) {
            addCriterion("CALA09 between", value1, value2, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala09NotBetween(String value1, String value2) {
            addCriterion("CALA09 not between", value1, value2, "cala09");
            return (Criteria) this;
        }

        public Criteria andCala10IsNull() {
            addCriterion("CALA10 is null");
            return (Criteria) this;
        }

        public Criteria andCala10IsNotNull() {
            addCriterion("CALA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCala10EqualTo(String value) {
            addCriterion("CALA10 =", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10NotEqualTo(String value) {
            addCriterion("CALA10 <>", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10GreaterThan(String value) {
            addCriterion("CALA10 >", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10GreaterThanOrEqualTo(String value) {
            addCriterion("CALA10 >=", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10LessThan(String value) {
            addCriterion("CALA10 <", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10LessThanOrEqualTo(String value) {
            addCriterion("CALA10 <=", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10Like(String value) {
            addCriterion("CALA10 like", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10NotLike(String value) {
            addCriterion("CALA10 not like", value, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10In(List<String> values) {
            addCriterion("CALA10 in", values, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10NotIn(List<String> values) {
            addCriterion("CALA10 not in", values, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10Between(String value1, String value2) {
            addCriterion("CALA10 between", value1, value2, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala10NotBetween(String value1, String value2) {
            addCriterion("CALA10 not between", value1, value2, "cala10");
            return (Criteria) this;
        }

        public Criteria andCala11IsNull() {
            addCriterion("CALA11 is null");
            return (Criteria) this;
        }

        public Criteria andCala11IsNotNull() {
            addCriterion("CALA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCala11EqualTo(String value) {
            addCriterion("CALA11 =", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11NotEqualTo(String value) {
            addCriterion("CALA11 <>", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11GreaterThan(String value) {
            addCriterion("CALA11 >", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11GreaterThanOrEqualTo(String value) {
            addCriterion("CALA11 >=", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11LessThan(String value) {
            addCriterion("CALA11 <", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11LessThanOrEqualTo(String value) {
            addCriterion("CALA11 <=", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11Like(String value) {
            addCriterion("CALA11 like", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11NotLike(String value) {
            addCriterion("CALA11 not like", value, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11In(List<String> values) {
            addCriterion("CALA11 in", values, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11NotIn(List<String> values) {
            addCriterion("CALA11 not in", values, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11Between(String value1, String value2) {
            addCriterion("CALA11 between", value1, value2, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala11NotBetween(String value1, String value2) {
            addCriterion("CALA11 not between", value1, value2, "cala11");
            return (Criteria) this;
        }

        public Criteria andCala12IsNull() {
            addCriterion("CALA12 is null");
            return (Criteria) this;
        }

        public Criteria andCala12IsNotNull() {
            addCriterion("CALA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCala12EqualTo(String value) {
            addCriterion("CALA12 =", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12NotEqualTo(String value) {
            addCriterion("CALA12 <>", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12GreaterThan(String value) {
            addCriterion("CALA12 >", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12GreaterThanOrEqualTo(String value) {
            addCriterion("CALA12 >=", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12LessThan(String value) {
            addCriterion("CALA12 <", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12LessThanOrEqualTo(String value) {
            addCriterion("CALA12 <=", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12Like(String value) {
            addCriterion("CALA12 like", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12NotLike(String value) {
            addCriterion("CALA12 not like", value, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12In(List<String> values) {
            addCriterion("CALA12 in", values, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12NotIn(List<String> values) {
            addCriterion("CALA12 not in", values, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12Between(String value1, String value2) {
            addCriterion("CALA12 between", value1, value2, "cala12");
            return (Criteria) this;
        }

        public Criteria andCala12NotBetween(String value1, String value2) {
            addCriterion("CALA12 not between", value1, value2, "cala12");
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
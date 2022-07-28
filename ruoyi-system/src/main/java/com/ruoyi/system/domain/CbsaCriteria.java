package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsaCriteria() {
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

        public Criteria andCbsa01IsNull() {
            addCriterion("CBSA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa01IsNotNull() {
            addCriterion("CBSA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa01EqualTo(Integer value) {
            addCriterion("CBSA01 =", value, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01NotEqualTo(Integer value) {
            addCriterion("CBSA01 <>", value, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01GreaterThan(Integer value) {
            addCriterion("CBSA01 >", value, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSA01 >=", value, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01LessThan(Integer value) {
            addCriterion("CBSA01 <", value, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBSA01 <=", value, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01In(List<Integer> values) {
            addCriterion("CBSA01 in", values, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01NotIn(List<Integer> values) {
            addCriterion("CBSA01 not in", values, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01Between(Integer value1, Integer value2) {
            addCriterion("CBSA01 between", value1, value2, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSA01 not between", value1, value2, "cbsa01");
            return (Criteria) this;
        }

        public Criteria andCbsa02IsNull() {
            addCriterion("CBSA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa02IsNotNull() {
            addCriterion("CBSA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa02EqualTo(Date value) {
            addCriterion("CBSA02 =", value, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02NotEqualTo(Date value) {
            addCriterion("CBSA02 <>", value, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02GreaterThan(Date value) {
            addCriterion("CBSA02 >", value, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSA02 >=", value, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02LessThan(Date value) {
            addCriterion("CBSA02 <", value, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02LessThanOrEqualTo(Date value) {
            addCriterion("CBSA02 <=", value, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02In(List<Date> values) {
            addCriterion("CBSA02 in", values, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02NotIn(List<Date> values) {
            addCriterion("CBSA02 not in", values, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02Between(Date value1, Date value2) {
            addCriterion("CBSA02 between", value1, value2, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa02NotBetween(Date value1, Date value2) {
            addCriterion("CBSA02 not between", value1, value2, "cbsa02");
            return (Criteria) this;
        }

        public Criteria andCbsa03IsNull() {
            addCriterion("CBSA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa03IsNotNull() {
            addCriterion("CBSA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa03EqualTo(Integer value) {
            addCriterion("CBSA03 =", value, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03NotEqualTo(Integer value) {
            addCriterion("CBSA03 <>", value, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03GreaterThan(Integer value) {
            addCriterion("CBSA03 >", value, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSA03 >=", value, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03LessThan(Integer value) {
            addCriterion("CBSA03 <", value, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03LessThanOrEqualTo(Integer value) {
            addCriterion("CBSA03 <=", value, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03In(List<Integer> values) {
            addCriterion("CBSA03 in", values, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03NotIn(List<Integer> values) {
            addCriterion("CBSA03 not in", values, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03Between(Integer value1, Integer value2) {
            addCriterion("CBSA03 between", value1, value2, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSA03 not between", value1, value2, "cbsa03");
            return (Criteria) this;
        }

        public Criteria andCbsa04IsNull() {
            addCriterion("CBSA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa04IsNotNull() {
            addCriterion("CBSA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa04EqualTo(Date value) {
            addCriterion("CBSA04 =", value, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04NotEqualTo(Date value) {
            addCriterion("CBSA04 <>", value, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04GreaterThan(Date value) {
            addCriterion("CBSA04 >", value, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBSA04 >=", value, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04LessThan(Date value) {
            addCriterion("CBSA04 <", value, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04LessThanOrEqualTo(Date value) {
            addCriterion("CBSA04 <=", value, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04In(List<Date> values) {
            addCriterion("CBSA04 in", values, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04NotIn(List<Date> values) {
            addCriterion("CBSA04 not in", values, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04Between(Date value1, Date value2) {
            addCriterion("CBSA04 between", value1, value2, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa04NotBetween(Date value1, Date value2) {
            addCriterion("CBSA04 not between", value1, value2, "cbsa04");
            return (Criteria) this;
        }

        public Criteria andCbsa05IsNull() {
            addCriterion("CBSA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa05IsNotNull() {
            addCriterion("CBSA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa05EqualTo(Integer value) {
            addCriterion("CBSA05 =", value, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05NotEqualTo(Integer value) {
            addCriterion("CBSA05 <>", value, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05GreaterThan(Integer value) {
            addCriterion("CBSA05 >", value, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSA05 >=", value, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05LessThan(Integer value) {
            addCriterion("CBSA05 <", value, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05LessThanOrEqualTo(Integer value) {
            addCriterion("CBSA05 <=", value, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05In(List<Integer> values) {
            addCriterion("CBSA05 in", values, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05NotIn(List<Integer> values) {
            addCriterion("CBSA05 not in", values, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05Between(Integer value1, Integer value2) {
            addCriterion("CBSA05 between", value1, value2, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSA05 not between", value1, value2, "cbsa05");
            return (Criteria) this;
        }

        public Criteria andCbsa06IsNull() {
            addCriterion("CBSA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa06IsNotNull() {
            addCriterion("CBSA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa06EqualTo(Integer value) {
            addCriterion("CBSA06 =", value, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06NotEqualTo(Integer value) {
            addCriterion("CBSA06 <>", value, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06GreaterThan(Integer value) {
            addCriterion("CBSA06 >", value, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSA06 >=", value, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06LessThan(Integer value) {
            addCriterion("CBSA06 <", value, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06LessThanOrEqualTo(Integer value) {
            addCriterion("CBSA06 <=", value, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06In(List<Integer> values) {
            addCriterion("CBSA06 in", values, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06NotIn(List<Integer> values) {
            addCriterion("CBSA06 not in", values, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06Between(Integer value1, Integer value2) {
            addCriterion("CBSA06 between", value1, value2, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSA06 not between", value1, value2, "cbsa06");
            return (Criteria) this;
        }

        public Criteria andCbsa07IsNull() {
            addCriterion("CBSA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa07IsNotNull() {
            addCriterion("CBSA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa07EqualTo(String value) {
            addCriterion("CBSA07 =", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07NotEqualTo(String value) {
            addCriterion("CBSA07 <>", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07GreaterThan(String value) {
            addCriterion("CBSA07 >", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA07 >=", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07LessThan(String value) {
            addCriterion("CBSA07 <", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07LessThanOrEqualTo(String value) {
            addCriterion("CBSA07 <=", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07Like(String value) {
            addCriterion("CBSA07 like", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07NotLike(String value) {
            addCriterion("CBSA07 not like", value, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07In(List<String> values) {
            addCriterion("CBSA07 in", values, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07NotIn(List<String> values) {
            addCriterion("CBSA07 not in", values, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07Between(String value1, String value2) {
            addCriterion("CBSA07 between", value1, value2, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa07NotBetween(String value1, String value2) {
            addCriterion("CBSA07 not between", value1, value2, "cbsa07");
            return (Criteria) this;
        }

        public Criteria andCbsa08IsNull() {
            addCriterion("CBSA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa08IsNotNull() {
            addCriterion("CBSA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa08EqualTo(String value) {
            addCriterion("CBSA08 =", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08NotEqualTo(String value) {
            addCriterion("CBSA08 <>", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08GreaterThan(String value) {
            addCriterion("CBSA08 >", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA08 >=", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08LessThan(String value) {
            addCriterion("CBSA08 <", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08LessThanOrEqualTo(String value) {
            addCriterion("CBSA08 <=", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08Like(String value) {
            addCriterion("CBSA08 like", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08NotLike(String value) {
            addCriterion("CBSA08 not like", value, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08In(List<String> values) {
            addCriterion("CBSA08 in", values, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08NotIn(List<String> values) {
            addCriterion("CBSA08 not in", values, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08Between(String value1, String value2) {
            addCriterion("CBSA08 between", value1, value2, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa08NotBetween(String value1, String value2) {
            addCriterion("CBSA08 not between", value1, value2, "cbsa08");
            return (Criteria) this;
        }

        public Criteria andCbsa09IsNull() {
            addCriterion("CBSA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa09IsNotNull() {
            addCriterion("CBSA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa09EqualTo(String value) {
            addCriterion("CBSA09 =", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09NotEqualTo(String value) {
            addCriterion("CBSA09 <>", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09GreaterThan(String value) {
            addCriterion("CBSA09 >", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA09 >=", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09LessThan(String value) {
            addCriterion("CBSA09 <", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09LessThanOrEqualTo(String value) {
            addCriterion("CBSA09 <=", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09Like(String value) {
            addCriterion("CBSA09 like", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09NotLike(String value) {
            addCriterion("CBSA09 not like", value, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09In(List<String> values) {
            addCriterion("CBSA09 in", values, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09NotIn(List<String> values) {
            addCriterion("CBSA09 not in", values, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09Between(String value1, String value2) {
            addCriterion("CBSA09 between", value1, value2, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa09NotBetween(String value1, String value2) {
            addCriterion("CBSA09 not between", value1, value2, "cbsa09");
            return (Criteria) this;
        }

        public Criteria andCbsa10IsNull() {
            addCriterion("CBSA10 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa10IsNotNull() {
            addCriterion("CBSA10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa10EqualTo(String value) {
            addCriterion("CBSA10 =", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10NotEqualTo(String value) {
            addCriterion("CBSA10 <>", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10GreaterThan(String value) {
            addCriterion("CBSA10 >", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA10 >=", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10LessThan(String value) {
            addCriterion("CBSA10 <", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10LessThanOrEqualTo(String value) {
            addCriterion("CBSA10 <=", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10Like(String value) {
            addCriterion("CBSA10 like", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10NotLike(String value) {
            addCriterion("CBSA10 not like", value, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10In(List<String> values) {
            addCriterion("CBSA10 in", values, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10NotIn(List<String> values) {
            addCriterion("CBSA10 not in", values, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10Between(String value1, String value2) {
            addCriterion("CBSA10 between", value1, value2, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa10NotBetween(String value1, String value2) {
            addCriterion("CBSA10 not between", value1, value2, "cbsa10");
            return (Criteria) this;
        }

        public Criteria andCbsa11IsNull() {
            addCriterion("CBSA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa11IsNotNull() {
            addCriterion("CBSA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa11EqualTo(String value) {
            addCriterion("CBSA11 =", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11NotEqualTo(String value) {
            addCriterion("CBSA11 <>", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11GreaterThan(String value) {
            addCriterion("CBSA11 >", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA11 >=", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11LessThan(String value) {
            addCriterion("CBSA11 <", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11LessThanOrEqualTo(String value) {
            addCriterion("CBSA11 <=", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11Like(String value) {
            addCriterion("CBSA11 like", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11NotLike(String value) {
            addCriterion("CBSA11 not like", value, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11In(List<String> values) {
            addCriterion("CBSA11 in", values, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11NotIn(List<String> values) {
            addCriterion("CBSA11 not in", values, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11Between(String value1, String value2) {
            addCriterion("CBSA11 between", value1, value2, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa11NotBetween(String value1, String value2) {
            addCriterion("CBSA11 not between", value1, value2, "cbsa11");
            return (Criteria) this;
        }

        public Criteria andCbsa12IsNull() {
            addCriterion("CBSA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa12IsNotNull() {
            addCriterion("CBSA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa12EqualTo(String value) {
            addCriterion("CBSA12 =", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12NotEqualTo(String value) {
            addCriterion("CBSA12 <>", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12GreaterThan(String value) {
            addCriterion("CBSA12 >", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA12 >=", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12LessThan(String value) {
            addCriterion("CBSA12 <", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12LessThanOrEqualTo(String value) {
            addCriterion("CBSA12 <=", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12Like(String value) {
            addCriterion("CBSA12 like", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12NotLike(String value) {
            addCriterion("CBSA12 not like", value, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12In(List<String> values) {
            addCriterion("CBSA12 in", values, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12NotIn(List<String> values) {
            addCriterion("CBSA12 not in", values, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12Between(String value1, String value2) {
            addCriterion("CBSA12 between", value1, value2, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa12NotBetween(String value1, String value2) {
            addCriterion("CBSA12 not between", value1, value2, "cbsa12");
            return (Criteria) this;
        }

        public Criteria andCbsa13IsNull() {
            addCriterion("CBSA13 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa13IsNotNull() {
            addCriterion("CBSA13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa13EqualTo(String value) {
            addCriterion("CBSA13 =", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13NotEqualTo(String value) {
            addCriterion("CBSA13 <>", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13GreaterThan(String value) {
            addCriterion("CBSA13 >", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA13 >=", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13LessThan(String value) {
            addCriterion("CBSA13 <", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13LessThanOrEqualTo(String value) {
            addCriterion("CBSA13 <=", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13Like(String value) {
            addCriterion("CBSA13 like", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13NotLike(String value) {
            addCriterion("CBSA13 not like", value, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13In(List<String> values) {
            addCriterion("CBSA13 in", values, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13NotIn(List<String> values) {
            addCriterion("CBSA13 not in", values, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13Between(String value1, String value2) {
            addCriterion("CBSA13 between", value1, value2, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa13NotBetween(String value1, String value2) {
            addCriterion("CBSA13 not between", value1, value2, "cbsa13");
            return (Criteria) this;
        }

        public Criteria andCbsa14IsNull() {
            addCriterion("CBSA14 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa14IsNotNull() {
            addCriterion("CBSA14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa14EqualTo(String value) {
            addCriterion("CBSA14 =", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14NotEqualTo(String value) {
            addCriterion("CBSA14 <>", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14GreaterThan(String value) {
            addCriterion("CBSA14 >", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA14 >=", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14LessThan(String value) {
            addCriterion("CBSA14 <", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14LessThanOrEqualTo(String value) {
            addCriterion("CBSA14 <=", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14Like(String value) {
            addCriterion("CBSA14 like", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14NotLike(String value) {
            addCriterion("CBSA14 not like", value, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14In(List<String> values) {
            addCriterion("CBSA14 in", values, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14NotIn(List<String> values) {
            addCriterion("CBSA14 not in", values, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14Between(String value1, String value2) {
            addCriterion("CBSA14 between", value1, value2, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa14NotBetween(String value1, String value2) {
            addCriterion("CBSA14 not between", value1, value2, "cbsa14");
            return (Criteria) this;
        }

        public Criteria andCbsa15IsNull() {
            addCriterion("CBSA15 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa15IsNotNull() {
            addCriterion("CBSA15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa15EqualTo(String value) {
            addCriterion("CBSA15 =", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15NotEqualTo(String value) {
            addCriterion("CBSA15 <>", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15GreaterThan(String value) {
            addCriterion("CBSA15 >", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA15 >=", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15LessThan(String value) {
            addCriterion("CBSA15 <", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15LessThanOrEqualTo(String value) {
            addCriterion("CBSA15 <=", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15Like(String value) {
            addCriterion("CBSA15 like", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15NotLike(String value) {
            addCriterion("CBSA15 not like", value, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15In(List<String> values) {
            addCriterion("CBSA15 in", values, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15NotIn(List<String> values) {
            addCriterion("CBSA15 not in", values, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15Between(String value1, String value2) {
            addCriterion("CBSA15 between", value1, value2, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa15NotBetween(String value1, String value2) {
            addCriterion("CBSA15 not between", value1, value2, "cbsa15");
            return (Criteria) this;
        }

        public Criteria andCbsa16IsNull() {
            addCriterion("CBSA16 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa16IsNotNull() {
            addCriterion("CBSA16 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa16EqualTo(String value) {
            addCriterion("CBSA16 =", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16NotEqualTo(String value) {
            addCriterion("CBSA16 <>", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16GreaterThan(String value) {
            addCriterion("CBSA16 >", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA16 >=", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16LessThan(String value) {
            addCriterion("CBSA16 <", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16LessThanOrEqualTo(String value) {
            addCriterion("CBSA16 <=", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16Like(String value) {
            addCriterion("CBSA16 like", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16NotLike(String value) {
            addCriterion("CBSA16 not like", value, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16In(List<String> values) {
            addCriterion("CBSA16 in", values, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16NotIn(List<String> values) {
            addCriterion("CBSA16 not in", values, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16Between(String value1, String value2) {
            addCriterion("CBSA16 between", value1, value2, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa16NotBetween(String value1, String value2) {
            addCriterion("CBSA16 not between", value1, value2, "cbsa16");
            return (Criteria) this;
        }

        public Criteria andCbsa17IsNull() {
            addCriterion("CBSA17 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa17IsNotNull() {
            addCriterion("CBSA17 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa17EqualTo(String value) {
            addCriterion("CBSA17 =", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17NotEqualTo(String value) {
            addCriterion("CBSA17 <>", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17GreaterThan(String value) {
            addCriterion("CBSA17 >", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17GreaterThanOrEqualTo(String value) {
            addCriterion("CBSA17 >=", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17LessThan(String value) {
            addCriterion("CBSA17 <", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17LessThanOrEqualTo(String value) {
            addCriterion("CBSA17 <=", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17Like(String value) {
            addCriterion("CBSA17 like", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17NotLike(String value) {
            addCriterion("CBSA17 not like", value, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17In(List<String> values) {
            addCriterion("CBSA17 in", values, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17NotIn(List<String> values) {
            addCriterion("CBSA17 not in", values, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17Between(String value1, String value2) {
            addCriterion("CBSA17 between", value1, value2, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa17NotBetween(String value1, String value2) {
            addCriterion("CBSA17 not between", value1, value2, "cbsa17");
            return (Criteria) this;
        }

        public Criteria andCbsa18IsNull() {
            addCriterion("CBSA18 is null");
            return (Criteria) this;
        }

        public Criteria andCbsa18IsNotNull() {
            addCriterion("CBSA18 is not null");
            return (Criteria) this;
        }

        public Criteria andCbsa18EqualTo(Integer value) {
            addCriterion("CBSA18 =", value, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18NotEqualTo(Integer value) {
            addCriterion("CBSA18 <>", value, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18GreaterThan(Integer value) {
            addCriterion("CBSA18 >", value, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBSA18 >=", value, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18LessThan(Integer value) {
            addCriterion("CBSA18 <", value, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18LessThanOrEqualTo(Integer value) {
            addCriterion("CBSA18 <=", value, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18In(List<Integer> values) {
            addCriterion("CBSA18 in", values, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18NotIn(List<Integer> values) {
            addCriterion("CBSA18 not in", values, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18Between(Integer value1, Integer value2) {
            addCriterion("CBSA18 between", value1, value2, "cbsa18");
            return (Criteria) this;
        }

        public Criteria andCbsa18NotBetween(Integer value1, Integer value2) {
            addCriterion("CBSA18 not between", value1, value2, "cbsa18");
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
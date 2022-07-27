package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbpaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbpaCriteria() {
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

        public Criteria andCbpa01IsNull() {
            addCriterion("CBPA01 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa01IsNotNull() {
            addCriterion("CBPA01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa01EqualTo(Integer value) {
            addCriterion("CBPA01 =", value, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01NotEqualTo(Integer value) {
            addCriterion("CBPA01 <>", value, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01GreaterThan(Integer value) {
            addCriterion("CBPA01 >", value, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPA01 >=", value, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01LessThan(Integer value) {
            addCriterion("CBPA01 <", value, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01LessThanOrEqualTo(Integer value) {
            addCriterion("CBPA01 <=", value, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01In(List<Integer> values) {
            addCriterion("CBPA01 in", values, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01NotIn(List<Integer> values) {
            addCriterion("CBPA01 not in", values, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01Between(Integer value1, Integer value2) {
            addCriterion("CBPA01 between", value1, value2, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPA01 not between", value1, value2, "cbpa01");
            return (Criteria) this;
        }

        public Criteria andCbpa02IsNull() {
            addCriterion("CBPA02 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa02IsNotNull() {
            addCriterion("CBPA02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa02EqualTo(Date value) {
            addCriterion("CBPA02 =", value, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02NotEqualTo(Date value) {
            addCriterion("CBPA02 <>", value, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02GreaterThan(Date value) {
            addCriterion("CBPA02 >", value, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPA02 >=", value, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02LessThan(Date value) {
            addCriterion("CBPA02 <", value, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02LessThanOrEqualTo(Date value) {
            addCriterion("CBPA02 <=", value, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02In(List<Date> values) {
            addCriterion("CBPA02 in", values, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02NotIn(List<Date> values) {
            addCriterion("CBPA02 not in", values, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02Between(Date value1, Date value2) {
            addCriterion("CBPA02 between", value1, value2, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa02NotBetween(Date value1, Date value2) {
            addCriterion("CBPA02 not between", value1, value2, "cbpa02");
            return (Criteria) this;
        }

        public Criteria andCbpa03IsNull() {
            addCriterion("CBPA03 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa03IsNotNull() {
            addCriterion("CBPA03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa03EqualTo(Date value) {
            addCriterion("CBPA03 =", value, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03NotEqualTo(Date value) {
            addCriterion("CBPA03 <>", value, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03GreaterThan(Date value) {
            addCriterion("CBPA03 >", value, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBPA03 >=", value, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03LessThan(Date value) {
            addCriterion("CBPA03 <", value, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03LessThanOrEqualTo(Date value) {
            addCriterion("CBPA03 <=", value, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03In(List<Date> values) {
            addCriterion("CBPA03 in", values, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03NotIn(List<Date> values) {
            addCriterion("CBPA03 not in", values, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03Between(Date value1, Date value2) {
            addCriterion("CBPA03 between", value1, value2, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa03NotBetween(Date value1, Date value2) {
            addCriterion("CBPA03 not between", value1, value2, "cbpa03");
            return (Criteria) this;
        }

        public Criteria andCbpa04IsNull() {
            addCriterion("CBPA04 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa04IsNotNull() {
            addCriterion("CBPA04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa04EqualTo(Integer value) {
            addCriterion("CBPA04 =", value, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04NotEqualTo(Integer value) {
            addCriterion("CBPA04 <>", value, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04GreaterThan(Integer value) {
            addCriterion("CBPA04 >", value, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPA04 >=", value, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04LessThan(Integer value) {
            addCriterion("CBPA04 <", value, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04LessThanOrEqualTo(Integer value) {
            addCriterion("CBPA04 <=", value, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04In(List<Integer> values) {
            addCriterion("CBPA04 in", values, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04NotIn(List<Integer> values) {
            addCriterion("CBPA04 not in", values, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04Between(Integer value1, Integer value2) {
            addCriterion("CBPA04 between", value1, value2, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPA04 not between", value1, value2, "cbpa04");
            return (Criteria) this;
        }

        public Criteria andCbpa05IsNull() {
            addCriterion("CBPA05 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa05IsNotNull() {
            addCriterion("CBPA05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa05EqualTo(Integer value) {
            addCriterion("CBPA05 =", value, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05NotEqualTo(Integer value) {
            addCriterion("CBPA05 <>", value, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05GreaterThan(Integer value) {
            addCriterion("CBPA05 >", value, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPA05 >=", value, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05LessThan(Integer value) {
            addCriterion("CBPA05 <", value, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05LessThanOrEqualTo(Integer value) {
            addCriterion("CBPA05 <=", value, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05In(List<Integer> values) {
            addCriterion("CBPA05 in", values, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05NotIn(List<Integer> values) {
            addCriterion("CBPA05 not in", values, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05Between(Integer value1, Integer value2) {
            addCriterion("CBPA05 between", value1, value2, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPA05 not between", value1, value2, "cbpa05");
            return (Criteria) this;
        }

        public Criteria andCbpa06IsNull() {
            addCriterion("CBPA06 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa06IsNotNull() {
            addCriterion("CBPA06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa06EqualTo(Integer value) {
            addCriterion("CBPA06 =", value, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06NotEqualTo(Integer value) {
            addCriterion("CBPA06 <>", value, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06GreaterThan(Integer value) {
            addCriterion("CBPA06 >", value, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPA06 >=", value, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06LessThan(Integer value) {
            addCriterion("CBPA06 <", value, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06LessThanOrEqualTo(Integer value) {
            addCriterion("CBPA06 <=", value, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06In(List<Integer> values) {
            addCriterion("CBPA06 in", values, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06NotIn(List<Integer> values) {
            addCriterion("CBPA06 not in", values, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06Between(Integer value1, Integer value2) {
            addCriterion("CBPA06 between", value1, value2, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPA06 not between", value1, value2, "cbpa06");
            return (Criteria) this;
        }

        public Criteria andCbpa07IsNull() {
            addCriterion("CBPA07 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa07IsNotNull() {
            addCriterion("CBPA07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa07EqualTo(String value) {
            addCriterion("CBPA07 =", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07NotEqualTo(String value) {
            addCriterion("CBPA07 <>", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07GreaterThan(String value) {
            addCriterion("CBPA07 >", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07GreaterThanOrEqualTo(String value) {
            addCriterion("CBPA07 >=", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07LessThan(String value) {
            addCriterion("CBPA07 <", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07LessThanOrEqualTo(String value) {
            addCriterion("CBPA07 <=", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07Like(String value) {
            addCriterion("CBPA07 like", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07NotLike(String value) {
            addCriterion("CBPA07 not like", value, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07In(List<String> values) {
            addCriterion("CBPA07 in", values, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07NotIn(List<String> values) {
            addCriterion("CBPA07 not in", values, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07Between(String value1, String value2) {
            addCriterion("CBPA07 between", value1, value2, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa07NotBetween(String value1, String value2) {
            addCriterion("CBPA07 not between", value1, value2, "cbpa07");
            return (Criteria) this;
        }

        public Criteria andCbpa08IsNull() {
            addCriterion("CBPA08 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa08IsNotNull() {
            addCriterion("CBPA08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa08EqualTo(String value) {
            addCriterion("CBPA08 =", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08NotEqualTo(String value) {
            addCriterion("CBPA08 <>", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08GreaterThan(String value) {
            addCriterion("CBPA08 >", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08GreaterThanOrEqualTo(String value) {
            addCriterion("CBPA08 >=", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08LessThan(String value) {
            addCriterion("CBPA08 <", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08LessThanOrEqualTo(String value) {
            addCriterion("CBPA08 <=", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08Like(String value) {
            addCriterion("CBPA08 like", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08NotLike(String value) {
            addCriterion("CBPA08 not like", value, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08In(List<String> values) {
            addCriterion("CBPA08 in", values, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08NotIn(List<String> values) {
            addCriterion("CBPA08 not in", values, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08Between(String value1, String value2) {
            addCriterion("CBPA08 between", value1, value2, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa08NotBetween(String value1, String value2) {
            addCriterion("CBPA08 not between", value1, value2, "cbpa08");
            return (Criteria) this;
        }

        public Criteria andCbpa09IsNull() {
            addCriterion("CBPA09 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa09IsNotNull() {
            addCriterion("CBPA09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa09EqualTo(Integer value) {
            addCriterion("CBPA09 =", value, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09NotEqualTo(Integer value) {
            addCriterion("CBPA09 <>", value, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09GreaterThan(Integer value) {
            addCriterion("CBPA09 >", value, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBPA09 >=", value, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09LessThan(Integer value) {
            addCriterion("CBPA09 <", value, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09LessThanOrEqualTo(Integer value) {
            addCriterion("CBPA09 <=", value, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09In(List<Integer> values) {
            addCriterion("CBPA09 in", values, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09NotIn(List<Integer> values) {
            addCriterion("CBPA09 not in", values, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09Between(Integer value1, Integer value2) {
            addCriterion("CBPA09 between", value1, value2, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBPA09 not between", value1, value2, "cbpa09");
            return (Criteria) this;
        }

        public Criteria andCbpa11IsNull() {
            addCriterion("CBPA11 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa11IsNotNull() {
            addCriterion("CBPA11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa11EqualTo(String value) {
            addCriterion("CBPA11 =", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11NotEqualTo(String value) {
            addCriterion("CBPA11 <>", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11GreaterThan(String value) {
            addCriterion("CBPA11 >", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11GreaterThanOrEqualTo(String value) {
            addCriterion("CBPA11 >=", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11LessThan(String value) {
            addCriterion("CBPA11 <", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11LessThanOrEqualTo(String value) {
            addCriterion("CBPA11 <=", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11Like(String value) {
            addCriterion("CBPA11 like", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11NotLike(String value) {
            addCriterion("CBPA11 not like", value, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11In(List<String> values) {
            addCriterion("CBPA11 in", values, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11NotIn(List<String> values) {
            addCriterion("CBPA11 not in", values, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11Between(String value1, String value2) {
            addCriterion("CBPA11 between", value1, value2, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa11NotBetween(String value1, String value2) {
            addCriterion("CBPA11 not between", value1, value2, "cbpa11");
            return (Criteria) this;
        }

        public Criteria andCbpa12IsNull() {
            addCriterion("CBPA12 is null");
            return (Criteria) this;
        }

        public Criteria andCbpa12IsNotNull() {
            addCriterion("CBPA12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbpa12EqualTo(String value) {
            addCriterion("CBPA12 =", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12NotEqualTo(String value) {
            addCriterion("CBPA12 <>", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12GreaterThan(String value) {
            addCriterion("CBPA12 >", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12GreaterThanOrEqualTo(String value) {
            addCriterion("CBPA12 >=", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12LessThan(String value) {
            addCriterion("CBPA12 <", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12LessThanOrEqualTo(String value) {
            addCriterion("CBPA12 <=", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12Like(String value) {
            addCriterion("CBPA12 like", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12NotLike(String value) {
            addCriterion("CBPA12 not like", value, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12In(List<String> values) {
            addCriterion("CBPA12 in", values, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12NotIn(List<String> values) {
            addCriterion("CBPA12 not in", values, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12Between(String value1, String value2) {
            addCriterion("CBPA12 between", value1, value2, "cbpa12");
            return (Criteria) this;
        }

        public Criteria andCbpa12NotBetween(String value1, String value2) {
            addCriterion("CBPA12 not between", value1, value2, "cbpa12");
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
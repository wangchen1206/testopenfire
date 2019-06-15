package com.hp.roam.model;

import java.util.ArrayList;
import java.util.List;

public class OfUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfUserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andStoredKeyIsNull() {
            addCriterion("storedKey is null");
            return (Criteria) this;
        }

        public Criteria andStoredKeyIsNotNull() {
            addCriterion("storedKey is not null");
            return (Criteria) this;
        }

        public Criteria andStoredKeyEqualTo(String value) {
            addCriterion("storedKey =", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyNotEqualTo(String value) {
            addCriterion("storedKey <>", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyGreaterThan(String value) {
            addCriterion("storedKey >", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyGreaterThanOrEqualTo(String value) {
            addCriterion("storedKey >=", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyLessThan(String value) {
            addCriterion("storedKey <", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyLessThanOrEqualTo(String value) {
            addCriterion("storedKey <=", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyLike(String value) {
            addCriterion("storedKey like", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyNotLike(String value) {
            addCriterion("storedKey not like", value, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyIn(List<String> values) {
            addCriterion("storedKey in", values, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyNotIn(List<String> values) {
            addCriterion("storedKey not in", values, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyBetween(String value1, String value2) {
            addCriterion("storedKey between", value1, value2, "storedKey");
            return (Criteria) this;
        }

        public Criteria andStoredKeyNotBetween(String value1, String value2) {
            addCriterion("storedKey not between", value1, value2, "storedKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyIsNull() {
            addCriterion("serverKey is null");
            return (Criteria) this;
        }

        public Criteria andServerKeyIsNotNull() {
            addCriterion("serverKey is not null");
            return (Criteria) this;
        }

        public Criteria andServerKeyEqualTo(String value) {
            addCriterion("serverKey =", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyNotEqualTo(String value) {
            addCriterion("serverKey <>", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyGreaterThan(String value) {
            addCriterion("serverKey >", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyGreaterThanOrEqualTo(String value) {
            addCriterion("serverKey >=", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyLessThan(String value) {
            addCriterion("serverKey <", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyLessThanOrEqualTo(String value) {
            addCriterion("serverKey <=", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyLike(String value) {
            addCriterion("serverKey like", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyNotLike(String value) {
            addCriterion("serverKey not like", value, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyIn(List<String> values) {
            addCriterion("serverKey in", values, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyNotIn(List<String> values) {
            addCriterion("serverKey not in", values, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyBetween(String value1, String value2) {
            addCriterion("serverKey between", value1, value2, "serverKey");
            return (Criteria) this;
        }

        public Criteria andServerKeyNotBetween(String value1, String value2) {
            addCriterion("serverKey not between", value1, value2, "serverKey");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andIterationsIsNull() {
            addCriterion("iterations is null");
            return (Criteria) this;
        }

        public Criteria andIterationsIsNotNull() {
            addCriterion("iterations is not null");
            return (Criteria) this;
        }

        public Criteria andIterationsEqualTo(Integer value) {
            addCriterion("iterations =", value, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsNotEqualTo(Integer value) {
            addCriterion("iterations <>", value, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsGreaterThan(Integer value) {
            addCriterion("iterations >", value, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsGreaterThanOrEqualTo(Integer value) {
            addCriterion("iterations >=", value, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsLessThan(Integer value) {
            addCriterion("iterations <", value, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsLessThanOrEqualTo(Integer value) {
            addCriterion("iterations <=", value, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsIn(List<Integer> values) {
            addCriterion("iterations in", values, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsNotIn(List<Integer> values) {
            addCriterion("iterations not in", values, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsBetween(Integer value1, Integer value2) {
            addCriterion("iterations between", value1, value2, "iterations");
            return (Criteria) this;
        }

        public Criteria andIterationsNotBetween(Integer value1, Integer value2) {
            addCriterion("iterations not between", value1, value2, "iterations");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordIsNull() {
            addCriterion("plainPassword is null");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordIsNotNull() {
            addCriterion("plainPassword is not null");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordEqualTo(String value) {
            addCriterion("plainPassword =", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordNotEqualTo(String value) {
            addCriterion("plainPassword <>", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordGreaterThan(String value) {
            addCriterion("plainPassword >", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("plainPassword >=", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordLessThan(String value) {
            addCriterion("plainPassword <", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordLessThanOrEqualTo(String value) {
            addCriterion("plainPassword <=", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordLike(String value) {
            addCriterion("plainPassword like", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordNotLike(String value) {
            addCriterion("plainPassword not like", value, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordIn(List<String> values) {
            addCriterion("plainPassword in", values, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordNotIn(List<String> values) {
            addCriterion("plainPassword not in", values, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordBetween(String value1, String value2) {
            addCriterion("plainPassword between", value1, value2, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andPlainPasswordNotBetween(String value1, String value2) {
            addCriterion("plainPassword not between", value1, value2, "plainPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordIsNull() {
            addCriterion("encryptedPassword is null");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordIsNotNull() {
            addCriterion("encryptedPassword is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordEqualTo(String value) {
            addCriterion("encryptedPassword =", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordNotEqualTo(String value) {
            addCriterion("encryptedPassword <>", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordGreaterThan(String value) {
            addCriterion("encryptedPassword >", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("encryptedPassword >=", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordLessThan(String value) {
            addCriterion("encryptedPassword <", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordLessThanOrEqualTo(String value) {
            addCriterion("encryptedPassword <=", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordLike(String value) {
            addCriterion("encryptedPassword like", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordNotLike(String value) {
            addCriterion("encryptedPassword not like", value, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordIn(List<String> values) {
            addCriterion("encryptedPassword in", values, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordNotIn(List<String> values) {
            addCriterion("encryptedPassword not in", values, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordBetween(String value1, String value2) {
            addCriterion("encryptedPassword between", value1, value2, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptedPasswordNotBetween(String value1, String value2) {
            addCriterion("encryptedPassword not between", value1, value2, "encryptedPassword");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("creationDate is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("creationDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(String value) {
            addCriterion("creationDate =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(String value) {
            addCriterion("creationDate <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(String value) {
            addCriterion("creationDate >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(String value) {
            addCriterion("creationDate >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(String value) {
            addCriterion("creationDate <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(String value) {
            addCriterion("creationDate <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLike(String value) {
            addCriterion("creationDate like", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotLike(String value) {
            addCriterion("creationDate not like", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<String> values) {
            addCriterion("creationDate in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<String> values) {
            addCriterion("creationDate not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(String value1, String value2) {
            addCriterion("creationDate between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(String value1, String value2) {
            addCriterion("creationDate not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateIsNull() {
            addCriterion("modificationDate is null");
            return (Criteria) this;
        }

        public Criteria andModificationDateIsNotNull() {
            addCriterion("modificationDate is not null");
            return (Criteria) this;
        }

        public Criteria andModificationDateEqualTo(String value) {
            addCriterion("modificationDate =", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotEqualTo(String value) {
            addCriterion("modificationDate <>", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateGreaterThan(String value) {
            addCriterion("modificationDate >", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateGreaterThanOrEqualTo(String value) {
            addCriterion("modificationDate >=", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLessThan(String value) {
            addCriterion("modificationDate <", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLessThanOrEqualTo(String value) {
            addCriterion("modificationDate <=", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLike(String value) {
            addCriterion("modificationDate like", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotLike(String value) {
            addCriterion("modificationDate not like", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateIn(List<String> values) {
            addCriterion("modificationDate in", values, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotIn(List<String> values) {
            addCriterion("modificationDate not in", values, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateBetween(String value1, String value2) {
            addCriterion("modificationDate between", value1, value2, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotBetween(String value1, String value2) {
            addCriterion("modificationDate not between", value1, value2, "modificationDate");
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
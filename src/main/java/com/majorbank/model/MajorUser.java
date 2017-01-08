package com.majorbank.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by AndySun on 2016/12/31.
 */
public class MajorUser implements Serializable {
    private long id;
    private String username;
    private String password;
    private String industryTypeRole;
    private String qbCategoryRole;
    private String qbTypeRole;
    private String bankRole;
    private Date changeDate;

    public MajorUser() {
    }

    public MajorUser(long id, String username, String password,
                     String industryTypeRole, String qbCategoryRole,
                     String qbTypeRole, String bankRole, Date changeDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.industryTypeRole = industryTypeRole;
        this.qbCategoryRole = qbCategoryRole;
        this.qbTypeRole = qbTypeRole;
        this.bankRole = bankRole;
        this.changeDate = changeDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndustryTypeRole() {
        return industryTypeRole;
    }

    public void setIndustryTypeRole(String industryTypeRole) {
        this.industryTypeRole = industryTypeRole;
    }

    public String getQbCategoryRole() {
        return qbCategoryRole;
    }

    public void setQbCategoryRole(String qbCategoryRole) {
        this.qbCategoryRole = qbCategoryRole;
    }

    public String getQbTypeRole() {
        return qbTypeRole;
    }

    public void setQbTypeRole(String qbTypeRole) {
        this.qbTypeRole = qbTypeRole;
    }

    public String getBankRole() {
        return bankRole;
    }

    public void setBankRole(String bankRole) {
        this.bankRole = bankRole;
    }
}

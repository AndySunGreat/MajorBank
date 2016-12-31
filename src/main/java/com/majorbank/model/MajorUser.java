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
    private String bankrole;
    private Date changeDate;

    public MajorUser() {
    }

    public MajorUser(long id, String username, String password, String bankrole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bankrole = bankrole;
    }

    public MajorUser(long id, String username, String password, String bankrole, Date changeDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bankrole = bankrole;
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

    public String getBankrole() {
        return bankrole;
    }

    public void setBankrole(String bankrole) {
        this.bankrole = bankrole;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}

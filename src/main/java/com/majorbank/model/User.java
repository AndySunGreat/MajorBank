package com.majorbank.model;

import java.io.Serializable;

/**
 * Created by AndySun on 2016/10/2.
 */
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String jobId;
    private String jobName;




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

    public User(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User() {
    }
}

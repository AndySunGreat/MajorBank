package com.majorbank.model;

/**
 * Created by AndySun on 2016/10/5.
 */
public class UserFilter {
    private long id;
    private String username;
    private String password;

    public UserFilter() {
    }

    public UserFilter(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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
}

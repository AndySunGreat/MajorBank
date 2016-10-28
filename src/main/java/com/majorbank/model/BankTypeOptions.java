package com.majorbank.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AndySun on 2016/10/28.
 */
public class BankTypeOptions implements Serializable {
    private String id;
    private String key;
    private String value;

    public BankTypeOptions() {
    }

    public BankTypeOptions(String id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

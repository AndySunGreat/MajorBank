package com.majorbank.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AndySun on 2016/10/28.
 */
public class BankCategoryOptions implements Serializable {
    private String id;
    private String key;
    private String value;
    private List<BankTypeOptions> types;

    public BankCategoryOptions(String id, String key, String value, List<BankTypeOptions> types) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.types = types;
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

    public List<BankTypeOptions> getTypes() {
        return types;
    }

    public void setTypes(List<BankTypeOptions> types) {
        this.types = types;
    }
}

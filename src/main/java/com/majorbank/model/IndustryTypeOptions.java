package com.majorbank.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AndySun on 2016/10/28.
 */
public class IndustryTypeOptions implements Serializable {
    private String id;
    private String key;
    private String value;
    private List<BankCategoryOptions> categories;

    public IndustryTypeOptions(String id, String key, String value, List<BankCategoryOptions> categories) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.categories = categories;
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

    public List<BankCategoryOptions> getCategories() {
        return categories;
    }

    public void setCategories(List<BankCategoryOptions> categories) {
        this.categories = categories;
    }
}

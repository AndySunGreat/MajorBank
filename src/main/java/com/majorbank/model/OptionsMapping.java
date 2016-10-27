package com.majorbank.model;

import java.io.Serializable;

/**
 * Created by AndySun on 2016/10/27.
 */
public class OptionsMapping implements Serializable {
    private long id;
    private String itemName;
    private String itemKey;
    private String itemValue;
    private String itemParentValue;

    public OptionsMapping() {
    }

    public OptionsMapping(long id, String itemName,
                          String itemKey, String itemValue,
                          String itemParentValue) {
        this.id = id;
        this.itemName = itemName;
        this.itemKey = itemKey;
        this.itemValue = itemValue;
        this.itemParentValue = itemParentValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemParentValue() {
        return itemParentValue;
    }

    public void setItemParentValue(String itemParentValue) {
        this.itemParentValue = itemParentValue;
    }
}

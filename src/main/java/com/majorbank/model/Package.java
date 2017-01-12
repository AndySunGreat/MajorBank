package com.majorbank.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by AndySun on 2016/10/6.
 * 比如：
 * 1) Java SSE - 第I段的套餐是JavaCore+SpringMVC+AngularJS
 */
public class Package implements Serializable {
    private long packageId; // 套餐ID
    private String packageName; // 套餐名称
    private String jobIds; // 岗位的ID
    private String jobNames;
    private String bankIdsJson;// 存放该套餐配置的一组bankID
    private String bankNames;
    private Date createDate; // 创建时间
    private Date changeDate; // 套餐修改时间
    private String packageDesc;

    public Package() {
    }

    public Package(long packageId, String packageName, String jobIds,
                   String jobNames, String bankIdsJson,
                   Date createDate, Date changeDate, String packageDesc,String bankNames) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.jobIds = jobIds;
        this.jobNames = jobNames;
        this.bankIdsJson = bankIdsJson;
        this.createDate = createDate;
        this.changeDate = changeDate;
        this.packageDesc = packageDesc;
        this.bankNames = bankNames;
    }

    public String getBankNames() {
        return bankNames;
    }

    public void setBankNames(String bankNames) {
        this.bankNames = bankNames;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getJobIds() {
        return jobIds;
    }

    public void setJobIds(String jobIds) {
        this.jobIds = jobIds;
    }

    public String getJobNames() {
        return jobNames;
    }

    public void setJobNames(String jobNames) {
        this.jobNames = jobNames;
    }

    public String getBankIdsJson() {
        return bankIdsJson;
    }

    public void setBankIdsJson(String bankIdsJson) {
        this.bankIdsJson = bankIdsJson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }
}

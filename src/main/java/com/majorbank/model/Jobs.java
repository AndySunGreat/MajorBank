package com.majorbank.model;

import java.io.Serializable;

/**
 * Created by AndySun on 2017/1/10.
 */
public class Jobs implements Serializable {
    private long jobId;
    private String jobName;
    private String jobCategory;
    private String industryType;
    private String jobGroup;
    private String jobLevel;
    private String jobIds;

    public Jobs() {
    }

    public Jobs(long jobId, String jobName,
                String jobCategory, String industryType,
                String jobGroup, String jobLevel, String jobIds) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobCategory = jobCategory;
        this.industryType = industryType;
        this.jobGroup = jobGroup;
        this.jobLevel = jobLevel;
        this.jobIds = jobIds;
    }

    public Jobs(long jobId, String jobName,
                String jobCategory, String industryType,
                String jobGroup, String jobLevel) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobCategory = jobCategory;
        this.industryType = industryType;
        this.jobGroup = jobGroup;
        this.jobLevel = jobLevel;
    }

    public String getJobIds() {
        return jobIds;
    }

    public void setJobIds(String jobIds) {
        this.jobIds = jobIds;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }
}

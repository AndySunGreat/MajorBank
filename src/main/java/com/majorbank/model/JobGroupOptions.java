package com.majorbank.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AndySun on 2017/1/12.
 */
public class JobGroupOptions implements Serializable {
    private String jobGroup;
    private List<Jobs> jobsList;

    public JobGroupOptions() {
    }

    public JobGroupOptions(String jobGroup, List<Jobs> jobsList) {
        this.jobGroup = jobGroup;
        this.jobsList = jobsList;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public List<Jobs> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<Jobs> jobsList) {
        this.jobsList = jobsList;
    }
}

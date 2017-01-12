package com.majorbank.model;

import java.util.List;

/**
 * Created by AndySun on 2017/1/12.
 */
public class JobIndustryTypeOptions {
    private String industryTypeValue;
    private List<JobGroupOptions> jobGroupOptionsList;

    public JobIndustryTypeOptions() {
    }

    public JobIndustryTypeOptions(String industryTypeValue, List<JobGroupOptions> jobGroupOptionsList) {
        this.industryTypeValue = industryTypeValue;
        this.jobGroupOptionsList = jobGroupOptionsList;
    }

    public String getIndustryTypeValue() {
        return industryTypeValue;
    }

    public void setIndustryTypeValue(String industryTypeValue) {
        this.industryTypeValue = industryTypeValue;
    }

    public List<JobGroupOptions> getJobGroupOptionsList() {
        return jobGroupOptionsList;
    }

    public void setJobGroupOptionsList(List<JobGroupOptions> jobGroupOptionsList) {
        this.jobGroupOptionsList = jobGroupOptionsList;
    }
}

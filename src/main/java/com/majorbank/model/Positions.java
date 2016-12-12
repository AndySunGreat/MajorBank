package com.majorbank.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by AndySun on 2016/12/12.
 */
public class Positions implements Serializable {
    private long positionId;
    private String positionName;
    private String requiredJson;
    private String salary;
    private long experience;
    private String city;
    private List<PositionsOption> positionsOptionList;
    private long companyId;
    private String positionIds;
    private Date changeDate;

    public Positions(){

    }

    public Positions(long positionId, String positionName,
                     String requiredJson, String salary,
                     long experience, String city,
                     List<PositionsOption> positionsOptionList, long companyId,
                     String positionIds, Date changeDate) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.requiredJson = requiredJson;
        this.salary = salary;
        this.experience = experience;
        this.city = city;
        this.positionsOptionList = positionsOptionList;
        this.companyId = companyId;
        this.positionIds = positionIds;
        this.changeDate = changeDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(String positionIds) {
        this.positionIds = positionIds;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getRequiredJson() {
        return requiredJson;
    }

    public void setRequiredJson(String requiredJson) {
        this.requiredJson = requiredJson;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<PositionsOption> getPositionsOptionList() {
        return positionsOptionList;
    }

    public void setPositionsOptionList(List<PositionsOption> positionsOptionList) {
        this.positionsOptionList = positionsOptionList;
    }
}

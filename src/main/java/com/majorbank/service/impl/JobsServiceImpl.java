package com.majorbank.service.impl;

import com.majorbank.mapper.JobsMapper;
import com.majorbank.model.JobGroupOptions;
import com.majorbank.model.JobIndustryTypeOptions;
import com.majorbank.model.Jobs;
import com.majorbank.service.JobsService;
import com.majorbank.service.JobsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("jobsService")
@Transactional
public class JobsServiceImpl implements JobsService {
    private static final Logger LOG = LoggerFactory.getLogger(JobsServiceImpl.class);

    @Autowired
    private JobsMapper jobsMapper;

    @Override
    public String getJobNames(String jobIds) {
        Jobs jobsParam = new Jobs();
        String[] strJobIdsArr = jobIds.split(",");
        List list = new ArrayList(Arrays.asList(strJobIdsArr));
        List<Jobs> jobsList = jobsMapper.getJobNames(list);
        Jobs jobs = new Jobs();
        String jobNames = "";
        for(int a=0;a<jobsList.size();a++){
            jobs = (Jobs) jobsList.get(a);
            jobNames = jobNames + jobs.getJobName();
            if(a<jobsList.size()-1){
                jobNames = jobNames + ",";
            }
        }
        return jobNames;
    }

    @Override
    public List<Jobs> getJobDetailForIDS(String jobIds) {
        Jobs jobsParam = new Jobs();
        String[] strJobIdsArr = jobIds.split(",");
        List list = new ArrayList(Arrays.asList(strJobIdsArr));
        List<Jobs> jobsList = jobsMapper.getJobNames(list);
        return jobsList;
    }


 /*   @Override
    public List<JobIndustryTypeOptions> getJobIndustryType(String tmp) {
        return jobsMapper.getJobIndustryType(tmp);
    }

    @Override
    public List<JobGroupOptions> getJobGroupOptionList(String industryType) {
        return jobsMapper.getJobGroupOptionList(industryType);
    }

    @Override
    public List<Jobs> getJobsList(String jobGroup) {
        return jobsMapper.getJobsList(jobGroup);
    }*/

    public List<Jobs> getAllJobs(Jobs jobs){
        return jobsMapper.getAllJobs(jobs);
    }
/*




    public int insertJobs(Jobs package1){
        return packageMapper.insertJobs(package1);
    }

    public Jobs getJobsById(long packageId){
        return packageMapper.getJobsById(packageId);
    }

    public int updateJobs(Jobs package1){
        return packageMapper.updateJobs(package1);
    }

    public int deleteJobs(long packageId){
        return packageMapper.deleteJobs(packageId);
    }

    public List<Jobs> getAutoJobsByJobId(long jobId){
        return packageMapper.getAutoJobsByJobId(jobId);
    }*/
}

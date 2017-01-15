package com.majorbank.mapper;

import com.majorbank.model.JobGroupOptions;
import com.majorbank.model.JobIndustryTypeOptions;
import com.majorbank.model.Jobs;
import com.majorbank.model.Package;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface JobsMapper {

    List<Jobs> getJobNames(List jobIds);


    List<Jobs> getAllJobs(Jobs jobs);

 /*   List<JobIndustryTypeOptions> getJobIndustryType(String tmp);

    List<JobGroupOptions> getJobGroupOptionList(String industryType);

    List<Jobs> getJobsList(String jobGroup);*/
}

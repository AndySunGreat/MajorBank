package com.majorbank.service;

import com.majorbank.model.JobGroupOptions;
import com.majorbank.model.JobIndustryTypeOptions;
import com.majorbank.model.Jobs;
import com.majorbank.model.Package;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface JobsService {

    String getJobNames(String jobIds);

    List<Jobs> getAllJobs(Jobs jobs);

    List<Jobs> getJobDetailForIDS(String jobIds);

/*    List<JobIndustryTypeOptions> getJobIndustryType(String aaa);

    List<JobGroupOptions> getJobGroupOptionList(String industryType);

    List<Jobs> getJobsList(String jobGroup);*/

/*    List<Package> getAllPackages(Package package1);
    int insertPackage(Package package1);
    Package getPackageById(long packageId);
    int updatePackage(Package package1);
    int deletePackage(long packageId);
    List<Package> getAutoPackageByJobId(long jobId);*/
}

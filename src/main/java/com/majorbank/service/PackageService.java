package com.majorbank.service;

import com.majorbank.model.Banks;
import com.majorbank.model.Package;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface PackageService {
    List<Package> getAllPackages(Package package1);
    int insertPackage(Package package1);
    Package getPackageById(long packageId);
    int updatePackage(Package package1);
    int deletePackage(long packageId);
    List<Package> getAutoPackageByJobId(long jobId);
}

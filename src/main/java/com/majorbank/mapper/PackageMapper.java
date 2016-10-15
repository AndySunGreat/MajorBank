package com.majorbank.mapper;

import com.majorbank.model.Package;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface PackageMapper {
    List<Package> getAllPackages(Package package1);
    int insertPackage(Package package1);
    Package getPackageById(long packageId);
    int updatePackage(Package package1);
    int deletePackage(long packageId);
    List<Package> getAutoPackageByJobId(long jobId);
}

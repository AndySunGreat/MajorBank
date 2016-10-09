package com.majorbank.service.impl;

import com.majorbank.mapper.PackageMapper;
import com.majorbank.model.Package;
import com.majorbank.service.PackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("packageService")
@Transactional
public class PackageServiceImpl implements PackageService{
    private static final Logger LOG = LoggerFactory.getLogger(PackageServiceImpl.class);

    @Autowired
    private PackageMapper packageMapper;

    public List<Package> getAllPackages(Package package1){
        List<Package> a = packageMapper.getAllPackages(package1);
        LOG.info("a:" + a);
        return packageMapper.getAllPackages(package1);
    }
    public void insertPackage(Package package1){
        packageMapper.insertPackage(package1);
    }

    public Package getPackageById(long packageId){
        return packageMapper.getPackageById(packageId);
    }

    public void updatePackage(Package package1){
        packageMapper.updatePackage(package1);
    }

    public void deletePackage(long packageId){
        packageMapper.deletePackage(packageId);
    }

    public List<Package> getAutoPackageByJobId(long jobId){
        return packageMapper.getAutoPackageByJobId(jobId);
    }
}

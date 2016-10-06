package com.majorbank.service.impl;

import com.majorbank.mapper.PackageMapper;
import com.majorbank.model.Package;
import com.majorbank.service.PackageService;
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
    @Autowired
    private PackageMapper packageMapper;

    public List<Package> getAllPackages(Package package1){
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
    
}

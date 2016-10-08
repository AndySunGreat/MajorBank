package com.majorbank.service;

import com.majorbank.model.Order;
import com.majorbank.model.Package;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface PackageService {
    List<Package> getAllPackages(Package package1);
    void insertPackage(Package package1);
    Package getPackageById(long packageId);
    void updatePackage(Package package1);
    void deletePackage(long packageId);
}
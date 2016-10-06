package com.majorbank.controller;

import com.majorbank.model.Order;
import com.majorbank.model.Package;
import com.majorbank.model.Package;
import com.majorbank.service.PackageService;
import com.majorbank.service.PackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/login")
public class PackageController {
    private static final Logger LOG = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackageService packageService;

    /**
     * list all Package
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package"},method = {RequestMethod.GET})
    public List<Package> getAllPackages(){
        List<Package> packageList = packageService.getAllPackages(null);
        return packageList;
    }

    /**
     * create one Package
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package"},method = {RequestMethod.POST})
    public void insertPackage(@RequestBody Package package1){
        packageService.insertPackage(package1);
    }

    /**
     * get one  Package
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package/{packageId}"},method = {RequestMethod.GET})
    public Package getPackageById(@PathVariable long packageId){
        Package Package = packageService.getPackageById(packageId);
        return Package;
    }

    /***
     * update Package info
     * @param packageId
     */
    @ResponseBody
    @RequestMapping(value={"/package/{packageId}"},method = {RequestMethod.PUT})
    public void updatePackage(@PathVariable long packageId,
                           @RequestBody Package package1){
        if(package1.getPackageId()==0L){
            package1.setPackageId(packageId);
        }
        LOG.debug("package.getPackageId():"+package1.getPackageId());
        packageService.updatePackage(package1);
    }

    /***
     * delete Package info
     * @param packageId
     */
    @ResponseBody
    @RequestMapping(value={"/Package/{packageId}"},method = {RequestMethod.DELETE})
    public void deletePackage(@PathVariable long packageId){
        packageService.deletePackage(packageId);
    }
}

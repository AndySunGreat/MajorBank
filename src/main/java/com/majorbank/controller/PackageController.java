package com.majorbank.controller;

import com.majorbank.model.Order;
import com.majorbank.model.Package;
import com.majorbank.model.Package;
import com.majorbank.model.QuestBank;
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
     * list all Package[tested]
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package"},method = {RequestMethod.GET})
    public List<Package> getAllPackages(){
        List<Package> packageList2 = packageService.getAllPackages(null);
        return packageList2;
    }

    /**
     * create one Package[tested]
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package"},method = {RequestMethod.POST})
    public void insertPackage(@RequestBody Package package1){

        packageService.insertPackage(package1);
    }

    /**
     * get one  Package[tested]
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package/{packageId}"},method = {RequestMethod.GET})
    public Package getPackageById(@PathVariable long packageId){
        Package package1 = packageService.getPackageById(packageId);
        return package1;
    }

    /***
     * update Package info[tested]
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
     * delete Package info[tested]
     * @param packageId
     */
    @ResponseBody
    @RequestMapping(value={"/package/{packageId}"},method = {RequestMethod.DELETE})
    public void deletePackage(@PathVariable long packageId){

        packageService.deletePackage(packageId);
    }

    /**
     * 根据jobId读取与职业相映射的自动推荐的套餐[tested]
     * @param jobId
     */
    @ResponseBody
    @RequestMapping(value={"/package/{jobId}/auto"},method = {RequestMethod.GET})
    public List<Package> getAutoPackageByJobId(@PathVariable long jobId){
        List<Package> packageList1 = packageService.getAutoPackageByJobId(jobId);
        return packageList1;
    }

    /**
     * TODO: [Register] Get available banks based on userId and userGrade to generate customize package
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value={"/package/{userId}/banks"},method = {RequestMethod.GET})
    public List<QuestBank> getAvailableBanks(@PathVariable long userId){
        //packageService.getAvailableBanks(packageId);
        return null;
    }

    /**
     *TODO:[Register] Create customize package based on user customization
     * @param jobId
     */
    @ResponseBody
    @RequestMapping(value={"/package/{jobId}/custom"},method = {RequestMethod.GET})
    public void insertCustomPkgByUserId(@PathVariable long jobId,
                                        @RequestBody Package package1){
        //packageService.insertCustomPkgByUserId(packageId);
    }

}

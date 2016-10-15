package com.majorbank.controller;

import com.majorbank.model.Orders;
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
    @PostMapping("/package")
    public ResponseEntity insertPackage(@RequestBody Package package1){
        int insertResult = packageService.insertPackage(package1);
        if(insertResult>0){
            return new ResponseEntity("Insert package " + insertResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Insert package failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseEntity updatePackage(@PathVariable long packageId,
                           @RequestBody Package package1){
        if(package1.getPackageId()==0L){
            package1.setPackageId(packageId);
        }
        LOG.debug("package.getPackageId():"+package1.getPackageId());
        int updateResult = packageService.updatePackage(package1);
        if(updateResult>0){
            return new ResponseEntity("Update package " + updateResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Update package failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete Package info[tested]
     * @param packageId
     */
    @DeleteMapping("/package/{packageId}")
    public ResponseEntity deletePackage(@PathVariable long packageId){

        int deleteResult = packageService.deletePackage(packageId);
        if(deleteResult>0){
            return new ResponseEntity("Delete Package " + deleteResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Delete Package failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

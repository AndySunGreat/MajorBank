package com.majorbank.controller;

import com.majorbank.model.Banks;
import com.majorbank.model.Package;
import com.majorbank.service.BanksService;
import com.majorbank.service.PackageService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/login")
public class PackageController {
    private static final Logger LOG = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackageService packageService;

    @Autowired
    private BanksService banksService;

    /**
     * list all Package[tested]
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/package"},method = {RequestMethod.GET})
    public List<Package> getAllPackages(@RequestParam(required = false) String packageId,
                                        @RequestParam(required = false) String packageName,
                                        @RequestParam(required = false) String jobId,
                                        @RequestParam(required = false) String bankIdsJson){
        Package package1 = new Package();
        if(packageId!=null) {
            package1.setPackageId(Long.valueOf(packageId));
        }
        if(packageName!=null) {
            package1.setPackageName(packageName);
        }
        if(jobId!=null){
            package1.setJobId(Long.valueOf(jobId));
        }
        if(bankIdsJson!=null){
            package1.setBankIdsJson(bankIdsJson);
        }
        List<Package> packageList2 = packageService.getAllPackages(package1);
        String startdate = "2016-11-1";
        Date date = null;
        try {
            date = (new SimpleDateFormat("yyyy-MM-dd")).parse(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));
        Date currentDate = new Date();
        long diff = currentDate.getTime() - date.getTime();
        long diffDays = TimeUnit.MILLISECONDS.toDays(diff);

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
        JSONObject jsonObject = new JSONObject();
        if(insertResult>0){
            jsonObject.put("msg","Insert package " + insertResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Insert package failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
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
    @ResponseBody
    @RequestMapping(value={"/package/banksDetail/{packageId}"},method = {RequestMethod.GET})
    public List<Banks> getBanksDetailByPkgId(@PathVariable long packageId){
        Package package1 = packageService.getPackageById(packageId);
        String bankIdsJson = package1.getBankIdsJson();
        Banks banks = new Banks();
        if(bankIdsJson!=null && bankIdsJson!="") {
            String[] bankIdsArray = bankIdsJson.split(",");
            banks.setBankIds(bankIdsArray);
        }
        List<Banks> banksList = banksService.getAllBanks(banks);
        return banksList;
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
        JSONObject jsonObject = new JSONObject();
        if(updateResult>0){
            jsonObject.put("msg","Update package " + updateResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Update package failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete Package info[tested]
     * @param packageId
     */
    @DeleteMapping("/package/{packageId}")
    public ResponseEntity deletePackage(@PathVariable long packageId){

        int deleteResult = packageService.deletePackage(packageId);
        JSONObject jsonObject = new JSONObject();

        if(deleteResult>0){
            jsonObject.put("msg","Delete Package " + deleteResult+" Record successfully!");
            return new ResponseEntity(jsonObject,HttpStatus.OK);
        }else{
            jsonObject.put("msg","Delete Package failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
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
    public List<Banks> getAvailableBanks(@PathVariable long userId){
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

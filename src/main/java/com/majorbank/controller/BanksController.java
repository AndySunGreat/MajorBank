package com.majorbank.controller;

import com.majorbank.model.*;
import com.majorbank.service.BanksService;
import com.majorbank.service.JobsService;
import com.majorbank.service.OptionsService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/")
public class BanksController {
    private static final Logger LOG = LoggerFactory.getLogger(BanksController.class);

    @Autowired
    private BanksService questBankService;

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private JobsService jobsService;

    @ResponseBody
    @RequestMapping(value={"options/jobsOptions"},method = {RequestMethod.GET})
    public List<JobIndustryTypeOptions> getJobsLinkage(){
        List<Jobs> allJobsList = jobsService.getAllJobs(null);
        List<JobIndustryTypeOptions> jobIndustryTypeOptionsList = new ArrayList<JobIndustryTypeOptions>();
        List<JobGroupOptions> jobGroupOptionsList = new ArrayList<JobGroupOptions>();
        List<Jobs> jobsList = new ArrayList<Jobs>();
        Jobs jobs = new Jobs();
        Jobs josEntity = new Jobs();
        JobIndustryTypeOptions jobIndustryTypeOptions = new JobIndustryTypeOptions();
        JobGroupOptions jobGroupOptions = new JobGroupOptions();
        String previousIndustryType = "";
        String previousJobsGroup = "";
        Boolean newJobList = false;
        Boolean newJobGroupList = false;
        Boolean newIndustryType = false;
        Boolean newJobGroup = false;
        Boolean newJob = false;


        for(int i=0;i<allJobsList.size();i++){
            jobs = (Jobs)allJobsList.get(i);
            newJobList = false;
            newJobGroupList = false;
            newIndustryType = false;
            newJobGroup = false;
            newJob = false;
            // New Industry Type
            if(!previousIndustryType.equals(jobs.getIndustryType())){
                newIndustryType = true;
                jobIndustryTypeOptions = new JobIndustryTypeOptions();
                jobIndustryTypeOptions.setIndustryTypeValue(jobs.getIndustryType());
            }

            // New JobGroup
            if(   (!previousJobsGroup.equals(jobs.getJobGroup())
                    && previousIndustryType.equals(jobs.getIndustryType()))
                    || previousIndustryType==""){
                newJobGroup = true;
                if(previousIndustryType!="") {
                    jobGroupOptions.setJobsList(jobsList);
                    jobsList = new ArrayList<Jobs>();
                    jobGroupOptionsList.add(jobGroupOptions);
                }
                jobGroupOptions = new JobGroupOptions();
                jobGroupOptions.setJobGroup(jobs.getJobGroup());
            }

            // New Job
            if( (previousJobsGroup.equals(jobs.getJobGroup()) && previousIndustryType.equals(jobs.getIndustryType()))
                    || (previousIndustryType=="" && previousJobsGroup=="")){
                newJob = true;
                jobsList.add(jobs);
            }

            if(previousIndustryType!="") {
                if(newIndustryType || i==allJobsList.size()-1) {
                    jobGroupOptions = new JobGroupOptions();
                    jobGroupOptions.setJobGroup(jobs.getJobGroup());
                    jobGroupOptions.setJobsList(jobsList);
                    jobGroupOptionsList.add(jobGroupOptions);
                    jobIndustryTypeOptions.setJobGroupOptionsList(jobGroupOptionsList);
                    jobGroupOptionsList =  new ArrayList<JobGroupOptions>();
                    jobIndustryTypeOptionsList.add(jobIndustryTypeOptions);
                }
            }
            previousIndustryType = jobs.getIndustryType();
            previousJobsGroup = jobs.getJobGroup();
        }
        return jobIndustryTypeOptionsList;



/*        List<JobIndustryTypeOptions> jobIndustryTypeOptionsList = new ArrayList<JobIndustryTypeOptions>();
        JobIndustryTypeOptions jobIndustryTypeOptions = new JobIndustryTypeOptions();
        jobIndustryTypeOptions.setIndustryTypeValue("IT");
        jobIndustryTypeOptionsList.add(jobIndustryTypeOptions);

        List<Jobs> jobsList = new ArrayList<Jobs>();

        Jobs jobs = new Jobs();


        for(int i=0;i<jobIndustryTypeOptionsList.size();i++){
            jobIndustryTypeOptions = (JobIndustryTypeOptions)jobIndustryTypeOptionsList.get(i);
            // IT -> GlobalDev,GlobalTest
            jobGroupOptionsList = jobsService.getJobGroupOptionList(jobIndustryTypeOptions.getIndustryTypeValue());
            for(int j=0;j<jobGroupOptionsList.size();j++){
                jobGroupOptions = (JobGroupOptions)jobGroupOptionsList.get(j);
                // GlobalDev
                jobsList = jobsService.getJobsList(jobGroupOptions.getJobGroup());
                ((JobGroupOptions)jobGroupOptionsList.get(j)).setJobsList(jobsList);
            }
            ((JobIndustryTypeOptions)jobIndustryTypeOptionsList.get(i)).setJobGroupOptionsList(jobGroupOptionsList);
        }
        return jobIndustryTypeOptionsList;*/
    }


    @ResponseBody
    @RequestMapping(value={"options/industryOptions"},method = {RequestMethod.GET})
    public List<IndustryTypeOptions> getOptionsByParentValue(){
        List<OptionsMapping> industryTypeList = optionsService.getOptionsByParentValue("questions");
        List<OptionsMapping> bankCategoryList,bankTypeList;

        OptionsMapping industryTypeOptionsMapping,bankCategoryOptionsMapping,bankTypeOptionsMapping;

        IndustryTypeOptions industryTypeOptions = new IndustryTypeOptions();
        List<IndustryTypeOptions> industryTypeOptionsList = new ArrayList<IndustryTypeOptions>();
        BankCategoryOptions bankCategoryOptions;
        List<BankCategoryOptions> bankCategoryOptionsList;
        BankTypeOptions bankTypeOptions;
        List<BankTypeOptions> bankTypeOptionsList;
        Banks banks;
        List<Banks> banksList;
        for(int i=0;i<industryTypeList.size();i++){
            industryTypeOptions = new IndustryTypeOptions();
            industryTypeOptionsMapping = industryTypeList.get(i);
            industryTypeOptions.setId(String.valueOf(industryTypeOptionsMapping.getId()));
            industryTypeOptions.setKey(industryTypeOptionsMapping.getItemKey());
            industryTypeOptions.setValue(industryTypeOptionsMapping.getItemValue());
            bankCategoryOptionsList = new ArrayList<BankCategoryOptions>();
            bankCategoryList = optionsService.getOptionsByParentValue(industryTypeOptionsMapping.getItemValue());
            if(bankCategoryList!=null){
                for(int j=0;j<bankCategoryList.size();j++){
                    bankCategoryOptions = new BankCategoryOptions();
                    bankCategoryOptionsMapping = bankCategoryList.get(j);
                    bankCategoryOptions.setId(String.valueOf(bankCategoryOptionsMapping.getId()));
                    bankCategoryOptions.setKey(bankCategoryOptionsMapping.getItemKey());
                    bankCategoryOptions.setValue(bankCategoryOptionsMapping.getItemValue());
                    bankTypeOptionsList = new ArrayList<BankTypeOptions>();
                    bankTypeList =  optionsService.getOptionsByParentValue(bankCategoryOptionsMapping.getItemValue());
                    if(bankTypeList!=null){
                        for(int m=0;m<bankTypeList.size();m++){
                            bankTypeOptions = new BankTypeOptions();
                            bankTypeOptionsMapping = bankTypeList.get(m);
                            bankTypeOptions.setId(String.valueOf(bankTypeOptionsMapping.getId()));
                            bankTypeOptions.setKey(bankTypeOptionsMapping.getItemKey());
                            bankTypeOptions.setValue(bankTypeOptionsMapping.getItemValue());
                            banksList = new ArrayList<Banks>();
                            banks = new Banks();
                            banks.setIndustryType(industryTypeOptionsMapping.getItemValue());
                            banks.setQbCategory(bankCategoryOptionsMapping.getItemValue());
                            banks.setQbType(bankTypeOptionsMapping.getItemValue());
                            banksList = questBankService.getAllBanks(banks);
                            bankTypeOptions.setBanks(banksList);
                            bankTypeOptionsList.add(bankTypeOptions);
                        }
                    }
                    bankCategoryOptions.setTypes(bankTypeOptionsList);
                    bankCategoryOptionsList.add(bankCategoryOptions);
                }
            }

            industryTypeOptions.setCategories(bankCategoryOptionsList);
            industryTypeOptionsList.add(industryTypeOptions);
        }
        return industryTypeOptionsList;
    }

    /**
     * get one  Banks
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"options"},method = {RequestMethod.GET})
    public List<OptionsMapping> getAllOptions(@RequestBody OptionsMapping optionsMapping){
        List<OptionsMapping> optionsMappingList = optionsService.getAllOptions(optionsMapping);
        return optionsMappingList;
    }

    /**
     * list all Banks
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"banks"},method = {RequestMethod.GET})
    public List<Banks> getAllBanks(@RequestParam(required = false) String industryType,
                                   @RequestParam(required = false) String qbCategory,
                                   @RequestParam(required = false) String qbType,
                                   @RequestParam(required = false) String bankId,
                                   @RequestParam(required = false) String bankName,
                                   @RequestParam(required = false) String qbVersion,
                                   @RequestParam(required = false) String bankIds){
        Banks banks = new Banks();
        banks.setBankId(bankId==null?0:Long.valueOf(bankId));
        banks.setBankName(bankName);
        banks.setIndustryType(industryType);
        banks.setQbCategory(qbCategory);
        banks.setQbType(qbType);
        banks.setQbVersion(qbVersion);
        if(bankIds!=null) {
            String[] bankIdsArray = bankIds.split(",");
            banks.setBankIds(bankIdsArray);
        }
        List<Banks> banksList = questBankService.getAllBanks(banks);
        return banksList;
    }

    /**
     * create one Banks
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @PostMapping("banks")
    public ResponseEntity insertBank(@RequestBody Banks banks){
        int insertResult = questBankService.insertBank(banks);

        JSONObject jsonObject = new JSONObject();
        if(insertResult>0){
            jsonObject.put("msg","Insert bank " + insertResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Insert bank failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * get one  Banks
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"banks/{bankId}"},method = {RequestMethod.GET})
    public Banks getBankById(@PathVariable long bankId){
        Banks Banks = questBankService.getBankById(bankId);
        return Banks;
    }

    /***
     * update Banks info
     * @param bankId
     */
    @ResponseBody
    @RequestMapping(value={"banks/{bankId}"},method = {RequestMethod.PUT})
    public ResponseEntity updateBank(@PathVariable long bankId,
                           @RequestBody Banks questbank){
        if(questbank.getBankId()==0L){
            questbank.setBankId(bankId);
        }
        LOG.debug("package.getBankId():"+questbank.getBankId());
        int updateResult = questBankService.updateBank(questbank);
        JSONObject jsonObject = new JSONObject();
        if(updateResult>0){
            jsonObject.put("msg","Update banks " + updateResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Update banks failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete Banks info
     * @param bankId
     */
    @ResponseBody
    @RequestMapping(value={"banks/{bankId}"},method = {RequestMethod.DELETE})
    public ResponseEntity deleteBank(@PathVariable long bankId){
        int deleteResult = questBankService.deleteBank(bankId);
        JSONObject jsonObject = new JSONObject();
        if(deleteResult>0){
            jsonObject.put("msg","Delete bank " + deleteResult+" Record successfully!");
            return new ResponseEntity(jsonObject,HttpStatus.OK);
        }else{
            jsonObject.put("msg","Delete bank failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.majorbank.controller;

import com.majorbank.model.*;
import com.majorbank.service.BanksService;
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

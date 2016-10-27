package com.majorbank.controller;

import com.majorbank.model.Banks;
import com.majorbank.model.OptionsMapping;
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
    @RequestMapping(value={"options/{itemParentValue}"},method = {RequestMethod.GET})
    public List<OptionsMapping> getOptionsByParentValue(@PathVariable String itemParentValue){
        List<OptionsMapping>optionsMapping = optionsService.getOptionsByParentValue(itemParentValue);
        return optionsMapping;
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
    public List<Banks> getAllBanks(){
        List<Banks> banksList = questBankService.getAllBanks(null);
        return banksList;
    }

    /**
     * create one Banks
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @PostMapping("/banks")
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

package com.majorbank.controller;

import com.majorbank.model.QuestBank;
import com.majorbank.model.QuestBank;
import com.majorbank.service.QuestBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api/login")
public class QuestBankController {
    private static final Logger LOG = LoggerFactory.getLogger(QuestBankController.class);

    @Autowired
    private QuestBankService questBankService;

    /**
     * list all QuestBank
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/questBank"},method = {RequestMethod.GET})
    public List<QuestBank> getAllQuestBanks(){
        List<QuestBank> questBankList = questBankService.getAllQuestBanks(null);
        return questBankList;
    }

    /**
     * create one QuestBank
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/questBank"},method = {RequestMethod.POST})
    public void insertQuestBank(@RequestBody QuestBank questbank){
        questBankService.insertQuestBank(questbank);
    }

    /**
     * get one  QuestBank
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/questBank/{bankId}"},method = {RequestMethod.GET})
    public QuestBank getQuestBankById(@PathVariable long bankId){
        QuestBank QuestBank = questBankService.getQuestBankById(bankId);
        return QuestBank;
    }

    /***
     * update QuestBank info
     * @param bankId
     */
    @ResponseBody
    @RequestMapping(value={"/questBank/{bankId}"},method = {RequestMethod.PUT})
    public void updateQuestBank(@PathVariable long bankId,
                           @RequestBody QuestBank questbank){
        if(questbank.getBankId()==0L){
            questbank.setBankId(bankId);
        }
        LOG.debug("package.getQuestBankId():"+questbank.getBankId());
        questBankService.updateQuestBank(questbank);
    }

    /***
     * delete QuestBank info
     * @param bankId
     */
    @ResponseBody
    @RequestMapping(value={"/questBank/{bankId}"},method = {RequestMethod.DELETE})
    public void deleteQuestBank(@PathVariable long bankId){
        questBankService.deleteQuestBank(bankId);
    }
}

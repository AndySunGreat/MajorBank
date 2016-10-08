package com.majorbank.controller;

import com.majorbank.model.ITQuestion;
import com.majorbank.model.QuestBank;
import com.majorbank.service.ITQuestService;
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
@RequestMapping("/api/bank")
public class ITQuestController {
    private static final Logger LOG = LoggerFactory.getLogger(ITQuestController.class);

    @Autowired
    private ITQuestService itQuestService;

    /**
     * list all ITQuest
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/itquest"},method = {RequestMethod.GET})
    public List<ITQuestion> getAllITQuests(){
        List<ITQuestion> itquestList = itQuestService.getAllITQuestions(null);
        return itquestList;
    }

    /**
     * create one ITQuest
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/itquest"},method = {RequestMethod.POST})
    public void insertITQuest(@RequestBody ITQuestion itquest){
        itQuestService.insertITQuestion(itquest);
    }

    /**
     * get one  ITQuest
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/itquest/{questionId}"},method = {RequestMethod.GET})
    public ITQuestion getITQuestById(@PathVariable long questionId){
        ITQuestion itQuest = itQuestService.getITQuestionById(questionId);
        return itQuest;
    }

    /***
     * update ITQuest info
     * @param questionId
     */
    @ResponseBody
    @RequestMapping(value={"/itquest/{questionId}"},method = {RequestMethod.PUT})
    public void updateITQuest(@PathVariable long questionId,
                           @RequestBody ITQuestion itQuest){
        if(itQuest.getQuestionId()==0L){
            itQuest.setQuestionId(questionId);
        }
        LOG.debug("itQuest.getQuestionId():"+itQuest.getQuestionId());
        itQuestService.updateITQuestion(itQuest);
    }

    /***
     * delete ITQuest info
     * @param questionId
     */
    @ResponseBody
    @RequestMapping(value={"/itquest/{questionId}"},method = {RequestMethod.DELETE})
    public void deleteITQuest(@PathVariable long questionId){

        itQuestService.deleteITQuestion(questionId);
    }

}
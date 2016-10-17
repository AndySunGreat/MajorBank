package com.majorbank.controller;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.ITQuestion;
import com.majorbank.model.Orders;
import com.majorbank.model.QuestBank;
import com.majorbank.service.ITQuestService;
import com.majorbank.service.OrderService;
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
@RequestMapping("/api/bank")
public class ITQuestController {
    private static final Logger LOG = LoggerFactory.getLogger(ITQuestController.class);

    @Autowired
    private ITQuestService itQuestService;

    @Autowired
    private OrderService orderService;


    @ResponseBody
    @RequestMapping(value={"/answers/{answerId}"},method = {RequestMethod.GET})
    public BankAnswers getBankAnswersById(@PathVariable long answerId){
        BankAnswers bankAnswers = itQuestService.getBankAnswersById(answerId);
        return bankAnswers;
    }

    @ResponseBody
    @RequestMapping(value={"/answers/userId/{userId}"},method = {RequestMethod.GET})
    public List<BankAnswers> getBankAnswersByUserId(@PathVariable long userId){
        List<BankAnswers> bankAnswersList = itQuestService.getBankAnswersByUserId(userId);
        return bankAnswersList;
    }

    @ResponseBody
    @RequestMapping(value={"/answers"},method = {RequestMethod.POST})
    public BankAnswers insertAndGetAnswers(@RequestBody BankAnswers bankAnswers){
        return itQuestService.insertAndGetAnswers(bankAnswers);
    }

    /**
     * list all ITQuest
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/itquestions/all"},method = {RequestMethod.GET})
    public List<ITQuestion> getAllITQuests(){
        List<ITQuestion> itquestList = itQuestService.getAllITQuestions(null);
        return itquestList;
    }

    @ResponseBody
    @RequestMapping(value={"/itquest/bankid/{bankId}"},method = {RequestMethod.GET})
    public List<ITQuestion> getITQuestsByBankId(@PathVariable long bankId){
        ITQuestion itquest = new ITQuestion();
        itquest.setBankId(bankId);
        List<ITQuestion> itquestList = itQuestService.getAllITQuestions(itquest);
        return itquestList;
    }
    @ResponseBody
    @RequestMapping(value={"/itquest"},method = {RequestMethod.GET})
    public List<ITQuestion> getITQuestsByQuestionIds(@RequestParam("questionIds") String questionIds){
        ITQuestion itquest = new ITQuestion();
        String[] questionArray = questionIds.split(",");
        itquest.setQuestionIds(questionArray);
        List<ITQuestion> itquestList = itQuestService.getAllITQuestions(itquest);
        return itquestList;
    }

    /**
     * create one ITQuest
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @PostMapping("/itquest")
    public ResponseEntity insertITQuest(@RequestBody ITQuestion itquest){
        int insertResult = itQuestService.insertITQuestion(itquest);
        if(insertResult>0){
            return new ResponseEntity("Insert IT question " + insertResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Insert IT question failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * get one  ITQuest
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/itquest/questionid/{questionId}"},method = {RequestMethod.GET})
    public ITQuestion getITQuestById(@PathVariable long questionId){
        ITQuestion itQuest = itQuestService.getITQuestionById(questionId);
        return itQuest;
    }

    /***
     * update ITQuest info
     * @param questionId
     */
    @PutMapping("/itquest/{questionId}")
    public ResponseEntity updateITQuest(@PathVariable long questionId,
                           @RequestBody ITQuestion itQuest){
        if(itQuest.getQuestionId()==0L){
            itQuest.setQuestionId(questionId);
        }
        LOG.debug("itQuest.getQuestionId():"+itQuest.getQuestionId());
        int updateResult = itQuestService.updateITQuestion(itQuest);
        if(updateResult>0){
            return new ResponseEntity("Update IT question " + updateResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Update IT question failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete ITQuest info
     * @param questionId
     */
    @DeleteMapping("/itquest/{questionId}")
    public ResponseEntity deleteITQuest(@PathVariable long questionId){
        int deleteResult = itQuestService.deleteITQuestion(questionId);
        if(deleteResult>0){
            return new ResponseEntity("Delete IT question " + deleteResult+" Record successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity("Delete IT question failure!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

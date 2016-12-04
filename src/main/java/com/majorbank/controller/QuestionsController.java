package com.majorbank.controller;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.Banks;
import com.majorbank.model.Questions;
import com.majorbank.service.BanksService;
import com.majorbank.service.QuestionsService;
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
@RequestMapping("/api")
public class QuestionsController {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionsController.class);

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private BanksService banksService;

    @Autowired
    private OrderService orderService;

    /**
     * list all questions based on bank id
     * version: 2016.10.26
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/questions"},method = {RequestMethod.GET})
    public List<Questions> getAllQuestions(@RequestParam(required = false) String questionId,
                                           @RequestParam(required = false) String bankId,
                                           @RequestParam(required = false) String questContent,
                                           @RequestParam(required = false) String questType){
        Questions questions = new Questions();
        if(questionId!=null){
            questions.setQuestionId(Long.valueOf(questionId));
        }
        if(bankId!=null) {
            questions.setBankId(Long.valueOf(bankId));
        }
        if(questContent!=null){
            questions.setQuestContent(questContent);
        }
        if(questType!=null){
            questions.setQuestType(questType);
        }
        List<Questions> questionsList = questionsService.getAllQuestions(questions);
        for(int i=0;i<questionsList.size();i++){
            Banks banks = banksService.getBankById(((Questions)questionsList.get(i)).getBankId());
            ((Questions)questionsList.get(i)).setBankName(banks.getBankName());
        }
        return questionsList;
    }


    /**
     * list question details based on question id
     * version: 2016.10.26
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/questions/{questionId}"},method = {RequestMethod.GET})
    public Questions getQuestionDetailById(@PathVariable long questionId){
        Questions questions = new Questions();
        questions.setQuestionId(questionId);
        Questions questionsList = questionsService.getQuestionById(questionId);
        Banks banks = banksService.getBankById(questionsList.getBankId());
        questionsList.setBankName(banks.getBankName());
        return questionsList;
    }




    /**
     * retrieve questions by question ids array
     * version: 2016.10.26
     * @param questionIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/questions/qids"},method = {RequestMethod.GET})
    public List<Questions> getQuestionsByQuestIds(
            @RequestParam("questionIds") String questionIds){
        Questions itquest = new Questions();
        String[] questionArray = questionIds.split(",");
        itquest.setQuestionIds(questionArray);
        List<Questions> itquestList = questionsService.getAllQuestions(itquest);
        return itquestList;
    }


    /**
     * create one Quest
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @PostMapping("/questions")
    public ResponseEntity insertQuestions(@RequestBody Questions questions){
        int insertResult = questionsService.insertQuestions(questions);
        JSONObject jsonObject = new JSONObject();
        if(insertResult>0){
            jsonObject.put("msg","Insert question " + insertResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Insert question failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * update Quest info
     * @param questionId
     */
    @PutMapping("/questions/{questionId}")
    public ResponseEntity updateQuestions(@PathVariable long questionId,
                                        @RequestBody Questions questions){
        if(questions.getQuestionId()==0L){
            questions.setQuestionId(questionId);
        }
        LOG.debug("itQuest.getQuestionId():"+questions.getQuestionId());
        int updateResult = questionsService.updateQuestions(questions);
        JSONObject jsonObject = new JSONObject();
        if(updateResult>0){
            jsonObject.put("msg","Update question " + updateResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Update question failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete Quest info
     * @param questionId
     */
    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity deleteQuestions(
            @PathVariable long questionId){
        int deleteResult = questionsService.deleteQuestions(questionId);
        JSONObject jsonObject = new JSONObject();

        if(deleteResult>0){
            jsonObject.put("msg","Delete Question " + deleteResult+" Record successfully!");
            return new ResponseEntity(jsonObject,HttpStatus.OK);
        }else{
            jsonObject.put("msg","Delete Question failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    /*********************************/


    @ResponseBody
    @RequestMapping(value={"/answers/{answerId}"},method = {RequestMethod.GET})
    public BankAnswers getBankAnswersById(@PathVariable long answerId){
        BankAnswers bankAnswers = questionsService.getBankAnswersById(answerId);
        return bankAnswers;
    }

    @ResponseBody
    @RequestMapping(value={"/answers/userId/{userId}"},method = {RequestMethod.GET})
    public List<BankAnswers> getBankAnswersByUserId(@PathVariable long userId){
        List<BankAnswers> bankAnswersList = questionsService.getBankAnswersByUserId(userId);
        return bankAnswersList;
    }

    @ResponseBody
    @RequestMapping(value={"/answers"},method = {RequestMethod.POST})
    public BankAnswers insertAndGetAnswers(@RequestBody BankAnswers bankAnswers){
        return questionsService.insertAndGetAnswers(bankAnswers);
    }


/*    *//**
     * get one  Quest
     * @return
     *//*
    @ResponseBody
    @RequestMapping(value={"/itquest/questionid/{questionId}"},method = {RequestMethod.GET})
    public Questions getQuestById(@PathVariable long questionId){
        Questions itQuest = questionsService.getQuestionById(questionId);
        return itQuest;
    }*/

/*    @ResponseBody
    @RequestMapping(value={"/itquest/bankid/{bankId}"},method = {RequestMethod.GET})
    public List<Questions> getQuestsByBankId(@PathVariable long bankId){
        Questions itquest = new Questions();
        itquest.setBankId(bankId);
        List<Questions> itquestList = questionsService.getAllQuestions(itquest);
        return itquestList;
    }*/

/*
    */
/**
     * list all Quest
     * @return
     *//*

    @ResponseBody
    @RequestMapping(value={"/itquestions/all"},method = {RequestMethod.GET})
    public List<Questions> getAllQuests(){
        List<Questions> itquestList = questionsService.getAllQuestions(null);
        return itquestList;
    }
*/












}

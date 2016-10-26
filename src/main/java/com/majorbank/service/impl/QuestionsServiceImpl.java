package com.majorbank.service.impl;

import com.majorbank.common.CovertCodeUtil;
import com.majorbank.mapper.QuestionsMapper;
import com.majorbank.model.BankAnswers;
import com.majorbank.model.Questions;
import com.majorbank.model.Options;
import com.majorbank.service.QuestionsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("questionsService")
@Transactional
public class QuestionsServiceImpl implements QuestionsService {
    //private static final Logger LOG = LoggerFactory.getLogger(QuestionsServiceImpl.class);
    @Autowired
    private QuestionsMapper questionsMapper;

    @Override
    public List<Questions> getAllQuestionsByBankId(Questions questions){
        Questions question;
        List<Questions> questionsList = questionsMapper.getAllQuestions(questions);
        List<Options> optionsList;
        String strAnswerIndexes = "";
        for(int i = 0; i< questionsList.size(); i++){
            question = questionsList.get(i);
            optionsList = this.parseOptJsonToObject(question);
            strAnswerIndexes = CovertCodeUtil.getPositionBySeq(question.getCorrectAnswer());
            question.setCorrectIndexes(strAnswerIndexes);
            question.setQuestOptions(optionsList);
        }
        return questionsList;
    }

    @Override
    public Questions getQuestionById(long bankId,long questionId){
        Map map = new HashMap();
        map.put("bankId",bankId);
        map.put("questionId",questionId);
        Questions question = questionsMapper.getQuestionById(map);
        List<Options> optionsList = this.parseOptJsonToObject(question);
        question.setQuestOptions(optionsList);
        return question;
    }



    @Override
    public int insertQuestions(Questions questions){

        return questionsMapper.insertQuestions(questions);
    }

    @Override
    public int updateQuestions(Questions questions){
        return questionsMapper.updateQuestions(questions);
    }
    @Override
    public int deleteQuestions(long questionId){
        return  questionsMapper.deleteQuestions(questionId);
    }

    @Override
    public BankAnswers getBankAnswersById(long answerId){
        BankAnswers bankAnswers = questionsMapper.getBankAnswersById(answerId);
        return bankAnswers;
    }


    @Override
    public BankAnswers insertAndGetAnswers(BankAnswers bankAnswers) {
        BankAnswers bankAnswersRtn = new BankAnswers();
        questionsMapper.insertBankAnswersAndGetId(bankAnswers);
        return bankAnswers;
    }

    @Override
    public List<BankAnswers> getBankAnswersByUserId(long userId) {
        return null;
    }


    public List<Options> parseOptJsonToObject(Questions question){
        String strOptsJson = question.getQuestOptionsJson();
        String jsonItemStr = "";
        List<Options> optionsList = new ArrayList<Options>();
        Options options = new Options();
        JSONArray array = new JSONArray().fromObject(strOptsJson);
        JSONObject obj = new JSONObject();
        for(int i=0;i<array.size();i++){
            obj = array.getJSONObject(i);
            options = new Options();
            options.setOptSeq(obj.getString("optSeq"));
            options.setOptContent(obj.getString("optContent"));
            optionsList.add(options);
        }
        return optionsList;
    }

    
}

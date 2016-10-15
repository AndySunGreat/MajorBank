package com.majorbank.service.impl;

import com.majorbank.common.CovertCodeUtil;
import com.majorbank.mapper.ITQuestMapper;
import com.majorbank.model.BankAnswers;
import com.majorbank.model.ITQuestion;
import com.majorbank.model.Options;
import com.majorbank.service.ITQuestService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("itQuestService")
@Transactional
public class ITQuestServiceImpl implements ITQuestService {
    private static final Logger LOG = LoggerFactory.getLogger(ITQuestServiceImpl.class);
    @Autowired
    private ITQuestMapper itQuestMapper;

    @Override
    public List<BankAnswers> getBankAnswersByUserId(long userId) {
        return null;
    }

    @Override
    public BankAnswers insertAndGetAnswers(BankAnswers bankAnswers) {
        BankAnswers bankAnswersRtn = new BankAnswers();
        itQuestMapper.insertBankAnswersAndGetId(bankAnswers);
        return bankAnswers;
    }
    @Override
    public List<ITQuestion> getAllITQuestions(ITQuestion itquestion){
        ITQuestion question;
        List<ITQuestion> itQuestionList =  itQuestMapper.getAllITQuestions(itquestion);
        // 设置问题选项列表
        List<Options> optionsList;
        // 设置答案序号字符串
        String strAnswerIndexes = "";
        for(int i=0;i<itQuestionList.size();i++){
            question = (ITQuestion)itQuestionList.get(i);
            optionsList = this.parseOptJsonToObject(question);
            strAnswerIndexes = CovertCodeUtil.getPositionBySeq(question.getCorrectAnswer());
            question.setCorrectIndexes(strAnswerIndexes);
            question.setQuestOptions(optionsList);
        }

        return itQuestionList;
    }
    @Override
    public int insertITQuestion(ITQuestion itquestion){

        return itQuestMapper.insertITQuestion(itquestion);
    }

    @Override
    public ITQuestion getITQuestionById(long questionId){
        ITQuestion question = itQuestMapper.getITQuestionById(questionId);
        List<Options> optionsList = this.parseOptJsonToObject(question);
        question.setQuestOptions(optionsList);
        return question;
    }

    public List<Options> parseOptJsonToObject(ITQuestion question){
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
    @Override
    public int updateITQuestion(ITQuestion itquestion){
        return itQuestMapper.updateITQuestion(itquestion);
    }
    @Override
    public int deleteITQuestion(long questionId){
      return  itQuestMapper.deleteITQuestion(questionId);
    }
    
}

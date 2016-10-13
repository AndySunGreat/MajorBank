package com.majorbank.service.impl;

import com.majorbank.common.CovertCodeUtil;
import com.majorbank.mapper.ITQuestMapper;
import com.majorbank.model.ITQuestion;
import com.majorbank.model.Options;
import com.majorbank.service.ITQuestService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
    @Autowired
    private ITQuestMapper itQuestMapper;

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
    public void insertITQuestion(ITQuestion itquestion){
        itQuestMapper.insertITQuestion(itquestion);
    }

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

    public void updateITQuestion(ITQuestion itquestion){
        itQuestMapper.updateITQuestion(itquestion);
    }

    public void deleteITQuestion(long questionId){
        itQuestMapper.deleteITQuestion(questionId);
    }
    
}

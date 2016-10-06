package com.majorbank.service.impl;

import com.majorbank.mapper.ITQuestMapper;
import com.majorbank.model.ITQuestion;
import com.majorbank.service.ITQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return itQuestMapper.getAllITQuestions(itquestion);
    }
    public void insertITQuestion(ITQuestion itquestion){
        itQuestMapper.insertITQuestion(itquestion);
    }

    public ITQuestion getITQuestionById(long questionId){
        return itQuestMapper.getITQuestionById(questionId);
    }

    public void updateITQuestion(ITQuestion itquestion){
        itQuestMapper.updateITQuestion(itquestion);
    }

    public void deleteITQuestion(long questionId){
        itQuestMapper.deleteITQuestion(questionId);
    }
    
}

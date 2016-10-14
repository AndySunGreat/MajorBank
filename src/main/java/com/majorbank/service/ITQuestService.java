package com.majorbank.service;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.ITQuestion;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface ITQuestService {
    List<ITQuestion> getAllITQuestions(ITQuestion itQuestion);
    void insertITQuestion(ITQuestion itQuestion);
    ITQuestion getITQuestionById(long questionId);
    void updateITQuestion(ITQuestion itQuestion);
    void deleteITQuestion(long questionId);
    List<BankAnswers> getBankAnswersByUserId(long userId);
    BankAnswers insertAndGetAnswers(BankAnswers bankAnswers);
}

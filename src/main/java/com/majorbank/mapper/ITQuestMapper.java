package com.majorbank.mapper;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.ITQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface ITQuestMapper {
    List<ITQuestion> getAllITQuestions(ITQuestion itQuestion);
    void insertITQuestion(ITQuestion itQuestion);
    ITQuestion getITQuestionById(long questionId);
    void updateITQuestion(ITQuestion itQuestion);
    void deleteITQuestion(long questionId);
    Long insertBankAnswersAndGetId(BankAnswers bankAnswers);
}

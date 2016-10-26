package com.majorbank.service;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.Questions;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface QuestionsService {

    List<Questions> getAllQuestionsByBankId(Questions questions);

    Questions getQuestionById(long bankId, long questionId);


    int insertQuestions(Questions questions);

    int updateQuestions(Questions questions);

    int deleteQuestions(long questionId);

    List<BankAnswers> getBankAnswersByUserId(long userId);

    BankAnswers insertAndGetAnswers(BankAnswers bankAnswers);

    BankAnswers getBankAnswersById(long answerId);
}

package com.majorbank.mapper;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface QuestionsMapper {

    List<Questions> getAllQuestions(Questions questions);

    Questions getQuestionById(Map map);

    int insertQuestions(Questions questions);

    int updateQuestions(Questions questions);

    int deleteQuestions(long questionId);

    Long insertBankAnswersAndGetId(BankAnswers bankAnswers);
    BankAnswers getBankAnswersById(long answerId);
    List<BankAnswers> getAllBankAnswers(BankAnswers bankAnswers);
}

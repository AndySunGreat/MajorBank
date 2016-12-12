package com.majorbank.mapper;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.Positions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface PositionsMapper {

    List<Positions> getAllPositions(Positions positions);

    Positions getPositionById(Map map);

    int insertPositions(Positions positions);

    int updatePositions(Positions positions);

    int deletePositions(long positionId);

/*    Long insertBankAnswersAndGetId(BankAnswers bankAnswers);
    BankAnswers getBankAnswersById(long answerId);
    List<BankAnswers> getAllBankAnswers(BankAnswers bankAnswers);*/
}

package com.majorbank.service;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.Positions;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface PositionsService {

    List<Positions> getAllPositions(Positions questions);

    Positions getPositionById(long questionId);


    int insertPositions(Positions questions);

    int updatePositions(Positions questions);

    int deletePositions(long questionId);

}

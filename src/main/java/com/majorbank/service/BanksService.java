package com.majorbank.service;

import com.majorbank.model.Banks;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface BanksService {
    List<Banks> getAllBanks(Banks banks);
    int insertBank(Banks banks);
    Banks getBankById(long bankId);
    int updateBank(Banks banks);
    int deleteBank(long bankId);
}

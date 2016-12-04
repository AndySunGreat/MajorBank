package com.majorbank.service.impl;

import com.majorbank.mapper.BanksMapper;
import com.majorbank.model.Banks;
import com.majorbank.service.BanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("questBankService")
@Transactional
public class BanksServiceImpl implements BanksService {
    @Autowired
    private BanksMapper bankMapper;

    public List<Banks> getAllBanks(Banks banks){
        return bankMapper.getAllBanks(banks);
    }
    public int insertBank(Banks banks){
        return bankMapper.insertBank(banks);
    }

    public Banks getBankById(long bankId){
        return bankMapper.getBankById(bankId);
    }

    public int updateBank(Banks banks){
        return bankMapper.updateBank(banks);
    }

    public int deleteBank(long bankId){
        return bankMapper.deleteBank(bankId);
    }

}

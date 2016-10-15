package com.majorbank.service.impl;

import com.majorbank.mapper.QuestBankMapper;
import com.majorbank.model.QuestBank;
import com.majorbank.service.QuestBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("questBankService")
@Transactional
public class QuestBankServiceImpl implements QuestBankService{
    @Autowired
    private QuestBankMapper questbankMapper;

    public List<QuestBank> getAllQuestBanks(QuestBank questbank){
        return questbankMapper.getAllQuestBanks(questbank);
    }
    public int insertQuestBank(QuestBank questbank){
        return questbankMapper.insertQuestBank(questbank);
    }

    public QuestBank getQuestBankById(long bankId){
        return questbankMapper.getQuestBankById(bankId);
    }

    public int updateQuestBank(QuestBank questbank){
        return questbankMapper.updateQuestBank(questbank);
    }

    public int deleteQuestBank(long bankId){
        return questbankMapper.deleteQuestBank(bankId);
    }
    
}

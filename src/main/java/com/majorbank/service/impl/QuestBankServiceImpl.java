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
    public void insertQuestBank(QuestBank questbank){
        questbankMapper.insertQuestBank(questbank);
    }

    public QuestBank getQuestBankById(long bankId){
        return questbankMapper.getQuestBankById(bankId);
    }

    public void updateQuestBank(QuestBank questbank){
        questbankMapper.updateQuestBank(questbank);
    }

    public void deleteQuestBank(long bankId){
        questbankMapper.deleteQuestBank(bankId);
    }
    
}

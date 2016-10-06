package com.majorbank.service;

import com.majorbank.model.QuestBank;

import java.util.List;

/**
 * Created by AndySun on 2016/10/6.
 */
public interface QuestBankService {
    List<QuestBank> getAllQuestBanks(QuestBank questBank);
    void insertQuestBank(QuestBank questBank);
    QuestBank getQuestBankById(long bankId);
    void updateQuestBank(QuestBank questBank);
    void deleteQuestBank(long bankId);
}

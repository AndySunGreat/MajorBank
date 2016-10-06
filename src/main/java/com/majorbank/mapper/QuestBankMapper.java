package com.majorbank.mapper;

import com.majorbank.model.QuestBank;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface QuestBankMapper {
    List<QuestBank> getAllQuestBanks(QuestBank questBank);
    void insertQuestBank(QuestBank questBank);
    QuestBank getQuestBankById(long bankId);
    void updateQuestBank(QuestBank questBank);
    void deleteQuestBank(long bankId);
}

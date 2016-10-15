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
    int insertQuestBank(QuestBank questBank);
    QuestBank getQuestBankById(long bankId);
    int updateQuestBank(QuestBank questBank);
    int deleteQuestBank(long bankId);
}

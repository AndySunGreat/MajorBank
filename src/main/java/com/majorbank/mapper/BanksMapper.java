package com.majorbank.mapper;

import com.majorbank.model.Banks;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface BanksMapper {
    List<Banks> getAllBanks(Banks banks);
    int insertBank(Banks banks);
    Banks getBankById(long bankId);
    int updateBank(Banks banks);
    int deleteBank(long bankId);
}

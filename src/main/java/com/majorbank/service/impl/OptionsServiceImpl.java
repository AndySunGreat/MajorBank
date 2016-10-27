package com.majorbank.service.impl;

import com.majorbank.mapper.OptionsMapper;
import com.majorbank.model.OptionsMapping;
import com.majorbank.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AndySun on 2016/10/27.
 */
@Service("optionsService")
@Transactional
public class OptionsServiceImpl implements OptionsService {
    @Autowired
    private OptionsMapper optionsMapper;

    @Override
    public List<OptionsMapping> getOptionsByParentValue(String itemParentValue) {
        return optionsMapper.getOptionsByParentValue(itemParentValue);
    }

    @Override
    public List<OptionsMapping> getAllOptions(OptionsMapping optionsMapping) {
        return optionsMapper.getAllOptions(optionsMapping);
    }
}

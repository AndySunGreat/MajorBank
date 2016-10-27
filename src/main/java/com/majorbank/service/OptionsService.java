package com.majorbank.service;

import com.majorbank.model.OptionsMapping;

import java.util.List;

/**
 * Created by AndySun on 2016/10/27.
 */
public interface OptionsService {
    List<OptionsMapping> getOptionsByParentValue(String itemParentValue);
    List<OptionsMapping> getAllOptions(OptionsMapping optionsMapping);
}

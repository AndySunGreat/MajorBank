package com.majorbank.mapper;

import com.majorbank.model.Banks;
import com.majorbank.model.OptionsMapping;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndySun on 2016/10/2.
 */
@Repository
public interface OptionsMapper {
    List<OptionsMapping> getOptionsByParentValue(String itemParentValue);
    List<OptionsMapping> getAllOptions(OptionsMapping optionsMapping);
}

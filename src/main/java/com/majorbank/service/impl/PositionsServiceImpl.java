package com.majorbank.service.impl;

import com.majorbank.common.CovertCodeUtil;
import com.majorbank.mapper.PositionsMapper;
import com.majorbank.model.BankAnswers;
import com.majorbank.model.Options;
import com.majorbank.model.Positions;
import com.majorbank.model.PositionsOption;
import com.majorbank.service.PositionsService;
import com.majorbank.service.PositionsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AndySun on 2016/10/6.
 */
@Service("positionsService")
@Transactional
public class PositionsServiceImpl implements PositionsService {
    //private static final Logger LOG = LoggerFactory.getLogger(PositionsServiceImpl.class);
    @Autowired
    private PositionsMapper positionsMapper;

    @Override
    public List<Positions> getAllPositions(Positions positions){
        Positions position;
        List<Positions> positionsList = positionsMapper.getAllPositions(positions);
        List<PositionsOption> optionsList;
        for(int i = 0; i< positionsList.size(); i++){
            position = positionsList.get(i);
            optionsList = this.parseOptJsonToObject(position);
            position.setPositionsOptionList(optionsList);
        }
        return positionsList;
    }

    @Override
    public Positions getPositionById(long positionId){
        Map map = new HashMap();
        map.put("positionId",positionId);
        Positions position = positionsMapper.getPositionById(map);
        List<PositionsOption> optionsList = this.parseOptJsonToObject(position);
        position.setPositionsOptionList(optionsList);
        return position;
    }



    @Override
    public int insertPositions(Positions positions){

        return positionsMapper.insertPositions(positions);
    }

    @Override
    public int updatePositions(Positions positions){
        return positionsMapper.updatePositions(positions);
    }
    @Override
    public int deletePositions(long positionId){
        return  positionsMapper.deletePositions(positionId);
    }

    public List<PositionsOption> parseOptJsonToObject(Positions position){
        String strOptsJson = position.getRequiredJson();
        String jsonItemStr = "";
        List<PositionsOption> optionsList = new ArrayList<PositionsOption>();
        PositionsOption options = new PositionsOption();
        JSONArray array = new JSONArray().fromObject(strOptsJson);
        JSONObject obj = new JSONObject();
        for(int i=0;i<array.size();i++){
            obj = array.getJSONObject(i);
            options = new PositionsOption();
            options.setOptSeq(obj.getString("optSeq"));
            options.setOptContent(obj.getString("optContent"));
            options.setRequiredDegree(obj.getString("requiredDegree"));
            options.setRequiredItem(obj.getString("requiredItem"));
            options.setRequiredValue(obj.getString("requiredValue"));
            optionsList.add(options);
        }
        return optionsList;
    }

    
}

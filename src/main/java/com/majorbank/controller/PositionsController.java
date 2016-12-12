package com.majorbank.controller;

import com.majorbank.model.BankAnswers;
import com.majorbank.model.Banks;
import com.majorbank.model.Positions;
import com.majorbank.service.BanksService;
import com.majorbank.service.OrderService;
import com.majorbank.service.PositionsService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AndySun on 2016/10/3.
 */
@Controller
@RequestMapping("/api")
public class PositionsController {
    private static final Logger LOG = LoggerFactory.getLogger(PositionsController.class);

    @Autowired
    private PositionsService positionsService;

    @Autowired
    private BanksService banksService;

    @Autowired
    private OrderService orderService;

    /**
     * list all positions based on bank id
     * version: 2016.10.26
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/positions"},method = {RequestMethod.GET})
    public List<Positions> getAllPositions(@RequestParam(required = false) String positionId,
                                           @RequestParam(required = false) String positionName,
                                           @RequestParam(required = false) String salary,
                                           @RequestParam(required = false) String experience,
                                           @RequestParam(required = false) String city,
                                           @RequestParam(required = false) String companyId
                                           ){
        Positions positions = new Positions();
        if(positionId!=null){
            positions.setPositionId(Long.valueOf(positionId));
        }
        if(positionName!=null){
            positions.setPositionName(positionName);
        }
        if(salary!=null){
            positions.setSalary(salary);
        }
        if(experience!=null){
            positions.setExperience(Long.valueOf(experience));
        }
        if(city!=null){
            positions.setCity(city);
        }
        if(companyId!=null){
            positions.setCompanyId(Long.valueOf(companyId));
        }
        List<Positions> positionsList = positionsService.getAllPositions(positions);
/*        for(int i=0;i<positionsList.size();i++){
            Banks banks = banksService.getBankById(((Positions)positionsList.get(i)).getBankId());
            ((Positions)positionsList.get(i)).setBankName(banks.getBankName());
        }*/
        return positionsList;
    }


    /**
     * list question details based on question id
     * version: 2016.10.26
     * @return
     */
    @ResponseBody
    @RequestMapping(value={"/positions/{positionId}"},method = {RequestMethod.GET})
    public Positions getPositionDetailById(@PathVariable long positionId){
        Positions positions = new Positions();
        positions.setPositionId(positionId);
        Positions positionsList = positionsService.getPositionById(positionId);
        //Banks banks = banksService.getBankById(positionsList.getBankId());
        //positionsList.setBankName(banks.getBankName());
        return positionsList;
    }




 /*   *//**
     * retrieve positions by question ids array
     * version: 2016.10.26
     * @param positionIds
     * @return
     *//*
    @ResponseBody
    @RequestMapping(value={"/positions/qids"},method = {RequestMethod.GET})
    public List<Positions> getPositionsByQuestIds(
            @RequestParam("positionIds") String positionIds){
        Positions itquest = new Positions();
        String[] questionArray = positionIds.split(",");
        itquest.setPositionIds(questionArray);
        List<Positions> itquestList = positionsService.getAllPositions(itquest);
        return itquestList;
    }
*/

    /**
     * create one Positions
     * ps: Content-Type要用application/json,Body选raw写入json才可以
     * @return
     */
    @PostMapping("/positions")
    public ResponseEntity insertPositions(@RequestBody Positions positions){
        int insertResult = positionsService.insertPositions(positions);
        JSONObject jsonObject = new JSONObject();
        if(insertResult>0){
            jsonObject.put("msg","Insert positions " + insertResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Insert positions failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * update Quest info
     * @param positionId
     */
    @PutMapping("/positions/{positionId}")
    public ResponseEntity updatePositions(@PathVariable long positionId,
                                        @RequestBody Positions positions){
        if(positions.getPositionId()==0L){
            positions.setPositionId(positionId);
        }
        LOG.debug("itQuest.getPositionId():"+positions.getPositionId());
        int updateResult = positionsService.updatePositions(positions);
        JSONObject jsonObject = new JSONObject();
        if(updateResult>0){
            jsonObject.put("msg","Update question " + updateResult+" Record successfully!");
            return new ResponseEntity(jsonObject, HttpStatus.OK);
        }else{
            jsonObject.put("msg","Update question failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * delete Quest info
     * @param positionId
     */
    @DeleteMapping("/positions/{positionId}")
    public ResponseEntity deletePositions(
            @PathVariable long positionId){
        int deleteResult = positionsService.deletePositions(positionId);
        JSONObject jsonObject = new JSONObject();

        if(deleteResult>0){
            jsonObject.put("msg","Delete Position " + deleteResult+" Record successfully!");
            return new ResponseEntity(jsonObject,HttpStatus.OK);
        }else{
            jsonObject.put("msg","Delete Position failure!");
            return new ResponseEntity(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

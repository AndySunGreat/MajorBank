package com.majorbank.model;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndySun on 2016/10/5.
 * Industry Type: IT行业; 每个行业会对应有一张题库表
 */
public class Questions implements Serializable {
    private long questionId;
    private long bankId;
    private String bankName;
    private String questContent; // 问题内容
    private String questType; // 问题类型 1-单选  2-多选  3-判断  4-问答(暂不支持)
    private String questOptionsJson; // 问题选项JSON
    private List<Options> questOptions; // 问题选项
    private String correctAnswer; // 正确答案
    private Date changeDate;
    private String correctIndexes; // 正确答案序列号
    private String[] questionIds;

    public Questions() {
    }

    public Questions(long questionId, long bankId, String questContent,
                     String questType, String questOptionsJson, List<Options> questOptions,
                     String correctAnswer, Date changeDate) {
        this.questionId = questionId;
        this.bankId = bankId;
        this.questContent = questContent;
        this.questType = questType;
        this.questOptionsJson = questOptionsJson;
        this.questOptions = questOptions;
        this.correctAnswer = correctAnswer;
        this.changeDate = changeDate;
    }

    public Questions(long questionId, long bankId, String questContent, String questType,
                     String questOptionsJson, List<Options> questOptions,
                     String correctAnswer, Date changeDate, String correctIndexes) {
        this.questionId = questionId;
        this.bankId = bankId;
        this.questContent = questContent;
        this.questType = questType;
        this.questOptionsJson = questOptionsJson;
        this.questOptions = questOptions;
        this.correctAnswer = correctAnswer;
        this.changeDate = changeDate;
        this.correctIndexes = correctIndexes;
    }

    public Questions(long questionId, long bankId, String questContent,
                     String questType, String questOptionsJson,
                     List<Options> questOptions, String correctAnswer,
                     Date changeDate, String correctIndexes, String[] questionIds) {
        this.questionId = questionId;
        this.bankId = bankId;
        this.questContent = questContent;
        this.questType = questType;
        this.questOptionsJson = questOptionsJson;
        this.questOptions = questOptions;
        this.correctAnswer = correctAnswer;
        this.changeDate = changeDate;
        this.correctIndexes = correctIndexes;
        this.questionIds = questionIds;
    }

    public Questions(long questionId, long bankId, String bankName,
                     String questContent, String questType, String questOptionsJson,
                     List<Options> questOptions,
                     String correctAnswer, Date changeDate, String correctIndexes,
                     String[] questionIds) {
        this.questionId = questionId;
        this.bankId = bankId;
        this.bankName = bankName;
        this.questContent = questContent;
        this.questType = questType;
        this.questOptionsJson = questOptionsJson;
        this.questOptions = questOptions;
        this.correctAnswer = correctAnswer;
        this.changeDate = changeDate;
        this.correctIndexes = correctIndexes;
        this.questionIds = questionIds;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String[] getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String[] questionIds) {
        this.questionIds = questionIds;
    }

    public String getCorrectIndexes() {
        return correctIndexes;
    }

    public void setCorrectIndexes(String correctIndexes) {
        this.correctIndexes = correctIndexes;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getQuestOptionsJson() {
        return questOptionsJson;
    }

    public void setQuestOptionsJson(String questOptionsJson) {
        this.questOptionsJson = questOptionsJson;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getQuestContent() {
        return questContent;
    }

    public void setQuestContent(String questContent) {
        this.questContent = questContent;
    }

    public String getQuestType() {
        return questType;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }

    public List<Options> getQuestOptions() {

        return questOptions;
    }

    public void setQuestOptions(List<Options> questOptions) {
        this.questOptions = questOptions;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

package com.majorbank.model;

import java.util.Date;

/**
 * Created by AndySun on 2016/10/6.
 */
public class BankAnswers {
    private long answerId;
    private long orderId;
    private float score;
    private String wrongQuestIds;
    private Date createDate;
    private long bankId;

    public BankAnswers() {
    }

    public BankAnswers(long answerId, long orderId, float score, String wrongQuestIds, Date createDate,long bankId) {
        this.answerId = answerId;
        this.orderId = orderId;
        this.score = score;
        this.wrongQuestIds = wrongQuestIds;
        this.createDate = createDate;
        this.bankId = bankId;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }


    public String getWrongQuestIds() {
        return wrongQuestIds;
    }

    public void setWrongQuestIds(String wrongQuestIds) {
        this.wrongQuestIds = wrongQuestIds;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

package com.majorbank.model;

import java.util.Date;

/**
 * Created by AndySun on 2016/10/6.
 */
public class BankAnswers {
    private long answerId;
    private long orderId;
    private long score;
    private String wrongQuestIds;
    private Date createDate;

    public BankAnswers() {
    }

    public BankAnswers(long answerId, long orderId, long score, String wrongQuestIds, Date createDate) {
        this.answerId = answerId;
        this.orderId = orderId;
        this.score = score;
        this.wrongQuestIds = wrongQuestIds;
        this.createDate = createDate;
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

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
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

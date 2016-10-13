package com.majorbank.model;

import java.io.Serializable;

/**
 * Created by AndySun on 2016/10/5.
 */
public class Options implements Serializable {
    private String optSeq; // A,B
    private String optContent;

    public Options() {
    }

    public Options(String optSeq, String optContent) {
        this.optSeq = optSeq;
        this.optContent = optContent;
    }


    public String getOptSeq() {
        return optSeq;
    }

    public void setOptSeq(String optSeq) {
        this.optSeq = optSeq;
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }
}

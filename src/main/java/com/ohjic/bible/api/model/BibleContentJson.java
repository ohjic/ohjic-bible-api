package com.ohjic.bible.api.model;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 22..
 */
public class BibleContentJson {
    private String status;
    private String msg;
    private List<BibleContent> bibleContentModelList;

    public BibleContentJson(String status, String msg, List<BibleContent> bibleContentModelList) {
        this.status = status;
        this.msg = msg;
        this.bibleContentModelList = bibleContentModelList;
    }

    public BibleContentJson(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<BibleContent> getBibleContentModelList() {
        return bibleContentModelList;
    }

    public void setBibleContentModelList(List<BibleContent> bibleContentModelList) {
        this.bibleContentModelList = bibleContentModelList;
    }
}

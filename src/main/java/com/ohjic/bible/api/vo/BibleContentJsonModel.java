package com.ohjic.bible.api.vo;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 22..
 */
public class BibleContentJsonModel {
    private String status;
    private String msg;
    private List<BibleContentModel> bibleContentModelList;

    public BibleContentJsonModel(String status, String msg, List<BibleContentModel> bibleContentModelList) {
        this.status = status;
        this.msg = msg;
        this.bibleContentModelList = bibleContentModelList;
    }

    public BibleContentJsonModel(String status, String msg) {
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

    public List<BibleContentModel> getBibleContentModelList() {
        return bibleContentModelList;
    }

    public void setBibleContentModelList(List<BibleContentModel> bibleContentModelList) {
        this.bibleContentModelList = bibleContentModelList;
    }
}

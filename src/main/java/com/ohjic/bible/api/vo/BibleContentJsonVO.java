package com.ohjic.bible.api.vo;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 22..
 */
public class BibleContentJsonVO {
    private String status;
    private String msg;
    private List<BibleContentVO> bibleContentVOList;

    public BibleContentJsonVO(String status, String msg, List<BibleContentVO> bibleContentVOList) {
        this.status = status;
        this.msg = msg;
        this.bibleContentVOList = bibleContentVOList;
    }

    public BibleContentJsonVO(String status, String msg) {
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

    public List<BibleContentVO> getBibleContentVOList() {
        return bibleContentVOList;
    }

    public void setBibleContentVOList(List<BibleContentVO> bibleContentVOList) {
        this.bibleContentVOList = bibleContentVOList;
    }
}

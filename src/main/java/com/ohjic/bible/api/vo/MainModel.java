package com.ohjic.bible.api.vo;

import java.util.Date;

/**
 * Created by hwangseong-in on 2017. 2. 21..
 */
public class MainModel {
    private int article_id;
    private int group_id;
    private String multiboard_no;
    private Date posting_date;
    private int read_count;
    private int reply_count;
    private String writer_name;
    private String title;
    private String content;
    private String sequence_no;
    private String path;
    private String R_path;



    public String getR_path() {
        return R_path;
    }
    public void setR_path(String r_path) {
        R_path = r_path;
    }
    public void setMultiboard_no(String multiboard_no) {
        this.multiboard_no = multiboard_no;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSequence_no() {
        return sequence_no;
    }
    public void setSequence_no(String sequence_no) {
        this.sequence_no = sequence_no;
    }
    public int getArticle_id() {
        return article_id;
    }
    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }
    public int getGroup_id() {
        return group_id;
    }
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }


    public String getMultiboard_no() {
        return multiboard_no;
    }
    public void setMultiboard_id(String multiboard_no) {
        this.multiboard_no = multiboard_no;
    }
    public Date getPosting_date() {
        return posting_date;
    }
    public void setPosting_date(Date posting_date) {
        this.posting_date = posting_date;
    }
    public int getRead_count() {
        return read_count;
    }
    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }
    public int getReply_count() {
        return reply_count;
    }
    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }
    public String getWriter_name() {
        return writer_name;
    }
    public void setWriter_name(String writer_name) {
        this.writer_name = writer_name;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}

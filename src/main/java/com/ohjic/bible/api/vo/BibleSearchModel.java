package com.ohjic.bible.api.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by hwangseong-in on 2017. 3. 14..
 */
/* 성경 검색 용 VO*/
public class BibleSearchModel {

    /*성격 종류 키*/
    private int bibleIdx;
    /*성경 책 종류 키*/
    private int bookKindIdx;
    /*성경 책 이름*/
    private String bookName;
    /*장*/
    private int chapter;
    /*절*/
    private int paragraph;
    /*절 내용*/
    private String paragraphValue;
    /*절 범위 검색용 시작 값 */
    private int firstChapter;
    /*절 범위 검색용 마지막 값*/
    private int lastChapter;
    /*절 범위 검색용 시작 값 */
    private int firstParagraph;
    /*절 범위 검색용 마지막 값*/
    private int lastParagraph;
    /* 장 절 검색 여부 플래그 */
    private String searchRange;
    private int startLimit;
    private int endLimit;

    public BibleSearchModel() {}


    public BibleSearchModel(int bibleIdx, int bookKindIdx, String bookName, int chapter, int paragraph, String paragraphValue, int firstChapter, int lastChapter, int firstParagraph, int lastParagraph, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookKindIdx = bookKindIdx;
        this.bookName = bookName;
        this.chapter = chapter;
        this.paragraph = paragraph;
        this.paragraphValue = paragraphValue;
        this.firstChapter = firstChapter;
        this.lastChapter = lastChapter;
        this.firstParagraph = firstParagraph;
        this.lastParagraph = lastParagraph;
        this.searchRange = searchRange;
    }

    public BibleSearchModel(int bibleIdx, int bookKindIdx, int chapter, int firstParagraph, int lastParagraph, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookKindIdx = bookKindIdx;
        this.chapter = chapter;
        this.firstParagraph = firstParagraph;
        this.lastParagraph = lastParagraph;
        this.searchRange = searchRange;
    }

    public BibleSearchModel(int bibleIdx, int bookKindIdx, int firstChapter, int lastChapter, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookKindIdx = bookKindIdx;
        this.firstChapter = firstChapter;
        this.lastChapter = lastChapter;
        this.searchRange = searchRange;
    }

    public BibleSearchModel(int bibleIdx, String bookName, int chapter, int firstParagraph, int lastParagraph, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookName = bookName;
        this.chapter = chapter;
        this.firstParagraph = firstParagraph;
        this.lastParagraph = lastParagraph;
        this.searchRange = searchRange;
    }

    public BibleSearchModel(int bibleIdx, String bookName, int chapter, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookName = bookName;
        this.chapter = chapter;
        this.searchRange = searchRange;
    }

    public BibleSearchModel(int bibleIdx, String paragraphValue, int startLimit, int endLimit) {
        this.bibleIdx = bibleIdx;
        this.paragraphValue = paragraphValue;
        this.startLimit = startLimit;
        this.endLimit = endLimit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(
                this,
                ToStringStyle.MULTI_LINE_STYLE);

    }

    public int getBibleIdx() {
        return bibleIdx;
    }

    public void setBibleIdx(int bibleIdx) {
        this.bibleIdx = bibleIdx;
    }

    public int getBookKindIdx() {
        return bookKindIdx;
    }

    public void setBookKindIdx(int bookKindIdx) {
        this.bookKindIdx = bookKindIdx;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getParagraph() {
        return paragraph;
    }

    public void setParagraph(int paragraph) {
        this.paragraph = paragraph;
    }

    public int getFirstChapter() {
        return firstChapter;
    }

    public void setFirstChapter(int firstChapter) {
        this.firstChapter = firstChapter;
    }

    public int getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(int lastChapter) {
        this.lastChapter = lastChapter;
    }

    public int getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(int firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public int getLastParagraph() {
        return lastParagraph;
    }

    public void setLastParagraph(int lastParagraph) {
        this.lastParagraph = lastParagraph;
    }

    public String getsearchRange() {
        return searchRange;
    }

    public void setsearchRange(String searchRange) {
        this.searchRange = searchRange;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getParagraphValue() {
        return paragraphValue;
    }

    public void setParagraphValue(String paragraphValue) {
        this.paragraphValue = paragraphValue;
    }

    public int getEndLimit() {
        return endLimit;
    }

    public void setEndLimit(int endLimit) {
        this.endLimit = endLimit;
    }

    public int getStartLimit() {
        return startLimit;
    }

    public void setStartLimit(int startLimit) {
        this.startLimit = startLimit;
    }
}

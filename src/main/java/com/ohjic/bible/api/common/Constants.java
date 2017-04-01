package com.ohjic.bible.api.common;

/**
 * Created by hwangseong-in on 2017. 4. 1..
 */
public class Constants {

    /*책 ~ 장 ~ 절 검사 */
    public static final int BOOK_SEARCH_FOR_CHAPTER_AND_PARAGRAPH = 3;
    /*책 ~ 장  검사 */
    public static final int BOOK_SEARCH_FOR_CHAPTER = 2;
    /* 절 의 범위검색 */
    public static final int FIND_RANGE_PARAGRAPH = 2;
    /* 절 한개 검색*/
    public static final int FIND_ONE_PARAGRAPH = 1;
    /* 문장형 검색 정규표현식*/
    public static final String SENTENCE_SEARCH_REGEXP = "[^0-9~-]";
    /*검색 실패 없음*/
    public static final String FAIL_SEARCH_MSG = "해당 검색결과에 해당하는 문장이 없습니다.";
    /* 검색결과 성공이나 결과값없음*/
    public static final String EMPTY_SEARCH_MSG = "값이 존재하지 않습니다.";/* 검색결과 성공*/
    /* 검색결과 성공*/
    public static final String SUCCESS_SEARCH_MSG = "검색에 성공하였습니다.";
    /* 페이지 당 나타낼 리스트 수*/
    public static final int PAGE_MAX_LIMIT = 20;

}

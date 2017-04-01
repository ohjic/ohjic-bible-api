package com.ohjic.bible.api.service.impl;

import com.ohjic.bible.api.service.BibleSearchService;
import com.ohjic.bible.api.util.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.bible.api.model.BibleSearchDao;
import com.ohjic.bible.api.vo.BibleContentJsonModel;
import com.ohjic.bible.api.vo.BibleContentModel;
import com.ohjic.bible.api.vo.BibleSearchModel;
import com.ohjic.bible.api.common.Constants;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@Service(value = "bibleSearchService")
public class BibleSearchServiceImpl implements BibleSearchService {

    @Autowired
    private BibleSearchDao bibleSearchDao;

    @Override
    public List<BibleContentModel> getChapterContents(BibleSearchModel bibleSearchModel) {
        return bibleSearchDao.selectBibleContents("getBible.bibleContents", bibleSearchModel);
    }

    @Override
    public List<BibleContentModel> getParagraphContents(BibleSearchModel bibleSearchModel) {
        return bibleSearchDao.selectBibleContents("getBible.bibleContents", bibleSearchModel);
    }

    @Override
    public List<BibleContentModel> getParagraphContentsForSentence(int bibleIdx, String searchSentence) {

        String[] sentenceSearchValue = null;
        List<BibleContentModel> bibleContentModelList = null;

        sentenceSearchValue = StringUtility.sentenceReplaceAndSplit(searchSentence,":"," "," ");

        if(sentenceSearchValue.length >=Constants.BOOK_SEARCH_FOR_CHAPTER_AND_PARAGRAPH) {
            bibleContentModelList = this.getChapterAndParagraphForSentenceSearch(bibleIdx,sentenceSearchValue);
        }else if(sentenceSearchValue.length == Constants.BOOK_SEARCH_FOR_CHAPTER) {
            bibleContentModelList = this.getChapterForSentenceSearch(bibleIdx,sentenceSearchValue);
        }

        return bibleContentModelList;
    }

    @Override
    public List<BibleContentModel> getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue, int limit) {
        BibleContentJsonModel bibleContentJsonModel = null;
        BibleSearchModel bibleSearchModel = null;

        bibleSearchModel = new BibleSearchModel(bibleIdx,paragraphValue,limit, limit + Constants.PAGE_MAX_LIMIT);

        return bibleSearchDao.selectBibleContents("getBible.getBibleParagraphValueSearch", bibleSearchModel);
    }


    @Override
    public List<BibleContentModel> getTodayParagraphValue(int bibleIdx) {
        BibleSearchModel bibleSearchModel = null;
        int todayParagraphCount = 0;

        todayParagraphCount = bibleSearchDao.selectTodayParagraphCount("getBible.selectTodayParagraphCount");

        if(todayParagraphCount <= 0){
            bibleSearchDao.InsertTodayParagraph("getBible.insertTodayParagraphKey");
        }

        bibleSearchModel = bibleSearchDao.selectBibleSearchKey("getBible.selectTodayParagraphKey");
        bibleSearchModel.setBibleIdx(bibleIdx);
        bibleSearchModel.setsearchRange("oneParagraph");
        return bibleSearchDao.selectBibleContents("getBible.bibleContents", bibleSearchModel);
    }

    @Override
    public void registTodayParagraphValue() {

    }

    @Override
    public List<BibleContentModel> getChapterAndParagraphForSentenceSearch(int bibleIdx, String[] sentenceSearchValue){

        String bookName = sentenceSearchValue[0];
        String chapter = sentenceSearchValue[1].replaceAll(Constants.SENTENCE_SEARCH_REGEXP,"");
        String paragraph = sentenceSearchValue[2].replaceAll(Constants.SENTENCE_SEARCH_REGEXP,"");
        String firstParagraph = "";
        String lastParagraph = "";
        List<BibleContentModel> bibleContentModelList = null;

        if(!(chapter.equals("") || paragraph.equals(""))){
            String[] paragraphList = null;
            paragraphList = StringUtility.sentenceReplaceAndSplit(paragraph,"~","-","-");
                /*절의 구간 검색 여부 체킹*/
            if(paragraphList.length >= Constants.FIND_RANGE_PARAGRAPH){
                 firstParagraph = paragraphList[0];
                 lastParagraph = paragraphList[1];
            }else if(paragraphList.length == Constants.FIND_ONE_PARAGRAPH){
                firstParagraph = lastParagraph = paragraphList[0];
            }else{
                firstParagraph = lastParagraph = "";
            }

            BibleSearchModel bibleSearchModel = new BibleSearchModel(bibleIdx,bookName,Integer.parseInt(chapter),Integer.parseInt(firstParagraph),Integer.parseInt(lastParagraph),"paragraph");
            bibleContentModelList = bibleSearchDao.selectBibleContents("getBible.getbibleSentenceSearch", bibleSearchModel);
        }

        return bibleContentModelList;
    }

    @Override
    public List<BibleContentModel> getChapterForSentenceSearch(int bibleIdx, String[] sentenceSearchValue){
        String bookName = sentenceSearchValue[0];
        String chapter = sentenceSearchValue[1].replaceAll(Constants.SENTENCE_SEARCH_REGEXP,"");

        BibleSearchModel bibleSearchModel = new BibleSearchModel(bibleIdx,bookName,Integer.parseInt(chapter),"chapter");

        return bibleSearchDao.selectBibleContents("getBible.getbibleSentenceSearch", bibleSearchModel);
    }


}

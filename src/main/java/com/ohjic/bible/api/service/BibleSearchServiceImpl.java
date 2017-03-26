package com.ohjic.bible.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.bible.api.model.BibleSearchDao;
import com.ohjic.bible.api.vo.BibleContentJsonModel;
import com.ohjic.bible.api.vo.BibleContentModel;
import com.ohjic.bible.api.vo.BibleSearchModel;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@Service(value = "bibleSearchService")
public class BibleSearchServiceImpl implements BibleSearchService{

    @Autowired
    private BibleSearchDao bibleSearchDao;

    @Override
    public List<BibleContentModel> getChapterContents(BibleSearchModel bibleSearchModel) {
        List<BibleContentModel> chapterContents = bibleSearchDao.selectBibleContents("getBible.bibleContents", bibleSearchModel);
        return chapterContents;
    }

    @Override
    public List<BibleContentModel> getParagraphContents(BibleSearchModel bibleSearchModel) {
        List<BibleContentModel> paragraphContents = bibleSearchDao.selectBibleContents("getBible.bibleContents", bibleSearchModel);
        return paragraphContents;
    }

    @Override
    public BibleContentJsonModel getParagraphContentsForSentence(int bibleIdx, String searchSentence) {

        String bookName = "";
        String chapter = "";
        String paragraph = "";
        String firstParagraph = "";
        String lastParagraph = "";
        String regExp = "[^0-9~-]";
        String[] paragraphList = null;
        BibleSearchModel bibleSearchModel = null;
        BibleContentJsonModel bibleContentJsonModel = null;
        List<BibleContentModel> bibleContentModelList = null;

        String[] splitValue = this.sentenceReplaceAndSplit(searchSentence,":"," "," ");

           /* length >=3 => 책 장 절 검사 , length ==2 => 책 장 검사 , 그외 검색 불능 */
        if(splitValue.length >=3){
            bookName = splitValue[0];
            chapter = splitValue[1].replaceAll(regExp,"");
            paragraph = splitValue[2].replaceAll(regExp,"");

            if(!(chapter.equals("") || paragraph.equals(""))){
                paragraphList = this.sentenceReplaceAndSplit(paragraph,"~","-","-");
                /*절의 구간 검색 여부 체킹*/
                if(paragraphList.length >= 2){
                    firstParagraph = paragraphList[0];
                    lastParagraph = paragraphList[1];
                }else if(paragraphList.length == 1){
                    firstParagraph = lastParagraph = paragraphList[0];
                }else{
                    firstParagraph = lastParagraph = "";
                }

                bibleSearchModel = new BibleSearchModel(bibleIdx,bookName,Integer.parseInt(chapter),Integer.parseInt(firstParagraph),Integer.parseInt(lastParagraph),"paragraph");
                bibleContentModelList = bibleSearchDao.selectBibleContents("getBible.getbibleSentenceSearch", bibleSearchModel);
                bibleContentJsonModel = new BibleContentJsonModel("success","성공", bibleContentModelList);
            }else{
                 bibleContentJsonModel = new BibleContentJsonModel("fail","적합한 검색어 수식이 아닙니다.");
            }

        }else if(splitValue.length == 2){
            bookName = splitValue[0];
            chapter = splitValue[1].replaceAll(regExp,"");
            bibleSearchModel = new BibleSearchModel(bibleIdx,bookName,Integer.parseInt(chapter),"chapter");
            bibleContentModelList = bibleSearchDao.selectBibleContents("getBible.getbibleSentenceSearch", bibleSearchModel);
            bibleContentJsonModel = new BibleContentJsonModel("success","성공", bibleContentModelList);
        }else{
             bibleContentJsonModel = new BibleContentJsonModel("fail","적합한 검색어 수식이 아닙니다.");
        }

        return bibleContentJsonModel;
    }

    @Override
    public BibleContentJsonModel getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue, int limit) {
        BibleContentJsonModel bibleContentJsonModel = null;
        BibleSearchModel bibleSearchModel = null;

        bibleSearchModel = new BibleSearchModel(bibleIdx,paragraphValue,limit, limit + 20);
        List<BibleContentModel> bibleContentModel = bibleSearchDao.selectBibleContents("getBible.getBibleParagraphValueSearch", bibleSearchModel);
        if(bibleContentModel.size() >0){
             bibleContentJsonModel = new BibleContentJsonModel("success","성공", bibleContentModel);
        }else{
             bibleContentJsonModel = new BibleContentJsonModel("none","조회 결과가 없습니다");
        }

        return bibleContentJsonModel;
    }

    @Override
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue) {
        String replaceCalcValue = TargetText.replace(replaceMatchValue,replaceChangeValue);
        String[] splitValueList = replaceCalcValue.split(SplitValue);
        return splitValueList;
    }

    @Override
    public BibleContentJsonModel getTodayParagraphValue(int bibleIdx) {
        BibleSearchModel bibleSearchModel = null;
        BibleContentJsonModel bibleContentJsonModel = null;
        List<BibleContentModel> bibleContentModels = null;
        int todayParagraphCount = 0;

        todayParagraphCount = bibleSearchDao.selectTodayParagraphCount("getBible.selectTodayParagraphCount");

        if(todayParagraphCount <= 0){
            bibleSearchDao.InsertTodayParagraph("getBible.insertTodayParagraphKey");
        }

        bibleSearchModel = bibleSearchDao.selectBibleSearchKey("getBible.selectTodayParagraphKey");
        bibleSearchModel.setBibleIdx(bibleIdx);
        bibleSearchModel.setsearchRange("oneParagraph");
        bibleContentModels = bibleSearchDao.selectBibleContents("getBible.bibleContents", bibleSearchModel);

        if(bibleContentModels.size() >0){
            bibleContentJsonModel = new BibleContentJsonModel("success","성공", bibleContentModels);
        }else{
            bibleContentJsonModel = new BibleContentJsonModel("none","조회 결과가 없습니다");
        }

        return bibleContentJsonModel;
    }

    @Override
    public void registTodayParagraphValue() {

    }


}

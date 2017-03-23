package com.ohjic.bible.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.bible.api.model.BibleSearchDao;
import com.ohjic.bible.api.vo.BibleContentJsonVO;
import com.ohjic.bible.api.vo.BibleContentVO;
import com.ohjic.bible.api.vo.BibleSerchVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@Service(value = "bibleSearchService")
public class BibleSearchServiceImpl implements BibleSearchService{

    @Autowired
    private BibleSearchDao bibleSearchDao;

    @Override
    public List<BibleContentVO> getChapterContents(BibleSerchVO bibleSerchVO) {
        List<BibleContentVO> chapterContents = bibleSearchDao.selectBibleContents("getBible.bibleContents",bibleSerchVO);
        return chapterContents;
    }

    @Override
    public List<BibleContentVO> getParagraphContents(BibleSerchVO bibleSerchVO) {
        List<BibleContentVO> paragraphContents = bibleSearchDao.selectBibleContents("getBible.bibleContents",bibleSerchVO);
        return paragraphContents;
    }

    @Override
    public BibleContentJsonVO getParagraphContentsForSentence(int bibleIdx, String searchSentence) {

        String bookName = "";
        String chapter = "";
        String paragraph = "";
        String firstParagraph = "";
        String lastParagraph = "";
        String regExp = "[^0-9~-]";
        String[] paragraphList;
        BibleSerchVO bibleSerchVO;
        BibleContentJsonVO bibleContentJsonVO;
        List<BibleContentVO> bibleContentVOList;

        String[] splitValue = this.sentenceReplaceAndSplit(searchSentence,":"," "," ");

           /* length >=3 => 책 장 절 검사 , length ==2 => 책 장 검사 , 그외 검색 불능*/
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

                bibleSerchVO = new BibleSerchVO(bibleIdx,bookName,Integer.parseInt(chapter),Integer.parseInt(firstParagraph),Integer.parseInt(lastParagraph),"paragraph");
                bibleContentVOList = bibleSearchDao.selectBibleContents("getBible.getbibleSentenceSearch",bibleSerchVO);
                bibleContentJsonVO = new BibleContentJsonVO("success","성공",bibleContentVOList);
            }else{
                 bibleContentJsonVO = new BibleContentJsonVO("fail","can not search");
            }

        }else if(splitValue.length == 2){
            bookName = splitValue[0];
            chapter = splitValue[1].replaceAll(regExp,"");
            bibleSerchVO = new BibleSerchVO(bibleIdx,bookName,Integer.parseInt(chapter),"chapter");
            bibleContentVOList = bibleSearchDao.selectBibleContents("getBible.getbibleSentenceSearch",bibleSerchVO);
            bibleContentJsonVO = new BibleContentJsonVO("success","성공",bibleContentVOList);
        }else{
             bibleContentJsonVO = new BibleContentJsonVO("fail","can not search");
        }

        return bibleContentJsonVO;
    }

    @Override
    public BibleContentJsonVO getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue,int limit) {
        BibleContentJsonVO bibleContentJsonVO;
        System.out.println(limit);
        System.out.println(limit+20);
        System.out.println("=======================");

        BibleSerchVO bibleSerchVO = new BibleSerchVO(bibleIdx,paragraphValue,limit, limit + 20);
        List<BibleContentVO> bibleContentVO = bibleSearchDao.selectBibleContents("getBible.getBibleParagraphValueSearch",bibleSerchVO);
        if(bibleContentVO.size() >0){
             bibleContentJsonVO = new BibleContentJsonVO("success","성공",bibleContentVO);
        }else{
             bibleContentJsonVO = new BibleContentJsonVO("none","조회 결과가 없습니다");
        }

        return bibleContentJsonVO;
    }

    @Override
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue) {
        String replaceCalcValue = TargetText.replace(replaceMatchValue,replaceChangeValue);
        String[] splitValueList = replaceCalcValue.split(SplitValue);
        return splitValueList;
    }

    @Override
    public BibleContentJsonVO getTodayParagraphValue(int bibleIdx) {
        BibleSerchVO bibleSerchVO = bibleSearchDao.selectBibleSearchKey("getBible.selectTodayParagraphKey");
        if(bibleSerchVO == null){
            System.out.println("널값");
        }else{
            System.out.println("널 아님");
        }
        return null;
    }

    @Override
    public void registTodayParagraphValue() {

    }


}

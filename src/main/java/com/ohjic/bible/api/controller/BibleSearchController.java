package com.ohjic.bible.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ohjic.bible.api.model.BibleContentJson;
import com.ohjic.bible.api.model.BibleContent;
import com.ohjic.bible.api.model.BibleSearch;
import com.ohjic.bible.api.service.impl.BibleSearchServiceImpl;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@RestController
@RequestMapping(value = "/bible")
public class BibleSearchController {

    protected static Logger LOGGER = LoggerFactory.getLogger(BibleSearchController.class);

    @Autowired
    private BibleSearchServiceImpl bibleSearchService;

    /*성경 장 가져오기 (성경장 으로 검색)*/
    @RequestMapping(value = "{bibleIdx}/chapter", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContent> getBibleChapterContents(@PathVariable int bibleIdx,
                                                           @RequestParam(value = "bookKindIdx" ,required = true,defaultValue = "0") int bookKindIdx,
                                                           @RequestParam(value = "firstChapter" ,required = true,defaultValue = "0") int firstChapter,
                                                           @RequestParam(value = "lastChapter" ,required = true,defaultValue = "0") int lastChapter){
        /*유지보수에서는 객체를 넘기는것이 용이*/
        /*컨트롤러 단 파라미터를 객체로 직업 받아 버리다.*/
        BibleSearch bibleSearchModel = new BibleSearch(bibleIdx,bookKindIdx,firstChapter,lastChapter,"chapter");

        /*로깅처리 할수 있도록*/
        List<BibleContent> chapterContents = bibleSearchService.getChapterContents(bibleSearchModel);
        LOGGER.info("================start-getBibleChapterContents================");
        LOGGER.info(bibleSearchModel.toString());
        LOGGER.info("================end-getBibleChapterContents==================");
        return chapterContents;
    }

    /*성경 절 가져오기 (성경장, 절로 검색)*/
    @RequestMapping(value = "{bibleIdx}/paragraph", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContent> getBibleParagraphContents(@PathVariable int bibleIdx,
                                                             @RequestParam(value = "bookKindIdx" ,required = true,defaultValue = "1") int bookKindIdx,
                                                             @RequestParam(value = "chapter" ,required = true,defaultValue = "1") int chapter,
                                                             @RequestParam(value = "fitstParagraph" ,required = true,defaultValue = "1") int firstParagraph,
                                                             @RequestParam(value = "lastParagraph" ,required = true,defaultValue = "1") int lastParagraph){
        BibleSearch bibleSearchModel = new BibleSearch(bibleIdx,bookKindIdx,chapter,firstParagraph,lastParagraph,"paragraph");
        List<BibleContent> ParagraphContents = bibleSearchService.getParagraphContents(bibleSearchModel);
        LOGGER.info("================start-getBibleParagraphContents================");
        LOGGER.info(bibleSearchModel.toString());
        LOGGER.info("================end-getBibleParagraphContents==================");
        return ParagraphContents;
    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContent> getBibleBookLists(){
        return null;
    }

    /*성경 문장형 검색 ex.) 창세기 1장 1절, 창세기 1:1 창세기 1장 1~3 )*/
    @RequestMapping(value = "/sentence/{bibleIdx}/{textValue}", method = RequestMethod.GET, headers = "accept=application/json")
    public BibleContentJson getBibleForSentence(@PathVariable int bibleIdx , @PathVariable String textValue){
        BibleContentJson bibleContentJsonModel = bibleSearchService.getParagraphContentsForSentence(bibleIdx,textValue);

        LOGGER.info("================start-getBibleForSentence================");
        LOGGER.info("================end-getBibleForSentence==================");
        return bibleContentJsonModel;
    }

    /*성경 말씀 문장 검색*/
    @RequestMapping(value = "/paragraph/{bibleIdx}/{paragraphValue}", method = RequestMethod.GET, headers = "accept=application/json")
    public BibleContentJson getBibleForParagraphValue(@PathVariable int bibleIdx , @PathVariable String paragraphValue,
                                                           @RequestParam(value = "limit" ,required = true,defaultValue = "0") int Limit){
        BibleContentJson bibleContentJsonModel = bibleSearchService.getParagraphContentsForParagraphValue(bibleIdx,paragraphValue,Limit);

        LOGGER.info("================start-getBibleForParagraphValue================");
        LOGGER.info("================end-getBibleForParagraphValue==================");

        return bibleContentJsonModel;
    }

    /* 오늘의 말씀 */
    @RequestMapping(value = "/todayParagraph/{bibleIdx}", method = RequestMethod.GET, headers = "accept=application/json")
    public BibleContentJson getBibleForParagraphValue(@PathVariable int bibleIdx ){
        BibleContentJson bibleContentJsonModel = bibleSearchService.getTodayParagraphValue(bibleIdx);

        LOGGER.info("================start-getBibleForParagraphValue================");
        LOGGER.info("================end-getBibleForParagraphValue==================");

        return bibleContentJsonModel;
    }


}

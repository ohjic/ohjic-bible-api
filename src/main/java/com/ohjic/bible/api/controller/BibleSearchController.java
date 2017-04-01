package com.ohjic.bible.api.controller;

import com.ohjic.bible.api.common.Constants;
import com.ohjic.bible.api.service.BibleSearchService;
import com.ohjic.bible.api.util.CommonUtil;
import com.ohjic.bible.api.vo.CommonResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ohjic.bible.api.service.impl.BibleSearchServiceImpl;
import com.ohjic.bible.api.vo.BibleContentJsonModel;
import com.ohjic.bible.api.vo.BibleContentModel;
import com.ohjic.bible.api.vo.BibleSearchModel;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@RestController
@RequestMapping(value = "/bible")
public class BibleSearchController {

    protected static Logger LOGGER = LoggerFactory.getLogger(BibleSearchController.class);

    @Autowired
    private BibleSearchService bibleSearchService;

    private CommonResponseJson commonResponseJson;

    /*성경 장 가져오기 (성경장 으로 검색)*/
    @RequestMapping(value = "{bibleIdx}/chapter", method = RequestMethod.GET, headers = "accept=application/json")
    public CommonResponseJson getBibleChapterContents(@PathVariable int bibleIdx,
                                                           @RequestParam(value = "bookKindIdx" ,required = true,defaultValue = "0") int bookKindIdx,
                                                           @RequestParam(value = "firstChapter" ,required = true,defaultValue = "0") int firstChapter,
                                                           @RequestParam(value = "lastChapter" ,required = true,defaultValue = "0") int lastChapter){

        BibleSearchModel bibleSearchModel = new BibleSearchModel(bibleIdx,bookKindIdx,firstChapter,lastChapter,"chapter");
        List<BibleContentModel> bibleContentModelList = bibleSearchService.getChapterContents(bibleSearchModel);
        commonResponseJson = CommonUtil.ListObjectToCommonJson(bibleContentModelList,Constants.SUCCESS_SEARCH_MSG,Constants.FAIL_SEARCH_MSG);

        LOGGER.info("================start-getBibleChapterContents================");
        LOGGER.info(bibleSearchModel.toString());
        LOGGER.info("================end-getBibleChapterContents==================");
        return commonResponseJson;
    }

    /*성경 절 가져오기 (성경장, 절로 검색)*/
    @RequestMapping(value = "{bibleIdx}/paragraph", method = RequestMethod.GET, headers = "accept=application/json")
    public CommonResponseJson getBibleParagraphContents(@PathVariable int bibleIdx,
                                                             @RequestParam(value = "bookKindIdx" ,required = true,defaultValue = "1") int bookKindIdx,
                                                             @RequestParam(value = "chapter" ,required = true,defaultValue = "1") int chapter,
                                                             @RequestParam(value = "fitstParagraph" ,required = true,defaultValue = "1") int firstParagraph,
                                                             @RequestParam(value = "lastParagraph" ,required = true,defaultValue = "1") int lastParagraph){

        BibleSearchModel bibleSearchModel = new BibleSearchModel(bibleIdx,bookKindIdx,chapter,firstParagraph,lastParagraph,"paragraph");
        List<BibleContentModel> bibleContentModelList = bibleSearchService.getParagraphContents(bibleSearchModel);
        commonResponseJson = CommonUtil.ListObjectToCommonJson(bibleContentModelList,Constants.SUCCESS_SEARCH_MSG,Constants.FAIL_SEARCH_MSG);

        LOGGER.info("================start-getBibleParagraphContents================");
        LOGGER.info(bibleSearchModel.toString());
        LOGGER.info("================end-getBibleParagraphContents==================");
        return commonResponseJson;
    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContentModel> getBibleBookLists(){
        return null;
    }

    /*성경 문장형 검색 ex.) 창세기 1장 1절, 창세기 1:1 창세기 1장 1~3 )*/
    @RequestMapping(value = "/sentence/{bibleIdx}/{textValue}", method = RequestMethod.GET, headers = "accept=application/json")
    public CommonResponseJson getBibleForSentence(@PathVariable int bibleIdx , @PathVariable String textValue){

        List<BibleContentModel> bibleContentModelList = bibleSearchService.getParagraphContentsForSentence(bibleIdx,textValue);
        commonResponseJson = CommonUtil.ListObjectToCommonJson(bibleContentModelList,Constants.SUCCESS_SEARCH_MSG,Constants.FAIL_SEARCH_MSG);

        LOGGER.info("================start-getBibleForSentence================");
        LOGGER.info("================end-getBibleForSentence==================");
        return commonResponseJson;
    }

    /*성경 말씀 문장 검색*/
    @RequestMapping(value = "/paragraph/{bibleIdx}/{paragraphValue}", method = RequestMethod.GET, headers = "accept=application/json")
    public CommonResponseJson getBibleForParagraphValue(@PathVariable int bibleIdx , @PathVariable String paragraphValue,
                                                           @RequestParam(value = "limit" ,required = true,defaultValue = "0") int Limit){
        List<BibleContentModel> bibleContentModelList = bibleSearchService.getParagraphContentsForParagraphValue(bibleIdx,paragraphValue,Limit);

        commonResponseJson = CommonUtil.ListObjectToCommonJson(bibleContentModelList,Constants.SUCCESS_SEARCH_MSG,Constants.FAIL_SEARCH_MSG);
        LOGGER.info("================start-getBibleForParagraphValue================");
        LOGGER.info("================end-getBibleForParagraphValue==================");

        return commonResponseJson;
    }

    /* 오늘의 말씀 */
    @RequestMapping(value = "/todayParagraph/{bibleIdx}", method = RequestMethod.GET, headers = "accept=application/json")
    public CommonResponseJson getBibleForParagraphValue(@PathVariable int bibleIdx ){

        List<BibleContentModel> bibleContentModelList = bibleSearchService.getTodayParagraphValue(bibleIdx);
        commonResponseJson = CommonUtil.ListObjectToCommonJson(bibleContentModelList,Constants.SUCCESS_SEARCH_MSG,Constants.FAIL_SEARCH_MSG);

        LOGGER.info("================start-getBibleForParagraphValue================");
        LOGGER.info("================end-getBibleForParagraphValue==================");

        return commonResponseJson;
    }


}

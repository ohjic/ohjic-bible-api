package com.ohjic.bible.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.bible.api.model.BibleContent;
import com.ohjic.bible.api.model.BibleSearch;
import com.ohjic.bible.api.service.impl.BibleSearchServiceImpl;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 13..
 */
@RestController
@RequestMapping(value = "/mainBible")
public class MainBibleController {

     protected static Logger logger = LoggerFactory.getLogger(MainBibleController.class);

    @Autowired
    private BibleSearchServiceImpl bibleSearchService;

    @RequestMapping(value = "/chapter", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContent> getBibleChapterContents(){
        /*유지보수에서는 객체를 넘기는것이 용이*/
        /*컨트롤러 단 파라미터를 객체로 직업 받아 버리다.*/
        BibleSearch bibleSearchModel = new BibleSearch(1,1,1,1,"chapter");

        /*로깅처리 할수 있도록*/
        List<BibleContent> capterContents = bibleSearchService.getChapterContents(bibleSearchModel);
        logger.debug("================로그 체킹 테스트 중입니다================","xptmxm");
        return capterContents;
    }

    @RequestMapping(value = "/paragraph", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContent> getBibleParagraphContents(){
        BibleSearch bibleSearchModel = new BibleSearch(1,1,1,1,2,"paragraph");
        List<BibleContent> ParagraphContents = bibleSearchService.getParagraphContents(bibleSearchModel);

        return ParagraphContents;
    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContent> getBibleBookLists(){
        return null;
    }

}

package com.ohjic.bible.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.bible.api.service.BibleSearchServiceImpl;
import com.ohjic.bible.api.vo.BibleContentVO;
import com.ohjic.bible.api.vo.BibleSerchVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 13..
 */
@RestController
@RequestMapping(value = "/bible")
public class MainBibleController {

     protected static Logger LOGGER = LoggerFactory.getLogger(MainBibleController.class);

    @Autowired
    private BibleSearchServiceImpl bibleSearchService;

    @RequestMapping(value = "/chapter", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContentVO> getBibleChapterContents(){
        /*유지보수에서는 객체를 넘기는것이 용이*/
        /*컨트롤러 단 파라미터를 객체로 직업 받아 버리다.*/
        BibleSerchVO bibleSerchVO = new BibleSerchVO(1,1,1,1,"chapter");

        /*로깅처리 할수 있도록*/
        List<BibleContentVO> capterContents = bibleSearchService.getChapterContents(bibleSerchVO);
        LOGGER.info("================로그 체킹 테스트 중입니다================","xptmxm");
        return capterContents;
    }

    @RequestMapping(value = "/paragraph", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContentVO> getBibleParagraphContents(){
        BibleSerchVO bibleSerchVO = new BibleSerchVO(1,1,1,1,2,"paragraph");
        List<BibleContentVO> ParagraphContents = bibleSearchService.getParagraphContents(bibleSerchVO);

        return ParagraphContents;
    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET, headers = "accept=application/json")
    public List<BibleContentVO> getBibleBookLists(){
        return null;
    }

}

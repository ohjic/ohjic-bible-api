package com.ohjic.bible.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ohjic.bible.api.service.BibleSearchServiceImpl;
import com.ohjic.bible.api.vo.BibleContentJsonVO;
import com.ohjic.bible.api.vo.BibleContentVO;
import com.ohjic.bible.api.vo.BibleSerchVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@RestController
@RequestMapping(value = "/search")
public class BibleSearchController {

    protected static Logger LOGGER = LoggerFactory.getLogger(BibleSearchController.class);

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

    @RequestMapping(value = "/sentence/{bibleIdx}/{textValue}", method = RequestMethod.GET, headers = "accept=application/json")
    public  BibleContentJsonVO getBibleForSentence(@PathVariable int bibleIdx ,@PathVariable String textValue){
        BibleContentJsonVO bibleContentJsonVO = bibleSearchService.getParagraphContentsForSentence(bibleIdx,textValue);
        return bibleContentJsonVO;
    }

    @RequestMapping(value = "/paragraph/{bibleIdx}/{paragraphValue}", method = RequestMethod.GET, headers = "accept=application/json")
    public  BibleContentJsonVO getBibleForParagraphValue(@PathVariable int bibleIdx ,@PathVariable String paragraphValue,
                                                         @RequestParam(value = "limit" ,required = true,defaultValue = "0") int Limit){
        BibleContentJsonVO bibleContentJsonVO = bibleSearchService.getParagraphContentsForParagraphValue(bibleIdx,paragraphValue,Limit);
        return bibleContentJsonVO;
    }

    @RequestMapping(value = "/todayParagraph/{bibleIdx}", method = RequestMethod.GET, headers = "accept=application/json")
    public  BibleContentJsonVO getBibleForParagraphValue(@PathVariable int bibleIdx ){
        BibleContentJsonVO bibleContentJsonVO = bibleSearchService.getTodayParagraphValue(bibleIdx);
        return bibleContentJsonVO;
    }


}

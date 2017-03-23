package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.vo.BibleContentJsonVO;
import com.ohjic.bible.api.vo.BibleContentVO;
import com.ohjic.bible.api.vo.BibleSerchVO;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
public interface BibleSearchService {

    public List<BibleContentVO> getChapterContents(BibleSerchVO bibleSerchVO);
    public List<BibleContentVO> getParagraphContents(BibleSerchVO bibleSerchVO);
    public BibleContentJsonVO getParagraphContentsForSentence(int bibleIdx, String searchSentence);
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue);
}

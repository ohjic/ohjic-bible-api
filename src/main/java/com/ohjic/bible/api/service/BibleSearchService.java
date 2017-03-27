package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.model.BibleContentJson;
import com.ohjic.bible.api.model.BibleContent;
import com.ohjic.bible.api.model.BibleSearch;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
public interface BibleSearchService {

    public List<BibleContent> getChapterContents(BibleSearch bibleSearchModel);
    public List<BibleContent> getParagraphContents(BibleSearch bibleSearchModel);
    public BibleContentJson getParagraphContentsForSentence(int bibleIdx, String searchSentence);
    public BibleContentJson getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue, int limit);
    public BibleContentJson getTodayParagraphValue(int bibleIdx);
    public void registTodayParagraphValue();
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue);
}

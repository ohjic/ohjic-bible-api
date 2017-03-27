package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.vo.BibleContentJsonModel;
import com.ohjic.bible.api.vo.BibleContentModel;
import com.ohjic.bible.api.vo.BibleSearchModel;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
public interface BibleSearchService {

    public List<BibleContentModel> getChapterContents(BibleSearchModel bibleSearchModel);
    public List<BibleContentModel> getParagraphContents(BibleSearchModel bibleSearchModel);
    public BibleContentJsonModel getParagraphContentsForSentence(int bibleIdx, String searchSentence);
    public BibleContentJsonModel getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue, int limit);
    public BibleContentJsonModel getTodayParagraphValue(int bibleIdx);
    public void registTodayParagraphValue();
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue);
}

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
    public List<BibleContentModel> getParagraphContentsForSentence(int bibleIdx, String searchSentence);
    public List<BibleContentModel> getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue, int limit);
    public List<BibleContentModel> getTodayParagraphValue(int bibleIdx);
    public void registTodayParagraphValue();
    public List<BibleContentModel> getChapterForSentenceSearch(int bibleIdx, String[] sentenceSearchValue);
    public List<BibleContentModel> getChapterAndParagraphForSentenceSearch(int bibleIdx, String[] sentenceSearchValue);
}

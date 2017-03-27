package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.model.BibleContentJson;
import com.ohjic.bible.api.model.BibleContent;
import com.ohjic.bible.api.model.BibleSearch;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
public interface BibleSearchService {

	/**
	 * 
	 * @param bibleSearch
	 * @return
	 */
    public List<BibleContent> getChapterContents(BibleSearch bibleSearch);
    
    /**
     * 
     * @param bibleSearch
     * @return
     */
    public List<BibleContent> getParagraphContents(BibleSearch bibleSearch);
    
    /**
     * 
     * @param bibleIdx
     * @param searchSentence
     * @return
     */
    public BibleContentJson getParagraphContentsForSentence(int bibleIdx, String searchSentence);
    
    /**
     * 
     * @param bibleIdx
     * @param paragraphValue
     * @param limit
     * @return
     */
    public BibleContentJson getParagraphContentsForParagraphValue(int bibleIdx, String paragraphValue, int limit);
    
    /**
     * 
     * @param bibleIdx
     * @return
     */
    public BibleContentJson getTodayParagraphValue(int bibleIdx);
    
    /**
     * 
     */
    public void registTodayParagraphValue();
    
    /**
     * 
     * @param TargetText
     * @param replaceMatchValue
     * @param replaceChangeValue
     * @param SplitValue
     * @return
     */
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue);
}

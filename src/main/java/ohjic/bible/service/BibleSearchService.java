package ohjic.bible.service;

import ohjic.bible.vo.BibleContentJsonVO;
import ohjic.bible.vo.BibleContentVO;
import ohjic.bible.vo.BibleSerchVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
public interface BibleSearchService {

    public List<BibleContentVO> getChapterContents(BibleSerchVO bibleSerchVO);
    public List<BibleContentVO> getParagraphContents(BibleSerchVO bibleSerchVO);
    public BibleContentJsonVO getParagraphContentsForSentence(int bibleIdx, String searchSentence);
    public String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue);
}

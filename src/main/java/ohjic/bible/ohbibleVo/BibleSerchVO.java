package ohjic.bible.ohbibleVo;

/**
 * Created by hwangseong-in on 2017. 3. 14..
 */
/* 성경 검색 용 VO*/
public class BibleSerchVO {

    /*성격 종류 키*/
    private int bibleIdx;
    /*성경 책 종류 키*/
    private int bookKindIdx;
    /*장*/
    private int chapter;
    /*절*/
    private int paragraph;
    /*절 범위 검색용 시작 값 */
    private int firstChapter;
    /*절 범위 검색용 마지막 값*/
    private int lastChapter;
    /*절 범위 검색용 시작 값 */
    private int firstParagraph;
    /*절 범위 검색용 마지막 값*/
    private int lastParagraph;
    /* 장 절 검색 여부 플래그 */
    private String SearchRange;

    public BibleSerchVO(int bibleIdx, int bookKindIdx, int chapter, int firstParagraph, int lastParagraph, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookKindIdx = bookKindIdx;
        this.chapter = chapter;
        this.firstParagraph = firstParagraph;
        this.lastParagraph = lastParagraph;
        SearchRange = searchRange;
    }

    public BibleSerchVO(int bibleIdx, int bookKindIdx, int firstChapter, int lastChapter, String searchRange) {
        this.bibleIdx = bibleIdx;
        this.bookKindIdx = bookKindIdx;
        this.firstChapter = firstChapter;
        this.lastChapter = lastChapter;
        SearchRange = searchRange;
    }

    public int getBibleIdx() {
        return bibleIdx;
    }

    public void setBibleIdx(int bibleIdx) {
        this.bibleIdx = bibleIdx;
    }

    public int getBookKindIdx() {
        return bookKindIdx;
    }

    public void setBookKindIdx(int bookKindIdx) {
        this.bookKindIdx = bookKindIdx;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getParagraph() {
        return paragraph;
    }

    public void setParagraph(int paragraph) {
        this.paragraph = paragraph;
    }

    public int getFirstChapter() {
        return firstChapter;
    }

    public void setFirstChapter(int firstChapter) {
        this.firstChapter = firstChapter;
    }

    public int getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(int lastChapter) {
        this.lastChapter = lastChapter;
    }

    public int getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(int firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public int getLastParagraph() {
        return lastParagraph;
    }

    public void setLastParagraph(int lastParagraph) {
        this.lastParagraph = lastParagraph;
    }

    public String getSearchRange() {
        return SearchRange;
    }

    public void setSearchRange(String searchRange) {
        SearchRange = searchRange;
    }




}

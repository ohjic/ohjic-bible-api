package ohjic.bible.ohbibleService;

import ohjic.bible.ohbibleVo.BibleContentVO;
import ohjic.bible.ohbibleVo.BibleSerchVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 13..
 */
public interface MainBibleService {

    public List<BibleContentVO> getChapterContents(BibleSerchVO bibleSerchVO);
    public List<BibleContentVO> getParagraphContents(BibleSerchVO bibleSerchVO);
}

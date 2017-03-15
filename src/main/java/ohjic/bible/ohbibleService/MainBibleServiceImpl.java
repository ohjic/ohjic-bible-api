package ohjic.bible.ohbibleService;

import ohjic.bible.ohbibleModel.MainBibleDao;
import ohjic.bible.ohbibleVo.BibleContentVO;
import ohjic.bible.ohbibleVo.BibleSerchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 13..
 */
@Service(value = "mainBibleServiceImpl")
public class MainBibleServiceImpl implements MainBibleService {

    @Autowired
    private MainBibleDao mainBibleDao;

    @Override
    public List<BibleContentVO> getChapterContents(BibleSerchVO bibleSerchVO) {

        List<BibleContentVO> chapterContents = mainBibleDao.selectBibleContents("getBible.bibleContents",bibleSerchVO);
        return chapterContents;
    }

    @Override
    public List<BibleContentVO> getParagraphContents(BibleSerchVO bibleSerchVO) {
        List<BibleContentVO> paragraphContents = mainBibleDao.selectBibleContents("getBible.bibleContents",bibleSerchVO);
        return paragraphContents;
    }
}

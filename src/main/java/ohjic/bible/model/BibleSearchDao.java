package ohjic.bible.model;

import ohjic.bible.vo.BibleContentVO;
import ohjic.bible.vo.BibleSerchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@Repository(value = "bibleSearchDao")
public class BibleSearchDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<BibleContentVO> selectBibleContents(String queryId, BibleSerchVO bibleSerchVO){
        return sqlSession.selectList(queryId,bibleSerchVO);
    }
}

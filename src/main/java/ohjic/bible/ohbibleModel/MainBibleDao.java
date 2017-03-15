package ohjic.bible.ohbibleModel;

import ohjic.bible.ohbibleVo.BibleContentVO;
import ohjic.bible.ohbibleVo.BibleSerchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by hwangseong-in on 2017. 3. 13..
 */
@Repository(value = "mainBibleDao")
public class MainBibleDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<BibleContentVO> selectBibleContents(String queryId, BibleSerchVO bibleSerchVO){
        return sqlSession.selectList(queryId,bibleSerchVO);
    }
}

package com.ohjic.bible.api.persistent;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ohjic.bible.api.model.BibleContent;
import com.ohjic.bible.api.model.BibleSearch;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 3. 20..
 */
@Repository(value = "bibleSearchDao")
public class BibleSearchDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<BibleContent> selectBibleContents(String queryId, BibleSearch bibleSearchModel){
        return sqlSession.selectList(queryId, bibleSearchModel);
    }

    public int selectTodayParagraphCount(String queryId){
        return sqlSession.selectOne(queryId);
    }

    public BibleSearch selectBibleSearchKey(String queryId){
        return sqlSession.selectOne(queryId);
    }

    public void InsertTodayParagraph(String queryId){
         sqlSession.insert(queryId);
    }

}

package com.ohjic.bible.api.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ohjic.bible.api.vo.MainVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
@Repository("MainDao")
public class MainDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<MainVO> getMainDaoData(String queryId){
        return sqlSession.selectList(queryId);
    }

    public List<MainVO> getMainDaoDataForParam(String queryId,int limitCount){
        return sqlSession.selectList(queryId,limitCount);
    }
}

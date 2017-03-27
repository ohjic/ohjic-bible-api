package com.ohjic.bible.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.bible.api.model.BibleMain;
import com.ohjic.bible.api.persistent.MainDao;
import com.ohjic.bible.api.service.MainService;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
@Service("mainServiceImpl")
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDao mainDao;

    public List<BibleMain> serviceDaoTest() throws Exception {
        return mainDao.getMainDaoData("test.testSql");
    }

    @Override
    public List<BibleMain> serviceDaoTestForParam(int limitCount) throws Exception {
        return mainDao.getMainDaoDataForParam("test.testSqlForParam",limitCount);
    }
}

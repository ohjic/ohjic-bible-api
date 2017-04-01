package com.ohjic.bible.api.service.impl;

import com.ohjic.bible.api.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.bible.api.model.MainDao;
import com.ohjic.bible.api.vo.MainModel;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
@Service("mainServiceImpl")
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDao mainDao;

    public List<MainModel> serviceDaoTest() throws Exception {
        return mainDao.getMainDaoData("test.testSql");
    }

    @Override
    public List<MainModel> serviceDaoTestForParam(int limitCount) throws Exception {
        return mainDao.getMainDaoDataForParam("test.testSqlForParam",limitCount);
    }
}

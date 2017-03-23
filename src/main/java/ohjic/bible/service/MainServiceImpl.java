package ohjic.bible.service;

import ohjic.bible.model.MainDao;
import ohjic.bible.vo.MainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
@Service("mainServiceImpl")
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDao mainDao;

    public List<MainVO> serviceDaoTest() throws Exception {
        return mainDao.getMainDaoData("test.testSql");
    }

    @Override
    public List<MainVO> serviceDaoTestForParam(int limitCount) throws Exception {
        return mainDao.getMainDaoDataForParam("test.testSqlForParam",limitCount);
    }
}

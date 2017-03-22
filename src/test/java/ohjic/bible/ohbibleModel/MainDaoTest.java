package ohjic.bible.ohbibleModel;

import ohjic.bible.model.MainDao;
import ohjic.bible.vo.MainVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hwangseong-in on 2017. 3. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "file:src/main/resources/spring/dispatcher-Context.xml",
        "file:src/main/resources/spring/database-Context.xml",
        "file:src/main/resources/spring/mapper-Context.xml",})
public class MainDaoTest {
    // 왜 안될까 숙제 널포인터 예외 ->

    @Autowired
    private MainDao mainDao;

    @Test
    public void testGetMainDaoData() throws Exception {

        List<MainVO> mainVOs = mainDao.getMainDaoData("test.testSql");
        System.out.println(mainVOs);
        assertTrue(mainVOs.size() >0);
    }

}
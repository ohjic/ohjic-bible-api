package ohjic.bible.ohbibleService;

import ohjic.bible.ohbibleVo.MainVO;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
public interface MainService {

   public List<MainVO> serviceDaoTest()throws Exception;
   public List<MainVO> serviceDaoTestForParam(int limit)throws Exception;
}

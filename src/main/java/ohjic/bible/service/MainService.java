package ohjic.bible.service;

import java.util.List;

import ohjic.bible.vo.MainVO;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
public interface MainService {

   public List<MainVO> serviceDaoTest()throws Exception;
   public List<MainVO> serviceDaoTestForParam(int limit)throws Exception;
}

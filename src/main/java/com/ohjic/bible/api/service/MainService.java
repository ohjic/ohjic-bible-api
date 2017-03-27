package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.model.BibleMain;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
public interface MainService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
   public List<BibleMain> serviceDaoTest()throws Exception;
   
   /**
    * 
    * @param limit
    * @return
    * @throws Exception
    */
   public List<BibleMain> serviceDaoTestForParam(int limit)throws Exception;
}

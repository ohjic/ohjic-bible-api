package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.model.Main;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
public interface MainService {

   public List<Main> serviceDaoTest()throws Exception;
   public List<Main> serviceDaoTestForParam(int limit)throws Exception;
}

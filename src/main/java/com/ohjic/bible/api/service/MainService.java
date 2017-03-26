package com.ohjic.bible.api.service;

import java.util.List;

import com.ohjic.bible.api.vo.MainModel;

/**
 * Created by hwangseong-in on 2017. 2. 20..
 */
public interface MainService {

   public List<MainModel> serviceDaoTest()throws Exception;
   public List<MainModel> serviceDaoTestForParam(int limit)throws Exception;
}

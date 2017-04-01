package com.ohjic.bible.api.util;

import com.ohjic.bible.api.vo.BibleContentModel;
import com.ohjic.bible.api.vo.CommonResponseJson;

import java.util.List;

/**
 * Created by hwangseong-in on 2017. 4. 1..
 */
public class CommonUtil {

    /*List<Object> 형태를 하고 싶은데 왜 안되는거지.*/
    public static CommonResponseJson ListObjectToCommonJson(List<BibleContentModel> lists, String successText, String failText){
        CommonResponseJson commonResponseJson;
        if(lists.isEmpty()){
            commonResponseJson = new CommonResponseJson("fail",failText);
        }else{
            commonResponseJson = new CommonResponseJson("success",successText,lists);
        }
        return commonResponseJson;
    }


}

package com.ohjic.bible.api.service;

import java.util.concurrent.TimeUnit;

/**
 * Created by hwangseong-in on 2017. 3. 1..
 */
public class TestJunit {
    public int testCalculater(int first, int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return (first * 2) * seconds  ;
    }

    public String[] testBibleSplit(String TargetText, String replaceMatchValue,String replaceChangeValue,String SplitValue){
        String replaceCalcValue = TargetText.replace(replaceMatchValue,replaceChangeValue);
        String[] splitValueList = replaceCalcValue.split(SplitValue);
        return splitValueList;
    }
}

package com.ohjic.bible.api.util;

/**
 * Created by hwangseong-in on 2017. 4. 1..
 */
public class StringUtility {

    /*문장 교체후 나누어 주기*/
    public static String[] sentenceReplaceAndSplit(String TargetText, String replaceMatchValue, String replaceChangeValue, String SplitValue) {
        String replaceCalcValue = TargetText.replace(replaceMatchValue,replaceChangeValue);
        String[] splitValueList = replaceCalcValue.split(SplitValue);
        return splitValueList;
    }
}

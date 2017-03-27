package com.ohjic.bible.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ohjic.bible.api.vo.BibleContentJsonModel;
import com.ohjic.bible.api.vo.BibleSearchModel;

/**
 * Created by hwangseong-in on 2017. 3. 1..
 */
public class TestJunitTest {

    @Test
    public void testTestCalculater() throws Exception {
        TestJunit testJunit = new TestJunit();
        assertEquals(200,testJunit.testCalculater(10,10));
    }

    @Test(timeout = 500000)
    public void testTestCalculaterTime() throws Exception {
        TestJunit testJunit = new TestJunit();
       /* String[] testValueList = {"창세기절 1장 1절","창세기절 1장 1","창세기절 1:1",
                              "창세기절 4장", "창세기절 4","창세기절",
                              "창세기절 1장 1-2","창세기절 1 1-2","창세기절 1 1장-2절","창세기절 1 장1-2"
                             ,"창세기절 1장 1~2","창세기절 1 1~2","창세기절 1 1자앙~2절","창세기절 1 1~2절","창세기장 일장 이절" };*/
        String[] testValueList = {"창세기절 1장 4절" };
        String regExp = "[^0-9~-]";


        for (String testValue: testValueList) {
            String bookName = "";
            String chapter = "";
            String paragraph = "";
            String firstParagraphTest = "";
            String lastParagraphTest = "";
            String searchRange = "";
            BibleSearchModel bibleSearchModel;
            BibleContentJsonModel bibleContentJsonModel;
            String[] splitValue = testJunit.testBibleSplit(testValue,":"," "," ");

           /* length >=3 => 책 장 절 검사 , length ==2 => 책 장 검사 , 그외 검색 불능*/
            if(splitValue.length >=3){
                bookName = splitValue[0];
                chapter = splitValue[1].replaceAll(regExp,"");
                paragraph = splitValue[2].replaceAll(regExp,"");
                if(!(chapter.equals("") || paragraph.equals(""))){
                    searchRange = "paragraph";
                    String[] paragraphList = testJunit.testBibleSplit(paragraph,"~","-","-");
                    /*절의 구간 검색 여부 체킹*/
                    if(paragraphList.length >= 2){
                        firstParagraphTest = paragraphList[0];
                        lastParagraphTest = paragraphList[1];
                    }else if(paragraphList.length == 1){
                        firstParagraphTest = lastParagraphTest = paragraphList[0];
                    }else{
                        firstParagraphTest = lastParagraphTest = "";
                    }
                    bibleSearchModel = new BibleSearchModel(1,bookName,Integer.parseInt(chapter),Integer.parseInt(firstParagraphTest),Integer.parseInt(lastParagraphTest),searchRange);
                }else{
                    System.out.println("can not Search");
                }

            }else if(splitValue.length == 2){
                bookName = splitValue[0];
                chapter = splitValue[1].replaceAll(regExp,"");
                searchRange = "chapter";
                bibleSearchModel = new BibleSearchModel(1,bookName,Integer.parseInt(chapter),searchRange);
            }else{
                System.out.println("can not Search");
            }



            System.out.println("=========================");
            System.out.println(testValue);
            System.out.print("book : ");
            System.out.println(bookName);
            System.out.print("chapter : ");
            System.out.println(chapter);
            System.out.print("fitstParagraph : ");
            System.out.println(firstParagraphTest);
            System.out.print("lastParagraph : ");
            System.out.println(lastParagraphTest);
            System.out.println("=========================");
        }
    }
}
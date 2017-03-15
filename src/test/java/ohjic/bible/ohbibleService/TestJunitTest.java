package ohjic.bible.ohbibleService;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hwangseong-in on 2017. 3. 1..
 */
public class TestJunitTest {

    @Test
    public void testTestCalculater() throws Exception {
        TestJunit testJunit = new TestJunit();
        assertEquals(200,testJunit.testCalculater(10,10));
    }

    @Test(timeout = 50000)
    public void testTestCalculaterTime() throws Exception {
        TestJunit testJunit = new TestJunit();
        assertEquals(200,testJunit.testCalculater(10,10));
    }
}
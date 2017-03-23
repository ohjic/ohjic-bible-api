package com.ohjic.bible.api.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ohjic.bible.api.controller.MainRestController;
import com.ohjic.bible.api.service.MainService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by hwangseong-in on 2017. 3. 5..
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "file:src/main/resources/spring/dispatcher-Context.xml",
        "file:src/main/resources/spring/database-Context.xml",
        "file:src/main/resources/spring/mapper-Context.xml",
        "file:src/main/resources/spring/applicationContext.xml"})
public class mainRestControllerTest {

    @Mock
    private MainService mainService;

    @InjectMocks
    private MainRestController mainRestController;


    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainRestController).build();
    }


    @Test
    public void MainRestControllerTest()throws Exception{
        mockMvc.perform(get("/rest/test")).andExpect(status().isOk());
    }


}





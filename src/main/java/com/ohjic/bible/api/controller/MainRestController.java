package com.ohjic.bible.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.bible.api.service.MainService;
import com.ohjic.bible.api.vo.MainModel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by hwangseong-in on 2017. 2. 21..
 */
@RestController
@RequestMapping(value = "/rest")
public class MainRestController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "accept=application/json")
    protected List<MainModel> restTest() throws Exception {

        List<MainModel> mainModelList = mainService.serviceDaoTest();
        return mainModelList;

    }

    @RequestMapping(value = "/testParam/{value}", method = RequestMethod.GET, headers = "accept=application/json")
    protected List<MainModel> restTestForparam(@PathVariable int value) throws Exception {
        System.out.println(value);
        List<MainModel> mainModelList = mainService.serviceDaoTestForParam(value);
        return mainModelList;
    }


    @RequestMapping(value = "/testFilterStream", method = RequestMethod.GET, headers = "accept=application/json")
    public List<MainModel> restStreamTest() throws Exception {

        List<MainModel> mainModelList = mainService.serviceDaoTest();
        List<MainModel> mainStreamVOList = mainModelList.stream().filter(e->e.getArticle_id() >10).collect(Collectors.toList());

        return mainStreamVOList;

    }

    @RequestMapping(value = "/testMapStream", method = RequestMethod.GET, headers = "accept=application/json")
    public List<String> restStreamMapTest() throws Exception {

        List<MainModel> mainModelList = mainService.serviceDaoTest();
        List<String> mainStreamVOList = mainModelList.stream().filter(e->e.getArticle_id() >10).map(e -> e.getWriter_name()).collect(Collectors.toList());

        return mainStreamVOList;

    }


    @RequestMapping(value = "/testParallelMapStream", method = RequestMethod.GET, headers = "accept=application/json")
    public Long parallel() throws Exception {
        Long start = System.currentTimeMillis();
        Arrays.asList(1,2,3,4,5,6,7,8).parallelStream().map(i->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }return i;
        }).forEach(i -> System.out.println(i));

        return System.currentTimeMillis()-start;

    }

    @RequestMapping(value = "/testNonParallelMapStream", method = RequestMethod.GET, headers = "accept=application/json")
    public Long nonParallel() throws Exception {
        Long start = System.currentTimeMillis();
        Arrays.asList(1,2,3,4,5,6,7,8).stream().map(i->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }return i;
        }).forEach(i -> System.out.println(i));

        return System.currentTimeMillis()-start;

    }




}

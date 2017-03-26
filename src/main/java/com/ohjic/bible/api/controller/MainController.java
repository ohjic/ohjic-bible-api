package com.ohjic.bible.api.controller; /**
 * Created by hwangseong-in on 2017. 2. 20..
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ohjic.bible.api.service.MainService;
import com.ohjic.bible.api.vo.MainModel;

import java.util.List;


@Controller
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    private MainService mainService;


    @RequestMapping(value = "/todo" , method = RequestMethod.GET)
    public String main(Model model) throws Exception {

        List<MainModel> mainModelList = mainService.serviceDaoTest();
        model.addAttribute("articleList", mainModelList);
        model.addAttribute("hello","sungin hi");
        return "hello";
    }

}

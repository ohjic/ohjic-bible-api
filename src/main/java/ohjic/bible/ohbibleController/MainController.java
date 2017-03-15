package ohjic.bible.ohbibleController; /**
 * Created by hwangseong-in on 2017. 2. 20..
 */

import ohjic.bible.ohbibleVo.MainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ohjic.bible.ohbibleService.MainService;

import java.util.List;


@Controller
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    private MainService mainService;


    @RequestMapping(value = "/todo" , method = RequestMethod.GET)
    public String main(Model model) throws Exception {

        List<MainVO> mainVOList = mainService.serviceDaoTest();
        model.addAttribute("articleList",mainVOList);
        model.addAttribute("hello","sungin hi");
        return "hello";
    }

}

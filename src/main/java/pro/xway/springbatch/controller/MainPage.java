package pro.xway.springbatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.xway.springbatch.service.DataService;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping
public class MainPage {
    public static final String LOAD_PAGE = "/loading";
    public static final String REDIRECT = "redirect:";
    @Autowired
    private DataService dataService;

    @RequestMapping("/")
    public String start(Model model) {
//        if (dataService.getSizeData() == 0) return REDIRECT + LOAD_PAGE;
        model.addAttribute("isLoadedData", dataService.getSizeData() == 0);



        return "index";
    }

    @RequestMapping(LOAD_PAGE)
    public String loading() {
        dataService.convertData();
        return REDIRECT + "/";
    }


    @RequestMapping("/reportOne")
    public String reportOne(Model model){
        model.addAttribute("itemList", dataService.getUserForReportForOne());
        model.addAttribute("date", new Date());

        return "reportOne";
    }

    @RequestMapping("/reportTwo")
    public String reportTwo(Model model) {
        model.addAttribute("itemList", dataService.getUserForReportForTwo());

        return "reportTwo";
    }
    @RequestMapping("/reportThree")
    public String reportThree(Model model) {
        model.addAttribute("itemList", dataService.getUserForReportForThree());

        return "reportThree";
    }


}

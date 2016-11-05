package com.majorbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by AndySun on 2016/10/7.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("name", "helloworld");
        return "index";
    }

    @RequestMapping("/freemarker")
    public ModelAndView freemarker() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hello", "andy");
        mav.setViewName("freemarker");
        return mav;
    }
}

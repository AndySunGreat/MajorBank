package com.majorbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by AndySun on 2016/10/7.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("name", "helloworld");
        //returns the view name
        return "index";
    }
}

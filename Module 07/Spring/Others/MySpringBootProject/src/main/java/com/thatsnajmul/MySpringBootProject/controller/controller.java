package com.thatsnajmul.MySpringBootProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

    @RequestMapping("/")
    public  String home(){
        return "index";
    }

    @RequestMapping("/contact")
    public  String contact(){
        return "contact";
    }


}

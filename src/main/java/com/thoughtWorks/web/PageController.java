package com.thoughtWorks.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("index")
    public String index(){
        return "front/home/index";
    }

    @RequestMapping("frontLogin")
    public String frontLogin(){
        return "front/login";
    }
}
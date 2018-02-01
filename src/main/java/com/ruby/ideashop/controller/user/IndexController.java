package com.ruby.ideashop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request){
        request.setAttribute("aaa","bbb");

        return "index";
    }

}

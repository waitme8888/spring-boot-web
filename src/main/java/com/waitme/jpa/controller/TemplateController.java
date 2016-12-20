package com.waitme.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TemplateController {
//    /**
//     * 返回html模板.
//     */
//    @RequestMapping("/hello")
//    public String helloHtml(Map<String,Object> map){
//        map.put("hello","from TemplateControllerqqq.helloHtml");
//        return "hello";
//    }
//    /**
//     * 返回html模板.
//     */
//    @RequestMapping("/helloFtl")
//    public String helloFtl(Map<String,Object> map){
//        map.put("hello","from TemplateController.helloFtl");
//        return"/helloFtl";
//    }

    @RequestMapping("/hello/jsp")
    public String helloHtml(Map<String, Object> map) {
        map.put("hello", "from TemplateControllerqqq.helloHtml");
        System.out.println("jsp");
        return "helloJsp";
    }
}

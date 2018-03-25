package com.cxb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TemplatesController {
    //这是测试模板页面
    @GetMapping("/templates")
    public String html(HttpServletRequest request){
        request.setAttribute("say","Hello Spring Boot");
        return "/index";
    }

    //这是测试静态页面   http://localhost:8082/index.html   直接访问静态页面
    @GetMapping("/html")
    public String html() {
        return "/index.html";
    }

    //这是测试重定向到静态页面上去
    @GetMapping("/redHtml")
    public String redHtml() {
        return "redirect:/index.html";
    }
}

package com.cxb.demo.controller;

import com.cxb.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
//@RestController==@Controller+@ResponseBody   前面的注解等于后面两个注解
public class HelloController {
    //这是使用配置文件里面的定义的变量
   /* @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;*/
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String hi(HttpServletRequest request){
        request.setAttribute("say","Hello Spring Boot");
        //这个是模板里面的页面的文件名
        return "spring";
    }

    //value = {"/hello","/hi"}这是输入两个链接都可以访问
    //这是取后边链接值的方式1
    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return girlProperties.getCupSize() + id;
    }

    //这是取后边链接值的方式2   /talk?id=100
   // @RequestMapping(value = "/talk",method = RequestMethod.GET)  //如果觉得这个太长了  就用下面的方式
    @GetMapping(value = "/talk")
    //这里可以给id一个默认值  如果不写默认值就是@RequestParam("id")
    public String talk(@RequestParam(value = "id", required = false,defaultValue = "0") Integer id){
        return girlProperties.getCupSize() + id;
    }

}

package com.cxb.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    /*//这里的*号代表该控制器里所有的方法  这些日志打印在方法前
    @Before("execution(public * com.cxb.demo.controller.GirlController.*(..))")
    public void log(){
        System.out.println("开始打印日志！");
    }

    @After("execution(public * com.cxb.demo.controller.GirlController.*(..))")
    public void doLog(){
        System.out.println("打印日志结束！");
    }*/
    private final static Logger log= LoggerFactory.getLogger(HttpAspect.class);
    //优化上面的代码
    @Pointcut("execution(public * com.cxb.demo.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("开始打印日志！");
        //url
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url={}",request.getRequestURL());
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}",request.getRemoteAddr());
        //类方法                                               类名 和  类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        log.info("打印日志结束！");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("response={}",object.toString());
    }
}

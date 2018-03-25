package com.cxb.demo.handle;

import com.cxb.demo.exception.GirlException;
import com.cxb.demo.domain.Result;
import com.cxb.demo.enums.ResultEnum;
import com.cxb.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger log= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException= (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            log.info("【系统异常】{}",e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR);
        }
    }
}

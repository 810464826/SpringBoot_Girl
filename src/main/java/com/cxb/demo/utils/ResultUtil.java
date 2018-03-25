package com.cxb.demo.utils;

import com.cxb.demo.domain.Result;
import com.cxb.demo.enums.ResultEnum;

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
    public static Result error(ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }

    public static Result success(){
        return success(null);
    }
}

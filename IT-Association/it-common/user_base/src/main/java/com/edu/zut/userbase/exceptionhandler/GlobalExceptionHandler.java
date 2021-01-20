package com.edu.zut.userbase.exceptionhandler;

import com.edu.zut.commonutils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 *统一异常处理
 */
@ControllerAdvice

public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..");
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody //为了返回数据
    public R error(MyException e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        return  R.error().code(e.getCode()).message(e.getMsg());
    }
}

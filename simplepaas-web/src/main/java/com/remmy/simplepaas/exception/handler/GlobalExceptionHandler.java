package com.remmy.simplepaas.exception.handler;

import com.remmy.simplepaas.common.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yejiaxin
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespBean handleException(Exception e) {
        log.error("【全局异常拦截】异常信息：{}", e.getMessage());
        e.printStackTrace();
        return RespBean.error(e.getMessage());
    }
}

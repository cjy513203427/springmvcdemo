package org.format.demo.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 谷天乐
 * @Date: 2019/1/21 10:48
 * @Description: ExceptionHandlerMethodResolver内部找不到Controller的@ExceptionHandler注解的话，
 * 会找@ControllerAdvice中的@ExceptionHandler注解方法
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> ajaxError(Throwable error, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", error.getMessage());
        map.put("result", "error");
        return map;
    }

}
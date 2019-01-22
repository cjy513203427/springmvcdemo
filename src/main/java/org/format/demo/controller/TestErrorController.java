package org.format.demo.controller;

import org.format.demo.custom.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/21 09:55
 * @Description:
 */
@Controller
@RequestMapping(value = "/error")
public class TestErrorController {

    @RequestMapping("/exception")
    @ResponseBody
    public Map exception() throws ClassNotFoundException {
        throw new ClassNotFoundException("class not found");
    }

    @RequestMapping("/nullpointer")
    @ResponseBody
    public Map nullpointer() {
        Map resultMap = new HashMap();
        String str = null;
        str.length();
        resultMap.put("strNullError",str);
        return resultMap;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map error(RuntimeException error, HttpServletRequest request) {
        Map resultMap = new HashMap();
        resultMap.put("param", "Runtime error");
        return resultMap;
    }

    @ExceptionHandler()
    @ResponseBody
    public Map error(Exception error, HttpServletRequest request, HttpServletResponse response) {
        Map resultMap = new HashMap();
        resultMap.put("param", "Exception error");
        return resultMap;
    }

    /**
     * @Author 谷天乐
     * @Description 将上面@ExceptionHandler的方法注释掉再测试
     * 未写@ExceptionHandler，会由ResponseStatusExceptionResolver解析
     * @Date 2019/1/21 10:52
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping("/unauth")
    @ResponseBody
    public Map unauth() {
        throw new UnauthorizedException();
    }


}
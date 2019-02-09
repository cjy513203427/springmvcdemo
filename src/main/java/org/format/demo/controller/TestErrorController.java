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

    @RequestMapping("/classNotFound")
    @ResponseBody
    public Map classNotFound() throws ClassNotFoundException {
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

    /**
     * @Author 谷天乐
     * @Description If empty, will default to any
     * exceptions listed in the method argument list.
     * 相当于@ExceptionHandler(Exception.class)
     * @Date 2019/2/8 21:34
     * @Param [error, request, response]
     * @return java.util.Map
     **/
    @ExceptionHandler()
    @ResponseBody
    public Map error(Exception error, HttpServletRequest request, HttpServletResponse response) {
        Map resultMap = new HashMap();
        resultMap.put("param", "Exception error");
        return resultMap;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map error() {
        Map resultMap = new HashMap();
        resultMap.put("param","NullPointerException");
        return resultMap;
    }

    @RequestMapping("/noSuchMethod")
    public Map noHandleMethod() throws NoSuchMethodException {
        throw new NoSuchMethodException();
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
    public Map unauth() {
        throw new UnauthorizedException();
    }

}
package org.format.demo.controller;

import org.format.demo.custom.TestObj;
import org.format.demo.model.Dept;
import org.format.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/28 14:17
 * @Description: 测试自定义参数注解
 */
@Controller
@RequestMapping(value = "/foc")
public class TestObjController {
    @RequestMapping("/test1")
    @ResponseBody
    public Map test1(@TestObj Dept dept, @TestObj Employee emp) {
        Map resultMap = new HashMap();
        resultMap.put("Dept",dept);
        resultMap.put("Emp",emp);
        return resultMap;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Map test2(@TestObj("d") Dept dept, @TestObj("e") Employee emp) {
        Map resultMap = new HashMap();
        resultMap.put("d",dept);
        resultMap.put("e",emp);
        return resultMap;
    }

}
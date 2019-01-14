package org.format.demo.controller;

import org.format.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/11 09:02
 * @Description:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("/testRb")
    @ResponseBody
    public Employee testRb(@RequestBody Employee e) {
        return e;
    }

    @RequestMapping(value="/testCustomObj", produces={"text/html; charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public Employee testCustomObj(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "name") String name) {
        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        return e;
    }

    @RequestMapping("/testCustomObjWithRp")
    @ResponseBody
    public Employee testCustomObjWithRp(@RequestParam Employee e) {
        return e;
    }

    @RequestMapping(value = "/testDate", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public Date testDate(Date date) {
        return date;
    }
}
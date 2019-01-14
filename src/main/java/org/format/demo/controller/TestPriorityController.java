package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/priority")
public class TestPriorityController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String test1(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "其他condition相同，带有method属性的优先级高");
        return String.valueOf(view);
    }

    @RequestMapping()
    @ResponseBody
    public String test2(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "其他condition相同，不带method属性的优先级高");
        return String.valueOf(view);
    }

}
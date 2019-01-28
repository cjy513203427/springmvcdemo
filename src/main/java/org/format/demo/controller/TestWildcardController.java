package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("wildcard")
public class TestWildcardController {

    @RequestMapping("/test/**")
    @ResponseBody
    public String test1(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> /test/**");
        return String.valueOf(view);
    }

    @RequestMapping("/test/*")
    @ResponseBody
    public String test2(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> /test*");
        return String.valueOf(view);
    }

    @RequestMapping("test?")
    @ResponseBody
    public String test3(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> test?");
        return String.valueOf(view);
    }

//    @RequestMapping("test/*")
//    @ResponseBody
//    public String test4(ModelAndView view) {
//        view.setViewName("/test/test");
//        view.addObject("attr", "TestWildcardController -> test/*");
//        return String.valueOf(view);
//    }

}
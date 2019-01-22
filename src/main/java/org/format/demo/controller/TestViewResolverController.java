package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/17 10:46
 * @Description: 解析jsp和freemarker
 */
@Controller
@RequestMapping(value = "/tvrc")
public class TestViewResolverController {


    @RequestMapping("jsp")
    public ModelAndView jsp(ModelAndView view) {
        view.setViewName("jsp:tvrc/test");
        return view;
    }

    @RequestMapping("/ftl")
    public ModelAndView freemarker(ModelAndView view) {
        view.setViewName("freemarker:tvrc/test");
        return view;
    }

}
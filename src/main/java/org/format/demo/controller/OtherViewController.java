package org.format.demo.controller;

import org.format.demo.custom.MyExcelView;
import org.format.demo.custom.MyPdfView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/17 14:30
 * @Description:
 */
@Controller
@RequestMapping("otherview")
public class OtherViewController {
    @RequestMapping("/pdf")
    public ModelAndView mypdf() {
        ModelAndView mav = new ModelAndView();
        //添加自定义视图
        mav.setView(new MyPdfView());
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/excel")
    public ModelAndView myexcle() {
        ModelAndView mav = new ModelAndView();
        //添加视图
        mav.setView(new MyExcelView());
        List list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
        mav.addObject("list", list);
        return mav;
    }
}
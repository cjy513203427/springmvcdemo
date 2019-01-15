package org.format.demo.custom;

import org.format.demo.model.Dept;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/15 17:13
 * @Description:
 */
public class MyWebBindingInitializer implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Dept.class, new CustomDeptEditor());
    }

}
package org.format.demo.controlleradvice;

import org.format.demo.custom.CustomDeptEditor;
import org.format.demo.model.Dept;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/15 17:16
 * @Description:注册CustomEditor
 */
@ControllerAdvice
public class InitBinderControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Dept.class, new CustomDeptEditor());
    }

}
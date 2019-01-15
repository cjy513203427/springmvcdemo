package org.format.demo.custom;

import org.format.demo.model.Dept;

import java.beans.PropertyEditorSupport;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/15 17:10
 * @Description: 自定义的属性编辑器
 */
public class CustomDeptEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.indexOf(",") > 0) {
            Dept dept = new Dept();
            String[] arr = text.split(",");
            dept.setId(Integer.parseInt(arr[0]));
            dept.setName(arr[1]);
            setValue(dept);
        } else {
            throw new IllegalArgumentException("dept param is error");
        }
    }

}
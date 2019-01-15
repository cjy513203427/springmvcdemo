package org.format.demo.controller;

import org.format.demo.custom.CustomDeptEditor;
import org.format.demo.model.Dept;
import org.format.demo.model.Employee;
import org.format.demo.model.TestModel;
import org.format.demo.model.XmlActionResult;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/11 09:02
 * @Description:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Dept.class, new CustomDeptEditor());
    }

    /**
     * @Author 谷天乐
     * @Description 参数为Json类型，参数写在请求体里
     * @Date 2019/1/14 16:01
     * @Param [e]
     * @return org.format.demo.model.Employee
     **/
    @RequestMapping(value = "/testRb",produces={"application/json; charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public Employee testRb(@RequestBody Employee e) {
        return e;
    }

    /**
     * @Author 谷天乐
     * @Description 返回XML
     * @Date 2019/1/14 16:04
     * @Param [id, name]
     * @return org.format.demo.model.XmlActionResult<org.format.demo.model.Employee>
     **/
    @RequestMapping(value="/testCustomObj", produces={"application/xml; charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public XmlActionResult<Employee> testCustomObj(@RequestParam(value = "id") int id,
                                                   @RequestParam(value = "name") String name) {
        XmlActionResult<Employee> actionResult = new XmlActionResult<Employee>();
        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setAge(20);
        e.setDept(new Dept(2,"部门"));
        actionResult.setCode("200");
        actionResult.setMessage("Success with XML");
        actionResult.setData(e);
        return actionResult;
    }

    @RequestMapping(value = "/testCustomObjWithRp", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public Employee testCustomObjWithRp(Employee e) {
        return e;
    }

    @RequestMapping(value = "/testDate", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public Date testDate(Date date) {
        return date;
    }

    @RequestMapping(value = "/testWrapper", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public TestModel testWrapper() {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        //bw.setPropertyValue("good", "on");
        bw.setPropertyValue("good", "1");
        //bw.setPropertyValue("good", "true");
        //bw.setPropertyValue("good", "yes");
        return tm;
    }

    /**
     * @Author 谷天乐
     * @Description 抛出java.lang.IllegalStateException
     * @Date 2019/1/15 16:39
     * @Param []
     * @return org.format.demo.model.TestModel
     **/
    @RequestMapping(value = "/testNotUseWrapper", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public TestModel testNotUseWrapper() {
        TestModel tm = new TestModel();
        BeanWrapperImpl bw = new BeanWrapperImpl(false);
        bw.setWrappedInstance(tm);
        bw.setPropertyValue("good", "1");
        return tm;
    }

    @RequestMapping(value = "/testParam", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public Map testParam(boolean b) {
        Map map = new HashMap<String,String>();
        if(b) {
            map.put("attr", "b is true");
        } else {
            map.put("attr", "b is false");
        }
        return map;
    }
}
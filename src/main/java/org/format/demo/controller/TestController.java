package org.format.demo.controller;

import org.format.demo.model.Employee;
import org.format.demo.model.XmlActionResult;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
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
}
package org.format.demo.model;

import javax.xml.bind.annotation.*;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/14 14:59
 * @Description:
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlActionResult<T> extends BaseXmlResult{

    @XmlElements({
            @XmlElement(name="employee",type = Employee.class)
    })
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
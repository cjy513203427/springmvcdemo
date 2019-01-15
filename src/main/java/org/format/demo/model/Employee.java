package org.format.demo.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)*/
@Entity
@Table(name="t_employee")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Employee {
    @XmlElement
    private Integer id;
    @XmlElement
    private String name;
    @XmlElement
    private Integer age;
    @XmlElement
    private Dept dept;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToOne
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

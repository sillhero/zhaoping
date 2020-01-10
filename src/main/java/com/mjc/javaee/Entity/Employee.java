package com.mjc.javaee.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}16:09
 */
@Entity
public class Employee {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private String departmentId;
    private String positionId;

    @Id
    @Column(name = "ID", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Sex", nullable = true, length = 50)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "DepartmentID", nullable = true, length = 50)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "PositionID", nullable = true, length = 50)
    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(sex, employee.sex) &&
                Objects.equals(departmentId, employee.departmentId) &&
                Objects.equals(positionId, employee.positionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex, departmentId, positionId);
    }
}

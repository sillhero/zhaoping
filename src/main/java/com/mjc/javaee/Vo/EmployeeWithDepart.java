package com.mjc.javaee.Vo;

import com.mjc.javaee.Entity.Employee;

import javax.persistence.Entity;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:35
 */
@Entity
public class EmployeeWithDepart extends Employee{
    private String departmentName;
    private String positionName;
    private Double positionSalary;


    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(Double positionSalary) {
        this.positionSalary = positionSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

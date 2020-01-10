package com.mjc.javaee.Dao;

import com.mjc.javaee.Vo.EmployeeWithDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:36
 */
public interface EmpWithDepartDao extends JpaRepository<EmployeeWithDepart,String > {
    @Query(value = "select Employee.ID,Age,DepartmentID,Name,PositionID,Sex,Employee.DepartmentID,Department.DepartmentName,Position.PositionName,Position.PositionSalary from Employee,Department,Position where Employee.DepartmentID = Department.ID and Employee.PositionID = Position.ID and Employee.Name like %?1%",nativeQuery = true)
    List<EmployeeWithDepart> selectLikeName(String name);
}

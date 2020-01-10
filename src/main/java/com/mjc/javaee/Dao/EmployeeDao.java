package com.mjc.javaee.Dao;

import com.mjc.javaee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}0:27
 */
public interface EmployeeDao extends JpaRepository<Employee,String> {
    @Query(value = "DELETE from Employee where ID = ?1",nativeQuery = true)
    @Modifying
    void deletByID(String id);

}

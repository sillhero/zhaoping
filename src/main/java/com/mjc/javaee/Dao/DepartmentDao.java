package com.mjc.javaee.Dao;


import com.mjc.javaee.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}15:03
 */
public interface DepartmentDao extends JpaRepository<Department, String> {
}

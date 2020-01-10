package com.mjc.javaee.Service;


import com.mjc.javaee.Dao.EmpWithDepartDao;
import com.mjc.javaee.Dao.EmployeeDao;
import com.mjc.javaee.Entity.Employee;
import com.mjc.javaee.Vo.EmployeeWithDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}0:27
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    EmpWithDepartDao empWithDepartDao;

    public void addEmployee(Employee employee){
        employeeDao.save(employee);
    }

    public void deleteEmp(String id){
        employeeDao.deletByID(id);
    }

    public void update(Employee employee){
        employeeDao.save(employee);
    }

    public List<EmployeeWithDepart> getByLike(String name){
        return empWithDepartDao.selectLikeName(name);
    }
}

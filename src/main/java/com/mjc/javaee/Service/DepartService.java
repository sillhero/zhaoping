package com.mjc.javaee.Service;

import com.mjc.javaee.Dao.DepartmentDao;
import com.mjc.javaee.Entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}15:05
 */
@Service
@Transactional
public class DepartService {
    @Autowired
    private DepartmentDao departmentDao;

    public void addDepart(Department department){
        departmentDao.save(department);
    }

    public List<Department> findAll(){
        return departmentDao.findAll();
    }

    public void updateDepart(Department department){
        departmentDao.save(department);
    }

    public void deletDepart(String id){
        departmentDao.deleteById(id);
    }
}

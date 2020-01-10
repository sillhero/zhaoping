package com.mjc.javaee.Controller;

import com.mjc.javaee.Entity.Employee;
import com.mjc.javaee.Service.EmployeeService;
import com.mjc.javaee.Utils.CommonUtils;
import com.mjc.javaee.Utils.Msg;
import com.mjc.javaee.Vo.EmployeeWithDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:44
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    @PostMapping
    public Msg addEmployee(@RequestBody Employee employee){
        employee.setId(CommonUtils.getUUID());
        employeeService.addEmployee(employee);
        return Msg.success().add("msg","添加成功");
    }

    /**
     * 通过姓名模糊查询员工信息
     * @param name
     * @return
     */
    @GetMapping
    public Msg selecByName(@RequestParam String name){
        List<EmployeeWithDepart> employeeWithDeparts = employeeService.getByLike(name);
        return Msg.success().add("msg",employeeWithDeparts);
    }

    /**
     * 更新员工
     * @param employee
     * @return
     */
    @PutMapping
    public Msg updateEmployee(@RequestBody Employee employee){
        employeeService.update(employee);
        return Msg.success().add("msg","更改成功");
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping
    public Msg deleteEmployee(@RequestParam String id){
        employeeService.deleteEmp(id);
        return Msg.success().add("msg","删除成功");
    }
}

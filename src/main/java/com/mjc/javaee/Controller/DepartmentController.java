package com.mjc.javaee.Controller;

import com.mjc.javaee.Entity.Department;
import com.mjc.javaee.Service.DepartService;
import com.mjc.javaee.Utils.CommonUtils;
import com.mjc.javaee.Utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}15:08
 */
@RestController
@RequestMapping("/depart")
public class DepartmentController {
    @Autowired
    private DepartService departService;

    /**
     * 添加部门
     * @param department
     * @return
     */
    @PostMapping
    public Msg addDepart(@RequestBody Department department){
        department.setId(CommonUtils.getUUID());
        departService.addDepart(department);
        return Msg.success().add("msg","添加成功");
    }

    /**
     * 显示全部信息
     * @return
     */
    @GetMapping
    public Msg selectAll(){
        return Msg.success().add("msg",departService.findAll());
    }


    /**
     * 编辑部门信息
     * @param department
     * @return
     */
    @PutMapping
    public Msg updateDepart(@RequestBody Department department){
        departService.updateDepart(department);
        return Msg.success().add("msg","更新成功");
    }

    /**
     * 删除部门信息
      * @param id
     * @return
     */
    @DeleteMapping
    public Msg deleteDepart(@RequestParam String id){
        departService.deletDepart(id);
        return Msg.success().add("msg","删除成功");
    }

}

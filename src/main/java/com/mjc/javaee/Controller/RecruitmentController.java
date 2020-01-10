package com.mjc.javaee.Controller;

import com.mjc.javaee.Entity.Recruitment;
import com.mjc.javaee.Entity.Resume;
import com.mjc.javaee.Service.EmployeeService;
import com.mjc.javaee.Service.RecruitmentService;
import com.mjc.javaee.Service.ResumeService;
import com.mjc.javaee.Utils.CommonUtils;
import com.mjc.javaee.Utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:51
 */
@RestController
@RequestMapping("/recruit")
public class RecruitmentController {
    @Autowired
    RecruitmentService recruitmentService;
    @Autowired
    ResumeService resumeService;
    @Autowired
    EmployeeService employeeService;

    /**
     * 添加招聘信息
     * @param recruitment
     * @return
     */
    @PostMapping
    public Msg addRecruit(@RequestBody Recruitment recruitment){
        recruitment.setId(CommonUtils.getUUID());
        recruitmentService.addRecruitment(recruitment);
        return Msg.success().add("msg","添加成功");
    }

    /**
     * 根据职位名称获取相应的信息
     * @param name
     * @return
     */
    @GetMapping("/get")
    public Msg getByName(@RequestParam String name){
        return Msg.success().add("msg",recruitmentService.selectByName(name));
    }

    /**
     * 根据招聘ID进行删除
     * @param id
     * @return
     */
    @DeleteMapping
    public Msg deleteById(@RequestParam String id){
        recruitmentService.deleteByID(id);
        return Msg.success().add("msg","删除成功");
    }

    /**
     * 编辑招聘信息
     * @param recruitment
     * @return
     */
    @PutMapping
    public Msg update(@RequestBody Recruitment recruitment){
        recruitmentService.addRecruitment(recruitment);
        return Msg.success().add("msg","更新成功");
    }

    /**
     * 根据招聘信息ID获取所对应的简历信息
     * @param id
     * @return
     */
    @GetMapping("/resume")
    public Msg getByRecrutmentID(@RequestParam String id){
        return Msg.success().add("msg",resumeService.selectByRecrutmentID(id));
    }

    /**
     * 通过简历信息
     * @param id
     * @return
     */
    @GetMapping("/pass")
    public Msg PassResume(@RequestParam String id){//简历的ID
        Resume resume = resumeService.getByID(id);
        if (resume.getIsPass().equals("审核通过")){
            return Msg.fail().add("msg","审核已通过,请勿重复操作");
        }
        resumeService.updatePass(id);
        recruitmentService.updateNum(resume.getRecrutmentId());
        return Msg.success().add("msg","审核成功,请准备面试");
    }
}

package com.mjc.javaee.Controller;

import com.mjc.javaee.Entity.Resume;
import com.mjc.javaee.Service.ResumeService;
import com.mjc.javaee.Utils.CommonUtils;
import com.mjc.javaee.Utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}10:32
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    ResumeService resumeService;

    /**
     * 根据名称获取对应的简历信息
     * @param name
     * @return
     */
    @GetMapping("/get")
    public Msg getByName(@RequestParam String name){
        return Msg.success().add("msg",resumeService.selectAllByName(name));
    }

    /**
     * 添加简历信息
     * @param resume
     * @param request
     * @return
     */
    @PostMapping
    public Msg addResume(@RequestBody Resume resume,HttpServletRequest request){
        resume.setId(CommonUtils.getUUID());
        resume.setIsPass("待审核");
        resume.setUserName(request.getHeader("token"));
        resumeService.addResume(resume);
        return Msg.success().add("msg","添加成功");
    }

    /**
     * 编辑简历信息
     * @param resume
     * @return
     */
    @PutMapping
    public Msg update(@RequestBody Resume resume){
        resumeService.updateResume(resume);
        return Msg.success().add("msg","更新成功");
    }

    /**
     * 根据ID删除简历信息
     * @param id
     * @return
     */
    @DeleteMapping
    public Msg delete(@RequestParam String id){
        resumeService.deleteResume(id);
        return Msg.success().add("msg","删除成功");
    }

    /**
     * 根据用户名显示对应的简历信息
     * @param request
     * @return
     */
    @GetMapping("/username")
    public Msg getByUserName(HttpServletRequest request){
        return Msg.success().add("msg",resumeService.getByUserName(request.getHeader("token")));
    }
}

package com.mjc.javaee.Controller;


import com.mjc.javaee.Entity.Position;
import com.mjc.javaee.Service.PositionService;
import com.mjc.javaee.Utils.CommonUtils;
import com.mjc.javaee.Utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}16:48
 */
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    /**
     * 添加职位信息
     * @param position
     * @return
     */
    @PostMapping
    public Msg addPosition(@RequestBody Position position){
        position.setId(CommonUtils.getUUID());
        positionService.addPosition(position);
        return Msg.success().add("msg","添加成功");
    }

    /**
     * 显示所有职务信息
     * @return
     */
    @GetMapping
    public Msg selectAll(){
        return Msg.success().add("msg",positionService.selectAll());
    }

    /**
     * 更新职位信息
     * @param position
     * @return
     */
    @PutMapping
    public Msg update(@RequestBody Position position){
        positionService.update(position);
        return Msg.success().add("msg","更新成功");
    }

    /**
     * 删除职位信息
     * @param id
     * @return
     */
    @DeleteMapping
    public Msg delete(@RequestParam String id){
        positionService.deletByID(id);
        return Msg.success().add("msg","删除成功");
    }

    /**
     * 根据名称进行查询
     * @param name
     * @return
     */
    @GetMapping("/get")
    public Msg getByName(@RequestParam String name){
        return Msg.success().add("msg",positionService.getByName(name));
    }

}

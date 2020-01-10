package com.mjc.javaee.Controller;

import com.mjc.javaee.Entity.User;
import com.mjc.javaee.Service.UserService;
import com.mjc.javaee.Utils.CommonUtils;
import com.mjc.javaee.Utils.MD5;
import com.mjc.javaee.Utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}20:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Msg saveUser(@RequestBody User user) throws Exception {
        if (userService.getByUserName(user.getUserName())==null) {
            user.setUserId(CommonUtils.getUUID());
            user.setPassWord(MD5.md5Encode(user.getPassWord()));
            user.setRole("普通用户");
            userService.addUser(user);
            return Msg.success().add("msg", "注册成功");
        }else {
            return Msg.fail().add("msg","用户名已注册");
        }
    }

    @GetMapping
    public Msg selectAll(){
        return Msg.success().add("msg",userService.selectAllUser());
    }

    @DeleteMapping
    public Msg deleteByID(@RequestParam String id){
        userService.deleteByID(id);
        return Msg.success().add("msg","删除成功");
    }

    @PutMapping
    public Msg update(@RequestBody User user)throws Exception{
        user.setPassWord(MD5.md5Encode(user.getPassWord()));
        userService.update(user);
        return Msg.success().add("msg","更新成功");
    }

    @GetMapping("/password")
    public Msg getPassword(@RequestParam String name){
        String password = userService.getPasswordByUserName(name);
        return Msg.success().add("msg",password);
    }
}

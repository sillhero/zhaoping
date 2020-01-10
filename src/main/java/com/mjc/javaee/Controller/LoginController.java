package com.mjc.javaee.Controller;

import com.mjc.javaee.Service.UserService;
import com.mjc.javaee.Utils.MD5;
import com.mjc.javaee.Utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}16:01
 */
@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    UserService userService;

    /**
     * 登录接口
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping
    public Msg LoginUser(@RequestBody Map<String,Object> map)throws Exception{
        String password = userService.getPasswordByUserName((String) map.get("username"));
        if (password==null||password.equals("")){
            return Msg.fail().add("msg","无此用户，请输入正确的用户名");
        }
        if (password.equals(MD5.md5Encode((String)map.get("password")))){
            return Msg.success().add("msg",userService.getByUserName((String)map.get("username")));
        }else {
            return Msg.fail().add("msg","登录失败，密码错误");
        }
    }
}

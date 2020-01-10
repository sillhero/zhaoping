package com.mjc.javaee.Filter;
import com.mjc.javaee.Service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName graduation
 * @Description: TODO
 * @date ${DAT}15:35
 */
@Component
public class ParamInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token==null||token.equals("")){
            returnErrorContent(401,response,"用户信息失效或者未登录请返回登录页面");
            return false;
        }else {
            String password = userService.getPasswordByUserName(token);
            if (password != null && !password.equals("")) {
                return true;
            } else {
                returnErrorContent(401, response, "用户信息失效或者未登录请返回登录页面");
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    private void returnErrorContent(int code, HttpServletResponse response, String msg) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(code);

        ServletOutputStream out=null;
        try {
            JSONObject res = new JSONObject();
            res.put("status", code);
            res.put("msg", msg);
            out = response.getOutputStream();
            out.write(res.toString().getBytes("utf-8"));
            out.flush();
            out.close();
        } catch (IOException e) {

        }

    }
}

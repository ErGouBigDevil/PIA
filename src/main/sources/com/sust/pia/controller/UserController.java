package com.sust.pia.controller;

import com.alibaba.fastjson.JSONObject;
import com.sust.pia.model.User;
import com.sust.pia.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Package com.sust.pia.controller
 * @Description 与User数据相关的Controller层 实现登录验证以及用户注册功能
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 15:54
 */
@Controller
@RequestMapping ( "/user" )
public class UserController {
    @Resource(name = "userService")
    IUserService userService;

    Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/4 16:42
     * @Param out
     * @Param response
     * @Return void
     */
    protected void writeJSON2Response(Object out, HttpServletResponse response) {
        try {
            response.getWriter().print(out);
            log.debug("SERVER TO FRONT END:" + out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/4 16:41
     * @Param username
     * @Param password
     * @Param request
     * @Param response
     * @Return void
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public void userLogin(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          HttpServletRequest request, HttpServletResponse response) {
        log.debug("FRONT END TO SERVER: " + username + " " + password);
        JSONObject resultJson = new JSONObject();
        if (userService.findByNameAndPassword(username, password) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            resultJson.put("result", true);
        } else {
            resultJson.put("result", false);
        }
        writeJSON2Response(resultJson, response);
    }


    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/4 16:40
     * @Param user
     * @Param response
     * @Return void
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public void userRegister(@RequestBody User user, HttpServletResponse response) {
        System.out.println(user.toString());
        JSONObject resultJson = new JSONObject();
        log.debug("SAVE TO DB: " + user);
        if (userService.insertUser(user) > 0)
            resultJson.put("result", true);
        else
            resultJson.put("result", false);
        writeJSON2Response(resultJson, response);
    }



    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/4 16:42
     * @Param username
     * @Param response
     * @Return void
     */
    @PostMapping(value = "/isRegistered")
    @ResponseBody
    public void isRegistered(String username, HttpServletResponse response) {
        JSONObject resultJson = new JSONObject();
        if (userService.findUserByName(username) == null)
            resultJson.put("result", true);
        else
            resultJson.put("result", false);
        writeJSON2Response(resultJson, response);
    }

    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/4 16:42
     * @Param request
     * @Return java.lang.String
     */
    @PostMapping(value="/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }

}



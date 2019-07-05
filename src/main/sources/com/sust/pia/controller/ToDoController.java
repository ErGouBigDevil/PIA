package com.sust.pia.controller;

import com.alibaba.fastjson.JSONObject;
import com.sust.pia.model.DataList;
import com.sust.pia.model.ToDo;
import com.sust.pia.model.User;
import com.sust.pia.service.IToDoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Package com.sust.pia.controller
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 18:43
 */
@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Resource(name = "toDoService")
    IToDoService toDoService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/5 19:03
     * @Param out
     * @Param response
     * @Return void
     */
    private void writeJSON2Response(Object out, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            log.debug("SERVER[ToDoController] to Front End: " + out);
            response.getWriter().print(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/5 19:04
     * @Param limit
     * @Param offset
     * @Param sort
     * @Param order
     * @Param request
     * @Param response
     * @Return void
     */
    @GetMapping(value = "/getAllInfo")
    @ResponseBody
    public void getAllInfo(@RequestParam(value = "limit", defaultValue = "10") Integer limit,
                           @RequestParam(value = "offset", defaultValue = "1") Integer offset,
                           @RequestParam(value = "sort") String sort,
                           @RequestParam(value = "order") String order,
                           HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("userObj");
        log.debug("SERVER[ToDoController] Get user: " + user);
        int size = toDoService.count(user.getId());
        DataList<ToDo> toDoList = new DataList<>();
        List<ToDo> list = toDoService.findAllData(user.getId(), offset, limit, sort, order);
        if (list != null) {
            toDoList.setRows(list);
            toDoList.setTotal(size);
        }
        writeJSON2Response(toDoList.toString(), response);
    }

    /**
     * @Description
     * @Author Haodong Zhao
     * @Date 2019/7/5 23:47
     * @Param toDo
     * @Param request
     * @Param response
     * @Return void
     */
    @PostMapping(value = "/insertData")
    @ResponseBody
    public void insertData(@RequestBody ToDo toDo, HttpServletRequest request,
                           HttpServletResponse response) {
        toDo.setUserId(((User) request.getSession().getAttribute("userObj")).getId());
        log.debug("SERVER[ToDoController] Get ToDo: " + toDo.toString());
        JSONObject result = new JSONObject();
        if (toDoService.insert(toDo) > 0)
            result.put("flag", true);
        else
            result.put("flag", false);
        writeJSON2Response(result, response);
    }



}

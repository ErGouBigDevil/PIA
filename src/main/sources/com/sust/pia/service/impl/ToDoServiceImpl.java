package com.sust.pia.service.impl;

import com.sust.pia.dao.IToDoDao;
import com.sust.pia.model.ToDo;
import com.sust.pia.service.IToDoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Package com.sust.pia.service.impl
 * @Description 待办事务管理Service层
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 15:12
 */
@Service("toDoService")
public class ToDoServiceImpl implements IToDoService {

    @Resource
    private IToDoDao toDoDao;

    @Override
    public List<ToDo> findByKeyword(Integer userId, String keyWord) {
        return toDoDao.findByKeyword(userId,keyWord);
    }

    @Override
    public List<ToDo> findByTime(Date startTime, Date endTime, Integer userId) {
        return toDoDao.findByTime(startTime,endTime,userId);
    }

    @Override
    public int insert(ToDo obj) {
        return toDoDao.insert(obj);
    }

    @Override
    public int delete(Integer id) {
        return toDoDao.delete(id);
    }

    @Override
    public int update(ToDo obj) {
        return toDoDao.update(obj);
    }

    @Override
    public ToDo findById(Integer id) {
        return toDoDao.findById(id);
    }

    @Override
    public List<ToDo> findAllData(Integer userId, Integer offset, Integer rows, String sort, String order) {
        return toDoDao.findAllData(userId,offset,rows,sort,order);
    }

    @Override
    public List<ToDo> findAll(Integer userId) {
        return toDoDao.findAll(userId);
    }

    @Override
    public int count(Integer userId) {
        return toDoDao.count(userId);
    }
}

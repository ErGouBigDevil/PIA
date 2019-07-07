package com.sust.pia.service.impl;

import com.sust.pia.dao.IUserDao;
import com.sust.pia.model.User;
import com.sust.pia.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Package com.sust.pia.service.impl
 * @Description 用户管理Service层
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 11:09
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User findByNameAndPassword(String username, String password) {
        return userDao.findByNameAndPassword(username, password);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}

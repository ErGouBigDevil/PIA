package com.sust.pia.service;

import com.sust.pia.model.User;

/**
 * @Package com.sust.pia.service
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 10:58
 */
public interface IUserService {
    User findByNameAndPassword(String username, String password);

    int insertUser(User user);

    User findUserByName(String username);
}

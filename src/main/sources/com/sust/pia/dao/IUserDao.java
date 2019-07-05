package com.sust.pia.dao;

import com.sust.pia.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层 用户管理IUserDao接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 10:31
 */
public interface IUserDao {
    User findByNameAndPassword(@Param(value="username") String username, @Param(value="password") String password);
    int insertUser(User user);
    User findUserByName(String username);

}

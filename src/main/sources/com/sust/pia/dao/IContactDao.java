package com.sust.pia.dao;

import com.sust.pia.model.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层 事务管理IContactDao接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/6 22:05
 */
public interface IContactDao extends IMBaseDao<Contact> {
    List<Contact> findByKeyword(@Param(value = "userId") Integer userId,
                                @Param(value = "keyWord") String keyWord);

    List<Contact> findByName(@Param(value = "userId") Integer userId,
                             @Param(value = "name") String name);

}

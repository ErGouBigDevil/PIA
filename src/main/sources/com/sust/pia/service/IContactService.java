package com.sust.pia.service;


import com.sust.pia.model.Contact;
import com.sust.pia.model.ToDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.service
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/6 23:33
 */
public interface IContactService extends IMBaseService<Contact> {
    List<Contact> findByKeyword(@Param(value = "userId") Integer userId,
                                @Param(value = "keyWord") String keyWord);

    List<Contact> findByName(@Param(value = "userId") Integer userId,
                             @Param(value = "name") String name);

}

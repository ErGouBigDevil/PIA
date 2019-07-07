package com.sust.pia.service;


import com.sust.pia.model.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.service
 * @Description 联系人管理基础Service接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/6 23:33
 */
public interface IContactService extends IMBaseService<Contact> {
    List<Contact> findByKeyword(@Param(value = "userId") Integer userId,
                                @Param(value = "keyWord") String keyWord);

    List<Contact> findByName(@Param(value = "userId") Integer userId,
                             @Param(value = "name") String name);

}

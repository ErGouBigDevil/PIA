package com.sust.pia.dao;

import com.sust.pia.model.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层 联系人管理IContactDao接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/6 22:05
 */
public interface IContactDao extends IMBaseDao<Contact> {
    /**
     * @Description 按照关键字搜索联系人信息
     * @Author Haodong Zhao
     * @Date 2019/7/7 15:46
     * @Param userId 用户id
     * @Param keyWord 关键字
     * @Return java.util.List<com.sust.pia.model.Contact>
     */
    List<Contact> findByKeyword(@Param(value = "userId") Integer userId,
                                @Param(value = "keyWord") String keyWord);

    /**
     * @Description 按照姓名搜索联系人信息
     * @Author Haodong Zhao
     * @Date 2019/7/7 15:46
     * @Param userId 用户id
     * @Param name 姓名
     * @Return java.util.List<com.sust.pia.model.Contact>
     */
    List<Contact> findByName(@Param(value = "userId") Integer userId,
                             @Param(value = "name") String name);

}

package com.sust.pia.dao;

import com.sust.pia.model.ToDo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层 事务管理IToDoDao接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 14:10
 */
public interface IToDoDao extends IMBaseDao<ToDo> {

    /**
     * @Description 按照关键字搜索事务
     * @Author Haodong Zhao
     * @Date 2019/7/7 15:45
     * @Param userId 用户id
     * @Param keyWord 关键字
     * @Return java.util.List<com.sust.pia.model.ToDo>
     */
    List<ToDo> findByKeyword(@Param(value = "userId") Integer userId,
                             @Param(value = "keyWord") String keyWord);

    /**
     * @Description 搜索指定范围内的事务信息
     * @Author Haodong Zhao
     * @Date 2019/7/7 15:45
     * @Param startTime 开始时间
     * @Param endTime 结束时间
     * @Param userId 用户id
     * @Return java.util.List<com.sust.pia.model.ToDo>
     */
    List<ToDo> findByTime(@Param(value = "startTime") Date startTime,
                          @Param(value = "endTime") Date endTime,
                          @Param(value = "userId") Integer userId);
}

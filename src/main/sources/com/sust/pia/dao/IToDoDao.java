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

    List<ToDo> findByKeyword(Integer userId, String keyWord);

    List<ToDo> findByTime(@Param(value = "startTime") Date startTime,
                          @Param(value = "endTime") Date endTime,
                          @Param(value = "userId") Integer userId);
}

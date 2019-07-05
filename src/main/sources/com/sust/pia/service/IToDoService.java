package com.sust.pia.service;

import com.sust.pia.model.ToDo;

import java.util.Date;
import java.util.List;

/**
 * @Package com.sust.pia.service.impl
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 15:12
 */
public interface IToDoService extends IMBaseService<ToDo>{

    List<ToDo> findByKeyword(Integer userId, String keyWord);

    List<ToDo> findByTime(Date startTime, Date endTime, Integer userId);

}

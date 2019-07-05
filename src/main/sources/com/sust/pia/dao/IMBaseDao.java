package com.sust.pia.dao;

import com.sust.pia.model.ToDo;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层  管理DAO基础类
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 14:07
 */
public interface IMBaseDao<T> {
    int insert(T obj);

    int delete(Integer id);

    int update(T obj);

    ToDo findById(Integer id);

    List<T> findAllData(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset,
                    @Param(value = "rows") Integer rows,
                    @Param(value = "sort") String sort,
                    @Param(value = "order") String order);

    List<T> findAll(Integer userId);

    int count(Integer userId);
}

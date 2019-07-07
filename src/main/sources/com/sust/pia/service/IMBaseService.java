package com.sust.pia.service;

import java.util.List;

/**
 * @Package com.sust.pia.service
 * @Description 数据管理基础Service接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 15:14
 */
public interface IMBaseService<T> {
    int insert(T obj);

    int delete(Integer id);

    int update(T obj);

    T findById(Integer id);

    List<T> findAllData(Integer userId, Integer offset,
                        Integer rows, String sort, String order);

    List<T> findAll(Integer userId);

    int count(Integer userId);
}

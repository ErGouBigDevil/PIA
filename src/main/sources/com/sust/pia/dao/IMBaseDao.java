package com.sust.pia.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层  管理DAO基础类
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 14:07
 */
public interface IMBaseDao<T> {
    /**
     * @Description 添加数据基础函数
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:35
     * @Param obj 数据类
     * @Return int 添加的行数
     */
    int insert(T obj);

    /**
     * @Description 删除数据基础函数
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:35
     * @Param id 待删除的数据信息id
     * @Return int 修改的行数
     */
    int delete(Integer id);

    /**
     * @Description 更新数据基础函数
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:36
     * @Param obj 待更新的数据类
     * @Return int 修改的行数
     */
    int update(T obj);

    /**
     * @Description 按数据类id搜索基础函数
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:39
     * @Param id 待搜索的数据信息id
     * @Return T
     */
    T findById(Integer id);

    /**
     * @Description 分页数据基础函数
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:40
     * @Param userId 用户id
     * @Param offset
     * @Param rows
     * @Param sort 排序
     * @Param order 顺序
     * @Return java.util.List<T>
     */
    List<T> findAllData(@Param(value = "userId") Integer userId,
                        @Param(value = "offset") Integer offset,
                        @Param(value = "rows") Integer rows,
                        @Param(value = "sort") String sort,
                        @Param(value = "order") String order);


    /**
     * @Description 按照用户id搜索全部数据
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:42
     * @Param userId
     * @Return java.util.List<T>
     */
    List<T> findAll(Integer userId);

    /**
     * @Description 计数基础函数
     * @Author Haodong Zhao
     * @Date 2019/7/5 15:43
     * @Param userId 用户id
     * @Return int 修改的行数
     */
    int count(Integer userId);
}

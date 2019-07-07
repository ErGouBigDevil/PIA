package com.sust.pia.dao;

import com.sust.pia.model.Pass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description DAO层 密码管理IPassDao接口
 * @Author Haodong Zhao
 * @Datetime 2019/7/7 13:23
 */

public interface IPassDao extends IMBaseDao<Pass> {
    /**
     * @Description 按照网站搜索密码信息
     * @Author Haodong Zhao
     * @Date 2019/7/7 15:44
     * @Param userId 用户id
     * @Param website 网站名
     * @Return java.util.List<com.sust.pia.model.Pass>
     */
    List<Pass> findByWebsite(@Param(value = "userId") Integer userId,
                             @Param(value = "website") String website);
}

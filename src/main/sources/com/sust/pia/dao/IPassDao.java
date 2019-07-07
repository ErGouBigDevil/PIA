package com.sust.pia.dao;

import com.sust.pia.model.Pass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.dao
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/7 13:23
 */

public interface IPassDao extends IMBaseDao<Pass> {
    List<Pass> findByWebsite(@Param(value = "userId") Integer userId,
                             @Param(value = "website") String website);
}

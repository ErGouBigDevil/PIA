package com.sust.pia.service;

import com.sust.pia.dao.IMBaseDao;
import com.sust.pia.model.Pass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package com.sust.pia.service
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/7 13:37
 */
public interface IPassService extends IMBaseDao<Pass> {
    List<Pass> findByWebsite(@Param(value = "userId") Integer userId,
                             @Param(value = "website") String website);

}

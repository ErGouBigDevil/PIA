package com.sust.pia.service.impl;

import com.sust.pia.dao.IPassDao;
import com.sust.pia.model.Pass;
import com.sust.pia.service.IPassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package com.sust.pia.service.impl
 * @Description 密码管理Service层
 * @Author Haodong Zhao
 * @Datetime 2019/7/7 13:38
 */

@Service("passService")
public class PassService implements IPassService {

    @Resource
    private IPassDao passDao;

    @Override
    public List<Pass> findByWebsite(Integer userId, String keyWord) {
        return passDao.findByWebsite(userId, keyWord);
    }

    @Override
    public int insert(Pass obj) {
        return passDao.insert(obj);
    }

    @Override
    public int delete(Integer id) {
        return passDao.delete(id);
    }

    @Override
    public int update(Pass obj) {
        return passDao.update(obj);
    }

    @Override
    public Pass findById(Integer id) {
        return passDao.findById(id);
    }

    @Override
    public List<Pass> findAllData(Integer userId, Integer offset, Integer rows, String sort, String order) {
        return passDao.findAllData(userId, offset, rows, sort, order);
    }

    @Override
    public List<Pass> findAll(Integer userId) {
        return passDao.findAll(userId);
    }

    @Override
    public int count(Integer userId) {
        return passDao.count(userId);
    }
}

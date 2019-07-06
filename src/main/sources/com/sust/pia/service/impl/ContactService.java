package com.sust.pia.service.impl;

import com.sust.pia.dao.IContactDao;
import com.sust.pia.model.Contact;
import com.sust.pia.model.ToDo;
import com.sust.pia.service.IContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package com.sust.pia.service.impl
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/6 23:37
 */
@Service("contactService")
public class ContactService implements IContactService {
    @Resource
    private IContactDao contactDao;


    @Override
    public List<Contact> findByKeyword(Integer userId, String keyWord) {
        return contactDao.findByKeyword(userId, keyWord);
    }

    @Override
    public List<Contact> findByName(Integer userId, String name) {
        return contactDao.findByName(userId, name);
    }

    @Override
    public int insert(Contact obj) {
        return contactDao.insert(obj);
    }

    @Override
    public int delete(Integer id) {
        return contactDao.delete(id);
    }

    @Override
    public int update(Contact obj) {
        return contactDao.update(obj);
    }

    @Override
    public Contact findById(Integer id) {
        return contactDao.findById(id);
    }

    @Override
    public List<Contact> findAllData(Integer userId, Integer offset, Integer rows, String sort, String order) {
        return contactDao.findAllData(userId, offset, rows, sort, order);
    }

    @Override
    public List<Contact> findAll(Integer userId) {
        return contactDao.findAll(userId);
    }

    @Override
    public int count(Integer userId) {
        return contactDao.count(userId);
    }
}

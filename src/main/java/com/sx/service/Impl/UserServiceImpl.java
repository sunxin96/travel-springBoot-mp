package com.sx.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sx.dao.UserDao;
import com.sx.entity.User;
import com.sx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-29 17:52
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> findPage(User condition, int pageNum, int pageSize) {

        if (condition.getName() == null && condition.getEmail() == null) {
            return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
                userDao.selectList(Wrappers.<User>query());
            });
        } else if (condition.getEmail() == null) {
            return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
                userDao.selectList(Wrappers.<User>query().like("name", condition.getName()));
            });
        }else if (condition.getName() == null){
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->{
               userDao.selectList(Wrappers.<User>query().like("email",condition.getEmail()));
            });
        } else {
            return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
                userDao.selectList(Wrappers.<User>query().like("name", condition.getName()).like("email", condition.getEmail()));
            });
        }

    }

    @Override
    public List<User> find(User condition) {
        return userDao.selectList(Wrappers.query());

    }

    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int update(User user) {
        return userDao.updateById(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public Integer batchDelete(List<Integer> id) {
        return userDao.deleteBatchIds(id);
    }


}

package com.sx.service;

import com.github.pagehelper.PageInfo;
import com.sx.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-29 17:51
 * @Modified By:
 */

@Service
public interface UserService {
    /**
     * 分页查询
     * @param condition 查询条件
     * @return
     */
    public PageInfo<User> findPage(User condition, int pageNum, int pageSize);
    /**
     * 查询
     * @param condition 查询条件
     * @return
     */
    public List<User> find(User condition);
    /**
     * 添加
     * @param user
     * @return
     */
    public int add(User user);
    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);
    /**
     * 修改
     * @param user
     * @return
     */
    public int update(User user);
    /**
     * 删除
     实现类
     注意：分页方法采用的lambda表达式的写法
     测试
     * @param id
     * @return
     */
    public int delete(Integer id);


    Integer batchDelete(List<Integer> id);
}

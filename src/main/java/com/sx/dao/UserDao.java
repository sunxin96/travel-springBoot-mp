package com.sx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.sx.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-29 17:26
 * @Modified By:
 */

@Repository
public interface UserDao extends BaseMapper<User> {

}

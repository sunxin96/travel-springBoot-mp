package com.sx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.entity.Route;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-01 22:06
 * @Modified By:
 */

@Repository
public interface RouteDao extends BaseMapper<Route> {


    /**
     * 分页查询
     *
     * @param route
     * @return
     */
    public List<Route> find(Route route);

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */

    public Route findById(Integer id);
}

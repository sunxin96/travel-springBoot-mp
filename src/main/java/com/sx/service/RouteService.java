package com.sx.service;

import com.github.pagehelper.PageInfo;
import com.sx.entity.Route;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-02 18:41
 * @Modified By:
 */
@Service
public interface RouteService {

    /**
     * 分页查询
     * @param route 查询条件
     * @return
     */
    public PageInfo<Route> findPage(Route route, int pageNum, int pageSize);
    /**
     * 添加
     * @param route
     * @return
     */
    public int add(Route route);
    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public Route findById(Integer id);
    /**
     * 修改
     * @param route
     * @return
     */
    public int update(Route route);
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);
}

package com.sx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sx.dao.RouteDao;
import com.sx.entity.Route;
import com.sx.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-02 18:43
 * @Modified By:
 */
@Service
public class RouteServiceImpl implements RouteService {



    @Autowired
    private RouteDao routeDao;

    @Override
    public PageInfo<Route> findPage(Route route, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            routeDao.find(route);
        });
    }

    /**b
     * 添加
     *
     * @param route
     * @return
     */
    @Override
    public int add(Route route) {
        return routeDao.insert(route);
    }
   /* @Override
    public int add(Route route) {
        return routeDao.insert(route);
    }*/


    @Override
    public Route findById(Integer id) {
        return routeDao.findById(id);
    }
    @Override
    public int update(Route route) {
        return routeDao.updateById(route);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return routeDao.deleteById(id);
    }
}

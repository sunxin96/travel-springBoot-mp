package com.sx.dao;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sx.entity.Route;
import com.sx.entity.RouteImg;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-02 17:22
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteImgDaoTest extends TestCase {


    @Autowired
    private RouteImgDao routeImgDao ;

    @Autowired
    private RouteDao routeDao;

    @Test
    public void select(){
        Route route = routeDao.findById(245);
        List<RouteImg> routeImgList = route.getRouteImgList();
        for (RouteImg routeImg : routeImgList) {
            System.out.println(routeImg);
        }
    }

    @Test
    public void test(){
        List<RouteImg> routeImgList = routeImgDao.findByRid(249);
        System.out.println(routeImgList.size());
    }

    @Test
    public void test02(){
        RouteImg byId = routeImgDao.findById();
        System.out.println(byId);
    }



    @Test
    public void test04(){
        List<RouteImg> routeImgs = routeImgDao.selectList(Wrappers.<RouteImg>query());
    }

    @Test
    public void insert(){
        RouteImg routeImg = new RouteImg();
        routeImg.setBigPic("111");
        routeImg.setSmallPic("222");
        routeImg.setRid(250);
        routeImgDao.insert(routeImg);
    }

    @Test
    public void delete(){
        int rgid = routeImgDao.delete(Wrappers.<RouteImg>query().eq("rgid", 2143));
        System.out.println(rgid);
    }
}
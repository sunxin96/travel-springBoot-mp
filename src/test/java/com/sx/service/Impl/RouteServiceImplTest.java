package com.sx.service.Impl;

import com.github.pagehelper.PageInfo;
import com.sx.entity.Route;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-02 21:10
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteServiceImplTest extends TestCase {

    @Autowired
    private RouteServiceImpl service;

    @Test
    public void findPage() {
        Route route = new Route();
        route.setRname("北京");
        PageInfo<Route> page = service.findPage(route, 1, 40);
        page.getList().forEach((r) -> {
            System.out.println(r.getRid() + "\t" + r.getRname() + "\t" +
                    r.getCategory().getCname() + "\t" + r.getSeller().getSname() + "\t" +
                    r.getRouteImgList().size());
        });
    }


    @Test
    public void  findById(){
        Route route = new Route();
        Route route1 = service.findById(34);
        System.out.println(route1);
    }

    @Test
    public void test01(){
        String str =  UUID.randomUUID().toString();

        System.out.println(str);
    }
}
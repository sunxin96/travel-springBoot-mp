package com.sx.service.Impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-05 20:33
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteImgServiceImplTest extends TestCase {

    @Autowired
    private RouteImgServiceImpl rsi;

    @Test
    public void test01(){
        rsi.saveImg(557,new ArrayList<>());

    }
}
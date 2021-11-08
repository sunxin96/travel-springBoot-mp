package com.sx.dao;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sx.entity.Seller;
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
 * @Date Created in 2021-10-31 13:58
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerDaoTest extends TestCase {

    @Autowired
    private SellerDao sd;

    @Test
    public void selectAll(){
        List<Seller> sellerList = sd.selectList(Wrappers.<Seller>query());
        for (Seller seller : sellerList) {
            System.out.println(seller);
        }
    }

    @Test
    public void select(){
        Seller seller = sd.findById(1);
        System.out.println(seller);
    }

    @Test
    public void test(){
        List<Seller> sellers = sd.selectList(Wrappers.query(new Seller()));
        sellers.forEach(seller -> System.out.println(seller));
    }
}
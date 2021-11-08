package com.sx.dao;

import com.sx.entity.Category;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-01 22:43
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDaoTest extends TestCase {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void selectById(){
        Category category = categoryDao.findById(5);
        System.out.println(category);
    }
}
package com.sx.dao;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageInfo;
import com.sx.entity.User;
import com.sx.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-29 17:26
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest extends TestCase {

    @Autowired
    private UserDao ud;

    @Autowired
    private UserService userService;
    @Test
    public void select(){
        User user = new User();
        user.setUsername("lgl");
        List<User> users = ud.selectList(Wrappers.query(user));
        System.out.println(users.size());
        for (User usera : users) {
            System.out.println(usera);
        }
    }

    @Test
    public void testFindPage() {
        User u = new User();
        PageInfo<User> page = userService.findPage(u, 1, 10);
        page.getList().forEach(System.out :: println);
        System.out.println("总行数=" + page.getTotal());
        System.out.println("当前页=" + page.getPageNum());
        System.out.println("每页行数=" + page.getPageSize());
        System.out.println("总页数=" + page.getPages());
        System.out.println("起始行数=" + page.getStartRow());
        System.out.println("是第一页=" + page.isIsFirstPage());
        System.out.println("是最后页=" + page.isIsLastPage());
        System.out.println("还有下一页=" + page.isHasNextPage());
        System.out.println("还有上一页=" + page.isHasPreviousPage());
        System.out.println("页码列表" + Arrays.toString(page.getNavigatepageNums()));
    }

    @Test
    public void selectUser(){
        User user = new User();
        PageInfo<User> page = userService.findPage(user, 1, 10);
        List<User> list = page.getList();
        for (User user1 : list) {
            System.out.println(user1);
        }
    }

    @Test
    public void test(){
        User user = new User();
        List<User> userList = ud.selectList(Wrappers.<User>query().like("name", user.getName()));
        userList.forEach(user1 -> System.out.println(user1));
    }

}
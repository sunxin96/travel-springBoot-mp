package com.sx.controller;

import com.github.pagehelper.PageInfo;
import com.sx.entity.User;
import com.sx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-29 17:51
 * @Modified By:
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    //批量删除
    /*@RequestMapping("/delete")
    public String batchDelete(@RequestParam(name = "ids") List<Integer> id){
        System.out.println("我进来了delete方法");
        for (Integer integer : id) {
            System.out.println(id);
        }
        Integer result = userService.batchDelete(id);
        System.out.println(result);
        return "redirect:/admin/user/page";
    }
*/
    //批量删除
    @ResponseBody
    @RequestMapping("/delete")
    public Integer batchDelete(@RequestParam(name = "ids") List<Integer> id){
        System.out.println("我进来了delete方法");
        for (Integer integer : id) {
            System.out.println(id);
        }
        Integer result = userService.batchDelete(id);
        System.out.println(result);
        return result;
    }



    /**
     * 分页查询
     * @param user 请求参数
     * @param pageNum 当前页
     * @param pageSize 每页行数
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String page(
            User user,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Model model) {
        System.out.println("page方法里的user : "+user);
        PageInfo<User> page = userService.findPage(user, pageNum, pageSize);
        System.out.println(page.getList().size());
        model.addAttribute("page", page);
        return "/user/list";
    }
    /**
     * 跳到添加页面
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd() {
        return "/user/add";
    }
    /**
     * 添加
     * @param user
     * @return
     */
    @RequestMapping("/doadd")
    public String doAdd(User user) {
        System.out.println("进入到这个方法里来了");
        System.out.println(user);
        userService.add(user);
        return "redirect:/admin/user/page";
    }
    /**
     * 跳到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user/update";
    }


    @RequestMapping("/doupdate")
    public String doUpdate(User user) {
        System.out.println("进入到doUpdate方法");
        System.out.println(user);
        userService.update(user);
        return "redirect:/admin/user/page";
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/admin/user/page";
    }
}

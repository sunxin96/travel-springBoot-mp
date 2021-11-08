package com.sx.controller;

import com.github.pagehelper.PageInfo;
import com.sx.entity.Seller;
import com.sx.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 14:36
 * @Modified By:
 */
@Controller
@RequestMapping("/admin/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/page")
    public String page(Seller seller,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Model model) {
        System.out.println(seller);
        PageInfo<Seller> pageInfo = sellerService.findPage(seller, pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "/seller/list";
    }

    @RequestMapping("/toadd")
    public String toAdd() {
        return "seller/add";
    }

    @RequestMapping("/doadd")
    public String doAdd(Seller seller) {
        sellerService.add(seller);
        return "redirect:/admin/seller/page";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable(name = "id") Long id, Model model) {
        Seller seller = sellerService.findById(id);
        model.addAttribute("seller", seller);
        return "seller/update";
    }

    @RequestMapping("/doupdate")
    public String doUpdate(Seller seller) {
        System.out.println(seller);
        sellerService.update(seller);
        return "redirect:/admin/seller/page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        sellerService.delete(id);
        return "redirect:/admin/seller/page";
    }

    @RequestMapping("/delete")
    public String batchDelete(@RequestParam(name = "ids")List<Long> id){
        Integer result = sellerService.batchDelete(id);
        return "redirect:/admin/seller/page";
    }

}

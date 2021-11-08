package com.sx.controller;

import com.github.pagehelper.PageInfo;
import com.sx.entity.Category;
import com.sx.entity.Route;
import com.sx.entity.RouteImg;
import com.sx.entity.Seller;
import com.sx.service.CategoryService;
import com.sx.service.RouteImgService;
import com.sx.service.RouteService;
import com.sx.service.SellerService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-02 21:35
 * @Modified By:
 */

@Controller
@RequestMapping("/admin/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private RouteImgService routeImgService;

    @RequestMapping("/page")
    public String page(
            Route route,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Model model) {
        PageInfo<Route> page = routeService.findPage(route, pageNum, pageSize);
        model.addAttribute("page", page);
//查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories", categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers", sellers);
//用于页面回显
        model.addAttribute("route", route);
        return "route/list";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        routeService.delete(id);
        return "redirect:/admin/route/page";
    }

    /**
     * 跳到添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd(Model model) {
//查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories", categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers", sellers);
        return "route/add";
    }

    /**
     * 执行添加
     *
     * @param route
     * @param rimageFile
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/doadd")
    public String doAdd(Route route, @RequestParam("rimageFile") MultipartFile rimageFile,
                        HttpServletRequest request) throws IOException {

        performRImage(route, rimageFile, request);
        routeService.add(route);
        return "redirect:/admin/route/page";
    }

    private void performRImage(Route route, @RequestParam("rimageFile") MultipartFile rimageFile, HttpServletRequest request) throws IOException {
        //项目的部署目录: /img/product/rimage/
/*
        String savePath = "D:\\testImg\\";
*/
        String savePath = request.getServletContext().getRealPath("img/product/rimage") + "/";
        System.out.println(savePath);
/*      int fileSuffixIndex = rimageFile.getOriginalFilename().lastIndexOf(".");
        String fileName = UUID.randomUUID().toString().replaceAll("-","")+rimageFile.getOriginalFilename().substring(fileSuffixIndex);*/
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + FilenameUtils.getExtension(rimageFile.getOriginalFilename());

        //上传目录不存在 则新创建目录
        File savePathDir = new File(savePath);
        if (!savePathDir.exists()) {
            boolean mkdirs = savePathDir.mkdirs();
            System.out.println(mkdirs);
        }
        //保存文件
        rimageFile.transferTo(new File(savePathDir, fileName));
        //设置route的rimage属性=图片相对路径
        route.setRimage("img/product/rimage/" + fileName);
    }


    /**
     * 根据id查询，跳转到修改页面
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/toupdate")
    public String toUpdate(Integer id, Model model) {
//查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories", categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers", sellers);
        Route route = routeService.findById(id);
        model.addAttribute("route", route);
        return "route/update";
    }


    @RequestMapping("/doupdate")
    public String doUpdate(Route route, @RequestParam("rimageFile") MultipartFile rimageFile,
                           HttpServletRequest request) throws IOException {
        System.out.println("route的Id : " + route.getRid());
        System.out.println("route的价格 : " + route.getPrice());
        performRImage(route, rimageFile, request);
        routeService.update(route);
        return "redirect:/admin/route/page";
    }

    @RequestMapping("/toimage/{id}")
    public String toImage(@PathVariable(name = "id") Integer id, Model model) {
        Route route = routeService.findById(id);
        model.addAttribute("route", route);
        return "/route/image";
    }


    @RequestMapping("/doimage")
    public String doImage(
            Integer rid,
            @RequestParam("bigPicFile") MultipartFile[] bigPicFile,
            @RequestParam("smallPicFile") MultipartFile[] smallPicFile,
            HttpServletRequest request) throws Exception {
        List<String> bigPic = new ArrayList<>();
        List<String> smallPic = new ArrayList<>();
        String path = request.getServletContext().getRealPath("/");
        for (MultipartFile f : bigPicFile) {
            File bigPath = new File(path + "img\\product\\big-pic\\");
            if (!bigPath.exists()) {
                bigPath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replace("-", "") + "." +
                    FilenameUtils.getExtension(f.getOriginalFilename());
            f.transferTo(new File(bigPath, fileName));
            bigPic.add("img/product/big-pic/" + fileName);
        }
        for (MultipartFile f : smallPicFile) {
            File smallPath = new File(path + "img\\product\\small-pic\\");
            if (!smallPath.exists()) {
                smallPath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replace("-", "") + "." +
                    FilenameUtils.getExtension(f.getOriginalFilename());
            f.transferTo(new File(smallPath, fileName));
            smallPic.add("img/product/small-pic/" + fileName);
        }
        //要添加的图片列表
        List<RouteImg> ris = new ArrayList<>();
        for (int i = 0; i < bigPic.size(); i++) {
            RouteImg img = new RouteImg();
            img.setRid(rid);
            img.setBigPic(bigPic.get(i));
            img.setSmallPic(smallPic.get(i));
            ris.add(img);
        }

        routeImgService.saveImg(rid, ris);
        return "redirect:/admin/route/page";
    }

}

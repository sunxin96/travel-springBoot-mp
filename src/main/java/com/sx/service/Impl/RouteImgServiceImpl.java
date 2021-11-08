package com.sx.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sx.dao.RouteImgDao;
import com.sx.entity.RouteImg;
import com.sx.service.RouteImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-05 17:55
 * @Modified By:
 */

@Repository
public class RouteImgServiceImpl implements RouteImgService {

    @Autowired
    private RouteImgDao rd;

    /**
     * @param rid       :线路Id  根据线路Id删除原图
     * @param routeImgs 要添加的新图列表
     * @Description
     * @Return void
     * @Author S.star
     * @Date Created in 5/11/2021 20:25
     */
    @Override
    @Transactional
    public void saveImg(Integer rid, List<RouteImg> routeImgs) {
        RouteImg routeImg = new RouteImg();
        routeImg.setRid(rid);
        int delete = rd.delete(Wrappers.<RouteImg>query().eq("rid",rid));
        System.out.println(delete);
        if (routeImgs != null){
            for (RouteImg img : routeImgs) {
                System.out.println(img.toString());
                rd.insert(img);
            }
        }
    }
}

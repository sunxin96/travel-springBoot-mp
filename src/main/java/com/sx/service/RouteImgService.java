package com.sx.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.entity.RouteImg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-05 17:54
 * @Modified By:
 */

@Repository
public interface RouteImgService  {

    /**
     *
     * @Description
     * @param rid :线路Id  根据线路Id删除原图
     * @param routeImgs   要添加的新图列表
     * @Return void
     * @Author S.star
     * @Date Created in 5/11/2021 20:25
     */
    public void saveImg(Integer rid, List<RouteImg> routeImgs);

}

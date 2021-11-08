package com.sx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.entity.RouteImg;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-11-01 22:32
 * @Modified By:
 */
@Repository
public interface RouteImgDao extends BaseMapper<RouteImg> {

    @Select("select * from tab_route_img where rid = #{rid}")
    public List<RouteImg> findByRid(Integer rid);


    @Select("select * from tab_route_img where rgid = 5")
    public RouteImg findById();


}

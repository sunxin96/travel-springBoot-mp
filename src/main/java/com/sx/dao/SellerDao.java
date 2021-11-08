package com.sx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.entity.Seller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 13:57
 * @Modified By:
 */
@Repository
public interface SellerDao extends BaseMapper<Seller> {

    @Select("select * from tab_seller where sid = #{id}")
    public Seller findById(Integer id);
}

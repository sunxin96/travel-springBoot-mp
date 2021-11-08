package com.sx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.entity.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 14:55
 * @Modified By:
 */

@Repository
public interface CategoryDao extends BaseMapper<Category> {


    @Select("select cid,cname from tab_category where cid = #{id}")
    public Category findById(Integer id);
}

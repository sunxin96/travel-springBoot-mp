package com.sx.service;

import com.sx.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 14:54
 * @Modified By:
 */

@Service
public interface CategoryService {



    public List<Category> find();
    /**
     * 添加
     * @param category
     * @return
     */
    public int add(Category category);
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Category findById(Integer id);
    /**
     * 修改
     * @param category
     * @return
     */
    public int update(Category category);
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);
}

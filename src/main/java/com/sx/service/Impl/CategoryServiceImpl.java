package com.sx.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sx.dao.CategoryDao;
import com.sx.entity.Category;
import com.sx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 14:55
 * @Modified By:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> find() {
        return categoryDao.selectList(Wrappers.<Category>query());
    }

    @Override
    public int add(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.selectById(id);
    }

    @Override
    public int update(Category category) {
        return categoryDao.updateById(category);
    }

    @Override
    public int delete(Integer id) {
        return categoryDao.deleteById(id);
    }
}

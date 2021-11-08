package com.sx.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sx.dao.SellerDao;
import com.sx.entity.Seller;
import com.sx.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 14:27
 * @Modified By:
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;


    /**
     * @param seller   查询条件
     * @param pageNum
     * @param pageSize
     * @Description
     * @Return com.github.pagehelper.PageInfo<com.sx.entity.Seller>
     * @Author S.star
     * @Date Created in 31/10/2021 14:11
     */
    @Override
    public PageInfo<Seller> findPage(Seller seller, int pageNum, int pageSize) {

        //都等于null
        if (seller.getSname() == null && seller.getAddress() == null) {
            return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
                sellerDao.selectList(Wrappers.<Seller>query());
            });
        }else if (seller.getSname() == null){
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->{
               sellerDao.selectList(Wrappers.<Seller>query().like("address",seller.getAddress()));
            });
        }else if (seller.getAddress() == null){
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->{
                sellerDao.selectList(Wrappers.<Seller>query().like("sname",seller.getSname()));
            });
        }else {
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->{
                sellerDao.selectList(Wrappers.<Seller>query().like("sname",seller.getSname()).like("address",seller.getAddress()));
            });
        }


    }

    /**
     * 添加
     *
     * @param seller
     * @Description
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:20
     */
    @Override
    public int add(Seller seller) {
        return sellerDao.insert(seller);
    }

    /**
     * @param Id
     * @Description 根据ID查询Seller
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:20
     */
    @Override
    public Seller findById(Long Id) {
        return sellerDao.selectById(Id);
    }

    /**
     * @param seller
     * @Description 更新
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:24
     */
    @Override
    public Integer update(Seller seller) {
        return sellerDao.updateById(seller);
    }

    /**
     * @param id
     * @Description 删除
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:25
     */
    @Override
    public Integer delete(Long id) {
        return sellerDao.deleteById(id);
    }

    @Override
    public Integer batchDelete(List<Long> id) {
        return sellerDao.deleteBatchIds(id);
    }

    @Override
    public List<Seller> find(Seller seller) {
        return sellerDao.selectList(Wrappers.query(seller));
    }
}

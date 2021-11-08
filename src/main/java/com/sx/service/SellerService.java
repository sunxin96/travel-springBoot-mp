package com.sx.service;

import com.github.pagehelper.PageInfo;
import com.sx.entity.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-31 14:03
 * @Modified By:
 */
@Service
public interface SellerService {

    /**
     *
     * @Description
     * @param seller 查询条件
     * @Return com.github.pagehelper.PageInfo<com.sx.entity.Seller>
     * @Author S.star
     * @Date Created in 31/10/2021 14:11
     */
    public PageInfo<Seller> findPage(Seller seller,int pageNum,int pageSize);

    /**
     * 添加
     * @Description
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:20
     */
    public int add(Seller seller);

    /**
     *
     * @Description 根据ID查询Seller
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:20
     */
    public Seller findById(Long Id);

    /**
     *
     * @Description 更新
     * @Return
     * @Author S.star
     * @Date Created in 31/10/2021 14:24
     */
     public Integer update(Seller seller);


     /**
      *
      * @Description 删除
      * @Return
      * @Author S.star
      * @Date Created in 31/10/2021 14:25
      */
     public Integer delete(Long id);


    Integer batchDelete(List<Long> id);

    List<Seller> find(Seller seller);
}

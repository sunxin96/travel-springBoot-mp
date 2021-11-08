package com.sx.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: S.star
 * @Description:
 * @Date Created in 2021-10-29 15:33
 * @Modified By:
 */

@Configuration
@MapperScan({"com.sx.dao"})
public class MybatisPlusConfig {

    @Bean
    public PageInterceptor pageInterceptor(){
        return new PageInterceptor();
    }
}

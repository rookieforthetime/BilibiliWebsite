package com.website.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {
    // 设置分页拦截器作为Spring管理的Bean
    @Bean
    public MybatisPlusInterceptor mpInterceptor() {
        // 1. 定义mybatisPlus拦截器
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        // 2. 添加分页查询拦截器
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 3. 添加乐观锁的拦截器
        mpInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mpInterceptor;
    }
}

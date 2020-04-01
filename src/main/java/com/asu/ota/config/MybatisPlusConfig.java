package com.asu.ota.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: carl
 * @Date: 2020-04-01 14:09
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

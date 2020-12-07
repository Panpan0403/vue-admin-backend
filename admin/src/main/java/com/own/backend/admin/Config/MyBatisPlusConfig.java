package com.own.backend.admin.Config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import org.springframework.context.annotation.Bean;

/**
 * @Author fangting
 * @create 2020/12/7 16:45
 * @description
 **/
public class MyBatisPlusConfig {
    @Bean
    public ISqlInjector sqlInjector() {
        return new MySqlInjector();
    }
}

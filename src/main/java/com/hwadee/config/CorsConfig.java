package com.hwadee.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executors;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 允许跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域请求的路由
        registry.addMapping("/**")
                //设置允许跨域的域名
                .allowedOriginPatterns("*")
                //是否允许携带cookie参数
                .allowCredentials(true)
                //允许跨域方法
                .allowedMethods("*")
                //允许跨域的时间
                .maxAge(3600);
    }

    /**
     * 设置异步请求支持
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //异步请求超时时间
        configurer.setDefaultTimeout(30000);
        //异步请求线程池
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
    }

    /**
     * 设置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}

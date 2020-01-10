package com.mjc.javaee.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 * @author VX5
 * @Title: MJC
 * @ProjectName graduation
 * @Description: TODO
 * @date ${DAT}16:00
 */
@Configuration
public class AllWebConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    ParamInterceptor paramInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paramInterceptor).addPathPatterns("/**").excludePathPatterns("/Login")
        .excludePathPatterns("/user/register");
        super.addInterceptors(registry);
    }
}

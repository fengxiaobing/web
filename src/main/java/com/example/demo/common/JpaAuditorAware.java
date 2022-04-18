package com.example.demo.common;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Configuration 系统启动后自动运行该类
 * 用于给 @CreatedBy，@LastModifiedBy赋值
 */
@Configuration
public class JpaAuditorAware implements AuditorAware<String> {

    @Resource
    private HttpServletRequest request;


    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("1213");
    }
}


package com.lym.springboot.jparepository.config;

import com.lym.springboot.jparepository.extend.LbxAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/28 17:16
 */
@EnableJpaAuditing
@Configuration
public class JpaAuditorConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new LbxAuditorAware();
    }

}

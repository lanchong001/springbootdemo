package com.lym.springboot.jparepository.extend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @Author: in liuyuanming
 * @Description: 自定义审核和审计功能
 * @Date:Created in  2019/5/28 17:03
 */
public class LbxAuditorAware implements AuditorAware<String> {

    @Value("${lbx.appliction.loginId}")
    private String loginId;

    @Override
    public Optional<String> getCurrentAuditor() {
        if (!StringUtils.isEmpty(loginId)) {
            return Optional.of(loginId);
        } else {
            return Optional.empty();
        }
    }
}

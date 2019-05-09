package com.lym.springboot.reflection.Utils;

import com.lym.springboot.reflection.domain.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 22:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApiAssertTest {

    @Test
    public void validation() throws IllegalAccessException {
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUserName("li li");
        userVo.setAppId("123");
        userVo.setNonceStr("234324");
        userVo.setTimeStamp(234234234);
        userVo.setSign("423423423423");
        userVo.setCreateDate(new Date());
        WebApiAssert.validation(userVo);
    }
}
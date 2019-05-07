package com.lym.springboot.junit.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 15:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserService userService;

    @SuppressWarnings("unchecked")
    @Test(expected = NullPointerException.class)
    public void testMockBean() {

        BDDMockito.given(userService.getUserAge(2L)).willReturn(Integer.valueOf(18));
        BDDMockito.given(userService.getUserAge(0L)).willReturn(Integer.valueOf(0));
        BDDMockito.given(userService.getUserAge(null)).willThrow(NullPointerException.class);

        Assert.assertEquals(Integer.valueOf(18), userService.getUserAge(2L));
        Assert.assertEquals(Integer.valueOf(0), userService.getUserAge(0L));
        Assert.assertEquals(Integer.valueOf(0), userService.getUserAge(null));
    }
}
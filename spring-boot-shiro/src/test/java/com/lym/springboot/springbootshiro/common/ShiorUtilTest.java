package com.lym.springboot.springbootshiro.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiorUtilTest {

    @Test
    public void getCode() {
        String staticSalt = ".";
        String algorithmName = "MD5";
        String encodedPassword = "123456";
        String dynaSalt = "test";
        String result = ShiorUtil.getCode(staticSalt,algorithmName,dynaSalt,encodedPassword);
        System.out.println(result);
    }
}
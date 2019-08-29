package com.lym.springboot.activeprofiles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
public class ProfileTest {

    @Value("${name}")
    private String name;

    @Test
    public void testGetName(){
        System.out.printf(name);
        Assert.assertEquals(name,"dev");
    }

}

package com.lym.springboot.mapper;

import com.lym.springboot.domain.Menu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class MenuMapperTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testGetMenu(){
        Menu menu = menuMapper.getMenu("27626f1201484584a31d06e6cf8ad61a");
        Assert.assertTrue(menu != null && menu.getId().equals("27626f1201484584a31d06e6cf8ad61a"));
    }
}
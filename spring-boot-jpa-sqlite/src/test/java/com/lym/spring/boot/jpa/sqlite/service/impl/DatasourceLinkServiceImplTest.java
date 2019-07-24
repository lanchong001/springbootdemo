package com.lym.spring.boot.jpa.sqlite.service.impl;

import com.lym.spring.boot.jpa.sqlite.domain.DatasourceLinkEntity;
import com.lym.spring.boot.jpa.sqlite.repository.DatasourceLinkRepository;
import com.lym.spring.boot.jpa.sqlite.service.DatasourceLinkService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatasourceLinkServiceImplTest {

    @Autowired
    private DatasourceLinkService datasourceLinkService;

    @Test
    public void edit() {
        boolean result = datasourceLinkService.edit("402892816b97a370016b97a6eb7e0000");
        Assert.assertTrue(result);
    }

    @Test
    public void save() throws ParseException {
        DatasourceLinkEntity datasourceLinkEntity = new DatasourceLinkEntity();
        datasourceLinkEntity.setId(UUID.randomUUID().toString());
        datasourceLinkEntity.setCode("9999");
        datasourceLinkEntity.setName("测试11");
        datasourceLinkEntity.setUrl("http://www.163.com");
        datasourceLinkEntity.setUsername("zhangshan");
        datasourceLinkEntity.setPassword("123456");
        datasourceLinkEntity.setType("1");
        datasourceLinkEntity.setDesc("描述11");
        datasourceLinkEntity.setStatus(1);
        datasourceLinkEntity.setCreationUser("00074913");
        datasourceLinkEntity.setCreationDate(new Timestamp(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2019-07-23 18:38:39").getTime()));
        datasourceLinkEntity.setModificationUser("00074913");
        datasourceLinkEntity.setModificationDate(new Timestamp(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2019-07-23 18:38:39").getTime()));
        boolean save = datasourceLinkService.save(datasourceLinkEntity);
        Assert.assertTrue(save);
    }

    @Test
    public void delete() {
        boolean result = datasourceLinkService.delete("402892816b97a370016b97a6eb7e0000");
        Assert.assertTrue(result);
    }

    @Test
    public void getList() {
        DatasourceLinkEntity datasourceLinkEntity = new DatasourceLinkEntity();
        List<DatasourceLinkEntity> list = datasourceLinkService.getList(datasourceLinkEntity, 1, 10);
        Assert.assertTrue(list != null && list.size() > 0);
    }
}
package com.lym.spring.boot.jpa.sqlite.repository;

import com.lym.spring.boot.jpa.sqlite.domain.DatasourceLinkEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceLinkRepositoryTest {

    @Autowired
    private DatasourceLinkRepository datasourceLinkRepository;

    @Test
    public void testFindByStatusAndType(){
        List<DatasourceLinkEntity> linkEntities = datasourceLinkRepository.findByStatusAndType(1, "1");
        Assert.assertTrue(linkEntities != null && linkEntities.size() > 0);
    }

}
package com.lym.springboot.jparepository.repository;

import com.lym.springboot.jparepository.domain.FaceLib;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/28 17:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FaceLibRepositoryTest {

    @Autowired
    private FaceLibRepository faceLibRepository;

    @Test
    public void testSave() {
        Optional<FaceLib> faceLib1 = faceLibRepository.findById("4028b8816afde5b1016afde5bd590000");
        FaceLib face = faceLib1.get();
        face.setImgUrl("test url1111");
        FaceLib faceLib = faceLibRepository.save(face);
        Assert.assertTrue(!ObjectUtils.isEmpty(faceLib));
    }

}
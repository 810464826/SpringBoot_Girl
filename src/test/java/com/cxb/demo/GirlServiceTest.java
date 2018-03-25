package com.cxb.demo;

import com.cxb.demo.domain.Girl;
import com.cxb.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        //id为2的女生  年龄是26
        Girl girl = girlService.findOne(2);
        Assert.assertEquals(new Integer(26),girl.getAge());
    }
}

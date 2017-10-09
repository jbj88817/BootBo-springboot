package us.bojie.bootbo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import us.bojie.bootbo.domain.Girl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService mGirlService;

    @Test
    public void findOneTest() {
        Girl girl = mGirlService.findOne(900936);
        Assert.assertEquals(new Integer(16), girl.getAge());
    }
}
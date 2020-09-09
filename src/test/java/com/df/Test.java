package com.df;

import com.df.entity.User;
import com.df.service.TestService;
import com.df.utils.Pub;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hanyli
 * @date 2020/6/9
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    @org.junit.Test
    public void test() throws InterruptedException{
        String df = "dfdf";
        redisTemplate.convertAndSend("test1",df);
        redisTemplate.convertAndSend("test2","df2");


    }
}

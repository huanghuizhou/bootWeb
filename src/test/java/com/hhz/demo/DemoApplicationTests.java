package com.hhz.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Test
    public void contextLoads() {
        Long time = System.currentTimeMillis();
        System.out.println(new Date());
        RestTemplate client = new RestTemplate();
        for (int i = 0; i < 5000; i++) {
            ResponseEntity<String> response = client.exchange("http://localhost:9080/hhz1", HttpMethod.GET, null, String.class);
        }
        Long end = System.currentTimeMillis();

        System.out.println("ok");
        System.out.println(end - time);

    }


    @Test
    public void aaa() {
    }

}

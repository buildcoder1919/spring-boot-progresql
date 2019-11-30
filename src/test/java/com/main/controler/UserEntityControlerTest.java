package com.main.controler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEntityControlerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void getUsers() {
        /*ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/user/getTestInfo?id=1",String.class);
        System.out.println("test_StatusCode-->"+responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());*/
    }
}
package com.wyj;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptApplicationTests {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void contextLoads() {
        System.out.println(stringEncryptor.encrypt("root"));
    }

    @Test
    public void passwordTest() {
        System.out.println(UUID.randomUUID());
    }

}

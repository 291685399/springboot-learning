package com.wyj;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input=wyj password=944ec5b7-148f-4db6-ae0e-612a5106507b algorithm=PBEWithMD5AndDES
 * java -jar -Djasypt.encryptor.password=G0CvDz7oJn6 xxx.jar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptApplicationTests {

    @Value("${com.wyj.user.name}")
    private String name;
    @Value("${com.wyj.user.sex}")
    private String sex;
    public static Logger logger = LoggerFactory.getLogger(JasyptApplicationTests.class);
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void contextLoads() {
        logger.info("name = {}", name);
        logger.info("sex = {}", sex);
        System.out.println(stringEncryptor.encrypt("root"));
        System.out.println(stringEncryptor.decrypt("RWswJhLElfDXz04czUWwYg=="));
    }

    @Test
    public void passwordTest() {
        System.out.println(UUID.randomUUID());
    }

}

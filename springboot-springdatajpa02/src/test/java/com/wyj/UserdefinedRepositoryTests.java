package com.wyj;

import com.wyj.dao.UserdefinedRepository;
import com.wyj.entity.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserdefinedRepositoryTests {

    @Autowired
    private UserdefinedRepository userdefinedRepository;

    @Test
    public void findByNameAndAge() {
        List<User> userList = userdefinedRepository.findByNameAndAge("ljk", 18);
        System.out.println(userList);
    }

    @Test
    public void findByNameOrAge() {
        List<User> userList = userdefinedRepository.findByNameOrAge("ljk", 18);
        System.out.println(userList);
    }

    @Test
    public void findByNameIs() {
        String str = "wyj";
        List<User> userList = userdefinedRepository.findByNameIs(str);
        System.out.println(userList);
    }

    @Test
    public void findByNameEquals() {
        String str = "wyj";
        List<User> userList = userdefinedRepository.findByNameEquals(str);
        System.out.println(userList);
    }

    @Test
    public void findByAgeBetween() {
        int littleAge = 17;
        int bigAge = 18;
        List<User> userList = userdefinedRepository.findByAgeBetween(littleAge, bigAge);
        System.out.println(userList);
    }

    @Test
    public void findByAgeLessThan() {
        int age = 19;
        List<User> userList = userdefinedRepository.findByAgeLessThan(age);
        System.out.println(userList);
    }

    @Test
    public void findByAgeLessThanEqual() {
        int age = 18;
        List<User> userList = userdefinedRepository.findByAgeLessThanEqual(age);
        System.out.println(userList);
    }

    @Test
    public void findByAgeGreaterThan() {
        int age = 17;
        List<User> userList = userdefinedRepository.findByAgeGreaterThan(age);
        System.out.println(userList);
    }

    @Test
    public void findByAgeGreaterThanEqual() {
        int age = 18;
        List<User> userList = userdefinedRepository.findByAgeGreaterThanEqual(age);
        System.out.println(userList);
    }

}

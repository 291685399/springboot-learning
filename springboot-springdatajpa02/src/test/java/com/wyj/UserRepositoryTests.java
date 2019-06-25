package com.wyj;

import com.wyj.dao.UserRepository;
import com.wyj.entity.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByNameAndAge() {
        List<User> userList = userRepository.findByNameAndAge("ljk", 18);
        System.out.println(userList);
    }

    @Test
    public void findByNameOrAge() {
        List<User> userList = userRepository.findByNameOrAge("ljk", 18);
        System.out.println(userList);
    }

    @Test
    public void findByNameIs() {
        String str = "wyj";
        List<User> userList = userRepository.findByNameIs(str);
        System.out.println(userList);
    }

    @Test
    public void findByNameEquals() {
        String str = "wyj";
        List<User> userList = userRepository.findByNameEquals(str);
        System.out.println(userList);
    }

    @Test
    public void findByAgeBetween() {
        int littleAge = 17;
        int bigAge = 18;
        List<User> userList = userRepository.findByAgeBetween(littleAge, bigAge);
        System.out.println(userList);
    }

    @Test
    public void findByAgeLessThan() {
        int age = 19;
        List<User> userList = userRepository.findByAgeLessThan(age);
        System.out.println(userList);
    }

    @Test
    public void findByAgeLessThanEqual() {
        int age = 18;
        List<User> userList = userRepository.findByAgeLessThanEqual(age);
        System.out.println(userList);
    }

    @Test
    public void findByAgeGreaterThan() {
        int age = 17;
        List<User> userList = userRepository.findByAgeGreaterThan(age);
        System.out.println(userList);
    }

    @Test
    public void findByAgeGreaterThanEqual() {
        int age = 18;
        List<User> userList = userRepository.findByAgeGreaterThanEqual(age);
        System.out.println(userList);
    }

    @Test
    public void findByOrderByAgeDesc() {
        List<User> userList = userRepository.findByOrderByAgeDesc();
        System.out.println(userList);
    }

    @Test
    public void findByNameIgnoreCase() {
        String name = "Wyj";
        List<User> userList = userRepository.findByNameIgnoreCase(name);
        System.out.println(userList);
    }

}

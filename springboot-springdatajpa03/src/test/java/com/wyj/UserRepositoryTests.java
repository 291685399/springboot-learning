package com.wyj;

import com.wyj.dao.UserRepository;
import com.wyj.po.User;
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
    public void findUserTest() {
        Long id = 1L;
        User user = userRepository.findUser(id);
        System.out.println("user:" + user);
    }

    @Test
    public void findUserByParamTest() {
        Long id = 1L;
        User user = userRepository.findUserByParam(id);
        System.out.println("user:" + user);
    }

    @Test
    public void findUserByIdAndNameTest() {
        Long id = 1L;
        String name = "ljk";
        User user = userRepository.findUserByIdAndName(id, name);
        System.out.println("user:" + user);
    }

    @Test
    public void findUserListTest() {
        List<User> userList = userRepository.findUserList();
        System.out.println("userList:" + userList);
    }

    @Test
    public void findUserListByLikeNameTest() {
        String name = "j";
        List<User> userListByLikeName = userRepository.findUserListByLikeName(name);
        System.out.println("userListByLikeName:" + userListByLikeName);
    }

    @Test
    public void findUserListByLikeConcatNameTest() {
        String name = "j";
        List<User> userListByLikeName = userRepository.findUserListByLikeConcatName(name);
        System.out.println("userListByLikeName:" + userListByLikeName);
    }

    @Test
    public void findUserByNativeQueryTest() {
        int id = 1;
        User user = userRepository.findUserByNativeQuery(id);
        System.out.println("user:" + user);
    }

    @Test
    public void findByLastnameTest() {
        String str = "wyj";
        List<User> userList = userRepository.findBySpEL(str);
        System.out.println("userList:" + userList);
    }

}

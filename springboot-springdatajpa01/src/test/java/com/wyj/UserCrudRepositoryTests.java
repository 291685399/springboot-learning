package com.wyj;

import com.wyj.dao.UserCrudRepository;
import com.wyj.entity.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudRepositoryTests {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * 新增
     */
    @Test
    public void add() {
        User user = new User();
        user.setName("ljk2");
        user.setSex("1");
        user.setAge(18);
        user.setAddress("beijing");
        User result = userCrudRepository.save(user);
        Assert.assertNotNull(result);
    }

    /**
     * 修改
     */
    @Test
    public void edit() {
        User user = new User();
        user.setId(1l);
        user.setName("ljk2edit");
        user.setSex("1");
        user.setAge(18);
        user.setAddress("beijing");
        User result = userCrudRepository.save(user);
        Assert.assertNotNull(result);
    }

    /**
     * 根据id查询
     */
    @Test
    public void findById() {
        Optional<User> userOptional = userCrudRepository.findById(1L);
        User result = userOptional.get();
        System.out.println(result);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<User> userList = (List<User>) userCrudRepository.findAll();
        System.out.println(userList);
    }

    /**
     * 计算总数
     */
    @Test
    public void count() {
        long count = userCrudRepository.count();
        System.out.println(count);
    }

}

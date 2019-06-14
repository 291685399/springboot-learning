package com.wyj;

import com.wyj.dao.UserJpaRepository;
import com.wyj.entity.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepositoryTests {

    @Autowired
    private UserJpaRepository userJpaRepository;

    /**
     * 执行秒数：49422 49145
     * 批量插入数据
     */
    @Test
    public void BatchSave() {
        long startTime = System.currentTimeMillis();
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 60000; i++) {
            User user = new User();
            user.setName("ljk" + i);
            user.setAge(i);
            user.setAddress("address" + i);
            list.add(user);
            if (i % 100 == 0) {
                userJpaRepository.saveAll(list);
                list.clear();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行秒数：" + (endTime - startTime));
    }

    /**
     * 执行秒数：48053 48394 执行速度比BatchSave 要快
     * 批量保存数据 （高效处理方式）减少大事物的提交
     */
    @Test
    public void BatchSaveBest() {
        long startTime = System.currentTimeMillis();
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 60000; i++) {
            User user = new User();
            user.setName("ljk" + i);
            list.add(user);
            if (i % 100 == 0) {
                userJpaRepository.saveAll(list);
                userJpaRepository.flush();
                list.clear();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行秒数：" + (endTime - startTime));
    }

    /**
     * 查询所有数据
     */
    @Test
    public void findAll() {
        List<User> userlists = userJpaRepository.findAll();
        Assert.assertTrue(userlists.size() > 0);
    }

    /**
     * 根据 age 排序查询
     */
    @Test
    public void findALLSortAge() {
        List<User> lists = userJpaRepository.findAll(Sort.by(Sort.Direction.ASC, "age"));
        for (User list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void findAllByPage() {
        PageRequest pageRequest = new PageRequest(0, 1);
        Page<User> userPage = userJpaRepository.findAll(pageRequest);
        Assert.assertTrue(userPage.getContent().size() == 1);
    }

    /**
     * 分页排序查询
     */
    @Test
    public void findAllByPageAndSort() {
        PageRequest pageRequest = new PageRequest(0, 3, Sort.by(Sort.Direction.ASC, "age"));
        Page<User> userPage = userJpaRepository.findAll(pageRequest);
        List<User> userList = userPage.getContent();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 根据id 的集合获取所有数据
     */
    @Test
    public void findAllByIds() {
        List<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        List<User> userList = userJpaRepository.findAllById(ids);
        System.out.println(userList);
    }

    /**
     * 批量删除所有数据
     */
    @Test
    public void deleteAllInBatch() {
        userJpaRepository.deleteAllInBatch();
    }

    /**
     * 保存数据并刷新缓存
     */
    @Test
    public void saveAndFlush() {
        User user = new User();
        user.setName("ljk");
        user.setAge(18);
        user.setAddress("beijing");
        user.setSex("1");
        User result = userJpaRepository.saveAndFlush(user);
        Assert.assertNotNull(result);
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteInBatch() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(1l);
        userList.add(user);
        User user2 = new User();
        user2.setId(2l);
        userList.add(user2);
        User user3 = new User();
        user3.setId(3l);
        userList.add(user3);
        User user4 = new User();
        user4.setId(4l);
        userList.add(user4);
        userJpaRepository.deleteInBatch(userList);
    }

    /**
     * 根据id 获取数据
     */
    @Test
    public void getOne() {
        User user = userJpaRepository.findById(1L).get();
        System.out.println(user);
    }

    /**
     * 示例匹配器 ExampleMatcher
     */
    @Test
    public void findUserByExam() {
        User user = new User();
        user.setName("ljk");
        List<User> list = userJpaRepository.findAll(Example.of(user));
        System.out.println(list);
    }

    /**
     * 模糊查询
     */
    @Test
    public void findUserByExamQuery() {
        User user = new User();
        user.setName("ljk");
        user.setAddress("beijing");
        user.setAge(18);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("id");//忽略字段，即不管id是什么值都不加入查询条件
        Example<User> example = Example.of(user, matcher);
        List<User> userList = userJpaRepository.findAll(example);
        System.out.println(userList);
    }

}

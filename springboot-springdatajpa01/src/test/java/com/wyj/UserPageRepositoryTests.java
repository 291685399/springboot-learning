package com.wyj;

import com.wyj.dao.UserPageRepository;
import com.wyj.entity.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPageRepositoryTests {

    @Autowired
    private UserPageRepository userPageRepository;

    /**
     * 排序查询
     */
    @Test
    public void findAllBySort() {
        List<User> userList = (List<User>) userPageRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        System.out.println(userList.size());
        System.out.println(userList);
    }

    /**
     * 分页查询
     */
    @Test
    public void findAllByPageable() {
        Page<User> userPage = userPageRepository.findAll(new PageRequest(0, 20));
        userPage.getNumber();//页数
        userPage.getContent();//分页的数据
        userPage.getTotalPages();//总共的页数
        System.out.println("number:" + userPage.getNumber()
                + "Countet" + userPage.getContent().size()
                + "TotalPages" + userPage.getTotalPages());
    }

}

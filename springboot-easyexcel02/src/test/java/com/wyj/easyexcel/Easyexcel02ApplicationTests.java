package com.wyj.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.wyj.easyexcel.entity.pojo.User;
import com.wyj.easyexcel.listener.UserExcelImportListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Easyexcel02ApplicationTests {

    @Test
    public void contextLoads() {
        String fileName = "/Users/wanyingjing/Desktop/user.xlsx";
        EasyExcel.read(fileName, User.class, new UserExcelImportListener()).sheet().doRead();
    }

}

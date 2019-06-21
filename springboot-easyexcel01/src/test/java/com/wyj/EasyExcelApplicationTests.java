package com.wyj;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyExcelApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:/Users/EDZ/Desktop/77.xls");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,false);

            List<List<String>> userList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                List<String> user = new ArrayList<>();
                user.add("a" + i);
                user.add("b" + i);
                user.add("c" + i);
                user.add("d" + i);
                userList.add(user);
            }

            // 设置SHEET名称
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("系统列表sheet1");

            // 设置标题
            Table table = new Table(1);
            List<List<String>> titles = new ArrayList<List<String>>();
            titles.add(Arrays.asList("系统名称"));
            titles.add(Arrays.asList("系统标识"));
            titles.add(Arrays.asList("描述"));
            titles.add(Arrays.asList("状态"));
            table.setHead(titles);
            writer.write0(userList, sheet, table);

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

package com.wyj.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.wyj.entity.po.User;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportExcel")
    public void exportExcel() {
        ExcelWriter writer = null;
        OutputStream out = null;
        try {
            List userList = userService.findAll();
            String fileName = "用户信息表格";
            out = new FileOutputStream("C:/Users/EDZ/Desktop/" + fileName + ".xlsx");
            writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0, User.class);
            sheet.setSheetName("用户信息");
            writer.write(userList, sheet);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.finish();
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 下载Excel
     *
     * @param response
     */
    @RequestMapping(value = "/uploadExcel")
    public void uploadExcel(HttpServletResponse response) {
        ExcelWriter writer = null;
        OutputStream out = null;
        try {
            List userList = userService.findAll();
            out = response.getOutputStream();
            writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            String fileName = "用户信息表格";
            Sheet sheet = new Sheet(1, 0, User.class);
            sheet.setSheetName("用户信息");
            writer.write(userList, sheet);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.finish();
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

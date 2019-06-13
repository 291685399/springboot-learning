package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.service.UserService;
import com.wyj.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Excel下载导出数据
     *
     * @param response
     */
    @RequestMapping(value = "/downloadExcel")
    @ResponseBody
    public void downloadExcel(HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            String fileName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ".xlsx";
            if (response == null) {
                outputStream = new FileOutputStream("C:/Users/EDZ/Desktop");
            } else {
                outputStream = response.getOutputStream();
                response.setContentType("application/octet-stream ");
                // 表示不能用浏览器直接打开
                response.setHeader("Connection", "close");
                // 告诉客户端允许断点续传多线程连接下载
                response.setHeader("Accept-Ranges", "bytes");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + fileName);
                response.setCharacterEncoding("UTF-8");
            }

            //新建sheet工作表
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("用户列表");

            //在sheet中新建首行元素
            int rowIdx = 0;
            XSSFRow headRow = sheet.createRow(rowIdx++);
            String[] heads = new String[]{"序号", "姓名", "性别", "年龄", "地址", "联系方式"};
            int cellIdx = 0;
            for (String string : heads) {
                headRow.createCell(cellIdx++).setCellValue(string);
            }

            List<User> userList = userService.findAll();

            Iterator<User> iterator = userList.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                //每次循环中创建一个row，将用户信息设置进去
                User user = iterator.next();
                XSSFRow row = sheet.createRow(rowIdx++);
                cellIdx = 0;
                count++;
                row.createCell(cellIdx++).setCellValue(count);
                row.createCell(cellIdx++).setCellValue(user.getName());
                row.createCell(cellIdx++).setCellValue(user.getSex());
                row.createCell(cellIdx++).setCellValue(user.getAge());
                row.createCell(cellIdx++).setCellValue(user.getAddress());
                row.createCell(cellIdx++).setCellValue(user.getPhone());
            }
            //将Excel写出到输出流中
            wb.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Excel导入数据（指定路径）
     */
    @RequestMapping(value = "/importExcel")
    @ResponseBody
    public void importExcel() {
        File file = new File("C:/Users/EDZ/Desktop/2019-06-03 16_35_24.xlsx");
        Workbook wb = null;
        List<User> userList = new ArrayList();
        try {
            if (ExcelUtil.isExcel2007(file.getPath())) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(file));
            }

            Sheet sheet = wb.getSheetAt(0);//获取第一张表
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);//获取索引为i的行，以0开始
                int id = (int) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String sex = row.getCell(2).getStringCellValue();
                int age = (int) row.getCell(3).getNumericCellValue();
                String address = row.getCell(4).getStringCellValue();
                String phone = row.getCell(5).getStringCellValue();
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setSex(sex);
                user.setAddress(address);
                user.setPhone(phone);
                userList.add(user);
            }
            userService.insertUserList(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * Excel导入数据（上传Excel文件）
     *
     * @param file
     */
    @RequestMapping(value = "/uploadExcel")
    @ResponseBody
    public void uploadExcel(MultipartFile file) {
        InputStream inputStream = null;
        Workbook wb = null;
        List<User> userList = new ArrayList();
        try {
            inputStream = file.getInputStream();
            if (ExcelUtil.isExcel2007(file.getOriginalFilename())) {
                wb = new XSSFWorkbook(inputStream);
            } else {
                wb = new HSSFWorkbook(inputStream);
            }

            Sheet sheet = wb.getSheetAt(0);//获取第一张表
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);//获取索引为i的行，以0开始
                int id = (int) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String sex = row.getCell(2).getStringCellValue();
                int age = (int) row.getCell(3).getNumericCellValue();
                String address = row.getCell(4).getStringCellValue();
                String phone = row.getCell(5).getStringCellValue();
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setSex(sex);
                user.setAddress(address);
                user.setPhone(phone);
                userList.add(user);
            }
            userService.insertUserList(userList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

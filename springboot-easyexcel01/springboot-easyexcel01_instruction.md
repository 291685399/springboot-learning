# springboot-easyexcel01

**springboot使用easyexcel完成Excel导出**

## springboot使用easyexcel完成Excel导出关键点
    1、pom.xml添加依赖
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>easyexcel</artifactId>
            <version>1.1.2-beat1</version>
        </dependency>
        
    2、在实体类中添加注解用于指定列信息和列索引，通过 @ExcelProperty 注解与 index 变量可以标注成员变量所映射的列
        @ExcelProperty(value = "序号", index = 0)
        
    3、导出Excel：
        ExcelWriter writer = null;
        OutputStream out = null;
        List userList = userService.findAll();
        String fileName = "用户信息表格";
        out = new FileOutputStream("C:/Users/EDZ/Desktop/" + fileName + ".xlsx");
        writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, User.class);
        sheet.setSheetName("用户信息");
        writer.write(userList, sheet);
        out.flush();
        writer.finish();
        out.close();
        
    4、实例：
        浏览器访问http://127.0.0.1:8080/exportExcel，在桌面生成“用户信息表格.xlsx”
    
    5、下载Excel：
        ExcelWriter writer = null;
        OutputStream out = null;
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
        writer.finish();
        out.close();
    
    6、实例：
        浏览器访问http://127.0.0.1:8080/exportExcel，浏览器直接下载“用户信息表格.xlsx”，具体位置要根据浏览器的下载位置而定
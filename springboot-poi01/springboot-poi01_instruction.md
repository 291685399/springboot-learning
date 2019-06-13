# springboot-poi01

**poi实现Excel导入导出**

## poi实现Excel导入导出关键点
    1、在pom.xml文件中添加依赖
        <!-- POI -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>3.8</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>3.8</version>
        </dependency>
    
    2、Excel导出
        (1)、新建sheet工作表
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("用户列表");
    
        (2)、在sheet中新建首行元素
            headRow.createCell(cellIdx++).setCellValue("序号");
        
        (3)、循环遍历List，每次循环中创建一个row，将用户信息设置进去
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
        
        (4)、将Excel写出到输出流中
            wb.write(outputStream);
            outputStream.flush();
    
    3、Excel导入
        (1)、判断是否是Excel2007之前的
            if (ExcelUtil.isExcel2007(file.getPath())) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(file));
            }
            
        (2)、获取第一张表
            Sheet sheet = wb.getSheetAt(0);
        (3)、获取每行
            Row row = sheet.getRow(i);
        (4)、获取每行中的数据
            int id = (int) row.getCell(0).getNumericCellValue();
            String name = row.getCell(1).getStringCellValue();
            String sex = row.getCell(2).getStringCellValue();
            int age = (int) row.getCell(3).getNumericCellValue();
            String address = row.getCell(4).getStringCellValue();
            String phone = row.getCell(5).getStringCellValue();
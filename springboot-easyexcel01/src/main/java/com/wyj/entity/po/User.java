package com.wyj.entity.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class User extends BaseRowModel implements Serializable {

    //通过 @ExcelProperty 注解与 index 变量可以标注成员变量所映射的列
    @ExcelProperty(value = "序号", index = 0)
    private int id;
    @ExcelProperty(value = "姓名", index = 1)
    private String name;
    @ExcelProperty(value = "性别", index = 2)
    private String sex;
    @ExcelProperty(value = "年龄", index = 3)
    private int age;
    @ExcelProperty(value = "地址", index = 4)
    private String address;
    @ExcelProperty(value = "联系方式", index = 5)
    private String phone;

}

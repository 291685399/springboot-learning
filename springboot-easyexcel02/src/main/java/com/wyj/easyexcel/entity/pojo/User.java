package com.wyj.easyexcel.entity.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.wyj.easyexcel.convert.MyConverter;
import lombok.Data;

import java.io.Serializable;

/**
 * 这里@ExcelProperty(index = 0)也可以使用@ExcelProperty(name = "姓名")来表示，
 * 但是name重复会导致只有一个字段读取到数据，所以 index 是更稳妥的方式
 * 不建议使用@ExcelProperty(index = 1， name = "姓名")
 * <p>
 * 使用@DateTimeFormat("yyyy-MM-dd HH:mm:ss")进行日期格式化
 */
@Data
public class User implements Serializable {

    @ExcelProperty(index = 0)
    private int id;

    @ExcelProperty(index = 1, converter = MyConverter.class)
    private String username;

    @ExcelProperty(index = 2)
    private String address;

    @ExcelProperty(index = 3)
    private String phone;

}

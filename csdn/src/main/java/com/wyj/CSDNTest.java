package com.wyj;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 定时访问CSDN博客页面
 *
 * @author wyj
 * @create 2019-03-12 20:58
 */
@Component
public class CSDNTest {

    private static Desktop desktop;//定义私有静态成员变量
    public static ArrayList<String> blogAddressList = new ArrayList<String>();//用来存储博客地址集合
    public static ArrayList<String> blogNameList = new ArrayList<String>();//用户存储博客名称集合

    public static void getBlogAddress() {
        File file = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        URL url = null;

        try {
            inputStream = CSDNTest.class.getClassLoader().getResourceAsStream("blogAddress.txt");
//            file = new File(url.getFile());
//            inputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] split = str.split("blogAddress：");
                blogNameList.add(split[0]);
                blogAddressList.add(split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * 定义了一个通过默认浏览器打开相应网址的方法
     * 这个方法还用到了有关Desktop类的一些内容，大家可以自行百度或者查看相应API
     */
    public static void browse(String uri) {

        if (Desktop.isDesktopSupported()) {//判断是否支持DeskTop
            desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(uri));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        int i = 0;
        getBlogAddress();
        while (true) {    //一直循环
            try {
                if (i < blogAddressList.size()) {    //判断是否小于博文数量，不然可能会出现越界错误
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = simpleDateFormat.format(new Date());
                    System.out.println("在" + date + "访问了" + blogNameList.get(i) + "blogAddress：" + blogAddressList.get(i));
                    browse((String) blogAddressList.get(i));
                    Thread.sleep(5000);    //这里的单位为毫秒我这里设置每个网址之间间隔5s 这里可以根据情况改
                } else {
                    i = -1; //将i重置为-1 因为后面会进行i++ 加1后就变成了0
                    // 启用cmd运行chrome的方式来退出
                    Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); //我默认浏览器是chrome
                    //如果你默认的浏览器是firefox 将chrome改为firefox即可
                    Thread.sleep(50000);    //这里的单位为毫秒 我这里设置每个访问所有博文后 休眠5分钟 这里可以根据情况改
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}

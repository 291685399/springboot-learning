# springboot-mail01

**springboot发送邮件**

## springboot发送邮件关键点
    1、在pom.xml文件中添加依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
    2、在application.properties文件中定义加密密码，可以使用UUID生成的，执行JasyptApplicationTests测试类中的passwordTest方法
        jasypt.encryptor.password=944ec5b7-148f-4db6-ae0e-612a5106507b
    3、在application.properties文件中配置邮件信息
        #邮箱服务器地址
        spring.mail.host=smtp.163.com
        #用户名
        spring.mail.username=wanyingjing@163.com
        #密码，这里密码使用了jasypt加密，使用测试类中的passwordTest方法加密密码，然后密码使用ENC()括起来
        spring.mail.password=
        #编码
        spring.mail.default-encoding=UTF-8
        
## springboot发送邮件说明
    1、测试发送html模板的邮件需要添加依赖
        <!-- thymeleaf -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
# springboot-jasypt01

**springboot对配置文件加密**

## springboot对配置文件加密关键点
    1、在pom.xml文件中添加依赖
        <dependency>
            <groupId>com.github.ulisesbocchio</groupId>
            <artifactId>jasypt-spring-boot-starter</artifactId>
            <version>1.14</version>
        </dependency>
    2、在application.properties文件中定义加密密码，可以使用UUID生成的，执行passwordTest方法
        jasypt.encryptor.password=944ec5b7-148f-4db6-ae0e-612a5106507b
    3、在JasyptApplicationTests测试类中提前将密码进行加密
        执行contextLoads测试方法
    4、在application.properties文件中用ENC()将加密后的密码括起来
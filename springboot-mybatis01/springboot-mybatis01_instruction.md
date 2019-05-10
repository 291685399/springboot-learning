# springboot-mybatis01

**springboot整合mybatis实现增删改查**

## springboot整合mybatis关键点
    1、在pom.xml文件中添加依赖
        <!-- mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.0</version>
        </dependency>
        <!-- mysql -->
         <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
             <scope>runtime</scope>
         </dependency>

    2、在application.properties文件中配置dataSource
        spring.datasource.driver-class-name=com.mysql.jdbc.Driver
        spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot-mybatis01?allowMultiQueries=true&useUnicode=true&useSSL=false&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull
        spring.datasource.username=root
        spring.datasource.password=root
        
    3、指定mapper.xml文件的路径
        mybatis.mapper-locations=classpath*:mapper/*.xml
       
    4、指定实体类的别名（可以不配置，但是要在mapper.xml文件中指定实体类的具体引用路径）
        mybatis.type-aliases-package=com.wyj.entity

    5、在springboot启动类中APIApplication.java中指定mapper扫描器扫描mapper的路径
    （具体到指定包的路径，可以使用通配符的方式，例如：com.wyj.**.mapper）
        @MapperScan(basePackages = "com.wyj.mapper")
# springboot-dubbo01

**springboot整合dubbo**

## springboot整合dubbo说明
    springboot-dubbo01-api-web：
        存放controller
        存放handler
        存放interceptor
    springboot-dubbo01-service：
        存放实体类
        存放Enum
        存放工具类
        存放service接口
    springboot-dubbo01-service-impl：
        存放service接口实现类
        存放mapper接口
        存放mapper.xml文件

## springboot整合dubbo关键点
    1、创建springboot-dubbo01项目，为maven空项目
        (1)、在pom.xml文件中添加依赖
            <parent>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>2.0.0.RELEASE</version>
            </parent>
            <modules>
                <module>springboot-dubbo01-api-web</module>
                <module>springboot-dubbo01-service-impl</module>
                <module>springboot-dubbo01-service</module>
            </modules>
        
    2、创建springboot-dubbo01-api-web模块，为springboot项目
        (1)、在pom.xml文件中添加依赖
            <parent>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo01</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </parent>
            <!-- dubbo -->
            <dependency>
                <groupId>io.dubbo.springboot</groupId>
                <artifactId>spring-boot-starter-dubbo</artifactId>
                <version>1.0.0</version>
            </dependency>
            <!-- 项目依赖，去除springboot整合mybatis的jar包原因是该jar包中会自动注入sqlsession，需要在api层配置DataSource相关参数 -->
            <dependency>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo01-service-impl</artifactId>
                <version>0.0.1-SNAPSHOT</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.mybatis.spring.boot</groupId>
                        <artifactId>mybatis-spring-boot-starter</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
        (2)、在application.properties中添加
            # tomcat
            server.port=8080
            # dubbo
            spring.dubbo.application.name=demo-consumer
            spring.dubbo.registry.address=zookeeper://127.0.0.1:2181
            spring.dubbo.scan=com.wyj.controller
        (3)、在ApiApplication.java中添加
            @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
        (4)、controller中使用@Reference来注入bean
        
    3、创建springboot-dubbo01-service模块，为maven-quickstart项目
    
    4、创建springboot-dubbo01-service-impl模块，为springboot项目
        (1)、在pom.xml文件中添加依赖
            <parent>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo01</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </parent>
            <!-- dubbo -->
            <dependency>
                <groupId>io.dubbo.springboot</groupId>
                <artifactId>spring-boot-starter-dubbo</artifactId>
                <version>1.0.0</version>
            </dependency>
            <!-- 日志 -->
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-api</artifactId>
                <version>1.7.25</version>
            </dependency>
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>log4j-over-slf4j</artifactId>
            </dependency>
        (2)、在application.properties中添加
            # tomcat
            server.port=8081
            # dubbo
            spring.dubbo.application.name=demo-provider
            pring.dubbo.registry.address=zookeeper://127.0.0.1:2181
            spring.dubbo.protocol.name=dubbo
            spring.dubbo.protocol.port=20880
            spring.dubbo.scan=com.wyj.service.impl
            # dataBase
            spring.datasource.driver-class-name=com.mysql.jdbc.Driver
            spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot-dubbo01?allowMultiQueries=true&useUnicode=true&useSSL=false&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull
            spring.datasource.username=root
            spring.datasource.password=root
            spring.datasource.max-idle=10
            spring.datasource.max-wait=10000
            spring.datasource.min-idle=5
            spring.datasource.initial-size=5
            # mybatis
            mybatis.mapper-locations=classpath:mapper/*.xml
        (3)、在ServiceApplication.java中添加
            @MapperScan(basePackages = "com.wyj.mapper")
        (4)、在service接口实现类中使用@com.alibaba.dubbo.config.annotation.Service来注册bean并暴露服务
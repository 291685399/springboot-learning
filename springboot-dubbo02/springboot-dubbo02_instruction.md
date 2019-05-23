# springboot-dubbo02

**springboot整合dubbo**

## springboot整合dubbo说明
    springboot-dubbo02-api-web：
        存放controller
        存放handler
        存放interceptor
    springboot-dubbo02-service：
        存放实体类
        存放Enum
        存放工具类
        存放service接口
    springboot-dubbo02-service-impl：
        存放service接口实现类
        存放mapper接口
        存放mapper.xml文件

## springboot整合dubbo关键点
    1、创建springboot-dubbo02项目，为maven空项目
        (1)、在pom.xml文件中添加依赖
            <parent>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>2.0.0.RELEASE</version>
            </parent>
            <modules>
                <module>springboot-dubbo02-api-web</module>
                <module>springboot-dubbo02-service-impl</module>
                <module>springboot-dubbo02-service</module>
            </modules>
        
    2、创建springboot-dubbo-api-web模块，为springboot项目
        (1)、在pom.xml文件中添加依赖
            <parent>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo02</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </parent>
            <!-- dubbo -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>dubbo</artifactId>
                <version>2.5.3</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <!-- zookeeper -->
            <dependency>
                <groupId>org.apache.zookeeper</groupId>
                <artifactId>zookeeper</artifactId>
                <version>3.4.6</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.slf4j</groupId>
                        <artifactId>slf4j-log4j12</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>log4j</groupId>
                        <artifactId>log4j</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>com.github.sgroschupf</groupId>
                <artifactId>zkclient</artifactId>
                <version>0.1</version>
            </dependency>
            <!-- 项目依赖 -->
            <dependency>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo02-service</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </dependency>
        (2)、在application.properties中添加
            # tomcat
            server.port=8080
            # dubbo
            dubbo.application.name=demo-consumer
            dubbo.registry.address=zookeeper://127.0.0.1:2181
            dubbo.protocol.name=dubbo
        (3)、在ApiApplication.java中添加
            @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
            @ImportResource("classpath:dubbo-customer.xml")
        (4)、controller中使用@Autowired来注入bean
        (5)、在dubbo-customer.xml文件中配置
            <dubbo:reference id="demoService" interface="com.wyj.service.DemoService"/>
            其中interface为接口的引用，id为服务的id，要和dubbo-provider.xml文件中的ref保持一致
        
    3、创建springboot-dubbo02-service模块，为maven-quickstart项目
    
    4、创建springboot-dubbo02-service-impl模块，为springboot项目
        (1)、在pom.xml文件中添加依赖
            <parent>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo02</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </parent>
            <!-- dubbo -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>dubbo</artifactId>
                <version>2.5.3</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <!-- zookeeper -->
            <dependency>
                <groupId>org.apache.zookeeper</groupId>
                <artifactId>zookeeper</artifactId>
                <version>3.4.6</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.slf4j</groupId>
                        <artifactId>slf4j-log4j12</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>log4j</groupId>
                        <artifactId>log4j</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>com.github.sgroschupf</groupId>
                <artifactId>zkclient</artifactId>
                <version>0.1</version>
            </dependency>
            <!-- 项目依赖 -->
            <dependency>
                <groupId>com.wyj</groupId>
                <artifactId>springboot-dubbo02-service</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </dependency>
            <!-- 日志 -->
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-log4j12</artifactId>
            </dependency>
        (2)、在application.properties中添加
            # tomcat
            server.port=8081
            # dubbo
            dubbo.application.name=demo-provider
            dubbo.registry.address=zookeeper://127.0.0.1:2181
            dubbo.protocol.name=dubbo
            dubbo.protocol.port=20880
            # dataBase
            spring.datasource.driver-class-name=com.mysql.jdbc.Driver
            spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot-dubbo02?allowMultiQueries=true&useUnicode=true&useSSL=false&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull
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
            @ImportResource("classpath:dubbo-provider.xml")
        (4)、在service接口实现类中使用@Service来注册bean
        (5)、在dubbo-provider.xml文件中配置
            <dubbo:service interface="com.wyj.service.DemoService" ref="demoService"/>
            其中interface为接口的引用，ref为暴露服务的名称，首字母小写
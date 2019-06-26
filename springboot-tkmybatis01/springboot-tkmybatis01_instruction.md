# springboot-swagger201

**springboot整合tkmybatis**

## springboot整合tkmybatis关键点
    1、pom.xml
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper</artifactId>
            <version>4.1.5</version>
        </dependency>
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
            <version>2.1.5</version>
        </dependency>
    
    2、新建mapper继承Mapper<>
        public interface UserMapper extends Mapper<User>
        
    3、在启动器上定义mapper扫描器
        @MapperScan("com.wyj.mapper")
        
    4、在实体类，注意：这里的int必须使用Integer
        @Data
        @Entity
        public class User implements Serializable {
            @Id
            @KeySql(useGeneratedKeys = true)
            private Integer id;
            private String name;
            private String sex;
            private Integer age;
            private String address;
            private String phone;
        }
        
    5、application.properties文件配置
        #tomcat port
        server.port=8080
        #datasource
        spring.datasource.driver-class-name=com.mysql.jdbc.Driver
        spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot-tkmybatis01?allowMultiQueries=true&useUnicode=true&useSSL=false&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull
        spring.datasource.username=root
        spring.datasource.password=root
        #logging
        logging.level.com.wyj.mapper:debug
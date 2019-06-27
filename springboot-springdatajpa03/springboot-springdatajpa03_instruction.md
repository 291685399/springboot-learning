# springboot-springdatajpa03

**springboot整合SpringDataJpa自定义查询sql**

## springboot整合SpringDataJpa自定义查询sql关键点
    1、在pom.xml文件中添加依赖
        <!-- redis -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

    2、在application.properties文件中配置jpa配置
        # datasource
        spring.datasource.url=jdbc:mysql://188.131.247.26:3306/springboot-springdatajpa01?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
        spring.datasource.driver-class-name=com.mysql.jdbc.Driver
        spring.datasource.username=root
        spring.datasource.password=root
        # springdatajpa
        #打印出自动生产的SQL，方便调试的时候查看
        spring.jpa.show-sql=true
        #更新数据库表结构
        spring.jpa.hibernate.ddl-auto=update
        #对打印的sql进行格式化，方便查看
        spring.jpa.properties.hibernate.format_sql=true
        spring.jpa.properties.hibernate.use_sql_comments ＝ true
        #指定生成表名的存储引擎为InneoDB
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
        
    3、自定义UserRepository接口集成Repository<User, Long>，User为实体类
    
    4、在UserRepository接口中新建查询方法，并使用@Query编写sql语句
        (1)、?1和?2表示参数的顺序
            @Query("select u from User u where u.id=?1 and u.name=?2")
            public User findUserByIdAndName(Long id, String name);
        (2)、:id表示用注解@Param标识的
            @Query("select u from User u where u.id=:id")
            public User findUserByParam(@Param("id") Long id);
        (3)、指定了nativeQuery = true，即使用原生的sql语句查询
            @Query(value = "select * from user where id=?1", nativeQuery = true)
            public User findUserByNativeQuery(int id);
        (4)、使用SpEL表达式，#{#entityName}表示实体类对应的数据库表名
            @Query("select u from #{#entityName} u where u.name = ?1")
            public List<User> findByLastname(String name);
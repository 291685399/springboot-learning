# springboot-springdatajpa01

**springboot整合springdatajpa实现增删改查、分页、排序功能**

## springboot整合springdatajpa、分页、排序功能关键点
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
        
    3、新建UserCrudRepository接口继承CrudRepository<User, Long>，User为实体类，CrudRepository接口中实现了基本的增删改查方法，直接调用即可
        (1)、新增：
            User result = userCrudRepository.save(user);
        (2)、修改：
            User result = userCrudRepository.save(user);
        (3)、查询
            Optional<User> userOptional = userCrudRepository.findById(1L);
            User result = userOptional.get();
        (4)、查询所有：
            List<User> userList = (List<User>) userCrudRepository.findAll();
        (5)、计算总数：
            long count = userCrudRepository.count();
    
    4、新建UserPageRepository接口继承JpaRepository<User, Long>，JpaRepository接口中实现了分页、排序方法，直接调用即可
        (1)、排序查询：
            List<User> userList = (List<User>) userPageRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        (2)、分页查询：
            Page<User> userPage = userPageRepository.findAll(new PageRequest(0, 20));
            
    5、新建UserJpaRepository接口继承JpaRepository<User, Long>，JpaRepository接口中实现了基本的增删改查、排序、分页、模糊查询方法，直接调用即可
        (1)、批量保存数据：
            userJpaRepository.saveAll(list);
        (2)、查询所有数据：
            List<User> userlists = userJpaRepository.findAll();
        (3)、排序查询：
            List<User> lists = userJpaRepository.findAll(Sort.by(Sort.Direction.ASC, "age"));
        (4)、分页查询：
            Page<User> userPage = userJpaRepository.findAll(new PageRequest(0, 1));
        (5)、分页排序查询：
            PageRequest pageRequest = new PageRequest(0, 3, Sort.by(Sort.Direction.ASC, "age"));
            Page<User> userPage = userJpaRepository.findAll(pageRequest);
            List<User> userList = userPage.getContent();
        (6)、根据id 的集合获取所有数据：
            List<User> userList = userJpaRepository.findAllById(ids);
        (7)、批量删除所有数据：
            userJpaRepository.deleteAllInBatch();
        (8)、保存数据并刷新缓存：
            User result = userJpaRepository.saveAndFlush(user);
        (9)、批量删除：
            userJpaRepository.deleteInBatch(userList);
        (10)、根据id 获取数据：
            User user = userJpaRepository.findById(1L).get();
        (11)、模糊查询，示例匹配器ExampleMatcher：
            List<User> list = userJpaRepository.findAll(Example.of(user));
        (12)、模糊查询：
            User user = new User();
            user.setName("ljk");
            user.setAddress("beijing");
            user.setAge(18);
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                    .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                    .withIgnorePaths("id");//忽略字段，即不管id是什么值都不加入查询条件
            Example<User> example = Example.of(user, matcher);
            List<User> userList = userJpaRepository.findAll(example);
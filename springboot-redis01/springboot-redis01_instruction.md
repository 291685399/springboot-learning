# springboot-mybatis-plus01

**springboot整合mybatis-plus实现增删改查**

## springboot整合mybatis-plus关键点
    1、在pom.xml文件中添加依赖
        <!-- redis -->
        <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

    2、在application.properties文件中配置redis配置（不同springboot的版本redis的配置可能不一样）
        spring.redis.database=1
        spring.redis.host=127.0.0.1
        spring.redis.port=6379
        spring.redis.password=
        spring.redis.jedis.pool.max-active=1000
        spring.redis.jedis.pool.max-wait=-1ms
        spring.redis.jedis.pool.max-idle=10
        spring.redis.jedis.pool.min-idle=2
        spring.redis.timeout=500ms
        
    3、在RedisService接口中声明redis的常用操作
    
    4、在RedisServiceImpl接口实现类中实现RedisService接口，注入StringRedisTemplate Api接口，
    通过调用StringRedisTemplate中的方法对redis进行操作
        @Autowired
        private StringRedisTemplate redisTemplate;
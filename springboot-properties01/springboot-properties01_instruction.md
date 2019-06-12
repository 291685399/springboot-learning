# springboot-properties01

**springboot读取属性文件**

## springboot读取属性文件关键点
    1、在pom.xml文件中添加依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

    2、使用@Value读取application.properties中的属性
        @Value("${com.wyj.user.name}")
        private String name;
        
    3、使用Environment读取application.properties中的属性
        @Autowired
        private Environment environment;
    
        environment.getProperty("com.wyj.user.name")
    
    4、用ConfigurationProperties读取指定属性文件中的属性
        @Configuration
        @ConfigurationProperties(prefix = "com.wyj.user")
        @PropertySource(value = "classpath:resource.properties")
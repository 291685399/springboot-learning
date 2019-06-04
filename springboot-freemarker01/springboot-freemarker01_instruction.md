# springboot-freemarker01

**springboot整合freemarker**

## springboot整合freemarker关键点
    1、在pom.xml文件中添加依赖
        <!-- freemarker -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
    2、在application.properties中添加配置
        #freemarker静态资源配置
        #设定ftl文件路径
        spring.freemarker.template-loader-path=classpath:/templates
        #关闭缓存，即使刷新，上线生产环境需要改为true
        spring.freemarker.cache=false
        spring.freemarker.charset=UTF-8
        spring.freemarker.check-template-location=true
        spring.freemarker.content-type=text/html
        spring.freemarker.expose-request-attributes=true
        spring.freemarker.expose-session-attributes=true
        spring.freemarker.request-context-attribute=request
        spring.freemarker.suffix=.ftl
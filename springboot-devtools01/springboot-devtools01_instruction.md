# springboot-devtools01

**springboot使用热部署**

## springboot使用热部署关键点
    1、在pom.xml文件中添加依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    2、开启IDEA对热部署的支持
        (1)、Settings --> Build，Execution，Deployment --> 勾选Build project automatically
        ​<img src="https://github.com/291685399/springboot-learning/tree/master/springboot-devtools01/src/main/resources/images/Build project automatically.png" width="500px">
        (2)、按快捷键Ctrl + Shift + Alt + /，选择Registry，勾选compiler.automake.allow.when.app.running
        ​<img src="https://github.com/291685399/springboot-learning/tree/master/springboot-devtools01/src/main/resources/images/Registry.png" width="500px">
        ​<img src="https://github.com/291685399/springboot-learning/tree/master/springboot-devtools01/src/main/resources/images/compiler.automake.allow.when.app.running.png" width="500px">
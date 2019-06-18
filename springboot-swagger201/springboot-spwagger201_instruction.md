# springboot-swagger201

**springboot整合swagger2生成在线接口文档**

## springboot整合swagger2生成在线接口文档关键点
    1、在pom.xml文件中添加依赖
        <!-- swagger2 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.7.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.7.0</version>
        </dependency>
        <dependency>
            <groupId>repos.io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.7.0</version>
        </dependency>

    2、在Swagger2Application.java文件中添加注解开启swagger2
        @EnableSwagger2
        
    3、创建Swagger2Config配置类，配置swagger2
        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.wyj.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }
        @Bean
        public ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("API文档")//接口文档主题
                    .description("API网关接口：http://www.baidu.com")//地址
                    .termsOfServiceUrl("www.taobao.com")//路径
                    .version("1.0.0")//版本号
                    .build();
        }
    
    4、在Controller接口添加注解用于说明参数相关信息
        @ApiOperation("测试接口")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "name", value = "姓名", required = false, dataType = "String", paramType = "query"),
                @ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "String", paramType = "query")
        })
        @RequestMapping(value = "/demo", method = RequestMethod.POST)
        public String demo(String name, String password) {
            return "hhh";
        }
        
    5、常用的Swagger2注解：
        @Api：修饰整个类，描述Controller的作用
        @ApiOperation：描述一个类的一个方法，或者说一个接口
        @ApiParam：单个单数描述
        @ApiModel：用对象来接收参数
        @ApiProperty：用对象接收参数时，描述对象的一个字段
        @ApiResponse：HTTP响应其中一个描述
        @ApiResponses：HTTP响应整体描述
        @ApiIgnore：使用该注解忽略这个API
        @ApiError：发生错误返回的信息
        @ApiImplicitParam：一个请求参数
        @ApiImplicitParams：多个请求参数
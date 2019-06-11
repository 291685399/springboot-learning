# springboot-interceptor01

**springboot拦截器**

## springboot拦截器关键点
    1、自定义拦截器实现HandlerInterceptor接口，重写方法
        preHandle()：在请求处理之前进行调用（Controller方法调用之前）
        postHandle()：请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
        afterCompletion()：在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    2、自定义WebMVCConfiguration配置类，有三种实现方式
        (1)、在springboot2.0.0之前继承WebMvcConfigurerAdapter类，重写addInterceptors方法
        (2)、在springboot2.0.0之后实现WebMvcConfigurer接口，重写addInterceptors方法
        (3)、在springboot2.0.0之后继承WebMvcConfigurationSupport类，重写addInterceptors方法
        在重写addInterceptors方法中添加需要拦截的url
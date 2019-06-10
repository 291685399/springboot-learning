# springboot-async01

**springboot异步任务**

## springboot异步任务关键点
    1、在启动类Asyncapplication.java中添加注解用于开启一步任务
        @EnableAsync
    2、新建异步任务处理类AsyncTasks
        (1)、用@component标识异步任务处理类AsyncTasks
        (2)、用@Async标识异步任务处理方法，返回值为Future<Boolean>
    3、新建controller用于执行异步任务
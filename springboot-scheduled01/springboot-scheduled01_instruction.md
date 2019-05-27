# springboot-scheduled01

**springboot执行定时任务**

## springboot执行定时任务关键点
    1、在ScheduledApplication.java文件中使用注解开启定时任务
        @EnableScheduling
    2、在定时任务类中添加注解能被spring扫描并识别
        @Component
    3、在方法前添加注解
        @Scheduled(cron = "*/5 * * * * ?")
        括号里面的代表定时任务执行的时间
        例如：
        @Scheduled(fixedRate = 5000) ：上一次开始执行之后5秒再执行
        @Scheduled(fixedDelay = 5000) ：上一次执行完之后5秒再执行
        @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
        @Scheduled(cron = "* /5 * * * * ?") ：通过cron表达式定义规则
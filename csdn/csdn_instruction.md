# csdn

**通过浏览器访问csdn博客，并设置访问间隔时间，从而达到刷取csdn访问量的效果**

## 需要的环境：
    1、Chrome谷歌浏览器：用于访问博客网址
        （建议使用Chrome，因为Chrome一直测试没有问题，其他的浏览器没有测试过）
    2、jre：用于Java程序

## 需要修改的地方：
    1、在blogAddress.txt文件中添加你的blogName和blogAddress
        指定格式为：blogName：你的博客名称；blogAddress：你的博客地址
        注意：一定要按照指定格式配置博客名称和地址
    2、在application.properties文件配置你的blogSleepTime和chromeSleepTime参数
        (1)、blogSleepTime：访问每个博客网址之间的间隔，我在配置文件中设置的是5秒，不建议设置的过低，因为csdn存放管理员，
            能够监控到你的访问量异常，最后的结果就是访问量清零，不影响其他使用
        (2)、chromeSleepTime：blogAddress.txt中配置的博客地址为一组，当访问完一组后休眠的时间，我在配置文件中设置的是5分钟，
            如果blogAddress.txt中配置的博客地址过多，建议设置休眠时间长一点，不建议设置的过低，理由同上
    
## 具体的操作流程：
    1、在命令行cd进入csdn目录，执行maven打包命令：mvn clean package -Dmaven.test.skip=true
    2、将打好的包放在你想放的目录，在resource目录下有一个start.cmd文件，将它复制到和csdn.jar包同级目录下
    3、修改start.cmd文件：使用记事本打开该文件，在cd后修改jar包的路径（如果不在c盘，先cd到其他盘，再cd到其他盘的路径，
    看下面的例子）
        比如我放的路径在D:\aaa\下，我需要cd的命令：
        cd D:
        cd D:\aaa\
        比如我放的路径在C:\Users\WYJ\Desktop，我需要cd的命令：
        cd C:\Users\WYJ\Desktop

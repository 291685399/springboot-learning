package com.wyj.controller;

import com.wyj.tasks.AsyncTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * 如果执行中的异步任务发生异常不影响其他异步任务的执行和整的流程
 * 异步任务使用场景：发送短信，发送邮件、消息推送
 *
 * @author wyj
 * @create 2019-06-01 21:20
 */
@RestController
public class DoAsyncTasksController {

    @Autowired
    private AsyncTasks asyncTasks;

    @RequestMapping("test")
    public String test() throws Exception {
        long start = System.currentTimeMillis();
        //执行异步任务
        Future<Boolean> a = asyncTasks.doTask11();
        Future<Boolean> b = asyncTasks.doTask22();
        Future<Boolean> c = asyncTasks.doTask33();
        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);
        return times;
    }

}

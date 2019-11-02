package com.wyj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 定义切入点，切入点为com.wyj下的所有函数
     */
    @Pointcut("execution(public * com.wyj..*.*(..))")
    public void webLog() {
    }

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("前置通知");
    }

    /**
     * 后置通知：处理完请求，返回内容
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("后置通知 ");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("webLog()")
    public void afterThrowingPrintLog() {
        logger.info("异常通知");
    }

    /**
     * 最终通知
     */
    @After("webLog()")
    public void afterPrintLog() {
        logger.info("最终通知");
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            logger.info("环绕通知 -> 前置通知");
            rtValue = pjp.proceed();
            logger.info("环绕通知 -> 后置通知");
        } catch (Throwable e) {
            logger.info("环绕通知 -> 异常通知");
            e.printStackTrace();
        } finally {
            logger.info("环绕通知 -> 最终通知");
        }
        return rtValue;
    }
}

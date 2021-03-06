package ankang.spring.learn.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-16
 */
@Component
@Aspect
public class LogUtils {

    @Pointcut("execution(public void ankang.spring.learn.service.TransferService.transfer(String,String,int))")
    public void pt1(){}

    /**
     * 执行之前
     */
    @Before("pt1()")
    public void beforeMethod() {
        System.out.println("业务逻辑开始执行之前。。。。。。。。。");
    }

    /**
     * 业务逻辑执行结束时执行，无论是否异常都会执行
     */
    @After("pt1()")
    public void afterMethod() {
        System.out.println("业务逻辑执行结束时执行，无论是否异常都会执行。。。。。。。。");
    }

    /**
     * 业务逻辑异常时执行
     */
    @AfterThrowing("pt1()")
    public void exceptionMethod() {
        System.out.println("业务逻辑异常时执行。。。。。。。。");
    }

    /**
     * 业务逻辑正常时执行
     */
    @AfterReturning("pt1()")
    public void successMethod() {
        System.out.println("业务逻辑正常时执行。。。。。。。。");
    }


    /**
     * 环绕增强，环绕增强可以控制原方法是否执行
     *
     * @param proceedingJoinPoint
     */
    @Around("execution(public void ankang.spring.learn.service.TransferService.transfer(String,String,int))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知中的before。。。。。。。。");
        try {
            // 可以控制原有逻辑是否执行
            final Object proceed = proceedingJoinPoint.proceed();
            System.out.println("环绕通知中的success。。。。。。。。");
            return proceed;
        } catch (Throwable throwable) {
            System.out.println("环绕通知中的exception。。。。。。。。");
        } finally {
            System.out.println("环绕通知中的after。。。。。。。。");
        }

        return null;
    }


}

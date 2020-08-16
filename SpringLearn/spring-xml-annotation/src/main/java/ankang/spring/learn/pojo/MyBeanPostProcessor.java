package ankang.spring.learn.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-14
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 6. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调⽤该接⼝的预初始化⽅法postProcessBeforeInitialzation() 对 Bean 进⾏加⼯操作，此处⾮常重要，javax.swing.Spring 的 AOP 就是利⽤它实现的。
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean , String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor开始方法。");
        return bean;
    }

    /**
     * 9. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调⽤该接⼝的初始化⽅法 postProcessAfterInitialization()。此时，Bean 已经可以被应⽤系统使⽤了。
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor结束方法。");
        return bean;
    }

}

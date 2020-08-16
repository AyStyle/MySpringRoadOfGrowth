package ankang.spring.learn.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PreDestroy;

/**
 * @author 应癫
 */
public class Result implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    /*
     * 1. 根据配置情况调用 org.springframework.context.annotation.Bean 构造方法或⼯⼚方法实例化 Bean。
     * 2. 利用依赖注⼊完成 Bean 中所有属性值的配置注⼊。
     * 3. 如果 Bean 实现了 BeanNameAware 接口，则 Spring 调用 Bean 的 setBeanName() 方法传⼊当前 Bean 的 id 值。
     * 4. 如果 Bean 实现了 BeanFactoryAware 接口，则 Spring 调用 setBeanFactory() 方法传⼊当前⼯⼚实例的引用。
     * 5. 如果 Bean 实现了 ApplicationContextAware 接口，则 Spring 调用 setApplicationContext() 方法传⼊当前 ApplicationContext 实例的引用。
     * 6. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调用该接口的预初始化方法postProcessBeforeInitialzation() 对 Bean 进⾏加⼯操作，此处非常重要，javax.swing.Spring 的 AOP 就是利用它实现的。
     * 7. 如果 Bean 实现了 InitializingBean 接口，则 Spring 将调用 afterPropertiesSet() 方法。
     * 8. 如果在配置⽂件中通过 init-method 属性指定了初始化方法，则调用该初始化方法。
     * 9. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调用该接口的初始化方法 postProcessAfterInitialization()。此时，Bean 已经可以被应用系统使用了。
     * 10. 如果在 <bean> 中指定了该 Bean 的作用范围为 scope="singleton"，则将该 Bean 放⼊ Spring IoC 的缓存池中，将触发 Spring 对该 Bean 的⽣命周期管理；如果在 <bean> 中指定了该 Bean 的作用范围为 scope="prototype"，则将该 Bean 交给调用者，调用者管理该Bean的生命周期
     * 11. 如果 Bean 实现了 DisposableBean 接口，则 Spring 会调用 destory() 方法将 Spring 中的 Bean 销毁。
     * 12. 如果在配置⽂件中通过 destory-method 属性指定了 Bean 的销毁方法，则 Spring 将调用该方法对 Bean 进⾏销毁。
     * 注意：Spring 为 Bean 提供了细致全⾯的⽣命周期过程，通过实现特定的接口或 <bean> 的属性设置，都可以对 Bean 的⽣命周期过程产⽣影响。虽然可以随意配置 <bean> 的属性，但是建议不要过多地使用 Bean 实现接口，因为这样会导致代码和 Spring 的聚合过于紧密
     */


    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * 3. 如果 Bean 实现了 BeanNameAware 接口，则 Spring 调用 Bean 的 setBeanName() 方法传⼊当前 Bean 的 id 值。
     *
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("定义Bean时使用的id：" + name);
    }

    /**
     * 4. 如果 Bean 实现了 BeanFactoryAware 接口，则 Spring 调用 setBeanFactory() 方法传⼊当前⼯⼚实例的引用。
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生成Bean时使用的工厂：" + beanFactory);
    }

    /**
     * 5. 如果 Bean 实现了 ApplicationContextAware 接口，则 Spring 调用 setApplicationContext() 方法传⼊当前 ApplicationContext 实例的引用。
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("高级容器接口ApplicationContext：" + applicationContext);
    }


    /**
     * 6. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调用该接口的预初始化方法postProcessBeforeInitialzation() 对 Bean 进⾏加⼯操作，此处非常重要，javax.swing.Spring 的 AOP 就是利用它实现的。
     * 备注：参考{@link ankang.spring.learn.pojo.MyBeanPostProcessor}
     */

    // 插曲：注解指定的初始化方法优先于InitializingBean接口的销毁方法
    @PreDestroy
    public void annotationInit() {
        System.out.println("注解指定的初始化方法。。。");
    }

    /**
     * 7. 如果 Bean 实现了 InitializingBean 接口，则 Spring 将调用 afterPropertiesSet() 方法。
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口中的初始化方法。。。。。。");
    }

    /**
     * 8. 如果在配置⽂件中通过 init-method 属性指定了初始化方法，则调用该初始化方法。
     */
    public void initMethod() {
        System.out.println("<bean>标签指定的初始化方法。。。");
    }

    /**
     * 9. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调用该接口的初始化方法 postProcessAfterInitialization()。此时，Bean 已经可以被应用系统使用了。
     * 备注：参考{@link ankang.spring.learn.pojo.MyBeanPostProcessor}
     * <p>
     * 10. 如果在 <bean> 中指定了该 Bean 的作用范围为 scope="singleton"，则将该 Bean 放⼊ Spring IoC 的缓存池中，将触发 Spring 对该 Bean 的⽣命周期管理；如果在 <bean> 中指定了该 Bean 的作用范围为 scope="prototype"，则将该 Bean 交给调用者，调用者管理该Bean的生命周期
     */

    // 插曲：注解指定的销毁方法优先于DisposableBean接口的销毁方法
    @PreDestroy
    public void annotationDestroy() {
        System.out.println("注解指定的销毁方法。。。");
    }

    /**
     * 11. 如果 Bean 实现了 DisposableBean 接口，则 Spring 会调用 destory() 方法将 Spring 中的 Bean 销毁。
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口中销毁方法。。。");
    }

    /**
     * 12. 如果在配置⽂件中通过 destory-method 属性指定了 Bean 的销毁方法，则 Spring 将调用该方法对 Bean 进⾏销毁。
     */
    public void destroyMethod() {
        System.out.println("<bean>标签指定的销毁方法。。。");
    }


}

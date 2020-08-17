# Spring学习笔记

#### Spring简介
    Spring是分层的full-stack轻量级开源框架，以Loc和AOP为内核，
    提供了展现层SpringMVC和业务层事务管理等众多的企业级应用技术，
    还能整合开源世界众多著名的第三方框架和类库
    
#### Spring的优势
    1.方便解耦，简化开发
    2.AOP编程的支持
    3.声明式事务的支持
    4.方便程序的测试
    5.方便集成各种优秀框架
    6.降低JavaEE API的使用难度
    7.源码是经典的Java学习范例
    
#### IOC和AOP思想
    注意：IOC和AOP不是Spring提出的，在Spring之前就已经存在，
    只不过更偏向于理论化，spring在技术层把这两个思想做了非常好的实现
    
1. IOC
   1. 什么是IOC？
      1. IOC全称是Inversion of Control（控制反转/反转控制），
          注意它是一个技术思想，不是一个技术实现
      2. 描述的事情：Java开发领域对象的创建，管理的问题
      
         传统开发方式：比如类A依赖于类B，往往会在类A中new一个B对象
         
         IOC思想开发方式：我们不自己去new对象，而是由IOC容器去帮助我们实例化对象并管理它，我们需要使用哪个对象，
              去问IOC容器即可，同时我们失去一个权力（创建、管理对象）也得到一个权力（不用考虑对象的创建、管理等一系列事情）
         
         控制：指的是对象实例化的权力
         
         反转：控制权交给外部环境了（Spring框架、IOC容器）
         
   2. IOC解决了什么问题？答：IOC解决了对象之间的耦合问题
   
   3. IOC和DI的区别
   
          IOC和DI描述的是同一件事情（对象实例化及依赖关系维护），只不过描述的角度不同
      1. IOC：Inversion of Control（控制反转/反转控制），IOC是站在对象的角度来说
      2. DI：Dependency Injection（依赖注入），DI是站在容器的角度来说
      
2. AOP
   1. 什么是AOP？
      1. OOP全称是Object Oriented Programming（面向对象编程）
      
             OOP特点：封装、继承、多态
             OOP是垂直方向上的继承体系
      2. AOP全称是Aspect Oriented Programming（面向切面编程），是OOP的延续
            
             AOP特点：在不改变原有业务逻辑的基础上，增强业务逻辑
             AOP是水平方向上的扩展体系
             
   2. AOP在解决什么问题
   
          在不改变原有业务逻辑情况下，增强横切逻辑代码，根本上解耦合，避免横切逻辑代码重复
          
   3. 为什么叫做面向切面编程
   
          【切】：指的是横切逻辑，原有业务逻辑代码我们不能动，只能操作横切逻辑代码，所有面向横切逻辑
          【面】：横切逻辑代码往往要影响的是很多个方法，每一个方法都如同一个点，多个点构成面
 
#### Spring开发
   1. spring-xml：纯xml开发
   2. spring-xml-annotation（常用）：xml + 注解开发
   3. spring-annotation：纯注解开发
   
#### Spring加载方式
1. 加载classpath资源文件（适用于xml + 注解开发）：ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml")
2. 加载外部资源文件（适用于xml + 注解开发）：ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml")
3. 加载注解配置类（适用于纯注解开发）：ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class)
4. 使用监听器加载（适用于JavaWeb项目）：ContextLoaderListener

#### Spring IOC基础
    BeanFactory和ApplicationContext区别
    BeanFactory（基础容器）是Spring框架IOC容器的顶级接口，定义了容器的一些基础功能和一些基础规范
    ApplicationContext（高级容器）是BeanFactory的子接口，除了BeanFactory功能外还添加了新的功能

#### Spring IOC高级特性
1. lazy-init：延迟加载
   1. bean对象延迟加载-xml：\<bean id="bean" class="Bean" lazy-init="true"/>
   2. bean对象延迟加载-注解：@Lazy
   3. 所有bean对象延迟加载：配置文件开头使用default-lazy-init属性 -> \<beans default-lazy-init="true">
2. FactoryBean和BeanFactory：
   1. BeanFactory：BeanFactory是容器的顶级接口，定义了容器的一些基础行为，负责生产和管理Bean的一个工厂，具体使用它下面的子接口类型：ApplicationContext
   2. FactoryBean：Spring中Bean有两种：一种是普通Bean，一种是工厂Bean（FactoryBean），FactoryBean可以生成某一个类型的Bean实例，我们可以借助于FactoryBean自定义Bean的创建过程
3. 后置处理器：
   1. BeanPostProcessor：Bean对象的后置处理器，在Bean对象实例化之后进行一些后置处理（并不是整个Spring Bean的生命周期完成）
   2. BeanFactoryPostProcessor：BeanFactory对象的后置处理器，在BeanFactory初始化之后可以进行一些后置处理
   + 注意：对象不一定是SpringBean，而SpringBean一定是个对象

#### SpringBean的生命周期
1. 根据配置情况调⽤ Bean 构造⽅法或⼯⼚⽅法实例化 Bean。
2. 利⽤依赖注⼊完成 Bean 中所有属性值的配置注⼊。
3. 如果 Bean 实现了 BeanNameAware 接⼝，则 Spring 调⽤ Bean 的 setBeanName() ⽅法传⼊当前 Bean 的 id 值。
4. 如果 Bean 实现了 BeanFactoryAware 接⼝，则 Spring 调⽤ setBeanFactory() ⽅法传⼊当前⼯⼚实例的引⽤。
5. 如果 Bean 实现了 ApplicationContextAware 接⼝，则 Spring 调⽤ setApplicationContext() ⽅法传⼊当前 ApplicationContext 实例的引⽤。
6. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调⽤该接⼝的预初始化⽅法postProcessBeforeInitialzation() 对 Bean 进⾏加⼯操作，此处⾮常重要，Spring 的 AOP 就是利⽤它实现的。
7. 如果 Bean 实现了 InitializingBean 接⼝，则 Spring 将调⽤ afterPropertiesSet() ⽅法。
8. 如果在配置⽂件中通过 init-method 属性指定了初始化⽅法，则调⽤该初始化⽅法。
9. 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调⽤该接⼝的初始化⽅法 postProcessAfterInitialization()。此时，Bean 已经可以被应⽤系统使⽤了。
10. 如果在 <bean> 中指定了该 Bean 的作⽤范围为 scope="singleton"，则将该 Bean 放⼊ Spring IoC 的缓存池中，将触发 Spring 对该 Bean 的⽣命周期管理；如果在 <bean> 中指定了该 Bean 的作⽤范围为 scope="prototype"，则将该 Bean 交给调⽤者，调⽤者管理该Bean的生命周期
11. 如果 Bean 实现了 DisposableBean 接⼝，则 Spring 会调⽤ destory() ⽅法将 Spring 中的 Bean 销毁。
12. 如果在配置⽂件中通过 destory-method 属性指定了 Bean 的销毁⽅法，则 Spring 将调⽤该⽅法对 Bean 进⾏销毁。
+ 注意：Spring 为 Bean 提供了细致全⾯的⽣命周期过程，通过实现特定的接⼝或 <bean> 的属性设置，都可以对 Bean 的⽣命周期过程产⽣影响。虽然可以随意配置 <bean> 的属性，但是建议不要过多地使⽤ Bean 实现接⼝，因为这样会导致代码和 Spring 的聚合过于紧密

#### Spring AOP
```
AOP本质：在不改变原有业务逻辑的情况下增强横切逻辑，横切逻辑代码往往是日志代码、事务控制代码、性能监控代码。
```

#### AOP 术语
|名词|术语|解释|
|:---:|:---:|---|
|JoinPoint|连接点|指的是用于把增强代码加入到业务主线中的点|
|Pointcut|切入点|指的是把增强代码加到入到业务主线进来之后的连接点|
|Advice|增强|指的是切面类中用于提供增强功能的方法，其分类有：前置增强、后置增强、异常增强、最终增强、环绕增强|
|Target|目标对象|指的是需要增强的对象|
|Proxy|代理|指的是增强后产生的代理对象|
|Weaving|织入|指的是将Advice增强方法加入到Target目标对象中并产生Proxy代理对象的过程|
|Aspect|切面|指的是增强代码所关注的方面|


#### Spring 声明式事务
1. 编程式事务：在业务代码中添加事务控制代码
2. 声明式事务：通过xml或注解配置的方式达到事务控制

#### 什么是事务
```
事务指的是逻辑上的一组操作。
组成这组操作的各个单元，要么全部成功，要么全部失败。
从而确保了数据的准确与安全
```

#### 事务的特性
1. 原子性：原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生
2. 一致性：事务必须使数据库从一个一致性状态变换到另一个一致性状态
3. 隔离性：多个事务可以同时并发执行，但各个事务之间的操作不会对其他事务造成影响
4. 持久性：一旦事务被提交了，那么它对数据库中的数据改变就是永久的，即使接下来数据库发生异常，也不应该对其有任何影响

#### 事务的隔离级别
解决事务的并发问题
+ 不考虑事务隔离级别会导致下面问题：
   1. 脏读：一个线程中的事务读取到了另外一个线程中未提交的数据
   2. 不可重复读：一个线程中的事务读到了另外一个线程中已经提交的数据（前后内容不一致）
   3. 虚读（幻读）：一个线程中的事务读到了另外一个线程中已经提交的insert或delete的数据（前后条数不一致）

+ 事务隔离级别：

|名称|等级|描述|
|:---:|:---:|:---|
|Serializable|最高|可避免脏读、不可重复读、虚读情况的发生（串行化）|
|Repeatable read|第二|可避免脏读、不可重复读，但会有虚读的情况发生（可重复读）|
|Read committed|第三|可避免脏读，不可重复读和虚读一定会发生（读已提交）|
|Read uncommitted|最低|不可避免脏读、不可重复读、虚读情况的发生|

+ 事务的传播行为

|名称|行为|
|:---:|:---|
|PROPAGATION_REQUIRED|如果当前没有事务，则：新建一个事务；如果已经存在一个事务，则：加入到该事务中。（最常见）|
|PROPAGATION_SUPPORTS|支持当前事务，如果当前没有事务，则：以非事务的方式执行|
|PROPAGATION_MANDATORY|使用当前的事务，如果当前没有事务，则：引发异常|
|PROPAGATION_REQUIRES_NEW|新建一个事务，如果当前存在事务，则：把当前事务挂起|
|PROPAGATION_NOT_SUPPORTED|以非事务方式执行操作，如果当前存在事务，则：把当前事务挂起|
|PROPAGATION_NEVER|以非事务方式执行操作，如果当前存在事务，则：抛出异常|
|PROPAGATION_NESTED|如果当前存在事务，则：再创建一个事务嵌套执行；如果当前没有事务，则：创建一个事务执行|




# Spring学习笔记

##### Spring简介
    Spring是分层的full-stack轻量级开源框架，以Loc和AOP为内核，
    提供了展现层SpringMVC和业务层事务管理等众多的企业级应用技术，
    还能整合开源世界众多著名的第三方框架和类库
    
##### Spring的优势
    1.方便解耦，简化开发
    2.AOP编程的支持
    3.声明式事务的支持
    4.方便程序的测试
    5.方便集成各种优秀框架
    6.降低JavaEE API的使用难度
    7.源码是经典的Java学习范例
    
##### IOC和AOP思想
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
 
##### Spring开发
   1. spring-xml：纯xml开发     
   2. spring-xml-annotation：xml + 注解开发
   3. spring-annotation：纯注解开发
   
##### Spring加载方式
1. 加载classpath资源文件（适用于xml + 注解开发）：ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml")
2. 加载外部资源文件（适用于xml + 注解开发）：ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml")
3. 加载注解配置类（适用于纯注解开发）：ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class)
4. 使用监听器加载（适用于JavaWeb项目）：ContextLoaderListener

##### Spring IOC基础
1. BeanFactory和ApplicationContext区别
      
       BeanFactory（基础容器）是Spring框架IOC容器的顶级接口，定义了容器的一些基础功能和一些基础规范
       ApplicationContext（高级容器）是BeanFactory的子接口，除了BeanFactory功能外还添加了新的功能

##### Bean的作用范围及生命周期
    single


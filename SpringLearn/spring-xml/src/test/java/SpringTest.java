import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-09
 */
public class SpringTest {

    /**
     * class path xml加载
     */
    @Test
    public void classpathXmlTest() {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        System.out.println(applicationContext.getBean("connectionUtils"));
    }

    /**
     * 文件系统xml加载
     */
    @Test
    public void filepathXmlTest() {
        final ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\Project\\Java\\MySpringRoadOfGrowth\\SpringLearn\\spring-xml\\src\\main\\resources\\spring.xml");
        System.out.println(applicationContext);
    }

    /**
     * Web应用启动
     * 1.需要在web.xml中配置监听器
     * 2.WebApplicationContextUtils.getWebApplicationContext传入Servlet对象的上下文Context对象
     */
    @Test
    public void webApplicationTest() {
//        final ApplicationContext applicationContext  = WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
//        System.out.println(applicationContext);

    }


}













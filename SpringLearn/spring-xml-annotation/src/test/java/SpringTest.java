import ankang.spring.learn.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-13
 */
public class SpringTest {
    @Test
    public void lazyTest() {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        final Result lazyResult = (Result) applicationContext.getBean("lazyResult");
        System.out.println(lazyResult);
    }

}

import ankang.spring.learn.factory.CompanyFactoryBean;
import ankang.spring.learn.pojo.Company;
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

    @Test
    public void factoryBeanTest(){
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // 获取Bean对象直接使用id，获取FactoryBean只需要在id前加上&即可
        final CompanyFactoryBean companyFactoryBean = (CompanyFactoryBean) applicationContext.getBean("&companyBean");
        final Company company = (Company) applicationContext.getBean("companyBean");

        System.out.println(companyFactoryBean);
        System.out.println(company);
    }
}

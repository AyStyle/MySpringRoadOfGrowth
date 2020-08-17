package ankang.spring.learn;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-13
 */
// @Configuration：表明该类是一个Spring配置类
@Configuration
// @ComponentScan：配置包扫描
@ComponentScan({"ankang.spring.learn"})
// @PropertySource：引入外部资源文件
@PropertySource("classpath:druid.properties")
// @Import：引入其它Spring配置文件，统一使用该类导入
// @EnableAspectJAutoProxy：启动AOP配置
@EnableAspectJAutoProxy
// @EnableTransactionManagement：启动声明式事务配置
@EnableTransactionManagement
public class SpringConfig {

    // @Value：引入外部资源文件配置的变量
    @Value("${druid.driver}")
    private String driverClassName;
    @Value("${druid.url}")
    private String url;
    @Value("${druid.username}")
    private String username;
    @Value("${druid.password}")
    private String password;

    /**
     * 引入第三方bean实例对象
     *
     * @return
     */
    // @Bean：表明将方法返回的bean对象加入到SpringIOC管理中
    @Bean("dataSource")
    public DataSource createDataSource() {
        final DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

}

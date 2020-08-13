package ankang.spring.learn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
@PropertySource("")
public class SpringConfig {
}

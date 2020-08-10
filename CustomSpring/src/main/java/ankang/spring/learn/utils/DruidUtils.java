package ankang.spring.learn.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 应癫
 */
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        druidDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("888888");

    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}

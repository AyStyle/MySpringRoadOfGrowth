package ankang.spring.learn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 应癫
 */
@Component
// 指定对象是否为单例
@Scope("singleton")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>(); // 存储当前线程的连接

    @Autowired
    private DataSource dataSource;

    /**
     * 从当前线程获取连接
     */
    public Connection getCurrentThreadConn() throws SQLException {
        /**
         * 判断当前线程中是否已经绑定连接，如果没有绑定，需要从连接池获取一个连接绑定到当前线程
          */
        Connection connection = threadLocal.get();
        if(connection == null) {
            // 从连接池拿连接并绑定到线程
            connection = dataSource.getConnection();
            // 绑定到当前线程
            threadLocal.set(connection);
        }
        return connection;
    }

    // 指定初始化方法，该注解在javax-annotation下
    @PostConstruct
    public void initMethod(){
        System.out.println("配置的初始化方法");
    }

    // 指定销毁方法，使用注解在javax-annotation下
    @PreDestroy
    public void destroy(){
        System.out.println("配置销毁方法");
    }

}

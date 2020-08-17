package ankang.spring.learn.dao.impl;

import ankang.spring.learn.dao.AccountDao;
import ankang.spring.learn.pojo.Account;
import ankang.spring.learn.utils.ConnectionUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 应癫
 */
public class JdbcAccountDaoImpl implements AccountDao {

    private ConnectionUtils connectionUtils;
    private DataSource dataSource;

    private String name;
    private int age;

    private String[] strings;
    private List<String> stringList;
    private Map<String, String> stringMap;
    private Set<String> stringSet;
    private Properties stringProperties;

    public JdbcAccountDaoImpl() {
    }

    public JdbcAccountDaoImpl(ConnectionUtils connectionUtils , String name , int age) {
        this.connectionUtils = connectionUtils;
        this.name = name;
        this.age = age;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringProperties(Properties stringProperties) {
        this.stringProperties = stringProperties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("初始化方法.....");
    }

    public void destory() {
        System.out.println("销毁方法......");
    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        //从连接池获取连接
        // Connection con = DruidUtils.getInstance().getConnection();
        // Connection con = connectionUtils.getCurrentThreadConn();
        Connection con = dataSource.getConnection();
        String sql = "select * from db_spring.account where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1 , cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while (resultSet.next()) {
            account.setCardNo(resultSet.getString("cardNo"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getInt("money"));
        }

        resultSet.close();
        preparedStatement.close();
        //con.close();

        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {

        // 从连接池获取连接
        // 改造为：从当前线程当中获取绑定的connection连接
        //Connection con = DruidUtils.getInstance().getConnection();
//        Connection con = connectionUtils.getCurrentThreadConn();
        Connection con = dataSource.getConnection();

        String sql = "update db_spring.account set money=? where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1 , account.getMoney());
        preparedStatement.setString(2 , account.getCardNo());
        int i = preparedStatement.executeUpdate();

        preparedStatement.close();
        //con.close();
        return i;
    }
}

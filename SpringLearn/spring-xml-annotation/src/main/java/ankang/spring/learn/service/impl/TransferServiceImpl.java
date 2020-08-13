package ankang.spring.learn.service.impl;

import ankang.spring.learn.dao.AccountDao;
import ankang.spring.learn.pojo.Account;
import ankang.spring.learn.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 应癫
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {

    // @Autowired：自动实现依赖注入，注入是按照类型（接口）注入的，被注解的字段可以省略set方法
    @Autowired
    // @Qualifier：如果@Autowired不能唯一锁定注入对象，则可以结合该注解指定特定的对象
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromCardNo , String toCardNo , int money) throws Exception {

        /*try{
            // 开启事务(关闭事务的自动提交)
            TransactionManager.getInstance().beginTransaction();*/

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        accountDao.updateAccountByCardNo(to);
//            int c = 1/0;
        accountDao.updateAccountByCardNo(from);

        /*    // 提交事务

            TransactionManager.getInstance().commit();
        }catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            TransactionManager.getInstance().rollback();

            // 抛出异常便于上层servlet捕获
            throw e;

        }*/


    }
}

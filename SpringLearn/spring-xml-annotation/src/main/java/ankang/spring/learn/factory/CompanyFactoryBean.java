package ankang.spring.learn.factory;

import ankang.spring.learn.pojo.Company;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-13
 */
public class CompanyFactoryBean implements FactoryBean<Company> {

    // 外部注入Company对象属性
    private String companyInfo; // format：公司名,地址

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    /**
     * 创建bean对象
     * @return
     * @throws Exception
     */
    @Override
    public Company getObject() throws Exception {
        // 创建复杂对象Company
        final Company company = new Company();
        final String[] split = companyInfo.split(",");
        company.setName(split[0]);
        company.setAddress(split[1]);

        return company;
    }

    /**
     * 返回bean对象的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Company.class;
    }

    /**
     * bean对象是否为单例
     * true是单例，false不是
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}

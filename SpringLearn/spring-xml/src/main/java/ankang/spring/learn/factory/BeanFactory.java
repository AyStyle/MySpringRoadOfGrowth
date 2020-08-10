package ankang.spring.learn.factory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.beans.BeanDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂类，生产对象（使用反射技术）
 *
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-08
 */
public class BeanFactory {

    /*
     * 任务一：读取解析xml，通过反射技术实例化对象并且存储代用对象
     * 任务二：对外提供获取实例对象的接口（根据id）
     * */

    /**
     * 存储对象：key = id，value = Object
     */
    private static Map<String, Object> ioc = new HashMap<>();

    static {
        // 任务一：读取解析xml，通过反射技术实例化对象并且存储代用对象
        final InputStream resourceAsStream = BeanDescriptor.class.getClassLoader().getResourceAsStream("beans.xml");

        // 解析xml
        final SAXReader saxReader = new SAXReader();
        try {
            final Document document = saxReader.read(resourceAsStream);
            final List<Node> beanList = document.selectNodes("//bean");

            for (Node bean : beanList) {
                // 处理每个bean，获取id和class属性
                final Element element = (Element) bean;
                final String id = element.attributeValue("id");
                final String clsName = element.attributeValue("class");

                // 通过反射技术实例化对象
                final Class<?> cls = Class.forName(clsName);
                final Object instance = cls.getConstructor().newInstance();

                // 存储到ioc容器中
                ioc.put(id , instance);
            }

            // 实例化完成之后维护对象的依赖关系，检查哪些对象需要传值进入，根据它的配置，我们传入相应的值
            // 有property子元素的bean就有传值需求
            final List<Node> propertyList = document.selectNodes("//property");

            for (Node property : propertyList) {
                final Element element = (Element) property;
                final String name = element.attributeValue("name");
                final String ref = element.attributeValue("ref");

                // 解析property获取父元素
                final Element parent = property.getParent();
                final String parentId = parent.attributeValue("id");

                final Object parentObj = ioc.get(parentId);
                // 遍历父对象中的所有方法，找到“set” + name方法
                final Method[] methods = parentObj.getClass().getMethods();
                for (Method method : methods) {
                    if (method.getName().equals("set" + name)){
                        // 使用反射赋值
                        method.invoke(parent, ioc.get(ref));
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String id) {
        return ioc.get(id);
    }

}

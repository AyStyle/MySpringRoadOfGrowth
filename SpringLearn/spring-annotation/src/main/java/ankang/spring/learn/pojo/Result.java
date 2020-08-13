package ankang.spring.learn.pojo;

/**
 * @author 应癫
 */

import org.springframework.context.annotation.Lazy;

//@Lazy：注解开启对象延迟加载
//@Lazy
public class Result {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

package cn.tsx.ioc_02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //单例
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例
public class JavaBean {
    @PostConstruct
    public void init() {
        System.out.println("init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy...");
    }
}

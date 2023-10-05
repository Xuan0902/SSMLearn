package cn.tsx.test;

import cn.tsx.ioc_01.XxxService;
import cn.tsx.ioc_02.JavaBean;
import cn.tsx.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-19
 **/

public class SpringIocTest {
    @Test
    public void testIoc_01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        Object bean = context.getBean("xxxDao");
        System.out.println(bean);

        XxxService bean1 = context.getBean(XxxService.class);
        System.out.println(bean1);
    }

    @Test
    public void testIoc_02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = context.getBean(JavaBean.class);
        System.out.println(bean);
        context.close();
    }

    @Test
    public void testIoc_03(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController bean = context.getBean(UserController.class);
        bean.show();
        context.close();
    }

    @Test
    public void testIoc_04(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        cn.tsx.ioc_04.JavaBean bean = context.getBean(cn.tsx.ioc_04.JavaBean.class);
        System.out.println(bean);
        context.close();
    }
}

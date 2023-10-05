import cn.tsx.ioc_03.HappyComponent;
import cn.tsx.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    /**
     * 创建Ioc容器
     */
    public void createIoc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        /*
          手动进行配置和刷新
          先进行配置，再进行刷新，通常在源码中常见
         */
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();  //仅仅只是创建ioc容器对象
        applicationContext1.setConfigLocations("spring-03.xml");    //进行指定配置文件
        applicationContext1.refresh();  //调用ioc和di的流程
    }

    /**
     * Ioc容器中获取Bean
     */
    @Test
    public void getBeanFromIoc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();
        //获取ioc组件
        HappyComponent happyComponent = applicationContext.getBean("happyComponent", HappyComponent.class);
        happyComponent.doWork();
    }

    @Test
    public void test_04() {
    }

    @Test
    public void test_05() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean);
    }
}

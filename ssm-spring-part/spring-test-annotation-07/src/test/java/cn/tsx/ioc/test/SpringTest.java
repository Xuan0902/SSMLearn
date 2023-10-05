package cn.tsx.ioc.test;

import cn.tsx.components.A;
import cn.tsx.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@SpringJUnitConfig(value = {JavaConfig.class})
public class SpringTest {

    @Autowired
    private A a;

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("a = " + a);
        }
    }
}

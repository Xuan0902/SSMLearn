package cn.tsx.test;

import cn.tsx.service.Calculator;
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
public class SpringAopTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int result = calculator.add(1, 1);
    }
}

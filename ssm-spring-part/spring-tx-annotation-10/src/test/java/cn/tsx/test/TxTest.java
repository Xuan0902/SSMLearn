package cn.tsx.test;

import cn.tsx.config.JavaConfig;
import cn.tsx.service.StudentService;
import cn.tsx.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(classes = JavaConfig.class)
public class TxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void testTx() throws FileNotFoundException {
        topService.topService();
    }
}

package cn.tsx.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description: 全局异常处理器
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public String nullException(RuntimeException e) {
        if (e instanceof NullPointerException) {
            return e.getMessage();
        } else if (e instanceof ArithmeticException) {
            return e.getMessage();
        }
        return "大异常";
    }
}

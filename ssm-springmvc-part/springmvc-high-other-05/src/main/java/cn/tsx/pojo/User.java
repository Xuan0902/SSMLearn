package cn.tsx.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author: ShengXuan
 * @create: 2023-09-26
 * @description: 用户
 **/

@Data
public class User {
    @NotBlank   // 代表字符串不为空且不为空串
    private String name;
    @Length(min = 6)    // 字符串最小长度为6
    private String password;
    @Min(1) // 数值最小为1
    private int age;
    @Email  // 必须为邮箱格式
    private String email;
    @Past   // 时间必须为过去时间
    private Date birthday;
}

package com.tsx.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description: user
 **/
@Data
@Builder
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic // 逻辑删除字段
    private Integer deleted;
    @Version    // 版本号
    private Integer version;
}

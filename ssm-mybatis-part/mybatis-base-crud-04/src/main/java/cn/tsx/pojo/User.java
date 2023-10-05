package cn.tsx.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data // lombok
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
}
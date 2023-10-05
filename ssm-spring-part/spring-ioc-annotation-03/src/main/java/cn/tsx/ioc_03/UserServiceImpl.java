package cn.tsx.ioc_03;

import org.springframework.stereotype.Service;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String show() {
        return "UserServiceImpl show()";
    }
}

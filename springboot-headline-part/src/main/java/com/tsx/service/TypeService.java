package com.tsx.service;

import com.tsx.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tsx.utils.Result;

/**
 * @author Xuan
 * @description 针对表【news_type】的数据库操作Service
 * @createDate 2023-09-30 20:49:17
 */
public interface TypeService extends IService<Type> {

    /**
     * 查找所有的分类
     *
     * @return
     */
    Result findAllTypes();

}

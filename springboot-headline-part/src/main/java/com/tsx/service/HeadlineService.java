package com.tsx.service;

import com.tsx.common.dto.HeadlineDTO;
import com.tsx.common.dto.PortalDTO;
import com.tsx.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tsx.utils.Result;

/**
 * @author Xuan
 * @description 针对表【news_headline】的数据库操作Service
 * @createDate 2023-09-30 20:49:17
 */
public interface HeadlineService extends IService<Headline> {

    /**
     * 根据传入的dto查找
     *
     * @param portalDTO
     * @return
     */
    Result findNewPage(PortalDTO portalDTO);

    /**
     * 根据文章hid查找对应信息
     *
     * @param hid
     * @return
     */
    Result showHeadlineDetail(Integer hid);

    /**
     * 插入headline
     *
     * @param headline
     * @param token
     * @return
     */
    Result publish(Headline headline, String token);

    /**
     * 根据hid回显数据
     *
     * @param hid
     * @return
     */
    Result findHeadlineByHid(int hid);

    /**
     * 更新
     *
     * @param headlineDTO
     * @return
     */
    Result updateHeadline(Headline headline);
}

package com.tsx.mapper;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tsx.common.dto.PortalDTO;
import com.tsx.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Xuan
 * @description 针对表【news_headline】的数据库操作Mapper
 * @createDate 2023-09-30 20:49:17
 * @Entity com.tsx.pojo.Headline
 */
public interface HeadlineMapper extends BaseMapper<Headline> {
    IPage<Map<String, Object>> selectMyPage(IPage<Headline> page, @Param("portalDTO") PortalDTO portalDTO);

    Map<String, Object> selectDetailMap(Integer hid);
}





package cn.tsx.mapper;

import cn.tsx.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Mapper
public interface ScheduleMapper {

    // @Select("select id,title,completed from schedule")
    List<Schedule> queryList();

    int deleteById(@Param("id") int id);

    int add(Schedule schedule);

    int updateById(Schedule schedule);
}

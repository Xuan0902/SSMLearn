package cn.tsx.service;

import cn.tsx.pojo.Schedule;
import cn.tsx.utils.PageBean;
import cn.tsx.utils.R;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

public interface ScheduleService {
    PageBean<Schedule> page(int pageSize, int currentPage);

    R deleteById(int id);

    R add(Schedule schedule);

    R updateById(Schedule schedule);
}

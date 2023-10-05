package cn.tsx.service.impl;

import cn.tsx.mapper.ScheduleMapper;
import cn.tsx.pojo.Schedule;
import cn.tsx.service.ScheduleService;
import cn.tsx.utils.PageBean;
import cn.tsx.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public PageBean<Schedule> page(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> scheduleList = scheduleMapper.queryList();
        PageInfo<Schedule> pageInfo = new PageInfo<>(scheduleList);
        return new PageBean<>(currentPage, pageSize, pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public R deleteById(int id) {
        int rows = scheduleMapper.deleteById(id);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R add(Schedule schedule) {
        int rows = scheduleMapper.add(schedule);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R updateById(Schedule schedule) {
        if (schedule.getId() == null) {
            return R.fail(null);
        }
        int rows = scheduleMapper.updateById(schedule);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }
}

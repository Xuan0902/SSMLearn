package cn.tsx.mapper;

import cn.tsx.pojo.Teacher;

public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    Teacher queryById(Integer tId);
}

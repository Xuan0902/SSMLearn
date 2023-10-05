package cn.tsx;

import cn.tsx.dao.StudentDao;
import cn.tsx.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;

    /**
     * 查询全部学员业务
     * @return
     */
    @Override
    public List<Student> findAll() {

        return studentDao.queryAll();
    }
}

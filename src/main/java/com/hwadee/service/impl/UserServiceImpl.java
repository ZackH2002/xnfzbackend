package com.hwadee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.common.Constant;
import com.hwadee.entity.Student;
import com.hwadee.entity.Teacher;
import com.hwadee.entity.User;
import com.hwadee.mapper.StudentMapper;
import com.hwadee.mapper.TeacherMapper;
import com.hwadee.mapper.UserMapper;
import com.hwadee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 判断用户名是否存在
     * @param accountName
     * @return
     */
    @Override
    public User getUserByAccountName(String accountName) {
        User user = null;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", accountName);
        user = userMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    public int register(User user, String number) {
        // 插入数据到用户表中
        int insertNumber = userMapper.insert(user);
        if(insertNumber > 0){
            if(user.getType().equals(Constant.USER_STUDENT)){
                // 用户类型为学生，就往学生表中插入数据
                Student student = new Student();
                student.setUserId(user.getUserId());
                student.setStudentNumber(number);
                int insertStudent = studentMapper.insert(student);
                return Math.max(insertStudent, 0);
            }
            else if(user.getType().equals(Constant.USER_TEACHER)) {
                // 用户数据为教师，就往教师表中插入数据
                Teacher teacher = new Teacher();
                teacher.setUserId(user.getUserId());
                teacher.setTeacherNumber(number);
                int insertTeacher = teacherMapper.insert(teacher);
                return Math.max(insertTeacher, 0);
            }
        }
        return Math.max(insertNumber, 0);
    }

    @Override
    public User getUserByLoginInfo(String account, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account).eq("password",password);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }
}

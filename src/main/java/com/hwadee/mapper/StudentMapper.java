package com.hwadee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 *  学生Mapper接口
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}

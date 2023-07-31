package com.hwadee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户接口
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

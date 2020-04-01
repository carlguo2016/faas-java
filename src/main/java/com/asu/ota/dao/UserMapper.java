package com.asu.ota.dao;

import com.asu.ota.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: carl
 * @Date: 2020-01-16 14:03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

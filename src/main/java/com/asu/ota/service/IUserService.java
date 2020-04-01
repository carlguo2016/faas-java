package com.asu.ota.service;

import com.asu.ota.bean.po.UserSavePO;
import com.asu.ota.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * @author carl
 * @Date 2020-04-01 13:02
 */
public interface IUserService extends IService<User> {
    void saveUser(UserSavePO po);

    void deleteUser(Long id);

    HashMap<String, Object> getUserList(String name, int page, int limit);
}
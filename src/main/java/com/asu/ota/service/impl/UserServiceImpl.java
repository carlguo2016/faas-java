package com.asu.ota.service.impl;

import com.asu.ota.bean.po.UserSavePO;
import com.asu.ota.dao.UserMapper;
import com.asu.ota.model.User;
import com.asu.ota.model.enums.UserStatusEnum;
import com.asu.ota.service.IUserService;
import com.asu.tool.util.AssertUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author carl
 * @Date 2020-04-01 13:03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void saveUser(UserSavePO po) {
        Long id = po.getId();
        User user;
        if (id > 0) {
            user = this.baseMapper.selectById(id);
            AssertUtil.isNull("用户不存在", user);
            User userEntity = this.baseMapper.selectOne(new QueryWrapper<User>().ne("id", id));
            AssertUtil.isNotNull("用户已存在", userEntity);

            user.setName(po.getName());
            user.setPhone(po.getPhone());
            user.setSex(po.getSex());
            this.baseMapper.updateById(user);
        } else {
            user = new User();
            user.setName(po.getName());
            user.setPhone(po.getPhone());
            user.setSex(po.getSex());
            user.setStatus(UserStatusEnum.NORMAL);
            this.baseMapper.insert(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = this.baseMapper.selectById(id);
        AssertUtil.isNull("用户不存在", user);

        this.baseMapper.deleteById(id);
    }

    @Override
    public HashMap<String, Object> getUserList(String name, int page, int limit) {
        QueryWrapper<User> query = new QueryWrapper<User>().orderByDesc("id");
        if (null != name && !name.equals("")) {
            query.like("name", name);
        }

        IPage<User> result = this.baseMapper.selectPage(new Page<>(page, limit), query);
        List<User> userList = result.getRecords();

        HashMap<String, Object> hashMap = new HashMap<>(2);
        hashMap.put("total", result.getTotal());
        hashMap.put("list", userList);

        return hashMap;
    }
}
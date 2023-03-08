package com.powernode.crm.settings.service.impl;

import com.powernode.crm.settings.domain.User;
import com.powernode.crm.settings.mapper.UserMapper;
import com.powernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据账号密码查询用户
     * @param map
     * @return
     */
    @Override
    public User queryUserByLoginAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoginActAndPwd(map);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectAllUsers();
    }
}

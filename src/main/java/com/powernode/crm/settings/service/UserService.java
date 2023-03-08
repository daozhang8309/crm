package com.powernode.crm.settings.service;

import com.powernode.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据账号密码查询用户
     * @param map
     * @return
     */
    User queryUserByLoginAndPwd(Map<String,Object> map);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAllUsers();

}

package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {
    /**
     * 获取数据库的信息和前端信息对比
     *
     * @param name      前端传进来的用户名
     * @param password  前端传进来的密码
     * @return          返回一个对象
     */
    User getLogin(String name, String password);

    /**
     *
     * @param user
     * @return
     */
    public Boolean getRegister(User user);
}

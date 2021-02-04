package com.qfedu.dao;

import com.qfedu.entity.User;

public interface UserDao {
    /**
     * 登录功能
     *
     * @param name 用户的用户名
     * @return  返回当前用户的信息
     */
    User login(String name);

    /**
     * 注册功能
     * @param user
     * @return
     */
    public int register(User user);


}

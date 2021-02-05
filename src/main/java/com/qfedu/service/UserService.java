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
    int getRegister(User user);


    /**
     * 根据ID寻找目标User
     * @param id  前端获得的ID
     * @return  返回一个User对象
     */
    User findUserById(int id);

    /**
     * 修改User对象的属性
     * @param user  目标User
     * @return  返回一个boolean值
     */
    int updateUser(User user);
}

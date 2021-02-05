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
     * @param user  注册用户的信息
     * @return      返回注册用户的id
     */
    int register(User user);



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

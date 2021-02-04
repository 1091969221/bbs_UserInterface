package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.lang.reflect.Parameter;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User getLogin(String name, String password) {
        User user = userDao.login(name);

        if (user == null) {
            throw new RuntimeException("账号错误");
        } else if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public int getRegister(User user) {
        int register = 0;
        User getSelectName = userDao.login(user.getName());
        if (getSelectName != null){
            throw new RuntimeException("用户名重复");
        }else{
            register = userDao.register(user);
        }
        return register;

    }

}


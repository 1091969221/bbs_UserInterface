package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(String name) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User login = mapper.login(name);
        session.close();
        return login;
    }
}

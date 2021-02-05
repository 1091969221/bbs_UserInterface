package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;
import com.qfedu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User login(String name) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User login = mapper.login(name);
        session.close();
        return login;
    }

    @Override
    public int register(User user) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        int register = mapper.register(user);
        session.commit();
        session.close();
        return register;
    }



    @Override
    public User findUserById(int id) {
        String sql = "select * from user where userid = ?";
        Object[] obj = {id};
        User user = new User();

        try {
            ResultSet resultSet = this.select(sql,obj);

            while (resultSet.next()){
                user.setUserid(resultSet.getInt("userid"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFamily(resultSet.getString("family"));
                user.setIntro(resultSet.getString("intro"));
                user.setTime(resultSet.getTimestamp("time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set name =?, password = ?, email = ?, family = ?, intro = ? where userid = ?";
        Object[] obj ={user.getName(),user.getPassword(),user.getEmail(),user.getFamily(),user.getIntro(),user.getUserid()};

        return this.setUpdate(sql,obj);
    }
}

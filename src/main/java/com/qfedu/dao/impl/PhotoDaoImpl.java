package com.qfedu.dao.impl;

import com.qfedu.dao.PhotoDao;
import com.qfedu.entity.Picture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoDaoImpl implements PhotoDao {
    //查询头像信息
    @Override
    public ResultSet query(Connection conn, Picture picture) throws SQLException {
        String sql = "select * from picture where userid=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,picture.getUserid());
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
    //添加头像
    @Override
    public void save(Connection conn, Picture picture) throws SQLException {
        String sql="insert into picture(userid,photo) values(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,picture.getUserid());
        preparedStatement.setString(2,picture.getPhoto());
        preparedStatement.execute();
    }
    //修改头像
    @Override
    public void update(Connection conn, Picture picture) throws SQLException {
        String sql="update picture set photo=? where userid=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(2,picture.getUserid());
        preparedStatement.setString(1,picture.getPhoto());
        preparedStatement.execute();
    }

}

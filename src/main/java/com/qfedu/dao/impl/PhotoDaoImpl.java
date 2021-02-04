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
        String sql = "select * from Picture where userid=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,picture.getUserid());
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
}

package com.qfedu.dao;

import com.qfedu.entity.Picture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PhotoDao {
    ResultSet query(Connection conn, Picture picture) throws SQLException;//查询头像
    //插入头像信息
    void save(Connection conn,Picture picture) throws SQLException;
    //修改头像信息
    void update(Connection conn,Picture picture) throws SQLException;
}

package com.qfedu.dao;

import com.qfedu.entity.Picture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PhotoDao {
    public ResultSet query(Connection conn, Picture picture) throws SQLException;//查询头像
}

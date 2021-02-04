package com.qfedu.dao;

import com.qfedu.entity.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PostDao {
    //查询用户信息
    public ResultSet query(Connection conn , Post post) throws SQLException;
    //通过userid查询用户信息
    public ResultSet queryId(Connection conn,Post post) throws SQLException;
    //插入用户信息
    public void save(Connection conn,Post post) throws SQLException;
    //修改用户信息
    public void update(Connection conn,Post post) throws SQLException;
    //删除用户信息
    public void delete(Connection conn,Post post) throws SQLException;
}

package com.qfedu.dao.impl;

import com.qfedu.dao.PostDao;
import com.qfedu.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDaoImpl implements PostDao {
    /**
     * 查询发帖信息
     */
    @Override
    public ResultSet query(Connection conn, Post post) throws SQLException {

        String sql="select * from post order by fid desc";
        PreparedStatement ps=conn.prepareStatement(sql);


        ResultSet rs=ps.executeQuery();

        return rs;
    }

    /**
     * 通过userid查询发帖信息
     */
    @Override
    public ResultSet queryId(Connection conn, Post post) throws SQLException {

        String sql="select * from post where userid=? order by fid desc";
        PreparedStatement ps=conn.prepareStatement(sql);

        ps.setInt(1, post.getUserid());

        ResultSet rs=ps.executeQuery();

        return rs;
    }


    /**
     * 插入发帖信息
     */
    @Override
    public void save(Connection conn, Post post) throws SQLException {

        String sql="insert into post(titles,fcontent,userid,photo,username) values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);

        ps.setString(1, post.getTitles());
        ps.setString(2, post.getFcontent());
        ps.setInt(3, post.getUserid());
        ps.setString(4, post.getPhoto());
        ps.setString(5, post.getUsername());

        ps.execute();
    }

    /**
     * 修改发帖信息
     */
    @Override
    public void update(Connection conn, Post post) throws SQLException {

        String sql="update post set titles=?,fcontent=?,photo=? where fid=?";
        PreparedStatement ps= conn.prepareCall(sql);

        ps.setString(1, post.getTitles());
        ps.setString(2, post.getFcontent());
        ps.setString(3, post.getPhoto());
        ps.setInt(4, post.getFid());

        ps.execute();
    }

    /**
     * 删除发帖信息
     */
    @Override
    public void delete(Connection conn, Post post) throws SQLException {

        String sql="delete from post where fid=?";
        PreparedStatement ps= conn.prepareCall(sql);

        ps.setInt(1, post.getFid());

        ps.execute();
    }
}

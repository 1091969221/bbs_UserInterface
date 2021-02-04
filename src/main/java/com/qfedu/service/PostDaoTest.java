package com.qfedu.service;

import com.qfedu.dao.impl.PostDaoImpl;
import com.qfedu.entity.Post;
import com.qfedu.util.ConnectionFactory;
import sun.net.ConnectionResetException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDaoTest {
    static Connection conn = null;
    /*获得发帖表信息*/
    public static List<Object> PostQuery() {
        List<Object> list = new ArrayList<>();

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            PostDaoImpl postDao = new PostDaoImpl();
            Post post = new Post();
            ResultSet rs = postDao.query(conn, post);
            for (int i = 0; rs.next(); i++) {
                Map<Object, Object> map = new HashMap<>();
                map.put("fid", rs.getInt(1));
                map.put("titles", rs.getString(2));
                map.put("fcontent", rs.getString(3));
                map.put("userid", rs.getInt(4));
                map.put("photo", rs.getString(5));
                map.put("time", rs.getString(6));
                map.put("username", rs.getString(7));
                list.add(i, map);
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return list;
    }
    /*通过userid查询发帖表信息*/
    public static List<Object> QueryId(int userid){
        List<Object> list = new ArrayList<>();

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            PostDaoImpl postDao = new PostDaoImpl();
            Post post = new Post();
            post.setUserid(userid);
            ResultSet rs = postDao.queryId(conn, post);

            for (int i = 0;rs.next() ; i++) {
                /**
                 * 要想向list插入不同HashMap的值  ， 必须要将HashMap new 在for循环内 因为存入list的是HashMap的地址  不是值*/
                Map<Object, Object> map = new HashMap<>();
                map.put("fid",rs.getInt(1));
                map.put("titles",rs.getString(2));
                map.put("fcontent",rs.getString(3));
                map.put("userid",rs.getInt(4));
                map.put("photo",rs.getString(5));
                map.put("time", rs.getString(6));
                map.put("username", rs.getString(7));

                list.add(i,map);
            }
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 像发帖表添加信息
     * */
    public static void save(Post post){
        conn = ConnectionFactory.getInstance().makeConnection();
        try {
            conn.setAutoCommit(false);
            PostDaoImpl postDao = new PostDaoImpl();
            postDao.save(conn,post);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            }finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
    }
    /**
     * 通过fid进行修改发帖表信息
     * */
    public static void update (Post post){

        try {
            ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            PostDaoImpl postDao = new PostDaoImpl();
            postDao.update(conn,post);

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }

        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过fid删除发帖表信息
    * */
    public static void delete(int fid){

        try {
            ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            PostDaoImpl postDao = new PostDaoImpl();

            Post post = new Post();
            post.setFid(fid);
            postDao.delete(conn,post);
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

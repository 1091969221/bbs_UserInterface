package com.qfedu.service.impl;

import com.qfedu.dao.impl.PhotoDaoImpl;
import com.qfedu.entity.Picture;
import com.qfedu.service.PhotoService;
import com.qfedu.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PhotoServiceImpl implements PhotoService {
    static Connection conn = null;
    //查询头像信息
    @Override
    public Map<Object, Object> query(int userid) {
        Map<Object, Object> map=new HashMap<>();
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            PhotoDaoImpl photoDao = new PhotoDaoImpl();
            Picture picture = new Picture();
            picture.setUserid(userid);

            ResultSet resultSet = photoDao.query(conn, picture);
            while (resultSet.next()) {
                map.put("userid",resultSet.getInt("userid"));
                map.put("photo",resultSet.getString("photo"));
                conn.commit();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
    //添加头像
    @Override
    public void save(int userid, String photoname) {

        try {
            Connection conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            PhotoDaoImpl photoDao = new PhotoDaoImpl();
            Picture picture = new Picture();
            picture.setUserid(userid);
            picture.setPhoto(photoname);
            photoDao.save(conn,picture);
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //修改头像
    @Override
    public void update(int userid, String photoname) {
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            PhotoDaoImpl photoDao = new PhotoDaoImpl();
            Picture picture = new Picture();
            picture.setUserid(userid);
            picture.setPhoto(photoname);
            photoDao.update(conn,picture);
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

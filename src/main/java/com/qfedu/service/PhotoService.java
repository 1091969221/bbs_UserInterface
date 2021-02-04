package com.qfedu.service;

import com.qfedu.entity.Picture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface PhotoService {
    Map<Object,Object> query(int userid);//查询头像
    //插入头像信息
    void save(int userid, String photoname);
    //修改头像信息
    void update(int userid, String photoname);
}

package com.qfedu.service;

import com.qfedu.entity.Picture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface PhotoService {
    public  Map<Object,Object> query(int userid);//查询头像
}

package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = req.getServletContext();

        UserService userService = new UserServiceImpl();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        //原密码
        String password = req.getParameter("password");
        //新密码
        String password1 = req.getParameter("password1");
        String email = req.getParameter("email");
        String family = req.getParameter("family");
        String intro = req.getParameter("intro");

        User user1 = userService.findUserById(id);
        //判断用户输入的旧密码是否正确
        if (user1.getPassword().equals(password)){
//          根据获取到的id找到对应的User对象
            User user = userService.findUserById(id);
//          继承新的个人信息
            user.setName(name);
            user.setPassword(password1);
            user.setEmail(email);
            user.setFamily(family);
            user.setIntro(intro);
//          调用方法，修改个人信息
            int i = userService.updateUser(user);

            if (i == 1){
//              修改成功，跳转回个人主页
                resp.sendRedirect(servletContext.getContextPath() + "");
            }else {
                resp.getWriter().append("修改失败");
            }

        }
        //原密码输入错误
        else {
            resp.getWriter().append("原密码错误，请重新输入");
        }

    }
}

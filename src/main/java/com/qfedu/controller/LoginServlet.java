package com.qfedu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("");
        resp.setContentType("");

        String name = req.getParameter("username");
        String password = req.getParameter("password");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            User login = userService.getLogin(name, password);
            req.getSession().setAttribute("login", login);
            JsonResult result = new JsonResult(1, null);
            String s = objectMapper.writeValueAsString(result);
            resp.getWriter().write(s);
        } catch (Exception e) {
            e.printStackTrace();
            JsonResult result = new JsonResult(0, e.getMessage());
            String s = objectMapper.writeValueAsString(result);
            resp.getWriter().write(s);
        }

    }
}

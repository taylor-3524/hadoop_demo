package com.tay.controller;

import com.tay.entity.UserEntity;
import com.tay.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //      System.out.println("执行！");
        String id=req.getParameter("id");       //接收网页的信息
        String pwd=req.getParameter("pwd");

        LoginService loginService=new LoginService();
        if(!loginService.CheckIdNPwd(id,pwd).equals("")){
            /*req.getRequestDispatcher("console").forward(req,resp);*/
  //          System.out.println("执行！！");
            resp.sendRedirect("login_success");
        }
        else {
            req.getRequestDispatcher("login_fail.jsp").forward(req,resp);
        }
        //super.doPost(req, resp);

    }
}

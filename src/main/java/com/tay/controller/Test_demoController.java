package com.tay.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

public class Test_demoController extends HttpServlet {
    public Test_demoController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String pwd=req.getParameter("pwd");
        req.setAttribute("id",id);
        req.setAttribute("pwd",pwd);
        req.getRequestDispatcher("test_demo_2.jsp").forward(req,resp);
    }
}
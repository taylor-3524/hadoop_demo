package com.tay.controller;

import com.google.gson.Gson;
import com.tay.service.RegisterService;
import org.apache.avro.data.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username").toString();
        String fun = request.getParameter("fun").toString();


        String msg = "";
        Map<String, Object> map = new HashMap<>();

        /**
         * 判断操作类型
         * 是检测用户名合法性还是注册
         */
        if(fun.equals("check_username")){
            if (username.equals("admin")) {
                msg = "用户名已存在";
                map.put("code", "001");
                map.put("success", "fail");
                map.put("data", msg);
            } else if(request.getParameter("username")==null||request.getParameter("username").equals("")){
                msg = "";
                map.put("code", "002");
                map.put("success", "fail");
                map.put("data", msg);
            }else {
                msg="用户名可用";
                map.put("code", "001");
                map.put("success", "success");
                map.put("data", msg);
            }
        }else if(fun.equals("register")){
            String pwd = request.getParameter("password").toString();

            RegisterService registerService=new RegisterService();
            registerService.register(username,pwd);
            msg="注册成功";
            map.put("code", "001");
            map.put("success", "success");
            map.put("data", msg);


        }else {     //防御性编程
            msg="error!fun："+fun;
            map.put("code", "003");
            map.put("success", "error");
            map.put("data", msg);
        }

        Gson json = new Gson();
        String json_msg = json.toJson(map);
        response.getWriter().write(json_msg);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}

package com.tay.controller;

import com.tay.entity.FileEntity;
import com.tay.service.ConsoleService;
import com.tay.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.sql.Types.NULL;

public class ConsoleController extends HttpServlet {
   static String  pathForNow="/";      //当前目录
   static String backPath="hdfs://hadoop01:9000/";
   static String open_file_path ="/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginService();
        if (!loginService.users.equals("")) {
            ConsoleService consoleService = new ConsoleService();
            //查询文件列表
            List<FileEntity> list = consoleService.findList(pathForNow);
            req.setAttribute("list", list);
            req.getRequestDispatcher("login_success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("login_fail.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dir_name = req.getParameter("dir_name");       //接收网页的信息
        if (req.getParameter("dir_name") != null && !req.getParameter("dir_name").equals("")) {               //dir_name有值则新建文件
                ConsoleService consoleService = new ConsoleService();
                try {
                    consoleService.make_dir(dir_name,pathForNow);

                    doGet(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        String del_file_path = req.getParameter("del_file_path");
        if (req.getParameter("del_file_path") != null && !req.getParameter("del_file_path").equals("")) {               //del_file_path有值则删除文件
            ConsoleService consoleService = new ConsoleService();
            try {
                consoleService.del(del_file_path);
                doGet(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String download_file_path = req.getParameter("download_file_path");
        if (req.getParameter("download_file_path") != null && !req.getParameter("download_file_path").equals("")) {               //download_file_path有值则下载文件
            ConsoleService consoleService = new ConsoleService();
            try {
                consoleService.download(download_file_path);
                doGet(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        open_file_path=req.getParameter("open_file_path");
        if (req.getParameter("open_file_path") != null && !req.getParameter("open_file_path").equals("")) {               //open_file_path有值则打开文件
            ConsoleService consoleService = new ConsoleService();

            if(consoleService.ifFile(open_file_path)){      //检查是否 文件,是文件返回true
                try {

                    String msg = consoleService.open(open_file_path);
                    System.out.println(open_file_path + "的内容为:" + msg);
                    req.setAttribute("msg", msg);
                    doGet(req, resp);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                pathForNow=open_file_path;
                doGet(req,resp);
            }

        }
/**
 * 上传文件
 */
        String file_path=req.getParameter("file_path");
        if (req.getParameter("file_path")!=null&&!req.getParameter("file_path").equals("")){
            ConsoleService consoleService=new ConsoleService();
            //本地路径用"\"
            try {
                consoleService.upload_file(file_path,pathForNow);
            } catch (Exception e) {
                e.printStackTrace();
            }
            doGet(req, resp);
        }

        /**
         * 返回首页

         */
        String back=req.getParameter("back");
        if (req.getParameter("back")!=null&&!req.getParameter("back").equals("")) {
            if (back.equals("yes")) {
                pathForNow = backPath;
                doGet(req, resp);

            }
        }
        /**
         * 退出登陆
         */
        String logout=req.getParameter("logout");
        if (req.getParameter("logout")!=null&&!req.getParameter("logout").equals("")) {
            if (logout.equals("yes")) {
                LoginService loginService=new LoginService();
                loginService.users="";
                doGet(req, resp);

            }
        }

    }

}

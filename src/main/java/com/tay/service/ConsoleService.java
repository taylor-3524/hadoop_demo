package com.tay.service;

import com.tay.entity.FileEntity;
import com.tay.tools.HadoopTool;

import java.util.List;

public class ConsoleService {

    //获取hadoop文件列表
    public List<FileEntity> findList(String pathForNow) {
        HadoopTool hadoopTool = new HadoopTool();
        LoginService loginService=new LoginService();
        List<FileEntity> list = hadoopTool.getList(pathForNow,loginService.users);
        return list;
    }

    public void make_dir(String dir_name,String pathForNow) throws Exception {        //创建目录
       if(pathForNow.equals("/")){
           pathForNow="";
       }
        dir_name=pathForNow+"/"+dir_name;
        HadoopTool hadoopTool = new HadoopTool();
        LoginService loginService=new LoginService();
        hadoopTool.mkdir(dir_name,loginService.users);
    }
    public void del(String del_path) throws Exception {

        HadoopTool hadoopTool = new HadoopTool();
        LoginService loginService=new LoginService();
        hadoopTool.del(del_path,loginService.users);
    }
    public String open(String path) throws Exception {      //是文件夹就调用list,不是文件夹就打开


        HadoopTool hadoopTool = new HadoopTool();
        LoginService loginService=new LoginService();
        String msg=hadoopTool.open(path,loginService.users);
        return msg;
    }

    public void download(String open_file_path) throws Exception {
        HadoopTool hadoopTool=new HadoopTool();
        LoginService loginService=new LoginService();
        hadoopTool.download(open_file_path,loginService.users);
    }
    public boolean ifFile(String path){
        if(path.contains(".")){
            return true;
        }
        else {
            return false;
        }
    }

    public void upload_file(String file_path,String pathForNow) throws Exception {
        HadoopTool hadoopTool=new HadoopTool();
        LoginService loginService=new LoginService();
        hadoopTool.upload(file_path,pathForNow,loginService.users);
    }
}

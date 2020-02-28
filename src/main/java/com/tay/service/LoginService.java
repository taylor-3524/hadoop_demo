package com.tay.service;

import com.tay.dao.UserDao;
import com.tay.entity.UserEntity;

public class   LoginService {
/*    LoginService(String id,String pwd){
        UserEntity userEntity=new UserEntity();
        if(id==userEntity.getId()&&pwd==userEntity.getPassword()){
            return ture;
        }
    }*/
   public static String users="";
   public static String CheckIdNPwd(String id, String pwd){
       UserDao userDao=new UserDao();
       if(pwd.equals(userDao.find(id))){        //密码正确
           users=id;
           return users;
       }else {
           users="";
           return users;
       }


    }
}

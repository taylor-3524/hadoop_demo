package com.tay.service;

import com.tay.dao.UserDao;
import com.tay.entity.UserEntity;

public class RegisterService {
    public void register(String username,String pwd){
        UserDao userDao=new UserDao();
        userDao.save(username,pwd);
    }

}

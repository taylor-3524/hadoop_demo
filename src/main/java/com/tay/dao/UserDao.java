package com.tay.dao;

import com.tay.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class UserDao {

        //1. 加载Hibernate的核心配置文件
        Configuration configuration = new Configuration().configure();
        //如果在Hibernate的核心配置文件没有设置加载哪个映射文件，则可手动加载映射文件
        //configuration.addResource("com/meimeixia/hibernate/demo01/Customer.hbm.xml");

        //2. 创建SessionFactory对象，类似于JDBC中的连接池
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //3. 通过SessionFactory获取到Session对象，类似于JDBC中的Connection
        Session session = sessionFactory.openSession();

        //4. 手动开启事务，（最好是手动开启事务）
        Transaction transaction = session.beginTransaction();

    public void save(String name,String passwd){     //保存数据

            //5. 编写代码
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(name);
            userEntity.setPassword(passwd);
            session.save(userEntity);//保存一个用户

            //6. 事务提交
            transaction.commit();

            //7. 释放资源
            session.close();
            sessionFactory.close();
        }
        /**
         * 查询用户的密码
         * 返回用户密码
         */

        public String find(String name) {

                String hql = "from UserEntity ";
                //创建HQL查询
                Query query = session.createQuery(hql);
                List list = query.list();
                //对查询的结果进行遍历
                for (int i = 0; i < list.size(); i++) {
                        UserEntity user = (UserEntity) list.get(i);
                        if(name.equals(user.getUsername())){
                                return user.getPassword();
                        }

                }

                session.close();
                return "no-password";
        }
}

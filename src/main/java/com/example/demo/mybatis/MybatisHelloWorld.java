package com.example.demo.mybatis;

import java.io.IOException;
import java.io.Reader;

import com.example.demo.mybatis.mapper.UserMapper;
import com.example.demo.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-16
 */
public class MybatisHelloWorld {
    public static void main(String[] args) {
        String resource = "Configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlSessionFactory.openSession();
            try {
                User user = (User) session.selectOne("com.example.demo.mybatis.mapper.UserMapper.getUser", 1);
                System.out.println(user.getId() + "," + user.getName());
                UserMapper mapper = session.getMapper(UserMapper.class);
                UserMapper mapper1= session.getMapper(UserMapper.class);
                User user1 = mapper.getUser(1);
                System.out.println(user1.getId() + "," + user1.getName());
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
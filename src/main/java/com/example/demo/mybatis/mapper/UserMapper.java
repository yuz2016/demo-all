package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.model.User;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-16
 */
public interface UserMapper {
    User getUser(int id);
}

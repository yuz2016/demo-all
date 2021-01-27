package com.example.beforeall.mybatis.mapper;

import com.example.beforeall.mybatis.model.User;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-16
 */
public interface UserMapper {
    User getUser(int id);
}

package com.example.beforeall.springcache.service;

import com.example.beforeall.springcache.model.UserEntity;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-30
 */
public interface UserService {

    /**
     * 查找所有
     * @return
     */
    List<UserEntity> getAll();
    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UserEntity getOne(Long id);
    /**
     * 新增用户
     * @param user
     */
    UserEntity insertUser(UserEntity user);
    /**
     * 修改用户
     * @param user
     */
    UserEntity updateUser(UserEntity user);

    void deleteAll1(Long id);

    void deleteAll12();

    UserEntity getByName(String name);
}


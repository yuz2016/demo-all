package com.example.beforeall.springcache.mapper;

import com.example.beforeall.springcache.model.UserEntity;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-16
 */
public interface UserMapper {
    /**
     * 获取所有用户
     * @return
     */
    List<UserEntity> getAll();
    /**
     * 根据id获取用户
     * @return
     */
    UserEntity getOne(Long id);
    UserEntity getUserByName(String name);
    /**
     * 新增用户
     * @param user
     */
    void insertUser(UserEntity user);
    /**
     * 修改用户
     * @param user
     */
    void updateUser(UserEntity user);
    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);
}

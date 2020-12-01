package com.example.demo.springcache.service;

import com.example.demo.springcache.mapper.UserMapper;
import com.example.demo.springcache.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-30
 */
@Service
@CacheConfig(cacheNames = {"userCache"})
public class UserServiceImpl implements UserService {

    @Resource
    private CacheManager cacheManager;

    @Autowired
    private UserMapper userDao;

    @Override
    @Cacheable("userCache")     // 标志读取缓存操作，如果缓存不存在，则调用目标方法，并将结果放入缓存
    public List<UserEntity> getAll() {
        System.out.println("缓存不存在，执行方法");
        return userDao.getAll();
    }

    @Override
    @Cacheable(cacheNames = { "userCache" }, key = "#id")   //如果缓存存在，直接读取缓存值；如果缓存不存在，则调用目标方法，并将结果放入缓存
    public UserEntity getOne(Long id) {
        System.out.println("缓存不存在，执行方法");
        return userDao.getOne(id);
    }

    @Override
    @CachePut(cacheNames = { "userCache" }, key = "#user.id")   //写入缓存，key为user.id,一般该注解标注在新增方法上
    public UserEntity insertUser(UserEntity user) {
        System.out.println("写入缓存");
        userDao.insertUser(user);
        return user;
    }

    @Override
    @CacheEvict(cacheNames = { "userCache" }, key = "#user.id") //根据key清除缓存，一般该注解标注在修改和删除方法上
    public UserEntity updateUser(UserEntity user) {
        System.out.println("清除缓存");
        userDao.updateUser(user);
        Objects.requireNonNull(cacheManager.getCache("nameCache")).clear();
        return user;
    }

    @Override
    @CacheEvict(value="userCache", key = "#id")  //方法调用后清空所有缓存
    public void deleteAll1(Long id) {
        System.out.println("清除缓存");
        Objects.requireNonNull(cacheManager.getCache("nameCache")).clear();
    }

    @Override
    @CacheEvict(value="userCache",beforeInvocation=true)    //方法调用前清空所有缓存
    public void deleteAll12() {
        System.out.println("清除缓存");
    }

    @Cacheable(cacheNames = { "nameCache" }, key = "#name")
    @Override
    public UserEntity getByName(String name) {
        System.out.println("缓存不存在，执行方法");
        return userDao.getUserByName(name);
    }

}

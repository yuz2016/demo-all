package com.example.beforeall.springcache.controller;

import com.example.beforeall.springcache.model.UserEntity;
import com.example.beforeall.springcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  查找所有
     * @return
     */
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(){
        return userService.getAll();
    }
    /**
     * 根据id获取用户
     * @return
     */
    @RequestMapping("/getOne")
    public UserEntity getOne(Long id){
        return userService.getOne(id);
    }
    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser(@RequestBody UserEntity user) {
        userService.insertUser(user);
        return "insert success";
    }
    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody UserEntity user) {
        userService.updateUser(user);
        return "update success";
    }

    @RequestMapping("/deleteUsers")
    public String deleteUsers(Long id) {
        userService.deleteAll1(id);
        return "delete success";
    }

    @RequestMapping("/getByName")
    public UserEntity getByName(String name) {
        return userService.getByName(name);
    }
}

package com.example.beforeall.mybatis.model;

import lombok.Data;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-16
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}

package com.example.beforeall.springcache.model;

import lombok.Data;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-16
 */
@Data
public class UserEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

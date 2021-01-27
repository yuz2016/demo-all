package com.example.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-12-29
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/demo")
    public String demo() {
        return "示例返回";
    }

}

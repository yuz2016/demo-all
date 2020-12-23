package com.example.demo.testAll.NestedConfigurationProperty;

import lombok.Data;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-12-23
 */
@Data
public class Duck {

    public Duck() {
        System.out.println(1);
    }

    int num;
    String color;

}

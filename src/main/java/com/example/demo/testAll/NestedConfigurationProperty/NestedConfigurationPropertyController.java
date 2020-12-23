package com.example.demo.testAll.NestedConfigurationProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/NestedConfigurationProperty")
public class NestedConfigurationPropertyController {

    @Autowired
    private ServerProperties serverProperties;

    /**
     *  查找所有
     * @return
     */
    @RequestMapping("/getAll")
    public int getAll(){
        return serverProperties.getPorts();
    }

}

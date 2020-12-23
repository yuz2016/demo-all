package com.example.demo.testAll.NestedConfigurationProperty;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-12-23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "serverss")
public class ServerProperties {
    int ports;
    @NestedConfigurationProperty
    private Duck duck = new Duck();
    @NestedConfigurationProperty
    private Duck duck2;
}

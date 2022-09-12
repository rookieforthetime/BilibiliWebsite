package com.website.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component // 受Spring控制
@ConfigurationProperties(prefix = "property")
public class MyPCLocation {
    private String des;
    private String[] path;
}

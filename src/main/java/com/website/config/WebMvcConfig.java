package com.website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /*
     * 当代码中有许多相同的文件路径地址时，反复写路径不仅繁琐且不易于修改，因此在参数设置中自行添加变量
     * video-path = D:\\Java\\video\\
     * img-path = D:\\Java\\img\\
     * 加入的变量通过注解 @Value("${参数中设置的变量名}") 进行使用，如下可见
     * 则定义的变量代表了设置的文件路径，易于统一管理, 在哪个类中使用就在那个类中加入字段
     */
    /*
    @Value("${video_path}")
    private String videoPath;
    @Value("${img_path}")
    private String imgPath;*/
    @Autowired
    MyPCLocation myPCLocation;

    /**
     * 静态资源(如图片、视频)映射:
     * 由addResourceHandlers()方法映射URL路径和磁盘路径
     * http://localhost:8080/play/xxx  ->  static/play/**(文件放在static里面时, **代表全部文件)
     * http://localhost:8080/play/xxx  ->  file:D:/aaa/(文件未放在static里面时)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler()告诉程序URL路径    addResourceLocations()告诉程序磁盘路径
        registry.addResourceHandler("/play/**").addResourceLocations("file:" + myPCLocation.getPath()[0]);
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + myPCLocation.getPath()[1]);
    }
}

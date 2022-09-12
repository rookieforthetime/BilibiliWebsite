package com.website.controller;

import com.website.config.MyPCLocation;
import com.website.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@RestController
public class UploadController {
    @Autowired
    MyPCLocation myPCLocation;
    /*
    @Value("${video_path}")
    private String videoPath;
    @Value("${img_path}")
    private String imgPath;
    */

    // 处理上传分块
    @RequestMapping(value = "/upload")
    public Map<String, String> uploadPart(Part part) throws IOException {
        System.out.println(String.format("%.2f", part.getI() * 100.0 / part.getChunks()) + "%" + "\t" + part.getUrl());
        // transferTo(Path)可以将视频分块成一系列二进制文件
        part.getData().transferTo(Path.of(myPCLocation.getPath()[0], part.getUrl() + ".part" + part.getI()));
        // String.format("%.nf", double data)  将浮点型数据data以小数点后n为进行转换并以字符串形式输出
        return Map.of(part.getUrl(), String.format("%.2f", part.getI() * 100.0 / part.getChunks()) + "%");
    }

    // 合并分块操作
    @RequestMapping(value = "/finish")
    public void mergeChunks(Part part) throws IOException {
        // FileOutputStream 文件输出流： 创建新文件并写入内容
        try (FileOutputStream os = new FileOutputStream(myPCLocation.getPath()[0] + part.getUrl())) {
            for (int i = 1; i <= part.getChunks(); i++) {
                Path path = Path.of(myPCLocation.getPath()[0], part.getUrl() + ".part" + i);
                // Files.copy(原始文件，目标文件) 合并视频文件
                Files.copy(path, os);
                // 删除Path文件
                path.toFile().delete();
            }
        }
    }

    // 上传视频封面
    @RequestMapping("/uploadCover")
    public Map<String, String> uploadCover(Part p) throws IOException {
        p.getData().transferTo(Path.of(myPCLocation.getPath()[1], p.getCover()));
        return Map.of("cover", p.getCover());
    }
}

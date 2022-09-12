package com.website.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * i: 第几块，从1开始
 * chunks: 总块数
 * data: data分块数据，是二进制数据，用MultipartFile类型表示
 * url: 视频文件名
 * cover: 视频封面
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part implements Serializable {

    private int i;

    private int chunks;

    private MultipartFile data;

    private String url;

    private String cover;

}

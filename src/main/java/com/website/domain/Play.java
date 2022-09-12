package com.website.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Play implements Serializable {
    /**
     * id: 视频集号
     * title: 视频标题
     * duration: 视频时长
     * url: 视频文件的路径
     */
    private String id;
    private String title;
    private LocalTime duration;
    private String url;
    private String bv;
    private Integer deleted;
    @Version
    private Integer version;
}

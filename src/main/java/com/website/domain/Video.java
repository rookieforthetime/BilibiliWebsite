package com.website.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @TableName("video") // 将该实体类与不同名的数据库中的表进行匹配，可以在全局配置中进行设置！
public class Video implements Serializable {
    /**
     * bv : 视频编号
     * title: 视频标题
     * publishTime: 发布时间
     * cover: 视频中的封面，代指图片所对应的编号
     * introduction: 视频简介
     * tagList: 标签
     * playList: 页面中包含多个Play
     * type: 视频类型，自制/转载
     * category: 视频分区
     */
    // @TableField(select = false)  设置该字段是否参与查询, 与select()映射配置并不冲突
    private String bv;
    private String title;
    @TableField(value = "publish_time")
    private LocalDateTime publishTime;
    private String cover;
    private String introduction;
    private String tags;
    /*
     * @TableId(type = IdType.?) id生成策略 可以在全局配置中进行设置！
     * AUTO 是数据库默认的生成策略
     * NONE 是没有策略
     * INPUT 是用户自己输入id，若没有设置id则无法插入
     * ASSIGN_ID 是雪花算法生成的id， 雪花算法生成一个64位的二进制，是Long值，可兼容数值型与字符串型
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String type;
    private String category;
    @TableField(exist = false)
    private List<String> tagList;
    @TableField(exist = false)
    private List<Play> playList;
    /*
     * 逻辑删除字段，标记当前记录是否被删除, 之后的删除操作就变成了修改操作
     * 查询数据也没有影响，不会再出现那条数据了，若想查被删除的数据，就写sql查询，即设置条件deleted = 1 来查询
     * 可以在全局配置中添加
     */
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
    /*
     * 乐观锁，防止并发事务出错
     * 锁从1开始，是逐渐往上累加的
     * 通过拦截器，在update的时候将version的值加1
     * 若要操作乐观锁，必须要在修改的时候先添加上version的初值
     */
    @Version
    private Integer version;

    public void setTagList() {
        if (tags == null) {
            tagList = List.of();
        } else {
            tagList = Arrays.asList(tags.split("_"));
        }
    }
}

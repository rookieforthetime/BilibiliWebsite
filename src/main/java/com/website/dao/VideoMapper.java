package com.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMapper extends BaseMapper<Video> {
  /*
  // 根据bv号查询视频
    @Select("""
            select bv, type, category, title, cover, introduction, publish_time, tags
            from video where bv = #{bv};
            """)
    *//*
     * publish_time与Video中的publishTime 字段名不一致，导致了无法传输数据,可以进行转换
     * 在application.properties中进行转换:  mybatis.configuration.map-underscore-to-camel-case=true
     *//*
    *//*
     * Video中的tagList是一个集合，而数据库中的tags其实就是一个字符串，无法直接进行对应，解决方法如下：
     * 在Video类中先构造一个String类型的字段tags, 接收来自数据库中对应字段的数据，然后再写方法进行转换
     *//*
    Video selectVideoByBv(String bv);

    @Insert("""
            Insert Into video(type, category, title, cover, introduction, publish_time, tags)
            VALUES (#{type}, #{category}, #{title}, #{cover}, #{introduction}, #{publishTime}, #{tags})
            """)
    void inserts(Video video);

    @Select("Select last_insert_id()") // 获取最新生成的自增主键值
    int lastInsertId();

    @Update("""
            Update video Set bv = #{bv} where id = #{id};
            """)
    void updateBv(@Param("bv") String bv, @Param("id") int id);
    */
}

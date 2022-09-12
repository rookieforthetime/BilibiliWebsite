package com.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayMapper extends BaseMapper<Play> {
 /*   @Select("""
            select id, title, url, duration
            from play where bv = #{bv};
            """)
    List<Play> selectPlayByBv(String bv);

    @Insert("""
            INSERT INTO play(id, title, url, duration, bv)
            VALUES (#{p.id}, #{p.title}, #{p.url}, #{p.duration}, #{bv})
            """)
    void insertPlay(@Param("p") Play play, @Param("bv") String bv);*/
}

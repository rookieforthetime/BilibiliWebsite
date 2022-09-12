package com.website;

import com.website.dao.VideoMapper;
import com.website.domain.Video;
import com.website.service.impl.GetBvService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TestVideoMapper {
/*
    @Autowired
    VideoMapper videoMapper;

    @Test
    public void selectById() {
        Video video = videoMapper.selectVideoByBv("1");
        System.out.println("bv: " + video.getBv() + "\ttype: " + video.getType() + "\tcategory: " +
                video.getCategory() + "\ttitle: " + video.getTitle() + "\tcover: " + video.getCover() +
                "\tintroduction: " + video.getIntroduction() + "\tpublish_time: " + video.getPublishTime()
                + "\ttagList: " + video.getTagList());
    }

    @Test
    public void insert(){
        Video v = new Video();
        v.setType("转发");
        v.setCategory("动漫");
        v.setTitle("海贼王");
        v.setCover("1.png");
        v.setIntroduction("简介....");
        v.setPublishTime(LocalDateTime.now());
        v.setTags("日本_热血_动漫");
        videoMapper.insert(v);
        int id = videoMapper.lastInsertId();
        System.out.println(id);
        String bv = GetBvService.get(id);
        videoMapper.updateBv(bv, id);
    }*/
}

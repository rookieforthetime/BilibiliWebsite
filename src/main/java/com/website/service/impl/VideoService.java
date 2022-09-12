package com.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.website.dao.PlayMapper;
import com.website.dao.VideoMapper;
import com.website.domain.Play;
import com.website.domain.Video;
import com.website.service.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class VideoService implements Service {
    public VideoService() {
    }

    @Autowired
    VideoMapper videoMapper;
    @Autowired
    PlayMapper playMapper;

    /**
     * 功能1： 根据bv号查找视频
     * 1. 判断bv号对应视频是否存在
     * 2. 根据bv号找到对应的视频
     * 3. 根据bv号找到所有的视频选集
     */
    @Override
    public Video findBv(String bv) {
        LambdaQueryWrapper<Video> lq = new LambdaQueryWrapper<>();
        lq.eq(null != bv, Video::getBv, bv);
//        Video v = videoMapper.selectVideoByBv(bv);
        Video vi = videoMapper.selectOne(lq);
        if (vi == null) {
            return null;
        } else {
            vi.setTagList();
            vi.setPlayList(findPlay(bv));
            return vi;
        }
    }

    @Override
    public List<Play> findPlay(String bv) {
        LambdaQueryWrapper<Play> lq = new LambdaQueryWrapper<>();
        lq.eq(null != bv, Play::getBv, bv);
        return playMapper.selectList(lq);
    }

    /*
     * 功能2： 发布视频
     * 1. 向Video表插入视频
     * 2. 生成bv号
     * 3. 更新bv号
     * 4. 向play表插入所有视频选集
     */

    public String publishVideo(Video video) {
        video.setPublishTime(LocalDateTime.now()); // 发布时间应该是当前时间
        videoMapper.insert(video);  // 1. 向Video表插入视频
        // 使用insert()插入的数据若没有设置id初值，会根据数据库中的id进行设置并返回给对象
        Integer last_id = video.getId();
        /*
        lq.eq(Video::getPublishTime, video.getPublishTime());
        lq.eq(Video::getBv, video.getBv());
        Video video1 = videoMapper.selectOne(lq);
        */
        String bv = GetBvService.get(last_id); // 2. 生成bv号
        video.setBv(bv);
        videoMapper.updateById(video); // 3. 更新bv号

        // 4. 向play表插入所有视频选集
        for (Play play : video.getPlayList()) {
            play.setBv(bv);
            playMapper.insert(play);
        }
        return bv;
    }
}

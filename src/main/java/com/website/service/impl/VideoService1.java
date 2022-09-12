/*
package com.website.service.impl;

import com.website.domain.Play;
import com.website.domain.Video;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class VideoService1 implements com.website.service.Service {
    // 只会被调用一次
    public VideoService1() {
    }

    */
/**
     * Map 便于查询
     * 1 -> Video 1
     * 2 -> Video 2
     * 3 -> Video 3
     *//*

    Map<String, Video> m = new HashMap<>(); // 成员变量可以在多个非静态方法之间应用

    @PostConstruct
    public void init() {  // 这是一个初始化方法，在对象创建之后只会被调用一次, 只能返回void
        // 使用初始化方法，直接将所有七个视频内容全部获取到了，不需要再写在findBv里了
        try {
            List<String> list = Files.readAllLines(Path.of("D:\\Java\\JavaProject\\BilibiliWebsite\\src\\main\\resources\\static\\data", "p.csv"));
            for (String s : list) {
                String[] s1 = s.split(",");
                m.put(s1[0], new Video(s1[0], s1[3], LocalDateTime.parse(s1[6]), s1[4], s1[5],
                        Arrays.asList(s1[7].split("_")), findPlay(s1[0]), s1[1], s1[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 会被调用多次
    @Override
    public Video findBv(String bv) {
        return m.get(bv);
    }

    @Override
    public List<Play> findPlay(String bv) {
        try {
            List<String> strings = Files.readAllLines(Path.of("D:\\Java\\JavaProject\\BilibiliWebsite\\src\\main\\resources\\static\\data", "v_" + bv + ".csv"));
            List<Play> p = new ArrayList<>(strings.size());
            for (String s : strings) {
                String[] split = s.split(",");
                p.add(new Play(split[0], split[1], LocalTime.parse(split[3]), split[2]));
            }
            return p;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
*/

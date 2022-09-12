package com.website.controller;

import com.website.domain.Video;
import com.website.service.impl.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 若有过多的请求，单独每个写返回会很麻烦，因此引入变化的路径参数
 * 变化的路径参数,改动如下
 * 1. @RequestMapping("/video/{bv}")
 * 2. 方法名(@PathVariable String bv), @PathVariable表示改方法参数要从路径中获得
 */
@RestController
public class VideoController {
    /*
    @Autowired
    private VideoService1 videoService1; // 构造方法只会被调用一次，而下面的returnVideo()和findBv()方法则会被调用许多次

    @RequestMapping("/video/{bv}")
    @ResponseBody
    public Video returnVideo(@PathVariable String bv){
        return videoService1.findBv(bv);
    }*/
    @Autowired
    private VideoService videoService; // 构造方法只会被调用一次，而下面的returnVideo()和findBv()方法则会被调用许多次

    @RequestMapping("/video/{bv}")
    public Video returnVideo(@PathVariable String bv){
        return videoService.findBv(bv);
    }
   /* @RequestMapping("/video/1")
    @ResponseBody
    public Video t1(){
        List<Play> plays1 = List.of(
                new Play("p1", "二分查找-演示", LocalTime.parse("00:05:46"), "1_1.mp4"),
                new Play("p2", "二分查找-实现", LocalTime.parse("00:06:47"), "1_2.mp4")
        );
        return new Video("1", "面试专题-基础篇", LocalDateTime.now(), "1.png", "祝你面试成功！",
                List.of("面试","Java","计算机技术"), plays1,"自制", "科技 -> 计算机技术");
    }
    @RequestMapping("/video/2")
    @ResponseBody
    public Video t2(){
        List<Play> plays2 = List.of(
                new Play("p1", "线程状态-Java中的线程状态", LocalTime.parse("00:09:45"), "2_1.mp4"),
                new Play("p2", "线程状态-Java中的线程状态-代码演示1", LocalTime.parse("00:07:05"), "2_2.mp4"),
                new Play("p3", "线程状态-Java中的线程状态-代码演示2", LocalTime.parse("00:05:01"), "2_3.mp4")
        );
        return new Video("2", "面试专题-并发篇", LocalDateTime.now(), "2.png", "祝你面试成功！",
                List.of("面试","Java","计算机技术"), plays2,"自制", "科技 -> 计算机技术");
    }*/

  // 发布视频
  @RequestMapping("/publish")
  // @ResponseBody就是把java对象转换成json格式，@RequestBody是把json格式转换成java对象
  public Map<String, String> publishVideo(@RequestBody Video video){
    return Map.of("bv", videoService.publishVideo(video));
  }
}

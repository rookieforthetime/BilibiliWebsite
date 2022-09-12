package com.website;

import com.website.dao.PlayMapper;
import com.website.domain.Play;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
public class TestPlayMapper {
/*
    @Autowired
    PlayMapper playMapper;

    @Test
    public void selectByBv() {
        List<Play> play = playMapper.selectPlayByBv("1");
        for (Play p : play) {
            System.out.println("id: " + p.getId() + "\ttitle: " + p.getTitle() + "\turl: " + p.getUrl()
                    + "\tduration: " + p.getDuration());
        }
    }

    @Test
    public void insertPlay(){
        Play p1 = new Play("P1", "选集1", LocalTime.parse("00:21:10"), "1.mp4");
        Play p2 = new Play("P2", "选集2", LocalTime.parse("00:18:22"), "2.mp4");
        playMapper.insertPlay(p1, "bv4GmR4x");
        playMapper.insertPlay(p2, "bv4GmR4w");
    }*/
}
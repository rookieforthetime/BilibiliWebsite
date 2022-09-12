package com.website.service;


import com.website.domain.Play;
import com.website.domain.Video;

import java.util.List;

public interface Service {
    Video findBv(String bv);
    List<Play> findPlay(String bv);
}

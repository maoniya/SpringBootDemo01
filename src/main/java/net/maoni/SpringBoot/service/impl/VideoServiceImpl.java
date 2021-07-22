package net.maoni.SpringBoot.service.impl;

import net.maoni.SpringBoot.domain.Video;
import net.maoni.SpringBoot.mapper.VideoMapper;
import net.maoni.SpringBoot.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}

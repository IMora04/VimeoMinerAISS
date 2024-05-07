package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.video.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VideoServiceTests {

    @Autowired
    @Qualifier("videoService")
    VideoService videoService;

    @Test
    void getVideos() {
        for(Video v:videoService.getVideos()) {
            System.out.println(v.getName());
        }
    }

    @Test
    void getVideosChannel(){
        for(Video v:videoService.getVideosOfChannel(1904324)){
            System.out.println(v.getName());
        }
    }

}

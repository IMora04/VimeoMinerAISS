package aiss.vimeominer.service;

import aiss.vimeominer.model.video.Video;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class VideoServiceTest {

    @Autowired
    VideoService service;

    @Test
    @DisplayName("Get videos")
    void getVideos(){
        List<Video> videos = service.getVideos();
        assertFalse(videos.isEmpty(), "The list of users is empty!");
        System.out.println(videos);
    }

}

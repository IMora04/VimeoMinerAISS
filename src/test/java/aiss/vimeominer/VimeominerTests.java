package aiss.vimeominer;

import aiss.vimeominer.model.video.Video;
import aiss.vimeominer.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VimeominerTests {

    @Autowired
    @Qualifier("videoService")
    VideoService videoService;

    @Test
    void getVideos() {
        for(Video v:videoService.getVideos()) {
            System.out.println(v.getUri());
        }
    }

}

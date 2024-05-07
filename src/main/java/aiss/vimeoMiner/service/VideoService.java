package aiss.vimeoMiner.service;


import aiss.vimeoMiner.model.video.Video;
import aiss.vimeoMiner.model.video.VideoSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("videoService")
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    public List<Video>  getVideos(){
        String uri = "https://api.vimeo.com/videos?direction=asc&filter=trending";
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + "5394a30ebd1c27d98804ed901a30358a");

        HttpEntity<VideoSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<VideoSearch> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, VideoSearch.class);

        return response.getBody().getData();
    }

    public List<Video> getVideosOfChannel(String channelId){
        return getVideosOfChannel(channelId,10);
    }

    public List<Video> getVideosOfChannel(String channelId, Integer numVideos){
        String uri = "https://api.vimeo.com/channels/" + channelId +"/videos?per_page="+numVideos;
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization","Bearer " + "5394a30ebd1c27d98804ed901a30358a");

        HttpEntity<VideoSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<VideoSearch> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, VideoSearch.class);

        return response.getBody().getData();

    }
}

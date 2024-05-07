package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.comment.Comment;
import aiss.vimeoMiner.model.comment.CommentSearch;
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

@Service("commentService")
public class CommentService {
    @Autowired
    RestTemplate restTemplate;
    public List<Comment> getComments(String videoId, Integer numComments) {
        String uri = "https://api.vimeo.com/videos/" + videoId + "/comments?per_page=" + numComments;
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + "5394a30ebd1c27d98804ed901a30358a");

        HttpEntity<CommentSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<CommentSearch> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, CommentSearch.class);

        return response.getBody().getData();

    }
    public List<Comment> getComments(String videoId){
        return getComments(videoId, 10);
    }

}

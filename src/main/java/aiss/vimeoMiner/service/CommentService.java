package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.comment.Comment;
import aiss.vimeoMiner.model.comment.CommentSearch;
import aiss.vimeoMiner.model.video.Video;
import aiss.vimeoMiner.model.video.VideoSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("commentService")
public class CommentService {

    @Value("vimeominer.token")
    private String token;

    @Autowired
    RestTemplate restTemplate;

    public List<Comment> getComments(String videoId, Integer numComments) {
        String uri = "https://api.vimeo.com/videos/" + videoId + "/comments?per_page=" + numComments;
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + token);

        HttpEntity<CommentSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<CommentSearch> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, CommentSearch.class);

        return response.getBody().getData();

    }
    public List<Comment> getComments(String videoId){
        return getComments(videoId, 10);
    }

}

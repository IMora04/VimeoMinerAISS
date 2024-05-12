package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.Caption;
import aiss.vimeoMiner.model.captions.CaptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("captionService")
public class CaptionService {

    @Value("vimeominer.token")
    private String token;

    @Autowired
    RestTemplate restTemplate;

    public List<Caption> getCaptions(String videoId){
        String uri = "https://api.vimeo.com/videos/" + videoId + "/texttracks";
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + token);

        HttpEntity<CaptionSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<CaptionSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionSearch.class);

        return response.getBody().getData();
    }


}
